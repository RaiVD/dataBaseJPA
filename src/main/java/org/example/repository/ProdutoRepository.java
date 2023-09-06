package org.example.repository;

import org.example.model.ProdutoModel;

public interface ProdutoRepository {
    ProdutoModel criarProduto(ProdutoModel produto);
    ProdutoModel recuperarProdutoPorId(Long id);
    ProdutoModel atualizarProduto(ProdutoModel produto);
    void excluirProduto(Long id);
}



