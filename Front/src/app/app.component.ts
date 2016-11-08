import {Component, OnInit} from '@angular/core';
import {Client} from './client'
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  clients: Array<Client>;
  private url = 'http://localhost:8083/back/rest';
  selectedClient: Client;

  constructor(private http:Http){
    
  }

  private getClients():void{
    this.http.get(this.url + '/clients')
    .map((res:Response) => res.json())
    .subscribe((clients:Array<Client>) => this.clients = clients);
  }

  ngOnInit():void{
    this.getClients();
  }

  onClick(client: Client):void{
    this.selectedClient = client;
  }

  save(client:Client):void{
    this.http.post(this.url + '/clients', client)
    .subscribe(data => console.log("Success"), err => console.log("Failed " + err), () => this.getClients());
  }

}
