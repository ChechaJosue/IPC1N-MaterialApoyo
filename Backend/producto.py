class Producto:

    # Constructor
    def __init__(self, id, nombre, precio, categoria, descripcion):
        self.id = id
        self.nombre = nombre
        self.precio = precio
        self.categoria = categoria 
        self.descripcion = descripcion 


    # Convertir cliente a json
    def dump(self):
        return {
            "id" : self.id,
            "nombre" : self.nombre,
            "precio" : self.precio,
            "categoria" : self.categoria, 
            "descripcion" : self.descripcion
        }