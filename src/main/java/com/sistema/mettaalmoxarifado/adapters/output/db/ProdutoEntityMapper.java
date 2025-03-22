package com.sistema.mettaalmoxarifado.adapters.output.db;

import com.sistema.mettaalmoxarifado.domain.model.Produto;

public class ProdutoEntityMapper {

    public static ProdutoEntity toEntity(Produto produto) {
        return new ProdutoEntity(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getQuantidade(),
                produto.getPreco()
        );
    }

    public static Produto toDomain(ProdutoEntity produtoEntity) {
        return new Produto(
                produtoEntity.getId(),
                produtoEntity.getNome(),
                produtoEntity.getDescricao(),
                produtoEntity.getQuantidade(),
                produtoEntity.getPreco()
        );
    }
}