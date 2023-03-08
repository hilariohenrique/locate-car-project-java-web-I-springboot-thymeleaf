package br.com.ada.locatecarprojectjavawebI.service;

import br.com.ada.locatecarprojectjavawebI.model.Aluguel;
import br.com.ada.locatecarprojectjavawebI.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<Aluguel> buscarPorId(Long id) {
        return this.aluguelRepository.findById(id);
    }

    public void deleteById(Long id) {
        this.aluguelRepository.deleteById(id);
    }
}
