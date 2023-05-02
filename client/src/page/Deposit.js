import React, { useState } from 'react';
import moment from 'moment';
import Bar1 from '../component/Bar1';
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
      <Bar1 term={term} url="/api/Bar1test.json"></Bar1>
      <Bar1 term={term} url="/api/Bar1test2.json"></Bar1>
    </div>
  );
};

export default Deposit;
