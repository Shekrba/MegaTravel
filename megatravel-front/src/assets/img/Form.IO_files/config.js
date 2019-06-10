var host = window.location.host;
var protocol = window.location.protocol;
var serverHost, apiProtocol;
var pathType = 'Subdomains';
var onPremise = false;

// Parse query string
var query = {};
var hashes = location.hash.substr(1).replace(/\?/g, '&').split("&");
var hashpath = '';

// Look in the location.
location.search.substr(1).split("&").forEach(function(item) {
  query[item.split("=")[0]] = item.split("=")[1] && decodeURIComponent(item.split("=")[1]);
});

// Also look in hashes.
hashes.forEach(function (item) {
  parts = item.split('=');
  if (parts.length > 1) {
    query[parts[0]] = parts[1] && decodeURIComponent(parts[1]);
  }
  else if (item.indexOf('/') === 0) {
    hashpath = '/#' + item;
  }
});

if (query['x-jwt-token']) {
  localStorage.setItem('formioToken', query['x-jwt-token']);
  localStorage.removeItem('formioAppUser');
  localStorage.removeItem('formioUser');
  window.history.pushState("", "", hashpath);
}

var parts = host.split('.');
if (parts[0] === 'portal' || parts[0] === 'beta') {
  parts.shift();
  host = parts.join('.');
}

if (host.indexOf('localhost') !== 0) {
  serverHost = host;
  apiProtocol = protocol;
}
else {
  serverHost = 'localhost:3000';
  apiProtocol = 'http:';
}

var appBase = protocol + '//' + window.location.host;
var apiBase = apiProtocol + '//api.' + serverHost;
var formioBase = apiProtocol + '//formio.' + serverHost;
var pdfServer = apiProtocol + '//files.' + serverHost;
if (onPremise) {
  apiBase = apiProtocol + '//' + serverHost;
  formioBase = apiProtocol + '//' + serverHost + '/formio';
  pdfServer = apiProtocol + '//' + serverHost + '/files';
  pathType = 'Subdirectories';
}
angular.module('formioApp').constant('AppConfig', {
  appVersion: '6.2.5',
  copyrightYear: (new Date()).getFullYear().toString(),
  pathType: pathType,
  forceSSL: false,
  pdfPrice: 10,
  onPremise: onPremise,
  appBase: appBase,
  apiBase: apiBase,
  formioBase: formioBase,
  apiProtocol: apiProtocol,
  apiServer: serverHost,
  serverHost: serverHost,
  protocol: apiProtocol,
  pdfServer: pdfServer,
  pdfHostedPrice: 50,
  pdfHostedForms: 25,
  pdfHostedSubs: 1000,
  pdfEnterprisePrice: 250,
  tutorial: 'https://help.form.io/start/',
  userForm: formioBase + '/user',
  userLoginForm: formioBase + '/user/login',
  userRegisterForm: formioBase + '/user/register',
  userLinkGithubForm: formioBase + '/user/link/github',
  paymentForm: formioBase + '/payment',
  commercialContactForm: formioBase + '/commercialcontact',
  pdfUploadForm: formioBase + '/pdfupload',
  teamForm: formioBase + '/team',
  betaForm: formioBase + '/beta',
  feedbackForm: formioBase + '/feedback',
  resetPassForm: formioBase + '/resetpass'
});
