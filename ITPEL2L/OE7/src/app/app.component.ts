import { Component } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {
  public appPages = [
    { title: 'About', url: '/about', icon: 'mail' },
    { title: 'Games', url: '/games', icon: 'paper-plane' },
    { title: 'Consoles', url: '/console', icon: 'heart' },
  ];
  public labels = [''];
  constructor() {}
}
