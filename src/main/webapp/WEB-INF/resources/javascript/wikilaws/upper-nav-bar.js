var viewModelUpperNavBar = {
		searchInput: ko.observable(),
		searchButtonClick : function() {
			var correctSearchinput = "";
			
			if( !jQuery.isEmptyObject(viewModelUpperNavBar.searchInput()) ){
				correctSearchinput = viewModelUpperNavBar.searchInput().toString();
			}
			correctSearchinput = $("#searchInput").val();
			redirectToPage("../ogrrhhapps/resultados_busqueda.htm?searchInput=" + correctSearchinput);
		},
        saveInNavegationHistory : function(url, descripcion){
        	
        }
	};
	
ko.applyBindings(viewModelUpperNavBar, $('#upper-navbar')[0]);

$(document).ready(function() {

	function onDataBound(){
		var autoCompleteContainerObject = $(".k-list-container").removeClass("k-reset").removeClass("k-state-border-up").css("background-color","white");
		autoCompleteContainerObject.find("ul").addClass("autocomplete-select-item");
	}

	$("#searchInput").kendoAutoComplete({
        minLength: 2,
        ignoreCase: true,
        template: '<a class="autocomplete-link-decoration" style="text-decoration: none;" href="../ogrrhhapps/contenido_pagina.htm?url=${data.url}&id_normas=${data.id_normas}">'+
        	'<div class="autocomplete-div-container" >${data.tipo} ${data.numero_norma} ${data.descripcion} '+
        	'</div>'+
        	'</a>',
        dataSource: {
        	serverFiltering: true,
            transport: {
                read:{
                    dataType: "json",
                    url: "../ogrrhhapps/resultados_busqueda_ajax.htm"
                },
                parameterMap: function() {
                   return { searchInput: $("#searchInput").data("kendoAutoComplete").value() };
                }
            }
        },
        animation: false,
        dataBound: onDataBound
    }).removeClass("k-state-hover").removeClass("k-state-hover: hover");
});