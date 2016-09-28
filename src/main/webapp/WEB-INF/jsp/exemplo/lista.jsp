<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m" %>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

<div id="page-inner">

	<div class="row">
		<div class="col-lg-12">
			<h2>LISTA DE EXEMPLOS</h2>
		</div>
	</div>
		
	<hr />
	<c:import url="/WEB-INF/jsp/mensagens.jsp"></c:import>

	<div class="row">
		<div class="col-lg-12">
			<form id="form" action="<c:url value="/exemplo/form" />" method="post">
				<p>
        			<button type="submit" class="btn btn-primary">Novo Exemplo</button>
        		</p>
        	</form>
        </div>
    </div>
   
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">Exemplos</div>
					<!-- /.panel-heading -->
                    <div class="panel-body">
                    	<div class="table-responsive">
                        	<table class="table table-striped table-bordered table-hover">
                            	<thead>
                            		<tr>
                            			<th>Id</th>
                                        <th>Descri��o</th>
                                        <th>A��es</th>
                                    </tr>
                                 </thead>
                                 <tbody>
                                 	<c:forEach items="${exemplos}" var="exemplo">
										<tr>
											<td>${exemplo.id}</td>
											<td>${exemplo.descricao}</td>
											<td>
												<a href="${linkTo[ExemploController].editar(exemplo.id)}"  class="btn btn-xs btn-info" >Editar</a>
												<m:confirmacao id="${exemplo.id}"  name="exemplo.id"  controller="${linkTo[ExemploController].excluir(exemplo.id)}" ></m:confirmacao>
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