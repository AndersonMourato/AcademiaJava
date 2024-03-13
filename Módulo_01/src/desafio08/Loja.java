package desafio08;
import java.util.ArrayList;
import java.util.Scanner;

public class Loja extends SistemaLoja {
	private ArrayList<Carro> carrosList = new ArrayList<>();
	private ArrayList<Cliente> clientesList = new ArrayList<>();
	
	

	@Override
	public Carro addCarro() {
		Carro car = new Carro();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nVocê precisa associar o carro a um cliente, selecione ou cadastre um novo cliente.");
		System.out.print("Informe o CPF de um cliente: ");
		String cpf = sc.nextLine();
		if(buscarClienteCpf(cpf) != null) {
			System.out.println("\n############# CADASTRO DE CARRO #############");
			System.out.print("PLACA: ");
			car.setPlaca(sc.nextLine());
			System.out.print("MARCA: ");
			car.setMarca(sc.nextLine());
			System.out.print("MODELO: ");
			car.setModelo(sc.nextLine());
			System.out.print("ANO FB.: ");
			car.setAno(sc.nextInt());
			sc.nextLine(); // resolver bug scan.
			System.out.print("VALOR R$: ");
			car.setValorAproximado(sc.nextFloat());
			sc.nextLine(); // resolver bug scan.
			System.out.print("DONO: " + buscarClienteCpf(cpf).getNome());
			car.setDono(buscarClienteCpf(cpf));
			
			carrosList.add(car);
			return car;
		}else {
			System.err.println("O CPF: "+cpf+" não foi encontrado na base de clientes, cadastre um novo cliente...");
			if(addCliente() != null){
				addCarro();
			}
		}
		return null;
	}

	@Override
	public Carro updateCarro() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Informe a PLACA: ");
		String placa = sc.nextLine();
		
		if(buscarCarroPlaca(placa) != null) {
			Carro car = buscarCarroPlaca(placa);
			System.out.println("\n######### ALTERAR INFORMAÇÕES DO CARRO #########");
			System.out.print("PLACA: ");
			car.setPlaca(sc.nextLine());
			System.out.print("MARCA: ");
			car.setMarca(sc.nextLine());
			System.out.print("MODELO: ");
			car.setModelo(sc.nextLine());
			System.out.print("ANO FB.: ");
			car.setAno(sc.nextInt());
			sc.nextLine(); // resolver bug scan.
			System.out.print("VALOR R$: ");
			car.setValorAproximado(sc.nextFloat());
			sc.nextLine(); // resolver bug scan.
			System.out.print("DONO: " + car.getDono().getNome());
			return car;
		}else {
			System.err.println("A placa: "+placa+" não foi encontrado na base de carros, tente novamente...");
		}
		return null;
	}
	
	@Override
	public void listaCarros() {
		System.out.println("	PLACA	|	MARCA	|	MODELO	|	ANO	|	PREÇO FIP	|	DDONO");
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		for (Carro car: carrosList) {
			System.out.println("	"+car.getPlaca() +"	|	"+ car.getMarca() +"	|	"+ car.getModelo() +"	|	"+ car.getAno() +"	|	R$"+car.getValorAproximado() +"	|	"+ car.getDono().getNome());
			System.out.println("---------------------------------------------------------------------------------------------------------------");
		}
	}

	@Override
	public void dellCarro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente addCliente() {
		Cliente client = new Cliente();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n############# CADASTRO DE CLIENTE #############");
		System.out.print("NOME: ");
		client.setNome(sc.nextLine());
		System.out.print("IDADE: ");
		client.setIdade(sc.nextInt());
		sc.nextLine();// resolver bug scan.
		System.out.print("CPF: ");
		client.setCpf(sc.nextLine());
		System.out.print("TELEFONE: ");
		client.setTelefone(sc.nextLine());
		System.out.print("ENDEREÇO: ");
		client.setEndereco(sc.nextLine());
		
		clientesList.add(client);
		return client;
	}

	@Override
	public Cliente updateCliente() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe o CPF: ");
		String cpf = sc.nextLine();
		
		if(buscarClienteCpf(cpf) != null) {
			Cliente client = buscarClienteCpf(cpf);
			System.out.println("\n############# ATUALIZAR CLIENTE #############");
			System.out.println("NOME: " + client.getNome());
			System.out.println("IDADE: " + client.getIdade());
			System.out.println("CPF: " + client.getCpf());
			System.out.println("TELEFONE: " + client.getTelefone());
			System.out.println("ENDEREÇO: " + client.getNome() +"\n");
			client.setNome(inputUpdate("NOME") ? sc.nextLine() : client.getNome());
			client.setIdade(inputUpdate("IDADE") ? sc.nextInt() : client.getIdade());
			client.setCpf(inputUpdate("CPF") ? sc.nextLine() : client.getCpf());
			client.setTelefone(inputUpdate("TELEFONE") ? sc.nextLine() : client.getTelefone());
			client.setEndereco(inputUpdate("ENDEREÇIO") ? sc.nextLine() : client.getNome());
			
			return client;
		}else {
			System.err.println("O CPF: "+cpf+" não foi encontrado na base, tente novamente...");
		}
		return null;
	}

	@Override
	public void dellCliente() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Cliente buscarClienteCpf(String cpf) {
		for (Cliente client: clientesList) {
			return client.getCpf().equalsIgnoreCase(cpf)? client : null;
		}
		return null;
	}
	
	@Override
	public Carro buscarCarroPlaca(String placa) {
		for (Carro car: carrosList) {
			return car.getPlaca().equalsIgnoreCase(placa)? car : null;
		}
		return null;
	}
	
	
	private boolean inputUpdate(String str) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Deseja alterar "+str+"? [S]/[N]");
		String op = sc.nextLine();
		if(op.equalsIgnoreCase("S")){
			return true;
		}
		return false;
	}
	
	public void aplicarDadosTeste() {
		Cliente c1 = new Cliente("Antonio Luiz", 33, "123456", "8199656985", "Rua Joge Dantas");
		Cliente c2 = new Cliente("Maria Julia", 21, "456789", "8188775544", "Rua Carvalho Sul");
		Cliente c3 = new Cliente("Diego Martinz", 33, "321654", "8199656985", "Rua Centro Norte");
		carrosList.add(new Carro("KJD-332", "FIAT", "MOBI", 2020, 455.33f, c1));
		carrosList.add(new Carro("SHT-845", "FIAT", "UNO", 2021, 854.22f, c2));
		carrosList.add(new Carro("GVS-567", "VW", "GOLF", 2018, 72345f, c2));
		clientesList.add(c1);
		clientesList.add(c2);
		clientesList.add(c3);
	}
}
