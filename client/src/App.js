import React from 'react';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import NavBar from "./components/NavBar";
import {Container} from "@mui/material";
import AddNewElement from "./pages/AddNewElement";
import Office from "./pages/Office";
import OfficeEdit from "./pages/OfficeEdit";
import OnSite from "./pages/OnSite";

const App = () => {
    return (
        <div>
            <BrowserRouter>
                <NavBar/>
                <Container
                    sx={{p: 0, mt: 9}}
                >
                    <Routes>
                        <Route path={"https://mystock-frontend.onrender.com/"} element={<Office/>}/>
                        <Route path={"https://mystock-frontend.onrender.com/edit"} element={<OfficeEdit/>}/>
                        {/*<Route path={"/login"} element={<Login/>}/>*/}
                        {/*<Route path={"/register"} element={<Register/>}/>*/}
                        <Route path={"https://mystock-frontend.onrender.com/new"} element={<AddNewElement/>}/>
                        <Route path={"https://mystock-frontend.onrender.com/onsite"} element={<OnSite/>}/>
                    </Routes>
                </Container>
            </BrowserRouter>
        </div>
    )
}

export default App;
