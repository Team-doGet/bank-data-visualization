import React, { useState } from 'react';
import moment from 'moment';
import PeriodForm from '../component/PeriodForm';

import BubbleGraph from '../component/BubbleGraph';
import BarGraph from '../component/BarGraph';
import { Row, Col, Container } from 'react-bootstrap';

const Loan = () => {
  const [term, setTerm] = useState({
    start: moment().subtract(1, 'month').format('YYYY-MM-DD'),
    end: moment().format('YYYY-MM-DD'),
    type: 'monthly',
  });
  return (
    <Container fluid>
      <Row className="content-page mt-4">
        <h1 style={{ fontWeight: 600 }}>loan</h1>
      </Row>
      <PeriodForm term={term} setTerm={setTerm}></PeriodForm>
      <Row>
        <Col>
          <BarGraph term={term} url="/api/loan/guarantee.json" xLabel={'년도'} yLabel={'인원 수'}></BarGraph>
        </Col>
        <Col>
          <BarGraph term={term} url="/api/loan/customers/type.json" xLabel={'년도'} yLabel={'인원 수'}></BarGraph>
        </Col>
      </Row>
      <Row>
        <Col>
          <BarGraph term={term} url="/api/loan/period.json" xLabel={'기간'} yLabel={'인원 수'}></BarGraph>
        </Col>
        <Col>
          <BarGraph term={term} url="/api/loan/interest.json" xLabel={'이자'} yLabel={'인원 수'}></BarGraph>
        </Col>
      </Row>

      <BubbleGraph term={term} url="/api/loan/customers/region.json" xLabel={'지역'} yLabel={'인원 수'}></BubbleGraph>
    </Container>
  );
};

export default Loan;
