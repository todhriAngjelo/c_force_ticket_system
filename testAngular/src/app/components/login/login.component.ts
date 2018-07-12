import { Component, OnInit } from '@angular/core';
import { AppService } from '../../services/app.service';
import { Users } from '../models/users';
import { AuthService } from '../../services/auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private apiService: AppService,public authService: AuthService, public router: Router) {
  }
  _usersArray: Users[];

  ngOnInit() {
  }
  
  getLog(form: Users): void {
    console.log('you submitted value:', form);  
    console.log("GETLOG ON LOGIN.COMPONENT.TS");
    this.apiService.loginService(form);
    // console.log(uname);
    // this.apiService.loginService(uname,pass);
        
  }
  
<<<<<<< HEAD
}
=======
  logout() {
    this.authService.logout();
  }


  //_____________________________________

}
>>>>>>> d69239190a64ce593b9e73a72fa61a922dad6340
