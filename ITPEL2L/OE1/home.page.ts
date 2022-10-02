import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  text = "My First Ionic App"
  onChangeText(){
    this.text = 'Changed';
  }

onOriginalText(){
  this.text = 'Original Text';
}
}
