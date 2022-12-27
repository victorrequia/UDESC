const Router = require('express').Router;
const db = require('../db/connection');
const {ObjectId} = require('mongodb');

const router = Router();

// Receber todos os passageiros
router.get('/compras/home', function(req, res) {
    res.render('passageiros/create');
});


module.exports = router;