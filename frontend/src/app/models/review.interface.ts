import { ICinema } from './cinema.interface';

export interface IReview {
  id?: any;
  userId?: any;
  userName?: string;
  cinema?: ICinema;
  comment?: string;
}
