import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { tap, delay } from 'rxjs/operators';

@Injectable()
export class AuthService {
  isLoggedIn = false;
  isAdmin=false;
  // store the URL so we can redirect after logging in
  redirectUrl: string;

  login(): void {
    console.log("login in auth.service.ts");
    this.isLoggedIn = true;
    this.isAdmin=false;

  
  }

  loginAdmin(): void {
    console.log("loginAdmin in auth.service.ts");
    this.isLoggedIn = true;
    this.isAdmin=true;
  
  }
  
  logout(): void {
    console.log("logout in auth.service.ts");
    this.isLoggedIn = false;
    this.isAdmin=false;

    localStorage.removeItem('key');
    localStorage.setItem('key', JSON.stringify(this.isLoggedIn));
    console.log("APOTHIKEVW OTI DEN EISAI LOGGED IN");
    
    localStorage.removeItem('admin');
    localStorage.setItem('admin', JSON.stringify(this.isAdmin));
    console.log("APOTHIKEVW OTI DEN EISAI LOGGED admin");

    

    
  }
}