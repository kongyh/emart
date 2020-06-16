import { Injectable } from '@angular/core';
import { items_list } from "./dummy/dummy_items";
import { Item } from "../models/item";
import { Order } from "../models/order";
import { JsonPipe } from '@angular/common';
import {environment} from '../../environments/environment';
import {HttpClient, HttpHeaders,HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  submitOrder(item_list:Item[]){
    let order = new Order();
    order.o_username = sessionStorage.getItem("username");
    order.o_status = "UNPAID";
    order.itemList = JSON.stringify(item_list);//item_list.toString();
    console.log("order service-submit order:"+JSON.stringify(item_list));
    return this.http.put(`${environment.baseUrl}/api/order/submitOrder`, JSON.stringify(order), httpOptions);
  }

}
