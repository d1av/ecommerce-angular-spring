import { environment } from "src/environments/environment";

export default {
  oidc: {
    clientId: '0oa7slv4ogJuueesy5d7',
    redirectUri: environment.shopApiUrl + '/login/callback',
    scopes: ['openid', 'profile', 'email']
  }
}
