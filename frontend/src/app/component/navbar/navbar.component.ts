import { Component, OnInit } from '@angular/core';
import { MessageService } from "../../services/message.service";
import { Subscription } from 'rxjs'
import { LocalStorage } from "../../pages/localstorage";
import { Router } from '@angular/router';

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

  constructor(private messageService: MessageService, 
              private ls: LocalStorage,
              private router: Router) { }
  count_in_cart: number=0;

  ngOnInit() {
    if(JSON.stringify(this.ls.getObject("cart"))!='{}'){
      console.log("navbar,cart is not empty:"+this.ls.getObject("cart").length);
      this.count_in_cart = this.ls.getObject("cart").length;
    }
  }

  ngAfterViewInit(): void {
    //consum message from login page, cart page and detail page
    //the message impact on buttons hidden/show in navbar
    this.subscription = this.messageService.getMessage().subscribe(msg => {
      console.log("MessageService in Navbar:get message"+JSON.stringify(msg));
      if(JSON.stringify(msg).indexOf("add")>-1){
        this.count_in_cart +=1;
      }else if(JSON.stringify(msg).indexOf("delete")>-1){
        this.count_in_cart -=1;
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
