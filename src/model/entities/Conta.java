package model.entities;

import model.exceptions.DomainException;

public class Conta {

	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteSaque;

	public Conta() {
		super();
	}

	public Conta(Integer numero, String titular, Double saldo, Double limiteSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	public void deposito(double valor) {
		this.saldo += valor;
	}

	public void saque(double valor) throws DomainException {
		if (valor > this.limiteSaque) {
			throw new DomainException("Valor excede o limite de saque!");
		} else if (valor > this.saldo) {
			throw new DomainException("Valor excede o saldo!");
		} else {
			this.saldo -= valor;
		}

	}

	@Override
	public String toString() {
		return "Conta [numero=" + getNumero() + ", titular=" + getTitular() + ", saldo=" + getSaldo() + ", limiteSaque="
				+ getLimiteSaque() + "]";
	}

}
