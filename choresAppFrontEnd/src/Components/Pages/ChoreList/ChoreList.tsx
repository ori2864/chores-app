import { useEffect, useState } from "react";
import "./ChoreList.css";
import { Chore } from "../../Models/Chore";
import axios from "axios";
import { SingleChore } from "../SingleChore/SingleChore";

export function ChoreList(): JSX.Element {
    const [chores,setChore] = useState<Chore[]>([]);
     useEffect(() => {
        
        axios.get(`http://localhost:8080/chores/getAll`).then((res)=>{
            
        let getChores = [];
        for(let i=0;i<res.data.length;i++){
            getChores.push(res.data[i])
        }
        setChore(getChores);
            console.log(getChores)

        })

    },[])
    return (
        <div className="ChoreList">
            
            <table>
                
            <th>Chore ID</th>
                <th>Chore</th>
                <th>Responsible</th>
                <th>End Date</th>
                <th>Done/UnDone</th>
            {
                chores.map((item)=><SingleChore key={item.id} id={item.id} choreName={item.choreName} endDate={item.endDate}
                doneDate={item.doneDate} responsible={item.responsible} isDone={item.isDone} />)
             
            }
            </table>        

        </div>
    );
}
