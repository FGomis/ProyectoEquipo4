import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  currentEmail = "";
  currentPass = "";

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  checkUser(){
    console.log(this.currentEmail+"\n"+this.currentPass);
    this.router.navigate(["busqueda"]);
  }

}
