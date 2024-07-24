package com.ori.chores.Repositories;

import com.ori.chores.Beans.Chore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface ChoreRepo extends JpaRepository<Chore,Integer> {
    public List<Chore>findByIsDoneFalse();
    public List<Chore>findByIsDoneTrue();
    public List<Chore>findByEndDateBefore(Date date);
    public Chore findByChoreName(String name);
}
