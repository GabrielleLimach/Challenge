package com.compasso.challengeapi.controller;

import com.compasso.challengeapi.model.Produtcs;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductsController {

    @GetMapping("products")
    private List<Produtcs> recuperarTodos(){
        return null;
    }
}
