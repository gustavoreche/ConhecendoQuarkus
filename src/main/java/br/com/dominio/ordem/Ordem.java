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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double preco;
	private String tipo;
	private LocalDate data;
	private String status;
	@Column(name = "user_id")
	private Long userId;
	
	public Ordem(OrdemDTO ordemDTO) {
		this.id = ordemDTO.getId();
		this.preco = ordemDTO.getPreco();
		this.tipo = ordemDTO.getTipo();
		this.data = ordemDTO.getData();
		this.status = ordemDTO.getStatus();
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

	public LocalDate getData() {
		return data;
	}

	public String getStatus() {
		return status;
	}

	public Long getUserId() {
		return userId;
	}

}
