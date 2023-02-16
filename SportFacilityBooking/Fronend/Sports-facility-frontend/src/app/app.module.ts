import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './Component/home/home.component';
import { LoginComponent } from './Component/login/login.component';
import { RegisterComponent } from './Component/register/register.component';
import { HeaderComponent } from './Component/header/header.component';
import { NavbarComponent } from './Component/navbar/navbar.component';
import { FooterComponent } from './Component/footer/footer.component';
import { BookingComponent } from './Component/booking/booking.component';
import { ContactusComponent } from './Component/contactus/contactus.component';
import { authInterceptorProviders } from './_auth/auth.interceptors';
import {HttpClientModule } from '@angular/common/http';
import { DashboardComponent } from './Component/dashboard/dashboard.component';
import { DashboardNavbarComponent } from './Component/dashboard-navbar/dashboard-navbar.component';
import { UpdateComponent } from './Component/update/update.component';
import { DashboardHomeComponent } from './Component/dashboard-home/dashboard-home.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    HeaderComponent,
    NavbarComponent,
    FooterComponent,
    BookingComponent,
    ContactusComponent,
    DashboardComponent,
    DashboardNavbarComponent,
    UpdateComponent,
    DashboardHomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
