<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Safe Banking</title>
</head>
<body>
 <form action="create-user" style="border:1px solid #ccc">
  <div class="container">
    <h1>Sign Up</h1>
    
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="fullName"><b>FullName</b></label>
    
    <input type="text"  name="fullName" required>
   <br></br>
   
   <br></br>
    
    <label for="gender"><b>Gender</b></label>
    <input type="text" name="gender" required>
    <br></br>
    <br></br>
    
    
    <label for="mobileNumber"><b>MobileNumber</b></label>
    <input type="text" name="mobileNumber"   maxlength="10"   minlength="10" required>
    
    <br></br>
    
    <br></br>
    
     <label for="dob"><b>Date Of Birth</b></label>
    <input type="date" name="dob" required>
    
    <br></br>
    <br></br>
    
    
    

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" maxlength="8" minlength="8" required  >
    
    <br></br>
    
    <br></br>

    <label for="confirm-password"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="confirm-password" maxlength="8" minlength="8" required>
    
    <br></br>
    
    <br></br>
   
    
    
    
    
    <label for="accountBalance"><b>AccountBalance</b></label>
    <input type="text" placeholder="AccountBalance" name="accountBalance" required>
    
    <br></br>
    
    <br></br>
  
 
      <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
    </label>

    <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

    <div class="clearfix">
      <button type="button" class="cancelbtn" style="height:20px ; width:150px;margin-right: 32px"  >Cancel</button>
      <button type="submit" class="signupbtn"  style="height:20px ; width:150px ; margin-right: 32px" >Sign Up</button>
    </div>
  </div>
</form>


</body>
</html>