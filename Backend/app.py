from flask import Flask, json, request, jsonify
from flask_cors import CORS
from CRUD_Usuarios import CRUD_Usuarios

# Inicializar el servidor de flask
crudUsuarios = CRUD_Usuarios()
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

@app.route('/saludo', methods=["GET"])
def saludoGet():
    print('Hola')
    return jsonify({ "mensaje": "Hola mundo" })

@app.route('/saludo', methods=["POST"])
def saludoPost():
    nombre = request.json["nombre"]
    edad = request.json["edad"]
    return jsonify({ "mensaje": "Hola " + nombre + " de edad " + str(edad)})

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

if __name__ == '__main__':
    app.run(debug=True, port=3000)