import { Component, OnInit } from '@angular/core';
import { Tickets } from '../../posts';
import { AppService } from '../../services/app.service';
import { Response } from '@angular/http';
import {Message} from 'primeng/components/common/api';
import {MessageService} from 'primeng/components/common/messageservice'
@Component({
    selector: 'app-tickets',
    templateUrl: './ticket.component.html',
    styleUrls: ['./ticket.component.css'],
    providers: [MessageService]
})
export class TicketComponent {
    array: Array<any>;
    msgs: Message[] = [];
    _postsArray: Tickets[];

    constructor(private apiSerivce: AppService,
                private messageService: MessageService) { }



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
        this.show();
        this.apiSerivce.doPOST(ticket).subscribe(response => {
            this._postsArray = response;
            console.log(this.array);
        });
    };

    show() {
        this.msgs = [];
        this.msgs.push({severity:'success', summary:'Success Message', detail:'Order submitted'});    }

    hide() {
        this.msgs = [];
    }

    showSuccess() {
        this.msgs = [];
        this.msgs.push({severity:'success', summary:'Success Message', detail:'Order submitted'});
    }

    showInfo() {
        this.msgs = [];
        this.msgs.push({severity:'info', summary:'Info Message', detail:'PrimeNG rocks'});
    }

    showWarn() {
        this.msgs = [];
        this.msgs.push({severity:'warn', summary:'Warn Message', detail:'There are unsaved changes'});
    }

    showError() {
        this.msgs = [];
        this.msgs.push({severity:'error', summary:'Error Message', detail:'Validation failed'});
    }

    showMultiple() {
        this.msgs = [];
        this.msgs.push({severity:'info', summary:'Message 1', detail:'PrimeNG rocks'});
        this.msgs.push({severity:'info', summary:'Message 2', detail:'PrimeUI rocks'});
        this.msgs.push({severity:'info', summary:'Message 3', detail:'PrimeFaces rocks'});
    }
    
    showViaService() {
        this.messageService.add({severity:'success', summary:'Service Message', detail:'Via MessageService'});
    }

    clear() {
        this.msgs = [];
    }



}