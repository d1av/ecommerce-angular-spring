import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { CartItem } from 'src/app/common/cart-item';
import { Product } from 'src/app/common/product';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.scss']
})
export class ProductDetailsComponent implements OnInit {

  product!: Product;

  constructor(
    private cartService: CartService,
    private activatedRoute: ActivatedRoute,
    private productService: ProductService
  ) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(() => {
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

  addToCart(product: Product) {
  //  console.log(`Adding to cart: ${this.product.name}, ${this.product.unitPrice}`)
    const theCartItem = new CartItem(this.product);
    this.cartService.addToCart(theCartItem);
  }
}
