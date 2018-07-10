import { Component } from '@angular/core';
import {MoviesService} from '../app/services/movies.service';
import { AuthService } from './services/auth/auth.service';
import { Router } from '@angular/router';

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
              public authService: AuthService) {
    this._moviesServices.getGenres().subscribe(res => {
      this.genres = res.genres.slice(0, 20);
    });
  }
  logout() {
    this.authService.logout();
    this.router.navigate(['']);
  }

}
