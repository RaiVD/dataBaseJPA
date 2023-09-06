package org.example;

import org.example.model.ProdutoModel;
import org.example.service.ProdutoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Configura o contexto do Spring
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Obtém uma instância do ProdutoService
        ProdutoService produtoService = context.getBean(ProdutoService.class);

        // Cria um novo produto
        ProdutoModel novoProduto = produtoService.criarProduto("Produto 1", 19.99);

        // Recupera um produto por ID e imprime seus detalhes
        ProdutoModel produtoRecuperado = produtoService.recuperarProdutoPorId(novoProduto.getId());
        System.out.println("Produto recuperado: " + produtoRecuperado.getNome() + " - Preço: " + produtoRecuperado.getPreco());

        // Atualiza o produto
        produtoService.atualizarProduto(novoProduto.getId(), "Produto Atualizado", 29.99);

        // Recupera o produto atualizado e imprime seus detalhes
        produtoRecuperado = produtoService.recuperarProdutoPorId(novoProduto.getId());
        System.out.println("Produto atualizado: " + produtoRecuperado.getNome() + " - Preço: " + produtoRecuperado.getPreco());

        // Exclui o produto
        produtoService.excluirProduto(novoProduto.getId());

        // Tenta recuperar o produto excluído
        produtoRecuperado = produtoService.recuperarProdutoPorId(novoProduto.getId());
        if (produtoRecuperado == null) {
            System.out.println("Produto não encontrado (foi excluído).");
        }
    }
}

