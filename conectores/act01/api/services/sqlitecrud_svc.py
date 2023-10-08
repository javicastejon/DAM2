# api/services/sqlitecrud_svc.py
import sqlite3
from typing import Any
from injector import inject


DATABASE_NAME = '/workspaces/DAM2/conectores/act01/act01.db'
# DATABASE_NAME = os.environ['DB_NAME']

class SqliteCrudService:
    """Servicio CRUD para cliente sqlite"""
    @inject
    def __init__(self):
        # create connection
        self.connection = sqlite3.connect(DATABASE_NAME)
        self.cursor = self.connection.cursor()
        print("SQLite CRUD service init")
        
    def create(self, sql_query, params) -> str:
        """Crea un nuevo registro con los parámetros y devuelve el resultado. """
        # Ejemplo de query: ''' INSERT INTO tabla(campo1,campo2,campo3) VALUES(?,?,?) '''
        self.cursor.execute(sql_query, params)
        self.connection.commit()
        self.dispose()
        return 'Succesfull'

        
    def read(self, sql_query, params) -> list[Any]:
        """Devuelve en una lista el resultado de la query"""
        # Cada fila es como una tupla con un entero como indice
        # Ejemplo de query:  "SELECT * FROM `tabla`
        try:
            self.cursor.execute(sql_query, params)
            rows = self.cursor.fetchall()
            if len(rows) > 0:
                return rows
            else:
                print("No results")
                return []
        except Exception as ex:
            print("SQLite read query exception: %", str(ex))
            
        
    def update(self, sql_query):
        """Actualiza un elemento"""
        # read data
        #sql_query = "SELECT * FROM `empleado` "

        # check if there is a change in the database
        rows = self.cursor.execute(sql_query).fetchall()

        # every row is like a tuple - integer indexed
        # if rows will do, since an empty row is `False`
        if len(rows) > 0:
            for row in rows:
                id = row[0]
                name = row[1]

                print(
                    f"ID: {id} - {name} ")
        else:
            print("profile writing to database unsuccessful")

        # there is no need to commit here because no changes are made to the database

        
    def delete(self):
        """Elimina un elemento"""
        pass

    # close cursor and connection
    def dispose(self):
        """Cierra la conexion con la BD"""
        self.cursor.close()
        self.connection.close()