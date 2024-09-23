import { Route, Routes } from "react-router-dom";
import "./MainRoute.css";
import { Page404 } from "../../Pages/Page404/Page404";
import { AddChore } from "../../Pages/AddChore/AddChore";
import { ChoreList } from "../../Pages/ChoreList/ChoreList";
import { EditChore } from "../../Pages/EditChore/EditChore";
import { ConfirmDelete } from "../../Pages/ConfirmDelete/ConfirmDelete";
import { ConfirmUpdate } from "../../Pages/ConfirmUpdate/ConfirmUpdate";
import { ChoreAdded } from "../../Pages/ChoreAdded/ChoreAdded";

export function MainRoute(): JSX.Element {
    return (
        <div className="MainRoute">
			<Routes>
                <Route path="/add" element={<AddChore/>}/>
                <Route path="/getAll" element={<ChoreList/>}/>
                <Route path="/edit/:id"  element={<EditChore />}/>
                <Route path="/update"  element={<ConfirmUpdate />}/>
                <Route path="/delete/:id"  element={<ConfirmDelete />}/>
                <Route path="/choreAdded" element={<ChoreAdded/>}/>
                <Route path="*" element={<Page404/>}/>
            </Routes>
        </div>
    );
}
