<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

	<div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Usuário</h2>
				<form action="${linkTo[UsuarioController].adiciona(null)}" method="post">
						
						<label for="nome">Nome:</label>
						<input type="text" name="usuario.nome" id="nome" class="form-control" value="${usuario.nome}"/>
						<br/>
						<label for="login">Login:</label>
						<input type="text" name="usuario.login" id="login" class="form-control" value="${usuario.login}"/>
						<br/>
						<div>
                       		<button type="submit" class="btn btn-default" >Salvar</button>
                       	</div>
						
				</form>
            </div>
        </div>
        <hr />
	</div>
    
<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>