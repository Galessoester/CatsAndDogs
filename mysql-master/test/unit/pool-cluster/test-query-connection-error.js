var assert = require('assert');
var common = require('../../common');

var cluster = common.createPoolCluster();
var server  = common.createFakeServer();

server.listen(0, function (err) {
  assert.ifError(err);

  var poolConfig = common.getTestConfig({port: server.port()});
  cluster.add('SLAVE1', poolConfig);

  var pool = cluster.of('SLAVE*', 'ORDER');

  pool.query('SELECT 1', function (err) {
    assert.ok(err, 'got error');
    assert.equal(err.code, 'ER_ACCESS_DENIED_ERROR');
    server.destroy();
  });
});

server.on('connection', function (conn) {
  conn.deny();
});
