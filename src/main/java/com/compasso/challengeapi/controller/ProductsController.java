package com.compasso.challengeapi.controller;

import com.compasso.challengeapi.model.Produto;
import com.compasso.challengeapi.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProdutoRepository produtoRepository;

    @PostMapping
    private ResponseEntity criarUmNovoProduto(@RequestBody Produto produto){
        return null;
    }

    @PutMapping("/{id}")
    private List<Produto> criarUmNovoProduto(){
        return null;
    }

    @GetMapping("/{id}")
    private Produto buscaProdutoPorId(){
        return null;
    }

    @GetMapping
    private List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/search")
    private List<Produto> listarProdutosFiltrados(){
        return null;
    }

    @DeleteMapping("/products/")
    private List<Produto> deletarProduto(){
        return null;
    }
}
