import { Component, OnInit } from '@angular/core';
import { Tickets } from '../../../posts';
import { AppService } from '../../../services/app.service';

@Component({
  selector: 'app-all-tickets',
  templateUrl: './all-tickets.component.html',
  styleUrls: ['./all-tickets.component.css']
})
export class AllTicketsComponent implements OnInit {

  _postsArray: Tickets[];
 
  constructor(private apiService: AppService) {}
  
  

  getAllTickets(): void {
      this.apiService.getAllTickets()
          .subscribe(
              resultArray => this._postsArray = resultArray,
              error => console.log("Error :: " + error)
          )
  }
 

  ngOnInit(): void {
      
      this.getAllTickets();
  }
  cancelBooking(ticket: Tickets): void {
    console.log("doPost on ticket.component.ts", ticket);

   this.apiService.cancelTicket(ticket) ;     
  };
}
