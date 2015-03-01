<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<c:import url="../views/jspf/resources.jsp" />
</head>
<body>
	<div class="container">
		<br>
		<form class="form-horizontal">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Doc. Ident</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputEmail3"
						placeholder="Doc. Ident">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Ap. Paterno</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputPassword3"
						placeholder="Ap.Paterno">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Ap. Materno</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputPassword3"
						placeholder="Ap. Materno">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Nombres</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputPassword3"
						placeholder="Nombres">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Buscar</button>
				</div>
			</div>
		</form>

		 <br>
		 <div id="grid"></div>
            <script>
                $(document).ready(function() {
                    $("#grid").kendoGrid({
                        dataSource: {
                            data: servidoresEncontrados,
                            schema: {
                                model: {
                                    fields: {
                                    	ser_doc_id_act: { type: "string" },
                                    	ser_ape_pat: { type: "string" },
                                    	ser_ape_mat: { type: "string" },
                                    	ser_nombres: { type: "string" },
                                    	total_du: { type: "number" }
                                    }
                                }
                            },
                            pageSize: 15,
                            serverPaging: true,
                            serverFiltering: true,
                            serverSorting: true
                        },
                        height: 550,
                        filterable: true,
                        sortable: true,
                        pageable: true,
                        columns: [{
                                field:"ser_doc_id_act",
                                title: "Doc. Ident.",
                                filterable: false
                            },{
                            	field: "ser_ape_pat",
                            	title: "Ap. Paterno",
                                filterable: false
                            },                            
                            {
                                field: "ser_ape_mat",
                                title: "Ap. Materno",
                                filterable: false
                            }, {
                                field: "ser_nombres",
                                title: "Nombres",
                                filterable: false
                            }, {
                                field: "total_du",
                                title: "Total D.U. 037-94",
                                filterable: false
                            }
                        ]
                    });
                });
            </script>

	</div>
</body>
<script>
	// 	var leyNorma = function(tipo, numero_norma, descripcion) {
	// 		tipo = ko.observable(tipo);
	// 		numero_norma = ko.observable(numero_norma);
	// 		descripcion = ko.observable(descripcion);
	// 	};

	// 	var viewModel = {
	// 		LeftMenu : ko.observableArray(),
	// 		MenuTabs : ko.observableArray(),
	// 		Tree : ko.observableArray(),
	// 		Cultures : ko.observableArray(),
	// 		MainContent : ko.observable(),
	// 		NavigationLine : ko.observableArray()
	// 	};

	// 	ko.applyBindings(viewModel, $('#page-content')[0]);
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
