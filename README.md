# ECUTAP E-Commerce UI Test Automation Framework

This repository contains a professional BDD (Behavior-Driven Development ) test automation framework built to validate the core functionalities and security boundaries of an e-commerce platform.

## Tech Stack & Architecture 
- **Language:** Java 17
- **Automation Tool:** Selenium WebDriver (v4.25.0)
- **BDD FrameWork:** Cucumber Java & JUnit
- **Build Tool:** Maven
- **Design Pattern:** Page Object Model (POM) & Singleton Driver Pattern
- **Project Management:** Agile/Scrum processes managed via Jira & Zephyr

## Executed Test Scenarios
1. **TC-001 (Positive):** End-to-End Successful Purchase Flow (8/8 steps PASSED)
2. **TC-002 (Negative):** Block Login with Invalid Credentials and verify error messages (3/3 steps PASSED)

## Reporting & Agile Traceability
- **Local Execution Reports:** Interactive **Cucumber HTML Reports** are automatically generated under the `target/` directory after each test execution to provide deep technical insights into step-by-step validations.
- **Enterprise QA Artifacts:** To ensure compliance with professional Agile/Scrum disciplines, the official execution metrics have been exported from **SmartBear Test Management (Zephyr)** and attached inside the `/reports` directory:
    - `Sprint1_UI_Regression_Report.pdf`: A comprehensive corporate test execution summary featuring visual metric charts (Pie-Charts) that confirm a 100% success rate (**PASSED**) for both `TC-001` and `TC-002`, fully cross-referenced with Jira issue `ECUTAP-1`.


## Sprint 2: Backend API Test Automation (Postman & Newman)
 In second sprint, we shifted our focus to backend validation by automating REST API endpoints (ReqRes simulation) to ensure data integrity and lightning-fast backend response times.
 
## API Tech Stack 
- **API Tooling:** Postman (Manual & Script Verification)
- **Automation Execution:** Newman CLI (Commad Line Interface)
- **CI/CD Readliness:** Automated using Node.js environment variables.
- **Reporting:** Advanced HTML Reporting via 'newman-reporter-htmlextra'.

## API Automation Test Results (5/5 Assertions PASSED)
- **TC-API-001 (GET List Users):** Status 200 OK verified, response time <1000ms, pagination logic checked.
- **TC-API-002 (POST Create User):** Status 201 Created verified, payload data reflection tested.
- All automation artifacts, environment variables, and execution cycle results are tracked back and linked to Jira user stroies using **Zephyr Squad Traceability Matrices**.