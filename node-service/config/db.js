// db.js
const mysql = require("mysql2/promise");
require("dotenv").config();

// 创建 MySQL 连接池
const pool = mysql.createPool({
  host: process.env.DB_HOST, // 数据库主机地址
  user: process.env.DB_USER, // 数据库用户名
  password: process.env.DB_PASSWORD, // 数据库密码
  database: process.env.DB_NAME, // 数据库名称
  waitForConnections: true, // 等待连接
  connectionLimit: 10, // 最大连接数
  queueLimit: 0, // 队列限制
});

// 导出连接池
module.exports = pool;
