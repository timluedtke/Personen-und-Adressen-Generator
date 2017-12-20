public class Main {
    public static void main(String[] args) {
        System.out.println("Personen-und-Adressen-Generator v0.5");

        int numberOfTuplesToBeGenerated = 20;
        if ( args.length > 0 ) {
            try {
                numberOfTuplesToBeGenerated = Integer.parseInt(args[0]);
            } catch ( NumberFormatException e ) {
                System.out.println("Bitte überprüfen sie ihre Programm-Parameter!");
            }
        }

        TupleGenerator tupleGenerator = new TupleGenerator();
        tupleGenerator.prepare();

        Human[] humans = new Human[numberOfTuplesToBeGenerated];
        for ( int i = 0; i < numberOfTuplesToBeGenerated; i++ ) {
            humans[i] = tupleGenerator.generateHuman();
            System.out.println((i + 1) + ". " + humans[i].toString());
        }
    }
}