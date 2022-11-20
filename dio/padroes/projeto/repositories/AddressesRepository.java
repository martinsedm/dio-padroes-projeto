package dio.padroes.projeto.repositories;

import dio.padroes.projeto.entities.Addresses;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressesRepository extends CrudRepository<Addresses, String> {

}
