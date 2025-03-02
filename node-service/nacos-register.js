// nacos-register.js
const { NacosNamingClient } = require("nacos");
const nacosConfig = {
  serverList: "127.0.0.1:8848", // Nacos服务器地址
  namespace: "public", // 命名空间（默认public）
  username: "nacos",
  password: "nacos",
};
const serviceName = "node-service"; //服务名称
const groupName = "DEFAULT_GROUP"; // 默认分组

// 创建Nacos客户端实例
const client = new NacosNamingClient({
  ...nacosConfig,
  logger: console, // 可选日志配置
});

// 注册服务
async function registerService(server) {
  await client.ready();
  try {
    const address = server.address();
    const port = address.port; // 获取端口号
    await client.registerInstance(
      serviceName,
      {
        ip: address.address, // 服务IP（若远程需改为实际IP）
        port: port, // 服务端口
        cluster: "DEFAULT", // 群名
        healthy: true,
        metadata: {
          // 新增元数据配置
          healthCheckPath: "/api/teacher", // 健康检查路径
          version: "1.0.0",
          protocol: "HTTP",
        },
      },
      groupName
    );
    console.log("服务成功注册！");
  } catch (err) {
    console.error("服务注册失败:", err);
    process.exit(1);
  }
}

// 注销服务
async function deregisterService(server) {
  try {
    const address = server.address();
    const port = address.port;
    await client.deregisterInstance(
      serviceName,
      {
        ip: address.address,
        port: port,
      },
      groupName
    );
    console.log("服务已注销");
  } catch (err) {
    console.error("服务注销失败:", err);
  }
}

// 处理优雅关闭
process.on("SIGINT", async () => {
  await deregisterService(server);
  server.close(() => {
    console.log("服务器已关闭");
    process.exit();
  });
});

module.exports = { registerService, deregisterService };
