import { Injectable } from '@angular/core';
import {Message} from 'primeng/components/common/api';
import {MessageService} from 'primeng/components/common/messageservice';

@Injectable({
  providedIn: 'root'
})
export class AlertService {

  constructor(private messageService: MessageService) {}

  addSingle() {
      this.messageService.add({severity:'success', summary:'Service Message', detail:'Via MessageService'});
  }

  addMultiple() {
      this.messageService.addAll([{severity:'success', summary:'Service Message', detail:'Via MessageService'},
                      {severity:'info', summary:'Info Message', detail:'Via MessageService'}]);
  }
  
  clear() {
      this.messageService.clear();
  }
}

