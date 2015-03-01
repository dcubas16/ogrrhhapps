<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="col-md-3 right-separator">
	<div class="col-md-12" style="padding-left: 0px;" align="center">
		<a href="../ogrrhhapps/home.htm"> <img
			src="../ogrrhhapps/resources/images/logo_wikilegal.jpg" />
		</a>
	</div>
	<div class="panel-group" id="accordion">
		<div class="panel panel-default">
			<div class="panel-heading panel-heading-according">
				<h4 class="panel-title small-panel-title">
					<a class="accordion-toggle" data-toggle="collapse"
						data-parent="#accordion" href="#collapseOne">Historial
						Reciente</a>
				</h4>
			</div>
			<div id="collapseOne" class="panel-collapse collapse in">
				<div class="panel-body according-height">
					<div class="row">
						<div class="col-md-12">
							<c:set var="count" value="0" scope="page" />
							<c:choose>
								<c:when test="${!empty historialNavegacionDeUsuario}">
									<ul class="list-unstyled">
										<c:forEach items="${historialNavegacionDeUsuario}"
											var="historialNavegacionDeUsuario">
											<c:if test="${count < 4}">
												<li><a
													href="../ogrrhhapps/contenido_pagina.htm?url=${historialNavegacionDeUsuario.leyNorma.url}&id_normas=${historialNavegacionDeUsuario.leyNorma.id_normas}">
														<!-- <span>${historialNavegacionDeUsuario.leyNorma.tipo} ${historialNavegacionDeUsuario.leyNorma.numero_norma} ${historialNavegacionDeUsuario.leyNorma.descripcion} (${historialNavegacionDeUsuario.fecha_acceso} ) </span> -->
														<span>${historialNavegacionDeUsuario.leyNorma.tipo} ${historialNavegacionDeUsuario.leyNorma.numero_norma} (${historialNavegacionDeUsuario.fecha_acceso} ) </span>
												</a></li>
												<c:set var="count" value="${count + 1}" scope="page" />
											</c:if>
										</c:forEach>
									</ul>
								</c:when>
								<c:otherwise>
									<h5>El usuario no presenta historial de navegación</h5>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-4"></div>
						<div class="col-md-4">
							<a href="../ogrrhhapps/historial_navegacion.htm">...Ver más</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading panel-heading-according">
				<h4 class="panel-title small-panel-title">
					<a class="accordion-toggle" data-toggle="collapse"
						data-parent="#accordion" href="#collapseTwo">Notas
					</a>
				</h4>
			</div>
			<div id="collapseTwo" class="panel-collapse collapse">
				<div class="panel-body  according-height">
					<div class="row">
						<div class="col-md-12">
							<c:set var="count" value="0" scope="page" />
							<c:choose>
								<c:when test="${!empty notas}">
									<ul class="list-unstyled">
										<c:forEach items="${notas}"
											var="notas">
											<c:if test="${count < 4}">
												<li><a
													href="#">
														<span>${notas.textoLey} </span>
												</a></li>
												<c:set var="count" value="${count + 1}" scope="page" />
											</c:if>
										</c:forEach>
									</ul>
								</c:when>
								<c:otherwise>
									<h5>El usuario no tiene notas en esta página</h5>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-4"></div>
						<div class="col-md-4">
							<a href="../ogrrhhapps/historial_navegacion.htm">...Ver más</a>
						</div>
					</div>	
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading panel-heading-according">
				<h4 class="panel-title small-panel-title">
					<a class="accordion-toggle" data-toggle="collapse"
						data-parent="#accordion" href="#collapseThree">Descarga/Impresion
					</a>
				</h4>
			</div>
			<div id="collapseThree" class="panel-collapse collapse">
				<div class="panel-body">
					<div class="col-md-12">
						<ul class="list-unstyled">
							<li><a href="#">Descargar en PDF</a></li>
							<li><a href="#">Vista de Impresio</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>