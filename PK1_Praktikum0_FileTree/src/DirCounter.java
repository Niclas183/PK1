import java.io.File;

public class DirCounter implements DirVisitor{

    int folders = 0;
    int files = 0;

    @Override
    public void enter(File f) {
        folders++;
    }

    @Override
    public void exit(File f) {

    }

    @Override
    public void visitFile(File f)
    {
        files++;
    }

    public int numberOfFiles()
    {
        return files;
    }

    public int numberOfFolders()
    {
        return folders;
    }

}
