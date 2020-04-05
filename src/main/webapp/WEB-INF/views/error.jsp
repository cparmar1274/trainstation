<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="trainStation">

<head>
<meta charset="UTF-8">
<title>Landing Page</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
</head>

<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container">
				<a class="navbar-brand" href="#">Train Station</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active"><a class="nav-link" href="#!">Home
								<span class="sr-only">(current)</span>
						</a></li>
					</ul>

				</div>
				<form class="form-inline my-2 my-lg-0" action="/logout">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</button>
				</form>
			</div>
		</nav>
	</header>

	<div class="container" style="margin-top: 5%">
		<h1>${errorCode}</h1>
		<span>${errorMessage}</span> <br> Go back to <a href="/">Home</a>
	</div>

</body>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</html>