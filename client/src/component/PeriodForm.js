import React, { useEffect, useState } from 'react';
import { Button, Card, Col, Form, Row } from 'react-bootstrap';

const PeriodForm = ({ term, setTerm }) => {
  const handleChange = (e) => {
    setTerm({
      ...term,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('test');
  };

  return (
    <Row className="mt-4">
      <Card border="" bg="" className="">
        <Card.Body className="">
          <Card.Title>Period</Card.Title>
          <Row>
            <Form onSubmit={handleSubmit}>
              <Row className="mb-3">
                <Form.Group as={Col} controlId="start">
                  <Form.Label>시작 날짜</Form.Label>
                  <Form.Control type="date" name="start" value={term.start} onChange={handleChange} />
                </Form.Group>
                <Form.Group as={Col} controlId="end">
                  <Form.Label>종료 날짜</Form.Label>
                  <Form.Control type="date" name="end" value={term.end} onChange={handleChange} />
                </Form.Group>
                <Form.Group as={Col} controlId="type">
                  <Form.Label>기간 텀</Form.Label>
                  <Form.Control as="select" name="type" value={term.type} onChange={handleChange}>
                    <option value="monthly">월간</option>
                    <option value="quarterly">분기</option>
                    <option value="yearly">년간</option>
                  </Form.Control>
                </Form.Group>
              </Row>
              <Col>
                <Button type="submit">적용</Button>
              </Col>
            </Form>
          </Row>
        </Card.Body>
      </Card>
    </Row>
  );
};

export default PeriodForm;
