import java.io.*;
import java.util.Random;

public class Generator {
	private static String[] malePrenamelist;
	private static String[] femalePrenamelist;
	private static String[] lastnamelist;


	public static void prepareGeneration(){
		readFile("vornamen_mann.txt", 1);
		readFile("vornamen_frau.txt", 2);
		readFile("nachnamen.txt", 3);
	}

	public static String generateFullName(){
		return generateMalePrename()+" "+generateLastname();
	}

	public static String generateMalePrename(){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(malePrenamelist.length-1);
		return malePrenamelist[randomInt];
	}

	public static String generateFemalePrename(){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(femalePrenamelist.length-1);
		return femalePrenamelist[randomInt];
	}

	public static String generateLastname(){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(lastnamelist.length-1);
		return lastnamelist[randomInt];
	}



	// nr: 1=malePrenamelist,
	private static void readFile(String filename, int nr){
		try {
			String[] list;
			FileReader fr;
			fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			int lines = 0;
			while (br.readLine() != null) lines++;
			br.close();

			//Reopenfile
			File fileDir = new File(filename);
			BufferedReader br2 = new BufferedReader(
					new InputStreamReader(new FileInputStream(fileDir), "UTF8"));

			switch(nr){
				case 1:
					if(malePrenamelist == null || malePrenamelist.length <= 1){
						malePrenamelist = new String[lines];
						for(int i=0;i<lines;i++){
							malePrenamelist[i] = br2.readLine();
						}
						System.out.println(lines+" maennliche Vornamen importiert.");
					}
					else {
							System.out.println("Liste 1 war bereits gefuellt.");
					}
					break;
				case 2:
					if(femalePrenamelist == null || femalePrenamelist.length <= 1){
						femalePrenamelist = new String[lines];
						for(int i=0;i<lines;i++){
							femalePrenamelist[i] = br2.readLine();
						}
						System.out.println(lines+" weibliche Vornamen importiert.");
					}
					else {
							System.out.println("Liste 1 war bereits gefaellt.");
					}
					break;
				case 3:
					if(lastnamelist == null || lastnamelist.length <= 1){
						lastnamelist = new String[lines];
						for(int i=0;i<lines;i++){
							lastnamelist[i] = br2.readLine();
						}
						System.out.println(lines+" Nachnamen importiert.");
					}
					else {
						System.out.println("Liste 2 war bereits gefuellt.");
					}
					break;
			}
			br2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int getDemografischesAlter(int startIndex, int stopIndex) {
	    //Generate a random number whose value ranges from 0.0 to the sum of the values of yourFunction for all the possible integer return values from startIndex to stopIndex.
	    double randomMultiplier = 0;
	    for (int i = startIndex; i <= stopIndex; i++) {
	        randomMultiplier += demografischeFunktion(i);//yourFunction(startIndex) + yourFunction(startIndex + 1) + .. yourFunction(stopIndex -1) + yourFunction(stopIndex)
	    }
	    Random r = new Random();
	    double randomDouble = r.nextDouble() * randomMultiplier;

	    //For each possible integer return value, subtract yourFunction value for that possible return value till you get below 0.  Once you get below 0, return the current value.
	    int yourFunctionRandomNumber = startIndex;
	    randomDouble = randomDouble - demografischeFunktion(yourFunctionRandomNumber);
	    while (randomDouble >= 0) {
	        yourFunctionRandomNumber++;
	        randomDouble = randomDouble - demografischeFunktion(yourFunctionRandomNumber);
	    }
	    	//System.out.println(yourFunctionRandomNumber);
	    return yourFunctionRandomNumber;
	}

	private static double demografischeFunktion(double x){
		return x*x;
	}
}
