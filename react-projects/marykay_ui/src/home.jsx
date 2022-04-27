import './css/Home.css'
import { Card } from './components/Card'
import { getFacturas } from './services/productos';
import { useEffect, useState } from 'react';

export function Home() {

    const [datos, setDatos] = useState([]);

    useEffect(() => {
        getFacturas().then(setDatos);
    }, [])


    return (

        <div className='container'>

            <h1 className='display-4'>Bienvenido de nuevo</h1>
            <div className='container'>
                <div className="row"> {datos.map((factura) => (
                    <Card key={factura.id} title={factura.cliente_name} text={factura.total} />
                )
                )}
                </div>
            </div>
        </div>
    )
}