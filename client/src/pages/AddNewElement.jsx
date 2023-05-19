import React from 'react';
import {Button, Card, CardContent, TextField, Typography} from "@mui/material"
import ExportDefaultToolbar from "../components/Grid/ExportDefaultToolbar";
import {FileUploader} from "../components/FileUploader/FileUploader";

const AddNewElement = () => {
    return (
        <>
            <Card sx={{
                p: 3,
                py: 5,
                maxWidth: "550px",
                margin: "50px auto",
                display: "flex",
                flexDirection: "column",
                gap: 4,
                borderRadius: "15px"
            }} elevation={10}>
                <Button variant={"contained"} color="primary">Add new Element</Button>
            </Card>
            <FileUploader/>
        </>
    )
}

export default AddNewElement;