# Use the Selenium Standalone Chromium image as the base
FROM --platform=linux/arm64 selenium/standalone-chromium:latest

# Set the working directory inside the container
WORKDIR /usr/src/app

# Switch to root to install necessary tools
USER root

# Install necessary tools
RUN apt-get update && apt-get install -y --no-install-recommends \
    wget \
    unzip \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Install Gradle
ARG GRADLE_VERSION=8.5
RUN wget https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip \
    && unzip gradle-${GRADLE_VERSION}-bin.zip -d /opt/gradle \
    && rm gradle-${GRADLE_VERSION}-bin.zip
ENV GRADLE_HOME=/opt/gradle/gradle-${GRADLE_VERSION}
ENV PATH=${GRADLE_HOME}/bin:${PATH}

# Switch back to the selenium user
USER seluser

# Copy the project files into the container
COPY --chown=seluser:seluser . .

# Download dependencies
RUN gradle build --no-daemon -x test

# Run the tests
CMD ["gradle", "test", "--no-daemon"]