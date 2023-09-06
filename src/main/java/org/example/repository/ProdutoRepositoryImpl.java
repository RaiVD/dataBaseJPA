package org.example.repository;
import org.example.model.ProdutoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final EntityManager entityManager;

    @Autowired
    public ProdutoRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public ProdutoModel criarProduto(ProdutoModel produto) {
        entityManager.persist(produto);
        return produto;
    }

    @Override
    public ProdutoModel recuperarProdutoPorId(Long id) {
        return entityManager.find(ProdutoModel.class, id);
    }

    @Override
    public ProdutoModel atualizarProduto(ProdutoModel produto) {
        return entityManager.merge(produto);
    }

    @Override
    public void excluirProduto(Long id) {
        ProdutoModel produto = entityManager.find(ProdutoModel.class, id);
        if (produto != null) {
            entityManager.remove(produto);
        }
    }
}

