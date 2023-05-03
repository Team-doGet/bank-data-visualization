import React, { useState } from 'react';
import BarGraph from '../component/BarGraph';
import PeriodForm from '../component/PeriodForm';
import { Container, Row } from 'react-bootstrap';

const Deposit = ({ baseDate }) => {
  const [term, setTerm] = useState({
    start: baseDate.min,
    end: baseDate.max,
    type: 'yearly',
  });
  return (
    <Container fluid>
      <Row className="content-page mt-4">
        <h1 style={{ fontWeight: 600 }}>Deposit</h1>
      </Row>
      <PeriodForm baseDate={baseDate} term={term} setTerm={setTerm} />
      <BarGraph term={term} url="/api/Bar1test.json"></BarGraph>
      <BarGraph term={term} url="/api/Bar1test2.json"></BarGraph>
    </Container>
  );
};

export default Deposit;
