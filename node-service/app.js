// app.js
const express = require("express");
const app = express();
const port = 3000;

// 加载环境变量
require("dotenv").config();

// 中间件配置
app.use(express.json()); // 用于解析 JSON 格式的请求体
app.use(express.urlencoded({ extended: true })); // 用于解析 URL 编码的请求体

// 路由挂载
app.use("/api/teacher", require("./routes/teacher")); // 假设 teacher 路由定义在 routes 文件夹下

// 错误处理中间件
app.use((err, req, res, next) => {
  console.error(err.stack); // 打印错误堆栈信息
  res.status(500).send("服务器内部错误"); // 返回 500 错误响应
});

// 启动服务器
const server = app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});

// 导出 server 对象以便 Nacos 注册使用
module.exports = server;

// 在服务器启动后注册服务
const { registerService } = require("./nacos-register");
registerService(server);
