<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml" xmlns:sf="http://www.w3.org/1999/xhtml" lang="en">
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
      <h4>New User Registration</h4>

      <form autocomplete="off" class="m-t" role="form" newAttribute="newUser" action="register" method="POST">
      	<span th:if="${emailCheck != null}" class="error">  
						 	<div class="alert alert-danger" role="alert">
						 		The email is exist, please choose another email.
						    </div>
	     				</span>
      
        <div class="form-group input-group">
			<span class="input-group-addon">
				<span class="glyphicon glyphicon-user"></span>
			</span>
	        <input type="email" name="username" id="username" class="form-control input-lg" placeholder="Email" required="true" autofocus="true" path="username"/>
	     </div>
	                    
        <button type="submit" class="btn btn-primary block full-width m-b">Register</button>
      </form>
      <p class="m-t"></p>
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