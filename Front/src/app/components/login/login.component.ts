import { HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import {first} from "rxjs/operators";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: any = {
    username: null,
    password: null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService, private tokenStorage: TokenStorageService, private router: Router) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()){
      this.isLoggedIn = true;
    }
  }

  onSubmit(): void {
    const { username, password } = this.form;
    this.authService.login(username, password)
    .pipe(first())
    .subscribe(
    (data: HttpResponse<any>) => {
      console.log(data.headers);
      console.log(data.headers.get('Authorization'));
      this.tokenStorage.saveToken(data.headers.get('Authorization'));
      this.router.navigate(['/busqueda']);
    },

    error => {
      this.errorMessage = error.error.message;
      console.log(error);
      this.isLoginFailed = true;
    }
    );
  }

  reloadPage(): void{
    window.location.reload();
  }
}

