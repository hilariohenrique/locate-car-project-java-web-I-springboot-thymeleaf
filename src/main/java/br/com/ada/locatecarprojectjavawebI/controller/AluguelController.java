package br.com.ada.locatecarprojectjavawebI.controller;

import br.com.ada.locatecarprojectjavawebI.model.Aluguel;
import br.com.ada.locatecarprojectjavawebI.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;
    @PostMapping("/criarAluguel")
    public void createAluguel(@RequestBody Aluguel aluguel){
        this.aluguelService.criarAluguel(aluguel);
    }

    @GetMapping("/listarTodos")
    public List<Aluguel> listarAlugueis(){
        return this.aluguelService.listarAlugueis();
    }
}
