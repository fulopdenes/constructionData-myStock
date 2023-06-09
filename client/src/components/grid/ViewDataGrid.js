import * as React from 'react';
import {DataGrid, GridToolbar} from '@mui/x-data-grid';
import {useState} from "react";

const ViewDataGrid = ({products}) => {
    const [tableData] = useState(products);

    // Map the data to rows
    const rows = tableData.map((item) => ({
        id: item.id,
        buildingId: item.buildingId,
        relatedUnit: item.relatedUnit,
        roomNameOfInstallation: item.roomNameOfInstallation,
        categoryType: item.categoryType,
        productName: item.productName,
        productTechCode: item.productTechCode,
        quantity: item.quantity,
        quantityType: item.quantityType,
        deliveryNoteId: item.deliveryNoteId,
        deliveryType: item.deliveryType,
        timeOfRecord: item.timeOfRecord,
        timeOfOrder: item.timeOfOrder,
        timeOfArrivedAtSite: item.timeOfArrivedAtSite,
        placeOfStorage: item.placeOfStorage,
        timeOfInstalled: item.timeOfInstalled,
        roomPlanCode: item.roomPlanCode,
        lastTimeOfModified: item.lastTimeOfModified
    }));

    // Define the columns
    const columns = [
        {field: 'buildingId', headerName: 'Building', width: 50},
        {field: 'relatedUnit', headerName: 'Unit', width: 50},
        {field: 'roomNameOfInstallation', headerName: 'Room Name', width: 100},
        {field: 'categoryType', headerName: 'Category', width: 150},
        {field: 'productName', headerName: 'Product Name', width: 150},
        {field: 'productTechCode', headerName: 'Tech. Code', width: 150},
        {field: 'quantity', headerName: 'Quantity', width: 100},
        {field: 'quantityType', headerName: 'Quantity Type', width: 100},
        {field: 'deliveryNoteId', headerName: 'DeliveryNote Id', width: 150},
        {field: 'deliveryType', headerName: 'Delivery Tye', width: 150},
        {field: 'timeOfRecord', headerName: 'Time of Record', width: 230},
        {field: 'timeOfOrder', headerName: 'Ordered at', width: 230},
        {field: 'timeOfArrivedAtSite', headerName: 'Arrived at', width: 230},
        {field: 'placeOfStorage', headerName: 'Store at', width: 150},
        {field: 'timeOfInstalled', headerName: 'Installed', width: 150},
        {field: 'roomPlanCode', headerName: 'Room ID', width: 150},
        {field: 'lastTimeOfModified', headerName: 'Modified at', width: 230},
    ];

    return (
        <div style={{height: 500, width: '100%'}}>
            <DataGrid
                columns={columns}
                rows={rows}
                density="compact"
                slots={{toolbar: GridToolbar}}
            />
        </div>
    );
}
export default ViewDataGrid;