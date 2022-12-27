const Router = require('express').Router;
const db = require('../db/connection');
const {ObjectId} = require('mongodb');

const router = Router();

// Receber todos os passageiros
router.get('/perfil/home', function(req, res) {
    res.render('perfil/create');
});


module.exports = router;