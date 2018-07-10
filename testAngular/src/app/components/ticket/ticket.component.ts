import { Component, OnInit } from '@angular/core';
import { Tickets } from '../../posts';
import { AppService } from '../../app.service';

@Component({
  selector: 'app-tickets',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.scss']
})
export class TicketComponent {

  _postsArray: Tickets[];
 
  //constructor(private apiSerivce: AppService) {}
  
  

  getPosts(): void {
      this.apiSerivce.getPosts()
          .subscribe(
              resultArray => this._postsArray = resultArray,
              error => console.log("Error :: " + error)
          )
  }
 

  ngOnInit(): void {
      this.getPosts();
  }
  
  
  doPOST(ticket: Tickets): void {
     console.log("PUUUUUUT",ticket);
    this.apiSerivce.doPOST(ticket) ;     };

    

}