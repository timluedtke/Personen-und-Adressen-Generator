import java.util.Random;

public class Generator {
    private FileReader fileReader = new FileReader();

    public void prepareGeneration() {
        fileReader.readFile("vornamen_mann.txt", 1);
        fileReader.readFile("vornamen_frau.txt", 2);
        fileReader.readFile("nachnamen.txt", 3);
        fileReader.readFile("strassen.txt", 4);
        fileReader.readFile("plz-ort.txt", 5);
    }

    public Human generateHuman() {
        return new Human(this);
    }

    public String generateMalePrename() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(fileReader.malePrenamelist().length - 1);
        return fileReader.malePrenamelist()[randomInt];
    }

    public String generateFemalePrename() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(fileReader.femalePrenamelist().length - 1);
        return fileReader.femalePrenamelist()[randomInt];
    }

    public String generateLastname() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(fileReader.lastnamelist().length - 1);
        return fileReader.lastnamelist()[randomInt];
    }

    public String generateStreetname() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(fileReader.streetnameslist().length - 1);
        return fileReader.streetnameslist()[randomInt];
    }

    public String generateCity() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(fileReader.plzcitylist().length - 1);
        return fileReader.plzcitylist()[randomInt];
    }

    public int getDemografischesAlter(int startIndex, int stopIndex) {
        //Generate a random number whose value ranges from 0.0 to the sum of the values of yourFunction for all the possible integer return values from startIndex to stopIndex.
        double randomMultiplier = 0;
        for ( int i = startIndex; i <= stopIndex; i++ ) {
            randomMultiplier += demografischeFunktion(i);//yourFunction(startIndex) + yourFunction(startIndex + 1) + .. yourFunction(stopIndex -1) + yourFunction(stopIndex)
        }
        Random r = new Random();
        double randomDouble = r.nextDouble() * randomMultiplier;

        //For each possible integer return value, subtract yourFunction value for that possible return value till you get below 0.  Once you get below 0, return the current value.
        int yourFunctionRandomNumber = startIndex;
        randomDouble = randomDouble - demografischeFunktion(yourFunctionRandomNumber);
        while ( randomDouble >= 0 ) {
            yourFunctionRandomNumber++;
            randomDouble = randomDouble - demografischeFunktion(yourFunctionRandomNumber);
        }
        //System.out.println(yourFunctionRandomNumber);
        return yourFunctionRandomNumber;
    }

    private double demografischeFunktion(double x) {
        return x * x;
    }
}
