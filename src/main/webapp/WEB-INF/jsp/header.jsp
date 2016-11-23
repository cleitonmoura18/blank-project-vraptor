<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
    	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Blank Project</title>
		<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet"/>
		<link href="<c:url value='/css/font-awesome.css'/>" rel="stylesheet"/>
		<link href="<c:url value='/css/custom.css'/>" rel="stylesheet"/>
		<link href="<c:url value='/css/jquery-ui.min.css'/>" rel="stylesheet"/>
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel="stylesheet"/>
	</head>
	
	<body>
	
		<div id="wrapper">
		
			<div class="navbar navbar-inverse navbar-fixed-top">
            <div class="adjust-nav">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">
                        <img src="/blank/img/logo.png" />
                    </a>
                </div>
              
                <span class="logout-spn" >
					<a href="${linkTo[LoginController].desloga}" style="color:#fff;">SAIR</a>  
                </span>
            </div>
        </div>
		
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
					<li id="menu-dashboard">
                        <a href="${linkTo[LoginController].index}" ><i class="fa fa-desktop "></i>Dashboard</a>
                    </li>
                    <li id="menu-usuario">
                        <a href="${linkTo[UsuarioController].lista}"><i class="fa fa-user "></i>Usuário</a>
                    </li>
                    <c:if test="${usuarioLogado.administrador}">
                    	<li id="menu-perfil">
                        	<a href="${linkTo[PerfilController].lista}"><i class="fa fa-key "></i>Perfil</a>
                    	</li>
                    </c:if>
					<li id="menu-exemplo">
                        <a href="${linkTo[ExemploController].lista}"><i class="fa fa-list-ul "></i>Exemplo</a>
                    </li>
                </ul>
            </div>
        </nav>
		
        <div id="page-wrapper">
        	<!-- <main> -->
        	<!-- Conteudo -->
