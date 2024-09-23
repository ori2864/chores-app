import { NavLink } from "react-router-dom";
import "./Menu.css";

export function Menu(): JSX.Element {
    return (
        <div className="Menu">
			<NavLink to="/add" >Add A Chore</NavLink>
			<NavLink to="/getAll" >All Chores</NavLink>
        </div>
    );
}
