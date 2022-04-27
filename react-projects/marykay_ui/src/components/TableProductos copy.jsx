import { useEffect, useState } from "react";
import { getProductos } from "../services/productos";

export function TableProducto() {

    const [productos, setproductos] = useState([]);

    useEffect(() => {
        getProductos().then(setproductos);
    }, [])


    return (
        <table className="table table-dark table-hover table-borderless table-sm">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Stock</th>
                </tr>
            </thead>
            <tbody>
                    {productos.map((producto) => (
                        <tr key={producto.id}>
                        <th scope="row">{producto.id}</th>
                        <td>{producto.name}</td>
                        <td>{producto.description}</td>
                        <td>{producto.stock}</td></tr>
                    ))}

            </tbody>
        </table>
    );
}