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
import { UserComponent } from './components/user/user.component';
import { AboutComponent } from './components/about/about.component';
import { AdminComponent } from './components/admin/admin.component';
import { AuthGuard2Service } from './services/auth-guard2.service';
import { AllUsersComponent } from './components/admin/all-users/all-users.component';
import { AllTicketsComponent } from './components/admin/all-tickets/all-tickets.component';


const routes: Routes = [
  {path: '', component: MoviesComponent},
  { path: 'tickets', component: TicketComponent,    canActivate: [AuthGuardService]  },
  { path: 'login', component: LoginComponent},
  { path: 'about', component: AboutComponent},
  { path: 'user', component: UserComponent, canActivate: [AuthGuardService] },
  { path: 'admin', component: AdminComponent, canActivate: [AuthGuard2Service] },
  { path: 'admin/allusers', component: AllUsersComponent, canActivate: [AuthGuard2Service] },
  { path: 'admin/alltickets', component: AllTicketsComponent, canActivate: [AuthGuard2Service] },
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
