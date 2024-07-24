package com.ori.chores.clr;

import com.ori.chores.Beans.Chore;
import com.ori.chores.Beans.Responsible;
import com.ori.chores.Repositories.ResponsibleRepo;
import com.ori.chores.Services.ChoreService;
import com.ori.chores.Services.ResponsibleService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@RequiredArgsConstructor
@Component
@Order(1)
public class AppTester implements CommandLineRunner {
    private final ChoreService choreService;
    private final ResponsibleService respService;

    @Override
    public void run(String... args) throws Exception {
        //==================building 3 responsibles===========================

        Responsible resp1= Responsible.builder()
                .name("ori")
                .phone("972533328546")
                .build();
        Responsible resp2= Responsible.builder()
                .name("tamir")
                .phone("972544428546")
                .build();
        Responsible resp3= Responsible.builder()
                .name("shani")
                .phone("972522228546")
                .build();
        System.out.println("=============== start ===============");

        //==================building 3 chores===========================

        Chore chore1 = Chore.builder()
                .choreName("take out trash")
                .responsible(resp1)
                .endDate(Date.valueOf(LocalDate.now().plusDays(10)))
                .build();
        Chore chore2 = Chore.builder()
                .choreName("clean toilet")
                .responsible(resp2)
                .endDate(Date.valueOf(LocalDate.now().plusDays(14)))
                .build();
        Chore chore3 = Chore.builder()
                .choreName("do dishes")
                .responsible(resp3)
                .endDate(Date.valueOf(LocalDate.now().plusDays(12)))
                .build();


        //========================adding the chores&responsibles===================

        respService.addResponsible(resp1);
        respService.addResponsible(resp2);
        respService.addResponsible(resp3);
        choreService.addChore(chore1);
        choreService.addChore(chore2);
        choreService.addChore(chore3);
        System.out.println("===========added 3 chores=============");


        //======================= setting chore - done ============================
        choreService.setChoreDone(chore1.getId());
        System.out.println("all done chores:\n"+choreService.getDoneChores());
        System.out.println("all undone chores:\n"+choreService.getUnDoneChores());

        System.out.println("all chores before: "
        +Date.valueOf(LocalDate.now().plusDays(13))+"\n"
        +choreService.getChoresDue(Date.valueOf(LocalDate.now().plusDays(13))));



    }
}
