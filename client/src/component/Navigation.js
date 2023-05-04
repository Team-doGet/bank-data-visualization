import { Nav, Container, Navbar, Form } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import Financial from '../data/Financial';

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
        <Navbar.Collapse></Navbar.Collapse>
        <Navbar.Collapse>
          <Form.Control as="select" name="srchFinancial" title="저축은행 선택">
            {Financial.map((e) => (
              <option value={e.code}>{e.name}</option>
            ))}
          </Form.Control>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default Navigation;
