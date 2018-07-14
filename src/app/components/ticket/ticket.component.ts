import { Component, OnInit } from '@angular/core';
import { Tickets } from '../../posts';
import { AppService } from '../../services/app.service';
import { Response } from '@angular/http';

@Component({
    selector: 'app-tickets',
    templateUrl: './ticket.component.html',
    styleUrls: ['./ticket.component.css']
})
export class TicketComponent {
    array: Array<any>;

    _postsArray: Tickets[];

    constructor(private apiSerivce: AppService) { }



    getPosts(): void {
        this.apiSerivce.getPosts()
            .subscribe(
                resultArray => this._postsArray = resultArray,
                error => console.log("Error :: " + error)
            )
    }


    ngOnInit(): void {

        this.getPosts();
    }


    doPOST(ticket: Tickets): void {
        console.log("doPost on ticket.component.ts", ticket);
        localStorage.removeItem('Array');
        localStorage.setItem('Array', JSON.stringify(this.array));
        this.apiSerivce.doPOST(ticket).subscribe(response => {
            this._postsArray = response;
            console.log(this.array);
        });
    };



}