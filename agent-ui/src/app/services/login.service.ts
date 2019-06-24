import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private showNavBar: BehaviorSubject<boolean>;

  constructor() { 
    this.showNavBar = new BehaviorSubject(false);
  }

  getShowMenu(): BehaviorSubject<boolean> {
    return this.showNavBar;
  }

  setShowMenu(value: boolean): void {
    this.showNavBar.next(value);
  }

}
