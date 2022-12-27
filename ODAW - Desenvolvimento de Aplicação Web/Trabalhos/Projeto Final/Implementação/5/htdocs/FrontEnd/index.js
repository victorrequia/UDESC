// Configurações
const express = require('express');
const exphbs = require('express-handlebars');
const bodyParser = require('body-parser')
const {ObjectId} = require('mongodb');

const app = express();
const port = 8000;

// Template engine
app.engine('handlebars', exphbs());
app.set('view engine', 'handlebars');
app.use(express.static('public'));
app.use(bodyParser.urlencoded({ extended: true }));

// Importação de rotas
const homepageRoutes = require('./routes/homepage');
const comprasRoutes = require('./routes/compras');
const contatoRoutes = require('./routes/contato');
const perfilRoutes = require('./routes/perfil');

// Rotas
app.get('/', async function (req, res) {
    const notes = await db.getDB().db().collection('passageiros').find({}).toArray();
    res.render('index', { notes });
});
app.use('/home', homepageRoutes);

app.get('/compras', async function (req, res) {
    res.render('./compras/home');
});
app.use('/compras', comprasRoutes);

app.get('/contato', async function (req, res){
    res.render('./contato/home');
})
app.use('/contato', contatoRoutes);

app.get('/perfil', async function (req, res){
    res.render('./perfil/home');
})
app.use('/perfil', perfilRoutes);

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