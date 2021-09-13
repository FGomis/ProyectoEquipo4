
import { Deserializable } from './deserializable';
import { Poblacion } from './poblacion.model';

export class Hotel implements Deserializable{
  public id_hotel!: number;
  public nombre!: string;
  public categoria!: '1' | '2' | '3' | '4'| '5';
  public ubi_lat!: number;
  public ubi_long!: number;
  public precio_noche!: number;
  public valoracion!: 'basico' | 'bien' | 'muybien' | 'excelente';
  public imagen!: string;
  public telefono!: string;
  public poblacion!: Poblacion;

  deserialize(input: any): this {
    return Object.assign(this, input);
  }
}
