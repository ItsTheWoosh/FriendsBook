package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateFile {
    public static FileReader fr;
    public static BufferedReader br;
    private static ArrayList<File> files = new ArrayList<>();

    public static ArrayList createAllFiles(String fileName) throws IOException {
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String fileString = "";
        while ((line = br.readLine()) != null) {
            if (!(line.equals(";"))) {
                fileString += line;
            } else {
                parseFile(fileString);
                fileString = "";
            }
        }
        return files;
    }

    private static void parseFile(String string) {
        String name = "";
        name = string;
        files.add(new File(name));
    }
}