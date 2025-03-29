package com.dev.ss.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class SolicitacaoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clienteNome;

    private String endereco;

    private String tipoServico; //  "Instalação", "Manutenção"

    private String status; //  "PENDENTE", "EM ANDAMENTO", "FINALIZADO"

    private LocalDateTime dataSolicitacao;

    private LocalDateTime dataConclusao;

}
