package br.com.ada.locatecarprojectjavawebI.service;

import br.com.ada.locatecarprojectjavawebI.model.Aluguel;
import br.com.ada.locatecarprojectjavawebI.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
