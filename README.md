# Gitlab-CI--ArgoCD-k8s
Creating a CI/CD pipeline using GitLab and Argo-CD and deploy it into kubernetes 

This project demonstrates how to use GitHub as the source code repository while leveraging GitLab CI/CD for continuous integration using GitLab shared (instance) runners.

The setup allows code changes pushed to GitHub to automatically trigger GitLab pipelines without migrating the repository.

🏗 Architecture Flow
Developer Push (GitHub)
        ↓
GitHub Webhook
        ↓
GitLab Pipeline Trigger API
        ↓
GitLab CI Pipeline
        ↓
GitLab Shared Runner (Docker Executor)

🛠 Tools & Technologies

Source Control: GitHub

CI/CD Platform: GitLab CI

Runners: GitLab Shared (Instance) Runners

Executor: Docker

OS: Linux

Container Image: Alpine

📂 Repository Structure
.
├── .gitlab-ci.yml
└── README.md

🔗 GitHub → GitLab Integration Steps
1️⃣ Create a GitLab Project (CI Only)

Created a blank GitLab project

No code stored in GitLab

Used only for CI/CD pipelines

2️⃣ Enable GitLab Instance (Shared) Runners

Path:

GitLab Project → Settings → CI/CD → Runners


Enabled “Turn on instance runners for this project”

Used GitLab-managed shared runners (no manual setup)

✔ Runners are automatically assigned
✔ No runner registration required

3️⃣ Create a Pipeline Trigger in GitLab

Path:

Settings → CI/CD → Pipeline triggers


Generated:

Trigger Token

Project ID

These are used by GitHub to trigger pipelines.

4️⃣ Configure GitHub Webhook

Path:

GitHub Repo → Settings → Webhooks → Add/Edit Webhook


Payload URL format:

https://gitlab.com/api/v4/projects/<PROJECT_ID>/trigger/pipeline?token=<TRIGGER_TOKEN>&ref=main


Settings:

Content-Type: application/json

Events: Push events

Active: ✅ Enabled





Docker Installation on EC2 (Amazon Linux 2023)

Update system:

sudo dnf update -y


Install Docker:

sudo dnf install -y docker


Start and enable Docker service:

sudo systemctl start docker
sudo systemctl enable docker














Problems Faced & Solutions
Problem	Cause	Solution
Git push rejected	Remote repo had commits not present locally	Used git push --force to overwrite
Docker installation failed	Amazon Linux 2023 does not have docker.io package	Installed Docker using dnf install docker
HTTPS push authentication fails	GitHub no longer supports username/password	Used Personal Access Token (PAT) or SSH key for authentication
EC2 reboot lost HTTPS credentials	Temporary credential cache lost	Switched to SSH authentication for permanent access
