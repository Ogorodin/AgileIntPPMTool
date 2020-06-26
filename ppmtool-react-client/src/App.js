import React from "react";
import "./App.css";
import Dashboard from "./components/Dashboard";
import Header from "./components/layout/Header";
import "bootstrap/dist/css/bootstrap.min.css";
import ProjectItem from "./components/project/ProjectItem";

function App() {
  return (
    <div className="App">
      <Header />
      <Dashboard />
      <ProjectItem />
    </div>
  );
}

export default App;
