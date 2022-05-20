const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const expressHBS = require('express-handlebars');
const proController = require('./controllers/productController');

// const url = 'mongodb+srv://admin:WhpuXIYKhSZWwqYR@cluster0.pxc7e.mongodb.net/dbUserManager?retryWrites=true&w=majority';
const url = "mongodb://localhost:27017/dbUserManagerPolyDN";

const app = express();
app.use(bodyParser.urlencoded({
    extended: true
}))
// loggin
var urlencodedParser =bodyParser.urlencoded({extended:false});

// loggin
app.use(bodyParser.json());
app.engine('.hbs', expressHBS.engine({ extname: '.hbs', defaultLayout: "main"}));
app.set('view engine', '.hbs');
app.use(express.json());
app.use(express.static('uploads'));
app.use(express.static('css')); 
app.use(express.static('js')); 
var user={} //bien toan cuc

mongoose.connect(url, {useUnifiedTopology: true, useNewUrlParser: true});
app.use('/', proController);
app.listen(3001, ()=>{console.log('Đang Load...')});

app.get('/login',function(req,res){
    res.sendFile(__dirname +'/views/logins/login.html');
})  

app.get('/dangki',function(req,res){
    res.sendFile(__dirname +'/views/logins/dangki.html');
})  

app.get('/lienhe',function(req,res){
    res.render('lienhe.hbs');
})

app.post('/loginProcess',urlencodedParser,function(req,res){
    var user ={
        username:req.body.email,
        password:req.body.pwd
    }
    if(user.username == "ducnxpd04647@gmail.com" && user.password == "123"){
         res.redirect('list-product');
    }else{
          res.sendFile(__dirname +'/views/logins/login.html');
          
    }
});