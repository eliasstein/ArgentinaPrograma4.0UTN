package com.proyecto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name="DIRECCION")
@Setter
@Getter
@NoArgsConstructor
public class Direccion implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @OneToOne(mappedBy="direccionLaboral")
    private Empleado empleado;

    @Column(name="calle")
    private String calle;

    @Column(name="localidad")
    private String localidad;

}