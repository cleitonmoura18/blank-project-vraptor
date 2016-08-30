<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

<div id="page-inner">
	<div class="row">
		<div class="col-lg-12">
        	<h2>Lista de Usuários</h2>
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
                            			<th></th>
                                        <th>Nome</th>
                                        <th>Login</th>
                                    </tr>
                                 </thead>
                                 <tbody>
                                 	<c:forEach items="${usuarios}" var="usuario">
										<tr>
											<td>${usuario.nome}</td>  
											<td>${usuario.login}</td>
											<td><a href="/usuario/edita?item=${usuario.id}">Editar</a></td>
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