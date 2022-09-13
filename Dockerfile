FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=headhunter_find_job_bot
ENV BOT_TOKEN=5671649090:AAHhTesINbG8Jgljrp-AN-EaTrHpc1fDJtU
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]
