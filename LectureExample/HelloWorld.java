public class HelloWorld {

    public static void main(String[] args) {
      //  System.out.println("Luodaan uusi henkilo");

        Person opettaja = new Person();
        opettaja.setName("Ulla Taalasmaa");
        opettaja.setAddress("Kotikatu 4");

        Person opiskelija1 = new Person();
        opiskelija1.setName("Kari TAalasmaa");
        opiskelija1.setAddress("Kotikatu 5");

        Person opiskelija2 = new Person();

      //  opettaja.printPersonInfo();
      //  opiskelija1.printPersonInfo();
      //  opiskelija2.printPersonInfo();

      //  System.out.println("Luodaan varusmies");
        Varusmies ismo = new Varusmies();
        ismo.setName("Ismo Laitela");
        ismo.setAddress("Intion Kasarmi 3");

        ismo.setKasisruoka(false);
        ismo.setVarusNro(-828);

      //  ismo.printPersonInfo();

        Person joku = ismo;
        Person joku2 = opettaja;

        System.out.println("Tulostetaan joku");
        joku.printPersonInfo();

        System.out.println("Tulostetaan joku2");
        joku2.printPersonInfo();
    }
}
