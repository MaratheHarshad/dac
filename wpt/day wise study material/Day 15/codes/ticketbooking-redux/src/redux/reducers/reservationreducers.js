export const manageReservation=(oldreservation=[],action)=>{
    switch(action.type){
        case "newbooking":
            return [...oldreservation,{...action.payload}];
        case "cancelbooking":
            return oldreservation.filter(ob=>ob.id!==action.payload.id);
        default:
            return oldreservation;
    }
}

export const manageCancellation=(oldcancellation=[],action)=>{
    switch(action.type){
        case "cancelbooking":
            //to calculate refund amount
            return [...oldcancellation,{...action.payload}]
        default:
            return oldcancellation;
    }
}
export const manageamount=(amount=3000,action)=>{
    switch(action.type){
        case "newbooking":
            return amount+parseFloat(action.payload.amt)
        case "cancelbooking":
            return amount-parseFloat(action.payload.amt)
        default:
            return amount;
    }
}