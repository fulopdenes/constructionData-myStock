import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import FormControl from "@mui/material/FormControl";
import Button from "@mui/material/Button";
import React, {useState} from "react";
import SaveIcon from "@mui/icons-material/Save";
import {useNavigate} from "react-router-dom";
import LoadingButton from '@mui/lab/LoadingButton';
import {Alert, Snackbar} from "@mui/material";

const createProduct = (product) => {
    return fetch(`${process.env.REACT_APP_API_URL}/products/new`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(product),
    }).then((res) => res.json());
};

const NewProductForm = () => {
    const navigate = useNavigate();
    const [buttonDisabled, setButtonDisabled] = useState(false);

    const [buildingId, setBuildingId] = useState("");
    const [productName, setProductName] = useState("");
    const [categoryType, setCategoryType] = useState("");
    const [productTechCode, setProductTechCode] = useState("");
    const [quantity, setQuantity] = useState("");
    const [quantityType, setQuantityType] = useState("");
    const [relatedUnit, setRelatedUnit] = useState("");
    const [roomNameOfInstallation, setRoomNameOfInstallation] = useState("");

    const [snackbar, setSnackbar] = React.useState(null);
    const handleCloseSnackbar = () => setSnackbar(null);


    const handleCreateEmployee = (product) => {
        createProduct(product)
            .then(() => {
                setButtonDisabled(false);
                setSnackbar({children: 'New product parameters are saved', severity: 'success'});

            })
            .catch((err) => {
                throw err;
            });
    };

    const onSubmit = (e) => {
        e.preventDefault();
        const formData = new FormData(e.target);
        const entries = [...formData.entries()];
        setButtonDisabled(true);

        const newProduct = entries.reduce((acc, entry) => {
            const [k, v] = entry;
            acc[k] = v;
            return acc;
        }, {});

        setBuildingId("");
        setProductName("");
        setCategoryType("");
        setProductTechCode("");
        setQuantity("");
        setQuantityType("");
        setRelatedUnit("");
        setRoomNameOfInstallation("");

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
                    name="buildingId"
                    id="buildingId"
                    label="Building Id"
                    variant="outlined"
                    value={buildingId}
                    onChange={(e) => setBuildingId(e.target.value)}
                    required
                />
            </FormControl>

            <FormControl fullWidth>
                <TextField
                    name="relatedUnit"
                    id="relatedUnit"
                    label="Related Unit"
                    variant="outlined"
                    value={relatedUnit}
                    onChange={(e) => setRelatedUnit(e.target.value)}
                    required
                />
            </FormControl>

            <FormControl fullWidth>
                <TextField
                    name="productName"
                    id="productName"
                    label="Product Name"
                    variant="outlined"
                    value={productName}
                    onChange={(e) => setProductName(e.target.value)}
                    required
                />
            </FormControl>

            <FormControl fullWidth>
                <TextField
                    name="categoryType"
                    id="categoryType"
                    label="Category"
                    variant="outlined"
                    value={categoryType}
                    onChange={(e) => setCategoryType(e.target.value)}
                    required
                />
            </FormControl>

            <FormControl fullWidth>
                <TextField
                    name="productTechCode"
                    id="productTechCode"
                    label="TechCode"
                    variant="outlined"
                    value={productTechCode}
                    onChange={(e) => setProductTechCode(e.target.value)}
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
                    value={quantity}
                    onChange={(e) => setQuantity(e.target.value)}
                    required
                />
            </FormControl>

            <FormControl fullWidth>
                <TextField
                    name="quantityType"
                    id="quantityType"
                    label="Quantity Type"
                    variant="outlined"
                    value={quantityType}
                    onChange={(e) => setQuantityType(e.target.value)}
                    required
                />
            </FormControl>



            <FormControl fullWidth>
                <TextField
                    name="roomNameOfInstallation"
                    id="roomNameOfInstallation"
                    label="Room Name"
                    variant="outlined"
                    value={roomNameOfInstallation}
                    onChange={(e) => setRoomNameOfInstallation(e.target.value)}
                    required
                />
            </FormControl>
            <div>
                <LoadingButton
                    sx={{ marginRight: "1rem" }}
                    variant="contained"
                    type="submit"
                    loadingPosition="start"
                    disabled={buttonDisabled}
                    startIcon={<SaveIcon />}
                >
                    <span>Add New Product</span>
                </LoadingButton>

                <Button variant="contained" color="warning" onClick={() => navigate(-1)} >
                    Cancel
                </Button>
                {!!snackbar && (
                    <Snackbar
                        open
                        anchorOrigin={{vertical: 'bottom', horizontal: 'center'}}
                        onClose={handleCloseSnackbar}
                        autoHideDuration={3000}
                    >
                        <Alert {...snackbar} onClose={handleCloseSnackbar}/>
                    </Snackbar>
                )}
            </div>
        </Box>
    );
};

export default NewProductForm;