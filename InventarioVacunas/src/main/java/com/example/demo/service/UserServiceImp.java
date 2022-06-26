package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	UserRepository repository;
	
	@Override
	public Iterable<Usuario> getAllUsers(){
		return repository.findAll();
	}
	
	private boolean comprobarusuario(Usuario usuario) throws Exception {
		Optional<Usuario> userFound = repository.findByUsiario(usuario.getUsuario());
		if(userFound.isPresent()) {
			throw new Exception("Usuario no disponible");
		}
		return true;
	}
	
	private boolean comprobarpassword(Usuario usuario) throws Exception {
		if(!usuario.getPassword().equals(usuario.getConfirmPassword())) {
			throw new Exception("Las contraseñas no coinciden");
		}
		return true;
	}
}
