module org.intissar.jasper1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires net.sf.jasperreports.core;
    requires java.sql;


    opens org.intissar.jasper1 to javafx.fxml;
    exports org.intissar.jasper1;
}