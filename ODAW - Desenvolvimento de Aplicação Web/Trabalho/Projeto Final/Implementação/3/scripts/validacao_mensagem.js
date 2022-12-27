const fields = document.querySelectorAll('[required]');

console.log(fields);

function customValidation(event) {
    const field = event.target

    // Lógica para verificar se existe erros
    function verifyErrors(){
        let foundError = false;

        for (let error in  field.validity) {
            if (error != "customError" && field.validity[error]) {
                foundError = error;
            }
        }

        return foundError;
    }

    const error = verifyErrors()
    console.log("Error: ", error);

    // trocar mensagem de required
    if (error) {
        field.setCustomValidity("Esse campo é obrigatório")
    } else {
        field.setCustomValidity("")
    }
}

for ( var field of fields) {
    field.addEventListener("invalid", customValidation)
}

document.querySelector("form").addEventListener("submit", event => {
    console.log("Enviar o formulário")

    //Não vai enviar o formulário
    event.preventDefault();

    window.alert("Mensagem enviada com sucesso")
})