public class Main {
    public static void main(String[] args) {
        System.out.println("People Generator v0.3");

        Generator generator = new Generator();
        generator.prepareGeneration();
        int generateNumber = 20;

        Human[] humans = new Human[generateNumber];
        for ( int i = 0; i < generateNumber; i++ ) {
            humans[i] = generator.generateHuman();
            System.out.println((i + 1) + ". " + humans[i].toString());
        }
    }
}