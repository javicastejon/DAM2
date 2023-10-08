from injector import noscope
from ..services.sqlitecrud_svc import SqliteCrudService


def configure(binder):
    binder.bind(SqliteCrudService, to=SqliteCrudService, scope=noscope)