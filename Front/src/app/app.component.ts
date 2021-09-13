import { Component } from '@angular/core';
import { TokenStorageService } from './services/token-storage.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Hotel Searcher';
  hoteles:any = null;
  isLoggedIn = true;
  username?: string;

  constructor(private tokenStorageService: TokenStorageService){}

  ngOnInit(): void{
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if(this.isLoggedIn){
      const user = this.tokenStorageService.getUser();

      this.username = user.username;
    }
  }

  logOut(){
    this.tokenStorageService.signOut();
    window.location.reload();
  }
}
