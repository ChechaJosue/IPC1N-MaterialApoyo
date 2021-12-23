from flask import Flask, json, request, jsonify
from flask_cors import CORS
from CRUD_Usuarios import CRUD_Usuarios
from CRUD_Clientes import CRUD_Clientes

# Inicializar el servidor de flask
crudUsuarios = CRUD_Usuarios()
crudClientes = CRUD_Clientes()
app = Flask(__name__)
CORS(app)

# Peticiones HTTP

# GET -> Recuperar datos
# POST -> Enviar datos
# DELETE -> Eliminar datos
# PUT -> Insertar datos

# Codigos HTTP
# 200 -> Ok
# 201 -> Recurso creado
# 400 -> Peticion incorrecta
# 404 -> No se encontro un recurso

@app.route('/', methods=["GET"])
def paginaInicial():
    print('Pagina inicial')
    return jsonify({ "mensaje": "Pagina inicial" })

@app.route('/auth', methods=["POST"])
def login():
    correo = request.json["correo"]
    pwd = request.json["pwd"]

    resultado = crudUsuarios.loginUser(correo, pwd)

    if resultado is None:
        return jsonify({ "mensaje": "Credenciales inválidas"}), 400

    resultado.pop('pwd')
    return jsonify(resultado), 200

@app.route('/usuario', methods=["PUT"])
def crearUsuario():
    nombre = request.json["nombre"]
    correo = request.json["correo"]
    pwd = request.json["pwd"]
    edad = request.json["edad"]
    
    res = crudUsuarios.createUser(nombre, correo, pwd, edad)
    return jsonify({ "mensaje": "Usuario creado con exito", "data": res}), 201

@app.route('/usuario', methods=["GET"])
def getUsuarios():
    return jsonify({"data": crudUsuarios.readUsers()})

@app.route('/usuario', methods=["POST"])
def updateUsuario():
    id_u = request.json["id"]
    nombre = request.json["nombre"]
    correo = request.json["correo"]
    pwd = request.json["pwd"]
    edad = request.json["edad"]
    resultado = crudUsuarios.updateUser(id_u, nombre, correo, pwd, edad)

    if resultado:
        return jsonify({ "mensaje": "Usuario " + nombre + " modificado con éxito" }), 200
    
    return jsonify({ "mensaje": "Usuario no encontrado" }), 404

@app.route('/usuario', methods=["DELETE"])
def deleteUsuario():
    id_u = request.json["id"]

    resultado = crudUsuarios.deleteUser(id_u)

    if resultado:
        return jsonify({ "mensaje": "Usuario con id " + str(id_u) + " eliminado con éxito" }), 200
    
    return jsonify({ "mensaje": "Usuario no encontrado" }), 404

################################################################

## CLIENTES

@app.route('/cliente', methods=["PUT"])
def crearCliente():
    dpi = request.json["dpi"]
    nombre = request.json["nombre"]
    apellido = request.json["apellido"] 
    correo = request.json["correo"] 
    password = request.json["password"] 
    edad = request.json["edad"] 
    compras = request.json["compras"] 
    
    res = crudClientes.createCliente(dpi, nombre, apellido, correo, password, edad, compras)
    return jsonify({ "mensaje": "Cliente creado con exito", "data": res}), 201

@app.route('/cliente', methods=["GET"])
def getClientes():
    return jsonify({"data": crudClientes.readClientes()})

if __name__ == '__main__':
    app.run(debug=True, port=3000)