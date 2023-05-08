import React, { useEffect, useState } from 'react';
import { Button, Card, Col, Form, Row } from 'react-bootstrap';

const PeriodForm = ({ baseDate, term, setTerm }) => {
  const [newTerm, setNewTerm] = useState({ start: term.start, end: term.end, type: term.type });
  const startYear = new Date(baseDate.min).getFullYear();
  const endYear = new Date(baseDate.max).getFullYear();
  const handleTypeChange = (e) => {
    let start = newTerm.start;
    let end = newTerm.end;
    if (e.target.value === 'monthly') {
      start = `${new Date(newTerm.start).getFullYear()}-${getMonth(newTerm.start)}-01`;
      end = `${new Date(newTerm.end).getFullYear()}-${getMonth(newTerm.end)}-01`;
    } else if (e.target.value === 'quarterly') {
      start = `${new Date(newTerm.start).getFullYear()}-${['01', '04', '07', '10'][getMonth(newTerm.start) % 4]}-01`;
      end = `${new Date(newTerm.end).getFullYear()}-${['03-31', '06-30', '09-30', '12-31'][getMonth(newTerm.end) % 4]}`;
    } else if (e.target.value === 'yearly') {
      start = `${new Date(newTerm.start).getFullYear()}-01-01`;
      end = `${new Date(newTerm.end).getFullYear()}-12-31`;
    }
    setNewTerm({
      start,
      end,
      [e.target.name]: e.target.value,
    });
  };
  const handleMonthlyChange = (e) => {
    let start = newTerm.start;
    let end = newTerm.end;
    if (e.target.name === 'start') {
      start = e.target.value + '-01';
    } else {
      end = `${e.target.value}-${new Date(...e.target.value.split('-'), 0).getDate()}`;
    }
    setNewTerm({
      ...newTerm,
      start,
      end,
    });
  };
  const handleDateChange = (e) => {
    if (e.target.value === 'monthly') {
    } else if (e.target.value === 'quarterly') {
    } else if (e.target.value === 'yearly') {
    }
    setNewTerm({
      ...newTerm,
      [e.target.name]: e.target.value,
    });
  };
  const handleSubmit = (event) => {
    event.preventDefault();
    const form = event.target;
    const inputs = form.querySelectorAll('input, select, textarea');
    let isValid = true;
    for (const input of inputs) {
      if (input.required && !input.value) {
        isValid = false;
        break;
      }
    }
    if (isValid && new Date(newTerm.start) < new Date(newTerm.end)) {
      // 폼 데이터가 유효한 경우, 서버로 전송하거나 다른 처리를 수행합니다.
      console.log('폼 데이터가 유효합니다.');
      setTerm({ ...term, ...newTerm });
    } else {
      // 폼 데이터가 유효하지 않은 경우, 사용자에게 알립니다.
      alert('시작일과 종료일을 확인해 주세요.');
    }
  };
  const getMonth = (date) => {
    return String(new Date(date).getMonth() + 1).padStart(2, '0');
  };
  return (
    <Row className="mt-4">
      <Card border="" bg="" className="">
        <Card.Body className="">
          <Card.Title>Period</Card.Title>
          <Row>
            <Form onSubmit={handleSubmit}>
              <Row className="mb-3">
                <Form.Group as={Col} controlId="type">
                  <Form.Label>
                    <h5>기간 텀</h5>
                  </Form.Label>
                  <Form.Control as="select" name="type" value={newTerm.type} onChange={handleTypeChange}>
                    <option value="yearly">년간</option>
                    <option value="quarterly">분기</option>
                    <option value="monthly">월간</option>
                  </Form.Control>
                </Form.Group>
                <Form.Group as={Col} controlId="start">
                  <Form.Label>
                    <h5>시작</h5>
                  </Form.Label>
                  {newTerm.type === 'monthly' ? (
                    <Form.Control
                      type="month"
                      name="start"
                      value={`${new Date(newTerm.start).getFullYear()}-${getMonth(newTerm.start)}`}
                      onChange={handleMonthlyChange}
                    />
                  ) : newTerm.type === 'quarterly' ? (
                    <Form.Control as="select" name="start" value={newTerm.start} onChange={handleDateChange} required>
                      <option value="">-선택-</option>
                      {Array(endYear - startYear + 1)
                        .fill()
                        .map((_, i) =>
                          ['01', '04', '07', '10'].map((e, q) => (
                            <option value={`${startYear + i}-${e}-01`}>{`${startYear + i}년 ${q + 1}분기`}</option>
                          ))
                        )}
                    </Form.Control>
                  ) : (
                    <Form.Control as="select" name="start" value={newTerm.start} onChange={handleDateChange} required>
                      <option value="">-선택-</option>
                      {Array(endYear - startYear + 1)
                        .fill()
                        .map((_, i) => (
                          <option value={`${startYear + i}-01-01`}>{`${startYear + i}년`}</option>
                        ))}
                    </Form.Control>
                  )}
                </Form.Group>
                <Form.Group as={Col} controlId="end">
                  <Form.Label className="form-label">
                    <h5>종료</h5>
                  </Form.Label>
                  {newTerm.type === 'monthly' ? (
                    <Form.Control
                      type="month"
                      name="end"
                      value={`${new Date(newTerm.end).getFullYear()}-${getMonth(newTerm.end)}`}
                      onChange={handleMonthlyChange}
                    />
                  ) : newTerm.type === 'quarterly' ? (
                    <Form.Control as="select" name="end" value={newTerm.end} onChange={handleDateChange} required>
                      <option value="">-선택-</option>
                      {Array(endYear - startYear + 1)
                        .fill()
                        .map((_, i) =>
                          ['03-31', '06-30', '09-30', '12-31'].map((e, q) => (
                            <option value={`${startYear + i}-${e}`}>{`${startYear + i}년 ${q + 1}분기`}</option>
                          ))
                        )}
                    </Form.Control>
                  ) : (
                    <Form.Control as="select" name="end" value={newTerm.end} onChange={handleDateChange} required>
                      <option value="">-선택-</option>
                      {Array(endYear - startYear + 1)
                        .fill()
                        .map((_, i) => (
                          <option value={`${startYear + i}-12-31`}>{`${startYear + i}년`}</option>
                        ))}
                    </Form.Control>
                  )}
                </Form.Group>
              </Row>
              <Col className="d-flex justify-content-end">
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
