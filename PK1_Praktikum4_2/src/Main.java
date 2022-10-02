import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

    public static void copy(File from, File to) throws IOException
    {
        RandomAccessFile raFrom = null;
        RandomAccessFile raTo = null;
        try{
            raFrom = new RandomAccessFile(from,"r");
            raTo = new RandomAccessFile(to,"rw");
            long length = raFrom.length();
            byte[] data = new byte[(int)length];
            raFrom.readFully(data);
            raTo.write(data);
        }
        catch(IOException e) {
            System.out.println("Fehler: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
        finally {
            try {
                if(raFrom!=null)
                    raFrom.close();
            }
            catch (IOException e)
            {
                System.out.println("Fehler: " + e.getMessage());
                e.printStackTrace();
            }
            try {
                if(raTo!=null)
                    raTo.close();
            }
            catch (IOException e)
            {
                System.out.println("Fehler: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void copy2(File from, File to) throws IOException
    {
        try(RandomAccessFile raFrom = new RandomAccessFile(from,"r"); RandomAccessFile raTo = new RandomAccessFile(to,"rw") ){
            long length = raFrom.length();
            byte[] data = new byte[(int)length];
            raFrom.readFully(data);
            raTo.write(data);
        }
        catch(IOException e) {
            System.out.println("Fehler: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            copy2(new File("C:\\temp\\input.txt"), new File("C:\\temp\\out.txt"));
        }
        catch(Exception e)
        {
            System.out.println("Test aus Main!");
        }


    }

}
