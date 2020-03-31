/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.repository;

import java.util.Optional;
import njt.webappiznajmljivanjesportskeopreme.domain.StavkaCenovnika;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface StavkaCenovnikaRepository extends JpaRepository<StavkaCenovnika, Long>{
//    @Query("SELECT * FROM stavkacenovnika WHERE oprema_id = :oprema_id")
//    public Optional<StavkaCenovnika> findByOprema(Long oprema_id);
//    
//    @Query("SELECT * FROM stavkacenovnika WHERE cenovnik_id = :cenovnik_id")
//    public Optional<StavkaCenovnika> findByCenovnik(Long cenovnik_id);
}
