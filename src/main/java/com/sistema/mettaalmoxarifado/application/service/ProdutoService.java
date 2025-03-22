package com.sistema.mettaalmoxarifado.application.service;

import com.sistema.mettaalmoxarifado.domain.model.Produto;
import com.sistema.mettaalmoxarifado.domain.ports.ProdutoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepositoryPort produtoRepository;

    public ProdutoService(ProdutoRepositoryPort produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.salvar(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.buscarTodos();
    }

    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.buscarPorId(id);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deletar(id);
    }
}