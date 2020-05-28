import { Component, OnInit } from '@angular/core';
import { Input,Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-itemAlert',
  templateUrl: './itemAlert.component.html',
  styleUrls: ['./itemAlert.component.css']
})
export class ItemAlertComponent implements OnInit {
  @Input() item;
  @Output() notify = new EventEmitter();
  constructor() { }

  ngOnInit() {
  }

}
