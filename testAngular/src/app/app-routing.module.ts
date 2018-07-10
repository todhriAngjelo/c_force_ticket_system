import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { TicketsComponent } from './components/tickets/tickets.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { MovieComponent } from './components/movie/movie/movie.component';
import { SerieComponent } from './components/serie/serie/serie.component';
import { GenresComponent } from './components/genres/genres/genres.component';
import { ActorComponent } from './components/actor/actor/actor.component';
import { UpcomingComponent } from './components/upcoming/upcoming/upcoming.component';
import { PopularSeriesComponent } from './components/popular-series/popular-series/popular-series.component';
import { MoviesComponent } from './components/movies/movies/movies.component';



const routes: Routes = [
  { path: 'tickets', component: TicketsComponent },
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent },
  {path: '', component: MoviesComponent},
  {path: 'movie/:id', component: MovieComponent},
  {path: 'tv/:id', component: SerieComponent},
  {path: 'actor/:id', component: ActorComponent},
  {path: 'genres/:id/:name', component: GenresComponent},
  {path: 'upcoming', component: UpcomingComponent},
  {path: 'popular/series', component: PopularSeriesComponent},



];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ],
  declarations: []
})


export class AppRoutingModule { }
