public class Main {
    public static void main(String[] args) {
        System.out.println("Personen-und-Adressen-Generator v0.4");

        TupleGenerator tupleGenerator = new TupleGenerator();
        tupleGenerator.prepare();
        int generateNumber = 20;

        Human[] humans = new Human[generateNumber];
        for ( int i = 0; i < generateNumber; i++ ) {
            humans[i] = tupleGenerator.generateHuman();
            System.out.println((i + 1) + ". " + humans[i].toString());
        }
    }
}