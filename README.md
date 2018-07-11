# OMADA NUMERO 1 στο Project Και στην ΖΩΗ

###( the logging started on 22of June )

- Date:22 June 2018, SometimeDuringTheDay
###### *Progress Title : fixed showAllTickets method in student servlet*
###### Where can this be found : "ticketMonster\src\main\java\com\codinghive\ticketMonster\jee\injection01\TicketServlet.java" 
###### Short Description following progress : leaved it blank because after exiting the if sentence getAllTickets will be invoked anyways and ticketDao will get the required data to serve to .jsp file

- Date:23 June 2018, SometimeDuringTheEvening
###### *Progress Title : added addTickToArrayList() method*
###### Where can this be found : "ticketMonster\src\main\java\com\codinghive\ticketMonster\jee\dao\TicketDao.java" 
###### Short Description following progress : probably it will be usefull for ticket info manipulation

- Date:23 June 2018, 11PM
###### *Progress Title : added getJsonsFromDB() method*
###### Where can this be found : "\ticketMonster\src\main\java\com\codinghive\ticketMonster\jee\dao\TicketDao.java"
###### Short Description following progress : added method that takesAllTickets() from db and converts them to a jsonString


- Date:27 June 2018
###### *Progress Title : organised packages*

- Date:27 June 2018
###### *Progress Title : added reserveTicket() Rest Endpoint for reserving a ticket*
###### Where can this be found : "\ticketMonster\src\main\java\com\codinghive\ticketMonster\jee\dao\TicketDao.java"
###### Short Description following progress : added method on TicketDao that creates a REST endpoint for a PUT HTTP Method that allows us to reserve a ticket by changin the ticket flag (t_booked)

- Date:27 June 2018, 11PM
###### *Progress Title : added Collum Ticket_Booked into database with sql import*

### Date:2 July 2018
###### *Progress Title : added addTicket() Rest Endpoint for adding a ticket to the database*
###### Where can this be found : "\ticketMonster\src\main\java\com\codinghive\ticketMonster\jee\dao\TicketDao.java"
###### Short Description following progress : Rest Endpoint Consumes JSON from Post request and creates a ticket to the database


a