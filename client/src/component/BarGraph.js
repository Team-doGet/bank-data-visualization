import React, { useEffect, useState } from 'react';
import { Bar } from 'react-chartjs-2';
import { Row, Card, Container } from 'react-bootstrap';
import ColorSet from '../ColorSet';

const BarGraph = ({ term, url, xLabel, yLabel }) => {
  const [data, setData] = useState({
    labels: [],
    datasets: [],
  });
  const [options, setOptions] = useState({ plugins: { title: { text: '' } } });

  const fetchData = async (term) => {
    try {
      const response = await fetch(url);
      const data = await response.json();

      setOptions({
        responsive: true,
        plugins: {
          legend: {
            position: 'right',
          },
          title: {
            display: false,
            text: data.title,
          },
        },
        scales: {
          x: {
            title: {
              display: true,
              text: xLabel,
            },
          },
          y: {
            title: {
              display: true,
              text: yLabel,
            },
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
  });

  return (
    <Container fluid>
      <Row className="content-page mt-4"></Row>
      <Row className="mt-4">
        <Card>
          <Card.Header style={{ backgroundColor: '#fff' }}>
            <h3 className="mt-2" style={{ fontWeight: 600 }}>
              {options.plugins.title.text || ''}
            </h3>
          </Card.Header>
          <Card.Body>
            <Bar options={options} data={data} />
          </Card.Body>
        </Card>
      </Row>
    </Container>
  );
};

export default BarGraph;
