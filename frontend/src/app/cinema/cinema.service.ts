import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {ICinema} from '../models/cinema.interface';
import {Observable} from 'rxjs';
import {IShowingDetails} from '../models/showing-details.interface';
import {IFilm} from '../models/film.interface';
import { IDeleteDTOInterface } from '../models/deleteDTO.interface';

@Injectable()
export class CinemaService {
  SERVER_URL = 'http://localhost:8081';
  constructor(private http: HttpClient) {}

  public addCinema(cinema: ICinema): Observable<HttpResponse<ICinema>> {
    return this.http.post<ICinema>(`${this.SERVER_URL}/api/create-cinema/`, cinema, {observe: 'response'});
  }

  public getAllCinemas(): Observable<HttpResponse<ICinema[]>> {
    return this.http.get<ICinema[]>(`${this.SERVER_URL}/api/get-all-cinemas`, {observe: 'response'});
  }

  public updateCinema(id: any, cinema: ICinema): Observable<HttpResponse<ICinema>> {
    return this.http.put<ICinema>(`${this.SERVER_URL}/api/update-cinema/${id}`, cinema, {observe: 'response'});
  }

  public saveShowingDetail(showingDetail: IShowingDetails): Observable<HttpResponse<IShowingDetails>> {
    return this.http.post<IShowingDetails>(`${this.SERVER_URL}/api/create-showingdetails/`, showingDetail, {observe: 'response'});
  }

  public deleteCinema(id: any): Observable<HttpResponse<IDeleteDTOInterface>> {
    return this.http.delete<IDeleteDTOInterface>(`${this.SERVER_URL}/api/delete-cinema/${id}`, {observe: 'response'});
  }
}
