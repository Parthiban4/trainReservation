import { Component } from '@angular/core';
import { TrainService } from '../train.service';
import { ActivatedRoute } from '@angular/router';
import jsPDF from 'jspdf';
import html2canvas from 'html2canvas';

export class BookingFinalDetails{ 

  pnr:any;
  passenger:{
    id:any
  };
  train:{
    trainid:any;
    trainname:string;
    timing:any;
    date:any;
  }
  seatsRequired:any;
  seatNumbers:any;
}

@Component({
  selector: 'app-booking-result',
  templateUrl: './booking-result.component.html',
  styleUrl: './booking-result.component.css'
})
export class BookingResultComponent {

  source:string;
  destination:string;
  classes:string;
  trainId:any;

  bookingResult: BookingFinalDetails = new BookingFinalDetails();

  constructor(private trainService: TrainService, private activatedRoute: ActivatedRoute){}

  ngOnInit(): void{
      this.source = this.activatedRoute.snapshot.paramMap.get('source');
      this.destination = this.activatedRoute.snapshot.paramMap.get('destination');
      this.classes = this.activatedRoute.snapshot.paramMap.get('classes');
      this.trainId = this.activatedRoute.snapshot.paramMap.get('trainId');
      this.getBookingDetails();
      // console.log(this.source);
      // console.log(this.destination);
      // console.log(this.classes);
 
  }


  getBookingDetails(){
    this.trainService.getBookingById(this.trainId).subscribe(data =>{
      this.bookingResult = data as BookingFinalDetails;
    })
  }

  //to download as pdf

  public downloadFullPagePDF(): void {
    html2canvas(document.body).then(canvas => {
      let pdf = new jsPDF('p', 'mm', 'a4');
      let imgWidth = 210; // A4 width in mm
      let pageHeight = 297;  // A4 height in mm
      let imgHeight = canvas.height * imgWidth / canvas.width;
      let heightLeft = imgHeight;
      let position = 0;

      pdf.addImage(canvas.toDataURL('image/png'), 'PNG', 0, position, imgWidth, imgHeight);
      pdf.save('Trainbooking.pdf');
    });
  }

  logout(){
    alert("logout successfull");
    localStorage.clear();
  }
}

