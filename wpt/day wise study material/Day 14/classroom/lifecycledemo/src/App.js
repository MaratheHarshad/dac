import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import Header from "./components/Header";
import MainNavBar from "./components/MainNavBar";
import Footer from "./components/Footer";

import { Route, Routes } from "react-router-dom";
import Discussion from "./pages/Discussion";
import Demos from "./pages/Demos";

function App() {
  return (
    <div className="App">
      <Header />
      <MainNavBar />
      <Routes>
        <Route path="/discussion" element={<Discussion></Discussion>} />
        <Route path="/demo" element={<Demos></Demos>} />
      </Routes>
      <Footer />
    </div>
  );
}

export default App;
