<a name="readme-top"></a>

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/minvoo/iteis">
    <img src="src/main/resources/static/assets/img/logo.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">ITEIS</h3>

  <p align="center">
    IT Equipment Inventory System
    <br />
    <a href="https://github.com/minvoo/iteis"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="#" style="color: red;font-weight: bold"><s>View live Demo - not available yet</s></a>
    ·
    <a href="https://github.com/minvoo/iteis/issues">Report Bug</a>
    ·
    <a href="https://github.com/minvoo/ITEIS/issues/new">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#rest-api">REST API</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->

## About The Project

[![Product Name Screen Shot][product-screenshot]](https://github.com/minvoo/iteis)

ITEIS is small project for SDAxCodecool's recruitment, that allows you to add employees and assign some devices to them.
Every employee has it's own profile. System has two different roles - Admin and User.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

* [![Spring][SpringBoot]][Spring-url]
* [![Hibernate][HibernateSite]][Hibernate-url]
* [![Java][JavaSite]][Java-url]
* [![HTML][HTMLSite]][HTML-url]
* [![CSS][CSSSite]][CSS-url]
* [![Thymeleaf][ThymeleafSite]][Thymeleaf-url]
* [![MySQL][MysqlSite]][Mysql-url]
* [![Bootstrap][Bootstrap.com]][Bootstrap-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->

## Getting Started

### Live Demo

1. <a href="#" style="color: red;font-weight: bold"><s>Try live demo here</s></a> (not available yet)

* Admin password

```
username: administrator
password: 12345678
```

### Prerequisites

To run app locally:

* Database setup
  ```sh
  schema name: iteis
  user db name: iteis
  password: iteis
  ```

* Default server port
    ```
  server.port = 8081
  ```

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/minvoo/iteis.git
   ```

2. Make new MySQL user with data provided above
* or change the data in `application.properties` file (<b>only if you run in IntellijIDEA or any other Java IDE</b>)

3. <b>If you don't have IDE</b> - Navigate to project folder and run the jar file and run it.
```
cd path/to/project_folder/taget
java -jar iteis-1.0.0-RELEASE.jar
```

4. Open your browser and access the page
```
localhost:8081
```

5. After first run change``application.properties`` property <br>from ``spring.jpa.hibernate.ddl-auto=create`` 
<br>to ``spring.jpa.hibernate.ddl-auto=create``

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->

## Usage

### User stories
Users can:
* Login or register
* Check own profile info
* Change password
* Check what devices are assigned to  them

* Administrator can:
* Create new user
* Change user details
* Delete user (assigned devices still persist in database)
* Change user role (from admin to user and vice versa)
* Add new devices (computers, mobiles and printers) and assign them to specific user
* Edit devices (computers, mobiles and printers)
* Delete devices 
* List all users
* List all devices (computers, mobiles and printers)
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTING -->

## REST-API
Full documentation with all available API endpoints available <a href="http://localhost:8081/swagger-ui/">here</a> (if you are running the app at localhost) or <a href="http://iteis.herokuapp.com/swagger-ui/">here</a> (if you are running the app on live demo)

Sample API calls to perform <s>(replace ``%host%`` with ``localhost:8081`` or ``iteis.herokuapp.com`` accordingly to the type of server you are working with.</s>
```
localhost:8081/api/authentication/sign-up
localhost:8081/api/authentication/sign-in

localhost:8081/api/employees
localhost:8081/api/employees/list
localhost:8081/api/employees/details/{id}
localhost:8081/api/employees/delete/{id}
localhost:8081/api/employees/change/{id}

localhost:8081/api/printers
localhost:8081/api/printers/list
localhost:8081/api/printers/details/{id}
localhost:8081/api/printers/delete/{id}

localhost:8081/api/computers
localhost:8081/api/computers/list
localhost:8081/api/computers/details/{id}
localhost:8081/api/computers/delete/{id}

localhost:8081/api/mobiles
localhost:8081/api/mobiles/list
localhost:8081/api/mobiles/details/{id}
localhost:8081/api/mobiles/delete/{id}
```

## Contributing

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also
simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Contact

Mariusz Maciejewski -  <a href="mailto:maciejewski_mariusz@wp.pl">maciejewski_mariusz@wp.pl

Project Link: [https://github.com/minvoo/iteis](https://github.com/minvoo/iteis)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[contributors-shield]: https://img.shields.io/github/contributors/minvoo/iteis.svg?style=for-the-badge

[contributors-url]: https://github.com/minvoo/iteis/graphs/contributors

[forks-shield]: https://img.shields.io/github/forks/minvoo/iteis.svg?style=for-the-badge

[forks-url]: https://github.com/minvoo/iteis/network/members

[stars-shield]: https://img.shields.io/github/stars/minvoo/iteis.svg?style=for-the-badge

[stars-url]: https://github.com/minvoo/iteis/stargazers

[issues-shield]: https://img.shields.io/github/issues/minvoo/iteis.svg?style=for-the-badge

[issues-url]: https://github.com/minvoo/iteis/issues

[license-shield]: https://img.shields.io/github/license/minvoo/iteis.svg?style=for-the-badge

[license-url]: https://github.com/minvoo/iteis/blob/master/LICENSE.txt

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555

[linkedin-url]: https://linkedin.com/in/minvoo

[product-screenshot]: src/main/resources/static/assets/img/logo.png

[Spring-url]: https://spring.io/projects/spring-boot

[SpringBoot]: https://img.shields.io/badge/SPRINGBOOT-6db33f?style=for-the-badge&logo=spring&logoColor=white

[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white

[Bootstrap-url]: https://getbootstrap.com

[JavaSite]: https://img.shields.io/badge/JAVA-%23ED8B00?style=for-the-badge&logo=java&logoColor=white

[Java-url]: https://www.oracle.com/java/

[HTMLSite]: https://img.shields.io/badge/html-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white

[HTML-url]: https://www.w3schools.com/html/

[HibernateSite]: https://img.shields.io/badge/hibernate-bcae79.svg?style=for-the-badge&logo=hibernate&logoColor=white

[Hibernate-url]: https://hibernate.org/

[CSSSite]: https://img.shields.io/badge/css-2862e9.svg?style=for-the-badge&logo=css3&logoColor=white

[CSS-url]: https://www.w3schools.com/css/default.asp

[ThymeleafSite]: https://img.shields.io/badge/thymeleaf-005f0f.svg?style=for-the-badge&logo=thymeleaf&logoColor=white

[Thymeleaf-url]: https://www.w3schools.com/css/default.asp

[MysqlSite]: https://img.shields.io/badge/mysql-3e6e93.svg?style=for-the-badge&logo=mysql&logoColor=white

[Mysql-url]: https://www.mysql.com