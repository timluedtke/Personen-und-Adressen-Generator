import java.util.Random;

public class Address {
    private String streetname;
    private int    housenumber;
    private String city;

    public Address(TupleGenerator tupleGenerator) {
        streetname = tupleGenerator.generateStreetname();
        housenumber = generateHousenumber();
        city = tupleGenerator.generateCity();
    }

    private int generateHousenumber() {
        Random randomGenerator = new Random();
        int housenumber = (int) (Math.abs(randomGenerator.nextGaussian() * 30));
        if ( housenumber < 1 )
            housenumber = 1;
        return housenumber;
    }

    @Override
    public String toString() {
        return streetname + " " + housenumber + ", " + city;
    }
}
