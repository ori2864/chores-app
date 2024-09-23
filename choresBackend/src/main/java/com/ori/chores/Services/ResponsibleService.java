package com.ori.chores.Services;

import com.ori.chores.Beans.Responsible;
import com.ori.chores.Repositories.ResponsibleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResponsibleService {
    private final ResponsibleRepo responsibleRepo;
    public void addResponsible(Responsible resp){
        responsibleRepo.save(resp);
    }
    //micro-service to get responsible from repository
    public Responsible getResponsible(Integer id) throws Exception {
        if (responsibleRepo.findById(id).isPresent()){
            return responsibleRepo.findById(id).get();
        }
        throw new Exception("this responsible does not exist");
    }
}
