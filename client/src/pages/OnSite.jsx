import React from 'react';
import {Button, Card, CardContent, Typography} from "@mui/material"

const OnSite = () => {
    return (
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
            <CardContent sx={{m: 0}}>
                <Typography gutterButton variant={"h4"} component={"div"} sx={{m: 0}}>
                    Get element of:
                </Typography>
            </CardContent>
            Filter
            based on 1 condition . select column
            list al card with confirmation button.

            <Button variant={"contained"}>Search</Button>
        </Card>
    )
}

export default OnSite;