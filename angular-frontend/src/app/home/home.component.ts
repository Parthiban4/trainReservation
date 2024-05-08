import { Component } from '@angular/core';
import { TrainService } from '../train.service';
import { TrainComponent } from './train/train.component';

export class Home{
  source:string;
  destination:string;
  date:any;
  classes:string;
  type:any;
}

export class Trains{
  constructor(
  trainId:any,
  trainName:any,
  trainClass:any,
  capacity:any,
  price:any,
  date:any,
  timing:any,
  )
{}
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  // ngOnInit(): void{
  //   this.homeDetails();
  // }

  constructor(private trainService: TrainService){}

  home : Home = new Home();

  name = localStorage.getItem('name');

  train: Trains[];

  onSelectClass(event : Event){
    this.home.classes = (event.target as HTMLSelectElement).value;
    // console.log(this.home.classes);
  }

  onSelectGeneral(event :Event){
    this.home.type = (event.target as HTMLSelectElement).value;
  }

  // homeDetails(){
  //   this.trainService.home(this.home).subscribe();
  // }

  logout(){
    alert("Logout successfull");
    localStorage.clear();
  }
  
}
