package ua.lysenko.andrii.zip;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        String pathInput = "C:\\projects\\ZipCmd\\src\\ua\\lysenko\\andrii\\zip\\Zipper.java";
        String pathInput = "C:\\projects\\ZipCmd\\src\\ua\\lysenko\\andrii\\zip";
        String pathOfZipFile = "C:\\Users\\Andrii\\Desktop\\zip_file.zip";
//        wait to open VisualVM manually in time to monitor memory consumption
//        Thread.sleep(10000);
        Zipper.zip(pathInput, pathOfZipFile);
        UnZipper.unzip(pathOfZipFile);
    }
}
