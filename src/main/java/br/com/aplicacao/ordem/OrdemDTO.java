package br.com.aplicacao.ordem;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.json.bind.annotation.JsonbProperty;

import br.com.dominio.ordem.Ordem;

public class OrdemDTO {

	private Double preco;
	private String tipo;
	private LocalDate data;
	private String status;
	@JsonbProperty(value = "user_id")
	private Long userId;
	
	public OrdemDTO() {

	}

	public OrdemDTO(Ordem ordem) {
		this.preco = ordem.getPreco();
		this.tipo = ordem.getTipo();
		this.data = ordem.getData();
		this.status = ordem.getStatus();
		this.userId = ordem.getUserId();
	}
	
	public Ordem converteParaAEntidade() {
		return new Ordem(this);
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

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public static List<OrdemDTO> converte(List<Ordem> ordens) {
		return ordens.stream().map(OrdemDTO::new).collect(Collectors.toList());
	}
	
}
