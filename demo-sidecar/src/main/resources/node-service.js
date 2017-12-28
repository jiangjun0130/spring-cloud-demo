var http = require('http');
var url = require('url');
var path = require('path');

var server = http.createServer(function (req, res) {
  var pathname = url.parse(req.url).pathname;
  res.writeHead(200,{'Content-Type': 'application/json;charset=utf-8'});
  if(path === '/'){
    res.end(JSON.stringify({"index":"welcome"}));
  }else if(pathname === "/health.json"){
    res.end(JSON.stringify({"status": "UP"}));
  }else {
    res.end("404");
  }
});

server.listen(8060,function () {
  console.log('listening on localhost:8060');
});
