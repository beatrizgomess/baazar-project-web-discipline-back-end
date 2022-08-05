package com.infortech.Bazar.controllers;

import com.infortech.Bazar.model.classes.Produto;
import com.infortech.Bazar.model.repositorios.Facade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ProdutoRestController {
    @PostMapping("/Produto")
    public String create(@RequestBody Produto produto){
        Facade.getCurrentInstance().createProduto(produto);
        return "Produto Cadastrado com sucesso";
    }


    @PutMapping("/Produto")
    public String update(@RequestBody Produto produto){
        Facade.getCurrentInstance().updateProduto(produto);
        return "Alteração Feita!!!";
    }

    @GetMapping("/Produto")
    public List<Produto> readAll(){
        return Facade.getCurrentInstance().readAllProduto();
    }

    @GetMapping("Produto/{codigo}")
    public Produto read(@PathVariable("codigo") int codigo){
        return Facade.getCurrentInstance().readProdutoById(codigo);

    }

    @DeleteMapping("Produto/{codigo}")
    public String delete(@PathVariable("codigo") int codigo){
        Facade.getCurrentInstance().deleteProdutoById(codigo);
        return "Produto deletado com sucesso!!";

    }

}
