package com.dev.ss.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class SolicitacaoServicoPostRequestBody {

    @NotEmpty(message = "Nome deve ser informado")
    @NotNull(message = "Nome deve ser informado")
    private String clienteNome;

    private String endereco;

    private String tipoServico;

    private String status;
}
