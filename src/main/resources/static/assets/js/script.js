function copiar(url) {
    navigator.clipboard.writeText(url);
}

let no_auth =
    `{
    'Accept': 'application/json',
    'Content-Type': 'application/json'
}
`;

let auth =
    `{
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization': 'token'
}
`;

let basic =
    `{
    'Authorization': 'token'
}
`;

let usuario =
    `JSON.stringify(
    {
        email: 'ejemplo@ejemplo.com',
        username: 'ejemplo',
        passwd: 'ejemplo'
    }
)
`;

let login =
    `JSON.stringify(
    {
        username: 'ejemplo',
        passwd: 'ejemplo'
    }
)
`;

let password =
    `JSON.stringify(
    {
        username: 'ejemplo',
        passwd: 'contraseña actual',
        email: 'nueva contraseña'
    }
)
`;

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

let updateRaza =
    `JSON.stringify(
    {
        denominacion: 'ejemplo',
        descripcion: 'ejemplo',
        modificacion: new Date()
    }
)
`;

window.onload = function () {
    for (let h of document.querySelectorAll('.h1')) {
        h.innerHTML = no_auth;
    }

    for (let h of document.querySelectorAll('.h2')) {
        h.innerHTML = auth;
    }

    for (let h of document.querySelectorAll('.h3')) {
        h.innerHTML = basic;
    }

    //Bodies
    //Usuario:
    document.getElementById("p1").innerHTML = usuario;
    document.getElementById("p2").innerHTML = login;
    document.getElementById("p3").innerHTML = password;
    //Campaña:
    document.getElementById("p4").innerHTML = campanha;
    document.getElementById("p5").innerHTML = updateCampanha;
    //Sesión:
    document.getElementById("p6").innerHTML = sesion;
    document.getElementById("p7").innerHTML = updateSesion;
    //Personaje:
    document.getElementById("p8").innerHTML = personaje;
    document.getElementById("p9").innerHTML = personaje;
    //Raza:
    document.getElementById("p10").innerHTML = raza;
    document.getElementById("p11").innerHTML = updateRaza;
}

function mostrar(id) {
    for (let c of document.querySelectorAll('.contenedor')) {
        if (!c.classList.contains("oculto"))
            c.classList.add("oculto");
    }
    document.getElementById(id).classList.remove("oculto");

    for (let c of document.querySelectorAll('.boton')) {
        if (c.classList.contains("actual"))
            c.classList.remove("actual");
    }

    document.querySelector('.b-' + id).classList.add("actual");
}