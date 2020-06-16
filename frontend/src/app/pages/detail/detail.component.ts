import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Item } from "../../models/item";
import { Cart } from "../../models/cart";
import { ItemService } from "../../services/item.service";
import { MessageService } from "../../services/message.service";
import { Subscription } from 'rxjs';
import { LocalStorage } from "../../pages/localstorage";
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  item: any ;
  images = [944, 1011, 984].map((n) => `https://picsum.photos/id/${n}/900/500`);
  // private subscription: Subscription

  constructor(
    private itemService: ItemService, 
    private cartService: CartService,
    private route: ActivatedRoute,
    private messageService: MessageService,
    private ls: LocalStorage
    
    ) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      console.log("detial page-ngoninit-id:"+params.get('itemId'));//.get('id')
      this.itemService.get_item(parseInt(params.get('itemId').replace(/[^0-9]/ig,""))).subscribe(data =>{
        this.item = data;
      })
    });    
  }

  ngAfterViewInit(): void {
    // this.subscription = this.messageService.getMessage().subscribe(msg => {
    //   console.log("MessageService in detail:get message"+JSON.stringify(msg));
    // })
   }
   
   ngOnDestroy(): void {
    // this.subscription.unsubscribe();
   }
   
   send(item:Item):void {
    this.messageService.sendMessage("MessageService in detail:add into cart");
    delete item.i_id;
    console.log("add item into cart:"+JSON.stringify(item));
    item.username = sessionStorage.getItem("username");
    this.cartService.addInCart(item).subscribe(data=>{
      console.log("detail page-response of add into cart:"+JSON.stringify(data));
      if(data!=null){
        window.alert("add into cart successfully!")
      }
      // if(JSON.stringify(this.ls.getObject("cart"))!='{}'){
      //   console.log("cart is not empty");
      //   cartArr = this.ls.getObject("cart");      
      // }
      // cartArr.push(this.item);
      // console.log("items count in cart:"+cartArr.length);
      // this.ls.setObject("cart",cartArr);
      // console.log("items in cart:"+JSON.stringify(cartArr));
    })
    
   }

}
