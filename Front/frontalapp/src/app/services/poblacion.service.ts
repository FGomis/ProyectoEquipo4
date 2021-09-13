import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PoblacionService {

  constructor(private http: HttpClient) {  }

  retornarPoblaciones() {
    return this.http.get("http://localhost:8084/api/hoteles")
  }
}
