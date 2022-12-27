const Router = require('express').Router;
const db = require('../db/connection');
const {ObjectId} = require('mongodb');

const router = Router();

// View de detalhes do passageiro
router.get('/:id', async function(req, res){
    const id = new ObjectId(req.params.id);

    const passageiro = await db.getDB().db().collection('passageiros').findOne({_id: id});
    const passagem = await db.getDB().db().collection('passagens').findOne({idpassageiro: req.params.id});
    voo = null;
    idvoo = null;
    
    if(passagem){
        idvoo = new ObjectId(passagem.idvoo);
        voo = await db.getDB().db().collection('voos').findOne({_id: idvoo});
    }

    res.render('passageiros/detail', {passageiro, passagem, voo});
})

// Receber todos os passageiros
router.get('/', function(req, res) {
    res.render('passageiros/create');
});

// Envio do passageiro para inserção no banco
router.post('/', function(req, res){
    const data = req.body;
    const nome = data.nome;
    const aero_coin = data.coins;
    const email = data.email;
    const telefone = data.telefone;

    db.getDB()
    .db()
    .collection('passageiros')
    .insertOne({nome: nome, coins: aero_coin, email: email, telefone: telefone});

    res.redirect(301, '/');
})

// View de edição de passageiro
router.get('/edit/:id', async function(req, res){
    const id = new ObjectId(req.params.id);

    const passageiro = await db.getDB().db().collection('passageiros').findOne({_id: id});

    res.render('passageiros/edit', {passageiro});
})

// Edição de passageiros
router.post('/update', function(req, res){
    const data = req.body;
    const id = new ObjectId(data.id);
    const nome = data.nome;
    const coins = data.coins;
    const email = data.email;
    const telefone = data.telefone;

    db.getDB()
    .db()
    .collection('passageiros')
    .updateOne({_id: id}, {$set: {nome: nome, coins: coins, email: email, telefone: telefone}})

    res.redirect('/');
})


// Remoção do passageiro
router.post('/delete', function (req, res){
    const data = req.body;
    const id = new ObjectId(data.id);

    db.getDB()
    .db()
    .collection('passageiros')
    .deleteOne({_id: id})

    res.redirect(301, '/');
})

module.exports = router;