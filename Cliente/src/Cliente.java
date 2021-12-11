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

    boolean partidaTerminou = false;

    Terminal.clear();
    System.out.println("Aguarde a jogada dos outros jogadores...\n");
    try {
      Comunicado comunicado;
      do {
        comunicado = servidor.espie();

        if (comunicado instanceof ComunicadoDeJogadaDeOutroJogador) {
          ComunicadoDeJogadaDeOutroJogador jogada = (ComunicadoDeJogadaDeOutroJogador) servidor.envie();

          System.out.println("Palavra...: " + jogada.getTracinhos());
          System.out.println("Digitadas.: " + jogada.getLetrasJaDigitadas() + "\n");

          System.out.println("Aguarde a jogada dos outros jogadores...\n");
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
              
            servidor.receba(new TentativaDeLetra(Character.toUpperCase(letra)));

            Comunicado statusLetra;
            do {
              statusLetra = servidor.espie();

              if (statusLetra == null) {
                continue;
              }

              Terminal.clear();

              if (statusLetra instanceof ComunicadoDeResultado) {
                partidaTerminou = true;
                break;
              } else if (statusLetra instanceof ComunicadoLetraJaDigitada) {
                System.out.println("Essa letra ja foi digitada!\n");
                break;
              } else if (statusLetra instanceof ComunicadoLetraErrada) {
                System.out.println("A palavra nao tem essa letra!\n");
                break;
              } else if (statusLetra instanceof ComunicadoLetraCorreta) {
                System.out.println("Parabens, voce acertou a letra\n");
                break;
              }
            } while (true);
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

            servidor.receba(new TentativaDePalavra(palavra.toUpperCase()));

            Comunicado statusPalavra;
            do {
              statusPalavra = servidor.espie();

              if (statusPalavra == null) {
                continue;
              }

              if (statusPalavra instanceof ComunicadoDeResultado) {
                partidaTerminou = true;
                break;
              }
            } while (true);
          }
        } else {
          servidor.envie();
        }
      } while (!partidaTerminou);
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
