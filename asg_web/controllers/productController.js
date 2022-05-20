const express = require('express');
const proModel = require('../model/product');
var multer = require('multer');
var bodyParser = require('body-parser');
const app = express();
app.use(bodyParser.urlencoded({extended:true}))

   
const storage = multer.diskStorage({
    destination: function(req, file, cb){
        if(file.mimetype === 'image/jpg' ||
        file.mimetype === 'image/jpeg' ||
        file.mimetype === 'image/png'){
            cb(null, 'uploads/images/products');
        }else{
            cb(new Error('not image'), null);
        }
        
    },
    filename: function(req, file, cb){
        cb(null, Date.now()+'.jpg');
    }
})

var upload = multer({storage: storage});

app.get('/add-product', (req,res) => {
    res.render('products/add.hbs',{
        viewTitle: 'THÊM SẢN PHẨM MỚI',
        Title:'Thêm Sản Phẩm Mới'
    });
});

app.get('/lienhe',function(req,res){
    res.render('products/lienhe.hbs',{
          Title:'Liên Hệ'
    });
});

app.get('/json/list-product', (req,res) => {
    proModel.find({}).then(products => {
        res.json(products);
    })

});

app.get('/list-product', (req,res) => {
    proModel.find({}).then(products => {
        res.render('products/list.hbs',{
            Title:'Sản Phẩm',
            products: products.map(product => product.toJSON())
            
        });
    })
    
});

// thu nghiem 

app.post('/json/add-product', (req,res) => {
    proModel.find({}).then(products => {
        res.json(products);
    })

});

app.delete('/json/delete-product', (req,res) => {
    proModel.find({}).then(products => {
        res.json(products);
    })

});

app.patch('/json/update-product', (req,res) => {
    proModel.find({}).then(products => {
        res.json(products);
    })

});

// thu nghiem

app.post('/add-product', upload.single('image'), async(req, res)=>{
    if(req.body.id == ''){
        AddRecord(req, res);
    }else{
        updateRecord(req, res);
    }
});



function AddRecord(req, res){
    var img = "null";
    try {
        img = req.file.filename;
    } catch (error) {
        
    }
    const pro = new proModel({
        name : req.body.name,
        brand : req.body.brand,
        category : req.body.category,
        description : req.body.description,
        price0 : req.body.price0,
        price1 : req.body.price1,
        image : img,
        ssd :req.body.ssd,
        ram : req.body.ram,
        tragop :req.body.tragop,

    });
    try {
        pro.save();
        res.redirect('/list-product');
    } catch (error) {
        res.status(500).send(error);
    }
}
function updateRecord(req, res){
    proModel.findOneAndUpdate({_id:req.body.id},req.body, {new:true},(err,doc) =>{
        if(!err){
            res.redirect('/list-product');
        }else{
            console.log(err);
            res.render('products/add.hbs', {
                viewTitle: "CẬP NHẬT"
                
            });
        }
    });
}

app.get('/xemchitiet/:id', (req,res) => {
     proModel.findById(req.params.id , (err, pro) => {
       if(!err){
           res.render('products/xemchitiet.hbs',{
              Title:"Chi Tiết Sản Phẩm",
               pro:pro.toJSON()
           });
       }
   })
    
});


app.get('/update-product/:id', (req, res) =>{ 
   proModel.findById(req.params.id , (err, pro) => {
       if(!err){
           res.render('products/add.hbs',{
               Title:"Cập Nhật Sản Phẩm",
               viewTitle: "CẬP NHẬT SẢN PHẨM",
               pro:pro.toJSON()
           });
       }
   })
});







app.get('/del-product/:id', async(req, res) =>{ 
    try {
        const pro = await proModel.findByIdAndDelete(req.params.id, req.body);
        if(!pro){
            res.status(404).send("No item found");
        } 
        else{
            res.redirect('/list-product');
        }
     } catch (error) {
        res.status(500).send(error);
     }
 });
 

module.exports = app;