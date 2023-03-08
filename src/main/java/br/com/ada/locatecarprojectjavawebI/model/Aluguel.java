package br.com.ada.locatecarprojectjavawebI.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "alugueis_tb")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
    private String veiculo;
    private String cliente;
    private String dataLocacao;
    private String dataDevolucao;

}
