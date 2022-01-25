var app = require('express')();
var http = require('http').Server(app);

var io = require('socket.io')(http);

app.get('/', function(req,res){
    res.send('<h1>Hi . . ."/" Route . . . </h1>');
});

io.on('connetion', function(socket){
    document.write("User Access");
})

http.listen(82, function(){
    console.log('lisntening on *:82')
})