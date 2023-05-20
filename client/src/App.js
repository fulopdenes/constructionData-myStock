import React from 'react';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import Register from "./pages/Register";
import NavBar from "./components/NavBar";
import {Container} from "@mui/material";
import AddNewElement from "./pages/AddNewElement";
import Office from "./pages/Office";
import OfficeEdit from "./pages/OfficeEdit";
import OnSite from "./pages/OnSite";
import RegisterPage from "./pages/RegisterPage";

const App = () => {
    return (
        <div>
            <BrowserRouter>
                <NavBar/>
                <Container
                    sx={{p: 0, mt: 9}}
                >
                    <Routes>
                        <Route path={"/"} element={<Office/>}/>
                        <Route path={"/edit"} element={<OfficeEdit/>}/>
                        <Route path={"/registerek"} element={<RegisterPage/>}/>
                        {/*<Route path={"/login"} element={<Login/>}/>*/}
                        <Route path={"/register"} element={<Register/>}/>
                        <Route path={"/new"} element={<AddNewElement/>}/>
                        <Route path={"/onsite"} element={<OnSite/>}/>
                    </Routes>
                </Container>
            </BrowserRouter>
        </div>
    )
}

export default App;
