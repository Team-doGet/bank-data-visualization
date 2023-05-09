import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Container } from 'react-bootstrap';
import AppHeader from './component/Header';
import Navigation from './component/Navigation';
import Example from './page/Example';
import Home from './page/Home';
import Loan from './page/Loan';
import Financial from './page/Financial';
import Deposit from './page/Deposit';
import Income from './page/Income';
import Footer from './component/Footer';
import { useEffect, useState } from 'react';
import API_ROOT from './data/API_ROOT';

const App = () => {
  const [bankCode, setbankCode] = useState(10452);
  const [bankInfo, setBankInfo] = useState({
    name: '',
    loanDate: { min: '1900-01-01', max: '1900-01-01' },
    depositDate: { min: '1900-01-01', max: '1900-01-01' },
    incomeDate: { min: '1900-01-01', max: '1900-01-01' },
    financialDate: { min: '1900-01-01', max: '1900-01-01' },
  });
  const fetchData = async () => {
    try {
      // const url = `api/bank/info.json`;
      const url = `${API_ROOT}/bank/info?bankCode=${bankCode}`;
      const response = await fetch(url);
      const data = await response.json();
      setBankInfo({
        ...bankInfo,
        ...data,
      });
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    fetchData();
  }, [bankCode]);
  return (
    <div className="App wrapper">
      <BrowserRouter>
        <AppHeader />
        <Navigation setbankCode={setbankCode} />
        <Container>
          <Routes>
            <Route path="/" element={<Home bankCode={bankCode} API_ROOT={API_ROOT} />}></Route>
            <Route path="/example" element={<Example />}></Route>
            <Route
              path="/loan"
              element={<Loan bankCode={bankCode} API_ROOT={API_ROOT} baseDate={bankInfo.loanDate} />}
            ></Route>
            <Route
              path="/deposit"
              element={<Deposit bankCode={bankCode} API_ROOT={API_ROOT} baseDate={bankInfo.depositDate} />}
            ></Route>
            <Route
              path="/income"
              element={<Income bankCode={bankCode} API_ROOT={API_ROOT} baseDate={bankInfo.incomeDate} />}
            ></Route>
            <Route
              path="/financial"
              element={<Financial bankCode={bankCode} API_ROOT={API_ROOT} baseDate={bankInfo.financialDate} />}
            ></Route>
          </Routes>
        </Container>
        <Footer />
      </BrowserRouter>
    </div>
  );
};

export default App;
