package dio.padroes.projeto.repositories;

import dio.padroes.projeto.entities.Products;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Products, Long> {

}
