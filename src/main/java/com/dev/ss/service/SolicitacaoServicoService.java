package com.dev.ss.service;

import com.dev.ss.domain.SolicitacaoServico;
import com.dev.ss.domain.mapper.SolicitacaoServicoMapper;
import com.dev.ss.exception.BadRequestException;
import com.dev.ss.repository.SolicitacaoServicoRepository;
import com.dev.ss.requests.SolicitacaoServicoPostRequestBody;
import com.dev.ss.requests.SolicitacaoServicoPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolicitacaoServicoService {

    private final SolicitacaoServicoRepository solicitacaoServicoRepository;

    public Page<SolicitacaoServico> list(Pageable pageable) {
        return solicitacaoServicoRepository.findAll(pageable);
    }

    public List<SolicitacaoServico> listAll() {
        return solicitacaoServicoRepository.findAll();
    }

    public List<SolicitacaoServico> findByClienteNome(String clienteNome) {
        return solicitacaoServicoRepository.findByClienteNome(clienteNome);
    }

    public SolicitacaoServico findByIdOrThrowBadRequestException(long id){
        return solicitacaoServicoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Solicitação not Found"));
    }

    public SolicitacaoServico save(SolicitacaoServicoPostRequestBody solicitacaoServicoRequestBody){
        return solicitacaoServicoRepository.save(SolicitacaoServicoMapper.INSTANCE.toSolicitacaoServico(solicitacaoServicoRequestBody));
    }

    public void delete(long id){
        solicitacaoServicoRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(SolicitacaoServicoPutRequestBody solicitacaoServicoPutRequestBody){
        SolicitacaoServico saveSolicitacaoServico = findByIdOrThrowBadRequestException(solicitacaoServicoPutRequestBody.getId());
        SolicitacaoServico solicitacaoServico = SolicitacaoServicoMapper.INSTANCE.toSolicitacaoServico(solicitacaoServicoPutRequestBody);
        solicitacaoServico.setId(saveSolicitacaoServico.getId());
        solicitacaoServicoRepository.save(solicitacaoServico);
    }


}
