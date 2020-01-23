package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Friend {
    public String name;
    private String gender;
    private String favFood;
    private Double rating;

    Friend(String n, String g, String f, Double r) {
        name = n;
        gender = g;
        favFood = f;
        rating = r;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getFavFood() {
        return favFood;
    }

    public Double getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFavFood(String favFood) {
        this.favFood = favFood;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String toString() {
        return name;
    }

    public void writeToFile(String s) throws IOException {
        FileWriter fw = new FileWriter(s, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name + ",\r");
        bw.write(gender + ",\r");
        bw.write(favFood + ",\r");
        bw.write(Double.toString(rating) + "\r");
        bw.write(";\r");
        bw.close();
    }

    public void fileToFile(String n) throws IOException {
        FileWriter fw = new FileWriter(n, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name + "\r");
        bw.write(";" + "\r");
        bw.close();
    }
}
