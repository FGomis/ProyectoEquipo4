import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Hotel} from '../models/hotel.model';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  constructor(private http: HttpClient) { }

  public getHoteles(): Observable<Hotel[]> {
    return this.http.get<Hotel[]>(`http://localhost:8084/api/hoteles`).pipe(
      map(data => data.map(data => new Hotel().deserialize(data)))
    );
  }
}
