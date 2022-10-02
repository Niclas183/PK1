package Datenhaltung;

public class PersistenzException extends Exception{

    public PersistenzException()
    {
        super();
    }

    public PersistenzException(String s)
    {
        super(s);
    }

    public PersistenzException(Exception e)
    {
        super(e);
    }

}
