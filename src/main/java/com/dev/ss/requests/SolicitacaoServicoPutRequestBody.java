package com.dev.ss.requests;

import lombok.Data;

@Data
public class SolicitacaoServicoPutRequestBody {

    private Long id;
    private String clienteNome;
    private String endereco;
    private String tipoServico;
    private String status;
}
