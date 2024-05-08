import { Component } from '@angular/core';
import { TrainService } from '../../train.service';

export class Route{
  routeid:any;
  source:string;
  destination:string;
  train:any ={
    "trainid":""
  };
}

export class RouteDetails{
  constructor(
    routeid:any,
    source:string,
    destination:string,
    train:any ={
      "trainid":""
    }
  ){}
}

@Component({
  selector: 'app-train-routes',
  templateUrl: './train-routes.component.html',
  styleUrl: './train-routes.component.css'
})
export class TrainRoutesComponent {

  ngOnInit(): void{
    this.getroute();
  }

  route: Route = new Route();

  routeDetails: RouteDetails[];

  constructor(private trainService: TrainService){}

  getroute(){
    this.trainService.getRoute().subscribe(data =>{
      this.routeDetails = data as RouteDetails[];
    })
  }

  addroute(){
    this.trainService.addRoute(this.route).subscribe(data =>{
      alert("Route Added Successfully");
      this.getroute();
    })
  }

  editroute(){
    this.trainService.editRoute(this.route).subscribe(data =>{
      alert("Route Edited Successfully");
      this.getroute();
    })
  }

  deleteroute(){
    this.trainService.deleteRoute(this.route).subscribe(data =>{
      alert("Route Deleted Successfully");
      this.getroute();
    })
  }

}
