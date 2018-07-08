import { Component, OnInit } from '@angular/core';
import { AppService } from '../../app.service';
import { Users } from '../models/users';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private apiService: AppService) {}
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

}
