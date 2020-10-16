package br.com.dominio.ordem;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.aplicacao.ordem.OrdemDTO;

@Entity
public class Ordem {
	
	private static final String ENVIADA = "ENVIADA";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double preco;
	private String tipo;
	private LocalDate data;
	private String status;
	@Column(name = "user_id")
	private Long userId;
	
	public Ordem() {
		
	}
	
	public Ordem(OrdemDTO ordemDTO) {
		this.id = ordemDTO.getId();
		this.preco = ordemDTO.getPreco();
		this.tipo = ordemDTO.getTipo();
		this.data = insereData(ordemDTO.getData());
		this.status = insereStatus(ordemDTO.getStatus());
		this.userId = ordemDTO.getUserId();
	}

	public Long getId() {
		return id;
	}

	public Double getPreco() {
		return preco;
	}

	public String getTipo() {
		return tipo;
	}
	
	private LocalDate insereData(LocalDate data) {
		if(data == null)
			return LocalDate.now();
		return data;
	}

	public LocalDate getData() {
		return data;
	}
	
	private String insereStatus(String status) {
		if(status == null || status.isEmpty())
			return ENVIADA;
		return status;
	}

	public String getStatus() {
		return status;
	}

	public Long getUserId() {
		return userId;
	}

}
