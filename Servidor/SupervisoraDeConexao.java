import java.io.*;
import java.net.*;
import java.util.*;

public class SupervisoraDeConexao extends Thread {
  private Parceiro usuario;
  private Socket conexao;
  private ArrayList<Parceiro> usuarios;
  private ArrayList<Parceiro> esperaPartida;


  public SupervisoraDeConexao(Socket conexao, ArrayList<Parceiro> usuarios, ArrayList<Parceiro> esperaPartida) throws Exception {
    if (conexao == null) {
      throw new Exception("Conexao ausente");
    }

    if (usuarios == null) {
      throw new Exception("Usuarios ausentes");
    }

    this.conexao = conexao;
    this.usuarios = usuarios;
    this.esperaPartida = esperaPartida;
  }

  public void run() {
    // Transmissor
    ObjectOutputStream transmissor;
    try {
      transmissor = new ObjectOutputStream(
              this.conexao.getOutputStream());
    } catch (Exception erro) {
      return;
    }

    // Receptor
    ObjectInputStream receptor;
    try {
      receptor = new ObjectInputStream(this.conexao.getInputStream());
    } catch (Exception err0) {
      try {
        transmissor.close();
      } catch (Exception falha) {
        // so tentando fechar antes de acabar a thread
      }

      return;
    }

    // Parceiro Usuario
    try {
      this.usuario = new Parceiro(this.conexao, receptor, transmissor);
    } catch (Exception erro) {
      //
    } // sei que passei os parametros corretos

    try {
      synchronized (this.usuarios) {
        this.usuarios.add(this.usuario);
      }

      synchronized (this.esperaPartida) {
        this.esperaPartida.add(this.usuario);

        if (this.esperaPartida.size() == 3) {
          ArrayList<Parceiro> esperaPartidaClone = (ArrayList<Parceiro>) this.esperaPartida.clone();
          Partida partida = new Partida(esperaPartidaClone);

          this.esperaPartida.clear();

          partida.start();
        };
      }
    } catch (Exception erro) {
      try {
        transmissor.close();
        receptor.close();
      } catch (Exception falha) {
        // so tentando fechar antes de acabar a thread
      }

      return;
    }
  }
}
