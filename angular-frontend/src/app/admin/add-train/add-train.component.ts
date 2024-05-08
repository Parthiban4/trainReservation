import { Component} from '@angular/core';
import { TrainService } from '../../train.service';

export class TrainDetails{
  trainid:any;
  trainname:any;
  trainclass:any;
  capacity:any;
  date:any;
  timing:any;
}

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
  selector: 'app-add-train',
  templateUrl: './add-train.component.html',
  styleUrl: './add-train.component.css'
})
export class AddTrainComponent {

  train: TrainDetails = new TrainDetails();

  trains: Trains[];

  ngOnInit(): void{
    this.showTrain();
  }

  constructor(private trainService: TrainService){}

  showTrain(){
    this.trainService.getTrainDetails().subscribe(data =>{
      this.trains = data as Trains[];
    });
  }

  addTrain(){
    this.trainService.createTrain(this.train).subscribe(data => {
      console.log(data);
      alert("New Train Created Successfully");
      this.showTrain();
    })
  }

  editTrain(){
    this.trainService.editTrain(this.train).subscribe(data =>{
      alert("Train Details Edited Successfully");
      this.showTrain();
    })
  }

  deletetrain(){
    this.trainService.deleteTrain(this.train).subscribe(data =>{
      alert("Train Deleted Successfully");
      this.showTrain();
    })
  }


}
