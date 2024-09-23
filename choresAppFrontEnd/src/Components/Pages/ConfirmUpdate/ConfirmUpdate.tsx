import { useNavigate } from "react-router-dom";
import "./ConfirmUpdate.css";
import axios from "axios";
import notify from "../../util/notify";

export function ConfirmUpdate(): JSX.Element {
    const navigate = useNavigate();
    let updateString = sessionStorage.getItem("update");
    console.log(updateString)
    return (
        <div className="ConfirmUpdate">
			<h1>Are you sure you want to update this chore?</h1>
            <input type="button" value="yes" onClick={()=>{
                if(updateString!=null){
                    updateString=JSON.parse(updateString)
                    console.log(updateString)
                    axios.put(`http://localhost:8080/chores/update`, updateString).then(()=>{
                        notify.success("chore updated");
            navigate("/getAll")
        })
                }

            }
            }/>
            <input type="button" value="no" onClick={()=>{
                navigate("/getAll")}} />
        </div>
        
    );
}
