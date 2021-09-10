import { Component, OnInit } from '@angular/core';
import { Hotel } from 'src/app/models/hotel.model';

@Component({
  selector: 'app-filtrado',
  templateUrl: './filtrado.component.html',
  styleUrls: ['./filtrado.component.css']
})
export class FiltradoComponent implements OnInit {

  currentCity = "Tarragona";
  currentCenter = {
    lat: 41.11667,
    lng: 1.25
  }

  listaHotels: Array<any> = [
    {
      id_hotel: 2,
      nombre: 'H10',
      categoria: '4',
      ubi_lat: 41.115248,
      ubi_long: 1.256901,
      precio_noche: 80,
      valoracion: 'excelente',
      imagen: 'url',
      telefono: '900400466',
      id_poblacion: 1,
    },
    {
      id_hotel: 4,
      nombre: 'Astari',
      categoria: '3',
      ubi_lat: 41.117412,
      ubi_long: 1.265011,
      precio_noche: 80,
      valoracion: 'muybien',
      imagen: 'url',
      telefono: '977236900',
      id_poblacion: 1
    }
  ];

  listaDistancias: Array<any> = []

  markers: Array<any> = []

  constructor() { }

  ngOnInit(): void {
    let i = 0;
    while(i<this.listaHotels.length){
      this.listaDistancias.push(Math.round(this.getDistancia(this.listaHotels[i].ubi_lat, this.listaHotels[i].ubi_long)*100)/100);
      this.markers.push({
        position: {
          lat: this.listaHotels[i].ubi_lat,
          lng: this.listaHotels[i].ubi_long
        },
        label: {
          color: 'yellow',
          text: this.listaHotels[i].nombre
        },
        clickeable: true,
        options: {
          animation: google.maps.Animation.DROP
        }
      });
      i++;
    }
  }

  getDistancia(lat: number, long: number){
    console.log(this.listaHotels[0].nombre);
    return Math.sqrt(Math.pow(this.currentCenter.lat-lat, 2)+Math.pow(this.currentCenter.lng-long, 2));
  }

}
