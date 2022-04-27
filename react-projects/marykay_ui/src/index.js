import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import ReactDOM from 'react-dom/client';
import './index.css';
import { Home } from './home';
import { NavbarComponent } from './components/Navbar';
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";
import { TableComponent } from './components/TableClientes';
import { TableProducto } from './components/TableProductos';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <NavbarComponent />
    <div className='container'>
    <Router>
      <Routes>
        <Route path='/Clientes' element={<TableComponent />} />
        <Route path='/' element={<Home />} />
        <Route path='/Productos' element={<TableProducto />} />
      </Routes>
    </Router>
    </div>
  </React.StrictMode>
);
