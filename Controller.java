package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    public TextField friendName;
    public CheckBox genderMale;
    public CheckBox genderFemale;
    public CheckBox genderOther;
    public TextField friendFood;
    public Slider friendRating;
    public ListView<Friend> friendsList = new ListView<>();
    public Label labelName;
    public Label labelGender;
    public Label labelFood;
    public Label labelRating;
    public Button addFriendBtn;
    public Button friendSave;
    public Button FriendLoad;
    public TextField fileName;
    public Button newFile;
    public ListView<File> fileList;
    public Button saveLoad;
    private int stopCheck = 0;

    public void addFriend(ActionEvent actionEvent) {
        stopCheck++;
        if (friendFood.getText().equals("") || friendName.getText().equals("")) {
            Error.friendError();

        } else if (!genderFemale.isSelected() && !genderMale.isSelected() && !genderOther.isSelected()) {
            Error.friendError();
        } else {
            String gender = "";
            if (genderMale.isSelected()) {
                gender = "Male";
            } else if (genderFemale.isSelected()) {
                gender = "Female";
            } else if (genderOther.isSelected()) {
                gender = "Other";
            } else {
                Error.friendError();
            }
            String food = friendFood.getText();
            String name = friendName.getText();
            Double rate = friendRating.getValue();
            Friend temp = new Friend(name, gender, food, rate);
            friendsList.getItems().add(temp);
            friendName.clear();
            if (genderMale.isSelected()) genderMale.fire();
            else if (genderFemale.isSelected()) genderFemale.fire();
            else if (genderOther.isSelected()) genderOther.fire();
            friendFood.clear();
            friendRating.setValue(0.0);
            stopCheck++;
        }
    }

    public void otherCheck(ActionEvent actionEvent) {
        do {
            if (genderOther.isSelected() && genderFemale.isSelected()) {
                Error.errorAlert();
            } else if (genderOther.isSelected() && genderMale.isSelected()) {
                Error.errorAlert();
            }
        } while (stopCheck == 1);
    }

    public void femaleCheck(ActionEvent actionEvent) {
        do {
            if (genderFemale.isSelected() && genderOther.isSelected()) {
                Error.errorAlert();
            } else if (genderFemale.isSelected() && genderMale.isSelected()) {
                Error.errorAlert();
            }
        } while (stopCheck == 1);
    }

    public void maleCheck(ActionEvent actionEvent) {
        if (genderMale.isSelected() && genderOther.isSelected()) {
            Error.errorAlert();
        } else if (genderMale.isSelected() && genderFemale.isSelected()) {
            Error.errorAlert();
        }
    }

    public void displayFriend(MouseEvent mouseEvent) {
        Friend temp;
        temp = friendsList.getSelectionModel().getSelectedItem();
        labelName.setText(temp.name);
        labelFood.setText(temp.getFavFood());
        labelGender.setText(temp.getGender());
        labelRating.setText(Double.toString(temp.getRating()));
    }

    public void DeleteFriend(ActionEvent actionEvent) {
        final int select = friendsList.getSelectionModel().getSelectedIndex();
        friendsList.getItems().remove(select);
        labelName.setText("");
        labelFood.setText("");
        labelGender.setText("");
        labelRating.setText("");
    }

    public void SaveFriend(ActionEvent actionEvent) throws IOException {
        ObservableList<Friend> myList = friendsList.getItems();
        String ok = fileName.getText();
        for (Friend f : myList) {
            f.writeToFile(ok);
        }
        File f = new File(ok);
        f.fileToFile("Saves");
        friendsList.getItems().clear();
        fileName.clear();
    }

    public void LoadFriend(ActionEvent actionEvent) throws IOException {
        friendsList.getItems().clear();
        String g = "yeet"/*(fileList.getItems()).toString()*/;
        ArrayList<Friend> friends = CreateFriend.createAllFriends(g);
        for (Friend f : friends) {
            friendsList.getItems().add(f);
        }
    }

    public void fileStart(MouseEvent mouseEvent) {
        newFile.setDisable(false);
    }

    public void LoadSaves(MouseEvent mouseEvent) throws IOException {
        fileList.getItems().clear();
        String s = "Saves";
        ArrayList<File> files = CreateFile.createAllFiles(s);
        for (File f : files) {
            fileList.getItems().add(f);
        }
    }
}
