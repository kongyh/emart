import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment';
import { User } from '../models/user'
import { Buyer } from '../models/buyer'
import { Seller } from '../models/seller'
import { RoleType } from '../models/enumRole'

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  public get currentUserToken(): string {
    return sessionStorage.getItem('token');
  }

  postSignIn(user: User) {
    return this.http.post(`${environment.baseUrl}/user/login`, JSON.stringify(user), httpOptions); 
    
  }

  signup(user: Seller | Buyer){
    // 1. check user name is duplicated in database
    // 2. insert user in database
    // 3. return status
    console.log("signup service");
    console.log("user service-signup user:"+JSON.stringify(user));
    if(JSON.stringify(user).indexOf("seller")>-1){
      return this.http.post(`${environment.baseUrl}/user/sellerSignup`, JSON.stringify(user), httpOptions);
    }else{
      return this.http.post(`${environment.baseUrl}/user/buyerSignup`, JSON.stringify(user), httpOptions);
    }   
  }

}
