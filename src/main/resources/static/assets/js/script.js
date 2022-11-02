/**
 * LumbreAPI - Javascript
 * @author Sara Vidal García
 */

// FUNCIONES

/**
 * Recibe una URL y la copia al portapapeles
 * @param url 
 */
function copiar(url) {
    navigator.clipboard.writeText(url);
    alert("Texto copiado al portapapeles");
}

/**
 * Muestra las peticiones asociadas al id recibido y oculta el resto
 * @param id 
 */
function mostrar(id) {
    //Se ocultan todos los contenedores
    for (let c of document.querySelectorAll('.contenedor')) {
        if (!c.classList.contains("oculto"))
            c.classList.add("oculto");
    }
    //Se muestra el contenedor con el id
    document.getElementById(id).classList.remove("oculto");
    //Se establece el nuevo botón actual
    for (let c of document.querySelectorAll('.boton')) {
        if (c.classList.contains("actual"))
            c.classList.remove("actual");
    }
    document.querySelector('.b-' + id).classList.add("actual");
}

/**
 * Función inicial que carga las partes de código de las peticiones
 */
window.onload = function () {

    //Se cargan los headers de las peticiones
    for (let h of document.querySelectorAll('.no-auth')) {
        h.innerHTML = no_auth;
    }
    for (let h of document.querySelectorAll('.completo')) {
        h.innerHTML = completo;
    }
    for (let h of document.querySelectorAll('.basico')) {
        h.innerHTML = basico;
    }

    //Se carga el código del body de las peticiones que así lo requieran
    document.getElementById("c-usuario").innerHTML = usuario;
    document.getElementById("c-login").innerHTML = login;
    document.getElementById("c-password").innerHTML = password;
    document.getElementById("c-campanha").innerHTML = campanha;
    document.getElementById("c-ucampanha").innerHTML = updateCampanha;
    document.getElementById("c-sesion").innerHTML = sesion;
    document.getElementById("c-usesion").innerHTML = updateSesion;
    document.getElementById("c-personaje").innerHTML = personaje;
    document.getElementById("c-upersonaje").innerHTML = personaje;
    document.getElementById("c-raza").innerHTML = raza;
    document.getElementById("c-uraza").innerHTML = updateRaza;
}


//HEADERS DE LAS PETICIONES

//Headers con Accept y Content-Type
let no_auth =
    `{
    'Accept': 'application/json',
    'Content-Type': 'application/json'
}
`;

//Headers con Accept, Content-Type y Authorization
let completo =
    `{
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization': 'token'
}
`;

//Headers únicamente con Authorization
let basico =
    `{
    'Authorization': 'token'
}
`;


//BODY DE LAS PETICIONES

//Código de ejemplo para crear un usuario
let usuario =
    `JSON.stringify(
    {
        email: 'ejemplo@ejemplo.com',
        username: 'ejemplo',
        passwd: 'ejemplo'
    }
)
`;

//Código de ejemplo para realizar el login
let login =
    `JSON.stringify(
    {
        username: 'ejemplo',
        passwd: 'ejemplo'
    }
)
`;

//Código de ejemplo para cambiar la contraseña
let password =
    `JSON.stringify(
    {
        username: 'ejemplo',
        passwd: 'contraseña actual',
        email: 'nueva contraseña'
    }
)
`;

//Código de ejemplo para crear una nueva campaña
let campanha =
    `JSON.stringify(
    {
        titulo: 'ejemplo',
        resumen: 'ejemplo',
        informacion: 'ejemplo',
        creacion: new Date(),
        modificacion: new Date()
    }
)
`;

//Código de ejemplo para actualizar una campaña
let updateCampanha =
    `JSON.stringify(
    {
        titulo: 'ejemplo',
        resumen: 'ejemplo',
        informacion: 'ejemplo',
        modificacion: new Date()
    }
)
`;

//Código de ejemplo para crear una sesión
let sesion =
    `JSON.stringify(
    {
        nombre: 'ejemplo',
        estado: 'Completada'/'Prevista',
        planificacion: 'ejemplo',
        resultados: 'ejemplo',
        fecha: new Date(),
        creacion: new Date(),
        modificacion: new Date()
    }
)
`;

//Código de ejemplo para actualizar una sesión
let updateSesion =
    `JSON.stringify(
    {
        nombre: 'ejemplo',
        estado: 'Completada'/'Prevista',
        planificacion: 'ejemplo',
        resultados: 'ejemplo',
        fecha: new Date(),
        modificacion: new Date()
    }
)
`;

//Código de ejemplo para crear o actualizar un personaje
let personaje =
    `new FormData(
    &lt;form enctype="multipart/form-data"&gt;
        &lt;input type="text" name="nombre"&gt;
        &lt;select name="raza"&gt;
            &lt;option value="1"&gt;Raza&lt;/option&gt;
        &lt;/select&gt;
        &lt;input type="text" name="jugador"&gt;
        &lt;textarea name="informacion"&gt;&lt;/textarea&gt;
        &lt;input type="file" name="file"&gt;
    &lt;/form&gt;
)
`;

//Código de ejemplo para crear una raza
let raza =
    `JSON.stringify(
    {
        denominacion: 'ejemplo',
        descripcion: 'ejemplo',
        tipo: 'Propia',
        creacion: new Date(),
        modificacion: new Date()
    }
)
`;

//Código de ejemplo para actualizar una raza
let updateRaza =
    `JSON.stringify(
    {
        denominacion: 'ejemplo',
        descripcion: 'ejemplo',
        modificacion: new Date()
    }
)
`;


