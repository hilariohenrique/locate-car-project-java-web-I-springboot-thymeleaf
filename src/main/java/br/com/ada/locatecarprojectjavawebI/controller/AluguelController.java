package br.com.ada.locatecarprojectjavawebI.controller;

import br.com.ada.locatecarprojectjavawebI.model.Aluguel;
import br.com.ada.locatecarprojectjavawebI.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @GetMapping("/alugueis")
    public String alugueis(Model model){
        List<Aluguel> alugueis = this.aluguelService.listarAlugueis();
        model.addAttribute("alugueis",alugueis);

        return "alugueis";

    }
    @GetMapping("/aluguel/add")
    public String adicionarAluguel(Model model){
        model.addAttribute("aluguel", new Aluguel());
        return "aluguel-add";
    }

    @PostMapping("/aluguel/add")
    public String criarAluguel(@ModelAttribute("aluguel") Aluguel aluguel) {
        this.aluguelService.criarAluguel(aluguel);
        return "redirect:/alugueis";
    }

}