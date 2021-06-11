package com.compasso.challengeapi.controller;

import com.compasso.challengeapi.model.Produtc;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductsController {

    @PostMapping("products")
    private ResponseEntity criarUmNovoProduto(@RequestBody Produtc produtc){
        return null;
    }

    @PutMapping("products/")
    private List<Produtc> criarUmNovoProduto(){
        return null;
    }

    @GetMapping("products/")
    private Produtc buscaProdutoPorId(){
        return null;
    }

    @GetMapping("products")
    private List<Produtc> listarProdutos(){
        return null;
    }

    @GetMapping("products/search")
    private List<Produtc> listarProdutosFiltrados(){
        return null;
    }

    @DeleteMapping("/products/")
    private List<Produtc> deletarProduto(){
        return null;
    }
}
