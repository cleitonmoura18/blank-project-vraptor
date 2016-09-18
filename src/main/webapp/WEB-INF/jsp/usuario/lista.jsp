<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m" %>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

<div id="page-inner">

	<div class="row">
		<div class="col-lg-12">
			<h2>LISTA DE USUÁRIOS</h2>
		</div>
	</div>
		
	<hr />
	
	<c:if test="${not empty exception}">
		<m:exceptionMessage></m:exceptionMessage>
	</c:if>
	<c:if test="${not empty sucesso}">
		<m:sucessoMessage></m:sucessoMessage>
	</c:if>

	<div class="row">
		<div class="col-lg-12">
			<form id="form" action="<c:url value="/usuario/form" />" method="post">
				<p>
        			<button type="submit" class="btn btn-primary">Novo Usuario</button>
        		</p>
        	</form>
        </div>
    </div>
   
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">Usuários</div>
					<!-- /.panel-heading -->
                    <div class="panel-body">
                    	<div class="table-responsive">
                        	<table class="table table-striped table-bordered table-hover">
                            	<thead>
                            		<tr>
                            			<th>Nome</th>
                                        <th>Login</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                 </thead>
                                 <tbody>
                                 	<c:forEach items="${usuarios}" var="usuario">
										<tr>
											<td>${usuario.nome}</td>  
											<td>${usuario.login}</td>
											<td>
												<form action="${linkTo[UsuarioController].editar(null)}" method="post">
													<input name="usuario.id" value="${usuario.id}" type="hidden" />
													<button type="submit" class="btn btn-primary" >Editar</button>
												</form>
											</td>
											<td>
												<m:confirmacao id="${usuario.id}"  name="usuario.id"  controller="${linkTo[UsuarioController].excluir(null)}" ></m:confirmacao>
											</td>
										</tr>
									</c:forEach>
                                 </tbody>
                            </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
      </div>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>