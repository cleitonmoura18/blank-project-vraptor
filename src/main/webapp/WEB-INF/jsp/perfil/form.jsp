<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m" %>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

	<div id="page-inner">
		
		<div class="row">
			<div class="col-lg-12">
				<h2>PERFIL</h2>
			</div>
		</div>
		
		<hr />
		<c:forEach var="error" items="${errors}">
			<m:validationMessage name="${error.category}"></m:validationMessage>
		</c:forEach>
		<c:if test="${not empty erro}">
			<m:exceptionMessage></m:exceptionMessage>
		</c:if>
		<c:if test="${not empty sucesso}">
			<m:sucessoMessage></m:sucessoMessage>
		</c:if>
		
        <div class="row">
            <div class="col-md-12">
				<form action="${linkTo[PerfilController].salvar(null)}" method="post">
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