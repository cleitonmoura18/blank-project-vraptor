<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m" %>
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
                        <h3 class="panel-title">Alterar Senha</h3>
                    </div>
                    <div class="panel-body">
                    	<form action="${linkTo[LoginController].alterarSenha(null, null, null, null, null)}" method="post">
                            <fieldset>
								<c:forEach var="error" items="${errors}">
									<m:validationMessage name="${error.category}"></m:validationMessage>
								</c:forEach>
								<c:if test="${not empty erro}">
									<m:exceptionMessage></m:exceptionMessage>
								</c:if>
								<c:if test="${not empty sucesso}">
									<m:sucessoMessage></m:sucessoMessage>
								</c:if>
								<div class="form-group">
                                    <input class="form-control" placeholder="Login" id="login" name="login" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Senha" id="senha" name="senha" type="password" value="">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Novo Login" id="novoLogin" name="novoLogin" type="text">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Nova Senha" id="novaSenha" name="novaSenha" type="password" value="">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Confirme a Senha" id="confirmeSenha" name="confirmeSenha" type="password" value="">
                                </div>
                                
                                <input class="btn btn-lg btn-primary btn-block" type="submit" value="Enviar"/>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>

</html>