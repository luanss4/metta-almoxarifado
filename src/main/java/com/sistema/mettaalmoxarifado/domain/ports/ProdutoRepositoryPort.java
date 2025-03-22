package com.sistema.mettaalmoxarifado.domain.ports;

import com.sistema.mettaalmoxarifado.domain.model.Produto;

import java.util.List;

public interface ProdutoRepositoryPort {
    Produto salvar(Produto produto);

    List<Produto> buscarTodos();

    Produto buscarPorId(Long id);

    void deletar(Long id);
}