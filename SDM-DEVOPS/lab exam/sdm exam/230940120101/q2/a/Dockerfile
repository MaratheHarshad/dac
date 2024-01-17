# pull jdk 11
FROM openjdk:11
# copy current directory content to /myapp
COPY . /myapp
# set working directory as /myapp
WORKDIR /myapp
# compile while image is creating
RUN javac Main.java
# cmd to execute while executing container
CMD ["java", "Main"]