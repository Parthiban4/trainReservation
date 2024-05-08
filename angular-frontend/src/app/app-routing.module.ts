import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { TrainComponent } from './home/train/train.component';

// const routes: Routes = [
//   { path: "", component: HomeComponent}, 
//   { path: "login", component: LoginComponent }, 
//   { path: "signup", component: SignupComponent },
//   { path: "train", component: TrainComponent}
// ];

@NgModule({
  imports: [],
  exports: [RouterModule]
})
export class AppRoutingModule { }
