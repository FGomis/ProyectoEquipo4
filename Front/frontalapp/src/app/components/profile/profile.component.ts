import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

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

  constructor(private acRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.nombre = this.acRoute.snapshot.params.user;
  }

}
