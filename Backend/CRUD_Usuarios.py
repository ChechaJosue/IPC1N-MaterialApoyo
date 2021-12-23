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

    def updateUser(self, id, nombre, correo, pwd, edad):
        for usuario in self.usuarios:
            if usuario.id == id:
                usuario.nombre = nombre
                usuario.correo = correo
                usuario.pwd = pwd
                usuario.edad = edad
                return True
        return False

    def deleteUser(self, id_u):
        for usuario in self.usuarios:
            if usuario.id == id_u:
                self.usuarios.remove(usuario)
                return True
        return False

    def loginUser(self, correo, pwd):
        for usuario in self.usuarios:
            if usuario.correo == correo and usuario.pwd == pwd:
                return usuario.dump()
        return None