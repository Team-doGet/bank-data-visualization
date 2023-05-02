import React, { useEffect, useState } from 'react';
import { Line } from 'react-chartjs-2';
import { Row, Card, Container } from 'react-bootstrap';
import PeriodForm from '../component/PeriodForm';
import ColorSet from '../ColorSet';

const Income = ({ baseDate }) => {
  const [term, setTerm] = useState({
    start: baseDate.min,
    end: baseDate.max,
    type: 'yearly',
  });
  const [data, setData] = useState({
    labels: [],
    datasets: [],
  });
  const [options, setOptions] = useState({});

  const fetchData = async (term) => {
    try {
      const url = `/api/income.json`; //?start=${term.start}&end=${term.end}&=type${term.type}`;
      const response = await fetch(url);
      const data = await response.json();

      setOptions({
        responsive: true,
        plugins: {
          legend: {
            position: 'right',
          },
          title: {
            display: true,
            text: data.title,
          },
        },
      });
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
  }, []);

  return (
    <Container fluid>
      <Row className="content-page mt-4">
        <h1 style={{ fontWeight: 600 }}>손익계산서</h1>
      </Row>
      <div>{`${term.start}~${term.end}`}</div>
      <PeriodForm baseDate={baseDate} term={term} setTerm={setTerm}></PeriodForm>

      <Row className="mt-4">
        <Card>
          <Card.Body>
            <Line options={options} data={data} />
          </Card.Body>
        </Card>
      </Row>
    </Container>
  );
};

export default Income;
