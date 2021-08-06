# Missing Person Tracking API

An API for reporting and tracking sightings of missing people, built with Spring Boot and PostgreSQL.

![build-pending](https://img.shields.io/badge/build-pending-yellow) ![release-v0.1](https://img.shields.io/badge/release-v0.5-blue) ![dependencies-up-to-date](https://img.shields.io/badge/dependencies-up%20to%20date-green)

# Features

- View all missing person reports.

- View all sightings

- Upload reports of missing people.

- Report sightings of missing people, with optional image upload.

- Edit missing person and sighting reports.

# Getting Started

## Prerequisites

- [Java JDK 8+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [PostgreSQL 13+](https://www.postgresql.org/download/)
- Any Java IDE, such as [IntelliJ](https://www.jetbrains.com/idea/download/#section=windows)

## Local Installation

1. Download and open the folder in an IDE.

2. Navigate to TrackingSystemApplication.java and run it.

3. Using CURL or an HTTP client like Postman, send GET, POST, or PUT requests to one of the URI's below to access the API.

### Endpoints

- http://localhost:8080/api/missing - GET request to view all missing person reports. POST/PUT to insert/update a report.

- http://localhost:8080/api/sightings - GET request to view all sightings. POST/PUT to insert/update sightings.
