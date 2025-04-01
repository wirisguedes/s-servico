package com.dev.ss.client;

import com.dev.ss.domain.SolicitacaoServico;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {

        ResponseEntity<SolicitacaoServico> entity = new RestTemplate().getForEntity("http://localhost:8080/solicitacoes/{id}", SolicitacaoServico.class, 2);

        log.info(entity);

        SolicitacaoServico object = new RestTemplate().getForObject("http://localhost:8080/solicitacoes/{id}", SolicitacaoServico.class, 2);

        log.info(object);

        ResponseEntity<List<SolicitacaoServico>> exchange = new RestTemplate().exchange("http://localhost:8080/solicitacoes/all", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<SolicitacaoServico>>() {
                });

        log.info(exchange.getBody());

        SolicitacaoServico Samuel = SolicitacaoServico.builder().clienteNome("Samuel").build();
        ResponseEntity<SolicitacaoServico> solicitacaoSevicoSaved = new RestTemplate().exchange("http://localhost:8080/solicitacoes/",
                HttpMethod.POST,
                new HttpEntity<>(Samuel, createJsonHeader()),
                SolicitacaoServico.class);

        log.info("saved solicitacao servico", solicitacaoSevicoSaved);
    }

    private static HttpHeaders createJsonHeader(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}
