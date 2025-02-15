<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Nuestra tienda virtual</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="css/card.css">
</head>
<body>

	<!-- Team -->
	<section id="team" class="pb-5">
		<div class="container">
			<h5 class="section-title h1">SERVICIOS</h5>
			<div class="row  justify-content-center pb-5">

				<div class="col-xs-12 col-sm-6 col-md-3">
					<a href="login.jsp"
						class="btn btn-lg btn-primary btn-block text-uppercase font-weight-bold mb-2 text-light"
						type="submit">Login</a>
				</div>

				<div class="col-xs-12 col-sm-6 col-md-3 align-self-center">
					<a href="registro.jsp"
						class="btn btn-lg btn-primary btn-block text-uppercase font-weight-bold mb-2 text-light"
						type="submit">Registrate</a>
				</div>
			</div>
			<div class="row">
				<!-- Team member -->
				<c:forEach var="tienda" items="${tiendas}">
					<div class="col-xs-12 col-sm-6 col-md-4">
						<div class="image-flip">
							<div class="mainflip flip-0">
								<div class="frontside">
									<div class="card">
										<div class="card-body text-center">
											<p>
												<img class=" img-fluid"
													src="<c:out value="${tienda.imagen}" />" alt="card image">
											</p>
											<h4 class="card-title">
												<c:out value="${tienda.nombre}" />
											</h4>
											<p class="card-text">
												<c:out value="${tienda.lema}" />
											</p>
											<a href="<c:out value="${tienda.facebook}" />"
												class="btn btn-primary btn-sm"><i class="fa fa-plus"></i></a>
										</div>
									</div>
								</div>
								<div class="backside">
									<div class="card">
										<div class="card-body text-center mt-4">
											<h4 class="card-title">
												<c:out value="${tienda.propietario}" />
											</h4>
											<p class="card-text">
												<c:out value="${tienda.descripcion}" />
											</p>
											<ul class="list-inline">
												<li class="list-inline-item"><a
													class="social-icon text-xs-center" target="_blank"
													href="<c:out value="${tienda.facebook}" />"> <i
														class="fa fa-facebook"></i>
												</a></li>
												<li class="list-inline-item"><a
													class="social-icon text-xs-center" target="_blank"
													href="<c:out value="${tienda.web}" />"> <i
														class="fa fa-share"></i>
												</a></li>
												<li class="list-inline-item"><a
													class="social-icon text-xs-center" target="_blank"
													href="tienda?action=servicios&id=${tienda.id} }"> <i
														class="fa fa-info-circle"></i>
												</a></li>

											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				<!-- ./Team member -->

			</div>
		</div>
	</section>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>