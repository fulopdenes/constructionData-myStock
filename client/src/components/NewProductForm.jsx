import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import FormControl from "@mui/material/FormControl";
import Button from "@mui/material/Button";
import React from "react";
import SaveIcon from "@mui/icons-material/Save";
import {useNavigate} from "react-router-dom";
import LoadingButton from '@mui/lab/LoadingButton';

const createProduct = (product) => {
    return fetch(`${process.env.API_URL}/api/products/new`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(product),
    }).then((res) => res.json());
};

const NewProductForm = () => {
    const navigate = useNavigate();

    const handleCreateEmployee = (product) => {
        createProduct(product)
            .then(() => {
                navigate("/");
            })
            .catch((err) => {
                throw err;
            });
    };

    const onSubmit = (e) => {
        e.preventDefault();
        const formData = new FormData(e.target);
        const entries = [...formData.entries()];

        const newProduct = entries.reduce((acc, entry) => {
            const [k, v] = entry;
            acc[k] = v;
            return acc;
        }, {});

        return handleCreateEmployee(newProduct);
    };

    return (
        <Box
            sx={{
                display: "flex",
                gap: "1rem",
                flexWrap: "wrap",
            }}
            component="form"
            onSubmit={onSubmit}
        >

            <FormControl>
                New Product Details:
            </FormControl>

            <FormControl fullWidth>
                <TextField
                    name="productName"
                    id="productName"
                    label="Product Name"
                    variant="outlined"
                    required
                />
            </FormControl>

            <FormControl fullWidth>
                <TextField
                    name="category"
                    id="category"
                    label="Category"
                    variant="outlined"
                    required
                />
            </FormControl>

            <FormControl fullWidth>
                <TextField
                    name="productTechCode"
                    id="productTechCode"
                    label="TechCode"
                    variant="outlined"
                    required
                />
            </FormControl>

            <FormControl fullWidth>
                <TextField
                    name="quantity"
                    id="quantity"
                    label="Quantity"
                    type="number"
                    variant="outlined"
                    required
                />
            </FormControl>

            <FormControl fullWidth>
                <TextField
                    name="quantityType"
                    id="quantityType"
                    label="Quantity Type"
                    variant="outlined"
                    required
                />
            </FormControl>

            <FormControl fullWidth>
                <TextField
                    name="relatedUnit"
                    id="relatedUnit"
                    label="Related Unit"
                    variant="outlined"
                    required
                />
            </FormControl>

            <FormControl fullWidth>
                <TextField
                    name="roomNameOfInstallation"
                    id="roomNameOfInstallation"
                    label="Room Name"
                    variant="outlined"
                    required
                />
            </FormControl>
            <div>
                <LoadingButton
                    sx={{ marginRight: "1rem" }}
                    variant="contained"
                    type="submit"
                    loadingPosition="start"
                    startIcon={<SaveIcon />}
                >
                    <span>Add New Product</span>
                </LoadingButton>

                <Button variant="contained" color="warning" onClick={() => navigate(-1)} >
                    Cancel
                </Button>
            </div>
        </Box>
    );
};

export default NewProductForm;