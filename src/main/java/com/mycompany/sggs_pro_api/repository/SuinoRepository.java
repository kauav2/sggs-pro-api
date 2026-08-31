package com.mycompany.sggs_pro_api.repository;

import com.mycompany.sggs_pro_api.entity.Suino;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SuinoRepository extends JpaRepository<Suino, Long> {

    Optional<Suino> findByNumero(Integer numero);

}