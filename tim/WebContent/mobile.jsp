<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mobile Rrcharge</title>
</head>
<body>
          <form action="services/dth" method="post">
        Account Number:<input type="text" name="acc_nu"/><br/>
        ATM_PIN:<input type="password" name="atm"/><br/>
        MOBILE NO:<input type="text" name="dth"/><br/>
        AMOUNT:<input type="text" name="Amount"/><br/>
        <input type="submit" value="Submit"/>
</body>
</html>