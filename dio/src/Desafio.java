import java.util.Scanner;

abstract class Cofre {
  protected String tipo;
  protected String metodoAbertura;

  public Cofre(String tipo, String metodoAbertura) {
    this.tipo = tipo;
    this.metodoAbertura = metodoAbertura;
  }

  public void imprimirInformacoes() {
    System.out.println("Tipo: " + this.tipo);
    System.out.println("Metodo de abertura: " + this.metodoAbertura);
  }
}

class CofreDigital extends Cofre {

  private int senha;

  public CofreDigital(int senha) {
    super("Cofre Digital", "Senha");
    this.senha = senha;
  }

  public boolean validarSenha(int confirmacaoSenha) {
    return confirmacaoSenha == this.senha;
  }
}

class CofreFisico extends Cofre {

  public CofreFisico() {
    super("Cofre Fisico", "Chave");
  }

}

public class Desafio {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String tipoCofre = scanner.nextLine();
    if(tipoCofre.equals("digital")){
      int senha = scanner.nextInt();
      CofreDigital cofre = new CofreDigital(senha);
      cofre.tipo = "Cofre Digital";
      cofre.metodoAbertura = "Senha";
      cofre.imprimirInformacoes();
      int senhaTeste = scanner.nextInt();
      if(cofre.validarSenha(senhaTeste)){
        System.out.println("Cofre aberto!");
      }else{
        System.out.println("Senha incorreta!");
      }
      
        
      }else{
      CofreFisico cofre = new CofreFisico();
      cofre.tipo = "Cofre Fisico";
      cofre.metodoAbertura = "Chave";
      cofre.imprimirInformacoes();
      

    } 


    }



    }