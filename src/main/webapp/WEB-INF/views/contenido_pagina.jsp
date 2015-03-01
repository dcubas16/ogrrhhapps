<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<c:import url="../views/jspf/resources.jsp" />
</head>
<body>
	<div class="row main-frame">
		<c:import url="../views/jspf/left-navbar.jsp" />
		<div class="col-md-9 botton-separator">
			<c:import url="../views/jspf/upper-navbar.jsp" />
			<div class="row botton-separator">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#contenido" data-toggle="tab">Contenidos</a></li>
					<li class=""><a href="#historial" data-toggle="tab">Historial</a></li>
					<li class=""><a href="#notas" data-toggle="tab">Notas</a></li>
				</ul>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade active in" id="contenido">
						<div class="row content-left-separator search-content-line-height">
							<div id="page-content" class="col-md-12 page-content-style">
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="historial">
						<div class="row content-left-separator search-content-line-height">
							<div class="col-md-12 page-content-style"">
								<c:choose>
									<c:when test="${!empty historialNavegacionDeUsuario}">
										<ul class="list-unstyled">
											<c:forEach items="${historialNavegacionDeUsuario}"
												var="historialNavegacionDeUsuario">
												<li><a
													href="../ogrrhhapps/contenido_pagina.htm?url=${historialNavegacionDeUsuario.leyNorma.url}&id_normas=${historialNavegacionDeUsuario.leyNorma.id_normas}">
														<span>
															${historialNavegacionDeUsuario.leyNorma.tipo}
															${historialNavegacionDeUsuario.leyNorma.numero_norma}
															${historialNavegacionDeUsuario.leyNorma.descripcion} (
															${historialNavegacionDeUsuario.fecha_acceso} ) </span>
															
												</a></li>
											</c:forEach>
										</ul>
									</c:when>
									<c:otherwise>
										<h5>El usuario no presenta historial de navegación</h5>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="notas">
						<div class="row content-left-separator search-content-line-height">
							<div class="col-md-12 page-content-style"">
								<c:choose>
									<c:when test="${!empty notas}">
										<ul class="list-unstyled">
											<c:forEach items="${notas}" var="notas">
												<li><a
													href="#">
														<span>
															${notas.textoLey}
															( ${notas.leyNorma.tipo} ${notas.leyNorma.numero_norma} ) </span>
												</a></li>
											</c:forEach>
										</ul>
									</c:when>
									<c:otherwise>
										<h5>El usuario no tiene anotaciones para esta ley</h5>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	$(function() {
		var leyNorma = function(tipo, numero_norma, descripcion) {
			tipo = ko.observable(tipo);
			numero_norma = ko.observable(numero_norma);
			descripcion = ko.observable(descripcion);
		};

		var viewModel = {
			LeftMenu : ko.observableArray(),
			MenuTabs : ko.observableArray(),
			Tree : ko.observableArray(),
			Cultures : ko.observableArray(),
			MainContent : ko.observable(),
			NavigationLine : ko.observableArray(),
			SearchResults : ko.observableArray()
		};

		var leftSectionViewModel = {
			Notas : ko.observableArray(),
			agregarNota: function(nota, idNormas){
				this.Notas.push({ textoSeleccionado : nota, idNormas : 1 })
			}
		};

		ko.applyBindings(viewModel, $('#page-content')[0]);
		ko.applyBindings(leftSectionViewModel, $('.right-separator')[0]);

		$.contextMenu({
			selector : '.page-content-style',
			callback : function(key, options) {
				var m = "clicked: " + key;
				var element = ".page-content-style";
				switch(key){
					case "agregarANotasDeLey": agregarNota(element);
					break;
					case "copiar": copiarTexto(element);
					break;
					case "imprimir": imprimirTexto(element);
					break;
					case "descargar": descargarPdf(element);
					break;
				}
			},
			items : {
				"agregarANotasDeLey" : {
					name : "Agregar a Notas"
				},
				"copiar" : {
					name : "Copiar"
				},
				"imprimir" : {
					name : "Imprimir"
				},
				"descargar" : {
					name : "Descargar Pdf"
				}
			}
		});
		
		function copiarTexto(objectClass) {
		    var textoSelec = selectHTML();
		    window.prompt ("Copy to clipboard: Ctrl+C, Enter", textoSelec);
		}
		
		function imprimirTexto(objectClass) {
		    var textoSel = selectHTML();
		    var ventimp = window.open(' ', 'popimpr');
		    ventimp.document.write(textoSel);
		    ventimp.document.close();
		    ventimp.print();
		    ventimp.close();
		}
		
		function descargarPdf(objectClass) {
			var id_normas = "${id_normas}";
			document.location.href ="../ogrrhhapps/resources/archivos/"+id_normas+".zip";
		}
		
		function agregarNota(objectClass) {
		    var notaSeleccionada = selectHTML();
		    var textoSeleccionado;
		    if(notaSeleccionada.anchorNode == undefined)
			  	{
			    	textoSeleccionado = notaSeleccionada;
			  	}
		    else
		    	{
		    		textoSeleccionado = notaSeleccionada.anchorNode.textContent;
		    	}
		    $.ajax(
					{
						type : "GET",
						url : "../ogrrhhapps/UserNavigationHistory/registrar_anotacion_ley.htm",
						data : {
							id_normas : "${id_normas}",
							textoley : textoSeleccionado
						}
					}).done(function(msg) {});
		    
		    leftSectionViewModel.agregarNota(notaSeleccionada, 1);
		    location.reload();
		}
	});

	$(document)
			.ready(
					function() {
						$.get("${url}", function(data) {
							$("#page-content").html(data);
						});

						$.ajax(
										{
											type : "GET",
											url : "../ogrrhhapps/UserNavigationHistory/registrar_navegacion_usuario.htm",
											data : {
												id_usuario : 1,
												id_normas : "${id_normas}"
											}
										}).done(function(msg) {
									// 			alert( "Data Saved: " + msg );
								});
					});

	function redirectToPage(pageUrl) {
		window.location.replace(pageUrl);
	}
</script>
<style>
@font-face {
	font-family: 'Glyphicons Halflings';
	src:
		url('../ogrrhhapps/resources/images/glyphicons-halflings-regular.eot');
	src:
		url('../ogrrhhapps/resources/images/glyphicons-halflings-regular.eot?#iefix')
		format('embedded-opentype'),
		url('../ogrrhhapps/resources/images/glyphicons-halflings-regular.woff')
		format('woff'),
		url('../ogrrhhapps/resources/images/glyphicons-halflings-regular.ttf')
		format('truetype'),
		url('../ogrrhhapps/resources/images/glyphicons-halflings-regular.svg#glyphicons-halflingsregular')
		format('svg');
}
</style>
</html>
