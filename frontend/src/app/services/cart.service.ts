import { Injectable } from '@angular/core';
import { items_list } from "./dummy/dummy_items";
import { Item } from "../models/item";
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
export class CartService {

  constructor(private http: HttpClient) { }
  
  addInCart(item:Item){
    console.log("item service-add into cart:"+JSON.stringify(item));
    return this.http.put(`${environment.baseUrl}/api/cart/addCart`, JSON.stringify(item), httpOptions);
  }

  getCart(username:String){
    console.log("item service-get cart:"+JSON.stringify(username));
    const params = new HttpParams().set('username',username.toString());
    return this.http.get(`${environment.baseUrl}/api/cart/myCart`, {params});
  }

  deleteInCart(i_id:number){
    console.log("cart service-delete cart -- item_id:"+i_id.toString);
    const params = new HttpParams().set('i_id',i_id.toString());
    return this.http.delete(`${environment.baseUrl}/api/cart/deleteInCart`, {params});
  }
   

}
