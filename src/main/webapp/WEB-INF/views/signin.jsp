<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SafeBanking - Home Page</title>
</head>
<body style="background-color: powderblue">
<h1> Hi ${fullName } This is your AccountNumber ${myAccountNumber} Welcome to <strong>Safe Banking</strong>  Please Enter your Credentials</h1>
<form action="validate-login" style="border:1px solid #ccc">
  <div class="container">
    <h1>Banking Services</h1>
    <p>Please fill in this form to Access your account.</p>
    <hr>

    <label for="AccountNumber"><b>AccountNumber</b></label>
    <input type="text" placeholder="AccountNumber" name="accountNumber" required>
    
    <br></br>

    <label for="password"><b>password</b></label>
    <input type="password" placeholder="password" name="password" required>
    
   <br></br>
    

    
<label>
      <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Terms & Conditions
    </label>
    <p>By Clicking this  you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

    <div class="clearfix">
      <button type="submit" class="cancelbtn">SignIn</button>
     </div>
<br></br>
 </form>   




<form action="password-page" style="border:1px solid #ccc">
    <div>
      <button type="submit" class="cancelbtn" style="height:20px ; width:150px;margin-right: 32px"  >ForgotPassword</button>
     </div>
 </form>
</body>
</html>