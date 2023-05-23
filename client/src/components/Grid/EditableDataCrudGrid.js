import * as React from 'react';
import {DataGrid, GridToolbar} from '@mui/x-data-grid';
import {useState} from "react";
import {Alert, Snackbar} from "@mui/material";
import {GridActionsCellItem, GridRowModes} from "@mui/x-data-grid-pro";
import SaveIcon from "@mui/icons-material/Save";
import CancelIcon from "@mui/icons-material/Close";
import EditIcon from "@mui/icons-material/Edit";
import DeleteIcon from "@mui/icons-material/DeleteOutlined";

const useFakeMutation = () => {
    return React.useCallback(
        (product) =>
            new Promise((resolve, reject) => {
                setTimeout(() => {
                    if (product.relatedUnit === '') {
                        reject(new Error("Error while saving product: Related Unit can't be empty."));
                    } else {
                        resolve({...product, relatedUnit: product.relatedUnit});
                    }
                }, 200);
            }),
        [],
    );
};

const deleteProduct = (id) => {
    return fetch(`/api/products/delete/${id}`, {
        method: 'DELETE'
    }).then(() => {
        // console.log('removed');
    }).catch(err => {
        console.error(err)
    });
};

const EditableDataCrudGrid = ({products}) => {
    const [tableData] = useState(products);

    // Map the data to rows
    const initialRowsFromTable = tableData.map((item) => ({
        id: item.id,
        relatedUnit: item.relatedUnit,
        roomNameOfInstallation: item.roomNameOfInstallation,
        category: item.category,
        productName: item.productName,
        productTechCode: item.productTechCode,
        quantity: item.quantity,
        quantityType: item.quantityType,
        deliveryNoteID: item.deliveryNoteID,
        deliveryType: item.deliveryType,
        timeOfRecord: item.timeOfRecord,
        timeOfOrder: item.timeOfOrder,
        timeOfArrivedAtSite: item.timeOfArrivedAtSite,
        placeOfStorage: item.placeOfStorage,
        timeOfInstalled: item.timeOfInstalled,
        roomPlanCode: item.roomPlanCode,
        lastTimeOfModified: item.lastTimeOfModified
    }));

    const [rows, setRows] = React.useState(initialRowsFromTable);
    const isEditable = true;
    const [rowModesModel, setRowModesModel] = React.useState({});

    const handleRowEditStart = (params, event) => {
        event.defaultMuiPrevented = true;
    };

    const handleRowEditStop = (params, event) => {
        event.defaultMuiPrevented = true;
    };

    const handleEditClick = (id) => () => {
        setRowModesModel({...rowModesModel, [id]: {mode: GridRowModes.Edit}});
    };

    const handleSaveClick = (id) => () => {
        setRowModesModel({...rowModesModel, [id]: {mode: GridRowModes.View}});
    };

    const handleDeleteClick = (id) => () => {
        deleteProduct(id)
            .then(() => {
                // navigate("/employees");
            })
            .catch((err) => {
                throw err;
            })
            .finally(() => {
                // setLoading(false);
            });
        setRows(rows.filter((row) => row.id !== id));
    };

    const handleCancelClick = (id) => () => {
        setRowModesModel({
            ...rowModesModel,
            [id]: {mode: GridRowModes.View, ignoreModifications: true},
        });

        // const editedRow = rows.find((row) => row.id === id);
        // if (editedRow.isNew) {
        //     setRows(rows.filter((row) => row.id !== id));
        // }
    };

    const handleRowModesModelChange = (newRowModesModel) => {
        setRowModesModel(newRowModesModel);
    };

    // Define the columns
    const columns = [
        {
            field: 'action',
            type: 'actions',
            headerName: 'Modify',
            width: 80,
            cellClassName: 'action',
            getActions: ({id}) => {
                const isInEditMode = rowModesModel[id]?.mode === GridRowModes.Edit;

                if (isInEditMode) {
                    return [
                        <GridActionsCellItem
                            icon={<SaveIcon/>}
                            label="Save"
                            onClick={handleSaveClick(id)}
                        />,
                        <GridActionsCellItem
                            icon={<CancelIcon/>}
                            label="Cancel"
                            className="textPrimary"
                            onClick={handleCancelClick(id)}
                            color="inherit"
                        />,
                    ];
                }

                return [
                    <GridActionsCellItem
                        icon={<EditIcon/>}
                        label="Edit"
                        className="textPrimary"
                        onClick={handleEditClick(id)}
                        color="inherit"
                    />,
                    <GridActionsCellItem
                        icon={<DeleteIcon/>}
                        label="Delete"
                        onClick={handleDeleteClick(id)}
                        color="inherit"
                    />,
                ];
            },
        },
        {field: 'relatedUnit', headerName: 'Related Unit', width: 100, hide: true, editable: isEditable},
        {field: 'roomNameOfInstallation', headerName: 'Room Name', width: 150, editable: isEditable, hide: 'true'},
        {field: 'category', headerName: 'Category', width: 150, editable: isEditable},
        {field: 'productName', headerName: 'Product Name', width: 150, editable: isEditable},
        {field: 'productTechCode', headerName: 'Tech. Code', width: 150, editable: isEditable},
        {field: 'quantity', headerName: 'Quantity', width: 100, editable: isEditable},
        {field: 'quantityType', headerName: 'Quantity Type', width: 100, editable: isEditable},
        {field: 'deliveryNoteID', headerName: 'DeliveryNote ID', width: 150, editable: isEditable},
        {field: 'deliveryType', headerName: 'Delivery Tye', width: 150, editable: isEditable},
        {field: 'timeOfRecord', headerName: 'Time of Record', width: 230, editable: isEditable},
        {field: 'timeOfOrder', headerName: 'Ordered at', width: 230, editable: isEditable},
        {field: 'timeOfArrivedAtSite', headerName: 'Arrived at', width: 230, editable: isEditable},
        {field: 'placeOfStorage', headerName: 'Store at', width: 150, editable: isEditable},
        {field: 'timeOfInstalled', headerName: 'Installed', width: 150, editable: isEditable},
        {field: 'roomPlanCode', headerName: 'Room ID', width: 150, editable: isEditable},
        {field: 'lastTimeOfModified', headerName: 'Modified at', width: 230, editable: isEditable},
    ];

    const mutateRow = useFakeMutation();

    const [snackbar, setSnackbar] = React.useState(null);

    const handleCloseSnackbar = () => setSnackbar(null);

    const processRowUpdate = React.useCallback(
        async (newRow) => {
            // Make the HTTP request to save in the backend
            const updatedProduct = await mutateRow(newRow);
            const res = await fetch(`/api/products/update/${updatedProduct.id}`, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(newRow)
            })
            const response = await res.json();
            setSnackbar({children: 'Modification successfully saved', severity: 'success'});
            return response;
        },
        [mutateRow],
    );

    const handleProcessRowUpdateError = React.useCallback((error) => {
        setSnackbar({children: error.message, severity: 'error'});
    }, []);

    return (
        <div style={{height: 450, width: '100%'}}>
            <DataGrid
                columns={columns}
                rows={rows}
                slots={{toolbar: GridToolbar}}
                onProcessRowUpdateError={handleProcessRowUpdateError}
                editMode="row"
                rowModesModel={rowModesModel}
                onRowModesModelChange={handleRowModesModelChange}
                onRowEditStart={handleRowEditStart}
                onRowEditStop={handleRowEditStop}
                processRowUpdate={processRowUpdate}
            />
            {!!snackbar && (
                <Snackbar
                    open
                    anchorOrigin={{vertical: 'bottom', horizontal: 'center'}}
                    onClose={handleCloseSnackbar}
                    autoHideDuration={6000}
                >
                    <Alert {...snackbar} onClose={handleCloseSnackbar}/>
                </Snackbar>
            )}
        </div>
    );
}

export default EditableDataCrudGrid;