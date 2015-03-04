package br.com.qualiti.qib.entidades;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.qualiti.qib.negocio.excecoes.SaldoInsuficienteException;

@Entity
@DiscriminatorValue(value="0")
public class Conta extends ContaAbstrata implements Serializable{

	public Conta(){
	}

	public Conta(String numero, double saldo){
		this.numero = numero;
		this.saldo = saldo;
	}

	public Conta(String numero, double saldo, Cliente cliente){
		this(numero, saldo);
		this.cliente = cliente;
	}

	public void debitar(double valor) 
			throws SaldoInsuficienteException {
		if (this.saldo >= valor){
			this.saldo -= valor;
		} else {
			throw new SaldoInsuficienteException("Seu saldo é insuficiente, deposite mais dinheiro $$ !");
		}
	}
}

