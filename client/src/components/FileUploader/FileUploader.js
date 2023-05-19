import React, {useState} from 'react';
import axios from 'axios';
import {toast} from 'react-toastify';

import './style.css';
import {Button, Card, CardContent, Input, Typography} from "@mui/material";

export const FileUploader = ({onSuccess}) => {
    const [files, setFiles] = useState([]);

    const onInputChange = (e) => {
        setFiles(e.target.files)
    };

    const onSubmit = (e) => {
        e.preventDefault();

        const data = new FormData();

        for (let i = 0; i < files.length; i++) {
            data.append('file', files[i]);
        }

        axios.post('//localhost:8000/upload', data)
            .then((response) => {
                toast.success('Upload Success');
                onSuccess(response.data)
            })
            .catch((e) => {
                toast.error('Upload Error')
            })
    };
    return (<Card sx={{
            p: 3,
            py: 5,
            maxWidth: "550px",
            margin: "50px auto",
            display: "flex",
            flexDirection: "column",
            gap: 1,
            borderRadius: "15px"
        }} elevation={10}>
            <CardContent sx={{
                m: 0
            }}>
                <Typography gutterButton variant={"h4"} component={"div"} sx={{m: 0, p: 0, textAlign:"center"}}>
                    Scan Your Document
                </Typography>
            </CardContent>
            <form method="post" action="#" id="#" onSubmit={onSubmit}>
                <div className="form-group files">
                    <input type="file"
                           onChange={onInputChange}
                           className="form-control"
                           multiple
                    />
                </div>
            </form>
            <Button variant={"contained"} color="primary">Submit</Button>
        </Card>
    )
};