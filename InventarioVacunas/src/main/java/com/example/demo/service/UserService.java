package com.example.demo.service;

import com.example.demo.entity.Usuario;
import javax.validation.Valid;

public interface UserService {
	
	public Iterable<Usuario> getAllUsers();

	public Usuario createUser(Usuario usuario) throws Exception; 

}
