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

const App = () => {
  return (
    <div className="App wrapper">
      <BrowserRouter>
        <AppHeader />
        <Navigation />
        <Container>
          <Routes>
            <Route path="/" element={<Home />}></Route>
            <Route path="/example" element={<Example />}></Route>
            <Route path="/loan" element={<Loan />}></Route>
            <Route path="/deposit" element={<Deposit />}></Route>
            <Route path="/income" element={<Income />}></Route>
            <Route path="/financial" element={<Financial />}></Route>
          </Routes>
        </Container>
        <Footer />
      </BrowserRouter>
    </div>
  );
};

export default App;
