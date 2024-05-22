# Citizen Management Application

This is a simple Java application for managing citizen records using a PostgreSQL database.

## Prerequisites

- Docker installed on your system to run the PostgreSQL database using Docker Compose.
- JDK (Java Development Kit) installed on your system to run the Java application.

## Setup

1. Clone this repository to your local machine.

2. Navigate to the root directory of the project.

3. Start the PostgreSQL database using Docker Compose:
    ```
    docker-compose up -d
    ```

   This command will start the PostgreSQL database container in the background.

4. Build the Java application using Gradle:
    ```
    ./gradlew build
    ```

## Running the Application

1. After starting the PostgreSQL database, you can run the Java application to interact with the database.

2. Run the Java application using Gradle:
    ```
    ./gradlew run
    ```

3. Follow the on-screen prompts to perform various operations such as reading, adding, updating, or deleting citizen entries.

## Stopping the Application

1. To stop the Java application, simply terminate the process by pressing `Ctrl + C` in the terminal where it is running.

2. To stop the PostgreSQL database, run:
    ```
    docker-compose down
    ```

   This command will stop and remove the PostgreSQL database container.

## Notes

- Make sure to replace placeholder values such as database credentials (`your_database_name`, `your_username`, `your_password`) with your actual database details.

- Ensure that the PostgreSQL database is running before starting the Java application, as the application depends on the database to function properly.
