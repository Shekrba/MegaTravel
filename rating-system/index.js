require('@google/cloud-debug');

const mysql = require('mysql');

const connectionName =
  process.env.INSTANCE_CONNECTION_NAME || 'megatravel-244015:us-central1:megatravelcloud';
const dbUser = process.env.SQL_USER || 'root';
const dbPassword = process.env.SQL_PASSWORD || '1234';
const dbName = process.env.SQL_NAME || 'megatravelcloud';

const mysqlConfig = {
  connectionLimit: 1,
  user: dbUser,
  password: dbPassword,
  database: dbName,
};

if (process.env.NODE_ENV === 'production') {
  mysqlConfig.socketPath = `/cloudsql/${connectionName}`;
}

let mysqlPool;

exports.getRatings = function getRezToRate(req, res) {
  
  res.header('Content-Type','application/json');
  res.header('Access-Control-Allow-Origin', "*")
  res.header('Access-Control-Allow-Methods', 'GET, POST')
  res.header('Access-Control-Allow-Headers', 'Content-Type');

  if (req.method === `OPTIONS`) {
    res.status(200).send();
    return;
  }

  if (!mysqlPool) {
    mysqlPool = mysql.createPool(mysqlConfig);
  }

  var sql = 'SELECT * FROM ocena o WHERE o.korisnik_id = '+req.body.korisnik_id;

  mysqlPool.query(sql, (err, results) => {
    if (err) {
      console.error(err);
      res.status(500).send(err);
    } else {  
      res.send(JSON.stringify(results));
    }
  });
};

exports.rateHotel = function rateHotel(req, res) {
  
  res.header('Content-Type','application/json');
  res.header('Access-Control-Allow-Origin', "*")
  res.header('Access-Control-Allow-Methods', 'GET, POST')
  res.header('Access-Control-Allow-Headers', 'Content-Type');

  if (req.method === `OPTIONS`) {
    res.status(200).send();
    return;
  }

  if (!mysqlPool) {
    mysqlPool = mysql.createPool(mysqlConfig);
  }

  var sql = 'INSERT INTO ocena (`vrednost`, `komentar`, `rezervacija_id`,`korisnik_id`, `smestaj_id`,`from`,`to`) VALUES ('+ req.body.vrednost +', "'+ req.body.komentar +'", '+ req.body.rezervacija_id +', '+ req.body.korisnik_id +', '+ req.body.smestaj_id +', "'+ req.body.from +'", "'+ req.body.to +'")'

  mysqlPool.query(sql, (err, results) => {
    if (err) {
      console.error(err);
      res.status(500).send(err);
    } else {
      res.status(200).send("INSERT SUCCESSFUL...");
    }
  });
};

exports.updateRating = function updateRating(req, res) {
  
  res.header('Content-Type','application/json');
  res.header('Access-Control-Allow-Origin', "*")
  res.header('Access-Control-Allow-Methods', 'GET, POST')
  res.header('Access-Control-Allow-Headers', 'Content-Type'); 

  if (req.method === `OPTIONS`) {
    res.status(200).send();
    return;
  }

  if (!mysqlPool) {
    mysqlPool = mysql.createPool(mysqlConfig);
  }

  var sql = 'UPDATE ocena SET vrednost = '+ req.body.vrednost +', komentar = "'+ req.body.komentar +'" WHERE ocena_id ='+ req.body.ocena_id

  mysqlPool.query(sql, (err, results) => {
    if (err) {
      console.error(err);
      res.status(500).send(err);
    } else {
      res.status(200).send("UPDATE SUCCESSFUL...");
    }
  });
};