package com.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.entities.Empleado;
public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {

}
