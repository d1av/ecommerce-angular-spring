import { Component, OnInit } from '@angular/core';
import { OrderHistoryService } from 'src/app/services/order-history.service';

@Component({
  selector: 'app-admin-area',
  templateUrl: './admin-area.component.html',
  styleUrls: ['./admin-area.component.scss']
})
export class AdminAreaComponent implements OnInit {

  constructor(private orderHistoryService: OrderHistoryService) { }
  ngOnInit(): void {

  }


  getOrdersEndpoint() {
    this.orderHistoryService.getOrderHistory("davi@davi.com").subscribe(
      data => {
        console.log(data);
      }
    )
  }
}
