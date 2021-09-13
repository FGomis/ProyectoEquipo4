import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  nombre = "Diego";
  apellidos = "Manríquez Canales";
  email = "ejemplo@dominio.com";
  historial = "Vacío";

  constructor() { }

  ngOnInit(): void {
  }

}