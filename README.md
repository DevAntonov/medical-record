# Medical Record System

## General Description

This project is a web-based application designed to manage medical records of patients in a structured and accessible way. Built using Spring Boot and RESTful web services, it allows users to handle medical data such as patient information, doctor records, medical examinations, diagnoses, treatments, and sick leaves.

The application provides role-based access control:
- **Patients** can view their own medical history.
- **Doctors** can view information for all patients but can only edit data related to their own examinations.
- **Administrators** have full access to view and manage all system data.

It supports key functionalities such as:
- Tracking patient health history
- Assigning general practitioners
- Diagnosing and prescribing treatments
- Issuing and tracking sick leaves
- Viewing various statistical and administrative reports

The system ensures data validation, exception handling, unit testing, and user management, aiming to deliver a secure and efficient healthcare data platform.
