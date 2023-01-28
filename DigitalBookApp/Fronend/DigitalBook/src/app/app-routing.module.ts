import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthorBlockbookComponent } from './Component/author-blockbook/author-blockbook.component';
import { AuthorCreateBookComponent } from './Component/author-create-book/author-create-book.component';
import { AuthorDashboardComponent } from './Component/author-dashboard/author-dashboard.component';
import { AuthorHomeComponent } from './Component/author-home/author-home.component';
import { AuthorMybooksComponent } from './Component/author-mybooks/author-mybooks.component';
import { AuthorSearchComponent } from './Component/author-search/author-search.component';
import { AuthorSubscriptionComponent } from './Component/author-subscription/author-subscription.component';
import { AuthorUpdateBookComponent } from './Component/author-update-book/author-update-book.component';
import { GuestDashboardComponent } from './Component/guest-dashboard/guest-dashboard.component';
import { GuestHomeComponent } from './Component/guest-home/guest-home.component';
import { GuestSearchComponent } from './Component/guest-search/guest-search.component';
import { HomeComponent } from './Component/home/home.component';
import { ProfileComponent } from './Component/profile/profile.component';
import { ReaderDashboardComponent } from './Component/reader-dashboard/reader-dashboard.component';
import { ReaderHomeComponent } from './Component/reader-home/reader-home.component';
import { ReaderLoginComponent } from './Component/reader-login/reader-login.component';
import { ReaderSearchComponent } from './Component/reader-search/reader-search.component';
import { ReaderSubscriptionComponent } from './Component/reader-subscription/reader-subscription.component';
import { RegisterComponent } from './Component/register/register.component';
import { ContactFormComponent } from './Contact/contact-form/contact-form.component';

const routes: Routes = [
  {
    path:"",component:HomeComponent
  },
  {
    path:"contactus",component:ContactFormComponent
  },
  {
    path:"login",component:ReaderLoginComponent,
    children:[
     
    ]
  },
  {
    path:"readerdashboard",component:ReaderDashboardComponent,
    children:[
      {
        path:'',component:ReaderHomeComponent
      },
      {
        path:'subscribedbooks',component:ReaderSubscriptionComponent
      },
      {
        path:'search',component:ReaderSearchComponent
      }
    ]
  },
  { 
    path: 'profile', component: ProfileComponent
   },
  {
    path:"authordashboard",component:AuthorDashboardComponent,
    children:[
      {
        path:'',component:AuthorHomeComponent
      },
      {
        path:'subscribedbooks',component:AuthorSubscriptionComponent
      },
      {
        path:'createbook',component:AuthorCreateBookComponent
      },
      {
        path:'updatebook',component:AuthorUpdateBookComponent
      },
      {
        path:'search',component:AuthorSearchComponent
      },
      {
        path:'mybooks',component:AuthorMybooksComponent
      },
      {
        path:'blockedbooks',component:AuthorBlockbookComponent
      }
    ]
  },
  {
    path:"guestdashboard",component:GuestDashboardComponent,
    children:[
      {
        path:"",component:GuestHomeComponent
      },
      { 
        path: 'register', component: RegisterComponent
     },
     {
       path:'search',component:GuestSearchComponent
     }
     
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
