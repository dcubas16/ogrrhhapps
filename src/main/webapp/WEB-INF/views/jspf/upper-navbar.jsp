<%@	taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="row" id="upper-navbar">
	<div class="col-md-1"></div>
	<div class="col-md-6 search-bar-separator">
		<div class="page-content">
			<div class="input-group">
				<input type="text" class="form-control input-group-small"
					id="searchInput" placeholder="Buscar..."
					data-bind="value: viewModelUpperNavBar.searchInput()"> <span
					class="input-group-btn">
					<button class="btn btn-primary btn-md" type="button"
						data-bind="click: searchButtonClick">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</span>
			</div>
		</div>
	</div>
	<div id="userBar" class="col-md-5 search-bar-separator" align="right">
		<div class="btn-group">
			<button type="button" class="btn btn-primary dropdown-toggle btn-sm"
				data-toggle="dropdown">
				<span class="glyphicon glyphicon-user">
				</span>  Erwin  <span class="caret"></span>
			</button>
			<ul class="dropdown-menu dropdown-menu-left-position" role="menu">
				<li><a href="../ogrrhhapps/historial_navegacion.htm">Historial</a></li>
				<li><a href="#">Cerrar Sesión</a></li>
			</ul>
		</div>
	</div>
</div>
<script src="../ogrrhhapps/resources/javascript/ogrrhhapps/upper-nav-bar.js"
	type="text/javascript"></script>
