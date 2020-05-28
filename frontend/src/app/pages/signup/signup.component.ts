import { Component, OnInit} from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { UserService } from "../../services/user.service";
import { Router } from '@angular/router';
import { Seller } from 'src/app/models/seller';
import { Buyer } from 'src/app/models/buyer';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  active = 1;
  sellerSignupForm;
  buyerSignupForm;
  constructor(private formBuilder: FormBuilder,
              private userService: UserService,
              private router: Router
   ){
      this.sellerSignupForm = this.formBuilder.group({
        s_name: '',
        s_password: '',
        s_company: '',
        s_brief_company: '',
        s_address: '',
        s_website: '',
        s_email: '',
        s_mobile: ''
      });
      this.buyerSignupForm = this.formBuilder.group({
        b_id: '',
        b_name: '',
        b_password: '',
        b_email: '',
        b_mobile: ''
      });
   }

  ngOnInit() {
  }
  onSubmit(signupData){
    console.log("signup submitted");
    console.log("signup data:"+JSON.stringify(signupData));
 
      this.userService.signup(signupData).subscribe(
        data => {
          console.log("response of signup:"+JSON.stringify(data)); 
          if(data!=null){
            this.router.navigate(["/login"]);
          }
          else{
            window.alert("error happen when signup, please try again!");
          }
        }
      );
  }

}
