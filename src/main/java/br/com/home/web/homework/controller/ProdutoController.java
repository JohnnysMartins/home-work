package br.com.home.web.homework.controller;


import br.com.home.web.homework.domain.Produto;
import br.com.home.web.homework.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @RequestMapping(value = "/allProdutos", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> getAllProdutos(){
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Produto getProduto(@PathVariable("id") Long id){
        return repository.findOne(id);
    }

}