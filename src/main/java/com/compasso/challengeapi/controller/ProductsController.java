package com.compasso.challengeapi.controller;

import com.compasso.challengeapi.model.enuns.ExceptionResponse;
import com.compasso.challengeapi.model.Produto;
import com.compasso.challengeapi.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity criarUmNovoProduto(@RequestBody Produto produto, HttpServletResponse response) {
        try {
            Produto produtoNovo = produtoService.salvar(produto);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}").buildAndExpand(produtoNovo.getId()).toUri();
            response.setHeader("Location", uri.toASCIIString());
            return ResponseEntity.created(uri).body(produtoNovo);
        }catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ExceptionResponse.POST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarProdutop(@PathVariable("id") String id, @RequestBody Produto produto) {
        try {
            return ResponseEntity.ok().body(produtoService.atualizar(id, produto));
        }catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ExceptionResponse.PUT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity buscaProdutoPorId(@PathVariable("id") String id) {
        try {
            return ResponseEntity.ok().body(produtoService.buscarPorId(id));
        }catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ExceptionResponse.GET);
        }
    }

    @GetMapping
    public ResponseEntity listarProdutos() {
            return ResponseEntity.ok().body(produtoService.buscarTodos());
    }

    @GetMapping("/search")
    public List<Produto> listarProdutosFiltrados(@RequestParam(value = "min_price", required = false) BigDecimal valorMin, @RequestParam(value = "max_price", required = false) BigDecimal valorMax, @RequestParam String q) {
        return produtoService.buscarTodosFilter(valorMin, valorMax, q);
    }

    @DeleteMapping
    public ResponseEntity deletarProduto(@RequestBody Produto produto) {
        try {
            produtoService.deletar(produto);
            return ResponseEntity.ok().body(HttpStatus.OK);
        }catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ExceptionResponse.DELETE);
        }
    }
}
