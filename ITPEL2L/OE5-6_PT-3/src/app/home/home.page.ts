import { Component } from '@angular/core';
import { ApiService } from '../api.service';


@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})

export class HomePage {
  gender: any;
  name: any;
  email: any;
  contact: any;
  address: any;
  students: any =[];


  constructor(public _apiService: ApiService) {}

  //Function for creating student record
  addStudent() {
    //console.log(this.student_number, this.student_name, this.email);
    const data = {
      name: this.name,
      email: this.email,
      contact: this.contact,
      address: this.address,
      gender: this.gender
    };

    // eslint-disable-next-line no-underscore-dangle
    this._apiService.addStudent(data).subscribe((res: any) => {
      console.log('Success == ', res)
      this.name = '';
      this.email = '';
      this.contact = '';
      this.address = '';
      this.gender = '';
      alert('SUCCESS');
    }, (error: any) => {
      alert('ERROR');
      console.log('Error = ', error);
    });
  }
  //display function
  getStudents(){
    this._apiService.getStudents().subscribe((res: any) =>{
      console.log("SUCCESS ==", res);
      this.students = res;
    },(error:any) =>{
      console.log("ERROR ==", error);
    }
    )
  }

}
