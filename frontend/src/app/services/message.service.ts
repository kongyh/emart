import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Subject } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class MessageService {
  private subject = new Subject<any>();

  sendMessage(type: any) {
    console.log('TAG' + '---------->>>' + type);
    this.subject.next({type: type});
   }

   clearMessage() {
    this.subject.next();
   }

   getMessage(): Observable<any> {
    return this.subject.asObservable();
   }
  
}
