package br.com.ada.locatecarprojectjavawebI.controller;

import br.com.ada.locatecarprojectjavawebI.rest.dto.AluguelDTO;
import br.com.ada.locatecarprojectjavawebI.model.Aluguel;
import br.com.ada.locatecarprojectjavawebI.service.AluguelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @PostMapping("/criarAluguel")
    public ResponseEntity<String> createAluguel(@Valid @RequestBody AluguelDTO aluguelDTO) {
        try {
            Aluguel aluguelDB = Aluguel.builder()
                    .veiculo(aluguelDTO.getVeiculo())
                    .cliente(aluguelDTO.getCliente())
                    .dataLocacao(aluguelDTO.getDataLocacao())
                    .dataDevolucao(aluguelDTO.getDataDevolucao())
                    .build();
            this.aluguelService.criarAluguel(aluguelDB);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Aluguel criado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/listarTodos")
    public List<Aluguel> listarAlugueis() {
        return this.aluguelService.listarAlugueis();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Aluguel> buscarAluguel(@PathVariable("id") Long id) {
        Optional<Aluguel> optionalAluguel = this.aluguelService.buscarPorId(id);

        if (optionalAluguel.isPresent()) {
            return ResponseEntity.ok(optionalAluguel.get());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateAluguel(@RequestBody AluguelDTO aluguelDTO) {
        try {
            Optional<Aluguel> optionalAluguel = this.aluguelService.buscarPorId(aluguelDTO.getId());
            if (optionalAluguel.isPresent() &&
                    aluguelDTO.getCliente().equals(optionalAluguel.get().getCliente()) &&
                    aluguelDTO.getDataLocacao().equals(optionalAluguel.get().getDataLocacao())) {
                Aluguel aluguelDB = optionalAluguel.get();
                Aluguel aluguelUpdate = Aluguel.builder().id(aluguelDB.getId())
                        .veiculo(aluguelDTO.getVeiculo())
                        .cliente(aluguelDTO.getCliente())
                        .dataLocacao(aluguelDTO.getDataLocacao())
                        .dataDevolucao(aluguelDTO.getDataDevolucao())
                        .build();

                this.aluguelService.criarAluguel(aluguelUpdate);
                return ResponseEntity.ok("Aluguel atualizado com sucesso.");
            }
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public void deleteAluguel(@PathVariable Long id) {
        this.aluguelService.deleteById(id);
    }
}
