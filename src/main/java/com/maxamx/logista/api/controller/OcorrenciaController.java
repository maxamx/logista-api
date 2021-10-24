package com.maxamx.logista.api.controller;

import com.maxamx.logista.api.dto.input.OcorrenciaInputDTO;
import com.maxamx.logista.api.dto.output.OcorrenciaOutputDTO;
import com.maxamx.logista.domain.model.Entrega;
import com.maxamx.logista.domain.model.Ocorrencia;
import com.maxamx.logista.domain.model.service.BuscaEntregaService;
import com.maxamx.logista.domain.model.service.RegistroOcorrenciaService;
import com.maxamx.logista.mapper.OcorrenciaMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaMapper ocorrenciaMapper;
    private BuscaEntregaService buscaEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    OcorrenciaOutputDTO registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInputDTO ocorrenciaInputDTO){
        Ocorrencia ocorrenciaRegistrada= registroOcorrenciaService.registrar(entregaId,ocorrenciaInputDTO.getDescricao());
        return ocorrenciaMapper.toDTO(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaOutputDTO> listar(@PathVariable Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);
        return ocorrenciaMapper.toCollectionDTO(entrega.getOcorrencias());
    }

}
