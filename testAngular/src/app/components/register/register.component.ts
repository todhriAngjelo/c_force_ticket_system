import { Component, OnInit } from '@angular/core';
import { AppService } from '../../services/app.service';
import { Users } from '../models/users';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private apiService: AppService) {}

  ngOnInit() {
  }

  register(regform: Users): void {
    console.log('you submitted value:', regform);  
    console.log("GETLOG ON REGISTER.COMPONENT.TS");
    this.apiService.registerService(regform).subscribe(
      response => console.log(response),
      err => console.log(err)
    );
    // console.log(uname);
    // this.apiService.loginService(uname,pass);
        
  }
 

  
}
