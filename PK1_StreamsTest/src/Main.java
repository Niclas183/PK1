import java.io.*;

public class Main {

    public static void sayHello(OutputStream s) throws IOException {
        String t = "Hello World";
        OutputStreamWriter sw = new OutputStreamWriter(s);
        sw.write(t.toCharArray());
        sw.flush();
    }

    public static void main(String[] args) {
        File f = new File("C:\\temp\\test.txt");
        File f2 = new File("C:\\temp\\test2.txt");

        FileOutputStream test = null;
        FileInputStream test2 = null;
        BufferedOutputStream buffer = null;
        PrintStream ps = null;
        try {
             test = new FileOutputStream(f);
             test2 = new FileInputStream(f2);
             buffer = new BufferedOutputStream(test);
             int c;
             while((c=test2.read()) != -1)
             {
                 buffer.write(c);
             }
        }
        catch(Exception e)
        {

        }




    }

}
