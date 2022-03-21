import {IShowingDetails} from './showing-details.interface';
import { IReview } from './review.interface';

export interface ICinema {
  id?: any;
  nom?: string;
  adresse?: string;
  telephone?: string;
  gouvernorat?: string;
  image?: string;
  programme?: IShowingDetails[];
  reviews?: IReview[];
}
