const mongoose = require('mongoose');
const productSchema = new mongoose.Schema({
    email_rs: {
        type: String
    },
    matkhau_rs: {
        type: String
    },
    nhaplai_rs: {
        type: String
    },
     sodienthoai_rs: {
        type: String
    },
    

});
const Product = mongoose.model('user', productSchema);
module.exports = Product;