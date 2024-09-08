$(document).ready(function(){
    $('#isbn').mask('000-0-00-000000-0', {reverse: true});

    $('#quantity').mask('00000', {reverse: true});

    $('#cpf').mask('000.000.000-00', {reverse: true});
});