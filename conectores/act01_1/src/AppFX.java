import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.Empleado;
import views.Vista_empleado;

public class AppFX extends Application {

    @Override
    public void start(Stage pantallaPrincipal) throws Exception {
        // Pantalla principal
        GridPane raiz = new GridPane();
        Scene scene = new Scene(raiz, 500, 300);
        MenuBar barraMenus = new MenuBar();
        raiz.setStyle("-fx-padding: 8;" + "-fx-border-style: solid inside;" + "-fx-border-width: 4;"
                + "-fx-border-radius: 6;" + "-fx-border-color: green;");
        barraMenus.setStyle("-fx-border-color: blue;");
        pantallaPrincipal.setTitle("Actividad 1 - Conectores");
        raiz.setVgap(50);
        raiz.addRow(0, barraMenus);

        // Gestor empleado
        Empleado emp = new Empleado();
        Vista_empleado empleadoView = new Vista_empleado(raiz, emp);       

        // Menu Departamento
        Menu Departamento = new Menu("Departamentos");
        Menu addDpto = new Menu("Alta");
        Menu rmDpto = new Menu("Baja");
        Menu updDpto = new Menu("Actualizar");
        Departamento.getItems().addAll(addDpto, rmDpto, updDpto);

        // Agregar menus a barra de menus
        barraMenus.getMenus().addAll(empleadoView.getMenuEmpleado(), Departamento);

        pantallaPrincipal.setScene(scene);
        pantallaPrincipal.show();
        // Eventos de los botones
    } 

    public static void main(String[] args) {
        launch(args);
    }
}
