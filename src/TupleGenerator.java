import java.io.IOException;
import java.util.Random;

public class TupleGenerator {
    private FileReader fileReader = new FileReader();

    private String[]   malePrenamelist;
    private String[]   femalePrenamelist;
    private String[]   lastnamelist;
    private String[]   streetnameslist;
    private String[]   plzcitylist;

    public void prepare() {
        try {
            malePrenamelist = fileReader.readFile("data/vornamen_mann.txt");
            femalePrenamelist = fileReader.readFile("data/vornamen_frau.txt");
            lastnamelist = fileReader.readFile("data/nachnamen.txt");
            streetnameslist = fileReader.readFile("data/strassen.txt");
            plzcitylist = fileReader.readFile("data/plz-ort.txt");
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    public Human generateHuman() {
        return new Human(this);
    }

    public String generateMalePrename() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(malePrenamelist.length - 1);
        return malePrenamelist[randomInt];
    }

    public String generateFemalePrename() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(femalePrenamelist.length - 1);
        return femalePrenamelist[randomInt];
    }

    public String generateLastname() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(lastnamelist.length - 1);
        return lastnamelist[randomInt];
    }

    public String generateStreetname() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(streetnameslist.length - 1);
        return streetnameslist[randomInt];
    }

    public String generateCity() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(plzcitylist.length - 1);
        return plzcitylist[randomInt];
    }

    private double demografischeFunktion(double x) {
        return x * x;
    }

    private int getDemografischesAlter(int startIndex, int stopIndex) {
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
}
