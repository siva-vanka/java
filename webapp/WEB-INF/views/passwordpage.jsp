<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>  please Enter New Password </h1>
    
      <form action="passwordChange" style="border:1px solid #ccc">
  <div class="container">
    
    <label for ="AccountNumber"><b>AccountNumber</b></label><input type="text" name = "accountNumber">

<label  for="passwordChanged"><b>passwordChanged</b></label>
    
<input  type="password"  name="passwordChanged" required>
    
    <input type="submit" placeholder="NewPassword" name="passwordChange" required>
   </div>
   </form>
</body>
</html>