class Cliente:

    # Constructor
    def __init__(self, dpi, nombre, apellido, correo, password, edad, compras):
        self.dpi = dpi
        self.nombre = nombre
        self.apellido = apellido 
        self.correo = correo 
        self.password = password 
        self.edad = edad 
        self.compras = compras 
    
    # Convertir cliente a json
    def dump(self):
        return {
            "dpi": self.dpi,
            "nombre": self.nombre,
            "apellido": self.apellido,
            "correo": self.correo,
            "password": self.password,
            "edad": self.edad,
            "compras": self.compras,
        }