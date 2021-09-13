import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  nombre = "";
  apellidos = "";
  correo = "";
  usuario = "";
  pass = "";
  conf_pass = "";
  pass_iguales = true;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  confirm_passw(){
    if(this.pass==this.conf_pass){
      this.pass_iguales=true;
      this.router.navigate(["busqueda"]);
    }else{
      this.pass_iguales=false;
    }
  }

}
