import React, { useState } from 'react';
import moment from 'moment';
import PeriodForm from '../component/PeriodForm';
import BubbleGraph from '../component/BubbleGraph';
import BarGraph from '../component/BarGraph';
import { Col, Row } from 'react-bootstrap';

const Loan = ({ baseDate }) => {
  const [term, setTerm] = useState({
    start: baseDate.min,
    end: baseDate.max,
    type: 'yearly',
  });
  return (
    <div>
      <h1>Loan</h1>
      <PeriodForm baseDate={baseDate} term={term} setTerm={setTerm} />
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
    </div>
  );
};

export default Loan;
