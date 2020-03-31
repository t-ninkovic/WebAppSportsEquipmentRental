/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.repository;

import njt.webappiznajmljivanjesportskeopreme.domain.VrstaOpreme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface VrstaOpremeRepository extends JpaRepository<VrstaOpreme, Long>{
    
}
