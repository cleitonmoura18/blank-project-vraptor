<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Blank Project</title>
		<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet"/>
		<link href="<c:url value='/css/font-awesome.min.css'/>" rel="stylesheet"/>
		<link href="<c:url value='/css/custom.css'/>" rel="stylesheet"/>
		<link href="<c:url value='/css/metisMenu.min.css'/>" rel="stylesheet"/>
	</head>
	<body>
		<div id="wrapper">
			<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
			<div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${linkTo[IndexController].index}">Blank Project</a>
            </div>
            
            <ul class="nav navbar-right top-nav">
                <li>
                    <a><i class="fa fa-user"></i> John Smith </a>
                </li>
            </ul>
            
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="index.html"><i class="fa fa-edit fa-fw"></i> Forms</a>
                        </li>
                        <li>
                            <a href="index.html"><i class="fa fa-edit fa-fw"></i> Forms</a>
                        </li>
                        <li>
                            <a href="index.html"><i class="fa fa-edit fa-fw"></i> Forms</a>
                        </li>
                        <li>
                            <a href="index.html"><i class="fa fa-edit fa-fw"></i> Forms</a>
                        </li>
                        <li>
                        	<a href="#"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
			<%-- <ul class="nav nav-tabs">
				<li><a href="${linkTo[IndexController].index}">Home</a>
			</ul> --%>
		</nav>
		
		<!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <main class="col-lg-8">
                    	<!-- Conteudo -->
                        
                
			
