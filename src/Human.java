import java.util.Calendar;
import java.util.Random;

public class Human {
    private boolean gender;   //false=male, true=female
    private String  prename;
    private String  lastname;
    private int     birthyear;
    private Address address;

    public Human(TupleGenerator tupleGenerator) {
        Random randomGenerator = new Random();
        gender = randomGenerator.nextBoolean();
        if ( !gender ) {
            prename = tupleGenerator.generateMalePrename();
        } else {
            prename = tupleGenerator.generateFemalePrename();
        }
        lastname = tupleGenerator.generateLastname();
        birthyear = generateBirthyear(randomGenerator);
        address = new Address(tupleGenerator);
    }

    private int generateBirthyear(Random randomGenerator) {
        int age = randomGenerator.nextInt(90);
        return Calendar.getInstance().get(Calendar.YEAR) - age;
    }

    public String getFullName() {
        return prename + " " + lastname;
    }

    public int getAge() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return year - birthyear;
    }

    public String getGender() {
        if ( !gender ) {
            return "männlich";
        } else {
            return "weiblich";
        }
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return getFullName() + ", " + getGender() + ", " + getAge() + " Jahre alt. Wohnhaft " + address.toString();
    }
}
