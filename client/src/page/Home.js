import React, { useEffect, useState } from 'react';
import { Card, Container, Row } from 'react-bootstrap';

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
        <Card>
          <Card.Body></Card.Body>
        </Card>
      </Row>
      <div>
        <ul>
          {branch.map((e) => (
            <li>{e.name}</li>
          ))}
        </ul>
      </div>
    </Container>
  );
};

export default Home;
