import { registerLocaleData } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookingComponent } from './Component/booking/booking.component';
import { ContactusComponent } from './Component/contactus/contactus.component';
import { DashboardHomeComponent } from './Component/dashboard-home/dashboard-home.component';
import { DashboardComponent } from './Component/dashboard/dashboard.component';
import { HomeComponent } from './Component/home/home.component';
import { LoginComponent } from './Component/login/login.component';
import { RegisterComponent } from './Component/register/register.component';
import { UpdateComponent } from './Component/update/update.component';

const routes: Routes = [
  {
    path:"",component:HomeComponent
  },
  {
    path:"login",component:LoginComponent
  },
  {
    path:"register",component:RegisterComponent
  }
  ,{
    path:"booking",component:BookingComponent
  },
  {
    path:"contact",component:ContactusComponent
  },
  {
    path:"dashboard",component:DashboardComponent,
    children:[
      {
        path:"",component:DashboardHomeComponent
      },
      {
        path:"update",component:UpdateComponent
      },
      {
        path:"booking",component:BookingComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
