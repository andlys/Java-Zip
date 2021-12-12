## An educational CLI tool to zip/unzip any file or directory
###On Windows clone this project, then open CMD, then type:

```
cd C:\projects\ZipCmd
javac -classpath ./classes -d ./classes src/ua/lysenko/andrii/zip/*.java
java -classpath ./classes ua.lysenko.andrii.zip.Main
```

It outputs:
```
C:\projects\ZipCmd>java -classpath ./classes ua.lysenko.andrii.zip.Main
This utility can be used to zip/unzip archives, usage:
-zip fileOrDirectoryToZip output.zip
-unzip file.zip
```

To zip a file:
```
C:\projects\ZipCmd>java -classpath ./classes ua.lysenko.andrii.zip.Main -zip C:\Users\Andrii\Desktop\notes.txt C:\Users\Andrii\Desktop\my_zip_file.zip
filePath notes.txt
Success packing to C:\Users\Andrii\Desktop\my_zip_file.zip
```

To unzip a file:
```
C:\projects\ZipCmd>java -classpath ./classes ua.lysenko.andrii.zip.Main -unzip C:\Users\Andrii\Desktop\my_zip_file.zip
filePath notes.txt
Success unzipping to C:\Users\Andrii\Desktop\my_zip_file
```