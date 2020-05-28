import { Injectable } from '@angular/core';
import {CanActivate, Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class SigninGuard implements CanActivate {

  constructor(private router: Router) {
  }

  canActivate() {
    result: Boolean;
    if (!sessionStorage.getItem('buyer-token') && !sessionStorage.getItem('seller-token')) {
      this.router.navigate(["/login"]);
    } else{
      return true;
    }
  }
}