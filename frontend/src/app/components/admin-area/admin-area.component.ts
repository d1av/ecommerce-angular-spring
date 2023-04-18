import { isPlatformBrowser } from '@angular/common';
import { Component, Inject, OnInit, PLATFORM_ID } from '@angular/core';
import { OrderHistoryService } from 'src/app/services/order-history.service';

@Component({
  selector: 'app-admin-area',
  templateUrl: './admin-area.component.html',
  styleUrls: ['./admin-area.component.scss']
})
export class AdminAreaComponent implements OnInit {

  userOrders: any;

  constructor (
    @Inject(PLATFORM_ID) public platformId: object,
    private orderHistoryService: OrderHistoryService) { }
  ngOnInit(): void {
    this.getOrdersEndpoint();
  }

  getOrdersEndpoint() {
    if (isPlatformBrowser(this.platformId)) {
      const theEmail = localStorage.getItem('email')!;
      this.orderHistoryService.getOrderHistory(theEmail).subscribe(
        data => {
          console.log(data);
          this.userOrders = data.content;
        }
      );
    }
  }

  getJson(): string {
    return JSON.stringify(this.userOrders);
  }
}
