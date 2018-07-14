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
     private _getUserInfosURL = "http://localhost:8080/home/ticket/userRest/getUserName";
     private _getTicketByUserURL = "http://localhost:8080/home/ticket/userRest/getReservationsOfUsers";
     private _cancelTicketURL = "http://localhost:8080/home/ticket/ticketRest/cancelReservation";
     private _getAllUsersURL = "http://localhost:8080/home/ticket/userRest/getAllUsers";
     private _getAllTicketsURL = "http://localhost:8080/home/ticket/ticketRest/getAllReservedTickets";
     private _resetPassURL = "http://localhost:8080/home/ticket/userRest/resetPassword";

     public userID;
 
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
      

      

  doPOST(ticket: Tickets | number): any{
    const id = typeof ticket === 'number' ? ticket : ticket.t_id;    
    const url = `${this._postUpdateURL}/${id}/${this.userID}`; 
    console.log("POOOOOOOOOOOOOOOOOST");
    console.log(url);
   
    return this.http
        .post<Tickets>(url, httpOptions)
        
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
  .post<Number>(url, httpOptions)
  .subscribe( value =>
      {
        if(value===0){
          console.log("m einai 0");

        }
        else{
          this.userID=value;
            console.log(this.userID);

      localStorage.removeItem('userIDDD');
      localStorage.setItem('userIDDD', JSON.stringify(this.userID));
      console.log("APOTHIKEVW To USERID sou sto loginService() tou app.service.ts");
          
      
          if(this.userID===1){
            this.auth1.loginAdmin();
            this.router.navigate(['admin']);
          }else{
          this.auth1.login();
          this.router.navigate(['tickets']);
          }
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
 
    return this.http.post(this._registerURL, body, httpOptions)              
    .subscribe( this.router.navigate(['login']));

    
  }



//______________________________________eeeeeeeeeeeND REGISTEEEEEEEEEEEEEEEEEEEEEEEEEERRRRRRR___________________________________________________________________

//______________________________________getReservedTickets___________________________________________________________________


getReservedTickets(): Observable<Tickets[]> {
  console.log("FERNW PISW TO userIDDD");

  this.userID = JSON.parse(localStorage.getItem('userIDDD'));
   localStorage.removeItem('userIDDD'); // to clear it again.
   console.log(this.userID);

   console.log("FERNW PISW TO admin 2222222222");



  console.log(this.userID);
  localStorage.removeItem('userIDDD');
    localStorage.setItem('userIDDD', JSON.stringify(this.userID));
    console.log("APOTHIKEVW To USERID sou sto getReservedTickets() tou app.service.ts");

  const nurl = `${this._getTicketByUserURL}/${this.userID}`; 
  console.log(nurl);
  return this.http.get<Tickets[]>(nurl)
  .pipe(
    tap(ticket => this.log(`fetched ticket`)),
    catchError(this.handleError('getReservedTickets', []))
  );
}
//______________________________________getReservedTickets___________________________________________________________________
    

//______________________________________getUserInfos___________________________________getUserInfos_______________________getUserInfos_________

  getUserDetails(): Observable<Users[]> {
    
    console.log("FERNW PISW TO userIDDD");

    this.userID = JSON.parse(localStorage.getItem('userIDDD'));
     localStorage.removeItem('userIDDD'); // to clear it again.
     console.log(this.userID);

     console.log("FERNW PISW TO admin 2222222222");



    console.log(this.userID);
    localStorage.removeItem('userIDDD');
      localStorage.setItem('userIDDD', JSON.stringify(this.userID));
      console.log("APOTHIKEVW To USERID sou sto getUserDetails() tou app.service.ts");
    const userurl = `${this._getUserInfosURL}/${this.userID}`; 
    console.log(userurl)

  return this.http.get<Users[]>(userurl)
  .pipe(
    tap(ticket => this.log(`fetched ticket`)),
    catchError(this.handleError('getUserDetails', []))
  );
}


//______________________________________getUserInfos__________________________________getUserInfos_________________________getUserInfos________

//______________________________________CancelTickeeeeeeet__________________________________CancelTickeeeeeeet_________________________CancelTickeeeeeeet________


        cancelTicket(ticket: Tickets | number): void{
          const id = typeof ticket === 'number' ? ticket : ticket.t_id;    
          const url = `${this._cancelTicketURL}/${id}`; 
          console.log("cancelTicket in app.service.ts");
          console.log(url);
        
          var m= this.http
              .post<Tickets>(url, httpOptions)
              .subscribe(_=> this.load());
          console.log(m);
        }

//______________________________________CancelTickeeeeeeet__________________________________CancelTickeeeeeeet_________________________CancelTickeeeeeeet________



//______________________________________getAllUsers__________________________getAllUsers_____________________getAllUsers_______

getAllUsers(): Observable<Users[]> {
  
  return this.http.get<Users[]>(this._getAllUsersURL)
  .pipe(
    tap(user => this.log(`fetched ticket`)),
    catchError(this.handleError('getAllUsers', []))
  );
}
//______________________________________getAllUsers__________________________getAllUsers_____________________getAllUsers_______

//____________________________________getAllTickets_____________________getAllTickets
getAllTickets(): Observable<Tickets[]> {
  
  return this.http.get<Tickets[]>(this._getAllTicketsURL)
  .pipe(
    tap(ticket => this.log(`fetched ticket`)),
    catchError(this.handleError('getAllTickets', []))
  );
}

//______________________________________getAllTickets___________________getAllTickets


//_____________________________________resetPass___________________resetPass

resetPass(user: Users | number): any{
  const id = typeof user === 'number' ? user : user.u_Id;    
  const url = `${this._resetPassURL}/${id}`; 
  console.log("resetPass in app.service.ts");
  console.log(url);
 
  return this.http
      .post<Users>(url, httpOptions)
      
}


//_____________________________________resetPass___________________resetPass



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
 