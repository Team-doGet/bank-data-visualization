import React, { useEffect, useState } from 'react';
import { Chart } from 'react-chartjs-2';
import { Row, Card, Container } from 'react-bootstrap';
import ColorSet from '../ColorSet';
import LoadingSpinner from './LoadingSpinner';

const MultiGraph = ({ term, url, xLabel, yLabel1, yLabel2 }) => {
  const [data, setData] = useState({
    labels: [],
    datasets: [],
  });
  const [options, setOptions] = useState({ plugins: { title: { text: '' } } });
  const [loading, setLoading] = useState(true);

  const fetchData = async (term) => {
    setLoading(true);

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
            id: 'y',
            position: 'left',
            title: {
              display: true,
              text: yLabel1,
            },
            ticks: {
              beginAtZero: true,
            },
          },
          y1: {
            type: 'linear',
            display: true,
            position: 'left',
            id: 'y1',
            title: {
              display: true,
              text: yLabel2,
            },
            grid: {
              drawOnChartArea: false,
            },
          },
        },
      });
      setData({
        labels: data.labels,
        datasets: data.datasets.map((e, i) => {
          if (i < 2) {
            if (i === 1) {
              return {
                ...e,
                ...ColorSet[i],
                yAxisID: 'y',
              };
            }
            return {
              ...e,
              ...ColorSet[i],
              yAxisID: 'y',
            };
          } else {
            const temp = [0];
            for (let index = 1; index < e.data.length; index++) {
              const element = ((e.data[index] - e.data[index - 1]) / e.data[index - 1]) * 100;
              temp.push(element);
            }
            if (i === 2) {
              return {
                ...e,
                data: temp,
                ...ColorSet[i],
                yAxisID: 'y1',
              };
            } else {
              return {
                ...e,
                data: temp,
                ...ColorSet[i],
                yAxisID: 'y1',
              };
            }
          }
        }),
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
            {loading ? (
              <LoadingSpinner />
            ) : (
              <div>
                <Chart options={options} data={data} />
              </div>
            )}
          </Card.Body>
        </Card>
      </Row>
    </Container>
  );
};

export default MultiGraph;
