package br.com.hairstyle.repository;


import br.com.hairstyle.model.HairdresserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HairdresserRepository extends JpaRepository<HairdresserModel, Integer> {

    public List<HairdresserModel> findByNameContainsIgnoreCaseOrderByName(String name);

}
