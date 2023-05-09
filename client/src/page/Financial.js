import React, { useEffect, useState } from 'react';
import { Line } from 'react-chartjs-2';
import { Row, Card, Container, Col } from 'react-bootstrap';
import PeriodForm from '../component/PeriodForm';
import ColorSet from '../ColorSet';

const Financial = ({ API_ROOT, bankCode, baseDate }) => {
  const incomeForm = [
    { title: '자산-부채-자본 비교', column: ['C10000000', 'C20000000', 'C30000000'] },
    {
      title: '자산 구성 비율',
      column: ['C10000000', 'C11000000', 'C14000000', 'C15000000', 'C16000000', 'C17000000', 'C19000000'],
    },
    {
      title: '부채 구성 비율',
      column: ['C20000000', 'C21000000', 'C22000000', 'C23000000'],
    },
    {
      title: '자본 구성 비율',
      column: ['C30000000', 'C31000000', 'C32000000', 'C33000000', 'C34000000', 'C35000000', 'C39000000'],
    },
  ];
  const [term, setTerm] = useState({
    start: baseDate.min,
    end: baseDate.max,
    type: 'yearly',
  });
  const [incomeData, setIncomeData] = useState({ labels: [], datasets: [] });

  const [data, setData] = useState({
    labels: [],
    datasets: [],
  });
  const [options, setOptions] = useState({});

  const fetchData = async (term) => {
    try {
      const url = `${API_ROOT}/financial?stDate=${term.start}&endDate=${term.end}&term=${term.type}&bankCode=${bankCode}&amountType=1`;
      const response = await fetch(url);
      const data = await response.json();
      setIncomeData(data);
      setOptions({});
      setData({
        labels: data.labels,
        datasets: data.datasets.map((e, i) => ({
          ...e,
          ...ColorSet[i],
        })),
      });
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    fetchData(term);
  }, [term, baseDate]);

  return (
    <Container fluid>
      <Row className="content-page mt-4">
        <Col>
          {/* <LoadingSpinner /> */}
          <h1 style={{ fontWeight: 600 }}>FinancialStatement</h1>
          <h6 className="text-muted">{`${baseDate.min}~${baseDate.max}`}</h6>
        </Col>
      </Row>
      <PeriodForm baseDate={baseDate} term={term} setTerm={setTerm} />

      {incomeForm.map((e) => (
        <Row className="mt-4">
          <Card>
            <Card.Header style={{ backgroundColor: '#fff' }}>
              <h3 className="mt-2" style={{ fontWeight: 600 }}>
                {e.title}
              </h3>
            </Card.Header>
            <Card.Body>
              <Line
                options={{
                  responsive: true,
                  plugins: {
                    legend: {
                      position: 'right',
                    },
                  },
                }}
                data={{
                  labels: incomeData.labels,
                  datasets: incomeData.datasets
                    .filter((data) => e.column.indexOf(data.code) > -1)
                    .map((data, i) => ({
                      ...data,
                      ...ColorSet[i],
                    })),
                }}
              />
            </Card.Body>
          </Card>
        </Row>
      ))}
      <Row>
        <br />
        <br />
        <br />
        <br />
      </Row>
    </Container>
  );
};

export default Financial;
