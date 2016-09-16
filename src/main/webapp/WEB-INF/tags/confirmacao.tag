<!-- Parametros -->
<%@ attribute name="id" required="true" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="controller" required="true" %>

<!-- <a href="#modal3" role="button" class="btn btn-primary" data-toggle="modal" data-target="#modal3"><i class="icon-trash icon-white"></i></a> -->
<button type="submit"  onclick="#${id}" role="button" class="btn btn-danger" data-toggle="modal" data-target="#${id}" >Excluir</button>

<div id="${id}" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel">Atenção</h3>
            </div>
            <div class="modal-body">
                <p>Deseja Excluir o registro?</p>
            </div>
            <div class="modal-footer">
            	<form action="${controller}" method="post">
					<input name="${name}" value="${id}" type="hidden" />
					<button type="submit" class="btn btn-danger" >Confirmar</button>
	                <button type="button" class="btn btn-warning" data-dismiss="modal" aria-hidden="true" >Cancelar</button>
				</form>
            </div>
        </div>
    </div>
</div>