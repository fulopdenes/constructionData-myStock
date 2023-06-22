import React from 'react';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import NavBar from "./components/NavBar";
import {Container} from "@mui/material";
import AddNewElement from "./pages/AddNewElement";
import Office from "./pages/Office/Office";
import OfficeEdit from "./pages/Office/OfficeEdit";
import OnSite from "./pages/Onsite/OnSite";
import HomePage from "./pages/Home/HomePage";

const App = () => {
    return (
        <div>
            <BrowserRouter>
                <NavBar/>
                <Container
                    sx={{p: 0, mt: 9}}
                >
                    <Routes>
                        <Route path={"/"} element={<HomePage/>}/>
                        <Route path={"/edit"} element={<OfficeEdit/>}/>
                        {/*<Route path={"/login"} element={<Login/>}/>*/}
                        {/*<Route path={"/register"} element={<Register/>}/>*/}
                        <Route path={"/new"} element={<AddNewElement/>}/>
                        <Route path={"/office"} element={<Office/>}/>
                        <Route path={"/onsite"} element={<OnSite/>}/>
                    </Routes>
                </Container>
            </BrowserRouter>
        </div>
    )
}

export default App;
