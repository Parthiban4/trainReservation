import { Component } from '@angular/core';
import { TrainService } from '../../train.service';

export class Users{
  constructor(
    id: any,
    email:any,
    username: string,
    address: string,
    birthdate: any,
    age: any,
    gender: string,
    mobileno: any
  ){}
}

@Component({
  selector: 'app-passenger',
  templateUrl: './passenger.component.html',
  styleUrl: './passenger.component.css'
})
export class PassengerComponent {

  count:number;

  constructor(private trainService: TrainService){}

  ngOnInit(): void{
    this.showPassengerCount();
  }

  // user : Users[];

  // showPassengers(){
  //   this.trainService.getPassengers().subscribe(data => {
  //     this.user = data as Users[];
  //   })
  // }

  showPassengerCount(){
    this.trainService.showPassengerCount().subscribe(data =>{
      this.count = data as number;
    })
  }


}
