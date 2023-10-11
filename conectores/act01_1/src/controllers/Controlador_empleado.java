package controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.chart.BubbleChart;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import models.Empleado;

public class Controlador_empleado extends MenuItem{
    private MenuItem addEmp, rmEmp, getEmp;
    private Button Guardar;
    private GridPane raiz;
    private Empleado emp;

    public Controlador_empleado(
        GridPane raiz,
        MenuItem add, 
        MenuItem rmv,
        MenuItem _upd,
        MenuItem read, 
        Empleado emp,
        Button guardar
        ){
        this.addEmp = add;
        this.rmEmp = rmv;
        this.getEmp = read;
        this.Guardar = guardar;
        this.emp = emp;
        this.raiz = raiz;
        loadEvents();
    }

    private void loadEvents(){
        addEmp.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent arg0) {
                System.out.println("test");

        }
        });

        rmEmp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                System.exit(0);
            }
        });

        getEmp.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                System.out.println(emp.getNombre().getText());
            }
        });

        Guardar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (emp.getNombre().getText().isEmpty()) {
                    if (emp.getNombre().getText().isEmpty() == false) {
                        raiz.getChildren().remove(emp.getNombre());
                    }
                    emp.getNombre().setText("Form Error! Please enter your name");
                    raiz.addRow(5, emp.getNombre());
                    return;
                }
                if (emp.getApellido().getText().isEmpty()) {
                    if (emp.getNombre().getText().isEmpty() == false) {
                        raiz.getChildren().remove(emp.getNombre());
                    }
                    emp.getNombre().setText("Form Error! Please enter your password");
                    raiz.addRow(6, emp.getNombre());
                    return;
                }
                if (emp.getNombre().getText().isEmpty() == false) {
                    raiz.getChildren().remove(emp.getNombre());
                }
                emp.getNombre().setText("Registration Successful!" + " Welcome " + emp.getNombre().getText());
                raiz.addRow(7, emp.getNombre());
            }
        });


    }

    private Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
    Node result = null;
    ObservableList<Node> childrens = gridPane.getChildren();

    for (Node node : childrens) {
        if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
            result = node;
            break;
        }
    }

    return result;
}

    private void addEmpleado(){

    }

    
}
