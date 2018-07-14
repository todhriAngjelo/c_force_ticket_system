import { Injectable } from '@angular/core';
import { AuthService } from './auth/auth.service';
import { Router, CanActivate } from '@angular/router';
import { AppService } from './app.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard2Service implements CanActivate {

  constructor(public auth: AuthService, public router: Router, public m: AppService) {}

  canActivate() {
    console.log('2222222 AuthGuard#canActivate called AADDDDMIIIIIIIIIIN',this.auth.isAdmin);
    
    if(this.auth.isAdmin!=true){
      

      return false;
      
    }
    localStorage.removeItem('admin');
    localStorage.setItem('admin', JSON.stringify(this.auth.isAdmin));
    console.log("APOTHIKEVW OTI EISAI admin");
    return true;


  }


}
