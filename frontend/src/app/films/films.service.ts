import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IFilm} from '../models/film.interface';
import {IDeleteDTOInterface} from '../models/deleteDTO.interface';

@Injectable()
export class FilmsService {
  SERVEUR_URL = 'http://localhost:8082';
  constructor(private http: HttpClient) {}

  public getAllFilms(): Observable<HttpResponse<IFilm[]>> {
    return this.http.get<IFilm[]>(`${this.SERVEUR_URL}/api/get-all-films`, {observe: 'response'});
  }

  public updateMovie(id: any, film: IFilm): Observable<HttpResponse<IFilm>> {
    return this.http.put<IFilm>(`${this.SERVEUR_URL}/api/update-film/${id}`, film, {observe: 'response'});
  }

  public deleteMovie(id: any): Observable<HttpResponse<IDeleteDTOInterface>> {
    return this.http.delete<IDeleteDTOInterface>(`${this.SERVEUR_URL}/api/delete-film/${id}`, {observe: 'response'});
  }

  public addMovie(film: IFilm): Observable<HttpResponse<IFilm>> {
    return this.http.post<IFilm>(`${this.SERVEUR_URL}/api/create-film`, film, {observe: 'response'});
  }

  public getMovieById(id: any): Observable<HttpResponse<IFilm>> {
    return this.http.get<IFilm>(`${this.SERVEUR_URL}/api/get-film/${id}`, {observe: 'response'});
  }

}
