package com.compasso.challengeapi.controller;

import com.compasso.challengeapi.model.Produto;
import com.compasso.challengeapi.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProdutoRepository produtoRepository;

    @PostMapping
    public Produto criarUmNovoProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @PutMapping("/{id}")
    public List<Produto> criarUmNovoProdutop() {
        return null;
    }

    @GetMapping("/{id}")
    public Produto buscaProdutoPorId() {
        return null;
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/search")
    public List<Produto> listarProdutosFiltrados() {
        return null;
    }

    @DeleteMapping("/products/")
    public List<Produto> deletarProduto() {
        return null;
    }
}
