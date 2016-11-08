import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import {Client} from '../client';
import {Http, Response} from '@angular/http';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  @Input() client: Client;
  @Output() emitter: EventEmitter<Client> = new EventEmitter<Client>();

  constructor(private http:Http) { }

  ngOnInit() {
  }

  onClick():void{
    this.emitter.emit(this.client);
  }

}
