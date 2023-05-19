import React, {useState} from 'react';
import {Button, Card, CardContent, TextField, Typography} from "@mui/material"
import ExportDefaultToolbar from "../components/Grid/ExportDefaultToolbar";
import {FileUploader} from "../components/FileUploader/FileUploader";

const AddNewElement = () => {
    const [product, setProduct] = useState({
        name:"",
        category:"",
        techCode:"",
        quantity: "",
        quantityType: "",
        relatedUnit: "",
        roomName: ""
    });

    const handleChange = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        setProduct ({...product, [name]: value});
    }

    const handleSubmit = () => {
        console.log(product)
    }

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
                <TextField id="outlined-basic" label="Name" variant="outlined" type={"text"} name={"name"} onChange={handleChange} value={product.name} required={true} />
                <TextField id="outlined-basic" label="Category" variant="outlined" type={"text"} name={"category"} onChange={handleChange} value={product.category} required={true} />
                <TextField id="outlined-basic" label="TechCode" variant="outlined" type={"text"} name={"techCode"}onChange={handleChange} value={product.techCode} required={true}/>
                <TextField id="outlined-basic" label="Quantity" variant="outlined" type={"number"} name={"quantity"}onChange={handleChange} value={product.quantity} required={true}/>
                <TextField id="outlined-basic" label="Quantity Type" variant="outlined" type={"text"} name={"quantityType"}onChange={handleChange} value={product.quantityType} required={true}/>
                <TextField id="outlined-basic" label="Related Unit" variant="outlined" type={"text"} name={"relatedUnit"}onChange={handleChange} value={product.relatedUnit} required={true}/>
                <TextField id="outlined-basic" label="Room Name" variant="outlined" type={"text"} name={"roomName"}onChange={handleChange} value={product.roomName} required={true}/>
                <Button variant={"contained"} onClick={handleSubmit}>Add New Product</Button>
            </Card>
            {/*<FileUploader/>*/}
        </>
    )
}

export default AddNewElement;