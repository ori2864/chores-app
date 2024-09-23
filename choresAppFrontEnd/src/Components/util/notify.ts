import { Notyf } from "notyf";

class Notify{
    private notification = new Notyf({duration:4000, position:{x:"center", y:"top"}});

    //all is ok
    public success(message:string){
        this.notification.success(message);
    }

    //all is bad
    public error(message:string){
        this.notification.error(message);
    }
}

const notify = new Notify();
export default notify;
