import * as React from 'react';
import { useDemoData } from '@mui/x-data-grid-generator';
import {DataGrid, GridToolbar} from '@mui/x-data-grid';

export default function ExportDefaultToolbar() {
    const { data, loading } = useDemoData({
        dataSet: 'Commodity',
        rowLength: 4,
        maxColumns: 10,
        editable: true
    });

    return (
        <div style={{ height: 450, width: '100%' }}>
            <DataGrid
                {...data}
                loading={loading}
                slots={{ toolbar: GridToolbar }}
            />
        </div>
    );
}