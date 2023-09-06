package org.example.repository;

import org.example.model.ProdutoModel;
import org.example.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    @Transactional
    public ProdutoModel criarProduto(String nome, double preco) {
        if (nome == null || nome.isEmpty() || preco < 0) {
            throw new IllegalArgumentException("Nome inválido ou preço negativo.");
        }

        ProdutoModel novoProduto = new ProdutoModel();
        novoProduto.setNome(nome);
        novoProduto.setPreco(preco);

        return produtoRepository.criarProduto(novoProduto);
    }

    @Override
    @Transactional(readOnly = true)
    public ProdutoModel recuperarProdutoPorId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }

        return produtoRepository.recuperarProdutoPorId(id);
    }

    @Override
    @Transactional
    public ProdutoModel atualizarProduto(Long id, String novoNome, double novoPreco) {
        if (id == null || id <= 0 || novoNome == null || novoNome.isEmpty() || novoPreco < 0) {
            throw new IllegalArgumentException("ID inválido, nome inválido ou preço negativo.");
        }

        ProdutoModel produtoExistente = produtoRepository.recuperarProdutoPorId(id);
        if (produtoExistente == null) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }

        produtoExistente.setNome(novoNome);
        produtoExistente.setPreco(novoPreco);

        return produtoRepository.atualizarProduto(produtoExistente);
    }

    @Override
    @Transactional
    public void excluirProduto(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }

        ProdutoModel produtoExistente = produtoRepository.recuperarProdutoPorId(id);
        if (produtoExistente == null) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }

        produtoRepository.excluirProduto(id);
    }
}



