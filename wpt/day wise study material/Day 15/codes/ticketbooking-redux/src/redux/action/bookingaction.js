export const newbooking=(id,name,amt)=>{
    return{
        type:"newbooking",
        payload:{
            id,name,amt
        }
    }

}

export const cancellationbooking=(id,name,amt)=>{
    return{
        type:"cancelbooking",
        payload:{
            id,name,amt
        }
    }

}