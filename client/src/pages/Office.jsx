import React from 'react';
import {Box, SpeedDial, SpeedDialIcon} from "@mui/material";
import ExportDefaultToolbar from "../components/Grid/ExportDefaultToolbar";
import SpeedDialAction from "@mui/material/SpeedDialAction";
import {styled} from "@mui/material/styles";
import DocumentScannerIcon from '@mui/icons-material/DocumentScanner';
import AddCircleOutlineRoundedIcon from '@mui/icons-material/AddCircleOutlineRounded';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';

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
}));

const actions = [
    { icon: <EditIcon />, name: 'Edit Table' },
    { icon: <DeleteIcon />, name: 'Delete Element' },
    { icon: <AddCircleOutlineRoundedIcon />, name: 'Add new element' },
    { icon: <DocumentScannerIcon />, name: 'Scan document' },
];

const Home = () => {
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

                <ExportDefaultToolbar/>
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

export default Home;