<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>


 <body style="font-size:20px;">
        
        
        <h1 style="margin-left:25%; color:green;">User Information</h1>
        <div style="width:50%; margin-left:25%; padding-left:10%; border-top: 1px solid black;">
 
        <form action="RegisterServ" method="post">
            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre"/></td>
                    
                </tr>
                
                <tr>
                    <td>Apellido</td>
                    <td><input type="text" name="apellido"/></td>
                </tr>
                
                 <tr>
                    <td>Nacimiento</td>
                    <td><input type="date" name="nacimiento"/></td>
                </tr>
                    
                <tr>
                     <td>Sexo</td>
                    <td>
                        <select name="sexo">
                            <option value="M">Masculino</option>
                            <option value="F">Femenino</option>
                        </select>
                    </td> 
                    
                </tr>                    
  
            </table>
            
            <h2 style="color:green;">Login Information</h2>
            <hr>
            <table>
                <tr>
                    <td>Username</td>
                    <td><input placeholder="create user name" type="text" name="username"/></td>
                </tr>
                
                <tr>
                    <td>Password</td>
                    <td><input placeholder="enter password" type="password" name="password"/></td>
                </tr>
                
                
                <tr>
                    <td>Confirm Password</td>
                    <td><input placeholder="confirm password" type="password" id="confirmPass"/></td>
                </tr>
                
                
                <tr>
                    <td>User Role</td>
                    <td>
                      
                        <select name="user_type">
                            <option value="null">choose one...</option>
                            <option value="A">Administrator</option>
                            <option value="O">Operator</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><hr></td>
                </tr>
                
                <tr>
                    <td></td>
                    
                <br>
                    <td><input type="submit" value="Registrar" style="width: 100%;background-color: green; color:white;
                               height:4vh; border: none; border-radius:3px;"/></td>
                </tr>
                
                
            </table>
            
            
            
        </form>
        
        </div>
        
        <br>
        <hr>
        
        
        
    </body>









</html>