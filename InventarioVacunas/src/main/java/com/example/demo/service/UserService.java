package com.example.demo.service;

import javax.validation.Valid;

import com.example.demo.entity.Usuario;

public interface UserService {
	
	public Iterable<Usuario> getAllUsers();

	public Usuario createUser(Usuario usuario) throws Exception; 

}
