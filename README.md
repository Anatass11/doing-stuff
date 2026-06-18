# doing-stuff
Тут у меня мини проекты.
Список таков:
1) Авто решалка японских сканвордов
2) 2048
3) Скрипты для всякого

В планах:
1) Сделать всё через Spring
2) Использовать Docker (compose)
3) Использовать K8s

Пока как то так

# Собрать все образы
docker-compose build

# Запустить все сервисы
docker-compose up -d

# Просмотреть логи
docker-compose logs -f

# Остановить
docker-compose down

# Пересобрать и запустить
docker-compose up -d --build

# Создать namespace
kubectl create namespace my-apps

# Применить все манифесты
kubectl apply -f k8s/

# Проверить статус
kubectl get pods -n my-apps
kubectl get services -n my-apps

# Просмотреть логи
kubectl logs -f deployment/mini-project-a -n my-apps

# Масштабирование
kubectl scale deployment mini-project-a --replicas=3 -n my-apps

# Обновление образа
kubectl set image deployment/mini-project-a mini-project-a=myregistry/mini-project-a:v2 -n my-apps

# Создать Helm chart
helm create my-app-chart

# Установить
helm install my-app ./my-app-chart -n my-apps

# Обновить
helm upgrade my-app ./my-app-chart -n my-apps

# Makefile
.PHONY: build push deploy

build:
docker-compose build

push:
docker tag mini-project-a myregistry/mini-project-a:latest
docker push myregistry/mini-project-a:latest

и т.д. для всех проектов

deploy-k8s:
kubectl apply -f k8s/

update:
kubectl rollout restart deployment -n my-apps

logs:
kubectl logs -f deployment/mini-project-a -n my-apps

status:
kubectl get all -n my-apps


# Чек-лист для продакшена
Добавить healthcheck во все сервисы

Настроить логирование в ELK или Loki

Добавить мониторинг (Prometheus + Grafana)

Настроить SSL/TLS через cert-manager

Использовать приватный registry (Docker Hub, Harbor)

Добавить CI/CD (GitHub Actions, GitLab CI)

Настроить автогенерацию документации (Swagger)
