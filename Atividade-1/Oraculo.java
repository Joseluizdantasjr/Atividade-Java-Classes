

import java.util.Random;

public class Oraculo{
  String nome;
  Guerreiro guerreiro;
  Random geradorVidas = new Random();
  int vidas;
  Random geradorSegredo = new Random();
  int segredo;
  int palpite;
  int numPalavras;
  int usada;
  Random geradorNumero = new Random();

public void setNome(String nome){
  this.nome = nome;
}

public int setVidas(){
  this.guerreiro.vidas = geradorVidas.nextInt(4) + 9;
  return this.guerreiro.vidas;
}
public String prologoIntroducao(){
  String prologo = (" Seja bem vindo ao jogo " + guerreiro.getNome() + "! Meu nome é " + nome + " e você possui " + guerreiro.getVidas() + " vidas. \n Boa sorte");
  InOut.MsgDeInformacao(nome + " diz: ", prologo);
  return prologo;
  
}
public int loadLevel1(){
  segredo = geradorSegredo.nextInt(100) + 1;
  System.out.println(segredo);
  while(guerreiro.getVidas() != 0){
  palpite = InOut.leInt("> Descubra meu número secreto ! <");
  if(palpite == segredo){
    InOut.MsgDeInformacao(nome + " diz: ", " > Parabéns você descobriu o número secreto! <");
    loadLevel2();
    break;
    }
  else if(palpite > segredo){
    InOut.MsgDeErro(nome + " diz: ", "> Você errou! Meu número secreto é menor que  " + palpite + " <");
    guerreiro.vidas -= 1;
    InOut.MsgDeAviso(nome + " diz: ", "> Agora você tem " + guerreiro.vidas + " vidas <");
    }
  else if(palpite < segredo){
    InOut.MsgDeErro(nome + " diz: ", "> Você errou! Meu número secreto é maior que " + palpite + " <");
    guerreiro.vidas -= 1;
    InOut.MsgDeAviso(nome + " diz: ", "> Agora você tem  " + guerreiro.vidas + " vidas <");
    }
  }
  if(guerreiro.getVidas() == 0 && usada != 1){
    InOut.MsgDeAviso(nome + " diz: ", "> Acabaram suas vidas! Peça misericórdia imediatamente, se quiser ter a chance de viver. <");
    guerreiro.vidaExtra();
    decidirVidaExtra(guerreiro.pedido);
    if(decidirVidaExtra(guerreiro.pedido) && usada != 1){
      InOut.MsgDeInformacao(nome + " diz: ", " > Você conseguiu minha misericórdia. Desfrute de mais uma vida! <");
      guerreiro.vidas = 1;
      palpite = InOut.leInt("> Descubra meu número secreto ! <");
        if(palpite == segredo){
        InOut.MsgDeInformacao(nome + " diz: ", " > Parabéns você descobriu o número secreto! <");
       usada = 1; 
       loadLevel2();
         
    }
        else if(palpite > segredo){
        InOut.MsgDeErro(nome + " diz: ", "> Você errou! Meu número secreto é menor que  " + palpite + " <");
        guerreiro.vidas -= 1;
        usada = 1;
        prologoPerdedor();
        
    }
         else if(palpite < segredo){
        InOut.MsgDeErro(nome + " diz: ", "> Você errou! Meu número secreto é maior que " + palpite + " <");
        guerreiro.vidas -= 1;
        usada = 1;
        prologoPerdedor();
        
    }   
    }
    else{
    InOut.MsgDeErro(nome + " diz: ", "Não foi dessa vez que te darei misericórdia! <");
      usada = 1;
      prologoPerdedor();
      
    }
  }
  return 0;
}
public void loadLevel2(){
  int opcao;
  InOut.MsgDeInformacao(nome + " diz: ", "Voce alcancou o level 2");
  while(guerreiro.getVidas() != 0){
  opcao = InOut.leInt("Digite 0 para par ou 1 para impar");
  if(opcao > 1 || opcao < 0){
    InOut.MsgDeErro(nome + " diz: ", "> Eu falei para digitar 0 ou 1! <");
  }
  else{ 
  int numOraculo = geradorNumero.nextInt(5);
  int numGuerreiro = geradorNumero.nextInt(5);
  int soma = numOraculo + numGuerreiro;
  int resultado;
  InOut.MsgDeInformacao(nome + " diz: ", "> Meu número = " + numOraculo + "\n Seu numero = " + numGuerreiro + " <");
  if(soma % 2 == 0){
    resultado = 0;
    if(opcao == resultado){
    prologoVencedor();
    break;
    }
    else if(opcao != resultado){
    guerreiro.vidas -= 1;
    InOut.MsgDeAviso(nome + " diz: ", "> Agora você tem  " + guerreiro.vidas + " vidas <");
    }
  }
  else if(soma % 2 != 0){
    resultado = 1;
    if(opcao == resultado){
    prologoVencedor();
    break;
    }
    else if(opcao != resultado){
    guerreiro.vidas -= 1;
    InOut.MsgDeAviso(nome + " diz: ", "> Agora você tem  " + guerreiro.vidas + " vidas <");
    }
  }
  
  }
    if(guerreiro.getVidas() == 0 && usada != 1){
    InOut.MsgDeAviso(nome + " diz: ", "> Acabaram suas vidas! Peça misericórdia imediatamente, se quiser ter a chance de viver. <");
    guerreiro.vidaExtra();
    this.decidirVidaExtra(this.guerreiro.pedido);
    if(this.decidirVidaExtra(this.guerreiro.pedido) && usada != 1){
      InOut.MsgDeInformacao(nome + " diz: ", " > Você conseguiu minha misericórdia. Desfrute de mais uma vida! <");
      guerreiro.vidas = 1;
      opcao = InOut.leInt("Digite 0 para par ou 1 para impar");
      int numOraculo = geradorNumero.nextInt(5);
      int numGuerreiro = geradorNumero.nextInt(5);
      int soma = numOraculo + numGuerreiro;
      int resultado;
      InOut.MsgDeInformacao(nome + " diz: ", "> Meu número = " + numOraculo + "\n Seu numero = " + numGuerreiro + " <");
      
  if(soma % 2 == 0){
    resultado = 0;
    if(opcao == resultado){
    usada = 1;
    prologoVencedor();
    
    }
    else if(opcao != resultado){
    usada = 1;
    prologoPerdedor();
    
    }
  }
  else if(soma % 2 != 0){
    resultado = 1;
    if(opcao == resultado){
    usada = 1;
    prologoVencedor();
    
    }
    else if(opcao != resultado){
    usada = 1;
    prologoPerdedor();
    
    }
  }

    }   

    else{
    InOut.MsgDeErro(nome + " diz: ", "Não foi dessa vez que te darei misericórdia! <");
    usada = 1;  
    prologoPerdedor();
      
    }
}
  else if (guerreiro.getVidas() == 0 && usada == 1){
    prologoPerdedor();
  }
}
}
public boolean decidirVidaExtra(String misericordia){
  for(int index = 0; index < misericordia.length(); index++){
    if(misericordia.charAt(index) == ' '){
      numPalavras++;
    }
  }
  if(numPalavras > 6){
    return true;
  }
  else{
    return false;
  }
}
public String prologoPerdedor(){
  String prologo = (" Você perdeu " + guerreiro.getNome() + ". Eu, " + nome + " sou o vencedor hoje. \n Mais sorte da proxima vez");
  InOut.MsgDeInformacao(nome + " diz: ", prologo);
  return prologo;
}
public String prologoVencedor(){
  String prologo2 = (" Você venceu " + guerreiro.getNome() + ". Eu, " + nome + " sou o perdedor hoje. \n Parabéns");
  InOut.MsgDeInformacao(nome + " diz: ", prologo2);
  return prologo2;
}

  
}