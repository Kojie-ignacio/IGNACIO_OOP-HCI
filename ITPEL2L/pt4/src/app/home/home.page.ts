import { Component } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  name:any;
  genre: any;
  f_main: any;
  m_main: any;
  epi: any;
  length: any;
  rate: any;
  students: any = [];

  constructor(public _apiService: ApiService) {}
  addStudent(){
    //console.log(this.student_no, this.student_name, this.email);
    let data = {
      name: this.name,
      genre: this.genre,
      f_main: this.f_main,
      m_main: this.m_main,
      epi: this.epi,
      length: this.length,
      rate: this.rate,
    }

    this._apiService.addStudent(data).subscribe((res:any)=>{
      console.log("Success == ", res);
      this.name = '';
      this.genre = '';
      this.f_main = '';
      this.m_main = '';
      this.epi = '';
      this.length = '';
      this.rate = '';
      alert("SUCCESS");
    }, (error: any) => {
      alert("ERROR");
      console.log("Error = ", error);
    });
  }
    getStudents(){
    this._apiService.getStudents().subscribe((res:any) => {
      console.log("SUCCESS == ", res);
      this.students = res;
    },(error:any) =>{
      console.log("ERROR == ", error);
    })
  }

  deleteStudent(id){
    let record;
      if (confirm("Do you really want to delete?") == true) {
        record = "Deleted Successfully!";
      } else {
        record = "Cancel";
      } alert(record);
    this._apiService.deleteStudent(id).subscribe((res:any) => {
      console.log("Delete SUCCESS == ", res);
      this.students = res;
    },(error:any) =>{
      console.log("ERROR");
    })
  }
}


