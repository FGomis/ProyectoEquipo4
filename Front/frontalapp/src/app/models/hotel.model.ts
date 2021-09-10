import { Poblacion } from "./poblacion.model";

export class Hotel {
  id_hotel?: number;
  nombre?: string;
  categoria?: string;
  ubi_lat?: number;
  ubi_long?: number;
  precio_noche?: number;
  valoracion?: string;
  imagen?: string;
  telefono?: string;
  id_poblacion?: number;
}
