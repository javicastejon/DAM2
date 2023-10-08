"""Controlador de los endpoints de persona"""
from flask import Flask
from flask_injector import FlaskInjector
from flask_cors import CORS
from werkzeug.middleware.proxy_fix import ProxyFix
from ..controllers.empleado import bp as empleado_controller
from ..controllers.home import bp as home_controller
from ..dependency.dependencies import configure as cfg


def create_app():
    """Carga la configuracion de la app"""
    app = Flask(__name__,
                template_folder='/workspaces/DAM2/conectores/act01/api/templates',
                static_folder='/workspaces/DAM2/conectores/act01/api/static')
    _ = CORS(app, resources={r"/api/*": {"origins": "*"}})
    app.config['RESTPLUS_MASK_SWAGGER'] = False
    app.config['SECRET_KEY'] = 'churrova'
    app.wsgi_app = ProxyFix(app.wsgi_app)

    app.register_blueprint(home_controller)
    app.register_blueprint(empleado_controller)
    # Carga en el Flask Injector la configuracion.
    # SIEMPRE despues de registrar los endponts (blueprint)
    FlaskInjector(app=app, modules=[cfg])
    return app
