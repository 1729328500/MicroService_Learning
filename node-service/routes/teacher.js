const express = require("express");
const router = express.Router();
const pool = require("../config/db");

// 查询所有教师
router.get("/", async (req, res) => {
  try {
    const [rows] = await pool.query("SELECT * FROM teacher");
    res.json(rows);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// 创建教师
router.post("/", async (req, res) => {
  const { name } = req.body;
  if (!name) {
    return res.status(400).json({ error: "教师名称不能为空" });
  }

  try {
    const [result] = await pool.query("INSERT INTO teacher (name) VALUES (?)", [
      name,
    ]);
    res.status(201).json({ id: result.insertId });
  } catch (err) {
    res.status(400).json({ error: err.message });
  }
});

// 更新教师
router.put("/:id", async (req, res) => {
  const { id } = req.params;
  const { name } = req.body;
  if (!name) {
    return res.status(400).json({ error: "教师名称不能为空" });
  }

  try {
    await pool.query("UPDATE teacher SET name = ? WHERE id = ?", [name, id]);
    res.json({ message: "更新成功" });
  } catch (err) {
    res.status(400).json({ error: err.message });
  }
});

// 删除教师
router.delete("/:id", async (req, res) => {
  const { id } = req.params;

  try {
    await pool.query("DELETE FROM teacher WHERE id = ?", [id]);
    res.json({ message: "删除成功" });
  } catch (err) {
    res.status(400).json({ error: err.message });
  }
});

module.exports = router;
