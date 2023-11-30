package com.proyecto.services;
import com.proyecto.entities.Empleado;
import com.proyecto.repositories.EmpleadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements BaseService<Empleado>{

    //@Autowired
    private EmpleadoRepository empleadoRepository;

    //En caso de no usar el autowired de arriba hay que crear un constructor
    public EmpleadoService(EmpleadoRepository empleadoRepository){
        this.empleadoRepository=empleadoRepository;
    }

    @Override
    @Transactional
    public List<Empleado> findAll() throws Exception {
        try{
            List<Empleado> entities = empleadoRepository.findAll();
            return entities;
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    @Transactional
    public Empleado findById(int id) throws Exception {
        try{
            Optional<Empleado> entityOptional = empleadoRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Empleado save(Empleado entity) throws Exception {
        try{
            entity = empleadoRepository.save(entity);
            return entity;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Empleado update(int id, Empleado entity) throws Exception {
        try{
            Optional<Empleado> entityOptional = empleadoRepository.findById(id);
            Empleado empleado = entityOptional.get();
            empleado = empleadoRepository.save(entity);
            return empleado;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(int id) throws Exception {
        try{
            if (empleadoRepository.existsById(id)){
                empleadoRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
