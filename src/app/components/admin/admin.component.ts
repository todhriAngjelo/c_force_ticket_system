import { Component, OnInit } from '@angular/core';

import { GaugeSegment, GaugeLabel } from './gauge';
import { AppService } from '../../services/app.service';
import { Users } from '../models/users';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})


 
 
 
 
 
 
export class AdminComponent implements OnInit {
  _userArray: Users[];

  constructor(private apiService: AppService) { }
  getUser(): void {
    this.apiService.getUserDetails() 
        .subscribe(
            resultArray => this._userArray = resultArray,
            error => console.log("Error :: " + error)
        )
}
  ngOnInit() {
    this.getUser();

  }



 

  colors = {
    indigo: '#14143e',
    pink: '#fd1c49',
    orange: '#ff6e00',
    yellow: '#f0c800',
    mint: '#00efab',
    cyan: '#05d1ff',
    purple: '#841386',
    white: '#fff'
  };

  nautilusGraph = {
    bgRadius: 100,
    bgColor: this.colors.indigo,
    rounded: true,
    reverse: true,
    animationSecs: 2,
    labels: [
      new GaugeLabel({
        color: this.colors.white,
        text: 'Booked',
        x: 0,
        y: 20,
        fontSize: '1em'
      })],
    segments: [
      new GaugeSegment({
        
        value: 4,
        color: this.colors.orange,
        radius: 20,
        borderWidth: 16
      }),
      new GaugeSegment({
        value: 8,
        color: this.colors.purple,
        radius: 36,
        borderWidth: 16
      }),
      new GaugeSegment({
        value: 15,
        color: this.colors.yellow,
        radius: 52,
        borderWidth: 16
      }),
      new GaugeSegment({
        value: 16,
        color: this.colors.cyan,
        radius: 68,
        borderWidth: 16
      }),
      new GaugeSegment({
        value: 23,
        color: this.colors.pink,
        radius: 84,
        borderWidth: 16
      }),
      new GaugeSegment({
        value: 100,
        color: this.colors.mint,
        radius: 100,
        borderWidth: 16
      })
    ]
  };



  progressGraph = {
    bgRadius: 60,
    bgColor: this.colors.indigo,
    rounded: false,
    reverse: false,
    animationSecs: 1,
    labels: [
      new GaugeLabel({
        color: this.colors.white,
        text: 'Booked',
        x: 0,
        y: 20,
        fontSize: '1em'
      }),
      new GaugeLabel({
        color: this.colors.pink,
        text: '81%',
        x: 0,
        y: 0,
        fontSize: '2em'
      })
    ],
    segments: [
      new GaugeSegment({
        value: 81,
        color: this.colors.pink,
        borderWidth: 20
      })
    ]
  };




}
