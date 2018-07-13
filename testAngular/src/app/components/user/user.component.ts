import { Component, OnInit } from '@angular/core';
import { Users } from '../models/users';
import { AppService } from '../../services/app.service';
import { Tickets } from '../../posts';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  _userArray: Users[];
  _ticketUserArray: Tickets[];

  constructor(private apiService: AppService) { }
  
  getUser(): void {
    this.apiService.getUserDetails() 
        .subscribe(
            resultArray => this._userArray = resultArray,
            error => console.log("Error :: " + error)
        )
}

getTicketOfUser(): void {
  this.apiService.getReservedTickets() 
      .subscribe(
          resultArray => this._ticketUserArray = resultArray,
          error => console.log("Error :: " + error)
      )
}

  ngOnInit() {
    this.getUser();
    this.getTicketOfUser();
  }

  cancelBooking(ticket: Tickets): void {
    console.log("doPost on ticket.component.ts", ticket);

   this.apiService.cancelTicket(ticket) ;     
  };

}
