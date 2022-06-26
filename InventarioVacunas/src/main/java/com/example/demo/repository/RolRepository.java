package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Long> {

}
