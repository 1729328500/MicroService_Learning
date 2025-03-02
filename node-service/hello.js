const express = require("express");
const { NacosNamingClient } = require("nacos");
const app = express();
const port = 8085;

// 简单的日志记录器函数
function logger() {
  return {
    info: console.log.bind(console),
    error: console.error.bind(console),
    debug: console.debug.bind(console),
  };
}

// 修复后的 Nacos 配置
const nacosClient = new NacosNamingClient({
  serverList: "localhost:8848", // 或 ['localhost:8848']
  namespace: "", // 默认命名空间留空
  username: "nacos",
  password: "nacos",
  logger: logger(), // 提供一个简单的 logger 实例
});

// ... 其他代码

// 服务注册逻辑
async function registerService() {
  try {
    await nacosClient.ready();
    await nacosClient.registerInstance("node-service", {
      ip: "localhost",
      port: port,
      serviceName: "node-service", // 明确指定服务名
    });
    console.log("Node服务注册成功");
  } catch (err) {
    console.error("注册失败:", err);
  }
}

// 接口定义
app.get("/ask", (req, res) => {
  const question = req.query.question;
  const username =
    question.split("生成用户")[1].split("的欢迎语")[0] || "未知用户";
  res.send(`欢迎您，${username}！`);
});

// 启动服务
app.listen(port, async () => {
  console.log(`Node服务运行在 http://localhost:${port}`);
  await registerService();
});

// 优雅关闭
process.on("SIGINT", async () => {
  await nacosClient.deregisterInstance("node-service", "localhost", port);
  console.log("服务已注销");
  process.exit();
});
