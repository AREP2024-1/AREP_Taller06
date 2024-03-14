function cadenaLog(){
    let inputCadena = document.getElementById("cadena");
    let endPoint = "/logService?cad=" + inputCadena.value;
    let peticion = solicitarEndPoint(endPoint);
    peticion.then(respuesta =>{
        let divResLog = document.getElementById("resLog");
        divResLog.innerHTML = respuesta;
    })
}

async function solicitarEndPoint(endPoint){
    return await fetch("http://localhost:"+ window.location.port + endPoint)
    .then(respuesta => {
        if(!respuesta.ok){
            throw new Error();
        }
        return respuesta.text();
    })
    .catch(error => alert(error));
}

