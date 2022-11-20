package dio.padroes.projeto.services;

import dio.padroes.projeto.entities.Products;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de produtos. Com
 * isso, se necessário, podemos ter múltiplas implementações dessa mesma
 * interface.
 */
public interface ProductsService {

    Iterable<Products> findAll();

    Products findById(Long id);

    void insert(Products product);

    void update(Long id, Products product);

    void delete(Long id);
}
