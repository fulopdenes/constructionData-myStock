import React, {useEffect, useState} from 'react';
import {Box, SpeedDial, SpeedDialIcon, Typography} from "@mui/material";
import ViewDataGrid from "../../components/grid/ViewDataGrid";
import SpeedDialAction from "@mui/material/SpeedDialAction";
import {styled} from "@mui/material/styles";
import DocumentScannerIcon from '@mui/icons-material/DocumentScanner';
import AddCircleOutlineRoundedIcon from '@mui/icons-material/AddCircleOutlineRounded';
import EditIcon from '@mui/icons-material/Edit';
import CircularIndeterminateLoading from "../../components/loading/CircularIndeterminateLoading";
import {Link} from "react-router-dom";

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
    {icon: withLink("/edit", <EditIcon sx={{color: "#000"}}/>), name: 'Edit Mode'},
    // { icon: withLink("/delete", <DeleteIcon sx={{ color: red[500] }} />), name: 'Delete Element'},
    {icon: withLink("/new", <AddCircleOutlineRoundedIcon color="primary"/>), name: 'Add new element'},
    {icon: <DocumentScannerIcon color="disabled"/>, name: 'Scan document'}
];

const fetchProducts = (signal) => {
    return fetch(`${process.env.REACT_APP_API_URL}/api/products/all`, {signal}).then((res) => res.json());
};

const Office = () => {
    const [isLoading, setIsLoading] = useState(true);
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
        return (
            <>
                <CircularIndeterminateLoading/>
            </>
            )
    }
    return (
        <>
            <Typography variant={"h8"} component={"div"} sx={{m: 0, p: 1, fontWeight: "bold"}}>
                VIEW MODE
            </Typography>
            <ViewDataGrid products={data}/>
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

export default Office;