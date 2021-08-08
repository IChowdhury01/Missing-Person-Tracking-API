# Missing Person Tracking API

An API for reporting and tracking sightings of missing people, built with Spring Boot and PostgreSQL/H2.

![build-complete](https://img.shields.io/badge/build-complete-green) ![release-v0.1](https://img.shields.io/badge/release-v1.0-blue) ![dependencies-up-to-date](https://img.shields.io/badge/dependencies-up%20to%20date-green)

# Features

- View all people reported missing.

- View all sightings, with photos

- Report missing people.

- Report sightings of missing people, with optional image upload.

- Edit missing person and sighting reports.

# Getting Started

## Prerequisites

- [Java Runtime Environment 8+](https://www.java.com/en/download/manual.jsp)
- [PostgreSQL 13+](https://www.postgresql.org/download/) (Optional)
- Any HTTP client, like [Postman](https://www.postman.com/downloads/)

## Installation

1. If you want to use a PostgreSQL server instead of H2: download and install PostgreSQL. Then enter your database configuration in the /src/resources/application.properties file, and build a new .JAR file.

2. Download the .JAR file for this project from the releases tab.

3. Open a command prompt and navigate to the directory of the .JAR file.

4. `java -jar TrackingSystem-0.0.1-SNAPSHOT.jar`

5. After running the .JAR, use an HTTP client to send GET, POST, or PUT requests to the endpoints below.

# Usage

### Endpoints

- http://localhost:8080/api/missing
    - `GET` to view all missing people
    - `POST` to report a missing person
- http://localhost:8080/api/missing/{id}
    - `PUT` to edit a missing person report
- http://localhost:8080/api/sightings
    - `GET` to view all sightings
    - `POST` to report a sighting
- http://localhost:8080/api/sightings/{id}/image/upload
    - `POST` to upload a sighting photo
- http://localhost:8080/api/sightings/{id}
    - `PUT` to edit a sighting report

**Note:** PUT requests and photo upload POST requests must be sent as multi-part forms. The rest can be sent as raw JSONs.

### JSON Syntax

```
Missing People
{
    "reporterName": "...",
    "name": "...",
    "description": "..."
}

Sightings
{
  "reporterName": "...",
  "imgPath": "./src/main/resources/images/...",
  "comments": "..."
}

```
