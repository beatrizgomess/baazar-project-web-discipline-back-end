package com.infortech.Bazar.controllers;

import com.infortech.Bazar.model.classes.OrgaoDonatario;
import com.infortech.Bazar.model.classes.OrgaoFiscalizador;
import com.infortech.Bazar.model.repositorios.Facade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class OrgaoFiscalizadorRestController {


    @PostMapping("/OrgaoFiscalizador")
    public String create(@RequestBody OrgaoFiscalizador orgaoFiscalizador){
        Facade.getCurrentInstance().createOrgaoFiscalizador(orgaoFiscalizador);

        return "Orgao cadastrado com sucesso!!!";
    }

    @PutMapping("/OrgaoFiscalizador")
    public String update(@RequestBody OrgaoFiscalizador orgaoFiscalizador){
        Facade.getCurrentInstance().updateOrgaoFiscalizador(orgaoFiscalizador);
        return "Alteração Feita!!!";
    }

    @GetMapping("/OrgaoFiscalizador")
    public List<OrgaoFiscalizador> readAll(){
        return Facade.getCurrentInstance().readAllOrgaoFiscalizador();
    }

    @GetMapping("OrgaoFiscalizador/{id}")
    public OrgaoFiscalizador read(@PathVariable("id") int id){
        return Facade.getCurrentInstance().readOrgaoFiscalizadorById(id);

    }

    @DeleteMapping("OrgaoFiscalizador/{id}")
    public String delete(@PathVariable("id") int id){
        Facade.getCurrentInstance().deleteOrgaoFiscalizadorById(id);
        return "Orgão deletado com sucesso!!";

    }

}
