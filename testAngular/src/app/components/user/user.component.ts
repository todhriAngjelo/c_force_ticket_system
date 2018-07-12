import { Component, OnInit } from '@angular/core';
import { Users } from '../models/users';
import { AppService } from '../../services/app.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private apiService: AppService) { }
  _userArray: Users[];

  ngOnInit() {
    
  }
  getUser(): void {
    this.apiService.getUserDetails() 
        .subscribe(
            resultArray => this._userArray = resultArray,
            error => console.log("Error :: " + error)
        )
}

}
