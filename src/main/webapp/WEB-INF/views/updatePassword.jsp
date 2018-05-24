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
      <h4>Please set up your password to continue</h4>

      <form autocomplete="off" class="m-t" role="form" newAttribute="newUser" action="registerPassword" method="POST">
        <div class="form-group input-group">
			<span class="input-group-addon">
				<span class="glyphicon glyphicon-user"></span>
			</span>
	        <input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password" required="true" autofocus="true" path="password"/>
	    </div>
	    
	    <div class="form-group input-group">
			<span class="input-group-addon">
				<span class="glyphicon glyphicon-user"></span>
			</span>
	        <input type="password" name="confirm_password" id="confirm_password" class="form-control input-lg" placeholder="Password confirm" required="true" autofocus="true"/>
	    </div>
	                    
        <button type="submit" class="btn btn-primary block full-width m-b">Register</button>
      </form>
      <p class="m-t"></p>
    </div>
  </div>


  <!-- jQuery-->
  <script
    src="//ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    
	<script type="text/javascript">
	  var password = document.getElementById("password")
	  var confirm_password = document.getElementById("confirm_password");
	
	function validatePassword(){
	  if(password.value != confirm_password.value) {
	    confirm_password.setCustomValidity("Passwords Don't Match");
	  } else {
	    confirm_password.setCustomValidity('');
	  }
	}
	
	password.onchange = validatePassword;
	confirm_password.onkeyup = validatePassword;
  </script>

  <!-- Bootstrap -->
  <script
    src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
    integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
    crossorigin="anonymous"></script>

  <!-- Bootstrap Validator plugin -->
  <script src="//cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js"></script>

 
</body>
</html>