import { Navbar, Container } from 'react-bootstrap';
import { Link } from 'react-router-dom';

function AppHeader() {
  return (
    <Navbar style={{ backgroundColor: 'black' }} variant="dark" expand="lg">
      <Container>
        <Navbar.Brand as={Link} to="/" style={{ fontFamily: 'Bruno Ace SC', fontSize: '2.0rem' }}>
          BankData
        </Navbar.Brand>
      </Container>
    </Navbar>
  );
}

export default AppHeader;
