<nav class="navbar navbar-default" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<g:link class="navbar-brand" mapping="home">0xQuestionApp</g:link>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<qa:header action="${['index', 'list']}"><g:link mapping="home">Home</g:link></qa:header>
				<qa:header action="${['create']}"><g:link controller="question" action="create">Ask Questions</g:link></qa:header>
				<li><a href="#about">About</a></li>
				<li><a href="#contact">Contact</a></li>
			</ul>

			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
			</form>

			<sec:ifLoggedIn>
				<ul class="nav navbar-nav navbar-right">
					<li><g:link controller="logout">Logout <sec:username/> <i class="fa fa-sign-out"></i></g:link></li>
				</ul>
			</sec:ifLoggedIn>

		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>
