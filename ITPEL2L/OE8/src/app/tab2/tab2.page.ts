import { Component } from '@angular/core';

@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page {
  dollar: any;
  peso: any;
  result: any;
  resultPeso: any;

  constructor () {}
  convert(){
    this.peso = 55.51;
    this.result = this.dollar * parseFloat(this.peso);
    this.resultPeso = this.result.toFixed(2);
    console.log('Final Value: ' + this.result);
  }
}
