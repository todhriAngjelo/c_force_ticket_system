import { Component } from '@angular/core';
import {MoviesService} from '../app/services/movies.service';
import { AuthService } from './services/auth/auth.service';
import { Router } from '@angular/router';
import { AuthGuardService } from './services/auth/auth-guard.service';

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
              public isok: AuthGuardService) {
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

  }
  logout() {
    this.authService.logout();
    this.router.navigate(['']);
  }

}
