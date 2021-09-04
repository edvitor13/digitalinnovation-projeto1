package com.dio.live.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

import com.dio.live.support.Model;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class Empresa implements Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String descricao;
	
	@JsonProperty
	private String cnpj;
	
	@JsonProperty
	private String endereco;
	
	@JsonProperty
	private String bairro;
	
	@JsonProperty
	private String cidade;
	
	@JsonProperty
	private String estado;
	
	@JsonProperty
	private String telefone;
}
