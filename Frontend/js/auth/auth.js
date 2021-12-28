
/*
{
    "correo": "kevin@gmail.com",
    "pwd": "123456"
}
*/

async function iniciarSesion() {
    let correo = document.getElementById('txtEmail').value
    let pwd = document.getElementById('txtPwd').value

    // Peticion HTTP hacia nuestro backend
    let rawResponse = await fetch("http://localhost:3000/auth", {
        method: "POST",
        headers: {'Content-type': 'application/json'},
        body: JSON.stringify(
            {
                "correo": correo,
                "pwd": pwd
            }
        )
    })
    
    let response = await rawResponse.json()

    if(rawResponse.status == 200){
        console.log(response)
        alert(`Bienvenid@ ${response.nombre} ${2+2}`)
        localStorage.setItem("usuario", JSON.stringify(response))
    } else {
        alert(response.mensaje)
    }

    let usuarioRecuperado = localStorage.getItem("usuario")
    
    console.log(usuarioRecuperado)
    
    if(usuarioRecuperado){
        usuarioRecuperado = await JSON.parse(usuarioRecuperado)
    }

    console.log(usuarioRecuperado)
}