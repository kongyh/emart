import { Component, OnInit } from '@angular/core';
import { ItemService } from '../../services/item.service';
import { Item } from "../../models/item";
import { Router } from '@angular/router';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  constructor(private orderService: OrderService,
              private router: Router) { }
   
  public order: any;
  public items:any;
  private username:string;

  ngOnInit() {
    this.username = sessionStorage.getItem("username");  
    let out_this = this;
    this.orderService.getOrder(this.username).subscribe(data=>{
      out_this.order = data[0];

      out_this.items =  JSON.parse(data[0]["itemList"]);
    })
  }

}
