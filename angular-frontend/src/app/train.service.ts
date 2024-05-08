import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserLogin } from './login/login.component';
import { UserDetails } from './signup/signup.component';
import { TrainDetails } from './admin/add-train/add-train.component';
import { Route } from './admin/train-routes/train-routes.component';
import { Booking } from './booking/booking.component';
import { Home } from './home/home.component';

@Injectable({
  providedIn: 'root'
})
export class TrainService {

  constructor(private httpClient: HttpClient) { }

  // //checkAvailability
  // checkingAvailableTrain(home: HomeDetails){
  //   return this.httpClient.post('http://localhost:8080/train/checkavailable',home);
  // }

  // login
  // loginUser(user :UserLogin):Observable<Object>{
  //   return this.httpClient.post('http://localhost:8080/login',user);
  // }

  //passenger
  showPassengerCount(){
    return this.httpClient.get('http://localhost:8080/passenger/count');
  }

  userExist(loginDetails:any){
    return this.httpClient.post('http://localhost:8080/passenger/login',loginDetails);
  }

  //signup
  userRegister(user : UserDetails){
    return this.httpClient.post('http://localhost:8080/passenger/add',user);
  }

  //train
  getTrainDetails(){
    return this.httpClient.get('http://localhost:8080/train/all');
  }

  //train
  getTrainFilter(source:string, destination:string){
    return this.httpClient.get(`http://localhost:8080/home/route/${source}/${destination}`);
  }

  //train
  getTrainFilterClasses(source:string, destination:string, classes: string, date:any){
    return this.httpClient.get(`http://localhost:8080/home/filter/${source}/${destination}/${classes}/${date}`);
  }

  //admin
  getPassengers(){
    return this.httpClient.get('http://localhost:8080/passenger/all')
  }

  //admin
  createTrain(train :TrainDetails){
    return this.httpClient.post('http://localhost:8080/train/add',train);
  }

  //admin
  editTrain(train: TrainDetails){
    return this.httpClient.put(`http://localhost:8080/train/update/${train.trainid}`,train);
  }

  //admin
  deleteTrain(train : TrainDetails){
    return this.httpClient.delete(`http://localhost:8080/train/delete/${train.trainid}`);
  }

  //route
  addRoute(route : Route){
    return this.httpClient.post('http://localhost:8080/route/add',route);
  }

  //route
  editRoute(route : Route){
    return this.httpClient.put(`http://localhost:8080/route/update/${route.routeid}`,route);
  }

  //route
  deleteRoute(route : Route){
    return this.httpClient.delete(`http://localhost:8080/route/delete/${route.routeid}`);
  }

  //booking
  booking(book : Booking){
    return this.httpClient.post('http://localhost:8080/booking/add',book);
  }

  //home
  cancelTicket(pnr:any){
    return this.httpClient.delete(`http://localhost:8080/booking/cancel/${pnr}`);
  }

  //route
  getRoute(){
    return this.httpClient.get('http://localhost:8080/route/all');
  }

  //home
  home(home : Home){
    return this.httpClient.get(`http://localhost:8080/home/filter/${home.source}/${home.destination}/${home.classes}`);
  }

  //bookingDetails
  getBooking(){
    return this.httpClient.get('http://localhost:8080/booking/all');
  }

  //bookingDetails
  getBookingById(trainId:any){
    return this.httpClient.get(`http://localhost:8080/booking/trainId/${trainId}`);
  }
}
