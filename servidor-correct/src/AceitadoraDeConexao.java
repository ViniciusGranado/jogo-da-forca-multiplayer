import java.net.*;
import java.util.*;

public class AceitadoraDeConexao extends Thread {
  private ServerSocket pedido;
  private ArrayList<Parceiro> usuarios;
  private ArrayList<Parceiro> esperaPartida;

  public AceitadoraDeConexao(String porta, ArrayList<Parceiro> usuarios, ArrayList<Parceiro> esperaPartida)
      throws Exception {
    if (porta == null)
      throw new Exception("Porta ausente");

    try {
      this.pedido = new ServerSocket(Integer.parseInt(porta));
    } catch (Exception erro) {
      throw new Exception("Porta invalida");
    }

    if (usuarios == null)
      throw new Exception("Usuarios ausentes");

    this.usuarios = usuarios;
    this.esperaPartida = esperaPartida;
  }

  public void run() {
    for (;;) {
      Socket conexao = null;
      try {
        conexao = this.pedido.accept();
      } catch (Exception erro) {
        continue;
      }

      SupervisoraDeConexao supervisoraDeConexao = null;
      try {
        supervisoraDeConexao = new SupervisoraDeConexao(conexao, usuarios, esperaPartida);
      } catch (Exception erro) {
        //
      }

      supervisoraDeConexao.start();
    }
  }
}
