import React from 'react';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import Register from "./pages/Register";
import Login from "./pages/Login";
import NavBar from "./components/NavBar";
import {Container} from "@mui/material";
import AddNewElement from "./pages/AddNewElement";
import Office from "./pages/Office";
import OnSite from "./pages/OnSite";



const App = () => {
    return (
        <div>
            <BrowserRouter>
                <NavBar/>
                <Container sx={{p:1, mt: 10}}>
                    <Routes>
                        <Route path={"/"} element={<Office/>}/>
                        <Route path={"/login"} element={<Login/>}/>
                        <Route path={"/register"} element={<Register/>}/>
                        <Route path={"/new"} element={<AddNewElement/>}/>
                        <Route path={"/onsite"} element={<OnSite/>}/>
                    </Routes>
                </Container>
            </BrowserRouter>
        </div>
    )
}

// import logo from './logo.svg';
// import './App.css';
//
// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }
//
export default App;
