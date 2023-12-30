import React from 'react'
import { useSelector } from 'react-redux'

export default function DisplayData() {
    let reservationList=useSelector((state)=>state.reservationList)
    let cancellationList=useSelector((state)=>state.cancellationList)
    let amount=useSelector((state)=>state.amount)
  return (
    <div>
    <h2>Reservation List</h2>
    <table border='2'>
       <thead>
         <tr><th>Id</th><th>name</th><th>amount</th></tr>
       </thead>
       <tbody>
        {reservationList.map(ob=><tr key={ob.id}>
        <td>{ob.id}</td>
        <td>{ob.name}</td>
        <td>{ob.amt}</td>
        </tr>)}
     </tbody>
    </table><hr></hr>
    <h2>Cancellation List</h2>
    <table border='2'>
       <thead>
         <tr><th>Id</th><th>name</th><th>amount</th></tr>
       </thead>
       <tbody>
        {cancellationList.map(ob=><tr key={ob.id}>
        <td>{ob.id}</td>
        <td>{ob.name}</td>
        <td>{ob.amt}</td>
        </tr>)}
     </tbody>
    </table>
    <h3>Total Amount : {amount}</h3>

    </div>
  )
}
