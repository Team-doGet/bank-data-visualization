import React, { useEffect, useState } from 'react';
import { Card, Col, Container, ListGroup, ListGroupItem, Row } from 'react-bootstrap';
import NaverMap from '../component/NaverMap';

const Home = ({ bankCode }) => {
  const [name, setName] = useState('');
  const [branch, setBranch] = useState([]);
  const fetchData = async (bankCode) => {
    try {
      const url = `/api/bank/branch.json`; //?backCode=${bankCode}`;
      const response = await fetch(url);
      const data = await response.json();
      setName(data.name);
      setBranch(data.branch);
    } catch (error) {
      console.error(error);
    }
  };
  useEffect(() => {
    fetchData(bankCode);
  }, []);

  return (
    <Container fluid>
      <Row className="content-page mt-4">
        <h1 style={{ fontWeight: 600 }}>{name}</h1>
      </Row>
      <Row className="mt-4">
        <Col lg={10}>
          <Card>
            <Card.Body>
              <NaverMap branch={branch}></NaverMap>
            </Card.Body>
          </Card>
        </Col>
        <Col lg={2}>
          <ListGroup>
            {branch.map((e, i) => (
              <ListGroupItem id={i}>{e.name}</ListGroupItem>
            ))}
          </ListGroup>
        </Col>
      </Row>
    </Container>
  );
};

export default Home;
