import 'zone.js/node';
import { APP_BASE_HREF, DOCUMENT } from '@angular/common';
import { ngExpressEngine } from '@nguniversal/express-engine';
import * as express from 'express';
import { existsSync } from 'fs';
import { join } from 'path';


// import * as domino from 'domino';
// import * as fs from 'fs';
// const template = fs.readFileSync('dist/sito-igna/browser/index.html').toString();

// const domino = require('domino');
// const fs = require('fs');
// const path = require('path');
// const template = fs
//   .readFileSync(path.join('dist/sito-igna/browser', 'index.html')) //<--- REPLACE WITH YOUR APP NAME
//   .toString();

// const window = domino.createWindow(template);
// global['window'] = window;
// global['document'] = window.document;
// global['navigator'] = window.navigator;

// Important positioning HERE
import { AppServerModule } from './src/main.server';
import { Injectable, Inject } from '@angular/core';

var mybrowser = require('mock-browser');

@Injectable()
export class MockWindowService {
  constructor (@Inject(DOCUMENT) private _doc: any) { }

  getWindow(): Window {
    return this._doc.defaultView;
  }
  getDocument(): Document {
    return this._doc;
  }
}
const MockBrowser = mybrowser.mocks.MockBrowser;
const mock = new MockBrowser();
global['navigator'] = mock.getNavigator();

// The Express app is exported so that it can be used by serverless Functions.
var docServicer = new MockWindowService(DOCUMENT);
var navigator = mock.getNavigator();
export function app(): express.Express {
  global['window'] = docServicer.getWindow() as any;
  global['document'] = docServicer.getDocument();
  // global['navigator'] = docServicer.getWindow().navigator;
  const server = express();
  const distFolder = join(process.cwd(), 'dist/angular-ecommerce/browser');
  const indexHtml = existsSync(join(distFolder, 'index.original.html')) ? 'index.original.html' : 'index.html';

  // Our Universal express-engine (found @ https://github.com/angular/universal/tree/main/modules/express-engine)
  server.engine('html', ngExpressEngine({
    bootstrap: AppServerModule,
  }));

  server.set('view engine', 'html');
  server.set('views', distFolder);

  // Example Express Rest API endpoints
  // server.get('/api/**', (req, res) => { });
  // Serve static files from /browser
  server.get('*.*', express.static(distFolder, {
    maxAge: '1y'
  }));

  // All regular routes use the Universal engine
  server.get('*', (req, res) => {
    res.render(indexHtml, { req, providers: [{ provide: APP_BASE_HREF, useValue: req.baseUrl }] });
  });

  return server;
}

function run(): void {
  const port = process.env['PORT'] || 4000;
  // Start up the Node server
  const server = app();
  server.listen(port, () => {
    console.log(`Node Express server listening on http://localhost:${ port }`);
  });
}

// Webpack will replace 'require' with '__webpack_require__'
// '__non_webpack_require__' is a proxy to Node 'require'
// The below code is to ensure that the server is run only when not requiring the bundle.
declare const __non_webpack_require__: NodeRequire;
const mainModule = __non_webpack_require__.main;
const moduleFilename = mainModule && mainModule.filename || '';
if (moduleFilename === __filename || moduleFilename.includes('iisnode')) {
  run();
}

export * from './src/main.server';
