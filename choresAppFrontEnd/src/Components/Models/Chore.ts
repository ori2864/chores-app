import { Responsible } from "./Responsible";

export class Chore{
    public id:number;
    public choreName:string;
    public endDate:Date;
    public doneDate:Date|null;
    public isDone:Boolean;
    public responsible:Responsible;
    
    constructor( id:number,choreName:string,isDone:Boolean,responsible:Responsible,endDate:Date,doneDate:Date){
            this.id=id;
            this.choreName=choreName;
            if(doneDate!=null){
                this.doneDate=doneDate;
            }else{this.doneDate=null}
            this.endDate=endDate;
            this.isDone=isDone;
            this.responsible=responsible;
        }
       
}
