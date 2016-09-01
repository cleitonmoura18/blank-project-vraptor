<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

	<div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Perfil</h2>
				<form action="${linkTo[PerfilController].adiciona(null)}" method="post">
					<div class="col-lg-8 col-md-8">
                        <div class="form-group">
							<label for="name">Nome:</label>
							<input type="text" name="role.name" id="name" class="form-control" value="${role.name}"/>
                        </div>
                    </div>
                    <div class="col-lg-8 col-md-8">
                        <div class="form-group">
                       		<button type="submit" class="btn btn-primary" >Salvar</button>
                        </div>
                    </div>
				</form>
            </div>
        </div>
        <hr />
	</div>
    
<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>