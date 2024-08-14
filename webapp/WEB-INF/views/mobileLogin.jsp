<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="mobile-Login" style="border:1px solid #ccc">
  <div class="container">
    <h1>Banking Services</h1>
    <p>Please fill in this form to Access your account.</p>
    <hr>

    <label for="mobileNumber"><b>MobileNumber</b></label>
    <input type="text" placeholder="MobileNumber" name="mobileNumber" required>
    
    <br></br>

    <label for="password"><b>password</b></label>
    <input type="password" placeholder="password" name="password" required>
    
   <br></br>
    </div>

    
<label>
      <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Terms & Conditions
    </label>
    <p>By Clicking this  you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

    <div class="clearfix">
      <button type="submit" class="cancelbtn">SignInM</button>
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
