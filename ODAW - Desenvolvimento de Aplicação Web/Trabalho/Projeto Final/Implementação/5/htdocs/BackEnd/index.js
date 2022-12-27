// Configurações
const express = require('express');
const exphbs = require('express-handlebars');
const bodyParser = require('body-parser')
const {ObjectId} = require('mongodb');

const app = express();
const port = 8001;

// Template engine
app.engine('handlebars', exphbs());
app.set('view engine', 'handlebars');
app.use(express.static('public'));
app.use(bodyParser.urlencoded({ extended: true }));

// Importação de rotas
const passageirosRoutes = require('./routes/passageiros');
const voosRoutes = require('./routes/voos');
const passagensRoutes = require('./routes/passagens');

// Rotas
app.get('/', async function (req, res) {
    const notes = await db.getDB().db().collection('passageiros').find({}).toArray();
    res.render('home', { notes });
});
app.use('/passageiros', passageirosRoutes);

app.get('/voos/home', async function (req, res) {
    const reservas = await db.getDB().db().collection('voos').find({}).toArray();
    res.render('./voos/home', {reservas});
});
app.use('/voos', voosRoutes);

app.get('/passagens/home', async function (req, res) {
    const reservas = await db.getDB().db().collection('passagens').find({}).toArray();
    res.render('./passagens/home', {reservas});
});
app.use('/passagens', passagensRoutes);

// DB
const db = require('./db/connection')

// Iniciando banco de dados
db.initDB((err, db) => {
    if (err) {
        console.log(err);
    } else {
        console.log('O banco conectou com sucesso!')
        app.listen(port, () => {
            console.log(`Projeto rodando na porta: ${port}`);
        });
    }
})