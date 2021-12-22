## CRUD
# CREATE
# READ
# UPDATE
# DELETE
from usuario import Usuario

class CRUD_Usuarios:

    # Constructor
    def __init__(self):

        # Arreglo para usuarios (simular base de datos)
        self.usuarios = []

    def createUser(self, nombre, correo, pwd, edad):
        id = len(self.usuarios)
        nuevoUsuario = Usuario(id, correo, pwd, nombre, edad)
        self.usuarios.append(nuevoUsuario)
        return nuevoUsuario.dump()

    def readUsers(self):
        usuariosJSON = []

        for usuario in self.usuarios:
            usuariosJSON.append(usuario.dump())

        return usuariosJSON
