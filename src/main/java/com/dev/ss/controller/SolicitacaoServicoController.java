package com.dev.ss.controller;

import com.dev.ss.domain.SolicitacaoServico;
import com.dev.ss.requests.SolicitacaoServicoPostRequestBody;
import com.dev.ss.requests.SolicitacaoServicoPutRequestBody;
import com.dev.ss.service.SolicitacaoServicoService;
import com.dev.ss.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("solicitacoes")
@Log4j2
@RequiredArgsConstructor
public class SolicitacaoServicoController {
    private final DateUtil dateUtil;
    private final SolicitacaoServicoService solicitacaoServicoService;

    @GetMapping
    public ResponseEntity<Page<SolicitacaoServico>>  list(Pageable pageable){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(solicitacaoServicoService.listAll(pageable));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SolicitacaoServico> findById(@PathVariable long id){
        return ResponseEntity.ok(solicitacaoServicoService.findByIdOrThrowBadRequestException(id));

    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<SolicitacaoServico>> findByClienteNome(@RequestParam String nome){
        return ResponseEntity.ok(solicitacaoServicoService.findByClienteNome(nome));

    }



    @PostMapping
    public ResponseEntity<SolicitacaoServico> save(@RequestBody @Valid SolicitacaoServicoPostRequestBody solicitacaoServico){
        return new ResponseEntity<>(solicitacaoServicoService.save(solicitacaoServico), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        solicitacaoServicoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> replace(@RequestBody SolicitacaoServicoPutRequestBody solicitacaoServicoPutRequestBody){
        solicitacaoServicoService.replace(solicitacaoServicoPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
