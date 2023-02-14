import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-dashboard-navbar',
  templateUrl: './dashboard-navbar.component.html',
  styleUrls: ['./dashboard-navbar.component.css']
})
export class DashboardNavbarComponent implements OnInit {

  constructor(private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
  }
  
  logOut(){
      this.tokenStorage.signOut();
      window.location.reload();
  }
}
