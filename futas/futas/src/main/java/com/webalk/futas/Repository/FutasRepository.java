package com.webalk.futas.Repository;

import com.webalk.futas.Entity.Futas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FutasRepository extends PagingAndSortingRepository<Futas, Long> {

    Optional<Futas> getFirstByFutasTipusOrderByTavDesc(int futasTipus);
}
