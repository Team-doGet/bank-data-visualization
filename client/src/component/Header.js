import { Navbar, Container } from 'react-bootstrap';

function AppHeader() {
  return (
    <Navbar style={{ backgroundColor: '##7749F8' }} variant="dark" expand="lg">
      <Container>
        <Navbar.Brand href="#home">BankData</Navbar.Brand>
      </Container>
    </Navbar>
  );
}

export default AppHeader;
