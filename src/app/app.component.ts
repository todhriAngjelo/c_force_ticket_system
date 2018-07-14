import { Component } from '@angular/core';
import {MoviesService} from '../app/services/movies.service';
import { AuthService } from './services/auth/auth.service';
import { Router } from '@angular/router';
import { AuthGuardService } from './services/auth/auth-guard.service';
import { AppService } from './services/app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [MoviesService]
})
export class AppComponent {
  genres: Array<Object>;

  constructor(private _moviesServices: MoviesService,
              private router:Router,
              public authService: AuthService,
              public isok: AuthGuardService,
              public userid: AppService) {
    this._moviesServices.getGenres().subscribe(res => {
      this.genres = res.genres.slice(0, 20);
    });
  }

  ngOnInit(): void {
    console.log("FERNW PISW TO ISLOGGED IN");
    console.log("edwwwwwwwwwreeeeeeeeeeeeeeeeeeeeeeeeeeee", JSON.parse(localStorage.getItem('key')) );

    this.authService.isLoggedIn = JSON.parse(localStorage.getItem('key'));
    localStorage.removeItem('key'); // to clear it again.
    console.log("FERNW PISW TO ISLOGGED IN2222222222");

    console.log("FERNW PISW TO admin");

     this.authService.isAdmin = JSON.parse(localStorage.getItem('admin'));
     localStorage.removeItem('admin'); // to clear it again.
     console.log("FERNW PISW TO admin 2222222222");

     console.log("FERNW PISW TO userIDDD");

     this.userid.userID = JSON.parse(localStorage.getItem('userIDDD'));
     console.log(this.userid.userID);
     
     console.log("FERNW PISW TO userIDDD 2222222222");

  }
  logout() {
    this.userid.userID=0;
    localStorage.removeItem('userIDDD');
    localStorage.setItem('userIDDD', JSON.stringify(this.userid.userID));
    console.log("APOTHIKEVW OTI DEN EISAI kanenas USERID");

    this.authService.logout();
    this.router.navigate(['']);
  }

}
