import {Nav,Container,Navbar}from 'react-bootstrap';
import logo from '../img/logo.png';

export const NavbarComponent = () => {

    return (
        <div className='navbarComponent'>
        <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
            <Container>
                <Navbar.Brand href="/"><img  src={logo} alt="" className='logo' /></Navbar.Brand>
                <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="me-auto">
                        <Nav.Link href="/">Home</Nav.Link>
                        <Nav.Link href="/Clientes">Clientes</Nav.Link>
                        <Nav.Link href="/Productos">Productos</Nav.Link>

                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
        </div>
    );
}