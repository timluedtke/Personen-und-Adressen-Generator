import java.io.*;

public class FileReader {
    private String[] malePrenamelist;
    private String[] femalePrenamelist;
    private String[] lastnamelist;

    // nr: 1=malePrenamelist,
    public void readFile(String filename, int nr) {
        try {
            String[] list;
            java.io.FileReader fr;
            fr = new java.io.FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            int lines = 0;
            while ( br.readLine() != null )
                lines++;
            br.close();

            //Reopenfile
            File fileDir = new File(filename);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));

            switch (nr) {
                case 1:
                    if ( malePrenamelist == null || malePrenamelist.length <= 1 ) {
                        malePrenamelist = new String[lines];
                        for ( int i = 0; i < lines; i++ ) {
                            malePrenamelist[i] = br2.readLine();
                        }
                        System.out.println(lines + " männliche Vornamen importiert.");
                    } else {
                        System.out.println("Liste 1 war bereits gefuellt.");
                    }
                    break;
                case 2:
                    if ( femalePrenamelist == null || femalePrenamelist.length <= 1 ) {
                        femalePrenamelist = new String[lines];
                        for ( int i = 0; i < lines; i++ ) {
                            femalePrenamelist[i] = br2.readLine();
                        }
                        System.out.println(lines + " weibliche Vornamen importiert.");
                    } else {
                        System.out.println("Liste 1 war bereits gefüllt.");
                    }
                    break;
                case 3:
                    if ( lastnamelist == null || lastnamelist.length <= 1 ) {
                        lastnamelist = new String[lines];
                        for ( int i = 0; i < lines; i++ ) {
                            lastnamelist[i] = br2.readLine();
                        }
                        System.out.println(lines + " Nachnamen importiert.\r\n");
                    } else {
                        System.out.println("Liste 2 war bereits gefüllt.");
                    }
                    break;
            }
            br2.close();
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    public String[] malePrenamelist() {
        return malePrenamelist;
    }

    public String[] femalePrenamelist() {
        return femalePrenamelist;
    }

    public String[] lastnamelist() {
        return lastnamelist;
    }
}
