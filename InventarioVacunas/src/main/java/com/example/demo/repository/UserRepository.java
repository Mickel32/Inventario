package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Usuario;

@Repository
public interface UserRepository extends CrudRepository<Usuario, Long>{
	
	public Optional<Usuario> findByUsuario(String usuario);

	public Optional<Usuario> findByEmail(String email);

}
