package com.ori.chores.Controllers;

import com.ori.chores.Beans.Chore;
import com.ori.chores.Services.ChoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chores")
@CrossOrigin
public class ChoreController {
    private final ChoreService choreService;


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addChore(@RequestBody Chore chore) {
        choreService.addChore(chore);
    }



    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateChore(@RequestBody Chore chore) throws Exception{
        System.out.println("ssssssss");
        choreService.updateChore(chore);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteChore (@PathVariable Integer id) throws Exception {
        choreService.deleteChore(id);
    }

    @PutMapping("/setDone/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void setChoreDone(@PathVariable Integer id) throws Exception {
        choreService.setChoreDone(id);
    }
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Chore getSingleChore(@PathVariable int id) throws Exception {
        return choreService.getSingleChore(id);
    }
    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Chore> getAllChores() {
        return choreService.getAllChores();
    }

    @GetMapping("/getAll/done")
    @ResponseStatus(HttpStatus.OK)
    public List<Chore> getDoneChores() {
        return choreService.getDoneChores();
    }

    @GetMapping("/getAll/unDone")
    public List<Chore> getUnDoneChores() {
        return choreService.getUnDoneChores();
    }

    @GetMapping("/getAll/due")
    public List<Chore> getChoresDue(Date dueDate) {
        return choreService.getChoresDue(dueDate);
    }

//    @GetMapping("/getAll/Done/{name}")
//    public Chore findChoreByName(@PathVariable String name) throws Exception {
//        return choreService.findChoreByName(name);
//    }
}
