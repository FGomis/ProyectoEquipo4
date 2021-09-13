import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Poblacion } from '../models/poblacion.model';

@Injectable({
  providedIn: 'root'
})
export class PoblacionService {

  constructor(private http: HttpClient) {  }

  public getPoblaciones(): Observable<Poblacion[]> {
    return this.http.get<Poblacion[]>(`http://localhost:8084/api/poblaciones`).pipe(
      map(data => data.map(data => new Poblacion().deserialize(data)))
    );
  }
}
