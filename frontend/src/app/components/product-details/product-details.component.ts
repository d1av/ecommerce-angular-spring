import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.scss']
})
export class ProductDetailsComponent implements OnInit {

  product!: Product;

  constructor(
    private activatedRoute: ActivatedRoute,
    private productService: ProductService
  ) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(()=>{
      this.handleProductDetails()
    })
  }


  handleProductDetails() {
    const theProductId: number = +this.activatedRoute.snapshot.paramMap.get('id')!
    this.productService.getOneProductById(theProductId).subscribe(
      (data: any) => {
        this.product = data
      })
  }
}
