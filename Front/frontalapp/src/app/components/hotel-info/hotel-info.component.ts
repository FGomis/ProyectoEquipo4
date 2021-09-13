import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Hotel } from 'src/app/models/hotel.model';
import { Poblacion } from 'src/app/models/poblacion.model';
import { HotelService } from 'src/app/services/hotel.service';

@Component({
  selector: 'app-hotel-info',
  templateUrl: './hotel-info.component.html',
  styleUrls: ['./hotel-info.component.css']
})
export class HotelInfoComponent implements OnInit {

  // Definimos una instancia de Hotel para guardar la informacion
  hotel: Hotel = {
    id_hotel: 0,
    nombre: '',
    categoria: '1',
    ubi_lat: 0,
    ubi_long: 0,
    precio_noche: 0,
    valoracion: 'basico',
    imagen: '',
    telefono: '',
    direccion: '',
  }

  // imagenH10: string = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1b/7e/af/36/rooftop-bar-caelum.jpg?w=900&h=-1&s=1";
  // imagenAstari: string = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1b/9a/94/46/astari-hotel.jpg?w=900&h=-1&s=1";

  // Calculamos la distancia del hotel al centro de la ciudad
  distancia: number = 0;

  // Array auxiliar para pintar las estrellas de la categoria del hotel
  numbers: Array<number> = [];

  // Guardamos las coordenadas de la poblacion para centrar el mapa y construimos un marker
  focus_point = {
    lat: 0,
    lng: 0
  }
  marker = {
    position: {
      lat: this.hotel.ubi_lat,
      lng: this.hotel.ubi_long
    },
    label: {
      color: 'white',
      text: this.hotel.nombre
    },
    clickeable: true,
    options: {
      animation: google.maps.Animation.DROP
    }
  }

  constructor(private acRoute: ActivatedRoute, private hotServ: HotelService) { }

  ngOnInit(): void {
    this.hotel.id_hotel = this.acRoute.snapshot.params.id;
    this.focus_point.lat = parseFloat(this.acRoute.snapshot.params.lat);
    this.focus_point.lng = parseFloat(this.acRoute.snapshot.params.long);

    this.hotServ.getHotel(this.hotel.id_hotel).subscribe(hotelito => {this.hotel = hotelito;
      this.crearMarkersYNums();});;
  }

  crearMarkersYNums(){
    this.marker = {
      position: {
        lat: this.hotel.ubi_lat,
        lng: this.hotel.ubi_long
      },
      label: {
        color: 'white',
        text: this.hotel.nombre
      },
      clickeable: true,
      options: {
        animation: google.maps.Animation.DROP
      }
    }
    this.distancia = Math.round(this.getDistancia(this.hotel.ubi_lat, this.hotel.ubi_long)*100)/100;
    console.log("Focus: "+this.focus_point.lat+", "+this.focus_point.lng )
    for(let i=0;i<this.cambiaTipo(this.hotel.categoria);i++){
      this.numbers.push(i);
    }
  }

  getDistancia(lat: number, long: number){
    return Math.sqrt(Math.pow(this.focus_point.lat-lat, 2)+Math.pow(this.focus_point.lng-long, 2));
  }

  capitalize(cadena: string){
    // Metodo para poner la primera letra en mayuscula y el resto en minuscula
    cadena = cadena.toLowerCase();
    let primera_letra = cadena.substring(0,1).toUpperCase();
    return primera_letra+cadena.substring(1);
  }

  cambiaTipo(categ: string){

    // Metodo para cambiar a entero los string uno, dos, tres, cuatro y cinco

    switch(categ){
      case 'uno':
        return 1;
      case 'dos':
        return 2;
      case 'tres':
        return 3;
      case 'cuatro':
        return 4;
      default:
        return 5;
    }
  }

}
