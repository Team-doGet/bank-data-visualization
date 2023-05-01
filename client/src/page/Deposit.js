import React, { useState } from 'react';
import moment from 'moment';
import BarGraph from '../component/BarGraph';
import PeriodForm from '../component/PeriodForm';

const Deposit = () => {
  const [term, setTerm] = useState({
    start: moment().subtract(1, 'month').format('YYYY-MM-DD'),
    end: moment().format('YYYY-MM-DD'),
    type: 'monthly',
  });

  return (
    <div>
      <h1>Deposit</h1>
      <PeriodForm term={term} setTerm={setTerm}></PeriodForm>
      <BarGraph term={term} url="/api/Bar1test.json"></BarGraph>
      <BarGraph term={term} url="/api/Bar1test2.json"></BarGraph>
    </div>
  );
};

export default Deposit;
