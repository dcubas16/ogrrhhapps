<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/download" var="downloadUrl" />
<c:url value="/download/token" var="downloadTokenUrl" />

<html>
<head>
<c:import url="../views/jspf/resources.jsp" />
</head>
<body>
	<div class="container" id="page-content">
		<br>
		<form class="form-horizontal">
			<div class="form-group">
				<div class="col-sm-1"></div>
				<label for="inputEmail3" class="col-sm-2 control-label">Doc.
					Ident</label>
				<div class="col-sm-7">
					<input id="serDocIdAct" name="serDocIdAct" type="text"
						class="form-control" data-bind="value: serDocIdAct"
						placeholder="Doc. Ident">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-1"></div>
				<label for="inputPassword3" class="col-sm-2 control-label">Ap.
					Paterno</label>
				<div class="col-sm-7">
					<input id="serApePat" name="serApePat" type="text"
						class="form-control" data-bind="value: serApePat"
						placeholder="Ap.Paterno">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-1"></div>
				<label for="inputPassword3" class="col-sm-2 control-label">Ap.
					Materno</label>
				<div class="col-sm-7">
					<input id="serApeMat" name="serApeMat" type="text"
						class="form-control" data-bind="value: serApeMat"
						placeholder="Ap. Materno">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-1"></div>
				<label for="inputPassword3" class="col-sm-2 control-label">Nombres</label>
				<div class="col-sm-7">
					<input id="serNombres" name="serNombres" type="text"
						class="form-control" data-bind="value: serNombres"
						placeholder="Nombres">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-4 col-sm-4"></div>
				<div class="col-sm-4 col-sm-4" style="text-align: right;">
					<button type="submit" class="btn btn-primary"
						style="text-align: right;">Buscar</button>
				</div>
				<div class="col-sm-4 col-sm-4" style="text-align: left;">
					<button type="button" class="btn btn-default"
						data-bind="click:limpiarFormulario">Limpiar</button>
				</div>
			</div>
		</form>

		<br>
		<div id="grid"></div>
		<script>
			var viewModel = {
				serDocIdAct : ko.observable(null),
				serApePat : ko.observable(null),
				serApeMat : ko.observable(null),
				serNombres : ko.observable(null),
				servidoresEncontrados : ko.observableArray(null),
				limpiarFormulario : function() {
					viewModel.serDocIdAct(null);
					viewModel.serApePat(null);
					viewModel.serApeMat(null);
					viewModel.serNombres(null);
					viewModel.servidoresEncontrados(null);
				}
			};

			ko.applyBindings(viewModel, $('#page-content')[0]);

			$("form")
					.submit(
							function(e) {
								e.preventDefault();

								if (!isEmpty(viewModel.serDocIdAct())
										|| !isEmpty(viewModel.serApePat())
										|| !isEmpty(viewModel.serApeMat())
										|| !isEmpty(viewModel.serNombres())) {

									$
											.ajax(
													{
														type : "GET",
														url : "buscarServidores.htm",
														data : {
															serDocIdAct : viewModel
																	.serDocIdAct(),
															serApePat : viewModel
																	.serApePat(),
															serApeMat : viewModel
																	.serApeMat(),
															serNombres : viewModel
																	.serNombres()
														}
													})
											.done(
													function(response) {
														viewModel
																.servidoresEncontrados(JSON
																		.parse(response));
														var dataSource = new kendo.data.DataSource(
																{
																	data : viewModel
																			.servidoresEncontrados()
																});
														var grid = $("#grid")
																.data(
																		"kendoGrid");
														grid
																.setDataSource(dataSource);
														grid.refresh();
													})
											.fail(
													function(jqxhr, textStatus,
															error) {
														var err = textStatus
																+ ", " + error;
														console
																.log("Request Failed: "
																		+ err);
													});

								} else {
									alert("Debe ingresar los campos de búsqueda");
								}
							});

			$(document).ready(function() {
				$("#grid").kendoGrid({
					dataSource : {
						data : viewModel.servidoresEncontrados(),
						schema : {
							model : {
								fields : {
									serDocIdAct : {
										type : "string"
									},
									serApePat : {
										type : "string"
									},
									serApeMat : {
										type : "string"
									},
									serNombres : {
										type : "string"
									},
									totalDu37 : {
										type : "number"
									}
								}
							}
						},
						pageSize : 15,
						serverPaging : true,
						serverFiltering : true,
						serverSorting : true
					},
					height : 400,
					// 					filterable : true,
					sortable : true,
					pageable : true,
					columns : [ {
						field : "serDocIdAct",
						title : "Doc. Ident.",
						filterable : false
					}, {
						field : "serApePat",
						title : "Ap. Paterno",
						filterable : false
					}, {
						field : "serApeMat",
						title : "Ap. Materno",
						filterable : false
					}, {
						field : "serNombres",
						title : "Nombres",
						filterable : false
					}, {
						field : "totalDu37",
						title : "Total D.U. 037-94",
						format: "{0:n}",
						filterable : false
					}, {
						command : {
							text : "Ver Reporte",
							click : downloadPdf
						},
						title : "",
						width : "180px"
					} ]
				});
			});

			function isEmpty(variable) {
				if (variable != null && variable != "") {
					return false;
				} else {
					return true;
				}

			}

			function downloadPdf(e) {
				e.preventDefault();
				var serDocIdAct = this.dataItem($(e.currentTarget)
						.closest("tr")).serDocIdAct;
				download('pdf', serDocIdAct);
			}

			function download(type, serDocIdAct) {
				// Retrieve download token
				// When token is received, proceed with download
				$.get('${downloadTokenUrl}', function(response) {
					// Store token
					var token = response.message[0];

					// Show progress dialog
					// 					$('#msgbox').text('Processing download...');
					// 					$('#msgbox').dialog( 
					// 							{	title: 'Download',
					// 								modal: true,
					// 								buttons: {"Close": function()  {
					// 									$(this).dialog("close");} 
					// 								}
					// 							});

					// Start download

					window.open(('${downloadUrl}' + '?token=' + token
							+ '&type=' + type + '&serDocIdAct=' + serDocIdAct),
							'_blank' // <- This is what makes it open in a new window.
					);
// 					window.location = '${downloadUrl}' + '?token=' + token
// 							+ '&type=' + type + '&serDocIdAct=' + serDocIdAct;
					// Check periodically if download has started
					var frequency = 1000;
					var timer = setInterval(function() {
						$.get('${downloadProgressUrl}', {
							token : token
						}, function(response) {
							// If token is not returned, download has started
							// Close progress dialog if started
// 							if (response.message[0] != token) {
// 								// 										$('#msgbox').dialog('close');
// 								clearInterval(timer);
// 							}
						});
					}, frequency);

				});
			}
		</script>

	</div>
</body>

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
