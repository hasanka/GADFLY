<!doctype html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> 	<html lang="en"> <!--<![endif]-->
<head>

	<!-- General Metas -->
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	<!-- Force Latest IE rendering engine -->
	<title>Login Form</title>
	<meta name="description" content="">
	<meta name="author" content="">
	<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	
	<!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" /> 
	
	<!-- Stylesheets -->
	<link rel="stylesheet" href="themes/login/css/base.css">
	<link rel="stylesheet" href="themes/login/css/skeleton.css">
	<link rel="stylesheet" href="themes/login/css/layout.css">
	
</head>
<body>

	<div class="notice" id="errorMsg">
		<a href="" class="close">close</a>
		<p class="warn">Whoops! We didn't recognise your username or password. Please try again.</p>
	</div> 



	<!-- Primary Page Layout -->

	<div class="container">
		
		<div class="form-bg">
			<form action="j_spring_security_check" method="post">
				<h2>Login</h2>
				<p><input type="text" placeholder="Username" name="username" id="username"></p>
				<p><input type="password" placeholder="Password" name="password" id="password"></p>
				<label for="remember">
				  <input type="checkbox" id="remember" value="remember" />
				  <span>Remember me on this computer</span>
				</label>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<button type="submit"></button>
			</form>
		</div>

	
		<p class="forgot">Forgot your password? <a href="">Click here to reset it.</a></p>


	</div>

	<!-- JS  -->
	<script src="javascript/jquery/jquery.js"></script>
	<script src="private/login/js/login.js"></script>
	
<!-- End Document -->
</body>
</html>