import java.net.*;
import java.io.*;

public class Cliente {
  public static final String HOST_PADRAO = "localhost";
  public static final int PORTA_PADRAO = 4000;

  public static void main(String[] args) {
    // Socket
    if (args.length > 2) {
      System.err.println("Uso esperado: java Cliente [HOST [PORTA]]\n");
      return;
    }

    Socket conexao;

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
    ObjectOutputStream transmissor;
    try {
      transmissor = new ObjectOutputStream(conexao.getOutputStream());
    } catch (Exception erro) {
      System.err.println("Indique o servidor e a porta corretos!\n");
      return;
    }

    // Receptor
    ObjectInputStream receptor;
    try {
      receptor = new ObjectInputStream(conexao.getInputStream());
    } catch (Exception erro) {
      System.err.println("Indique o servidor e a porta corretos!\n");
      return;
    }

    // Parceiro Servido
    Parceiro servidor;
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

    // Execução

    Terminal.clear();
    System.out.println("Aguardando a entrada de novos jogadores...");
    System.out.println("O jogo ira iniciar em breve.");

    try {
      Comunicado comunicado = null;
      do {
        comunicado = servidor.espie();
      } while (!(comunicado instanceof ComunicadoDeInicioDePartida));
      System.out.println("\nA partida iniciou!!!\n");

      servidor.envie();
    } catch (Exception erro) {
      System.out.println(erro);
    }

    try {
      Comunicado comunicado;
      do {
        // Terminal.clear();
        System.out.println("Aguarde a jogada dos outros jogadores...");

        comunicado = servidor.espie();
        System.out.println(comunicado.getClass());

        if (comunicado instanceof ComunicadoDeFimDePartida) {
          servidor.envie();
          break;
        } else if (comunicado instanceof ComunicadoDeVezDoJogador) {
          ComunicadoDeVezDoJogador jogada = (ComunicadoDeVezDoJogador) servidor.envie();
          String opcaoUsuario;

          Terminal.clear();
          System.out.println("Chegou a sua vez!!");
          do {
            System.out.println("Faca sua jogada\n");

            System.out.println("Palavra...: " + jogada.getTracinhos());
            System.out.println("Digitadas.: " + jogada.getLetrasJaDigitadas() + "\n");

            System.out.println("SELECIONE UMA OPCAO: ");
            System.out.println("Se deseja digitar uma letra digite [L]");
            System.out.println("Se deseja chutar a palavra  digite [P]\n");

            System.out.print("Digite sua opcao: ");

            opcaoUsuario = Teclado.getUmString();

            if (opcaoUsuario.toLowerCase().equals("l") || opcaoUsuario.toLowerCase().equals("p")) {
              break;
            }

            Terminal.clear();
            System.out.println("Opcao invalida. Tente novamente.");
          } while (true);

          if (opcaoUsuario.toLowerCase().equals("l")) {
            Character letra = null;

            do {
              try {
                System.out.print("Qual a letra? ");
                letra = Teclado.getUmChar();
              } catch (Exception erro) {
                System.out.println("\nLetra invalida, tente novamente! \n");
              }
            } while (letra == null);

            servidor.receba(new TentativaDeLetra(letra));
          } else {
            String palavra = null;

            do {
              try {
                System.out.print("Qual a palavra? ");
                palavra = Teclado.getUmString();
              } catch (Exception erro) {
                System.out.println("Palavra inválida, tente novamente! \n");
              }
            } while (palavra == null);

            servidor.receba(new TentativaDePalavra(palavra));
          }
        } else {
          servidor.envie();
        }
      } while (!(comunicado instanceof ComunicadoDeFimDePartida));
    } catch (Exception erro) {
      System.out.println(erro);
    }

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
