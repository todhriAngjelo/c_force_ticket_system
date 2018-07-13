import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import { HttpModule, JsonpModule, RequestOptions } from '@angular/http';
import {AppComponent} from "./app.component";
import { HttpClientModule } from "@angular/common/http";
import { HomeComponent } from './components/home/home.component';
import { HomeTicketShowComponent } from './components/home-ticket-show/home-ticket-show.component';
import { LoginComponent } from './components/login/login.component';
import { AppRoutingModule } from "src/app/app-routing.module";
import { RegisterComponent } from './components/register/register.component';
import { ActorComponent } from './components/actor/actor/actor.component';
import { GenresComponent } from './components/genres/genres/genres.component';
import { MovieComponent } from './components/movie/movie/movie.component';
import { MovieCardComponent } from './components/movie-card/movie-card/movie-card.component';
import { MoviesComponent } from './components/movies/movies/movies.component';
import { PopularSeriesComponent } from './components/popular-series/popular-series/popular-series.component';
import { SerieComponent } from './components/serie/serie/serie.component';
import { UpcomingComponent } from './components/upcoming/upcoming/upcoming.component';
import { MoviesService } from "./services/movies.service";
import { TicketComponent } from './components/ticket/ticket.component';
import { AppService } from "./services/app.service";
import { AuthGuardService } from "./services/auth/auth-guard.service";
import { AuthService } from "./services/auth/auth.service";
import { UserComponent } from './components/user/user.component';
import { AboutComponent } from './components/about/about.component';
import { AdminComponent } from './components/admin/admin.component';

@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        HomeTicketShowComponent,
        LoginComponent,
        RegisterComponent,
        ActorComponent,
        GenresComponent,
        MovieComponent,
        MovieCardComponent,
        MoviesComponent,
        PopularSeriesComponent,
        SerieComponent,
        UpcomingComponent,
        TicketComponent,
        UserComponent,
        AboutComponent,
        AdminComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        HttpClientModule,
        JsonpModule,
        AppRoutingModule
    ],
    providers: [MoviesService, AppService, AuthService, AuthGuardService],
    bootstrap: [
        AppComponent
    ]
})
export class AppModule {
}