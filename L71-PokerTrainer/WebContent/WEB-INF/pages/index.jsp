<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link href="<c:url value="/resources/css/united.css"/>" rel="stylesheet"
	type="text/css">
<script src="<c:url value="/resources/scripts/jquery-2.1.1.min.js"/>"
	type="text/javascript"></script>
<script src="<c:url value="/resources/scripts/bootstrap.js"/>"
	type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>

<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-responsive-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

			</div>
			<div class="navbar-collapse collapse navbar-responsive-collapse">

				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath}/" title="Home">Back</a></li>
					<c:if test="${currentuser == null}">
						<li><a href="${pageContext.request.contextPath}/login"
							title="LogIn" id="LoginPopup">Login</a></li>
						<li><a href="${pageContext.request.contextPath}/registration"
							title="Registration">Register</a></li>
					</c:if>
					<c:if test="${currentuser != null && !isAdmin}">
						<li><a href="${pageContext.request.contextPath}/"
							title="User">${currentuser}</a></li>
					</c:if>
					<c:if test="${currentuser != null && isAdmin}">
						<li><a href="${pageContext.request.contextPath}/admin"
							title="User">${currentuser}</a></li>
					</c:if>
					<c:if test="${currentuser != null}">
						<li><a href="${pageContext.request.contextPath}/logout"
							title="User">Logout</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
	<div class="container body-content">
		<div class="jumbotron">
			<h1>Poker Trainer</h1>
		</div>
		<c:if test="${level == 'A'}">
			<h2>You are a poker profi!</h2>
		</c:if>
		<c:if test="${level == 'N'}">
			<h2>You are a poker looser! Please try to improve your skills.</h2>
			<h2><a href="${pageContext.request.contextPath}/learn">Learn new!</a></h2>
		</c:if>
		<form:form action="/PokerTrainer/" method="POST" cssClass="form-horizontal">
			<c:if test="${result.questions != null}">
				<table class="table table-striped table-hover">
					<!-- column data -->
					<tbody>
						<c:forEach var="question" items="${result.questions}"
							varStatus="loop">
							<tr>${loop.index+1}-${question.getText()}
							</tr>
							<br>
							<c:forEach var="answer" items="${result.answers}">
								<c:if
									test="${answer.getQuestionId() == question.getQuestionId()}">
									<tr>
									<input type="radio" name="answer_${loop.index+1}" value="${answer.answerId}" />${answer.getText()}
									</tr>
									<br>
								</c:if>
							</c:forEach>
							<br>
							<br>
						</c:forEach>
					</tbody>
				</table>
				<div class="form-actions">
					<tr>
						<td><input type="submit" value="Submit"
							class="btn btn-primary"></td>
					</tr>
				</div>
			</c:if>
		</form:form>
		<hr />
		<footer> </footer>
	</div>

</body>
</html>
