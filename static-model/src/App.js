import React from 'react';
import Header from './components/Header';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import GameConsoleView from './components/GameConsoleView';


function App() {
  return (
    <BrowserRouter>
      <Header />
      <GameConsoleView />
    </BrowserRouter>)
}

export default App;
