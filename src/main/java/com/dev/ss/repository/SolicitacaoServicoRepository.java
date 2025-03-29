package com.dev.ss.repository;

import com.dev.ss.domain.SolicitacaoServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitacaoServicoRepository extends JpaRepository<SolicitacaoServico, Long> {

    List<SolicitacaoServico> findByClienteNome(String clienteNome);

}
