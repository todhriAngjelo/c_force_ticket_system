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
  
  getLog(): void {
    console.log("Hello");
    this.apiService.getLogin()
        .subscribe(
            resultArray => this._usersArray = resultArray,
            error => console.log("Error :: " + error)
        )
  }

}
