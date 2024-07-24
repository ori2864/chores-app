package com.ori.chores.Services;

import com.ori.chores.Beans.Chore;
import com.ori.chores.Beans.Responsible;
import com.ori.chores.Repositories.ChoreRepo;
import com.ori.chores.Repositories.ResponsibleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChoreService {
    private final ChoreRepo choreRepo;
    private final ResponsibleRepo responsibleRepo;

/*      add chore
        set chore-done
        list - done chores
        list - undone chores
 */
    public void addChore (Chore chore){
        Responsible responsible = chore.getResponsible();
        if (responsible != null && responsible.getId() == 0) {
            responsible.setId(null); // Mark as new entity
            responsibleRepo.save(responsible);
            chore.setResponsible(responsibleRepo.findByName(responsible.getName()));
        }
            choreRepo.save(chore);
    }
    public void updateChore(Chore chore) throws Exception {
        if (choreRepo.findById(chore.getId()).isPresent()) {
            choreRepo.saveAndFlush(chore);
        }
        else throw new Exception("chore not found with this id");
    }
    public void deleteChore (Integer id) throws Exception {
        if (choreRepo.findById(id).isPresent()){
        choreRepo.deleteById(id);
        }
        else throw new Exception("chore not found with this id");
    }

    public void setChoreDone(Integer id) throws Exception {
        if (choreRepo.findById(id).isPresent()){
            Chore chore = choreRepo.findById(id).get();
            chore.setIsDone(true);
            chore.setDoneDate(Date.valueOf(LocalDate.now()));
            choreRepo.saveAndFlush(chore);
        }
        else throw new Exception("chore not found with this id");
    }
    public Chore getSingleChore(int id) throws Exception {
        if (choreRepo.findById(id).isPresent()){
        return choreRepo.findById(id).get();
        }
        else throw new Exception("chore not found with this id");
    }
    public List<Chore>getAllChores(){
        System.out.println("get all called");
        return choreRepo.findAll();
    }

    public List<Chore>getDoneChores(){
        return choreRepo.findByIsDoneTrue();
    }

    public List<Chore>getUnDoneChores(){
        return choreRepo.findByIsDoneFalse();
    }

    public List<Chore>getChoresDue(Date dueDate){
        return choreRepo.findByEndDateBefore(dueDate);
    }

    public Chore findChoreByName (String name) throws Exception {
        if (choreRepo.findByChoreName(name)!=null){
            return choreRepo.findByChoreName(name);
        }
        throw new Exception("chore not found by this name");
    }




}
