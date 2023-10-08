# api/basic_endpoints/__ini__.py
import os
from flask import Blueprint, render_template, request, url_for, redirect
from api.services.sqlitecrud_svc import SqliteCrudService

API_VERSION = os.environ.get('API_VERSION', 'v1')

bp = Blueprint('empleado', __name__, url_prefix=f'/api/{API_VERSION}/empleado')

# region Ejemplo formularios CRUD DAM2
@bp.route('/create/', methods=('GET', 'POST'))
def crear_empleado(sqlite_svc: SqliteCrudService):
    """Crear un nuevo empleado"""
    if request.method == 'POST':
        nombre = request.form['nombre']
        apellido = request.form['apellido']
        if not nombre:
            print('Nombre no rellenado')
        elif not apellido:
            print('Apellido no rellenado')
        else:
            # Gestionar servicio
            sql_query = ''' INSERT INTO Empleados(nombre,apellido) VALUES(?,?) '''
            sqlite_svc.create(sql_query, (nombre, apellido))
            return redirect(url_for('empleado.listar_empleados'))
    return render_template('crear_empleado.html')


@bp.route('/read', methods=('GET', 'POST'))
def listar_empleados(sqlite_svc: SqliteCrudService):
    """Recuperar un empleado"""
    rows = []
    if request.method == 'POST':
        nombre = request.form['nombre']
        if not nombre:
            print('No se ha rellenado el nombre')
        else:
            rows = sqlite_svc.read("SELECT * FROM Empleados WHERE nombre=?", (nombre,))

    if len(rows) == 0:
        rows = sqlite_svc.read("SELECT * FROM Empleados", [])

    return render_template('listar_empleados.html', data=rows)


@bp.route('/update/', methods=['POST'])
def actualizar_empleado(service: SqliteCrudService):
    """Actualizar empleado"""
    # TODO: response = service.create("INSERT INTO..")
    # return response
    pass


@bp.route('/delete/', methods=['DELETE'])
def eliminar_empleado(service: SqliteCrudService):
    """Eliminar empleado"""
    # TODO: response = service.create("INSERT INTO..")
    # return response
    pass

# endregion
