package com.dev.ss.domain.mapper;

import com.dev.ss.domain.SolicitacaoServico;
import com.dev.ss.requests.SolicitacaoServicoPostRequestBody;
import com.dev.ss.requests.SolicitacaoServicoPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class SolicitacaoServicoMapper {

    public static final SolicitacaoServicoMapper INSTANCE = Mappers.getMapper(SolicitacaoServicoMapper.class);

    public abstract SolicitacaoServico toSolicitacaoServico(SolicitacaoServicoPostRequestBody solicitacaoServicoPostRequestBody);

    public abstract  SolicitacaoServico toSolicitacaoServico(SolicitacaoServicoPutRequestBody solicitacaoServicoPutRequestBody);
}
