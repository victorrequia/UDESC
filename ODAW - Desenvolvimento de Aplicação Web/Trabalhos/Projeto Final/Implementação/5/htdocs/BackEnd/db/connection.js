const {MongoClient} = require('mongodb');
const url = "mongodb://127.0.0.1:27017/aero";

let _db;

const initDB = cb => {
    MongoClient.connect(url, {useUnifiedTopology: true})
        .then(client => {
            _db = client
            cb(null, _db);
        })
        .catch(err => {
            cb(err);
        });
}

const getDB = () => {
    return _db;
}

module.exports = {
    initDB,
    getDB
}