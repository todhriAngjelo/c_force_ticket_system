import { Component, OnInit } from '@angular/core';
import { Tickets } from '../../posts';
import { AppService } from '../../app.service';

@Component({
  selector: 'app-tickets',
  templateUrl: './tickets.component.html',
  styleUrls: ['./tickets.component.scss']
})
export class TicketsComponent implements OnInit {

  _postsArray: Tickets[];
 
  constructor(private apiSerivce: AppService) {
  }
  
  

  getPosts(): void {
      this.apiSerivce.getPosts()
          .subscribe(
              resultArray => this._postsArray = resultArray,
              error => console.log("Error :: " + error)
          )
  }
 
 hello(){
     console.log("Helloooooo");
 }

  ngOnInit(): void {
      this.getPosts();
  }
  
  
  doPOST(ticket: Tickets): void {
     console.log("PUUUUUUT",ticket);
    this.apiSerivce.doPOST(ticket)      
    .subscribe()
    };

}