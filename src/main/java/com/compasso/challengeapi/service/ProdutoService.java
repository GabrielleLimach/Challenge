package com.compasso.challengeapi.service;

import com.compasso.challengeapi.model.Produto;

import java.math.BigDecimal;
import java.util.List;

public interface ProdutoService {

    Produto salvar(Produto produto);

    void deletar(Produto produto);

    Produto atualizar(String id, Produto produto);

    List<Produto> buscarTodos();

    Produto buscarPorId(String id);

    List<Produto> buscarTodosFilter(BigDecimal valorMin, BigDecimal valorMax, String q);

}
