import { Component,EventEmitter,OnInit, Output } from '@angular/core';
import { TrainService } from '../../train.service';
import { Home } from '../home.component';
import { ActivatedRoute } from '@angular/router';

export class Trains{
  constructor(
  trainid:any,
  trainname:any,
  trainclass:any,
  capacity:any,
  date:any,
  timing:any,
  )
{}
}

@Component({
  selector: 'app-train',
  templateUrl: './train.component.html',
  styleUrl: './train.component.css'
})
export class TrainComponent {

  source:string;
  destination:string;
  classes;
  date;

  train:Trains[];

  constructor(private trainService : TrainService, private activatedRoute: ActivatedRoute){}

  ngOnInit(): void{
    this.source = this.activatedRoute.snapshot.paramMap.get('source');
    this.destination = this.activatedRoute.snapshot.paramMap.get('destination');
    this.classes = this.activatedRoute.snapshot.paramMap.get('classes');
    this.date = this.activatedRoute.snapshot.paramMap.get('date');
    // console.log(this.source);
    // console.log(this.destination);
    // console.log(this.classes);
    this.retrieveTrain();
  }

  retrieveTrain(){
      this.trainService.getTrainFilterClasses(this.source,this.destination,this.classes,this.date).subscribe(data =>{
      this.train = data as Trains[];
    });
  }

  



  // homeTrain(){
  //   this.trainService.home(this.home).subscribe(data =>{
  //     this.train = data as Trains[];
  //   })
  // }

}
