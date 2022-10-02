package Datenhaltung;

import Fachlogik.Medium;

import java.io.*;
import java.util.List;

public class SerializableIDao implements IDao{

    String speicherOrt;

    public SerializableIDao(String s)
    {
        speicherOrt = s;
    }

    @Override
    public void speichern(List<Medium> liste) throws PersistenzException {
        try(FileOutputStream fos = new FileOutputStream(speicherOrt); ObjectOutputStream os = new ObjectOutputStream(fos))
        {
            os.writeObject(liste);
        }
        catch(IOException e)
        {
            throw new PersistenzException(e);
        }
    }

    @Override
    public List<Medium> laden() throws PersistenzException {
        List<Medium> l;
        try(FileInputStream fis = new FileInputStream(speicherOrt); ObjectInputStream os = new ObjectInputStream(fis))
        {

            l = (List<Medium>)os.readObject();
        }
        catch(IOException | ClassNotFoundException | ClassCastException e)
        {
            System.out.println("test");
            throw new PersistenzException(e);
        }
        return l;
    }
}
