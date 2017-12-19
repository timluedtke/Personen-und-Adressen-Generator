import java.util.Random;

public class Address {
    private String streetname;
    private int    housenumber;
    private String city;
    private String country;

    public Address(Generator generator) {
        housenumber = generateHousenumber();
        streetname = generator.generateStreetname();
        city = generator.generateCity();
        country = "Germany";
    }

    private int generateHousenumber() {
        Random randomGenerator = new Random();
        int housenumber = (int) (Math.abs(randomGenerator.nextGaussian() * 30));
        if ( housenumber < 1 )
            housenumber = 1;
        return housenumber;
    }

    public String getStreetname() {
        return streetname;
    }

    public String getCity() {
        return city;
    }

    public int getHousenumber() {
        return housenumber;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "";
    }
}
