package ua.lysenko.andrii.zip;

public class Main {

    public static void main(String[] args) {
        String pathIn = "C:\\projects\\ZipCmd\\src\\ua\\lysenko\\andrii\\zip\\Zipper.java";
//        String pathIn = "C:\\projects\\ZipCmd\\src";
        String pathOut = "C:\\Users\\Andrii\\Desktop\\zip_file.zip";
        Zipper.zip(pathIn, pathOut);
    }
}
