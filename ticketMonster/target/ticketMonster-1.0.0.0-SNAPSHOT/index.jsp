<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tickets Information</title>
    </head>
    <body>
       
        
        
        <!--newwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww-->
        
<!--        <h1>User Information</h1>
        <form action="./UsersServlet" method="POST">
            <table>
                <tr>
                    <td>User ID:</td>
                    <td><input type="text" name="userId" value="${users.userId}" /></td>
                    
                </tr>
                
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                    </td>                
                </tr>            
            </table>
        </form>        
        <br>
        <table border="1">
            <th>ID</th>
             <c:forEach items="${allUsers}" var="us">
                <tr>
                    <td>${us.userId}</td>
                   
                </tr>
            </c:forEach>
                
                
        </table> 
        -->
    <h1>Ticket Information</h1>
        <form action="./TicketServlet" method="POST">
            <table>
                <tr>
                    <td>Ticket ID:</td>
                    <td><input type="text" name="ticketId" value="${ticket.ticketId}" /></td>
                    
                </tr>
                <tr>
                    <td>Ticket Title</td>
                    <td><input type="text" name="t_title" value="${ticket.t_title}" /></td>
                </tr>
                <tr>
                    <td>Ticket Price</td>
                    <td><input type="text" name="t_price" value="${ticket.t_price}" /></td>
                </tr>
                <tr>
                    <td>Ticket belong to id</td>
                    <td><input type="text" name="user_Id" value="${ticket.user_Id}" /></td>
                </tr>
               
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                       
                    </td>                
                </tr>            
            </table>
        </form>        
        <br>
        <table border="1">
            <th>Ticket ID:</th>
            <th>Ticket Title</th>
            <th>Ticket Price</th>
            <th>User ID</th>
            
            <c:forEach items="${allTicket}" var="tick">
                <tr>
                    <td>${tick.ticketId}</td>
                    <td>${tick.t_title}</td>
                    <td>${tick.t_price}</td>
                    <td>${tick.user_Id}</td>
                </tr>
            </c:forEach>
        </table>  
        
        
        
        
        
    </body>
</html>
