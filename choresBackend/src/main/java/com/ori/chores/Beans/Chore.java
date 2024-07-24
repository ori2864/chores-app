package com.ori.chores.Beans;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Chore {
//    public Chore() {
//        isDone = false;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String choreName;
//    @Column(nullable = false)
    @OneToOne
    private Responsible responsible;
    private Date endDate;
    private Date doneDate;
    @Builder.Default
    private Boolean isDone=false;


}
