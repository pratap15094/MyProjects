import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/service/login.service';
import { NgModel } from '@angular/forms';
import { NgForm } from '@angular/forms';
import { TokenStorageService } from 'src/app/service/token-storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reader-login',
  templateUrl: './reader-login.component.html',
  styleUrls: ['./reader-login.component.css']
})
export class ReaderLoginComponent implements OnInit {

  form: any = {
    username: null,
    password: null
  };
  isReader=false;
  isAuthor=true;
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  useRole:string="";
  constructor(private authService: LoginService, private tokenStorage: TokenStorageService,private router: Router) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
  }

  onSubmit(): void {
    const { username, password } = this.form;
   console.log(username);
   console.log(password);
    this.authService.readerLogin(username, password).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUser(data);
        console.log(data);
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        
        this.roles = this.tokenStorage.getUser().roles;
        
        this.reloadPage();
        this.isReader = this.roles.includes('ROLE_READER');
        this.isAuthor = this.roles.includes('ROLE_AUTHOR');
        if(this.isReader){
          this.reloadPage();
        this.router.navigate(['readerdashboard']);
        }
        if(this.isAuthor){
          this.router.navigate(['authordashboard']);
        }
      },
      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }

  reloadPage(): void {
    window.location.reload();
  }

  info(){
    alert("Please login as Guest user to register!");
  }

}
