import React, {useEffect, useState} from 'react';
import {Box, SpeedDial, SpeedDialIcon} from "@mui/material";
import ExportDefaultToolbar from "../components/Grid/ExportDefaultToolbar";
import SpeedDialAction from "@mui/material/SpeedDialAction";
import {styled} from "@mui/material/styles";
import DocumentScannerIcon from '@mui/icons-material/DocumentScanner';
import AddCircleOutlineRoundedIcon from '@mui/icons-material/AddCircleOutlineRounded';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import CircularIndeterminateLoading from "../components/CircularIndeterminateLoading";
import {red} from "@mui/material/colors";
import {Link} from "react-router-dom";


const StyledSpeedDial = styled(SpeedDial)(({ theme }) => ({
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
    { icon: withLink("/", <EditIcon sx={{ color: "#000" }} />), name: 'Edit Table'},
    { icon: withLink("/delete", <DeleteIcon sx={{ color: red[500] }} />), name: 'Delete Element'},
    { icon: withLink("/new", <AddCircleOutlineRoundedIcon color="primary"/>), name: 'Add new element' },
    { icon: <DocumentScannerIcon color="disabled"/>, name: 'Scan document' }
];

const fetchProducts = (signal) => {
    return fetch(`http://localhost:8080/products/all`, { signal }).then((res) => res.json());
};

const Office = () => {
    const [loading, setLoading] = useState(true);
    const [data, setData] = useState(null);

    useEffect(() => {
        const controller = new AbortController();

        fetchProducts(controller.signal)
            .then((products) => {
                setLoading(false);
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

    if (loading) {
        return <CircularIndeterminateLoading />;
    }
    return (
        <>
        {/*    <Card sx={{*/}
        {/*    p: 2,*/}
        {/*    py: 2,*/}
        {/*    // maxWidth: "550px",*/}
        {/*    // margin: "2px auto",*/}
        {/*    display: "flex",*/}
        {/*    flexDirection: "column",*/}
        {/*    // gap: 0,*/}
        {/*    borderRadius: "15px"*/}
        {/*}} elevation={10}>*/}
                <ExportDefaultToolbar products={data}/>
                {/*<Button variant={"contained"}><SpeedDial ariaLabel={"SpeedDial basic example"}></SpeedDial></Button>*/}
                {/*<SpeedDial*/}
                {/*    ariaLabel="SpeedDial basic example"*/}
                {/*    icon={<SpeedDialIcon />}></SpeedDial>*/}
                {/*<PlaygroundSpeedDial/>*/}
                <Box sx={{ position: 'relative', mt: 0, height: 80 }}>

                    <StyledSpeedDial
                        ariaLabel="SpeedDial playground example"
                        // hidden={hidden}
                        icon={<SpeedDialIcon />}
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

                {/*    <SpeedDial*/}
                {/*        ariaLabel="Save Feedback"*/}
                {/*        icon={<SpeedDialIcon icon={<EditIcon />} openIcon={<EditIcon />} />}*/}
                {/*        onClick={() => fabAction()}*/}
                {/*        FabProps={{*/}
                {/*          onClick: () => fabAction()*/}
                {/*        }}*/}
                {/*    open={true}*/}
                {/*    direction="left">*/}
                {/*    <SpeedDialAction*/}
                {/*        icon={<EditIcon />}*/}
                {/*        tooltipTitle="Add Point"*/}
                {/*        onClick={() => fabActionAdd()} />*/}
                {/*</SpeedDial>*/}
                </Box>
                {/*<SpeedDialAction*/}
                {/*    key={action.name}*/}
                {/*    icon={action.icon}*/}
                {/*    tooltipTitle={action.name}*/}
                {/*/>*/}
        {/*</Card>*/}
        </>
    )
}

export default Office;