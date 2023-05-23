import * as React from 'react';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import Box from "@mui/material/Box";
import {Card} from "@mui/material";
import {useEffect, useState} from "react";
import CircularIndeterminateLoading from "./Loading/CircularIndeterminateLoading";
import BasicProductCard from "./BasicProductCard";

const fetchProducts = (signal) => {
    return fetch(`/api/products/all`, {signal}).then((res) => res.json());
};

export default function SearchBarAndValueHandler() {
    const [selectAt, setSelectAt] = React.useState('');
    const [resultIsHided, setResultIsHided] = useState(true);
    const [filteredData, setFilteredData] = useState('');
    const [valueResult, setValueResult] = useState('');


    const [data, setData] = useState(null);
    const [isLoading, setIsLoading] = useState(true);

    const onSubmit = (e) => {
        e.preventDefault();

        const formData = new FormData(e.target);
        const entries = [...formData.entries()];

        const employee = entries.reduce((acc, entry) => {
            const [k, v] = entry;
            acc[k] = v;
            return acc;
        }, {});

        setFilteredData(data.filter((product) => product[employee.search].toString() === employee.value));
        setResultIsHided(false);
    };


    useEffect(() => {
        const controller = new AbortController();

        fetchProducts(controller.signal)
            .then((products) => {
                setIsLoading(false);
                setData(products);
            })
            .catch((error) => {
                if (error.name !== "AbortError") {
                    setData(null);
                    throw error;
                }
            });

        return () => controller.abort();
    }, []);

    if (isLoading) {
        return <CircularIndeterminateLoading/>;
    }

    const handleChange = (event) => {
        setSelectAt(event.target.value);
    };

    const handleClear = () => {
        setSelectAt('');
        setResultIsHided(true);
        setValueResult('');
    }

    return (
        <>
            <Card
                sx={{
                    display: "flex",
                    flexWrap: "wrap",
                    alignItems: "center",
                    maxWidth: "550px",
                    padding: "25px",
                    justifyContent: "space-evenly",
                    p: 3,
                    py: 5,
                    // maxWidth: "600px",
                    margin: "10px auto",
                    gap: 4,
                    borderRadius: "15px"
            }}
                component="form"
                onSubmit={onSubmit}
                elevation={10}
            >
                <FormControl fullWidth>
                    <Box sx={{ minWidth: 120 }}>
                        <FormControl fullWidth>
                            <InputLabel id="demo-simple-select-label">Search At</InputLabel>
                            <Select
                                labelId="demo-simple-select-label"
                                name="search"
                                id="search"
                                value={selectAt}
                                label="Search"
                                onChange={handleChange}
                                required
                            >
                                <MenuItem value="relatedUnit">Related Unit</MenuItem>
                                <MenuItem value="roomNameOfInstallation">Room Name</MenuItem>
                                <MenuItem value="category">Category</MenuItem>
                                <MenuItem value="productName">Product Name</MenuItem>
                                <MenuItem value="productTechCode">Product Tech. Code</MenuItem>
                                <MenuItem value="quantity">Quantity</MenuItem>
                                <MenuItem value="quantityType">Quantity Type</MenuItem>
                                {/*<MenuItem value="deliveryNoteID">Delivery Note ID</MenuItem>*/}
                                {/*<MenuItem value="deliveryType">Delivery Type</MenuItem>*/}
                                {/*<MenuItem value="roomPlanCode">Room ID</MenuItem>*/}
                            </Select>
                        </FormControl>
                        <FormControl sx={{m: 0, minWidth: 100}}>
                            <TextField
                                name="value"
                                id="value"
                                label="Value"
                                variant="outlined"
                                required
                                value={valueResult} // Bind value to component state
                                onChange={(e) => setValueResult(e.target.value)} // Update state on change
                            />
                        </FormControl>
                    </Box>
                </FormControl>
                <div>
                    <Button
                        sx={{ marginRight: "1rem" }}
                        variant="contained"
                        type="submit"
                    >
                        Search
                    </Button>

                    <Button variant="contained" color="warning" onClick={handleClear}>
                        Clear
                    </Button>
                </div>
            </Card>
            <Box sx={{
                display: "flex",
                alignItems: "center",
                justifyContent: "space-evenly",
                flexWrap: "wrap"
            }}>
                {!resultIsHided ? filteredData.length ? filteredData.map((product) => {
                        return (
                            <div key={product.id}>
                                <BasicProductCard
                                    data={product}
                                />
                            </div>
                        )
                    })
                    : "No result!" : "Please select column and value!"}
            </Box>
        </>

    );
};