import React, { useEffect, useState } from 'react';
import { Line } from 'react-chartjs-2';
import { Row, Card, Container, Col } from 'react-bootstrap';
import PeriodForm from '../component/PeriodForm';
import ColorSet from '../ColorSet';

const Income = ({ bankCode, API_ROOT, baseDate }) => {
  const incomeForm = [
    { id: 1, title: '비용-수익 비교', column: ['C40000000', 'C60000000'] },
    { id: 2, title: '이익-손실 추이', column: ['C57000000', 'C77000000'] },
    {
      id: 3,
      title: '비용 요소 분석',
      column: ['C41000000', 'C42000000', 'C43000000', 'C45000000', 'C47000000', 'C48000000', 'C55000000'],
    },
    {
      id: 4,
      title: '수익 요소 분석',
      column: ['C61000000', 'C62000000', 'C63000000', 'C65000000', 'C66000000', 'C67000000'],
    },
    { id: 5, title: '대출채권과 배당금 수익 분석', column: ['C66000000', 'C67000000'] },
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
      const url = `${API_ROOT}/income?stDate=${term.start}&endDate=${term.end}&term=${term.type}&bankCode=${bankCode}`;

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
  }, [term]);
  useEffect(() => {
    if (term.start !== baseDate.min) {
      setTerm({
        start: baseDate.min,
        end: baseDate.max,
        type: 'yearly',
      });
    }
  }, [baseDate]);

  return (
    <Container fluid>
      <Row className="content-page mt-4">
        <Col>
          <h1 style={{ fontWeight: 600 }}>IncomeStatement</h1>
          <h6 className="text-muted">{`${baseDate.min}~${baseDate.max}`}</h6>
        </Col>
      </Row>
      <PeriodForm baseDate={baseDate} term={term} setTerm={setTerm} />

      {incomeForm.map((e) => (
        <Row className="mt-4" key={e.id}>
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
                    .filter((row) => e.column.indexOf(row.code) > -1)
                    .map((row, i) => ({
                      ...row,
                      ...ColorSet[i],
                      data: row.data.map((el) => Number(el || 0)),
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

export default Income;
