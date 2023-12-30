import React from "react";
import { useSelector } from "react-redux";

function DisplayData() {
  // hook
  // whatever the state of that state is fetched using useSelector
  // any time state changes, it automatically re-renders the component
  const reservationList = useSelector((state) => state.reservationList);
  const cancellationList = useSelector((state) => state.cancellationList);
  const amount = useSelector((state) => state.amount);
  return (
    <div>
      <h2>Reservation List</h2>
      <table border="2">
        <thead>
          <th>Id</th>
          <th>Name</th>
          <th>Amount</th>
        </thead>

        <tbody>
          {reservationList.map((ob) => (
            <tr key={ob.id}>
              <td>{ob.id}</td>
              <td>{ob.name}</td>
              <td>{ob.amt}</td>
            </tr>
          ))}
        </tbody>
      </table>

      {/* cancellation list */}

      <h2>Cancellation List</h2>
      <table border="2">
        <thead>
          <th>Id</th>
          <th>Name</th>
          <th>Amount</th>
        </thead>

        <tbody>
          {cancellationList.map((ob) => (
            <tr key={ob.id}>
              <td>{ob.id}</td>
              <td>{ob.name}</td>
              <td>{ob.amt}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default DisplayData;
