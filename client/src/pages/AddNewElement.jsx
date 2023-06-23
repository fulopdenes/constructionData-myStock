import React from 'react';
import {Card} from "@mui/material"

import NewProductForm from "../components/form/NewProductForm";

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
                gap: 0,
                borderRadius: "15px"
            }} elevation={10}>
                <NewProductForm
                />

            </Card>
        </>
    )
}

export default AddNewElement;