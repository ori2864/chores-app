import { Navigate, useNavigate, useParams } from "react-router-dom";
import { Chore } from "../../Models/Chore";
import "./EditChore.css";
import axios from "axios";
import { useEffect, useState } from "react";
import { error } from "console";
import { SubmitHandler, useForm } from "react-hook-form";
import notify from "../../util/notify";
import { Responsible } from "../../Models/Responsible";

export function EditChore(): JSX.Element {
    const navigate = useNavigate();
    const params = useParams();
    const [chore,setChore]= useState<Chore>();
    function doneButton(){
        if(chore?.isDone===false){
       return( <>
        <button onClick={() => {
            axios.put(`http://localhost:8080/chores/setDone/${params.id}`).then(()=>notify.success("chore set to done"))
        }}>Set Chore - Done</button><br />
        </>
       )
    }else return <>chore is done <br /></>
        
    }
    useEffect(()=>{
                axios.get<Chore>(`http://localhost:8080/chores/get/${params.id}`).then(res=>{
               
                setChore(res.data)
        })
        },)
        
        
        const { register, handleSubmit, formState: { errors } } = useForm<Chore>();

        const update: SubmitHandler<Chore> = (data) => {
            chore!=undefined&&(chore.choreName=data.choreName);
            chore!=undefined&&(chore.endDate=data.endDate);
            let stringData = JSON.stringify(chore)
            sessionStorage.setItem("update",stringData)
            navigate("/update"); 
        }



    return (
        <div className="EditChore">
            <h1>Edit Chore</h1>
            {`chore id: ${chore!=undefined&&chore.id}`}<br />
            {`name: ${chore!=undefined&&chore.choreName}`}<br/>
            {`responsible name: ${chore!=undefined&&chore.responsible.name}`}<br/>
            {doneButton()}


            


            <button onClick={()=>{
                navigate(`/delete/${params.id}`)
            }}>Delete Chore</button>


            <form onSubmit={handleSubmit(update)}>
                Update Chore <br />
                <input type="text" placeholder="enter new name" {...register("choreName")} />
                <input type="date" placeholder="new end date" {...register("endDate")} />
                <input type="submit" value="Update" />
            </form>
            
			
        </div>
    );
}
