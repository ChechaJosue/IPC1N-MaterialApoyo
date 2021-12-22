class Usuario:

    # Constructor
    def __init__(self, _id, correo, pwd, nombre, edad):
        self.id = _id
        self.correo = correo
        self.pwd = pwd
        self.nombre = nombre
        self.edad = edad

    # Metodos
    def saludar(self):
        print("Hola, mi nombre es " + self.nombre + " y tengo " + str(self.id))
    
    # Convertir usuario a json
    def dump(self):
        return {
            "id": self.id,
            "correo": self.correo,
            "pwd": self.pwd,
            "nombre": self.nombre,
            "edad": self.edad
        }