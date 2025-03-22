package com.sistema.mettaalmoxarifado.adapters.output.db;

import com.sistema.mettaalmoxarifado.domain.model.Produto;
import com.sistema.mettaalmoxarifado.domain.ports.ProdutoRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProdutoRepositoryAdapter implements ProdutoRepositoryPort {

    private final ProdutoJpaRepository jpaRepository;

    public ProdutoRepositoryAdapter(ProdutoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Produto salvar(Produto produto) {
        ProdutoEntity entity = ProdutoEntityMapper.toEntity(produto);
        ProdutoEntity savedEntity = jpaRepository.save(entity);
        return ProdutoEntityMapper.toDomain(savedEntity);
    }

    @Override
    public List<Produto> buscarTodos() {
        return jpaRepository.findAll()
                .stream()
                .map(ProdutoEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Produto buscarPorId(Long id) {
        return jpaRepository.findById(id)
                .map(ProdutoEntityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public void deletar(Long id) {
        jpaRepository.deleteById(id);
    }
}