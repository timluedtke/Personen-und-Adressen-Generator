import java.util.Calendar;
import java.util.Random;

public class Human {
    private boolean gender;   //false=male, true=female
    private String  prename;
    private String  lastname;
    private int     birthyear;

    public Human() {
        Random randomGenerator = new Random();
        gender = randomGenerator.nextBoolean();
        if ( !gender ) {
            prename = Generator.generateMalePrename();
        } else {
            prename = Generator.generateFemalePrename();
        }
        lastname = Generator.generateLastname();
        int age = randomGenerator.nextInt(90);
        birthyear = Calendar.getInstance().get(Calendar.YEAR) - age;
    }

    public String getName() {
        return prename + " " + lastname;
    }

    public String getGender() {
        if ( !gender ) {
            return "maennlich";
        } else {
            return "weiblich";
        }
    }

    public int getAge() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return year - birthyear;
    }
}
