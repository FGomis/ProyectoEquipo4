import { Component, OnInit, ViewChild } from '@angular/core';
import { MapInfoWindow, MapMarker } from '@angular/google-maps';
import {Hotel} from './../../models/hotel.model';
import { HotelService } from './../../services/hotel.service';

@Component({
  selector: 'app-filtrado',
  templateUrl: './filtrado.component.html',
  styleUrls: ['./filtrado.component.css']
})
export class FiltradoComponent implements OnInit {

  @ViewChild(MapInfoWindow, {static: false}) infoWindow: any;

  currentCity = "Tarragona";
  currentCenter = {
    lat: 41.11667,
    lng: 1.25
  }
  id_hotel!: number;
  listahoteles!: Hotel[];

  markers = [{
      position: {
        lat: 41.115248,
        lng: 1.256901
      },
      label: {
        color: 'yellow',
        text: 'H10'
      },
      clickeable: true,
      options: {
        animation: google.maps.Animation.DROP
      }
    },
    {
      position: {
        lat: 41.117412,
        lng: 1.265011
      },
      label: {
        color: 'yellow',
        text: 'Astari'
      },
      clickeable: true,
      options: {
        animation: google.maps.Animation.DROP
      }
    }
  ]

  constructor(private hotelService: HotelService) { }

  ngOnInit(): void {
  }

  public getHoteles() {
    this.hotelService.getHoteles().subscribe(hoteles => this.listahoteles = hoteles);
  }

  openInfo() {
    window.open("/busqueda");
  }

}
