import logo from "./logo.svg";
import "./App.css";
import TicketBookingForm from "./components/TicketBookingForm";
import DisplayData from "./components/DisplayData";
function App() {
  return (
    <div className="App">
      <DisplayData></DisplayData>
      <TicketBookingForm />
    </div>
  );
}

export default App;