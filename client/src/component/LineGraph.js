import React, { useEffect, useState } from 'react';
import { Line } from 'react-chartjs-2';
import { Row, Card, Container } from 'react-bootstrap';
import ColorSet from '../ColorSet';
import LoadingSpinner from './LoadingSpinner';

const BarGraph = ({ term, url, title, xLabel, yLabel }) => {
  const [data, setData] = useState({
    labels: [],
    datasets: [],
  });
  const [options, setOptions] = useState({ plugins: { title: { text: '' } } });
  const [loading, setLoading] = useState(true);

  const fetchData = async (term) => {
    try {
      const response = await fetch(`${url}&stDate=${term.start}&endDate=${term.end}&term=${term.type}`);
      const data = await response.json();

      setOptions({
        responsive: true,
        plugins: {
          legend: {
            position: 'right',
          },
          title: {
            display: false,
            text: title,
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
      setLoading(false);
    } catch (error) {
      console.error(error);
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchData(term);
  }, [term]);

  return (
    <Container>
      <Row className="content-page mt-4"></Row>
      <Row className="mt-4">
        <Card>
          <Card.Header style={{ backgroundColor: '#fff' }}>
            <h3 className="mt-2" style={{ fontWeight: 600 }}>
              {options.plugins.title.text || ''}
            </h3>
          </Card.Header>
          <Card.Body>
            {loading ? (
              <LoadingSpinner />
            ) : (
              <div>
                <Line options={options} data={data} />
              </div>
            )}
          </Card.Body>
        </Card>
      </Row>
    </Container>
  );
};

export default BarGraph;
