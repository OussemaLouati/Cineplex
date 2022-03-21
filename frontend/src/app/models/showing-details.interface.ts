import {IPlace} from './place.interface';

export interface IShowingDetails {
  id?: any;
  nomCinema?: string;
  nomFilm?: string;
  temps?: string;
  prixTND?: number;
  places?: IPlace[];
}
