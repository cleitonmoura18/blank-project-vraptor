<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/header.jsp"></c:import>
	<%-- <h1 class="page-header">${variable} ${linkTo[LoginController].index}</h1> --%>
<div id="page-inner">
	<div class="row">
		<div class="col-lg-12">
			<h2>DASHBOARD</h2>
		</div>
	</div>

	<hr />
	<div class="row">
		<div class="col-lg-12 ">
			<div class="alert alert-info">
				<strong>Bem Vindo ${usuarioLogado.usuario.nome}! </strong> Você está
				logado como ${usuarioLogado.role}.
			</div>
		</div>
	</div>

	<div class="row text-center pad-top">
	
		<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
			<div class="div-square">
				<a href="${linkTo[UsuarioController].lista}"> <i
					class="fa fa-users fa-5x"></i>
					<h4>Usuários</h4>
				</a>
			</div>
		</div>
		<c:if test="${usuarioLogado.administrador}">
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
				<div class="div-square">
					<a href="${linkTo[PerfilController].lista}"> <i
						class="fa fa-key fa-5x"></i>
						<h4>Permissões</h4>
					</a>
				</div>
			</div>
		</c:if>
		<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
			<div class="div-square">
				<a href="${linkTo[ExemploController].lista}"> <i
					class="fa fa-list-ul fa-5x"></i>
					<h4>Exemplos</h4>
				</a>
			</div>
		</div>
	</div>
</div>


<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>
<script src="/blank/js/dashboard.js"></script>