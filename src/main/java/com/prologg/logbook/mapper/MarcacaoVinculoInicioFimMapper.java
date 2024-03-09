package com.prologg.logbook.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import com.prologg.logbook.dto.MarcacaoVinculoInicioFimDTO;
import com.prologg.logbook.entity.MarcacaoVinculoInicioFim;

@Mapper(componentModel = "spring")
@Component
public interface MarcacaoVinculoInicioFimMapper extends MapperBase<MarcacaoVinculoInicioFim, MarcacaoVinculoInicioFimDTO> {

}
