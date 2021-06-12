package com.compasso.challengeapi.controller;

import com.compasso.challengeapi.exceptions.ExceptionResponse;
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
            ExceptionResponse exceptionResponse = ExceptionResponse.builder().message("Error").status_code(HttpStatus.BAD_REQUEST.value()).build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
        }
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
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/search").buildAndExpand(produtoNovo.getId()).toUri();
//        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(URI.create(null)).body(produtoService.buscarTodosFilter(valorMin, valorMax, q));
    }

    @DeleteMapping("/products/")
    public ResponseEntity deletarProduto(@RequestBody Produto produto) {
        produtoService.deletar(produto);
//        return ResponseEntity.created(URI.create(null));
        return null;
    }
}
