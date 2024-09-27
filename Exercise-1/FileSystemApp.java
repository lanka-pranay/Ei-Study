//structural design pattern
//Example 1

//Use Case: A file system that allows individual files and directories to be treated uniformly.
import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
    void showDetails();
}

class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}

class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.showDetails(); // Recursive call for components
        }
    }
}

// Example usage
public class FileSystemApp {
    public static void main(String[] args) {
        Directory root = new Directory("Root");
        File file1 = new File("File1.txt");
        File file2 = new File("File2.txt");

        Directory subDir = new Directory("SubDir");
        subDir.add(new File("File3.txt"));

        root.add(file1);
        root.add(file2);
        root.add(subDir);

        root.showDetails(); // Show structure
    }
}
