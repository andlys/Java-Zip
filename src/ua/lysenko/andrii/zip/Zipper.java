package ua.lysenko.andrii.zip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static ua.lysenko.andrii.zip.Print.print;

public class Zipper {

    public static void zip(String pathIn, String pathOut) {
        File fileIn = new File(pathIn);
        File fileOut = new File(pathOut);
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(fileOut))) {
            zip(fileIn, zos, "");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        print("Success packing to " + fileOut.getAbsolutePath());
    }

    private static void zip(File fileIn, ZipOutputStream zos, String relativeDir) throws IOException {
        if (fileIn.isDirectory()) {
            String newRelativeDir = zipDirectory(fileIn, zos, relativeDir);
            File[] files = fileIn.listFiles();
            if (Objects.nonNull(files)) {
                for (File f : files) {
                    zip(f, zos, newRelativeDir);
                }
            }
        } else {
            zipFile(fileIn, zos, relativeDir);
        }
    }

    private static void zipFile(File fileIn, ZipOutputStream zos, String relativeDir) throws IOException {
        zos.putNextEntry(new ZipEntry(relativeDir + fileIn.getName()));
        zos.write(Files.readAllBytes(Path.of(fileIn.getAbsolutePath())));
        zos.closeEntry();
        print("filePath " + relativeDir + fileIn.getName());
    }

    private static String zipDirectory(File fileIn, ZipOutputStream zos, String relativeDir) throws IOException {
        String zipEntryName;
        if (relativeDir.isEmpty()) {
            zipEntryName = String.format("%s", fileIn.getName());
        } else {
            zipEntryName = String.format("%s/%s", relativeDir, fileIn.getName());
        }
        print("dirPath " + zipEntryName);
        zos.putNextEntry(new ZipEntry(zipEntryName + "/"));
        zos.closeEntry();
        return zipEntryName;
    }
}
