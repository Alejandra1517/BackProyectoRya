package com.reformasyacabados.ryaweb.controller;

import com.reformasyacabados.ryaweb.models.Cliente;
import com.reformasyacabados.ryaweb.models.Material;
import com.reformasyacabados.ryaweb.service.ClienteService;
import com.reformasyacabados.ryaweb.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin("*")
public class MaterialesController {

    @Autowired
    private MaterialService materialService;


    @GetMapping("/getMateriales")
    public List<Material> getMateriales() {
        return materialService.listarMateriales();
    }


    @GetMapping("/getMaterialPorId/{id_material}")
    public ResponseEntity<Material> materialById(@PathVariable Integer id_material) {
        try {
            Material material = materialService.obtenerMaterialId(id_material);
            return new ResponseEntity<Material>(material, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Material>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/postMaterial")
    public void saveMaterial(@RequestBody Material material) {
        materialService.guardarMaterial(material);
    }

    @PutMapping("/putMaterial/{id_material}")
    public ResponseEntity<?> updateMaterial(@RequestBody Material material, @PathVariable Integer id_material) {
        try {
            Material materialExiste = materialService.obtenerMaterialId(id_material);
            materialExiste.setNombre_material(material.getNombre_material());
            materialExiste.setProveedor(material.getProveedor());
            materialExiste.setEstado(material.getEstado());
            materialExiste.setFecha_ingreso(material.getFecha_ingreso());
            materialService.guardarMaterial(materialExiste);
            return new ResponseEntity<Material>(material, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Material>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteMaterial/{id_material}")
    public void deleteMaterial(@PathVariable int id_material){
        materialService.eliminarMaterial(id_material);
    }



}
