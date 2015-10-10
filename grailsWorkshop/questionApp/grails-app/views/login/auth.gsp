<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="layout" content="main"/>
        <title>Login</title>
</head>

<body>
        <div class="jumbotron">
                <h3>0xQuestionApp Login</h3>
                <hr>
                <g:if test='${flash.message}'>
                        <div class="alert alert-error">
                                <button type="button" class="close" data-dismiss="alert">&times;</button>
                                <h5>Username or Password Incorrect</h5>
                                ${flash.message}
                        </div>
                </g:if>
                <form action='${postUrl}' method='POST' id='loginForm' autocomplete='off' role='form'>
                        <div class="row">
                                <div class="col-lg-4 col-md-4 col-sm-4 col-lg-offset-4 col-md-offset-4 col-sm-offset-4">
                                        <div class="form-group">
                                                <label class="control-label">Username</label>
                                                <input class="form-control" type="text" name='j_username' id='username' placeholder="Username"/>
                                        </div>
                                </div>
                        </div>
                        <div class="row">
                                <div class="col-lg-4 col-md-4 col-sm-4 col-lg-offset-4 col-md-offset-4 col-sm-offset-4">
                                        <div class="form-group">
                                                <label class="control-label">Password</label>
                                                <input class="form-control" type="password" name='j_password' id='password' id="inputpassword" placeholder="Password"/>
                                        </div>
                                </div>
                        </div>
                        <div class="row">
                                <div class="col-lg-4 col-md-4 col-sm-4 col-lg-offset-4 col-md-offset-4 col-sm-offset-4">
                                        <button type="submit" id="submit" class="btn" value='${message(code: "springSecurity.login.button")}'>Sign in</button>
                                </div>
                        </div>
                </form>
        </div>
</body>
</html>
