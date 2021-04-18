$(document).ready(() => {

    const save = () => {
        $('#agregar').on('click', function () {
            const datosCliente = {
                tipo_identificacion: $('#tipo_identificacion').val(),
                num_identificacion: $('#num_identificacion').val(),
                nombre: $('#nombre').val(),
                email: $('#email').val(),
                telefono: $('#telefono').val(),
                direccion: $('#direccion').val(),
            }

            $.ajax({
                url: 'http://localhost:8084/api/save',
                contentType: 'application/json',
                type: 'POST',
                data: JSON.stringify(datosCliente),
                dataType: 'json',
                success: (data) => {
                    $('#messages').html('Cliente Creado').css('display', 'block')
                    reset();
                    console.log('Cliente registrado')
                }

            })

        })
    }

    const reset = () => {
        $('#num_identificacion').val('');
        $('#nombre').val('');
        $('#email').val('');
        $('#telefono').val('');
        $('#direccion').val('');
    }

    save();

})

function validatorForms(formulario) {

    function validarEmail(elemento) {
        var texto = document.getElementById(elemento.id).value;
        var regex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
        if (!regex.test(texto)) {
            //correo invalido
            return false;
        } else {
            //correo valido
            return true;
        }
    }

    function validarVacio(elemento) {
        var texto = document.getElementById(elemento.id).value;
        texto = texto.trim();
        if (texto.length == 0 || texto == "") {
            //campo invalido
            return false;
        } else {
            //campo valido
            return true;
        }
    }

    function validarSiNumero(elemento) {
        var g = parseInt(elemento.value);
        if (Number.isInteger(g)) {
            return true;
        } else {
            return false;
        }
    }

    /*
     *
     * @param {Elemento} e
     * @returns {Boolean}
     * TRUE (Si el selecciono una opción / FALSE (No se selecciono ninguna opción valida)
     */
    function validarSelectOne(e) {
        var elemento = formulario.elements[e];
        if (elemento.value == "select") {
            return false;
        } else {
            return true;
        }
    }

    var validar = function (e) {
        for (var i = 0, max = formulario.elements.length; i < max; i++) {
            //tipo email validador
            if (formulario.elements[i].type == "email") {
                //validar
                if (validarEmail(formulario.elements[i])) {
                    formulario.elements[i].setAttribute("class", "form-control is-valid");
                } else {
                    formulario.elements[i].setAttribute("class", "form-control is-invalid");
                    e.preventDefault(e);
                }
            }
            
            //validar select-one
            if (formulario.elements[i].type == "select-one") {
                if (validarSelectOne(i)) {
                    formulario.elements[i].setAttribute("class", "custom-select is-valid");
                } else {
                    formulario.elements[i].setAttribute("class", "custom-select is-invalid");
                    e.preventDefault(e);
                }
            }

            if (formulario.elements[i].type == "number") {
                //validar datos numeros
                if (validarSiNumero(formulario.elements[i])) {
                    formulario.elements[i].setAttribute("class", "form-control is-valid");
                } else {
                    formulario.elements[i].setAttribute("class", "form-control is-invalid");
                    e.preventDefault(e);
                }
            }

        }
    };

    formulario.addEventListener("submit", validar);

};

function txNombres() {
    if ((event.keyCode != 32) && (event.keyCode < 65) || (event.keyCode > 90) && (event.keyCode < 97) || (event.keyCode > 122))
     event.returnValue = false;
   }
