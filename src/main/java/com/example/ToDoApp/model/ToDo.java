package com.example.ToDoApp.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table (name = "todo")
public class ToDo {

    @Id
    @GeneratedValue (strategy =  GenerationType.AUTO)
    @Nonnull
    private Long id;

    @Column
    @Nonnull
    private String title;

    @Column
    @Nonnull
    private Date date;

    @Column
    @Nonnull
    private String status;


    public ToDo(){

    };
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
