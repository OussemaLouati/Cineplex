import {IGenre} from './genre.interface';

export interface IFilm {
  id?: any;
  titre?: string;
  synopsis?: string;
  poster?: string;
  genres?: IGenre[];
  duree?: number;
  dateSortie?: string;
}
