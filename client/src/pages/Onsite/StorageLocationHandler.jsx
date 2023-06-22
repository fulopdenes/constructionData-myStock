import {Card} from "@mui/material";
import React from "react";
import FormControl from "@mui/material/FormControl";
import TextField from "@mui/material/TextField";

const StorageLocationHandler = () => {
    return (
        <>
            <Card sx={{
                p: 3,
                py: 5,
                maxWidth: "550px",
                margin: "15px auto",
                display: "flex",
                flexDirection: "column",
                gap: 0,
                borderRadius: "15px"
            }} elevation={10}>
                <FormControl fullWidth>
                    <TextField
                        name="placeOfStorage"
                        id="placeOfStorage"
                        label="Arrived product will be stored at"
                        variant="outlined"
                        required
                    />
                </FormControl>
            </Card>
        </>
    )
}

export default StorageLocationHandler;