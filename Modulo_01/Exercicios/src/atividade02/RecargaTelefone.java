package atividade02;

import java.util.Scanner;

public class RecargaTelefone {

	public static void main(String[] args) {

		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		
		System.out.println("############## CADASTRAR NOVO USUARIO ##############");
		System.out.print("NOME: ");
		String userNome1 = scan1.nextLine();
		System.out.print("TELEFONE: ");
		String userTelefone1 = scan1.nextLine();
		System.out.print("CPF: ");
		String userCPF1 = scan1.nextLine();
		System.out.print("NUMERO DO CARTÃO: ");
		String userCartao1 = scan1.nextLine();
		System.out.print("CVV DO CARTÃO: ");
		int userCVV1 = scan1.nextInt();
		System.out.println("_____________________________________________________");
		System.out.println();

		System.out.println("############## CADASTRAR NOVO USUARIO ##############");
		System.out.print("NOME: ");
		String userNome2 = scan2.nextLine();
		System.out.print("TELEFONE: ");
		String userTelefone2 = scan2.nextLine();
		System.out.print("CPF: ");
		String userCPF2 = scan2.nextLine();
		System.out.print("NUMERO DO CARTÃO: ");
		String userCartao2 = scan2.nextLine();
		System.out.print("CVV DO CARTÃO: ");
		int userCVV2 = scan2.nextInt();
		System.out.println("_____________________________________________________");
		System.out.println();
		System.out.println();

		
		boolean menu = true;
		String opcao;
		int opcaoMenu;
		int validaCVV = 0;
		String validaTelef = "0";
		String compraValor = "R$ 0,00";
		String compraFormPag = "NULL";
		boolean autorizaCompra = false;
		
		while(menu) {
			System.out.println("Fazer recarga? [SIM]/[NAO]");
			opcao = scan1.next();
			
			if(opcao.equalsIgnoreCase("SIM") || opcao.equalsIgnoreCase("S")) {
				System.out.println("Iinforme o numedo do TELEFONE: ");
				validaTelef = scan2.next();
				
				// Valida se o TELEFONE de entrada é o mesmo do usuario1 ou do usuario2?
				if(validaTelef.equalsIgnoreCase(userTelefone1) || validaTelef.equalsIgnoreCase(userTelefone2)) {
					System.out.println("############ SELECIONE O VALOR DA RECARGA ############");
					System.out.println("	[1] - R$ 10,00");
					System.out.println("	[2] - R$ 15,00");
					System.out.println("	[3] - R$ 25,00");
					System.out.println("	[4] - R$ 35,00");
					System.out.println("	[5] - R$ 50,00");
					System.out.println("_____________________________________________________");
					System.out.println();
					
					System.out.println("Informe uma das opções: ");
					opcaoMenu = scan1.nextInt();
					
					switch(opcaoMenu) {
						case 1: compraValor = "R$ 10,00";
							break;
						case 2: compraValor = "R$ 15,00";
							break;
						case 3: compraValor = "R$ 25,00";
							break;
						case 4: compraValor = "R$ 35,00";
							break;
						case 5: compraValor = "R$ 50,00";
							break;
						default: System.out.println("O numero informado não é uma OPÇÃO válida!");
							menu = false;
					}
					
					System.out.println("########### SELECIONE A FORMA DE PAGAMENTO ###########");
					System.out.println("	[1] - PAGAR COM CARTÃO DE CREDITO");
					System.out.println("	[2] - PAGAR COM CARTÃO DE DEBITO");
					System.out.println("	[3] - PAGAR COM PIX");
					System.out.println("_____________________________________________________");
					System.out.println();
					
					System.out.println("Informe uma das opções: ");
					opcaoMenu = scan2.nextInt();
					
					switch(opcaoMenu) {
						case 1: compraFormPag = "CARTÃO DE CREDITO";
							System.out.println("Informe o CVV de seu cartão: ");
							validaCVV = scan1.nextInt();
							if(validaCVV == userCVV1 && validaTelef.equalsIgnoreCase(userTelefone1) || validaCVV == userCVV2 && validaTelef.equalsIgnoreCase(userTelefone2)) {
								System.out.println("**COMPRA AUTORIZADA**");
								autorizaCompra = true;
							}else {
								System.err.println("**COMPRA NEGADA, o codigo CVV não condiz com as informações cadastradas.**");
							}
							break;
						case 2: compraFormPag = "CARTÃO DE DEBITO";
							System.out.println("Informe o CVV de seu cartão: ");
							validaCVV = scan2.nextInt();
							if(validaCVV == userCVV1 && validaTelef.equalsIgnoreCase(userTelefone1) || validaCVV == userCVV2 && validaTelef.equalsIgnoreCase(userTelefone2)) {
								System.out.println("**COMPRA AUTORIZADA**");
								autorizaCompra = true;
							}else {
								System.err.println("**COMPRA NEGADA, o codigo CVV não condiz com as informações cadastradas.**");
							}
							break;
						case 3: compraFormPag = "PIX";
								System.out.println("Faça o pagamento via PIX para a chave: 6988462874651. No valor de " + compraValor);
								System.out.println();
								System.out.println();
								autorizaCompra = true;
							break;
						default: System.out.println("O numero informado não é uma OPÇÃO válida!");
								menu = false;
					}
					
					System.out.println("############# RECARGA REALIZADA COM EXITO #############");
					System.out.println("NUMERO DE TELEFONE: " + validaTelef);
					System.out.println("VALOR DA RECARGA: " + compraValor);
					System.out.println("FORMA DE PAGAMENTO: " + compraFormPag);
					System.out.println("********************************************************");
					autorizaCompra = false;
					
				}else {
					System.err.println("O TELEFONE informado não consta na base de dados!");
				}
			}else {
				//Finaliza o Loop e sai do menu.
				menu = false;
			}			
		}//Fim do While.
		System.out.println("Programa finalizado com exito!");
	}
}
