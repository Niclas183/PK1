import java.io.*;

public class UpperCaseWriter extends FilterWriter {

    public UpperCaseWriter(Writer w) throws IOException
    {
        super(w);
    }

    public void write(int c) throws IOException
    {
        super.write(c);
    }


    public void write(char[] cbuf, int off, int len) throws IOException
    {
        for(int i = off; i<len; i++)
        {
            write(Character.toUpperCase(cbuf[i]));
        }
    }

    public void write(String str, int off, int len) throws IOException
    {
        for(int i = off; i<len; i++)
        {
            write(Character.toUpperCase(str.charAt(i)));
        }
    }

}
