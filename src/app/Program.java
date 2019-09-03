package app;

import java.util.Scanner;

import model.entities.Conta;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("\nNumero da conta: ");
			int numero = sc.nextInt();
			System.out.print("\nTitular: ");
			sc.nextLine();
			String titular = sc.nextLine();
			System.out.print("\nSaldo inicial: ");
			double saldo = sc.nextDouble();
			System.out.print("\nLimite de saque: ");
			double limiteSaque = sc.nextDouble();

			Conta conta = new Conta(numero, titular, saldo, limiteSaque);

			System.out.println(conta);
			
			System.out.print("\nValor de saque: ");
			conta.saque(sc.nextDouble());
			
			System.out.println("\nATUALIZADO: \n"+conta);
		} 
		catch (DomainException e) {
			System.out.println("Erro!" + e.getMessage());
		} 
		catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		finally {
			sc.close();
		}
		

	}

}
