import {Injectable} from "@angular/core";
import { Observable, of } from "rxjs"; 
import "rxjs";
import {Tickets} from "./../posts";
import { tap, catchError } from 'rxjs/operators'; 
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MessageService } from "./../message.service";
import { Users } from "./../components/models/users";
import { Router } from "@angular/router";
import { AuthGuardService } from "./auth/auth-guard.service";
import { AuthService } from "./auth/auth.service";

  
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  
};
 @Injectable()
 export class AppService {
     [x: string]: any;
 
     private _getURL = "http://localhost:8080/home/ticket/ticketRest/getAllAvailableTickets";
     private _postUpdateURL = "http://localhost:8080/home/ticket/ticketRest/reserveTicket";
     private _loginURL = "http://localhost:8080/home/ticket/userRest/login";
     private _registerURL = "http://localhost:8080/home/ticket/userRest/register";
     
 
     constructor( private http: HttpClient,
                  private messageService: MessageService,
                  private router:Router,
                  public auth1: AuthService) {}
 
     getPosts(): Observable<Tickets[]> {

        return this.http.get<Tickets[]>(this._getURL)
        .pipe(
          tap(ticket => this.log(`fetched ticket`)),
          catchError(this.handleError('getPosts', []))
        );
     }

     load() {
       console.log("LOADDDDDDDDDDDD");
      location.reload();
      }
      

      

  doPOST(ticket: Tickets | number): void{
    const id = typeof ticket === 'number' ? ticket : ticket.t_id;    
    const url = `${this._postUpdateURL}/${id}`; 
    console.log("POOOOOOOOOOOOOOOOOST");
    console.log(url);
   
    var m= this.http
        .post<Tickets>(url, httpOptions)
        .subscribe(_=> this.load());
    console.log(m);
}

//LOGIIIIIIN_______________________________________________________

loginService(f: Users | string): Observable<Number>{
  const uname = typeof f==='string' ? f : f.u_Name;
  const pass = typeof f==='string' ? f : f.u_Pw;
  console.log(uname);
  console.log(pass);
  const url = `${this._loginURL}?u_name=${uname}&u_pw=${pass}`; 
  console.log("LOGINSERVICEEEEEEEEEEEEEEEEE")
  console.log(url);
var m2;
  var m=this.http
  .get<Boolean>(url, httpOptions)
  .subscribe( value =>
      {
        if(value===true){
          console.log("m einai true");
          this.auth1.login();
          this.router.navigate(['tickets']);
        }
        else{
          console.log("m einai 0");

        }
      
      }  
    );
m2=m;
  return;
}
//___________________________________________________________________


//______________________________________REGISTEEEEEEEEEEEEEEEEEEEEEEEEEERRRRRRR___________________________________________________________________

registerService(f: Users | string) {
  const uname = typeof f==='string' ? f : f.u_Name;
  const fname = typeof f==='string' ? f: f.u_Fname;
  const pass = typeof f==='string' ? f : f.u_Pw;
  console.log(uname);
  console.log(fname);
  console.log(pass);
    const body = '{ "u_name": "' + uname + '", "u_fname": "' + fname + '", "u_pw": "' + pass + '" }';
    const body2 = JSON.stringify({u_name: uname, u_fname: fname, u_pw: pass});
        console.log(body2);
 // var test =this.http.post(this._registerURL, body, httpOptions);
 
    return this.http.post(this._registerURL, body, httpOptions);
  }



//______________________________________eeeeeeeeeeeND REGISTEEEEEEEEEEEEEEEEEEEEEEEEEERRRRRRR___________________________________________________________________
       
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
 