/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Specialty;
import com.example.demo.Repositorio.SpecialtyRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Idiaz
 */
@Service

public class SpecialtyService {
    @Autowired
    private SpecialtyRepository specialtyRepository;
    
    public List<Specialty> getAll(){
        return specialtyRepository.getAll();       
    }
    
    public Optional<Specialty> getSpecialty (int id){
        return specialtyRepository.getSpecialty(id);
    }
    public Specialty save (Specialty specialty){
        if (specialty.getId()== null){
            return specialtyRepository.save(specialty);
        }else{
            Optional<Specialty> specialty1 = specialtyRepository.getSpecialty(specialty.getId());
            if(specialty1.isEmpty()){
                return specialtyRepository.save(specialty);
            }else {
                return specialty;
            }
        }
    }
}
