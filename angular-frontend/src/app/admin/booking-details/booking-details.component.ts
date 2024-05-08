import { Component } from '@angular/core';
import { TrainService } from '../../train.service';

export class BookDetails{
  constructor(
  bookingId:any,
  pnr:any,
  noOfSeat:any,
  passenger:{
    id:any;
  },
  train:{
    trainid:any;
  }
  ){}
}

@Component({
  selector: 'app-booking-details',
  templateUrl: './booking-details.component.html',
  styleUrl: './booking-details.component.css'
})
export class BookingDetailsComponent{

  bookDetails : BookDetails[];

  constructor(private trainservice: TrainService){}

  ngOnInit(): void{
    this.showBooking();
  }

  showBooking(){
    this.trainservice.getBooking().subscribe(data =>{
      this.bookDetails = data as BookDetails[];
    });
  }
}
