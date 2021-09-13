import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Poblacion } from '../models/poblacion.model';
import { Hotel } from '../models/hotel.model';

@Injectable({
  providedIn: 'root'
})
export class PoblacionService {

  constructor(private http: HttpClient) {  }

  public getHoteles(nombre_poblacion: string): Observable<Hotel[]> {
    return this.http.get<Hotel[]>("http://localhost:8084/api/poblaciones/"+nombre_poblacion+"/hoteles");
  }

  public getPoblacion(nombre_poblacion: string): Observable<Poblacion> {
    return this.http.get<Poblacion>("http://localhost:8084/api/poblaciones/nombre/"+nombre_poblacion);
  }
}

