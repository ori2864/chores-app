package com.ori.chores.Repositories;

import com.ori.chores.Beans.Responsible;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponsibleRepo extends JpaRepository<Responsible,Integer> {
    Responsible findByName(String name);
}
