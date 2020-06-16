/** angular core */
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';

/** module */
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms'  
import { ReactiveFormsModule} from '@angular/forms' 
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";


/**  pages */ 
import { AppComponent } from './app.component';
import { LoginComponent } from './pages/login/login.component';
import { SearchComponent } from './pages/search/search.component';
import { DetailComponent } from './pages/detail/detail.component'
import { NavbarComponent } from "./component/navbar/navbar.component";
import { FooterComponent } from './component/footer/footer.component';
import { CartComponent } from './pages/cart/cart.component';
import { OrderComponent } from "./pages/order/order.component";
import { ItemAlertComponent } from "./component/itemAlert/itemAlert.component";
import { SignupComponent } from "./pages/signup/signup.component";
import { SellerHomeComponent } from "./pages/seller-home/seller-home.component";
import { SellerInvertoryComponent } from "./pages/seller-invertory/seller-invertory.component";
import { SellerReportComponent } from './pages/seller-report/seller-report.component';
import { SellerAddComponent } from "./pages/seller-add/seller-add.component";
import { SellerSidebarComponent } from "./component/seller-sidebar/seller-sidebar.component";

/**interceptor */
import {JwtInterceptor} from './interceptor/jwt.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SearchComponent,
    NavbarComponent,
    FooterComponent,
    DetailComponent,
    CartComponent,
    OrderComponent,
    ItemAlertComponent,
    SignupComponent,
    SellerHomeComponent,
    SellerInvertoryComponent,
    SellerReportComponent,
    SellerAddComponent,
    SellerSidebarComponent
  ],
  imports: [
    NgbModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
