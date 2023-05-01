import { Navbar, Container } from 'react-bootstrap';
import { Link } from 'react-router-dom';

function AppHeader() {
  return (
    <Navbar bg="primary" variant="dark" expand="lg">
      <Container>
        <Navbar.Brand as={Link} to="/">
          BankData
        </Navbar.Brand>
      </Container>
    </Navbar>
  );
}

export default AppHeader;
