package com.dio.live.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class Movimentacao implements Model {
	
	@AllArgsConstructor
	@NoArgsConstructor
	@EqualsAndHashCode
	@Embeddable
	public class MovimentacaoId implements Serializable {
		private Long idMovimento;
		private Long idUsuario;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EmbeddedId
	@JsonProperty
	private MovimentacaoId id;
	
	@JsonProperty
	private LocalDateTime dataEntrada;
	
	@JsonProperty
	private LocalDateTime dataSaida;
	
	@JsonProperty
	private BigDecimal periodo;
	
	@ManyToOne
	@JsonProperty
	private Ocorrencia ocorrencia;
	
	@ManyToOne
	@JsonProperty
	private Calendario calendario;
}
