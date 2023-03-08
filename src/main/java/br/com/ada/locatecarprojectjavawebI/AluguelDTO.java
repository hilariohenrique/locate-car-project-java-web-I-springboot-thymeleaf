package br.com.ada.locatecarprojectjavawebI;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AluguelDTO {

    private Long id;
    @NotBlank(message = "É necessário adicionar um veículo.")
    private String veiculo;
    private String cliente;
    private String dataLocacao;
    private String dataDevolucao;
}
