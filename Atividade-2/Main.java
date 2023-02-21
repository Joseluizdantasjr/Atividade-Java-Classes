

class Main {
  public static void main(String[] args) {
    Oraculo o = new Oraculo();
    Guerreiro g = new Guerreiro();
    o.setNome("Oráculo mestre");
    o.guerreiro = g;
    g.setNome(g.nome);
   
    o.setVidas();
    o.prologoIntroducao();
    o.loadLevel1();
  }
}