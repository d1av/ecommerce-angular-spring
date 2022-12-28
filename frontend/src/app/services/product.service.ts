import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Product } from '../common/product';
import { map, Observable } from 'rxjs';
import { ProductCategory } from '../common/product-category';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/products';
  private categoryUrl ='http://localhost:8080/product-categories';

  constructor(private httpClient: HttpClient) { }

  getProductList(theCategoryId: number): Observable<Product[]> {

    const searchUrl = `${this.baseUrl}/search/category?id=${theCategoryId}`;

    return this.httpClient.get<ApiResponseProduct>(searchUrl)
      .pipe(map(response => response.content))
  }

  getProductCategories(): Observable<ProductCategory[]> {
    return this.httpClient.get<ResponseProductCategory>(this.categoryUrl)
      .pipe(map(response => response.content));

  }
}

interface ApiResponseProduct {
  content: Product[]
}

interface ResponseProductCategory {
  content: ProductCategory[]
}
