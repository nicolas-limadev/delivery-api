package com.bytedev.springrest.assembler;

import com.bytedev.springrest.model.Entrega;
import com.bytedev.springrest.representation.EntregaModel;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class EntregaAssembler {

  private ModelMapper modelMapper;

  public EntregaModel toModel(Entrega entrega) {
    return modelMapper.map(entrega, EntregaModel.class);
  }

  public List<EntregaModel> toCollectionModel(List<Entrega> entregas) {
    return entregas.stream().map(this::toModel).collect(Collectors.toList());
  }
}
