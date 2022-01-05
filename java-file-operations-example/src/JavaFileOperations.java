import java.io.File;
import java.io.FileWriter;

public class JavaFileOperations {

  private final static String filePath = "/Volumes/MyGitHub/auxiliary/temp-files/java-file-example.txt";
  private final static String fileInput = "I give basic Java sample code snippets every Wednesday from my twitter account, @evrn_tan !!!";

  public static void main(String[] args) {

    File newFile = new File(filePath);

    try {
      if (newFile.exists()) {
        System.out.println("your file's parent path is " + newFile.getParent());
        System.out.println("your file's absolute path is " + newFile.getAbsolutePath());
        System.out.println("your file name is " + newFile.getName());
        System.out.println("your file's size is " + newFile.getTotalSpace() + " bytes");
        System.out.println("your file can be readable (true/false)? " + newFile.canRead());
      } else if (newFile.createNewFile()) {
        System.out.println("Your file " + newFile.getName() + " is created successfully !!!");
      }

      if (newFile.canWrite()) {
        System.out.println("your file can be writable (true/false)? " + newFile.canWrite());
        FileWriter newFileWriter = new FileWriter(filePath);
        newFileWriter.write(fileInput);
        newFileWriter.flush();
        newFileWriter.close();
        System.out.println("file input is successfully written in your file !!!");
      }
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }
}
