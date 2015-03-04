package br.com.qualiti.qib.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.qualiti.qib.negocio.excecoes.SaldoInsuficienteException;

@Entity
@Table(name="tb_conta")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo", discriminatorType=DiscriminatorType.INTEGER)
public abstract class ContaAbstrata implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;
	@Column(name="numero")
	protected String numero;
	@Column(name="saldo")
	protected double saldo;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	protected Cliente cliente;

	public ContaAbstrata(){

	}

	public ContaAbstrata(String numero, double saldo) {
		this.numero = numero;
		this.saldo = saldo;
	}

	public ContaAbstrata(String numero, double saldo, Cliente cliente) {
		this(numero, saldo);
		this.cliente = cliente;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void creditar(double valor) {
		this.saldo += valor;
	}

	public void transferir(ContaAbstrata c, double valor) throws SaldoInsuficienteException {
		this.debitar(valor);
		c.creditar(valor);
	}

	public abstract void debitar(double valor) throws SaldoInsuficienteException;

    @Override
    public String toString() {
        return "Conta: [Número = " + this.numero  + ", saldo = " + this.saldo  + " ]";
    }
        
}
