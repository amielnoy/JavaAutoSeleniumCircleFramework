# Use the Selenium Standalone Chromium image as the base
FROM selenium/standalone-chromium:latest

# Set the working directory inside the container
WORKDIR /usr/src/app

# Install necessary tools
RUN apt-get update && apt-get install -y  wget unzip && apt-get clean

# Install Gradle
ARG GRADLE_VERSION=8.5
RUN wget https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip \
    && unzip gradle-${GRADLE_VERSION}-bin.zip -d /opt/gradle \
    && rm gradle-${GRADLE_VERSION}-bin.zip
ENV GRADLE_HOME /opt/gradle/gradle-${GRADLE_VERSION}
ENV PATH ${GRADLE_HOME}/bin:${PATH}

# Copy the project files into the container
COPY . .

# Download dependencies
RUN gradle build --no-daemon -x test

# Run the tests
CMD ["gradle", "test", "--no-daemon"]