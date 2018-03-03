/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var url = 'rest/calculadora/';
            
var sendRequest = function (url, verb, data) {
    var settings = {
        url: url,
        method: verb,
        "headers": {
          "Content-Type" : "application/json"
        },
        data : JSON.stringify(data)
      }
    return $.ajax(settings); 
}

ko.extenders.required = function(target, overrideMessage) {
    target.hasError = ko.observable();
    target.validationMessage = ko.observable();
    function validate(newValue) {
       target.hasError(newValue ? false : true);
       target.validationMessage(newValue ? "" : overrideMessage || "Este campo es requerido");
    }
    validate(target());
    target.subscribe(validate);
    return target;
};

ko.extenders.logChange = function(target, option) {
    target.subscribe(function(newValue) {
       console.log(option + ": " + newValue);
    });
    return target;
};

var model =  {
        categorias :  ko.observable([]),
        nombre : ko.observable("").extend({ required: "" }),
        valor : ko.observable("").extend({ required: "" }),
        categoria : ko.observable(""),
        hasServerError: ko.observable(false),
        ServerError: ko.observable()
    }

var total = ko.computed(function() {
    let cat = model.categoria();
    let val = model.valor();
    if(cat)
        return val * (1 + cat.Valor);
    else
        return 0
})

var impuesto = ko.computed(function() {
    let cat = model.categoria();
    let val = model.valor();
    if(cat)
        return val * cat.Valor;
    else
        return 0
})

var notificar = function(){
    $(".alert").toggleClass('in out'); 
    return false; // Keep close.bs.alert event from removing from DOM
}

var guardar = function() {
    let data = {
        nombre : model.nombre(),
        valor: model.valor(),
        categoria: model.categoria().Nombre
    }
    sendRequest(url,'POST',data)
            .done(()=>{
                model.hasServerError(false);
                notificar();
            }).fail((e)=>{
                model.hasServerError(true);
                model.ServerError(`No se pudo insertar el producto. Error: ${e.status}, ${e.statusText}`)
            })
}

$(function(){
    ko.applyBindings();
    $('#bsalert').on('close.bs.alert', notificar)
    sendRequest(url,'GET')
            .done((d)=>{
                model.categorias(d);
            })
            .fail((d)=> {
                model.hasServerError(true);
                model.ServerError(`No se pudo obtener las categorias. Error: ${e.status}, ${e.statusText}`)
            })
})


