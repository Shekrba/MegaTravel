import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from '../model/User';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private LOGIN_URL = "http://localhost:8082/auth"

  private showNavBar: BehaviorSubject<boolean>;

  private currentUserSubject: BehaviorSubject<User>;
  public currentUser: Observable<User>;

  constructor(private http: HttpClient) {
    this.showNavBar = new BehaviorSubject(false);
    this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
  }

  getShowMenu(): BehaviorSubject<boolean> {
    return this.showNavBar;
  }

  setShowMenu(value: boolean): void {
    this.showNavBar.next(value);
  }

  public get currentUserValue(): User {
    return this.currentUserSubject.value;
  }

  login(username: string, password: string) {
    return this.http.post<any>(`${this.LOGIN_URL}/login`, { username, password })
      .pipe(map(user => {
        // login successful if there's a jwt token in the response
        if (user && user.token) {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem('currentUser', JSON.stringify(user));
          this.currentUserSubject.next(user);

        }

        return user;
      }));
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }

  confirmPassword(user : User) : Observable<any> {
    return this.http.post(`${this.LOGIN_URL}/confirmPassword`,user);
  }

}
