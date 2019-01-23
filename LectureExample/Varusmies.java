
public class Varusmies extends Person {
  private int varusNumero;
  private Boolean kasvisruokailija;

  public void setKasisruoka(Boolean kasvis) {
    this.kasvisruokailija = kasvis;
  }

  public void setVarusNro(int numero) {
    if(numero < 0) {
      System.out.println("Varusmiesnumero ei voi olla negatiivinen!");
      return;
    }
    this.varusNumero = numero;
  }

  public void printPersonInfo() {
    super.printPersonInfo();
    System.out.println("VarusmiesNro: "+varusNumero + "Kasvis: " + kasvisruokailija);
  }
  
  // Vastaavat getter-metodit tahan, ei tehdä ajanpuutteen vuoksi.
}
