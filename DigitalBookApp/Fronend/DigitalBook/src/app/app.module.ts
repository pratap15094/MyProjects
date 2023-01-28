import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { authInterceptorProviders } from './_auth/auth.interceptors';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReaderLoginComponent } from './Component/reader-login/reader-login.component';
import { ReaderDashboardComponent } from './Component/reader-dashboard/reader-dashboard.component';
import { ProfileComponent } from './Component/profile/profile.component';
import { RegisterComponent } from './Component/register/register.component';
import { HeaderAppComponent } from './Component/header-app/header-app.component';
import { HomeComponent } from './Component/home/home.component';
import { HomeNavbarComponent } from './Component/home-navbar/home-navbar.component';
import { AuthorDashboardComponent } from './Component/author-dashboard/author-dashboard.component';
import { NavbrComponent } from './Component/navbr/navbr.component';
import { GuestDashboardComponent } from './Component/guest-dashboard/guest-dashboard.component';
import { AuthorNavbarComponent } from './Component/author-navbar/author-navbar.component';
import { ReaderNavbarComponent } from './Component/reader-navbar/reader-navbar.component';
import { GuestNavbarComponent } from './Component/guest-navbar/guest-navbar.component';
import { AllBooksComponent } from './Component/all-books/all-books.component';
import { GuestHomeComponent } from './Component/guest-home/guest-home.component';
import { GuestSearchComponent } from './Component/guest-search/guest-search.component';
import { ReaderSearchComponent } from './Component/reader-search/reader-search.component';
import { ReaderSubscriptionComponent } from './Component/reader-subscription/reader-subscription.component';
import { AuthorSearchComponent } from './Component/author-search/author-search.component';
import { AuthorCreateBookComponent } from './Component/author-create-book/author-create-book.component';
import { AuthorSubscriptionComponent } from './Component/author-subscription/author-subscription.component';
import { AuthorUpdateBookComponent } from './Component/author-update-book/author-update-book.component';
import { ReaderHomeComponent } from './Component/reader-home/reader-home.component';
import { AuthorHomeComponent } from './Component/author-home/author-home.component';
import { NgxLoadingButtonsModule } from 'ngx-loading-buttons';
import { AuthorMybooksComponent } from './Component/author-mybooks/author-mybooks.component';
import { AuthorBlockbookComponent } from './Component/author-blockbook/author-blockbook.component';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { ContactFormComponent } from './Contact/contact-form/contact-form.component';
@NgModule({
  declarations: [
    AppComponent,
    ReaderLoginComponent,
    ReaderDashboardComponent,
    ProfileComponent,
    RegisterComponent,
    HeaderAppComponent,
    HomeComponent,
    HomeNavbarComponent,
    AuthorDashboardComponent,
    NavbrComponent,
    GuestDashboardComponent,
    AuthorNavbarComponent,
    ReaderNavbarComponent,
    GuestNavbarComponent,
    AllBooksComponent,
    GuestHomeComponent,
    GuestSearchComponent,
    ReaderSearchComponent,
    ReaderSubscriptionComponent,
    AuthorSearchComponent,
    AuthorCreateBookComponent,
    AuthorSubscriptionComponent,
    AuthorUpdateBookComponent,
    ReaderHomeComponent,
    AuthorHomeComponent,
    AuthorMybooksComponent,
    AuthorBlockbookComponent,
    ContactFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxLoadingButtonsModule,
    CommonModule,
    ReactiveFormsModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
