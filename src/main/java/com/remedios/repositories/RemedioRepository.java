package com.remedios.repositories;

import com.remedios.dtos.DadosListagemRemedio;
import com.remedios.models.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RemedioRepository extends JpaRepository<Remedio, Long> {

    List<Remedio> findAllByAtivoTrue();
}
