package dio.padroes.projeto.services.impl;

import dio.padroes.projeto.entities.Addresses;
import dio.padroes.projeto.entities.Distributors;
import dio.padroes.projeto.entities.Products;
import dio.padroes.projeto.repositories.AddressesRepository;
import dio.padroes.projeto.repositories.DistributorsRepository;
import dio.padroes.projeto.repositories.ProductsRepository;
import dio.padroes.projeto.services.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Implementação da <b>Strategy</b> {@link ProductsService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 */
@Service
public class ProductsServiceImpl implements ProductsService {

    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private DistributorsRepository distributorsRepository;
    

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Products> findAll() {
        return productsRepository.findAll();
    }

    @Override
    public Products findById(Long id) {
        Optional<Products> product = productsRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public void insert(Products product) {
        insertProductWithDistributor(product);
    }

    @Override
    public void update(Long id, Products product) {
        Optional<Products> productDb = productsRepository.findById(id);
        if (productDb.isPresent()) {
            insertProductWithDistributor(product);
        }
    }

    @Override
    public void delete(Long id) {
        productsRepository.deleteById(id);
    }

    private void insertProductWithDistributor(Products product) {
        List<Distributors> distributorsList = product.getDistributors();
        distributorsList.forEach(this::insertDistributorWithZipCod);
        productsRepository.save(product);
    }

    private void insertDistributorWithZipCod(Distributors distributor) {
        distributorsRepository.save(distributor);
    }

}
