package br.com.ada.locatecarprojectjavawebI.repository;

import br.com.ada.locatecarprojectjavawebI.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

}
