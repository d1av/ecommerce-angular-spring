<<<<<<< HEAD
import { HttpClientModule, HTTP_INTERCEPTORS, provideHttpClient } from '@angular/common/http';
=======
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
>>>>>>> a2a4190dcd835df27e2ddda8682ef2e99baf8d36
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppComponent } from './app.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import { CartStatusComponent } from './components/cart-status/cart-status.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { LoginStatusComponent } from './components/login-status/login-status.component';
import { LoginComponent } from './components/login/login.component';
import { ProductCategoryMenuComponent } from './components/product-category-menu/product-category-menu.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { SearchComponent } from './components/search/search.component';
import { CartService } from './services/cart.service';
import { ProductService } from './services/product.service';

import {
  OktaAuthModule,
  OktaCallbackComponent,
  OKTA_CONFIG
} from '@okta/okta-angular';

import { OktaAuth } from '@okta/okta-auth-js';

import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { MembersPageComponent } from './components/members-page/members-page.component';
import { OrderHistoryComponent } from './components/order-history/order-history.component';
import myAppConfig from './config/my-app-config';
import { AuthInterceptorService } from './services/auth-interceptor.service';


const oktaConfig = myAppConfig.oidc;
const oktaAuth = new OktaAuth(oktaConfig);


@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductCategoryMenuComponent,
    SearchComponent,
    ProductDetailsComponent,
    CartStatusComponent,
    CartDetailsComponent,
    CheckoutComponent,
    LoginComponent,
    LoginStatusComponent,
    MembersPageComponent,
    OrderHistoryComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    ReactiveFormsModule,
    FormsModule,
    OktaAuthModule,
    RouterModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    ProductService,
    CartService,
    OktaCallbackComponent,
    provideHttpClient(),
    { provide: OKTA_CONFIG, useValue: { oktaAuth } },
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptorService, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
