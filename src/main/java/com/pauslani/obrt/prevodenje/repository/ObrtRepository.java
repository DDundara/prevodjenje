package com.pauslani.obrt.prevodenje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pauslani.obrt.prevodenje.entitet.Obrt;

@Repository
public interface ObrtRepository extends JpaRepository<Obrt, Long> {
}