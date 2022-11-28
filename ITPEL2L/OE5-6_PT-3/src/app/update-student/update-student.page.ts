import { ApiService } from './../api.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.page.html',
  styleUrls: ['./update-student.page.scss'],
})
export class UpdateStudentPage implements OnInit {

  id: any;
  name: any;
  email: any;
  contact: any;
  address: any;
  gender: any;


  constructor(private route:ActivatedRoute, private router: Router, private _apiService: ApiService) {
    this.route.params.subscribe((param:any)=>{
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
      this.email = student.email;
      this.contact = student.contact;
      this.address = student.address;
      this.gender = student.gender;
    }, (err:any)=>{
      console.log("ERROR", err);
    })
  }

updateStudent(){
  let data = {
    name: this.name,
    email: this.email,

    address: this.address,
    gender: this.gender,
  }
  this._apiService.updateStudent(this.id,data).subscribe((res:any)=>{
    console.log("SUCCESS",res);
    alert("SUCCESS");
    this.router.navigateByUrl('/home');
  }, (err:any)=>{
    console.log("ERROR", err);
  })
}


}
