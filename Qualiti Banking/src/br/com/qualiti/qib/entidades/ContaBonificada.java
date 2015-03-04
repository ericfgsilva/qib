package br.com.qualiti.qib.entidades;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue(value="2")
public class ContaBonificada extends Conta implements Serializable {

	@Transient
	private double bonus;
	
	public ContaBonificada() {
		super();
	}
	
	public ContaBonificada(String n, double saldo) {
		super(n, saldo);
	}

	/**
	 * @return the bonus
	 */
	public double getBonus() {
		return bonus;
	}

	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public void creditar(double valor) {
		this.bonus += (valor * 0.01);
		super.creditar(valor);
	}
	
	public void renderBonus() {
		super.creditar(this.bonus);
		this.bonus = 0;
	}
}
