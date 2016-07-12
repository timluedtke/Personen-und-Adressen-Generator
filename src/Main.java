public class Main {
    public static void main(String[] args) {
        System.out.println("People Generator v0.1");

        Generator.prepareGeneration();
        System.out.println("");

        int generateNumber = 20;
        Human[] humans = new Human[generateNumber];

        for ( int i = 0; i < generateNumber; i++ ) {
            humans[i] = new Human();
            System.out.println((i + 1) + ". " + humans[i].getName() + ", " + humans[i].getGender() + ", " + humans[i].getAge() + " Jahre alt");
        }
    }
}