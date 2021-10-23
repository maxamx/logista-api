package com.maxamx.logista.mapper;

import com.maxamx.logista.api.dto.EntregaDTO;
import com.maxamx.logista.api.dto.input.EntregaInputDTO;
import com.maxamx.logista.domain.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class EntregaMapper {
    private ModelMapper modelMapper;

    public EntregaDTO toDTO(Entrega entrega){
        return modelMapper.map(entrega, EntregaDTO.class);
    }

    public List toCollectionDTO(List<Entrega> entregas){
        return entregas.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());

    }

    public Entrega toEntity(EntregaInputDTO entregaInputDTO){
        return modelMapper.map(entregaInputDTO,Entrega.class);
    }
}
