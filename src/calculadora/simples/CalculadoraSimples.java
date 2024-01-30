package calculadora.simples;

import java.util.Scanner;

public class CalculadoraSimples {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double number1, number2;
		
		System.out.println("Entre com dois numeros:");
		number1 = scan.nextDouble();
		number2 = scan.nextDouble();
		
		double resultSoma = soma(number1, number2);
		double resultMutiplicacao = mutiplicacao(number1, number2);
		double resultSubitracao = subitracao(number1, number2);
		double resultDivisao = divisao(number1, number2);
		
		System.out.println("Resultado para SOMA: " + resultSoma);
		System.out.println("Resultado para MUTIPLICAÇÃO: " + resultMutiplicacao);
		System.out.println("Resultado para SUBITRAÇÃO: " + resultSubitracao);
		System.out.println("Resultado para DIVISÃO: " + resultDivisao);
	}
		
	
	public static double soma(double num1, double num2) {
		return num1 + num2;
	}
	
	public static double mutiplicacao(double num1, double num2) {
		return num1 * num2;
	}
	
	public static double subitracao(double num1, double num2) {
		return num1 - num2;
	}

	public static double divisao(double num1, double num2) {
		return num1 / num2;
	}
}

/*
* CALCULADORA 
* SOMA 
* SUBTRAÇÃO
* DIVIZÃO
*/