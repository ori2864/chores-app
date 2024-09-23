import { useState } from "react";
import { Chore } from "../../Models/Chore";
import "./SingleChore.css";
import { useNavigate } from "react-router-dom";
import { EditChore } from "../EditChore/EditChore";

export function SingleChore(props:Chore): JSX.Element {
    const navigate = useNavigate();
    
    // function checkNull(item:any){
    //     return item.isDone&&item != null && item
    // }
      
    
        //  {props.doneDate} 
            /* {props.doneDate != null &&props.doneDate.toString()}  */
            /* {checkNull(props.doneDate)}           */
    
    return (
        <>
        
                <tr  onClick={() =>navigate(`/edit/${props.id}`) }>
                </tr>
                <tr  onClick={() =>navigate(`/edit/${props.id}`) }>
                <td>
                {props.id}
                </td>
                
                <td>
                {props.choreName}
                </td>
               
                
                <td>
                {`responsible name: ${props.responsible.name}`} <br />
                </td>
                
                <td>
                {`ends at: ${props.endDate}`}<br />
                </td>
                
                <td>
                {props.isDone?"chore is done":"chore not done"} <br />
                </td>
            </tr>
        
        
			
            
        </>
            
            
           
        
    );
}
