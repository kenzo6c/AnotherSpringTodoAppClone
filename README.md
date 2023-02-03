# Another Spring Boot Todo App clone

This is a simple todo app clone which I made to learn more about Spring Boot and back-end development in general.

It was done in 5 days: I spent 2 days digging the Spring Framework and Spring MVC theory, then I spent 3 days building this app while also making sure to understand how everything worked.

This project is based on this tutorial: https://www.youtube.com/watch?v=yqWtYKWWcpY, and I also used Marco Behler's guides on Spring Framework and Spring MVC. However, many things were changed in the code and in the functions available so that I could discover new things.

Here are a few lists of the differences:
- I used String + Model instead of ModelAndView to redirect to other pages.
- Everything is on the same page.
- Missing functionalities (edit), added new ones (check button and delete all button).
- Used bootstrap-icons


## Front-end
The front-end was not the focus of this project, however, I still wanted a nice and clean display. As in the tutorial, I didn't create a REST API and instead connected the backend directly to a simple HTML + Bootstrap front-end using Thymeleaf.

The front-end technologies used are:
- HTML
- Bootstrap CSS & JS
- Bootstrap-Icons


## Back-end
The back-end was the focus of this project, and this is why it is the most developed part. I used the same Maven dependencies as in the tutorial to simplify things. However, I did use some of them differently. As stated in the Front-end part, this is not a REST API.

The back-end technologies used are:
- Java
- Spring Framework, mostly:
    - Spring's Dependency Injection Container
    - Spring MVC
- Spring Data JPA (to make the handling of the database easier.)
- Lombok (to simplify some code: Getters, Setters, etc.)
- h8 database (because it has no other dependency and is simple to set up.)
- Thymeleaf (to link with the front-end.)

## Other
I used the official Spring initializer to create the project, and I programmed using the IntelliJ IDEA Ultimate IDE (from Jetbrains).

