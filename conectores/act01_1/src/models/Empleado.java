package models;

import javafx.scene.control.TextField;

public class Empleado {
	private int id;
	private TextField nombre;
    private TextField apellido;
    private TextField dni;

  	public int getId() {
		return id;
	}

	public TextField getNombre() {
		return nombre;
	}

	public TextField getApellido() {
		return apellido;
	}

	public TextField getDni() {
		return dni;
	}


	//////////////////////////////
	public Empleado() {
		super();
		this.nombre = new TextField();
		this.apellido = new TextField();
		this.dni = new TextField();
	}
	///////////////////////////
	
	
	
	
	
}