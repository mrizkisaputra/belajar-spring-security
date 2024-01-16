package com.mrizkisaputra.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity(name = "students")
public class Student {
    @Id
    @NotNull
    private String id;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_major", referencedColumnName = "id")
    private Major major;

    public Student() { }
}
