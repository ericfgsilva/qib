package br.com.qualiti.qib.entidades;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.qualiti.qib.negocio.excecoes.SaldoInsuficienteException;

@Entity
@DiscriminatorValue(value="3")
public class ContaImposto extends ContaAbstrata implements Serializable {

	public static final double TAXA = 0.001; //0,1%
	
	public ContaImposto() {
		
	}
	
	public ContaImposto(String numero, double valor) {
		this.numero = numero;
		this.saldo = valor;
	}
		
	@Override
	public void debitar(double valor) throws SaldoInsuficienteException {
		double imposto = valor *  TAXA;
		double saldo = this.getSaldo();
		if (valor + imposto <= saldo) { 
			setSaldo(saldo - (valor + imposto));
		} else {
			throw new SaldoInsuficienteException("Saldo insuficiente !");
		}
	}

}
