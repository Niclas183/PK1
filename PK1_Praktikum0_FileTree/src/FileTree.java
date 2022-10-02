import java.io.File;

public class FileTree {

    private DirVisitor dv;

    public FileTree(DirVisitor dv)
    {
        this.dv=dv;
    }

    public void traverse(File dir)
    {
        if(dir.isDirectory())
        {
            dv.enter(dir);
            File[] files = dir.listFiles();
            for(File f: files)
            {
                if(f.isDirectory())
                    traverse(f);
                else
                    dv.visitFile(f);
            }
            dv.exit(dir);
        }
    }

}
