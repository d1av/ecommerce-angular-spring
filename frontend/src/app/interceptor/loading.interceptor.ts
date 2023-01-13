import {
  HttpEvent, HttpHandler, HttpInterceptor, HttpRequest
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { delay, finalize, Observable } from 'rxjs';

@Injectable()
export class LoadingInterceptor implements HttpInterceptor {

  constructor(private loading: NgxSpinnerService) { }

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    this.loading.show(undefined, {
      bdColor: 'rbga(255,255,0,0.6)',
      color: '#000000'
    });
    return next.handle(request).pipe(
      delay(1000),
      finalize(() => {
        this.loading.hide()
      })
    )
  }
}
