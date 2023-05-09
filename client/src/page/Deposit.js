import React, { useState } from 'react';
import PeriodForm from '../component/PeriodForm';
import BubbleGraph from '../component/BubbleGraph';
import BarGraph from '../component/BarGraph';
import LineGraph from '../component/LineGraph';
import MultiGraph from '../component/MultiGraph';
import { Row, Col, Container } from 'react-bootstrap';

const Loan = ({ bankCode, API_ROOT, baseDate }) => {
  const [term, setTerm] = useState({
    start: baseDate.min,
    end: baseDate.max,
    type: 'yearly',
  });
  return (
    <Container fluid>
      <Row className="content-page mt-4">
        <Col>
          <h1 style={{ fontWeight: 600 }}>Deposit</h1>
          <h6 className="text-muted">{`${baseDate.min}~${baseDate.max}`}</h6>
        </Col>
      </Row>
      <PeriodForm baseDate={baseDate} term={term} setTerm={setTerm} />
      <Row>
        <Col>
          <BarGraph
            term={term}
            url={`${API_ROOT}/deposit/type?bankCode=${bankCode}`}
            title={`예금 종류`}
            xLabel={'년도'}
            yLabel={'인원 수'}
          ></BarGraph>
        </Col>
        <Col>
          <BarGraph
            term={term}
            url={`${API_ROOT}/deposit/customers/type?bankCode=${bankCode}`}
            title={`개인·법인 구분`}
            xLabel={'년도'}
            yLabel={'인원 수'}
          ></BarGraph>
        </Col>
      </Row>
      <Row>
        <Col>
          <BarGraph
            term={term}
            url={`${API_ROOT}/deposit/customers/amount?bankCode=${bankCode}`}
            title={`금액별 인원`}
            xLabel={'금액'}
            yLabel={'인원 수'}
          ></BarGraph>
        </Col>
        {/* <Col>
          <BarGraph
            term={term}
            url={`${API_ROOT}/deposit/period?bankCode=${bankCode}`}
            title={`예금 기간`}
            xLabel={'기간'}
            yLabel={'인원 수'}
          ></BarGraph>
        </Col>
        <Col></Col> */}
      </Row>
      <Row>
        <Col>
          {/* <MultiGraph
            term={term}
            url={`${API_ROOT}/deposit/customers/amount?bankCode=${bankCode}`}
            xLabel={'금액'}
            yLabel={'인원 수'}
          ></MultiGraph> */}
        </Col>
      </Row>
      <Row>
        <Col>
          <LineGraph
            term={term}
            url={`${API_ROOT}/deposit/stats?bankCode=${bankCode}`}
            title={`예금액 분석`}
            xLabel={'통계'}
            yLabel={'금액'}
          ></LineGraph>
        </Col>
      </Row>
      <Row>
        <Col>
          {/* <BubbleGraph
            term={term}
            url={`${API_ROOT}/deposit/customers/region?bankCode=${bankCode}`}
            xLabel={'지역'}
            yLabel={'인원 수'}
          ></BubbleGraph> */}
        </Col>
      </Row>
      <Row>
        <br />
        <br />
        <br />
        <br />
      </Row>
    </Container>
  );
};

export default Loan;
