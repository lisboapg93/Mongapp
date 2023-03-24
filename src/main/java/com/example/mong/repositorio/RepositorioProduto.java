package com.example.mong.repositorio;

import com.example.mong.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioProduto extends MongoRepository<Produto, String> {


}
