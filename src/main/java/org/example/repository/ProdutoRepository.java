package org.example;

import org.example.model.ProdutoModel;

public interface ProdutoRepository {
    ProdutoModel save(ProdutoModel produto);
    ProdutoModel findById(Long id);
    void delete(ProdutoModel produto);
}


