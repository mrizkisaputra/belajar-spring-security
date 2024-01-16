package com.mrizkisaputra.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity(name = "majors")
public class Major {
    @Id
    @NotNull
    private String id;

    @NotNull
    private String name;

    public Major() { }
}
