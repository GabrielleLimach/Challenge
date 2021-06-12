package com.compasso.challengeapi.repository;

import com.compasso.challengeapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, String>{

    List<Produto> findProdutoByNameOrAndDescription(String name, String description);

    List<Produto> findProdutoByPriceBetween(BigDecimal valorMin, BigDecimal valorMax);



}
