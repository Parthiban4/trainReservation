import { Component } from '@angular/core';
import { FormControl,FormGroup, Validators } from '@angular/forms';
import { TrainService } from '../train.service';
import { Router } from '@angular/router';

export class UserLogin {
  email:string;
  password:string;

  constructor(){
    this.email='';
    this.password='';
  }
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {


  ngOnInit():void{
  }

  //validations
  contactForm = new FormGroup({
    password : new FormControl('', [Validators.required]),
    email : new FormControl('', [Validators.required, Validators.email])
  })

  user: UserLogin;

  constructor(private trainService: TrainService, private route: Router) {
    this.user = new UserLogin;
  }



    loginUser(){
        if(this.user.email==="admin@gmail.com" && this.user.password==="admin@123"){
          localStorage.setItem('role',"admin");
          alert("Login successfull");
          this.route.navigate(["/admin"]);
        }
        else{
        this.trainService.userExist({"email": this.user.email,"password": this.user.password}).subscribe(
          (data: any) => {
            if(data!==null){
              localStorage.setItem("id",data.id);
              localStorage.setItem("name",data.username)
              localStorage.setItem("role","user");
              alert("Login successfull");
              this.route.navigate(["/home"]);
            }
            else{
              alert("Invalid Credentials");
            }
          }
        )
        }
      }
    }
