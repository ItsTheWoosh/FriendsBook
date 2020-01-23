package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class File {
    public String name;

    File(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public void fileToFile(String n) throws IOException {
        FileWriter fw = new FileWriter(n, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name + "\r");
        bw.write(";" + "\r");
        bw.close();
    }
}
