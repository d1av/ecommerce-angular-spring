import { Component, OnInit } from '@angular/core';
import { OrderHistoryService } from 'src/app/services/order-history.service';

@Component({
  selector: 'app-admin-area',
  templateUrl: './admin-area.component.html',
  styleUrls: ['./admin-area.component.scss']
})
export class AdminAreaComponent implements OnInit {

  userOrders: any;
  storage: Storage = sessionStorage;

  constructor (private orderHistoryService: OrderHistoryService) { }
  ngOnInit(): void {
    this.getOrdersEndpoint();
  }

  getOrdersEndpoint() {
    const theEmail = this.storage.getItem('email')!;
    this.orderHistoryService.getOrderHistory(theEmail).subscribe(
      data => {
        console.log(data);
        this.userOrders = data.content;
      }
    );
  }

  getJson(): string {
    return JSON.stringify(this.userOrders);
  }
}
