<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Safe Banking </title>
</head>
<body>

<form action="view-Balance" style="border:1px solid #ccc">
  <div class="container">
    <h1>Banking Services</h1>
    <p>Please Select the Options .</p>
    <hr>
<h1>Your accountBalance is ${existingBalance}</h1>
    <label for="viewBalance"><b>viewBalance</b></label>
   <input type="text" name = "accountNumber" >
    
    <input type="submit" placeholder="viewBalance" name="viewBalance" required>
    </div>
    </form>
    <br></br>
    
 <form action="withdrawAmount" style="border:1px solid #ccc">
  <div class="container">

<h1>please enter your withdrawalAmount</h1>

<label for = "AccountNumber" ><b>AccountNumber</b></label><input type="text" name = "accountNumber" >
    <label for="withdrawAmount"><b>WithdrawAmount</b></label>
    <input for ="AccountNumber" type="text"  name="withdrawAmount" required>
    
    <input type="submit" placeholder="enterAmount" name="withdrawAmount" required>
    
    
    

    
    
    </div>
    </form>
    
    <br></br>
    
    
     <form action="depositAmount" style="border:1px solid #ccc">
  <div class="container">

<h1>please enter your DepositAmount</h1>

<label for = "AccountNumber" ><b>AccountNumber</b></label><input type="text" name = "accountNumber" >
    <label for="DepositAmount"><b>DepositAmount</b></label>
    <input type="text"  name="depositAmount" required>
    
    <input type="submit" placeholder="enterAmount" name="DepositAmount" required>
    
    
 </div>
 
 </form>
    <br></br>
    
    <h1>  please Enter New Password </h1>
    
      <form action="passwordChange" style="border:1px solid #ccc">
  <div class="container">
    
    <label for ="AccountNumber"><b>AccountNumber</b></label><input type="text" name = "accountNumber">

<label  for="passwordChanged"><b>passwordChanged</b></label>
    
<input for ="AccountNumber" type="password"  name="passwordChanged" required>
    
    <input type="submit" placeholder="NewPassword" name="passwordChange" required>
   


  
</div>
</form>
</body>
</html>