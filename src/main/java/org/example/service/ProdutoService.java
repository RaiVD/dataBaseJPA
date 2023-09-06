package org.example.service;

import org.example.model.ProdutoModel;

public interface ProdutoService {
    ProdutoModel criarProduto(String nome, double preco);
    ProdutoModel recuperarProdutoPorId(Long id);
    ProdutoModel atualizarProduto(Long id, String novoNome, double novoPreco);
    void excluirProduto(Long id);
}


