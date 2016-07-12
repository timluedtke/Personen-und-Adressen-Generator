import java.util.Random;

public class Address {
    private String streetname;
    private int    housenumber;
    private String city;
    private String citycode;
    private String country;

    public Address() {
        housenumber = generateHousenumber();
        streetname = Generator.generateStreetname();
        city = Generator.generateCity();
        citycode = city.substring(0, 5);
        city = city.substring(6, city.length());
    }

    protected static int generateHousenumber() {
        Random randomGenerator = new Random();
        int nr = (int) (Math.abs(randomGenerator.nextGaussian() * 30));
        if ( nr < 1 )
            nr = 1;
        return nr;
    }

    public int getHousenumber() {
        return housenumber;
    }

    public String getCity() {
        return city;
    }

    public String getCitycode() {
        return citycode;
    }

    public String getStreet() {
        return streetname;
    }
}
