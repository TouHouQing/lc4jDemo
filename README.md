# LangChain4j Demo - AI-Powered College Admission Consultant

[中文版本](#中文版本) | [English Version](#english-version)

---

## English Version

### 📋 Project Overview

This is a Spring Boot application that demonstrates the integration of LangChain4j with various AI services to create an intelligent college admission consulting system. The application provides AI-powered guidance for Chinese high school students in their college application process, including university information queries, major recommendations, and one-on-one consultation booking services.

### 🚀 Key Features

- **AI-Powered Chat Interface**: Streaming chat responses using Alibaba Cloud's Qwen model
- **RAG (Retrieval-Augmented Generation)**: Enhanced responses using university information from PDF documents
- **Memory Management**: Persistent chat history using Redis
- **Tool Integration**: AI agent can perform actions like booking consultations
- **Vector Database**: Milvus integration for efficient document retrieval
- **Database Operations**: MySQL integration for storing reservation data

### 🛠 Technology Stack

- **Framework**: Spring Boot 3.5.4
- **AI Library**: LangChain4j 1.2.0-beta8
- **Language Model**: Alibaba Cloud Qwen (via OpenAI-compatible API)
- **Vector Database**: Milvus
- **Cache/Memory**: Redis
- **Database**: MySQL
- **ORM**: MyBatis
- **Build Tool**: Maven
- **Java Version**: 17

### 📁 Project Structure

```
src/main/java/com/touhouqing/lc4jDemo/
├── DemoApplication.java           # Main application entry point
├── aiservice/
│   └── ConsultantService.java     # AI service interface with LangChain4j annotations
├── config/
│   └── CommonConfig.java          # Configuration for AI components
├── controller/
│   └── ChatController.java        # REST API endpoints
├── mapper/
│   └── ReservationMapper.java     # MyBatis mapper for database operations
├── pojo/
│   └── Reservation.java           # Entity class for reservations
├── repository/
│   └── RedisChatMemoryStore.java  # Custom Redis-based chat memory store
├── service/
│   └── ReservationService.java    # Business logic for reservations
└── tools/
    └── ReservationTool.java       # AI tool for handling reservations
```

### 🔧 Configuration

The application requires the following environment variables:

- `BAILIAN-API-KEY`: Alibaba Cloud API key for Qwen model access
- `REDIS.PASSWORD`: Redis server password
- `MYSQL.PASSWORD`: MySQL database password

### 📊 Database Schema

The application uses a MySQL database with the following table:

```sql
CREATE TABLE reservation (
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT 'Primary Key',
    name VARCHAR(50) NOT NULL COMMENT 'Student Name',
    gender VARCHAR(2) NOT NULL COMMENT 'Student Gender',
    phone VARCHAR(20) NOT NULL COMMENT 'Student Phone',
    communication_time DATETIME NOT NULL COMMENT 'Communication Time',
    province VARCHAR(32) NOT NULL COMMENT 'Student Province',
    estimated_score INT NOT NULL COMMENT 'Estimated Score'
);
```

### 🚀 Getting Started

1. **Prerequisites**
   - Java 17 or higher
   - Maven 3.6+
   - MySQL 8.0+
   - Redis 6.0+
   - Milvus 2.0+ (optional, for vector storage)

2. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd lc4jDemo
   ```

3. **Set up environment variables**
   ```bash
   export BAILIAN-API-KEY=your_alibaba_cloud_api_key
   export REDIS.PASSWORD=your_redis_password
   export MYSQL.PASSWORD=your_mysql_password
   ```

4. **Initialize the database**
   ```bash
   mysql -u root -p < volunteer.sql
   ```

5. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

### 📡 API Endpoints

- **POST/GET** `/chat?memoryId={id}&message={message}`: Chat with the AI consultant
  - `memoryId`: Unique identifier for conversation memory
  - `message`: User's question or message
  - Returns: Streaming text response

### 🤖 AI Capabilities

The AI consultant can:

1. Query university information and admission requirements
2. Provide scholarship information
3. Describe campus facilities and accommodation
4. Share contact information for admissions
5. Analyze admission statistics for different majors
6. Recommend popular and challenging majors
7. Suggest suitable universities and majors based on scores
8. Book one-on-one consultation appointments
9. Query existing reservation details

### 📚 Document Processing

The system processes PDF documents containing university information stored in `src/main/resources/content/`. These documents are:
- Parsed using Apache PDFBox
- Split into chunks for better retrieval
- Embedded using Alibaba Cloud's text-embedding-v3 model
- Stored in Milvus vector database for efficient similarity search

---

## 中文版本

### 📋 项目概述

这是一个基于Spring Boot的演示应用程序，展示了LangChain4j与各种AI服务的集成，创建了一个智能高考志愿填报咨询系统。该应用为中国高中生提供AI驱动的大学申请指导，包括院校信息查询、专业推荐和一对一咨询预约服务。

### 🚀 核心功能

- **AI聊天界面**: 使用阿里云通义千问模型的流式聊天响应
- **RAG检索增强生成**: 使用PDF文档中的大学信息增强回答质量
- **记忆管理**: 使用Redis持久化聊天历史
- **工具集成**: AI代理可以执行预约咨询等操作
- **向量数据库**: Milvus集成实现高效文档检索
- **数据库操作**: MySQL集成存储预约数据

### 🛠 技术栈

- **框架**: Spring Boot 3.5.4
- **AI库**: LangChain4j 1.2.0-beta8
- **语言模型**: 阿里云通义千问 (通过OpenAI兼容API)
- **向量数据库**: Milvus
- **缓存/内存**: Redis
- **数据库**: MySQL
- **ORM**: MyBatis
- **构建工具**: Maven
- **Java版本**: 17

### 🔧 配置要求

应用程序需要以下环境变量：

- `BAILIAN-API-KEY`: 阿里云API密钥，用于访问通义千问模型
- `REDIS.PASSWORD`: Redis服务器密码
- `MYSQL.PASSWORD`: MySQL数据库密码

### 🚀 快速开始

1. **环境要求**
   - Java 17或更高版本
   - Maven 3.6+
   - MySQL 8.0+
   - Redis 6.0+
   - Milvus 2.0+ (可选，用于向量存储)

2. **克隆仓库**
   ```bash
   git clone <repository-url>
   cd lc4jDemo
   ```

3. **设置环境变量**
   ```bash
   export BAILIAN-API-KEY=你的阿里云API密钥
   export REDIS.PASSWORD=你的Redis密码
   export MYSQL.PASSWORD=你的MySQL密码
   ```

4. **初始化数据库**
   ```bash
   mysql -u root -p < volunteer.sql
   ```

5. **运行应用**
   ```bash
   ./mvnw spring-boot:run
   ```

### 📡 API接口

- **POST/GET** `/chat?memoryId={id}&message={message}`: 与AI顾问聊天
  - `memoryId`: 对话记忆的唯一标识符
  - `message`: 用户的问题或消息
  - 返回: 流式文本响应

### 🤖 AI功能

AI顾问可以：

1. 查询目标院校的院校简介
2. 查询目标院校的录取规则
3. 查询目标院校的奖学金设置状况
4. 查询目标院校的食宿条件
5. 查询目标院校招生联系方式
6. 查询目标院校2024年不同专业录取情况
7. 查询热门专业和天坑专业
8. 根据学生分数推荐合适的学校和专业
9. 提供高考志愿填报一对一沟通预约服务
10. 查询志愿指导服务预约详情

### 📚 文档处理

系统处理存储在`src/main/resources/content/`中的包含大学信息的PDF文档。这些文档会：
- 使用Apache PDFBox解析
- 分割成块以便更好地检索
- 使用阿里云text-embedding-v3模型进行向量化
- 存储在Milvus向量数据库中以实现高效的相似性搜索

### 🎯 使用场景

该系统特别适用于：
- 高考志愿填报咨询服务
- 教育机构的智能客服系统
- 大学招生信息查询平台
- AI驱动的教育咨询应用

### 📝 许可证

本项目仅用于学习和演示目的。

### 🤝 贡献

欢迎提交Issue和Pull Request来改进这个项目。

### 📞 联系方式

如有问题或建议，请通过GitHub Issues联系。
