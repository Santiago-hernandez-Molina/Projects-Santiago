import axios from "axios";

const url='http://localhost:8000/api/'

export async function getProductos(){
    let datos={};
    await axios.get(`${url}producto/`).then(response=>{
        datos=response.data;
    });
    return datos;
}
export async function getClientes(){
    let datos={};
    await axios.get(`${url}cliente/`).then(response=>{
        datos=response.data;
    })
    return datos;
}
export async function getFacturas(){
    let datos={}
    await axios.get(`${url}factura/`).then(response=>{
        datos=response.data;
    })
    return datos;
}
export async function detailFactura(id){
    let dato={}
    await axios.get(`${url}factura/${id}/`).then(response=>{
        dato=response.data;
    })
    return dato;
}

