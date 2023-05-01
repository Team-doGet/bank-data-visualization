import { Navbar, Container, Row, Col } from 'react-bootstrap';

function Footer() {
  return (
    <Navbar fixed="bottom" bg="dark" variant="dark" expand="lg">
      <Container>
        <Row>
          <Col xs={12} md={12} style={{ color: '#fff' }}>
            2023 © BankDataVisualization - data.doGet.site
          </Col>
        </Row>
      </Container>
    </Navbar>
  );
}

export default Footer;
