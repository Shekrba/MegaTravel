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

exports.getRatings = function getRatings(req, res) {
  
  if (!mysqlPool) {
    mysqlPool = mysql.createPool(mysqlConfig);
  }

  mysqlPool.query('SELECT * FROM ocena o LEFT OUTER JOIN rezervacija r ON o.rezervacija_id=r.id', (err, results) => {
    if (err) {
      console.error(err);
      res.status(500).send(err);
    } else {
      res.send(JSON.stringify(results));
    }
  });
};

exports.getRezToRate = function getRezToRate(req, res) {
  
  if (!mysqlPool) {
    mysqlPool = mysql.createPool(mysqlConfig);
  }

  var sql = 'SELECT * FROM rezervacija r LEFT OUTER JOIN ocena o on r.id = o.rezervacija_id WHERE r.do <= NOW() AND r.korisnik_id = '+req.body.korisnik_id;

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
  
  if (!mysqlPool) {
    mysqlPool = mysql.createPool(mysqlConfig);
  }

  var sql = 'INSERT INTO ocena (vrednost, rezervacija_id, komentar) VALUES ('+ req.body.vrednost +', '+ req.body.rezervacija_id +', "'+ req.body.komentar +'")'

  mysqlPool.query(sql, (err, results) => {
    if (err) {
      console.error(err);
      res.status(500).send(err);
    } else {
      res.send(JSON.stringify("INSERTED INTO OCENA... " + req.body));
    }
  });
};

exports.getUserRatings = function getUserRatings(req, res) {
  
  if (!mysqlPool) {
    mysqlPool = mysql.createPool(mysqlConfig);
  }

  var sql = 'SELECT * FROM ocena o LEFT OUTER JOIN rezervacija r ON o.rezervacija_id=r.id where r.korisnik_id='+req.body.korisnik_id

  mysqlPool.query(sql, (err, results) => {
    if (err) {
      console.error(err);
      res.status(500).send(err);
    } else {
      res.send(JSON.stringify(results));
    }
  });
};

exports.updateRating = function updateRating(req, res) {
  
  if (!mysqlPool) {
    mysqlPool = mysql.createPool(mysqlConfig);
  }

  var sql = 'UPDATE ocena SET vrednost = '+ req.body.vrednost +', komentar = "'+ req.body.komentar +'" WHERE id ='+ req.body.id

  mysqlPool.query(sql, (err, results) => {
    if (err) {
      console.error(err);
      res.status(500).send(err);
    } else {
      res.send(JSON.stringify("UPDATED OCENA TO VALUE: "+req.body.vrednost+" WITH ID: "+req.body.id+"..."));
    }
  });
};