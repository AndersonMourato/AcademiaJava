package desafio08;
import java.util.ArrayList;
import java.util.Scanner;


public class Loja extends SistemaLoja {
	private ArrayList<Carro> carrosList = new ArrayList<>();
	private ArrayList<Cliente> clientesList = new ArrayList<>();
	private int quantidade;
	

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
			System.out.print("CLIENTE: " + buscarClienteCpf(cpf).getNome());
			car.setDono(buscarClienteCpf(cpf));;
		}else {
			System.err.println("O CPF: "+cpf+" não foi encontrado na base de clientes, cadastre um novo cliente...");
			if(addCliente() != null){
				addCarro();
			}
		}
		
		return car;
	}

	@Override
	public Carro updateCarro() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
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
	
	
}
