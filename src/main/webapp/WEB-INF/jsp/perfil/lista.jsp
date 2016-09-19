<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

<div id="page-inner">
	<div class="row">
		<div class="col-lg-12">
        	<h2>Lista de Roles</h2>
			<form id="form" action="<c:url value="/perfil/form" />" method="post">
				<p>
        			<button type="submit" class="btn btn-primary">Novo Perfil</button>
        		</p>
        	</form>
        </div>
    </div>
	
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">Roles</div>
					<!-- /.panel-heading -->
                    <div class="panel-body">
                    	<div class="table-responsive">
                        	<table class="table table-striped table-bordered table-hover">
                            	<thead>
                            		<tr>
                            			<th>Descrição</th>
                                    </tr>
                                 </thead>
                                 <tbody>
                                 	<c:forEach items="${roles}" var="role">
										<tr>
											<td>${role.name}</td>
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