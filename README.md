# Spring XML Configuration with Nested Dependency Injection

This project demonstrates Spring Framework XML-based configuration with 3 levels of nested dependency injection in an e-commerce domain.

## Project Overview

The project showcases:
- **3 Levels of Bean Nesting**: User → ShoppingCart → Item
- **Constructor-based Dependency Injection**
- **Setter-based Dependency Injection**
- **Property File Configuration**
- **XML-based Spring Configuration**

## Architecture

### Bean Hierarchy

```
Level 1: User Bean
    ├── userId (constructor injection)
    ├── username (constructor injection)
    ├── email (setter injection from properties)
    └── shoppingCart (setter injection)
         │
         └── Level 2: ShoppingCart Bean
              ├── cartId (constructor injection from properties)
              ├── status (setter injection from properties)
              └── items (setter injection - list of Item beans)
                   │
                   └── Level 3: Item Beans (item1, item2, item3)
                        ├── itemId (constructor injection from properties)
                        ├── name (constructor injection from properties)
                        ├── price (constructor injection from properties)
                        └── description (setter injection from properties)
```

## Project Structure

```
spring-xml-di-demo/
├── pom.xml                                    # Maven configuration
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── ecommerce/
│       │           ├── EcommerceApplication.java    # Main application class
│       │           └── model/
│       │               ├── User.java                # Level 1 bean
│       │               ├── ShoppingCart.java        # Level 2 bean
│       │               └── Item.java                # Level 3 bean
│       └── resources/
│           ├── applicationContext.xml               # Spring XML configuration
│           └── application.properties               # Property values
└── README.md
```

## Configuration Details

### application.properties
Contains all configurable values for beans:
- User properties (userId, username, email)
- Shopping cart properties (cartId, status)
- Item properties (itemId, name, price, description) for 3 items

### applicationContext.xml
Spring XML configuration file that:
1. Loads properties using `<context:property-placeholder>`
2. Defines Item beans (Level 3) with constructor and setter injection
3. Defines ShoppingCart bean (Level 2) injecting Item beans as a list
4. Defines User bean (Level 1) injecting ShoppingCart bean

## Building and Running

### Prerequisites
- Java 8 or higher
- Maven 3.x

### Build the Project
```bash
mvn clean compile
```

### Run the Application
```bash
mvn exec:java -Dexec.mainClass="com.ecommerce.EcommerceApplication"
```

## Expected Output

The application will display:
1. User information (Level 1)
2. Shopping cart information with nested items (Level 2)
3. Individual item details (Level 3)
4. Summary of dependency injection types used

## Key Features Demonstrated

### Constructor-based DI
- **User**: userId and username injected via constructor
- **ShoppingCart**: cartId injected via constructor
- **Item**: itemId, name, and price injected via constructor

### Setter-based DI
- **User**: email and shoppingCart injected via setters
- **ShoppingCart**: items list and status injected via setters
- **Item**: description injected via setter

### Property Injection
All values (strings, numbers) are injected from `application.properties` file using Spring's property placeholder mechanism (`${property.name}`).

### Bean Nesting
Demonstrates 3 levels of dependency:
- User contains ShoppingCart
- ShoppingCart contains List of Items
- All wired together through Spring XML configuration

## Technologies Used

- **Spring Framework 5.3.20**
  - spring-core
  - spring-context
  - spring-beans
- **Java 8**
- **Maven**

## Learning Outcomes

This project demonstrates:
1. XML-based Spring configuration (alternative to annotation-based)
2. Different types of dependency injection (constructor vs setter)
3. Injecting values from properties files
4. Injecting complex types (lists, nested beans)
5. Managing multi-level bean dependencies
6. Spring ApplicationContext usage

## License

This is an educational project demonstrating Spring Framework concepts.