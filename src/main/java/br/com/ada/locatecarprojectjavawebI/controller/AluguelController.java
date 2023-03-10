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
    public String alugueis(Model model) {
        List<Aluguel> alugueis = this.aluguelService.listarAlugueis();
        model.addAttribute("alugueis", alugueis);
        return "alugueis";

    }

    @GetMapping("/aluguel/add")
    public String adicionarAluguel(Model model) {
        model.addAttribute("add", Boolean.TRUE);
        model.addAttribute("aluguel", new Aluguel());
        return "aluguel-add";
    }

    @PostMapping("/aluguel/add")
    public String criarAluguel(@ModelAttribute("aluguel") Aluguel aluguel) {
        this.aluguelService.criarAluguel(aluguel);
        return "redirect:/alugueis";
    }

    @GetMapping("/aluguel/{aluguelId}/delete")
    public String deletarAluguel(@PathVariable("aluguelId") Long aluguelId) {
        this.aluguelService.deleteById(aluguelId);
        return "redirect:/alugueis";
    }

    @GetMapping("/aluguel/{aluguelId}/edit")
    public String telaEditarAluguel(Model model, @PathVariable("aluguelId") Long aluguelId) {
        Optional<Aluguel> optionalAluguel = this.aluguelService.buscarPorId(aluguelId);
        optionalAluguel.ifPresent(aluguel -> model.addAttribute("aluguel", aluguel));
        model.addAttribute("add", Boolean.FALSE);
        return "aluguel-add";
    }

    @PutMapping("/aluguel/{aluguelId}/edit")
    public String editarAluguel(@ModelAttribute("aluguel") Aluguel aluguel,
                                @PathVariable("aluguelId") Long aluguelId){
        aluguel.setId(aluguelId);
        this.aluguelService.criarAluguel(aluguel);
        return "redirect:/alugueis";

    }

}