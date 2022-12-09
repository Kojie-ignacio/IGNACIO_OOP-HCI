import { Component } from '@angular/core';

@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss']
})
export class Tab3Page {
  dollar: any;
  peso: any;
  result: any;
  resultDollar: any;

  constructor () {}
  convert(){
    this.dollar = 0.018019;
    this.result = this.peso * parseFloat(this.dollar);
    this.resultDollar = this.result.toFixed(2);
    console.log('Final Value: ' + this.result);
  }
}
