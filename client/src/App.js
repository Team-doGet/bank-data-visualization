import { Container } from 'react-bootstrap';
import AppHeader from './component/Header';
import Navigation from './component/Navigation';
function App() {
  return (
    <div className="App">
      <AppHeader></AppHeader>
      <Navigation></Navigation>
      <Container></Container>
    </div>
  );
}

export default App;
