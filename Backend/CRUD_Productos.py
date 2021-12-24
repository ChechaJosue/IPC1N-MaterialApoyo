## CRUD
# CREATE
# READ
# UPDATE
# DELETE
from producto import Producto

class CRUD_Productos:

    # Constructor
    def __init__(self):

        # Arreglo para productos (simular base de datos)
        self.productos = []

    def createProducto(self, id, nombre, precio, categoria, descripcion):
        nuevoProducto = Producto(id, nombre, precio, categoria, descripcion)
        self.productos.append(nuevoProducto)
        return nuevoProducto.dump()

    def readProductos(self):
        productosJSON = []
        for producto in self.productos:
            productosJSON.append(producto.dump())
        return productosJSON

    # Carga masiva
    def cargaMasiva(self, productos_cm):
        try:
            for producto_cm in productos_cm:
                self.createProducto(len(self.productos), producto_cm['nombre'], producto_cm['precio'], producto_cm['categoria'], producto_cm['descripcion'])
            return self.readProductos()
        except Exception as e:
            print('\nOcurrió un error durante la carga masiva')
            print(e)
            print('\n')
            return False
        
        