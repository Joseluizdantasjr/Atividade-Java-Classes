
import java.util.Scanner;

public class Guerreiro {
  public String nome;
  public int vidas;
  Scanner ler = new Scanner(System.in);
  String pedido;

  public void setNome(String nome){
    this.nome = InOut.leString("> Me diga seu nome nobre guerreiro < ");
  }

  public int getVidas(){
    return this.vidas;
  }

  public String getNome(){
    return this.nome;
  }
  public String vidaExtra(){
    pedido = InOut.leString("> Grite seu pedido de misericordia: < ");
    return pedido;
  }
}