<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

	<div id="page-inner">
		<div class="row">
			<div class="col-lg-12">
				<h2>EXEMPLO</h2>
			</div>
		</div>
		
		<hr />
		<c:import url="/WEB-INF/jsp/mensagens.jsp"></c:import>
	
        <div class="row">
            <div class="col-md-12">
				
				<form action="<c:url value="/exemplo/enviar"/>" method="post">
					<input type="hidden" name="exemplo.id" id="id" class="form-control" value="${exemplo.id}" />
					<div class="col-lg-8 col-md-8">
                        <div class="form-group">
							<label for="nome">Descrição:</label>
							<input type="text" name="exemplo.descricao" id="descricao" class="form-control text-uppercase" value="${exemplo.descricao}" />
                        </div>
                    </div>
					<div class="col-lg-4 col-md-4">
						<div class="form-group">
                    		<label for="exemploLista">Exemplos</label>
                    		<select id="exemploLista" name="exemplo1.descricao" class="form-control">
								<c:forEach items="${exemplos}" var="ex">
    								<option value="${ex.descricao}" ${exemplo1.descricao eq ex.descricao ? 'selected' : '' }  >${ex.descricao}</option>
								</c:forEach>
                    		</select>
                    	</div>
					</div>
					
				<div class="col-lg-8 col-md-8">
                        <div class="form-group">
                       		<button type="submit" class="btn btn-primary" name="_method" value="POST">Enviar Post</button>
                       		<button type="submit" class="btn btn-primary" name="_method" value="PUT">Enviar Put</button>
                        </div>
                    </div>
				</form>
            </div>
        </div>
        <hr />
	</div>
    
<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>