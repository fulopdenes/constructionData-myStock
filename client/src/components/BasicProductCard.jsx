import * as React from 'react';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';

const BasicProductCard = ({data}) => {
    return (<Card sx={{
        p: 0,
        py: 5,
        paddingTop: 0,
        paddingBottom: 0,
        maxWidth: "220px",
        margin: "20px auto",
        display: "flex",
        flexDirection: "column",
        gap: 0,
        borderRadius: "15px"
    }}
                  elevation={10}
    >
        <CardContent sx={{
            display: "flex",
            flexDirection: "column",
            gap: 0.5
        }}>
            <Card sx={{p: 0.5}}
                  elevation={2}
            >
                <Typography sx={{fontSize: 14}} color="text.secondary" gutterBottom>
                    Related Unit:
                </Typography>
                <Typography>
                    {data.relatedUnit}
                </Typography>
            </Card>

            <Card sx={{p: 0.5}}
                  elevation={2}
            >
                <Typography sx={{fontSize: 14}} color="text.secondary" gutterBottom>
                    Product Tech Code:
                </Typography>
                <Typography>
                    {data.productTechCode}
                </Typography>
            </Card>

            <Card sx={{p: 0.5}}
                  elevation={2}
            >
                <Typography sx={{fontSize: 14}} color="text.secondary" gutterBottom>
                    Product Name:
                </Typography>
                <Typography>
                    {data.productName}
                </Typography>
            </Card>

            <Card sx={{p: 0.5}}
                  elevation={2}
            >
                <Typography sx={{fontSize: 14}} color="text.secondary" gutterBottom>
                    Quantity:
                </Typography>
                <Typography>
                    {data.quantity}
                </Typography>
            </Card>

            <Card sx={{p: 0.5}}
                  elevation={2}
            >
                <Typography sx={{fontSize: 14}} color="text.secondary" gutterBottom>
                    Quantity Type:
                </Typography>
                <Typography>
                    {data.quantityType}
                </Typography>
            </Card>

            <Card sx={{p: 0.5}}
                  elevation={2}
            >
                <Typography sx={{fontSize: 14}} color="text.secondary" gutterBottom>
                    Category:
                </Typography>
                <Typography>
                    {data.category}
                </Typography>
            </Card>

            <Card sx={{p: 0.5}}
                  elevation={2}
            >
                <Typography sx={{fontSize: 14}} color="text.secondary" gutterBottom>
                    Room Name of Installation:
                </Typography>
                <Typography>
                    {data.roomNameOfInstallation}
                </Typography>
            </Card>
        </CardContent>
        <CardActions sx={{mb: 1.5}}>
            <Button variant={"contained"} size="medium" disabled>Confirm</Button>
        </CardActions>
    </Card>);
}

export default BasicProductCard;