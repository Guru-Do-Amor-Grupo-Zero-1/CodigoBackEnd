# Etapa 1: Build da aplicação
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copia o arquivo pom.xml e baixa as dependências
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código-fonte e compila o projeto
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Criar a imagem final
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copia o JAR gerado na etapa anterior
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
