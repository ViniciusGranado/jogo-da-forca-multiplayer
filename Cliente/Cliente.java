import java.net.*;
import java.io.*;

public class Cliente {
	public static final String HOST_PADRAO = "localhost";
	public static final int PORTA_PADRAO = 3000;

	public static void main(String[] args) {
		// Socket
		if (args.length > 2) {
			System.err.println("Uso esperado: java Cliente [HOST [PORTA]]\n");
			return;
		}

		Socket conexao = null;

		try {
			String host = Cliente.HOST_PADRAO;
			int porta = Cliente.PORTA_PADRAO;

			if (args.length > 0)
				host = args[0];

			if (args.length == 2)
				porta = Integer.parseInt(args[1]);

			conexao = new Socket(host, porta);
		} catch (Exception erro) {
			System.err.println("Indique o servidor e a porta corretos!\n");
			return;
		}

		// Transmissor
		ObjectOutputStream transmissor = null;
		try {
			transmissor = new ObjectOutputStream(conexao.getOutputStream());
		} catch (Exception erro) {
			System.err.println("Indique o servidor e a porta corretos!\n");
			return;
		}

		// Receptor
		ObjectInputStream receptor = null;
		try {
			receptor = new ObjectInputStream(conexao.getInputStream());
		} catch (Exception erro) {
			System.err.println("Indique o servidor e a porta corretos!\n");
			return;
		}

		// Parceiro Servido
		Parceiro servidor = null;
		try {
			servidor = new Parceiro(conexao, receptor, transmissor);
		} catch (Exception erro) {
			System.err.println("Indique o servidor e a porta corretos!\n");
			return;
		}

		TratadoraDeComunicadoDeDesligamento tratadoraDeComunicadoDeDesligamento = null;
		try {
			tratadoraDeComunicadoDeDesligamento = new TratadoraDeComunicadoDeDesligamento(servidor);
		} catch (Exception erro) {
			//
		}

		tratadoraDeComunicadoDeDesligamento.start();

		// Loop de execução
		char opcao = ' ';

		do {
			try {
				opcao = Character.toUpperCase(Teclado.getUmChar());
			} catch (Exception erro) {
				System.err.println("Opcao invalida!\n");
				continue;
			}
		
			System.out.println(opcao);
		} while (opcao != 'T');

		// Desconexão com o servidor
		try {
			servidor.receba(new PedidoParaSair());
		} catch (Exception erro) {
			//
		}

		System.out.println("Obrigado por usar este programa!");
		System.exit(0);
	}
}
