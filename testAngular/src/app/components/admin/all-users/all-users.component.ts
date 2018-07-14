import { Component, OnInit } from '@angular/core';
import { Users } from '../../models/users';
import { AppService } from '../../../services/app.service';

@Component({
  selector: 'app-all-users',
  templateUrl: './all-users.component.html',
  styleUrls: ['./all-users.component.css']
})
export class AllUsersComponent implements OnInit {

  _postsArray: Users[];

  constructor(private apiSerivce: AppService) {}

  getUsers(): void {
    console.log("getUsers")
    this.apiSerivce.getAllUsers()
        .subscribe(
            resultArray => this._postsArray = resultArray,
            error => console.log("Error :: " + error)
        )
}
  ngOnInit() {
    this.getUsers();
  }

  resetPassword(user: Users): void {
    console.log("doPost on ticket.component.ts", user);

    this.apiSerivce.resetPass(user).subscribe(response => {
        this._postsArray = response;
      });
};

}
