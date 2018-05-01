package br.com.home.web.homework.controller;


import br.com.home.web.homework.domain.Categoria;
import br.com.home.web.homework.domain.Produto;
import br.com.home.web.homework.repository.CategoriaRepository;
import br.com.home.web.homework.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Produto getProduto(@PathVariable("id") Long id) {
        return produtoRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void saveProduto(@RequestBody Produto produto, @PathVariable("id") Long id) {
        Categoria categoria = categoriaRepository.findOne(id);
        produto.setCategoria(categoria);
        produtoRepository.save(produto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void removeProduto(@PathVariable("id") Long id) {
        produtoRepository.delete(id);
    }
}
