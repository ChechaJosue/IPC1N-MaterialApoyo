## CRUD
# CREATE
# READ
# UPDATE
# DELETE
from cliente import Cliente

class CRUD_Clientes:

    # Constructor
    def __init__(self):

        # Arreglo para clientes (simular base de datos)
        self.clientes = []

    def createCliente(self, dpi, nombre, apellido, correo, password, edad, compras):
        nuevoCliente = Cliente(dpi, nombre, apellido, correo, password, edad, compras)
        self.clientes.append(nuevoCliente)
        return nuevoCliente.dump()

    def readClientes(self):
        clientesJSON = []
        for cliente in self.clientes:
            clientesJSON.append(cliente.dump())
        return clientesJSON

    def updateCliente(self, dpi, nombre, apellido, correo, password, edad, compras):
        for cliente in self.clientes:
            if cliente.dpi == dpi:
                cliente.dpi = dpi
                cliente.nombre = nombre
                cliente.apellido = apellido 
                cliente.correo = correo 
                if password != "": cliente.password = password 
                cliente.edad = edad 
                cliente.compras = compras 
                return True
        return False

    def deleteCliente(self, dpi):
        for cliente in self.clientes:
            if cliente.dpi == dpi:
                self.clientes.remove(cliente)
                return True
        return False

    def loginCliente(self, correo, password):
        for cliente in self.clientes:
            if cliente.correo == correo and cliente.password == password:
                return cliente.dump()
        return None