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
      return true;
    }
  }