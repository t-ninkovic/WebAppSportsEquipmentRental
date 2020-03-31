/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.dto;

import java.util.List;
import njt.webappiznajmljivanjesportskeopreme.domain.VrstaOpreme;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author HP
 */
@Mapper
public interface VrstaMapper {
    VrstaMapper INSTANCE = Mappers.getMapper(VrstaMapper.class);
    
    VrstaDTO toVrstaDTO(VrstaOpreme vrsta);
    List<VrstaDTO> toVrstaDTOs(List<VrstaOpreme> vrste);
    VrstaOpreme toVrsta(VrstaDTO vrstaDTO);
}
