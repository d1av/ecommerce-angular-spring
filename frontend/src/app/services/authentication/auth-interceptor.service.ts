import { isPlatformBrowser } from '@angular/common';
import { HttpClient, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Inject, Injectable, PLATFORM_ID } from '@angular/core';
import { Observable, from, lastValueFrom, map } from 'rxjs';
import LoginTokenResponse from 'src/app/common/auth/login-token-response';
import { environment } from 'src/environments/environment';
import Login from '../../common/auth/login';

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor {

  baseUrl = environment.shopApiUrl;
  accessToken: string | undefined;
  responseLoginDataFromApi: any;

  constructor (
    @Inject(PLATFORM_ID) public platformId: object,
    private http: HttpClient,
  ) { }


  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return from(this.handleAccess(request, next));
  }

  private async handleAccess(request: HttpRequest<any>, next: HttpHandler): Promise<HttpEvent<any>> {
    const theEndpoint = environment.shopApiUrl + '/orders';

    const securedEndpoints = [theEndpoint];
    if (this.accessToken == null && isPlatformBrowser(this.platformId)) {
      this.accessToken = sessionStorage.getItem("token")!;
    }

    if (securedEndpoints.some(url => request.urlWithParams.includes(url))) {

      request = request.clone({
        setHeaders: {
          Authorization: 'Bearer ' + this.accessToken
        }
      });
    }
    return await lastValueFrom(next.handle(request));
  }


  login(formValue: Login): Observable<any> {
    return this.http.post<LoginTokenResponse>(this.baseUrl + '/auth/login', formValue).pipe(map(
      data => {
        this.accessToken = data.accessToken;
        if (isPlatformBrowser(this.platformId)) {
          sessionStorage.setItem("token", data.accessToken);
          sessionStorage.setItem("username", data.username);
          sessionStorage.setItem("roles", JSON.stringify(data.roles));
        }
        this.responseLoginDataFromApi = data;
        return this.responseLoginDataFromApi;
      })
    );
  }
}
