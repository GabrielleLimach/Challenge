package com.compasso.challengeapi.service;

import com.compasso.challengeapi.model.Produto;
import com.compasso.challengeapi.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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
            Produto novoProduto = produtoRepository.getById(id);
            BeanUtils.copyProperties(produto,novoProduto, "id");
            return produtoRepository.save(novoProduto);
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
        if (Objects.isNull(q))
            return produtoRepository.findProdutoByPriceBetween(valorMin, valorMax);
        else
            return produtoRepository.findProdutoByNameOrAndDescription(q,q);
    }
}
