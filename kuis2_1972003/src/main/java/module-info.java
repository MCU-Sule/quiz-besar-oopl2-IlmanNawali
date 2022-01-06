module com.example.kuis_1972003 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.persistence;


    opens com.example.kuis_1972003 to javafx.fxml;
    exports com.example.kuis_1972003;
    exports com.example.Model;
}