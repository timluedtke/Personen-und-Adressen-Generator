import java.io.*;

public class FileReader {
    private String[] malePrenamelist;
    private String[] femalePrenamelist;
    private String[] lastnamelist;
    private String[] streetnameslist;
    private String[] plzcitylist;

    public void readFile(String filename, int switchCase) { //TODO remove this switchCase crap
        try {
            java.io.FileReader fileReader;
            fileReader = new java.io.FileReader(filename);
            BufferedReader br = new BufferedReader(fileReader);
            int lines = 0;
            while ( br.readLine() != null )
                lines++;
            br.close();

            //Reopenfile
            File fileDir = new File(filename);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));

            switch (switchCase) {
                case 1:
                    if ( malePrenamelist == null || malePrenamelist.length <= 1 ) {
                        malePrenamelist = new String[lines];
                        for ( int i = 0; i < lines; i++ ) {
                            malePrenamelist[i] = br2.readLine();
                        }
                        System.out.println(lines + " männliche Vornamen importiert.");
                    }
                    break;
                case 2:
                    if ( femalePrenamelist == null || femalePrenamelist.length <= 1 ) {
                        femalePrenamelist = new String[lines];
                        for ( int i = 0; i < lines; i++ ) {
                            femalePrenamelist[i] = br2.readLine();
                        }
                        System.out.println(lines + " weibliche Vornamen importiert.");
                    }
                    break;
                case 3:
                    if ( lastnamelist == null || lastnamelist.length <= 1 ) {
                        lastnamelist = new String[lines];
                        for ( int i = 0; i < lines; i++ ) {
                            lastnamelist[i] = br2.readLine();
                        }
                    System.out.println(lines + " Nachnamen importiert.");
                }
                break;
            case 4:
                if ( streetnameslist == null || streetnameslist.length <= 1 ) {
                    streetnameslist = new String[lines];
                    for ( int i = 0; i < lines; i++ ) {
                        streetnameslist[i] = br2.readLine();
                    }
                    System.out.println(lines + " Straßennamen importiert.");
                }
                break;
            case 5:
                if ( plzcitylist == null || plzcitylist.length <= 1 ) {
                    plzcitylist = new String[lines];
                    for ( int i = 0; i < lines; i++ ) {
                        plzcitylist[i] = br2.readLine();
                    }
                    System.out.println(lines + " Cities importiert.\r\n");
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

    public String[] streetnameslist() {
        return streetnameslist;
    }

    public String[] plzcitylist() {
        return plzcitylist;
    }
}
