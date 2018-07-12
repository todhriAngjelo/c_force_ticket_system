import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './components/register/register.component';
import { MovieComponent } from './components/movie/movie/movie.component';
import { SerieComponent } from './components/serie/serie/serie.component';
import { GenresComponent } from './components/genres/genres/genres.component';
import { ActorComponent } from './components/actor/actor/actor.component';
import { UpcomingComponent } from './components/upcoming/upcoming/upcoming.component';
import { PopularSeriesComponent } from './components/popular-series/popular-series/popular-series.component';
import { MoviesComponent } from './components/movies/movies/movies.component';
import { TicketComponent } from './components/ticket/ticket.component';
import { LoginComponent } from './components/login/login.component';
import { AuthGuardService} from './services/auth/auth-guard.service';
import { AuthService } from './services/auth/auth.service';


const routes: Routes = [
  {path: '', component: MoviesComponent},
  { path: 'tickets', component: TicketComponent,    canActivate: [AuthGuardService]  },
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent },
  {path: 'movie/:id', component: MovieComponent},
  {path: 'tv/:id', component: SerieComponent},
  {path: 'actor/:id', component: ActorComponent},
  {path: 'genres/:id/:name', component: GenresComponent},
  {path: 'upcoming', component: UpcomingComponent},
  {path: 'popular/series', component: PopularSeriesComponent}



];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ],
  providers: [
    AuthGuardService,
    AuthService
  ],
  declarations: []
})


export class AppRoutingModule { }
