import Nav from 'react-bootstrap/Nav';
import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from 'react-router-dom';

function Navigation() {
  const fontStyle = { fontSize: '1.2rem' };
  const menu = [
    { title: 'Loan', to: '/loan' },
    { title: 'Deposit', to: '/deposit' },
    { title: 'IncomeStatement', to: '/income' },
    { title: 'FinancialStatement', to: '/financial' },
  ];
  return (
    <Navbar bg="dark" variant="dark" expand="lg">
      <Container>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            {menu.map((e) => (
              <Nav.Link as={Link} to={e.to} style={fontStyle}>
                {e.title}
              </Nav.Link>
            ))}
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default Navigation;
