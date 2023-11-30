package com.proyecto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Columns;

import java.io.Serializable;
import java.util.List;
@Entity
@Table(name="Empleado")
@Setter
@Getter
@NoArgsConstructor
public class Empleado implements Serializable {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nombre")
    private String nombre;

    @OneToOne
    @JoinColumn(name="direccion_id",referencedColumnName = "id")
    private Direccion direccionLaboral;

    @ManyToOne
    @JoinColumn(name="sector_id",referencedColumnName = "id")
    private Sector sector;

/*
    @ManyToMany
    @JoinTable(
            name="empleado_rol",
            joinColumns = @JoinColumn(name= "rol_id"),
            inverseJoinColumns = @JoinColumn(name = "empleado_id")
    )

 */

    @ManyToMany(mappedBy="empleados")
    private List<Rol> roles;
    //Fin atributos

    public Empleado(String nombre){
        this.nombre=nombre;
    }



}
