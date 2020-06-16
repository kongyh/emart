import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SigninGuard } from "./guard/sign.guard";

import { LoginComponent } from './pages/login/login.component';
import { SearchComponent } from './pages/search/search.component';
import { DetailComponent } from './pages/detail/detail.component';
import { CartComponent } from './pages/cart/cart.component';
import { OrderComponent } from "./pages/order/order.component";
import { SignupComponent } from "./pages/signup/signup.component";
import { SellerHomeComponent } from "./pages/seller-home/seller-home.component";
import { SellerInvertoryComponent } from "./pages/seller-invertory/seller-invertory.component";
import { SellerReportComponent } from "./pages/seller-report/seller-report.component";
import { SellerAddComponent } from "./pages/seller-add/seller-add.component";

const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "search", component: SearchComponent,canActivate: [SigninGuard] },
  { path: "detail/:itemId", component:  DetailComponent,canActivate: [SigninGuard]},
  { path: "cart", component: CartComponent,canActivate: [SigninGuard] },
  { path: "myOrder", component: OrderComponent,canActivate: [SigninGuard] },
  { path: "signup", component: SignupComponent },
  { path: "sellerHome", component: SellerHomeComponent },
  { path: "sellerInventory", component: SellerInvertoryComponent },
  { path: "sellerReport", component: SellerReportComponent },
  { path: "sellerAdd", component: SellerAddComponent },
  { path: "", redirectTo: '/login', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
