import { useEffect, useState } from "react";
import { getClientes } from "../services/productos";

export function TableComponent() {

    const [clientes, setclientes] = useState([]);

    useEffect(() => {
        getClientes().then(setclientes);
    }, [])


    return (
        <table className="table table-dark table-hover table table-sm">
            <thead>
                <tr>

                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">LastName</th>
                    <th scope="col">Address</th>
                </tr>
            </thead>
            <tbody>
                    {clientes.map((cliente) => (
                        <tr key={cliente.id}>
                        <th scope="row">{cliente.id}</th>
                        <td>{cliente.name}</td>
                        <td>{cliente.lastName}</td>
                        <td>{cliente.address}</td></tr>
                    ))}

            </tbody>
        </table>
    );
}