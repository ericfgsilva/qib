package br.com.qualiti.qib.entidades;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="1")
public class ContaPoupanca extends Conta implements Serializable {

	public ContaPoupanca() {
		super();
	}
	
	public ContaPoupanca(String numero, double saldo) {
		super(numero, saldo);
	}
	
	public void renderJuros(double taxa) {
		this.saldo += this.saldo * taxa;
	}
}
