package br.com.ada.locatecarprojectjavawebI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "alugueis_tb")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
    @NotEmpty(message = "*Campo de preenchimento obrigatório")
    @NotBlank(message = "*Campo vazio")
    private String veiculo;
    @NotEmpty(message = "*Campo de preenchimento obrigatório")
    @NotBlank(message = "*Campo vazio")
    private String cliente;
    @NotEmpty(message = "*Campo de preenchimento obrigatório")
    @NotBlank(message = "*Campo vazio")
    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
}
