import React, {useState} from 'react';
import {Button, Card, CardContent, TextField, Typography} from "@mui/material"

const Register = () => {
    const [user, setUser] = useState({name:"",email:"",password:""});

    const handleChange = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        setUser ({...user, [name]: value});
    }

    const handleSubmit = async () => {
        console.log(user)
        const res = await fetch("http://localhost:8080/api/users/", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(user)
        })
        const data = await res.json()
        if (res.ok) {
            navigator("/");
        } else {
            console.log(data);
        }
    }

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
                    Register Here!
                </Typography>
            </CardContent>
            <TextField id="outlined-basic" label="Name" variant="outlined" type={"text"} name={"name"} onChange={handleChange} value={user.name}/>
            <TextField id="outlined-basic" label="Email" variant="outlined" type={"email"} name={"email"} onChange={handleChange} value={user.email}/>
            <TextField id="outlined-basic" label="Password" variant="outlined" type={"password"} name={"password"} onChange={handleChange} value={user.password}/>
            <Button variant={"contained"} onClick={handleSubmit}>Register</Button>
        </Card>
    )
}

export default Register;