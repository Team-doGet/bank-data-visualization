import { Nav, Container, Navbar, Form } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import BANK_LIST from '../data/FINANCIAL';

function Navigation({ setbankCode }) {
  const fontStyle = { fontSize: '1.2rem' };
  const menu = [
    { id: 1, title: 'Loan', to: '/loan' },
    { id: 2, title: 'Deposit', to: '/deposit' },
    { id: 3, title: 'IncomeStatement', to: '/income' },
    { id: 4, title: 'FinancialStatement', to: '/financial' },
  ];
  const selectEvent = (e) => {
    setbankCode(e.target.value);
  };
  return (
    <Navbar bg="dark" variant="dark" expand="lg">
      <Container>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            {menu.map((e) => (
              <Nav.Link key={e.id} as={Link} to={e.to} style={fontStyle}>
                {e.title}
              </Nav.Link>
            ))}
          </Nav>
        </Navbar.Collapse>
        <Navbar.Collapse></Navbar.Collapse>
        <Navbar.Collapse>
          <Form.Control as="select" name="srchFinancial" title="저축은행 선택" onChange={selectEvent}>
            <option value={BANK_LIST[0].code}>{BANK_LIST[0].name}</option>
            {/* {BANK_LIST.map((e) => (
              <option value={e.code}>{e.name}</option>
            ))} */}
          </Form.Control>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default Navigation;
