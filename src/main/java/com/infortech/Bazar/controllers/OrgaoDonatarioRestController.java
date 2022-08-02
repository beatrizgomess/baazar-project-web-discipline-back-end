package com.infortech.Bazar.controllers;

import com.infortech.Bazar.model.classes.OrgaoDonatario;
import com.infortech.Bazar.model.repositorios.Facade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrgaoDonatarioRestController {
    Facade facade = new Facade();
    @PostMapping("/OrgaoDonatario")
    public String create(@RequestBody OrgaoDonatario orgaoDonatario){
        Facade.getCurrentInstance().createOrgaoDonatario(orgaoDonatario);
        return "Orgao Donatario Cadastrado com sucesso";
    }


    @PutMapping("/OrgaoDonatario")
    public String update(@RequestBody OrgaoDonatario orgaoDonatario){
        Facade.getCurrentInstance().updateOrgaoDonatario(orgaoDonatario);
        return "Alteração Feita!!!";
    }


    @GetMapping("/OrgaoDonatario")
    public List<OrgaoDonatario> readAll(){
        return Facade.getCurrentInstance().readAllOrgaoDonatario();
    }


    @GetMapping("OrgaoDonatario/{id}")
    public OrgaoDonatario read(@PathVariable("id") int id){
        return Facade.getCurrentInstance().readOrgaoDonatarioById(id);

    }

    @DeleteMapping("OrgaoDonatario/{id}")
    public String delete(@PathVariable("id") int id){
        Facade.getCurrentInstance().deleteOrgaoDonatarioById(id);
        return "Orgão deletado com sucesso!!";

    }


}
