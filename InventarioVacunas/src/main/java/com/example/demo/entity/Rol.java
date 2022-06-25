package com.example.demo.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Rol implements Serializable{

	private static final long serialVersionUID = 8313085396653812713L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator= "native")
	@GenericGenerator(name="native", strategy="native")
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String descripcion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", name=" + name + ", descripcion=" + descripcion + "]";
	}
	
	
	
}
