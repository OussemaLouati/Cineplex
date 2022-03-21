import {Injectable} from '@angular/core';
import {Observable, Subject} from 'rxjs';

@Injectable()
export class DataSharingService {
 private addedSubject: Subject<boolean> = new Subject();
  private updatedSubject: Subject<boolean> = new Subject();
  private deletedSubject: Subject<boolean> = new Subject();
  private cinemaAddedSubject: Subject<boolean> = new Subject();
  public emitFilmAdded(value: boolean) {
    this.addedSubject.next(value);
  }

  public emitCinemaAdded(value: boolean) {
    this.cinemaAddedSubject.next(value);
  }

  public getCinemaAddedObservable(): Observable<boolean> {
    return this.cinemaAddedSubject.asObservable();
  }

  public emitFilmUpdated(value: boolean) {
    this.updatedSubject.next(value);
  }

  public emitFilmDeleted(value: boolean) {
    this.deletedSubject.next(value);
  }

  public getAddedObservable(): Observable<boolean> {
    return this.addedSubject.asObservable();
  }

  public getUpdatedObservable(): Observable<boolean> {
    return this.updatedSubject.asObservable();
  }

  public getDeletedObservable(): Observable<boolean> {
    return this.deletedSubject.asObservable();
  }
}
