<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

	<div id="page-inner">
		<div class="row">
			<div class="col-lg-12">
				<h2>USUÁRIO</h2>
			</div>
		</div>
		
		<hr />
		<c:import url="/WEB-INF/jsp/mensagens.jsp"></c:import>
	
        <div class="row">
            <div class="col-md-12">
				
				<form action="<c:url value="/usuario/salvar"/>" method="post">
					<input type="hidden" name="usuario.id" id="id" class="form-control" value="${usuario.id}" />
					<div class="col-lg-10 col-md-10">
                        <div class="form-group">
							<label for="nome">Nome:</label>
							<input type="text" name="usuario.nome" id="nome" class="form-control text-uppercase" value="${usuario.nome}" />
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="form-group">
							<label for="login">Login:</label>
							<input type="text" name="usuario.login" id="login" class="form-control" value="${usuario.login}"/>
                        </div>
                    </div>
					<div class="col-lg-4 col-md-4">
						<div class="form-group">
                    		<label for="perfil">Perfil</label>
                    		<select id="perfil" name="role.name" class="form-control">
								<c:forEach items="${roles}" var="r">
    								<option value="${r.name}" ${role.name eq r.name ? 'selected' : '' }  >${r.name}</option>
								</c:forEach>
                    		</select>
                    	</div>
					</div>
					
				<div class="col-lg-8 col-md-8">
                        <div class="form-group">
                       		<button type="submit" class="btn btn-primary" name="_method" value="POST">Salvar</button>
                       		<button type="submit" class="btn btn-primary" name="_method" value="PUT">Resetar Senha</button>
                        </div>
                    </div>
				</form>
				<%-- <form action="${linkTo[UsuarioController].resetarSenha(null, null)}" method="post">
					<div class="col-lg-8 col-md-8">
                        <div class="form-group">
                       		<button type="submit" class="btn btn-primary" >Salvar</button>
                        </div>
                    </div>
				</form> --%>
            </div>
        </div>
        <hr />
	</div>
    
<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>