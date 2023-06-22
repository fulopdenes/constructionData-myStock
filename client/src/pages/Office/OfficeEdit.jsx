import React, {useEffect, useState} from 'react';
import {Box, SpeedDial, SpeedDialIcon, Typography} from "@mui/material";
import SpeedDialAction from "@mui/material/SpeedDialAction";
import {styled} from "@mui/material/styles";
import DocumentScannerIcon from '@mui/icons-material/DocumentScanner';
import AddCircleOutlineRoundedIcon from '@mui/icons-material/AddCircleOutlineRounded';
import CircularIndeterminateLoading from "../../components/loading/CircularIndeterminateLoading";
import {Link} from "react-router-dom";
import NavigateBeforeIcon from '@mui/icons-material/NavigateBefore';
import EditableDataCrudGrid from "../../components/grid/EditableDataCrudGrid";

const StyledSpeedDial = styled(SpeedDial)(({theme}) => ({
    position: 'absolute',
    '&.MuiSpeedDial-directionUp, &.MuiSpeedDial-directionLeft': {
        bottom: theme.spacing(2),
        right: theme.spacing(2),
    },
    '&.MuiSpeedDial-directionDown, &.MuiSpeedDial-directionRight': {
        top: theme.spacing(2),
        left: theme.spacing(2),
    },
    "& svg": {
        display: "block"
    },
}));

const withLink = (to, children) => <Link to={to}>{children}</Link>;

const actions = [
    {icon: withLink("/office", <NavigateBeforeIcon sx={{color: "#000"}}/>), name: 'View Mode'},
    {icon: withLink("/new", <AddCircleOutlineRoundedIcon color="primary"/>), name: 'Add New Product'},
    {icon: <DocumentScannerIcon color="disabled"/>, name: 'Scan document'}
];

const fetchProducts = (signal) => {
    return fetch(`${process.env.REACT_APP_API_URL}/api/products/all`, {signal}).then((res) => res.json());
};

const OfficeEdit = () => {
    let [isLoading, setIsLoading] = useState(true);
    const [data, setData] = useState(null);

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
    return (
        <>
            <Typography variant={"h8"} component={"div"} sx={{m: 0, p: 1, fontWeight: "bold"}}>
                EDIT MODE
            </Typography>
            <EditableDataCrudGrid products={data} setData={setData}/>
            <Box sx={{position: 'relative', mt: 0, height: 80}}>
                <StyledSpeedDial
                    ariaLabel="SpeedDial playground example"
                    icon={<SpeedDialIcon/>}
                    direction="right"
                >
                    {actions.map((action) => (
                        <SpeedDialAction
                            key={action.name}
                            icon={action.icon}
                            tooltipTitle={action.name}
                        />
                    ))}
                </StyledSpeedDial>
            </Box>

        </>
    )
}

export default OfficeEdit;