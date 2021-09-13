import { Deserializable } from "./deserializable";
import { Hotel } from './hotel.model';

export class Poblacion implements Deserializable{
  public id_poblacion!: number;
  public nombre!: string;
  public ubi_lat!: number;
  public ubi_long!: number;
  public hoteles!: Hotel[];

  deserialize(input: any): this {
        Object.assign(this, input);

        this.hoteles = input.hoteles.map((hotel: any) => new Hotel().deserialize(hotel));

        return this;
  }
}
