# 学生信息管理系统（控制台版）

Java 实现的控制台学生信息管理程序，练习面向对象、集合、异常处理、JDBC 与 MySQL 数据库操作。

## 功能

- 添加学生（学号、姓名、性别、电话，空格分隔）
- 显示全部学生
- 按学号查找
- 按学号删除
- **数据持久化**：数据存储在 MySQL 数据库中，关掉程序不丢失

## 技术栈

- Java 21
- MySQL 8.0
- JDBC（`PreparedStatement`，参数化查询防注入）
- `ArrayList`、`Scanner`、字符串处理

## 数据库

数据库名 `student_db`，表结构：

```sql
CREATE TABLE student (
  id    VARCHAR(20) PRIMARY KEY COMMENT '学号',
  name  VARCHAR(50) NOT NULL        COMMENT '姓名',
  sex   CHAR(1)                     COMMENT '性别',
  phone VARCHAR(20)                 COMMENT '电话'
);
```

## 如何运行

1. 安装 MySQL 8.0，创建数据库 `student_db` 并执行上面的建表语句
2. 把 MySQL 驱动 `mysql-connector-java-8.0.29.jar` 放到项目根目录的 `lib/` 文件夹
3. 用 IntelliJ IDEA 打开项目，`Ctrl+Alt+Shift+S` → `Modules` → `Dependencies` → `+` → 选中 `lib` 目录
4. 修改 `MysqlStudentDao` 里的数据库地址、用户名和密码
5. 运行 `src/com/hnufe/contacts/Main.java`

> `lib/` 里的第三方 jar 不纳入版本管理，需要自行下载。

## 项目结构

```
src/com/hnufe/contacts/
├── Main.java              # 程序入口、菜单、各功能流程
├── Student.java           # 学生实体类
└── MysqlStudentDao.java   # 数据库访问：查询、新增、删除
```

## 待改进

- [ ] 抽象出 `StudentDao` 接口，便于切换实现
- [ ] 输入校验：输入非数字、字段缺失时的友好提示
- [ ] 根据学号修改学生信息
- [ ] 改造成 Spring Boot 的 REST 接口版本
