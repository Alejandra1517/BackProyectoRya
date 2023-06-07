package com.reformasyacabados.ryaweb.service;

import com.reformasyacabados.ryaweb.models.Material;
import com.reformasyacabados.ryaweb.repository.IMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {


    @Autowired
    private IMaterialRepository iMaterialRepository;

    public List<Material> listarMateriales(){
        return iMaterialRepository.findAll();
    }


    public Material obtenerMaterialId(Integer id_material){
        return iMaterialRepository.findById(id_material).get();
    }


    public void guardarMaterial(Material material){
        iMaterialRepository.save(material);
    }


    public void eliminarMaterial(Integer id_material){
        iMaterialRepository.deleteById(id_material);
    }





}
