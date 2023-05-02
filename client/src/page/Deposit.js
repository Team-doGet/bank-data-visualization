import React, { useState } from 'react';
import moment from 'moment';
import BarGraph from '../component/BarGraph';
import PeriodForm from '../component/PeriodForm';

const Deposit = ({ baseDate }) => {
  const [term, setTerm] = useState({
    start: baseDate.min,
    end: baseDate.max,
    type: 'yearly',
  });
  return (
    <div>
      <h1>Deposit</h1>
      <PeriodForm baseDate={baseDate} term={term} setTerm={setTerm} />
      <BarGraph term={term} url="/api/Bar1test.json"></BarGraph>
      <BarGraph term={term} url="/api/Bar1test2.json"></BarGraph>
    </div>
  );
};

export default Deposit;
