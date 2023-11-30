package com.proyecto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="ROL")
@Setter
@Getter
@NoArgsConstructor
public class Rol implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="rol")
    private String rol;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name="empleado_rol",
            joinColumns = @JoinColumn(name= "rol_id"),
            inverseJoinColumns = @JoinColumn(name = "empleado_id")
    )
    List<Empleado> empleados;


}