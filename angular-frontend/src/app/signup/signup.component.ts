import { Component } from '@angular/core';
import { TrainService } from '../train.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

export class UserDetails{
  id: any;
  email:any;
  username: string;
  password: string;
  address: string;
  birthdate: any;
  age: any;
  gender: string;
  mobileno: any;
}

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent{

  //validations
  contactForm = new FormGroup({
    password : new FormControl('', [Validators.required]),
    email : new FormControl('', [Validators.required, Validators.email]),
    age : new FormControl('', [Validators.required]),
    mobileNo : new FormControl('', [Validators.required]),
    username : new FormControl('', [Validators.required]),
    birthData : new FormControl('', [Validators.required]),
    address : new FormControl('', [Validators.required]),
    gender : new FormControl('', [Validators.required])
  })


  user: UserDetails = new UserDetails;

  constructor(private trainService : TrainService, private router: Router){}

  registerUser(){
    this.trainService.userRegister(this.user).subscribe(data => {
      alert("Register Successfully");
      this.router.navigateByUrl('');
    })
  }
}
