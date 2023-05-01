import React, { useState } from 'react';
import moment from 'moment';
import PeriodForm from '../component/PeriodForm';

import Bar2 from '../component/Bar2';

const Loan = () => {
  const [term, setTerm] = useState({
    start: moment().subtract(1, 'month').format('YYYY-MM-DD'),
    end: moment().format('YYYY-MM-DD'),
    type: 'monthly',
  });
  return (
    <div>
      <h1>loan</h1>
      <PeriodForm term={term} setTerm={setTerm}></PeriodForm>
      <Bar2 term={term} url="/api/bar2.json"></Bar2>
      <Bar2 term={term} url="/api/bar2_1.json"></Bar2>
    </div>
  );
};

export default Loan;
