import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import { Routes, Route, Link } from 'react-router-dom'
import TeamDashboard from './pages/TeamDashboard.jsx';
import PlayerList from './pages/PlayerList.jsx';
import Home from './pages/Home.jsx';
import './App.css'
import 'bootstrap/dist/css/bootstrap.css';



function App() {

  return (
    <>
      <Routes>
          <Route path="/" element={<Home />}/>
          <Route path="/team" element={<TeamDashboard/>} />
          <Route path="/players" element={<PlayerList/>} />

      </Routes>

    </>
  )
}

export default App
