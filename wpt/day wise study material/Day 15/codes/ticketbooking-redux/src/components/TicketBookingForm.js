import React,{useState} from 'react'
import { newbooking,cancellationbooking } from '../redux/action/bookingaction';
import {useDispatch} from 'react-redux';

export default function TicketBookingForm
() {
    const [formdetails,setformdetails] = useState({id:"",name:"",amount:""});
    const dispatch=useDispatch();
    const handlechange=(event)=>{
       let {name,value}=event.target;
       setformdetails({...formdetails,[name]:value});
    }
    const bookticket=()=>{
       let action1=newbooking(formdetails.id,formdetails.name,formdetails.amount); 
       dispatch(action1);
    }
    const cancelBooking=()=>{
        let action1=cancellationbooking(formdetails.id,formdetails.name,formdetails.amount); 
       dispatch(action1);
    }
  return (
    <div>
        <form>
            Id :<input type="text" name="id" id="id"
            value={formdetails.id}
            onChange={handlechange}></input><br></br>
            Name : <input type="text" name="name" id="name"
            value={formdetails.name}
            onChange={handlechange}></input><br></br>
            Amount : <input type="text" name="amount" id="amount"
            value={formdetails.amount}
            onChange={handlechange}></input><br></br>
            <button type="button" name="btn" id="booking" onClick={bookticket}>Book Ticket</button>
            <button type="button" name="btn" id="cancel" onClick={cancelBooking}>cancel Ticket</button>
        </form>
    </div>
  )
}
