const Router = require('express').Router;
const db = require('../db/connection');
const {ObjectId} = require('mongodb');

const router = Router();

// Receber todos as passagem
router.get('/', function(req, res) {
    res.render('passagens/create');
});

// Envio de passagem para inserção no banco
router.post('/', function(req, res){
    const data = req.body;
    const idpassageiro = data.idpassageiro;
    const idvoo = data.idvoo;
    const poltrona = data.poltrona;
    
    db.getDB()
    .db()
    .collection('passagens')
    .insertOne({idpassageiro: idpassageiro, idvoo: idvoo, poltrona: poltrona});

    res.redirect(301, '/passagens/home');
})

// View de edição de passagem
router.get('/passagens/edit/:id', async function(req, res){
    const id = new ObjectId(req.params.id);

    const passagem = await db.getDB().db().collection('passagens').findOne({_id: id});

    res.render('passagens/edit', {passagem});
})

// Edição de passagem
router.post('/update', function(req, res){
    const data = req.body;
    const id = new ObjectId(data.id);
    const idpassageiro = data.idpassageiro;
    const idvoo = data.idvoo;
    const poltrona = data.poltrona;

    db.getDB()
    .db()
    .collection('passagens')
    .updateOne({_id: id}, {$set: {idpassageiro: idpassageiro, idvoo: idvoo, poltrona: poltrona}})

    res.redirect('/passagens/home');
})

// Remoção de passagem
router.post('/passagens/delete', function (req, res){
    const data = req.body;
    const id = new ObjectId(data.id);

    db.getDB()
    .db()
    .collection('passagens')
    .deleteOne({_id: id})

    res.redirect(301, '/passagens/home');
})

module.exports = router;