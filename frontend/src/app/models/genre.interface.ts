import {IFilm} from './film.interface';

export interface IGenre {
  id?: any;
  nomGenre?: string;
  films?: IFilm[];
}
