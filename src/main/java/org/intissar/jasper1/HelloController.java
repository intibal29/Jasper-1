package org.intissar.jasper1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.sql.DriverManager;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        try {
            // Ruta del archivo Jasper (ya compilado)
            String reportPath = getClass().getResource("/jasper/ejer1.jasper").getPath();

            // Configurar conexión a la base de datos
            String dbUrl = "jdbc:mysql://localhost:3306/paises";
            String dbUser = "root";
            String dbPassword = "1234";

            // Establecer conexión a la base de datos
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            // Llenar el informe con datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, null, connection);

            // Mostrar el informe
            JasperViewer.viewReport(jasperPrint, false);

            // Cerrar la conexión
            connection.close();

            // Confirmar en la interfaz
            welcomeText.setText("Reporte generado correctamente!");
        } catch (Exception e) {
            // Mostrar error en la interfaz
            welcomeText.setText("Error al generar el reporte: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
