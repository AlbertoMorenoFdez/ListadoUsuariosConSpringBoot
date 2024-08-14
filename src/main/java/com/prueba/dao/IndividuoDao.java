package com.prueba.dao;

import com.prueba.domain.Individuo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividuoDao extends JpaRepository<Individuo, Long>{
    
}
