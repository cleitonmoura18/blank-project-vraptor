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
					<a href="#" style="color:#fff;">LOGOUT</a>  
                </span>
            </div>
        </div>
		
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
					<li class="active-link">
                        <a href="${linkTo[LoginController].index}" ><i class="fa fa-desktop "></i>Dashboard </a>
                    </li>
                    <li>
                        <a href="${linkTo[UsuarioController].form}"><i class="fa fa-table "></i>Usuário </a>
                    </li>
                    <li >
                        <a href="${linkTo[UsuarioController].lista}"><i class="fa fa-edit "></i>Blank Page </a>
                    </li>
					<li>
                        <a href="#"><i class="fa fa-qrcode "></i>My Link One</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o"></i>My Link Two</a>
                    </li>

                    <li>
                        <a href="#"><i class="fa fa-edit "></i>My Link Three </a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-table "></i>My Link Four</a>
                    </li>
                     <li>
                        <a href="#"><i class="fa fa-edit "></i>My Link Five </a>
                    </li>
                </ul>
            </div>
        </nav>
		
        <div id="page-wrapper">
        	<!-- <main> -->
        	<!-- Conteudo -->
