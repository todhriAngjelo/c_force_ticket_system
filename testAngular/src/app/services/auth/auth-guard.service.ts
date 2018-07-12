import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { AuthService } from './auth.service';
import { AppService } from '../app.service';

@Injectable()
export class AuthGuardService implements CanActivate {
  constructor(public auth: AuthService, public router: Router, public m: AppService) {}
    canActivate() {
      console.log('AuthGuard#canActivate called');
      console.log(this.auth.isLoggedIn);



      if(!this.auth.isLoggedIn){
      

        return false;
        
      }
      console.log("eddddddddddddddddwwwwwwwwwww",JSON.stringify(this.auth.isLoggedIn));
      localStorage.removeItem('key');
      localStorage.setItem('key', JSON.stringify(this.auth.isLoggedIn));
      console.log("APOTHIKEVW OTI EISAI LOGGED IN");

      // localStorage.removeItem('admin');
      // localStorage.setItem('admin', JSON.stringify(this.auth.isAdmin));
      // console.log("APOTHIKEVW OTI EISAI admin");

      return true;
    }
    ngOnInit() { // your code here
     
    }
  }