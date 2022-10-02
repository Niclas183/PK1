import java.io.File;

public class DirPrinter implements DirVisitor{

    private String tab = "";

    @Override
    public void enter(File f) {
        System.out.printf("%s[%s]%n",tab,f.getName());
        tab+="   ";
    }

    @Override
    public void exit(File f) {
        tab=tab.substring(3);
    }

    @Override
    public void visitFile(File f)
    {
        System.out.printf("%s%s%n",tab,f.getName());
    }
}
