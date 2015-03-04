package br.com.qualiti.qib.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tb_cliente", schema="public")
public class Cliente implements Serializable {
	
	@Column(name="NOME")
	private String nome;
	
	@Id
	@Column(name="CPF")
	private String cpf;
	
	@OneToMany(mappedBy="cliente", fetch=FetchType.LAZY)
	private List<ContaAbstrata> contas;

	public Cliente(){
	}

	public Cliente(String nome, String cpf){
		this.nome = nome;
		this.cpf = cpf;
	}
	
	
	public String getNome(){
		return nome; 
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getCpf(){
		return cpf;
	}
	
	public void setCpf(String cpf){
		this.cpf = cpf;
	}

	/**
	 * @return the contas
	 */
	public List<ContaAbstrata> getContas() {
		return contas;
	}

	/**
	 * @param contas the contas to set
	 */
	public void setContas(List<ContaAbstrata> contas) {
		this.contas = contas;
	}

	@Override
	public String toString() {
		return "Cliente: [nome = " + this.nome + ", cpf = " + this.cpf + "]";
	}
}
