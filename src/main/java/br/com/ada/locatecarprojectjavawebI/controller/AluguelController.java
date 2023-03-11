package br.com.ada.locatecarprojectjavawebI.controller;

import br.com.ada.locatecarprojectjavawebI.model.Aluguel;
import br.com.ada.locatecarprojectjavawebI.service.AluguelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @GetMapping("/alugueis")
    public String alugueis(@RequestParam(defaultValue = "1") int page,
                           @RequestParam(defaultValue = "5") int size,
                           Model model) {
        Page<Aluguel> alugueisPaginados = this.aluguelService.listarAlugueisPaginados(page - 1, size);
        model.addAttribute("alugueis", alugueisPaginados.getContent());
        model.addAttribute("totalPages", alugueisPaginados.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageNum", alugueisPaginados.getNumber());
        model.addAttribute("pageSize", alugueisPaginados.getSize());
        return "alugueis";

    }

    @GetMapping("/aluguel/add")
    public String adicionarAluguel(Model model, Aluguel aluguel) {
        model.addAttribute("add", Boolean.TRUE);
        model.addAttribute("aluguel", Objects.nonNull(aluguel) ? aluguel : new Aluguel());
        return "aluguel-add";
    }

    @PostMapping("/aluguel/add")
    public String criarAluguel(@Valid @ModelAttribute("aluguel") Aluguel aluguel,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            return adicionarAluguel(model, aluguel);
        }
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
    public String editarAluguel(@Valid @ModelAttribute("aluguel") Aluguel aluguel,
                                @PathVariable("aluguelId") Long aluguelId,
                                BindingResult result, Model model) {
        System.out.println("PAusa");
        if (result.hasFieldErrors()){
            return "aluguel-add";
        }
        aluguel.setId(aluguelId);
        this.aluguelService.criarAluguel(aluguel);
        return "redirect:/alugueis";

    }

}