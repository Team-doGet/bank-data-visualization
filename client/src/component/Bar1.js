import React, { useEffect, useState } from 'react';
import { Bar } from 'react-chartjs-2';
import { Row, Card } from 'react-bootstrap';
import ColorSet from '../ColorSet';

const Bar1 = ({ term, url }) => {
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
    <div>
      <Row className="mt-4">
        <Card>
          <Card.Body>
            <Bar options={options} data={data} />
          </Card.Body>
        </Card>
      </Row>
    </div>
  );
};

export default Bar1;
