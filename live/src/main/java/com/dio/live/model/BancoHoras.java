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
public class BancoHoras implements Model {
	@AllArgsConstructor
	@NoArgsConstructor
	@EqualsAndHashCode
	@Embeddable
	public class BancoHorasId implements Serializable {
		private Long idBancoHoras;
		private Long idMovimento;
		private Long idUsuario;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EmbeddedId
	@JsonProperty
	private BancoHorasId id;
	
	@JsonProperty
	private LocalDateTime dataTrabalhada;
	
	@JsonProperty
	private BigDecimal quantidadeHorasTrabalhadas;
	
	@JsonProperty
	private BigDecimal saldoHorasTrabalhadas;
}
