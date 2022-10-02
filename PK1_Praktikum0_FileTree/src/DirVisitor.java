import java.io.File;

public interface DirVisitor {

    void enter(File f);
    void visitFile(File f);
    void exit(File f);

}
