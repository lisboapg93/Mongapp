package com.example.mong.controller;

import com.example.mong.model.Produto;
import com.example.mong.repositorio.RepositorioProduto;
import com.example.mong.resource.RequisicaoProduto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControleProduto {


    private final RepositorioProduto repositorioProduto;

    public ControleProduto(RepositorioProduto repositorioProduto) {
        this.repositorioProduto = repositorioProduto;
    }

    @GetMapping("/produto")
    public ResponseEntity<List<Produto>> getAllProducts(){

    return ResponseEntity.ok(this.repositorioProduto.findAll());
    }

    @PostMapping("/produto")
    public ResponseEntity<Produto> createProduto(@RequestBody RequisicaoProduto requisicaoProduto){

        Produto produto = new Produto();
        produto.setNome(requisicaoProduto.getNome());
        produto.setDescricao(requisicaoProduto.getDescricao());

        return ResponseEntity.status(201).body(this.repositorioProduto.save(produto));
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity getAllProducts(@PathVariable String id){

        Optional <Produto> produto = this.repositorioProduto.findById(id);

        if (produto.isPresent()){
            return ResponseEntity.ok(produto.get());
        }else{
            return ResponseEntity.ok("O produto com id: " + id + "não foi encontrado!");
        }

        return ResponseEntity.ok(this.repositorioProduto.findAll());
    }
}
