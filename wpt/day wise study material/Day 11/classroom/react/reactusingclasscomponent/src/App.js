import "./App.css";
import Header from "./components/Header";
import Footer from "./components/Footer";
import CounterClassComponent from "./components/CouterClassComponent";
import CounterFunctionalComponent from "./components/CounterFunctionalComponent";

function App() {
  return (
    <div className="App">
      <Header />
      <CounterClassComponent />
      <CounterFunctionalComponent />
      <Footer />
    </div>
  );
}

export default App;
