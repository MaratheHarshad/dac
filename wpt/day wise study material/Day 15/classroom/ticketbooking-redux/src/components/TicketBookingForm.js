import React, { useState } from "react";
import { cancellationbooking, newbooking } from "../redux/action/bookingaction";
import { useDispatch } from "react-redux";

function TicketBookingForm() {
  const dispatch = useDispatch();

  // state for form details

  const [formdetails, setformdetails] = useState({
    id: "",
    name: "",
    amount: "",
  });

  const handlechange = (event) => {
    const { name, value } = event.target;
    setformdetails({ ...formdetails, [name]: value });
  };

  // bookticket functionality
  const bookticket = () => {
    let action1 = newbooking(
      formdetails.id,
      formdetails.name,
      formdetails.amount
    );
    dispatch(action1);
    setformdetails({ id: "", name: "", amount: "" });
  };

  const cancelbooking = () => {
    let action1 = cancellationbooking(
      formdetails.id,
      formdetails.name,
      formdetails.amount
    );
    dispatch(action1);
    setformdetails({ id: "", name: "", amount: "" });
  };

  return (
    <div>
      <form>
        Id :{" "}
        <input
          type="text"
          name="id"
          id="id"
          value={formdetails.id}
          onChange={handlechange}
        />
        <br></br>
        Name :{" "}
        <input
          type="text"
          name="name"
          id="name"
          value={formdetails.name}
          onChange={handlechange}
        />
        <br />
        Amount :{" "}
        <input
          type="text"
          name="amount"
          id="amount"
          value={formdetails.amount}
          onChange={handlechange}
        />
        <button type="button" name="btn" id="booking" onClick={bookticket}>
          Book Ticket
        </button>
        <button type="button" name="btn" id="cancel" onClick={cancelbooking}>
          Cancel Ticket
        </button>
      </form>
    </div>
  );
}

export default TicketBookingForm;
