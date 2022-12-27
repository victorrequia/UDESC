const Router = require('express').Router;
const db = require('../db/connection');
const {ObjectId} = require('mongodb');

const router = Router();

// View de detalhes do passageiro
router.get('/:id', async function(req, res){
    const id = new ObjectId(req.params.id);

    const voo = await db.getDB().db().collection('voos').findOne({_id: id});

    res.render('voos/detail', {voo});
})

// Receber todos os voos
router.get('/', function(req, res) {
    res.render('voos/create');
});

// Envio de voo para inserção no banco
router.post('/', function(req, res){
    const data = req.body;
    const dia = data.dia;
    const origem = data.origem;
    const destino = data.destino;
    const disponiveis = data.disponiveis;
    const codigo = data.codigo;

    db.getDB()
    .db()
    .collection('voos')
    .insertOne({dia: dia, origem: origem, destino: destino, disponiveis: disponiveis, codigo: codigo});

    res.redirect(301, '/voos/home');
})

// View de edição de voos
router.get('/voos/edit/:id', async function(req, res){
    const id = new ObjectId(req.params.id);

    const voo = await db.getDB().db().collection('voos').findOne({_id: id});

    res.render('voos/edit', {voo});
})

// Edição de voos
router.post('/update', function(req, res){
    const data = req.body;
    const id = new ObjectId(data.id);
    const dia = data.dia;
    const origem = data.origem;
    const destino = data.destino;
    const disponiveis = data.disponiveis;
    const codigo = data.codigo;

    db.getDB()
    .db()
    .collection('voos')
    .updateOne({_id: id}, {$set: {dia: dia, origem: origem, destino: destino, disponiveis: disponiveis, codigo: codigo}})

    res.redirect('/voos/home');
})

// Remoção do voo
router.post('/voos/delete', function (req, res){
    const data = req.body;
    const id = new ObjectId(data.id);

    db.getDB()
    .db()
    .collection('voos')
    .deleteOne({_id: id})

    res.redirect(301, '/voos/home');
})

module.exports = router;