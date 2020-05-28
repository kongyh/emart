import { Component, OnInit } from '@angular/core';
import { UserService } from "../../services/user.service";
import { Router } from '@angular/router';
import { FormControl } from "@angular/forms";
import { LocalStorage } from "../../pages/localstorage";
import { MessageService } from "../../services/message.service";
import { User } from 'src/app/models/user';
import { RoleType } from 'src/app/models/enumRole'

interface Alert {
  type: string;
  message: string;
}

const ALERTS: Alert[] = [];

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  alerts: Alert[];
  ifChecked: boolean=false;
  inputUsername: string;
  // should be model, if other name did not work, and the value should be boolean or number, 0 mean buyer, 1 mean seller
  model:number = 0; 

  constructor(private userService: UserService, 
              private router: Router,
              private ls: LocalStorage,
              private message: MessageService) {
    this.reset();
  }

  ngOnInit(): void {
    if(this.ls.get("username")!=undefined){
      console.log("username in session storage:"+this.ls.get("username"));
      this.inputUsername= this.ls.get("username");
      this.ifChecked = true;
    }
    if (sessionStorage.getItem('buyer-token')!=undefined) {
      this.router.navigate(['/search']);
      this.message.sendMessage("buyer-authenticated");
    }else if(sessionStorage.getItem('seller-token')!=undefined){
      this.router.navigate(['/sellerHome']);
      this.message.sendMessage("seller-authenticated");
    }
  }

  /* sign in submit */
  onSubmit(value: any) {
    // the input format: {"radioBasic":0,"name":"nina","password":"12345678"}
    if (this.validInput(value)) {
          let postValue: User = new User();
          postValue.role = this.model>0 ? RoleType[1]:RoleType[0];
          postValue.username = value.name;
          postValue.password = value.password;
          console.log("post login:"+JSON.stringify(postValue));
          let out_this = this;
          this.userService.postSignIn(postValue).subscribe(
            data => {
              console.log(JSON.stringify(data));
              const info: any = data;
              if (200 === info.code) {
                  
                  
                  if(out_this.ifChecked){
                    console.log("remember username:"+value.name);
                    out_this.ls.set("username",value.name);
                  }
                  if(info.data.role=="BUYER"){
                    console.log('buyer login successfully! redirect to search page');
                    sessionStorage.setItem('buyer-token', info.data.token);
                    out_this.message.sendMessage("buyer:authenticated");
                    out_this.router.navigate(['/search']);
                  }else{
                    console.log('seller login successfully! redirect to seller home page');
                    sessionStorage.setItem('seller-token', info.data.token);
                    out_this.message.sendMessage("seller:authenticated");
                    out_this.router.navigate(['/sellerHome']);
                  }
                  
              } else {
                console.log('login failed，pop up MSG');
                this.alerts.push({type : 'danger', message: 'username or password error!'});

              }
            }
          );
    }
  }
  /* 验证输入项 */
  validInput(value: any): boolean {
    this.reset();
    let result = true
    if (!value.name) {
      this.alerts.push({type : 'danger', message: 'username required!'});
      result = false;
    }

    if (!value.password) {
      this.alerts.push({type : 'danger', message: 'password required!'});
      result =  false;
    }

    if (value.password.length < 6) {
      this.alerts.push({type : 'danger', message: 'password length must be greater than 6!'});
      result =  false;
    }
    return result;
  }

  close(alert: Alert) {
    this.alerts.splice(this.alerts.indexOf(alert), 1);
  }

  reset() {
    this.alerts = Array.from(ALERTS);
  }
}
