import { Component, OnInit } from '@angular/core';
import { Item } from "../../models/item";
import { LocalStorage } from "../../pages/localstorage";
import { MessageService } from "../../services/message.service";
import { ItemAlertComponent } from "../../component/itemAlert/itemAlert.component";
import { ITS_JUST_ANGULAR } from '@angular/core/src/r3_symbols';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  items: Item[];
  total: number=0;
  disTotal: number=0;
  itemsCount: number;
  constructor(private ls: LocalStorage,
    private messageService: MessageService
  ) { }


  ngOnInit() {
    if(JSON.stringify(this.ls.getObject("cart"))!='{}'){
      console.log("navbar,cart is not empty:"+this.ls.getObject("cart").length);
      this.items = this.ls.getObject("cart");
      this.total = this.calTotal(this.items);
      this.disTotal = this.total;
      this.itemsCount = this.items.length;
    }
  }

  deleteItem(index: number){
    this.items.splice(index,1);
    this.ls.setObject("cart",this.items);
    this.messageService.sendMessage("MessageService in cart: delete in cart");
    this.itemsCount = this.items.length;
  }

  onNotify() {
    window.alert('You will be notified when the product goes on sale');
  }

  calTotal(param: any[]){
    let result=0;
    param.forEach(value =>{
      result+=value.i_price;
    })
    return result;
  }

  discount(){
    this.disTotal = this.total*0.85;
  }

  showTips(){
    console.log("show tips in");
    window.alert('This function is on ToDo List');
  }

}
