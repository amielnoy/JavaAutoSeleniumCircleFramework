# Use the official OpenJDK image as a base
FROM markhobson/maven-chrome:jdk-17

# Install necessary packages and dependencies for Chrome
RUN apt-get update && apt-get install -y \
    wget \
    gnupg \
    unzip \
    xvfb \
    libxi6 \
    libgconf-2-4 \
    libxss1 \
    libappindicator1 \
    libindicator7 \
    libnss3 \
    libgbm1 \
    libasound2 \
    fonts-liberation \
    && rm -rf /var/lib/apt/lists/*


# Install Chrome
#RUN wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb \
#    && apt-get update \
#    && apt-get install -y ./google-chrome-stable_current_amd64.deb \
#    && rm google-chrome-stable_current_amd64.deb \
#    && rm -rf /var/lib/apt/lists/*

# Install ChromeDriver
RUN CHROME_DRIVER_VERSION=$(wget -qO- https://chromedriver.storage.googleapis.com/LATEST_RELEASE) \
    && wget -q "https://chromedriver.storage.googleapis.com/${CHROME_DRIVER_VERSION}/chromedriver_linux64.zip" \
    && unzip chromedriver_linux64.zip -d /usr/local/bin/ \
    && rm chromedriver_linux64.zip

# Install Gradle
ARG GRADLE_VERSION=8.5
RUN wget https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip \
    && unzip gradle-${GRADLE_VERSION}-bin.zip -d /opt/gradle \
    && rm gradle-${GRADLE_VERSION}-bin.zip
ENV GRADLE_HOME /opt/gradle/gradle-${GRADLE_VERSION}
ENV PATH ${GRADLE_HOME}/bin:${PATH}

# Set the working directory
WORKDIR /app

# Copy the project files
COPY . .

# Run the tests
CMD ["gradle", "test"]