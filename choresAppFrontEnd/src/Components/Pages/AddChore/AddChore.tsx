import { SubmitHandler, useForm } from "react-hook-form";
// import { Button, ButtonGroup, Checkbox, MenuItem, Select, TextField, Typography } from "@mui/material";
import { Chore } from "../../Models/Chore";
import "./AddChore.css";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import notify from "../../util/notify";
import { TextField, Button } from "@mui/material";
import { Responsible } from "../../Models/Responsible";
import { useState } from "react";

export function AddChore(): JSX.Element {
    const {register,handleSubmit,formState:{errors}}=useForm<Chore>();
    const navigate = useNavigate();
    let date = Date.now.prototype;
    const [responsible,setResponsible] = useState<Responsible>();
    const [chore,setChore] = useState<Chore>();
    const addChore:SubmitHandler<Chore> = (formChore) => {
            if (formChore) {
                formChore.id=0;
                formChore.doneDate=null;
                formChore.isDone=false;
            const resData = new Responsible(0,formChore.responsible.name,formChore.responsible.phone);
            console.log(resData);
            formChore.responsible=resData;
            
                console.log(formChore)
                
                axios.post(`http://localhost:8080/chores/add`,formChore);
                
                notify.success("chore added");
                navigate("/choreAdded")
            } else {
                throw console.error();
            }
    }
    
    return (
        <div className="AddChore">
            
            <form onSubmit={handleSubmit(addChore)}>
            <TextField label="chore name" variant="outlined" required={true} {...register("choreName")}/><br /><br />
            <input type="Date" {...register("endDate")}/><br /><br />
            <TextField label="responsible name" variant="outlined" {...register("responsible.name")}/><br /><br />
            <TextField label="responsible phone" variant="outlined" {...register("responsible.phone")}/><br /><br />
            <Button type="submit" color="success" style={{ marginRight: 10 }}>Add</Button>
            </form>
			
        </div>
    );
}
