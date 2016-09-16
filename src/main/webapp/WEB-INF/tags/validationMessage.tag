<%@ attribute name="name"  required="true" %>

<%-- <span class="validation-error">
	${errors.from(name)}
</span> --%>
<div class="row">
	<div class="col-lg-12 ">
		<div class="alert alert-danger">
			<strong>${errors.from(name)}</strong>
		</div>
	</div>
</div>