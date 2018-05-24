<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Everest</title>
    <!-- Bootstrap core CSS -->
	<link
	  href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	  rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous" />
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<style>
		
	</style>
</head>
<body class="gray-bg">

  <div class="middle-box text-center loginscreen animated fadeInDown">
    <div>
      
      <hr />

      <form newAttribute="getUser" action="saveMountaineer" method="POST">
        
        <h4>Please Sign In</h4>
	                    <span th:if="${logError != null}" class="error">  
		                    <div class="alert alert-danger" role="alert">
		                    	<strong>Oh no</strong> Invalid username and password.
		                    </div>
	                    </span>
	                    
	                    <span th:if="${logActivate != null}" class="error">  
		                    <div class="alert alert-danger" role="alert">
		                    	Please activate your account first
		                    </div>
	                    </span>
	                    
	                    <span th:if="${emailCheck != null}" class="error">  
						 	<div class="alert alert-success" role="alert">
						 		An email has been sent to your mailbox, please active it before continue.
						    </div>
	     				</span>

	                    <div class="form-group input-group">
	                    	<span class="input-group-addon">
					            <span class="glyphicon glyphicon-user"></span>
					         </span>
	                        <input type="email" name="username" id="username" class="form-control input-lg"
	                               placeholder="Email" required="true" autofocus="true" path="username"/>
	                    </div>
	                    
	                    <div class="form-group input-group">
	                    	<span class="input-group-addon">
					            <span class="glyphicon glyphicon-lock"></span>
					        </span>
	                        <input type="password" name="password" id="password" class="form-control input-lg"
	                               placeholder="Password" required="true" path="password"/>
	                    </div>

        <button type="submit" class="btn btn-primary block full-width m-b">Sign in</button>
      </form>
      <a href="http://localhost:8080/Everest/login/register"><button type="register" class="btn btn-secondary block full-width m-b">Register</button></a>
       <p class="m-t"> </p>
    </div>
  </div>


  <!-- jQuery-->
  <script
    src="//ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

  <!-- Bootstrap -->
  <script
    src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
    integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
    crossorigin="anonymous"></script>

  <!-- Bootstrap Validator plugin -->
  <script src="//cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js"></script>

</body>

</html>