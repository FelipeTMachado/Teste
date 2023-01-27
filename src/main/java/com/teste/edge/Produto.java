package com.teste.edge;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data	
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long codigo;
	String nome;
	float preco;
	String marca;
	
}
