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
    
    <hr/>

	<div class="row">
		<div class="col-lg-12 col-md-12">
			<h5>Panel Sample</h5>
			<div class="panel panel-primary">
				<div class="panel-heading">Default Panel</div>
				<div class="panel-body">
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare
						lacus adipiscing, posuere lectus et, fringilla augue.</p>
				</div>
				<div class="panel-footer">Panel Footer</div>
			</div>
		</div>
		<div class="col-lg-6 col-md-6">
			<h5>Accordion Sample</h5>
			<div class="panel-group" id="accordion">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne" class="collapsed">Collapsible Group Item
								#1</a>
						</h4>
					</div>
					<div id="collapseOne" class="panel-collapse collapse"
						style="height: 0px;">
						<div class="panel-body">Lorem ipsum dolor sit amet,
							consectetur adipisicing elit, sed do eiusmod tempor incididunt.</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseTwo">Collapsible Group Item #2</a>
						</h4>
					</div>
					<div id="collapseTwo" class="panel-collapse in"
						style="height: auto;">
						<div class="panel-body">Lorem ipsum dolor sit amet,
							consectetur adipisicing elit, sed do eiusmod tempor incididunt.</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseThree" class="collapsed">Collapsible Group
								Item #3</a>
						</h4>
					</div>
					<div id="collapseThree" class="panel-collapse collapse">


						<div class="panel-body">Lorem ipsum dolor sit amet,
							consectetur adipisicing elit, sed do eiusmod tempor incididunt.</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-6 col-md-6">
			<h5>Tabs Sample</h5>
			<ul class="nav nav-tabs">
				<li class="active"><a href="#home" data-toggle="tab">Home</a></li>
				<li class=""><a href="#profile" data-toggle="tab">Profile</a></li>
				<li class=""><a href="#messages" data-toggle="tab">Messages</a>
				</li>

			</ul>
			<div class="tab-content">
				<div class="tab-pane fade active in" id="home">
					<h4>Home Tab</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit
						eserunt mollit anim id est laborum. Lorem ipsum dolor sit amet,
						consectetur adipisicing elit eserunt mollit anim id est laborum.
						Lorem ipsum dolor sit amet, consectetur adipisicing elit eserunt
						mollit anim id est laborum.</p>
				</div>
				<div class="tab-pane fade" id="profile">
					<h4>Profile Tab</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit
						eserunt mollit anim id est laborum. Lorem ipsum dolor sit amet,
						consectetur adipisicing elit eserunt mollit anim id est laborum.
						Lorem ipsum dolor sit amet, consectetur adipisicing elit eserunt
						mollit anim id est laborum.</p>

				</div>
				<div class="tab-pane fade" id="messages">
					<h4>Messages Tab</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit
						eserunt mollit anim id est laborum. Lorem ipsum dolor sit amet,
						consectetur adipisicing elit eserunt mollit anim id est laborum.
						Lorem ipsum dolor sit amet, consectetur adipisicing elit eserunt
						mollit anim id est laborum.</p>

				</div>

			</div>
		</div>

	</div>
	
	<hr/>

	<div class="col-lg-12 col-md-12">
		<h5>Exemplos</h5>
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th>id</th>
						<th>Descrição</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${exemplos}" var="exemplo">
						<tr >
							<td>${exemplo.id}</td>
							<td>${exemplo.descricao}</td>
						</tr>
					</c:forEach>
					<tr class="success">
						<td>#</td>
						<td>Success</td>
					</tr>
					<tr class="info">
						<td>#</td>
						<td>Info</td>
					</tr>
					<tr class="warning">
						<td>#</td>
						<td>Warning</td>
					</tr>
					<tr class="danger">
						<td>#</td>
						<td>Danger</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<hr/>
   
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
                                        <th>Descrição</th>
                                        <th>Ações</th>
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
<script src="/blank/js/exemplo.js"></script>