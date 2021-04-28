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
