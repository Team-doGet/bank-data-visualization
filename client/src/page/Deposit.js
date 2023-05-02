import React, { useState } from 'react';
import moment from 'moment';
import BarGraph from '../component/BarGraph';
import PeriodForm from '../component/PeriodForm';
import { Container, Row } from 'react-bootstrap';

const Deposit = () => {
  const [term, setTerm] = useState({
    start: moment().subtract(1, 'month').format('YYYY-MM-DD'),
    end: moment().format('YYYY-MM-DD'),
    type: 'monthly',
  });

  return (
    <Container fluid>
      <Row className="content-page mt-4">
        <h1 style={{ fontWeight: 600 }}>Deposit</h1>
      </Row>
      <PeriodForm term={term} setTerm={setTerm}></PeriodForm>
      <BarGraph term={term} url="/api/Bar1test.json"></BarGraph>
      <BarGraph term={term} url="/api/Bar1test2.json"></BarGraph>
    </Container>
  );
};

export default Deposit;
