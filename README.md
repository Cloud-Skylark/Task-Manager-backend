# ☁️ Cloudy Task Manager - Full Stack & CI/CD Project 🚀

![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen?style=for-the-badge&logo=jenkins)
![Quality Gate](https://img.shields.io/badge/SonarQube-Passed-success?style=for-the-badge&logo=sonarqube)
![Kubernetes](https://img.shields.io/badge/Kubernetes-Ready-blue?style=for-the-badge&logo=kubernetes)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=springboot)

✨ A modern, high-performance **Task Management Application** built with **Spring Boot** and a sleek **Glassmorphic UI**. This project is built to demonstrate enterprise-grade DevOps practices, including automated CI/CD pipelines, static code analysis, and production-ready container orchestration! 🎯

---

## 🔥 Key Features

* **🎨 Premium UI/UX:** Clean, responsive front-end using Glassmorphism design principles and CSS elevation.
* **⚡ Full CRUD Operations:** Seamlessly add, toggle status, and delete tasks asynchronously via the Fetch API.
* **💾 Data Persistence:** PostgreSQL database running securely within a Kubernetes Persistent Volume (PV/PVC).
* **🛡️ Enterprise Code Quality:** Integrated **SonarQube** for static code analysis and strict Quality Gate enforcement.
* **🤖 Fully Automated Pipeline:** **Jenkins** pipeline that builds, tests, containerizes, and deploys the application with zero manual intervention.

---

## 💻 Technology Stack

| Layer | Technology |
| :--- | :--- |
| **🎨 Frontend** | HTML5, CSS3, Vanilla JavaScript, FontAwesome |
| **⚙️ Backend** | Java 17, Spring Boot, Spring Data JPA |
| **🗄️ Database** | PostgreSQL 15 |
| **🐳 Containerization**| Docker (Multi-stage builds) |
| **🔄 CI/CD** | Jenkins, SonarQube |
| **☸️ Orchestration** | Kubernetes (Pods, Deployments, Services, PV, PVC) |

---

## 📁 Project Structure

```text
cloudy-task-manager/
├── 📁 src/main/              # ☕ Spring Boot Backend Code
├── 📁 frontend/              # 🌐 HTML, CSS, JS 
├── 🐳 Dockerfile             # 📦 Multi-stage Docker build file
├── 📜 Jenkinsfile            # 🤖 Jenkins CI/CD Pipeline definition
└── 📁 k8s/                   # ☸️ Kubernetes Manifests
    ├── 📁 postgres/          # 🗄️ Database PV, PVC, Service & Deployment
    └── 📁 app/               # 🚀 Spring Boot Service & Deployment
🏗️ Architecture & DevOps Workflow
This project implements a robust CI/CD workflow:

💻 Code Commit: Developer pushes code to the GitHub repository.

👷‍♂️ Continuous Integration (Jenkins): * Pulls the latest code.

Builds the application using Maven 🛠️.

Runs SonarQube Analysis 🔎 to ensure code quality. If bugs are found, the pipeline fails!

📦 Containerization: Docker builds a lightweight image and pushes it securely to Docker Hub.

🚢 Continuous Deployment (Kubernetes): Jenkins updates the K8s cluster, ensuring the Database is up, followed by a rolling update to the App pods.

🏠 How to Run Locally (Without K8s)
1. 🗄️ Database Setup
Create a PostgreSQL database named taskdb and update the application.properties file with your credentials.

2. 🚀 Run Backend

Bash
mvn clean install
mvn spring-boot:run
3. 🌐 Run Frontend
Simply open index.html in your favorite web browser or use a VS Code Live Server! 🎉

☸️ Kubernetes Deployment Details
To deploy this stack manually on your Ubuntu Kubernetes node:

1. 💽 Create the Local Directory for PV

Bash
sudo mkdir -p /mnt/data/postgres
sudo chmod 777 /mnt/data/postgres
2. 🗄️ Deploy the Database Layer

Bash
kubectl apply -f k8s/postgres/
3. 🚀 Deploy the Application Layer

Bash
kubectl apply -f k8s/app/
👨‍💻 Developed By
Badal Ahire 📱 Android Developer | 🎓 BCA Student | ☁️ DevOps Enthusiast

🔗 GitHub: Cloud-Skylark

🎮 YouTube: Cloudy Gaming

"Building scalable systems and clean interfaces." 🚀