import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ICinema} from '../models/cinema.interface';
import {IShowingDetails} from '../models/showing-details.interface';

@Injectable()
export class HomeService {
  SERVER_URL = 'http://localhost:8081';
  constructor(private http: HttpClient) {}

  public getAllCinemasByGouvernorat(governorat: string): Observable<HttpResponse<ICinema[]>> {
    return this.http.get<ICinema[]>(`${this.SERVER_URL}/api/find-cinemas-gouvernorat/${governorat}`, {observe: 'response'});
  }

  public getCinemaById(id: any): Observable<HttpResponse<ICinema>> {
    return this.http.get<ICinema>(`${this.SERVER_URL}/api/get-cinema/${id}`, {observe: 'response'});
  }

  public getShowingDetailsByCinema(cinema: ICinema): Observable<HttpResponse<IShowingDetails[]>> {
    return this.http.get<IShowingDetails[]>(`${this.SERVER_URL}/api/find-showingdetails-cinema/${cinema.nom}`, {observe: 'response'});
  }

  public getProgrammeByCinema(cinema: ICinema): Observable<HttpResponse<IShowingDetails[]>> {
    return this.http.get<IShowingDetails[]>(`${this.SERVER_URL}/api/get-programme-cinema/${cinema.nom}`, {observe: 'response'});
  }
}
