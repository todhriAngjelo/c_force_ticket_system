import {Component, OnInit} from "@angular/core";
 import {AppService} from "./app.service";
 import {Tickets} from "./posts";
import { MoviesService } from "./services/movies.service";
 
 @Component({
     selector: 'app-root',
     templateUrl: './app.component.html',
     styleUrls: ['./app.component.css'],
     providers: [AppService]
 })
 export class AppComponent implements OnInit {
 
    genres: Array<Object>;

    constructor(private _moviesServices: MoviesService) {
      this._moviesServices.getGenres().subscribe(res => {
        this.genres = res.genres.slice(0, 20);
      });
    }
 
     
     ngOnInit(): void {
     }
     
    
   
   
 }