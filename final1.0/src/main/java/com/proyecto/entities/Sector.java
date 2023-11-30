package com.proyecto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="SECTOR")
@Setter
@Getter
@NoArgsConstructor
public class Sector {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="sectorDeTrabajo")
    private String sector;

    @JsonIgnore
    @OneToMany(mappedBy="sector")
    private List<Empleado> empleados;

}