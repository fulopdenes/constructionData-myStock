<a name="readme-top"></a>

# ConstructionData-MyStock
[//]: # (Due to the free service, the server does not work permanently, so you have to wait 2 minutes and 30 seconds after )
[//]: # (opening it for the first time. Public link: https://mystock-frontend.onrender.com/)

<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#description">Description</a>
    </li>
    <li>
      <a href="#motivation">Motivation</a>
    </li>
    <li><a href="#features">Features</a>
    <li><a href="#installation-guide--getting-started">Installation Guide & Getting Started</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#screenshots">Screenshots</a></li>
    <li><a href="#used-technologies">Used technologies</a></li>
    <li><a href="#configuration">Configuration</a></li>
    <li><a href="#contributing">Contributing</a></li>
     <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

## Description

This software provides a common work platform of companies in the construction industry. This program is very similar to Excel, but it optimized by construction conditions, examples:
 * for small screens -> bigger icons and fonts or just a relevant content shown;
<!--  * for slow internet -> precache data or offline mode; -->
 * when several companies must have access to one data -> common database access;

The server works through a free service provider, so it does not run permanently. After the first request, it starts and you need to wait approximately 150 ms. -> https://mystock-frontend.onrender.com !

Usually the construction stakeholders spend cca. 3 hours (38%) of their work time with administration . As an 
experienced civil engineer and programmer, I find a solution to reduce this to 2 hours (11% efficiency). By using 
this software, data can be recorded quickly. The platform will be available form office, construction 
site, or from the warehouse also. 

The application provides a user-friendly interface for interacting with the backend services and performing various
actions.
Explore the different pages and features to get a better understanding of the implemented functionalities.

This software can be used at the following cases:
1. Recording selected product parameters.
2. Ordering products.
3. Preparing reports of products.
4. Product status questions.
5. Handover products.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Motivation

The technology and knowledge are available, it's just a matter of time how we apply digital opportunities in the construction industry. I am part of this transformation.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Features
1. Data CRUD Operations
2. Search Functionality
3. Data Validation and Error Handling
4. Data Filtering and Sorting
5. Responsive Design
6. Data Export

#### Planned future functions:

7. Online/Offline caching data management
8. User Registration and Authentication 
9. User Profiles 
10. File Upload and Management 
11. Role-based Access Control 
12. Analytics and Reporting 
13. User Activity Logs 
14. Data Export - Excel, Pdf, Docx 
15. Intelligent Search Suggestions 
16. Activity Feeds 
17. Data Privacy and GDPR Compliance 
18. Geolocation Services 
19. Password Reset 
20. Email Notifications 
21. Localization and Internationalization 
22. Multi-language Support 
23. Automated Backup and Restore 
24. Ticketing System 
25. Caching and Performance Optimization 
26. Automated Testing 
27. Multi-factor Authentication

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Installation Guide & Getting Started

1. Fork the repository.
2. Navigate to the project directory: cd constructionData-myStock
3. Install dependencies for the backend:
   * Run `cd server` to enter the backend directory.
   * Run mvn install to install the required Java dependencies. `npm install`
4. Install dependencies for the frontend:
   * Run `cd client` to enter the frontend directory.
   * Run npm install to install the required dependencies. `npm install`
5. Database setup:
   * Make sure you have PostgreSQL installed and running.
   * Configure the database connection in the application.properties file located in the backend/src/main/resources
     directory.
   * Create the necessary database tables by running the provided SQL scripts in the database directory.
6. Start the backend server:
   * Run cd backend to enter the backend directory.
   * Run mvn spring-boot:run to start the Spring Boot server. `npm start`
7. Start the frontend development server:
   * Run cd frontend to enter the frontend directory.
   * Run npm start to start the React development server.
8. Open your web browser and access the application at http://localhost:3000

For contribution:

9. Create a new branch: git checkout -b feature/your-feature
10. Make your changes and commit them: git commit -am 'Add new feature'
11. Push to the branch: git push origin feature/your-feature
12. Submit a pull request.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Roadmap

- [x] Define purpose of this project. 

#### Frontend:
- [x] Implement navbar with react.
- [x] Set responsive parameters.
- [x] Create view mode at office page.
- [x] Create edit mode at office page.
- [x] Implement scroll bar with feature icons.
- [x] Setup proxy parameters and env. variables.
- [x] Deploy frontend part of the project with link. 
- [ ] Create login page.
- [ ] Test input fields with possible bad and good scenarios.
- [ ] Create profile section with user data edit features.
- [ ] Implement profile icon at navbar.
- [ ] Develop password reset option with email confirmation.
- [ ] Create a register page with user profile options.
- [ ] Create page with user activities.
- [ ] Add user names at tables for any new activity.
- [ ] Add notification handlers for buttons.
- [ ] Create scan file page.
- [ ] Add data export feature with pdf and docs file extensions.
- [ ] Implement autocomplete option for searchbar.
- [ ] Add Hungarian language for the project.
- [ ] Add language change possibilite option for profile section.
- [ ] Add multi-factor authentication option to registration page.
- [ ] Add backup option for administration user.
- [ ] Add notifications for related pages when program works offline.
- [ ] Create separate page for creating report.

#### Backend:
- [x] Define product model.
- [x] Create connection with database.
- [x] Define endpoints & test.
- [x] Deploy backend part of the project with link. 
- [ ] Test endpoints with possible scenarios.
- [ ] Implement security and authentication with token based solution.
- [ ] Implement user roles.
- [ ] Implement role-based access control.
- [ ] Test autentication process.
- [ ] Implement password reset endpoint.
- [ ] Create database for tracking user activites.
- [ ] Set hours based on locations.
- [ ] Implement GDPR settings.
- [ ] Create email notification services.
- [ ] Create scan file service.
- [ ] Implement automated test setup before production stage.
- [ ] Set multi-factor authentication service.
- [ ] Add restore and backup option for server side.
- [ ] Implement caching option for offline period.
- [ ] Implement report services.
- [ ] Add preload option for better performance.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Screenshots


In progress..
<!-- milyen szerkezete van a projektnek.?  -->

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Used Technologies

This fullstack project was developed using the following technologies and frameworks:

#### Backend:

* **Programming Language**: Java 17
* **Framework**: Spring Boot 3.1.0
* **Database**: PostgreSQL 15.1
* **API Development**: Spring Web
* **Authentication/Authorization**: -----. _(not implemented yet, planned to be Spring Security)_
* **Caching**: -----. _(not implemented yet, planned to be Caffeine Cache)_
* **Testing**: -----. _(not implemented yet, planned to be JUnit, Mockito)_
* **Deployment**: Docker, Render.com (Render.com - Web Services)

#### Frontend:

* **Framework/Library:**  React
* **JavaScript Version**: JavaScript ES6+
* **Styling**: CSS
* **State Management**: ----.  _(not implemented yet, planned to be Redux)_
* **Routing**: React Router
* **UI Components**: Material-UI
* **API Communication**: Fetch API
* **Testing**: ----.  _(not implemented yet, planned to be Jest, React Testing Library)_
* **Build/Bundle**: ----.  _(not implemented yet, planned to be Webpack)_
* **Deployment**: Docker, Render.com (Render.com - Static Site)


<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Configuration
Open the application.properties file located in [path/to/application.properties].

Configure the database connection settings by modifying the following properties:
* spring.datasource.url: [Database URL]
* spring.datasource.username: [Database username]
* spring.datasource.password: [Database password] 

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Contributing
Contributions are welcome! If you find any issues or want to enhance the project, feel free to submit a pull request.
Modify the code and customize the application according to your specific requirements.
Add new components, endpoints, or database models as needed to extend the application's functionality.
Please ensure that your changes are well-documented and tested.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## License
This project is licensed under the MIT License.
See the LICENSE file for more details.
MIT © Fülöp Dénes

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Contact

If you have any questions, suggestions, or feedback, please feel free to contact me at denes.fulopp@gmail.com.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Acknowledgments

* [MUI Services](https://mui.com/)
* [Swagger IO Services](https://swagger.io/)
* [Render.com Services](https://render.com/)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

