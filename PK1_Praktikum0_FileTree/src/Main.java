import java.io.File;

public class Main {

    public static void main(String[] args) {

        DirCounter dc = new DirCounter();
        FileTree ft = new FileTree(dc);
        ft.traverse(new File("C:\\temp"));
        System.out.println("Ordner: " + dc.numberOfFolders());
        System.out.println("Dateien: " + dc.numberOfFiles());
    }

}
