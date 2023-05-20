import React, {useState} from 'react';
import {Button, Card, FormControl, FormHelperText, Input, InputLabel, TextField} from "@mui/material"
import {useNavigate} from "react-router-dom";
import SaveIcon from "@mui/icons-material/Save";
import LoadingButton from '@mui/lab/LoadingButton';

const AddNewElement = () => {
    const [loading, setLoading] = React.useState(false);

    const handleClick = async () => {
        setLoading(true);
        const res = await fetch(`http://localhost:8080/products/new`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(product)
        })
        const data = await res.json()
        if (res.ok) {
            setLoading(false);
        } else {
            console.log(data);
        }
    }

    const [product, setProduct] = useState({
        category:"",
        productTechCode:"",
        quantity: "",
        quantityType: "",
        relatedUnit: "",
        roomNameOfInstallation: "",
        productName: ""
    });
    const navigate = useNavigate();

    const handleChange = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        setProduct ({...product, [name]: value});
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
                New Product Details:
                <TextField id="outlined-basic" label="Name" variant="outlined" type={"text"} name={"productName"} onChange={handleChange} value={product.productName} required={true} />
                <TextField id="outlined-basic" label="Category" variant="outlined" type={"text"} name={"category"} onChange={handleChange} value={product.category} required={true} />
                <TextField id="outlined-basic" label="TechCode" variant="outlined" type={"text"} name={"productTechCode"} onChange={handleChange} value={product.productTechCode} required={true}/>
                <TextField id="outlined-basic" label="Quantity" variant="outlined" type={"number"} name={"quantity"} onChange={handleChange} value={product.quantity} required={true}/>
                <TextField id="outlined-basic" label="Quantity Type" variant="outlined" type={"text"} name={"quantityType"} onChange={handleChange} value={product.quantityType} required={true}/>
                <TextField id="outlined-basic" label="Related Unit" variant="outlined" type={"text"} name={"relatedUnit"} onChange={handleChange} value={product.relatedUnit} required={true}/>
                <TextField id="outlined-basic" label="Room Name" variant="outlined" type={"text"} name={"roomNameOfInstallation"} onChange={handleChange} value={product.roomNameOfInstallation} required={true}/>
                {/*<Button variant={"contained"} onClick={handleSubmit}>Add New Product</Button>*/}
                {/*<Button variant="contained" onClick={handleSubmit} endIcon={<SendIcon />}>*/}
                {/*    Add New Product*/}
                {/*</Button>*/}
                <FormControl>
                    <InputLabel htmlFor="my-input">Email address</InputLabel>
                    <Input id="my-input" aria-describedby="my-helper-text" />
                    <FormHelperText id="my-helper-text">We'll never share your email.</FormHelperText>
                </FormControl>

                <LoadingButton
                    // color="primary"
                    onClick={handleClick}
                    loading={loading}
                    loadingPosition="start"
                    startIcon={<SaveIcon />}
                    variant="contained"
                >
                    <span>Add New Product</span>
                </LoadingButton>
                <Button variant={"outlined"} color="error" onClick={() => navigate(-1)} >Back</Button>
            </Card>
            {/*<FileUploader/>*/}
        </>
    )
}

export default AddNewElement;