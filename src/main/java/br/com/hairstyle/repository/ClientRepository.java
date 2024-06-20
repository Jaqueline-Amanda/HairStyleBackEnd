package br.com.hairstyle.repository;

import br.com.hairstyle.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Integer> {

    public List<ClientModel> findByNameContainsIgnoreCaseOrderByName(String name);

}
