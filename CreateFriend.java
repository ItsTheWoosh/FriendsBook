package sample;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateFriend {
    private static String n;
    private static String g;
    private static String f;
    private static double r;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Friend> friends = new ArrayList<>();

    public static ArrayList createAllFriends(String fileName) throws IOException {
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String friendString = "";
        while ((line = br.readLine()) != null) {
            if (!(line.equals(";"))) {
                friendString += line;
            } else {
                parseFriend(friendString);
                friendString = "";
            }
        }
        return friends;
    }

    private static void parseFriend(String string) {
        int pos = 0, count = 0, letter = 0;
        String n = "";
        String g = "";
        String f = "";
        double r = 0.0;
        for (int i = 0; i < string.length(); i++) {
            boolean comma = string.substring(i, i + 1).equals(",");
            if (!comma) {
                letter += 1;
            } else if (comma) {
                count += 1;
                if (count == 1) {
                    n = string.substring(0, letter);
                    pos = letter;
                } else if (count == 2) {
                    pos++;
                    letter++;
                    g = string.substring(pos, letter);
                    pos = letter;
                }  else if (count == 3) {
                    pos++;
                    letter++;
                    f = string.substring(pos, letter);
                    pos = letter;
                } else if (count == 4) {
                    r = Double.parseDouble(string.substring(pos, letter));
                }
            }
        }
        friends.add(new Friend(n, g, f, r));
    }
}
