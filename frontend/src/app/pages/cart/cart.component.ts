import { Component, OnInit } from '@angular/core';
import { Item } from "../../models/item";
import { LocalStorage } from "../../pages/localstorage";
import { MessageService } from "../../services/message.service";
import { ItemAlertComponent } from "../../component/itemAlert/itemAlert.component";
import { ITS_JUST_ANGULAR } from '@angular/core/src/r3_symbols';
import { CartService } from 'src/app/services/cart.service';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  items: any;
  total: number=0;
  disTotal: number=0;
  itemsCount: number;
  username: string;
  constructor(private ls: LocalStorage,
    private messageService: MessageService,
    private cartService: CartService,
    private orderService: OrderService
  ) { }


  ngOnInit() {
    this.username = sessionStorage.getItem("username");  
    this.cartService.getCart(this.username).subscribe(data =>{
        console.log("navbar -- response of get cart:"+JSON.stringify(data));
        this.items  = data;
        this.total = this.calTotal(this.items) ;
        this.disTotal = this.total;
        if(data!=null){
          this.itemsCount = this.items.length;
        }else{
          this.itemsCount=0;
        }
        
      });
  }

  deleteItem(i_id: number){
    // this.items.splice(index,1);
    // this.ls.setObject("cart",this.items);
    let out_this = this;
    debugger
    this.cartService.deleteInCart(i_id).subscribe(data =>{
      out_this.messageService.sendMessage("MessageService in cart: delete in cart");
      out_this.ngOnInit();
    })
    
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

  submitOrder(){
    console.log("show tips in");
    debugger;
    this.orderService.submitOrder(this.items).subscribe(data=>{
      console.log("order service--reponse of submit orders:"+JSON.stringify(data));
      window.alert('You have submitted your order with unpaid status!');
    })
    
  }

}
