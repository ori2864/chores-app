import axios from "axios";
import "./ConfirmDelete.css";
import { useNavigate, useParams } from "react-router-dom";
import notify from "../../util/notify";

export function ConfirmDelete(): JSX.Element {
    const navigate = useNavigate();
    const params=useParams();
    return (
        <div className="ConfirmDelete">
			<h1>Are you sure you want to delete this chore?</h1>
            <input type="button" value="yes" onClick={()=>{
                console.log(params.id)
              axios.delete(`http://localhost:8080/chores/delete/${params.id}`).then(()=>{
              notify.success("chore deleted")
            navigate("/getAll")
            });
            }
            } />
            <input type="button" value="no" onClick={()=>{
                navigate("/getAll")}} />
        </div>
    );
}
