
package com.senac.hotel.repository;

import com.senac.hotel.model.Analise;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnaliseRepository  extends JpaRepository<Analise, Integer>{
    List<Analise> findByClienteId(int clienteId);
}
