import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.page.html',
  styleUrls: ['./update-student.page.scss'],
})
export class UpdateStudentPage implements OnInit {
  id:any;
  name:any;
  genre: any;
  f_main: any;
  m_main: any;
  epi: any;
  length: any;
  rate: any;

  constructor(private route: ActivatedRoute, private router: Router, private _apiService: ApiService){
    this.route.params.subscribe((param:any) => {
      this.id = param.id;
      console.log(this.id);
      this.getStudent(this.id);
    })
  }

  ngOnInit() {
  }

  getStudent(id){
    this._apiService.getStudent(id).subscribe((res:any)=>{
      console.log("SUCCESS", res);
      let student = res[0];
      this.name = student.name;
      this.genre= student.genre;
      this.f_main = student.f_main;
      this.m_main = student.m_main;
      this.epi = student.epi;
      this.length = student.length;
      this.rate = student.rate;
    }, (err:any) => {
      console.log("ERROR", err);
    })
  }

  updateStudent(){
    let data = {
      name: this.name,
      genre: this.genre,
      f_main: this.f_main,
      m_main: this.m_main,
      epi: this.epi,
      length: this.length,
      rate: this.rate,
    }
    this._apiService.updateStudent(this.id,data).subscribe((res:any)=>{
      console.log("Success", res);
      alert("SUCCESS");
      this.router.navigateByUrl('/home');
    }, (err: any) => {
      alert("ERROR");
      console.log("Error", err);
    });
  }
  

}
