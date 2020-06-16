import { Component, OnInit } from '@angular/core';
import { MessageService } from "../../services/message.service";
import { Subscription } from 'rxjs'
import { LocalStorage } from "../../pages/localstorage";
import { Router } from '@angular/router';
import { CartService } from 'src/app/services/cart.service';
import { Cart } from 'src/app/models/cart';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  public subscription: Subscription;
  //if login: logout button show,cart button show, login button hide
  //if logout: login button show,cart button hide, logout button hide
  //for seller cart button always hide
  public ifLoginHidden: boolean=false;
  public ifCartHidden: boolean=true;
  private username: string;

  constructor(private messageService: MessageService, 
              private cartService: CartService,
              private ls: LocalStorage,
              private router: Router) { }
  count_in_cart: number=0;

  ngOnInit() {
    this.username = sessionStorage.getItem("username");
    // if(JSON.stringify(this.ls.getObject("cart"))!='{}'){
      console.log("navbar,cart is not empty:"+this.ls.getObject("cart").length);
      this.cartService.getCart(this.username).subscribe(data =>{
        console.log("navbar -- response of get cart:"+JSON.stringify(data));
        let cart_list: any = data;
        if(data!=null){
          this.count_in_cart = cart_list.length;
        }else{
          this.count_in_cart = 0;
        }

      });
      
    //}
  }

  ngAfterViewInit(): void {
    //consum message from login page, cart page and detail page
    //the message impact on buttons hidden/show in navbar
    this.subscription = this.messageService.getMessage().subscribe(msg => {
      console.log("MessageService in Navbar:get message"+JSON.stringify(msg));   
      console.log("user name is:"+this.username);
      if(JSON.stringify(msg).indexOf("add")>-1){
        // this.count_in_cart +=1;
        this.cartService.getCart(this.username).subscribe(data =>{
          let cart_list: any = data;
          this.count_in_cart = cart_list.length;
          console.log("navbar -- response of get cart:"+JSON.stringify(data));
        });
       
      }else if(JSON.stringify(msg).indexOf("delete")>-1){
        // this.count_in_cart -=1;
        this.cartService.getCart(this.username).subscribe(data =>{
          let cart_list: any = data;
          this.count_in_cart = cart_list.length;
          console.log("navbar -- response of get cart:"+JSON.stringify(data));
        });
      }else if(JSON.stringify(msg).indexOf("authenticated")>-1){      
        this.ifCartHidden=false;
        this.ifLoginHidden=true;
      }

      if(JSON.stringify(msg).indexOf("seller")>-1){
        this.ifCartHidden=true;
      }
        
    })
   }
   
   ngOnDestroy(): void {
    this.subscription.unsubscribe();
   }
   
   send():void {
    this.messageService.sendMessage("MessageService:add into cart");
   }

   logout(){
     console.log("logout");
     sessionStorage.clear();
     this.router.navigate(["/login"]);
     this.ifLoginHidden=false;
     this.ifCartHidden=true;
   }
}
