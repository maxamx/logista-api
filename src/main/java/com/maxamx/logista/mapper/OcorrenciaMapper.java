package com.maxamx.logista.mapper;

import com.maxamx.logista.api.dto.output.OcorrenciaOutputDTO;
import com.maxamx.logista.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OcorrenciaMapper {
    private ModelMapper modelMapper;

    public OcorrenciaOutputDTO toDTO(Ocorrencia ocorrencia){
        return modelMapper.map(ocorrencia,OcorrenciaOutputDTO.class);

    }

    public List<OcorrenciaOutputDTO> toCollectionDTO(List<Ocorrencia> ocorrencias){
       return ocorrencias.stream()
               .map(this::toDTO)
               .collect(Collectors.toList());

    }
}
