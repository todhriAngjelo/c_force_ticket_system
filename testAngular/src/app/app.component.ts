import {Component, OnInit} from "@angular/core";
 import {AppService} from "./app.service";
 import {Tickets} from "./posts";
 
 @Component({
     selector: 'app-root',
     templateUrl: './app.component.html',
     styleUrls: ['./app.component.css'],
     providers: [AppService]
 })
 export class AppComponent implements OnInit {
 
     constructor() {
     }
 
     
     ngOnInit(): void {
     }
     
    
   
   
 }