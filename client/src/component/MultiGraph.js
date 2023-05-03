import React, { useEffect, useState } from 'react';
import { Chart } from 'react-chartjs-2';
import { Row, Card, Container } from 'react-bootstrap';
import ColorSet from '../ColorSet';

const MultiGraph = ({ term, url, xLabel, yLabel1, yLabel2 }) => {
  const [data, setData] = useState({
    labels: [],
    datasets: [],
  });
  const [options, setOptions] = useState({});

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
            display: true,
            text: data.title,
          },
        },
        options: {
          scales: {
            x: {
              title: {
                display: true,
                text: xLabel,
              },
            },
            'y-left': {
              id: 'y-axis-1',
              position: 'left',

              title: {
                display: true,
                text: yLabel1,
              },
              ticks: {
                beginAtZero: true,
              },
            },
            'y-right': {
              position: 'right',
              id: 'y-axis-2',
              title: {
                display: true,
                text: yLabel2,
              },
              ticks: {
                beginAtZero: true,
              },
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
                yAxisID: 'y-left',
              };
            }
            return {
              ...e,
              ...ColorSet[i],
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
              };
            } else {
              return {
                ...e,
                data: temp,
                ...ColorSet[i],
                // yAxisID: 'y-right',
              };
            }
          }
        }),
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
          <Card.Body>
            <Chart type="bar" options={options} data={data} />
          </Card.Body>
        </Card>
      </Row>
    </Container>
  );
};

export default MultiGraph;
