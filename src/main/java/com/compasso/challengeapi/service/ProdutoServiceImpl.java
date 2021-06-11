package com.compasso.challengeapi.service;

import com.compasso.challengeapi.model.Produto;
import com.compasso.challengeapi.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Override
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void deletar(Produto produto) {
        produtoRepository.delete(produto);
    }

    @Override
    public Produto atualizar(String id, Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto buscarPorId(String id) {
        return produtoRepository.getById(id);
    }

    @Override
    public List<Produto> buscarTodosFilter(BigDecimal valorMin, BigDecimal valorMax, String q) {
//        return produtoRepository.;
        return null;
    }
}
