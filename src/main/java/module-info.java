module com.cse.oop.myprojects.simplelogin {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.cse.oop.myprojects.simplelogin to javafx.fxml;
    exports com.cse.oop.myprojects.simplelogin;
}