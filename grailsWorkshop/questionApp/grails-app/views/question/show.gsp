<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<meta content="main" name="layout">
	<title>Question</title>
</head>

<body>
	<qa:row>
		<div class="col-md-1">
			<div class="row">
				<g:link controller="vote" action="voteUpQuestion" id="${question.id}">
					<span class="glyphicon glyphicon-plus"></span>
				</g:link>
			</div>
      <div class="row">
			     <h2>${question.voteCount}</h2>
      </div>

			<div class="row">
				<g:link controller="vote" action="voteDownQuestion" id="${question.id}">
					<span class="glyphicon glyphicon-minus"></span>
				</g:link>
			</div>
		</div>

		<div class="col-md-10">
			<div class="row">
				<div class="col-md-9">
					<h2>${question.title}</h2>
				</div>

			</div>

			<p>${question.text}</p>

			<div class="row">
				<div class="offset8">
					<qa:signature user="${question.user}" />
				</div>
			</div>

			<g:render template="answered" collection="${answers}" var="answer" />

		</div>
	</qa:row>

	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<g:if test="${flash.message}">
				<div class="alert alert-error">${flash.message}</div>
			</g:if>

			<g:hasErrors bean="${answer}">
				<g:renderErrors bean="${answer}" as="list" />
			</g:hasErrors>

			<g:form class="form" controller="answer" action="answer" id="${question.id}">
				<div class="form-group">
					<label for="answer">Your Answer</label>
				</div>

				<div class="form-group">
					<g:textArea name="answer" rows="10" cols="80" />
				</div>

				<div class="form-group">
					<g:submitButton class="btn" name="postAnswer" value="Post Answer" />
				</div>
			</g:form>
		</div>
	</div>

</body>
</html>
