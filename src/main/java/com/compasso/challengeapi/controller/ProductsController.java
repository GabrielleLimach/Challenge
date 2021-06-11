package com.compasso.challengeapi.controller;

import com.compasso.challengeapi.model.Produto;
import com.compasso.challengeapi.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> criarUmNovoProduto(@RequestBody Produto produto) {
        return ResponseEntity.created(URI.create(null)).body(produtoService.salvar(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProdutop(@PathVariable("id") String id, @RequestBody Produto produto) {
        return ResponseEntity.ok().body(produtoService.atualizar(id, produto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscaProdutoPorId(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(produtoService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        return ResponseEntity.ok().body(produtoService.buscarTodos());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Produto>> listarProdutosFiltrados(@RequestParam(value = "valorMin", required = false) BigDecimal valorMin, @RequestParam(value = "valorMax", required = false) BigDecimal valorMax, @RequestParam String q) {
        return ResponseEntity.created(URI.create(null)).body(produtoService.buscarTodosFilter(valorMin, valorMax, q));
    }

    @DeleteMapping("/products/")
    public ResponseEntity deletarProduto(@RequestBody Produto produto) {
        produtoService.deletar(produto);
        return ResponseEntity.created(URI.create(null));
    }
}
