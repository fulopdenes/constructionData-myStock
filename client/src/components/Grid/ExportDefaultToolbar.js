import * as React from 'react';
import {DataGrid, GridToolbar} from '@mui/x-data-grid';
import {useState} from "react";


const ExportDefaultToolbar = ({ products }) => {
    const [tableData, setTableData] = useState(products);

// Define the columns
    const columns = [
        { field: 'relatedUnit', headerName: 'Related Unit', width: 100 },
        { field: 'roomNameOfInstallation', headerName: 'Room Name', width: 150 },
        { field: 'category', headerName: 'Category', width: 150 },
        { field: 'productName', headerName: 'Product Name', width: 150 },
        { field: 'productTechCode', headerName: 'Tech. Code', width: 150 },
        { field: 'quantity', headerName: 'Quantity', width: 100 },
        { field: 'quantityType', headerName: 'Quantity Type', width: 100 },
        { field: 'deliveryNoteID', headerName: 'DeliveryNote ID', width: 150 },
        { field: 'deliveryType', headerName: 'Delivery Tye', width: 150 },
        { field: 'timeOfRecord', headerName: 'Time of Record', width: 230 },
        { field: 'timeOfOrder', headerName: 'Ordered at', width: 230 },
        { field: 'timeOfArrivedAtSite', headerName: 'Arrived at', width: 230 },
        { field: 'placeOfStorage', headerName: 'Store at', width: 150 },
        { field: 'timeOfInstalled', headerName: 'Installed', width: 150 },
        { field: 'roomPlanCode', headerName: 'Room ID', width: 150 },
        { field: 'lastTimeOfModified', headerName: 'Modified at', width: 230 }
    ];

// Map the data to rows
    const rows = tableData.map((item) => ({
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

    return (
        <div style={{ height: 450, width: '100%' }}>
            <DataGrid
                columns={columns}
                rows={rows}
                slots={{ toolbar: GridToolbar }}
            />
        </div>
    );
}

export default ExportDefaultToolbar;