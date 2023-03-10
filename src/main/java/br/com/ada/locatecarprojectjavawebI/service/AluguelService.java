package br.com.ada.locatecarprojectjavawebI.service;

import br.com.ada.locatecarprojectjavawebI.model.Aluguel;
import br.com.ada.locatecarprojectjavawebI.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {
    @Autowired
    private AluguelRepository aluguelRepository;

    public void criarAluguel(Aluguel aluguel){
        this.aluguelRepository.save(aluguel);
    }

    public List<Aluguel> listarAlugueis() {
        return this.aluguelRepository.findAll();
    }
    public Page<Aluguel> listarAlugueisPaginados(Integer numeroPagina, Integer tamanhoPagina) {
        return this.aluguelRepository.findAll(PageRequest.of(numeroPagina, tamanhoPagina,
                Sort.by(Sort.Order.asc("id"))));
    }

    public Optional<Aluguel> buscarPorId(Long id) {
        return this.aluguelRepository.findById(id);
    }


    public void deleteById(Long id) {
        this.aluguelRepository.deleteById(id);
    }
}
