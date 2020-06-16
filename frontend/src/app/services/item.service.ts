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

interface Filter{
  startPrice: number;
  endPrice: number;
  manufacture: string;
}

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  constructor(private http: HttpClient) { }
  items_list: Item[] = items_list;

  get_item(id:number){
    const params = new HttpParams().set('i_id', id.toString());
    console.log("item service-get item-get params:"+JSON.stringify(params));//'${filter.startPrice}' '${filter.endPrice}' '${filter.manufacture}'
    return this.http.get(`${environment.baseUrl}/api/item/getItem`,{params});
  }

  get_items(){
    return this.http.get(`${environment.baseUrl}/api/item/getItems`);
  }

  get_manufactures(){
    return this.http.get(`${environment.baseUrl}/api/item/getManufactures`);
  }

  add_item(item:Item){
    console.log("item service-add item:"+JSON.stringify(item));
    return this.http.post(`${environment.baseUrl}/api/item/addItem`, JSON.stringify(item), httpOptions);
  }

  filter_items(filter: Filter){
    console.log("item service-filter items:"+JSON.stringify(filter));
    const params = new HttpParams()
    .set('startPrice', filter.startPrice.toString())
    .set('endPrice',filter.endPrice.toString())
    .set('manufacture',filter.manufacture);
    console.log("item service-filter items-post params:"+JSON.stringify(params));//'${filter.startPrice}' '${filter.endPrice}' '${filter.manufacture}'
    return this.http.get(`${environment.baseUrl}/api/item/getFilterItems`,{params});
  }

  // addInCart(item:Item){
  //   console.log("item service-add into cart:"+JSON.stringify(item));
  //   return this.http.put(`${environment.baseUrl}/api/cart/addCart`, JSON.stringify(item), httpOptions);
  // }

  // getCart(username:String){
  //   console.log("item service-add into cart:"+JSON.stringify(username));
  //   const params = new HttpParams().set('username',username.toString());
  //   return this.http.get(`${environment.baseUrl}/api/cart/myCart`, {params});
  // }

}
