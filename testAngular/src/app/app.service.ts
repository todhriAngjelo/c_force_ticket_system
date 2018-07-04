import {Injectable} from "@angular/core";
 import { Observable, of } from "rxjs"; 
 import "rxjs";
 import {Tickets} from "./posts";
 import { map, tap, catchError } from 'rxjs/operators'; 
 import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MessageService } from "./message.service";

 const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

 @Injectable()
 export class AppService {
     [x: string]: any;
 
     private _getURL = "http://localhost:8080/home/ticket/allticket";
     private _postUpdateURL = "http://localhost:8080/home/ticket/allticket/reserveTicket";
 
     constructor(    private http: HttpClient,
        private messageService: MessageService) {
     }
 
     getPosts(): Observable<Tickets[]> {
        return this.http.get<Tickets[]>(this._getURL)
        .pipe(
          tap(ticket => this.log(`fetched ticket`)),
          catchError(this.handleError('getPosts', []))
        );
     }

     load() {
      location.reload()
      }
  doPOST(ticket: Tickets | number): Observable<Tickets>{
    const id = typeof ticket === 'number' ? ticket : ticket.t_id;    
    const url = `${this._postUpdateURL}/${id}`; 
    return this.http
        .post<Tickets>(url, httpOptions)
                   .pipe(
            tap(_ => this.log(`updated ticket ticket_id=${id}`)),
            catchError(this.handleError<Tickets>('doPOST'))
          );
                 

       // return this.http.put('http://localhost:8080/home/ticket/allticket',ticketId ); 
             
       

}
       
  /** Log a HeroService message with the MessageService */
   /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
 
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
 
      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);
 
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
 
  /** Log a HeroService message with the MessageService */
  private log(message: string) {
    this.messageService.add('HeroService: ' + message);
  }

}
 