import React, { useState } from 'react';
import moment from 'moment';
import PeriodForm from '../component/PeriodForm';

import BarGraph from '../component/BarGraph';

const Loan = () => {
  const [term, setTerm] = useState({
    start: moment().subtract(1, 'month').format('YYYY-MM-DD'),
    end: moment().format('YYYY-MM-DD'),
    type: 'monthly',
  });
  return (
    <div>
      <h1>Loan</h1>
      <PeriodForm term={term} setTerm={setTerm}></PeriodForm>
      <BarGraph term={term} url="/api/loan/customers/type.json"></BarGraph>
      <BarGraph term={term} url="/api/loan/guarantee.json"></BarGraph>
      <BarGraph term={term} url="/api/loan/period.json"></BarGraph>
      <BarGraph term={term} url="/api/loan/interest.json"></BarGraph>
    </div>
  );
};

export default Loan;
