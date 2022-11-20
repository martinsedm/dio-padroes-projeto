package dio.padroes.projeto.repositories;

import dio.padroes.projeto.entities.Distributors;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorsRepository extends CrudRepository<Distributors, Long> {

}
