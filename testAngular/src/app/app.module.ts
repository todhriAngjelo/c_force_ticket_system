import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import { HttpModule, JsonpModule } from '@angular/http';
import {AppComponent} from "./app.component";
import { HttpClientModule } from "@angular/common/http";
import { HomeComponent } from './components/home/home.component';
import { TicketsComponent } from './components/tickets/tickets.component';
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

@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        TicketsComponent,
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
        UpcomingComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        HttpClientModule,
        JsonpModule,
        AppRoutingModule
    ],
    providers: [MoviesService],
    bootstrap: [
        AppComponent
    ]
})
export class AppModule {
}