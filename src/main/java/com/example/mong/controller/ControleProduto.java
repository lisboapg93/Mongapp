package com.example.mong.controller;

import com.example.mong.model.Produto;
import com.example.mong.repositorio.RepositorioProduto;
import com.example.mong.resource.RequisicaoProduto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
