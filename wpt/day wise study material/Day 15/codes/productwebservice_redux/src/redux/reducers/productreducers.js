const initialstate={
    proddata:[],

}
export const manageprodarr=(state=initialstate,action)=>{
    switch(action.type){
        case "setdata":
            return {...state,proddata:[...action.payload]};
        default:
            return state;
    }

}