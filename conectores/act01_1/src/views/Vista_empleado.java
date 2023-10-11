package views;

import controllers.Controlador_empleado;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import models.Empleado;

public class Vista_empleado {
    private Menu menu_Empleado;

    public Vista_empleado(GridPane raiz, Empleado emp){
        // Menu Empleado
        MenuItem addEmp = new MenuItem("Alta");
        MenuItem rmEmp = new MenuItem("Baja");
        MenuItem updEmp = new MenuItem("Actualizar");
        MenuItem getEmp  = new MenuItem("Listar");
        Button guardar = new Button("Guardar");
        menu_Empleado = new Menu("Empleados");
        menu_Empleado.getItems().addAll(addEmp, rmEmp, updEmp, getEmp);
        Text text = new Text();
        text.setText("Agregar empleado:");
        text.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Label nombre = new Label("Nombre");
        Label apellido = new Label("Apellido");
        Label dni = new Label("DNI");

        raiz.addRow(1, text);
        raiz.setVgap(10);
        raiz.addRow(2, nombre, emp.getNombre());
        raiz.setVgap(10);
        raiz.addRow(3, apellido, emp.getApellido());
        raiz.setVgap(10);
        raiz.addRow(4, dni, emp.getDni());
        raiz.setVgap(10);
        raiz.addRow(5, guardar);
        raiz.setVgap(10);

        new Controlador_empleado(raiz, addEmp, rmEmp, updEmp, getEmp, emp, guardar);
    }

    public Menu getMenuEmpleado(){
        return menu_Empleado;
    }



}
