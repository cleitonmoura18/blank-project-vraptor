<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ taglib uri="/WEB-INF/tags" prefix="v" %> --%>
<!DOCTYPE html>
<html>

<head>
		<title>Blank Project</title>
		<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet"/>
		<link href="<c:url value='/css/font-awesome.css'/>" rel="stylesheet"/>
		<link href="<c:url value='/css/custom.css'/>" rel="stylesheet"/>
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel="stylesheet"/>
</head>

<body>

    <div class="container">
        <div class="row vertical-offset-100">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Login</h3>
                    </div>
                    <div class="panel-body">
                    	<form action="${linkTo[LoginController].logar(null, null)}" method="post">
                            <fieldset>
                            	<!-- <div class="alert alert-info">
									<strong>
                            			<v:validationMessage name="login_invalido"></v:validationMessage>
									</strong>
								</div> -->
                                <div class="form-group">
                                    <input class="form-control" placeholder="Login" id="login" name="login" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Senha" id="senha" name="senha" type="password" value="">
                                </div>
                                
                                <input class="btn btn-lg btn-success btn-block" type="submit" value="Enviar"/>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>

</html>