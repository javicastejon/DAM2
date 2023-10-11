package interfaces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface I_Menu_Crud {
	/*
	 * Crea un registro: 
     * - Devuelve en un booleano si se ha realizado la operacion
	 */
	public boolean create(String sqlQuery, PreparedStatement parameters);
	
	/* 
     * Recupera los datos de la consulta de lectura:
     * - Devuelve un set de datos
     */
	public ResultSet read(String sqlQuery, PreparedStatement parameters);
	
	/*
	 * Actualiza un registro:
     * - Devuelve en un booleano si se ha realizado la operacion
	 */
	public boolean update(String sqlQuery, PreparedStatement parameters);
	
	/*
	 * Elimina un registro
     * - Devuelve en un booleano si se ha realizado la operacion
	 */
	public boolean delete(String sqlQuery, PreparedStatement parameters);
}
