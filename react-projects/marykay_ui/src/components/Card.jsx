import { useState } from 'react';
import { Modal, Button } from 'react-bootstrap';

export function Card({ id, title, text }) {
    const [show, setShow] = useState(false);


    const handleClose = () => {
        setShow(false);
    };
    const handleShow = () => setShow(true);

    return (

        <div className="col-sm-6">
            <div className="card bg-dark">
                <div className="card-body">
                    <h5 className="card-title">{title}</h5>
                    <p className="card-text">Valor total: ${text}</p>
                    <button onClick={handleShow} className="btn btn-primary">Vamos a ver</button>
                </div>
            </div>
            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>factura de {title}</Modal.Title>
                </Modal.Header>
                <Modal.Body></Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
                    </Button>
                    <Button variant="primary" onClick={handleClose}>
                        Save Changes
                    </Button>
                </Modal.Footer>
            </Modal>
        </div>

    );
}