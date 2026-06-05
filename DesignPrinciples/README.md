# Software Design Principles & Best Practices

## Why Design Principles Matter

Software design principles are proven guidelines that help developers write code that is:

- Easier to understand
- Easier to maintain
- Easier to test
- Easier to extend
- Less prone to bugs
- More scalable over time

Without design principles, applications often become difficult to modify, tightly coupled, and full of technical debt.

Good design principles help us build software that remains clean and manageable as complexity grows.

---

# 1. DRY (Don't Repeat Yourself)

## Definition

Every piece of knowledge or logic should have a single, unambiguous representation within the system.

## Goal

Avoid code duplication.

## Bad Example

```java
if (user.getAge() < 18) {
    throw new IllegalArgumentException("User must be 18+");
}
```

Repeated in multiple controllers.

## Good Example

```java
AgeValidator.validate(user);
```

Validation logic exists in one place.

## Benefits

- Easier maintenance
- Fix bugs once
- Reduced code size
- Consistent behavior

## When to Apply

Whenever you notice duplicated logic, calculations, validations, or business rules.

---

# 2. YAGNI (You Aren't Gonna Need It)

## Definition

Do not implement functionality until it is actually needed.

## Goal

Avoid over-engineering.

## Bad Example

Creating:

- Abstract classes
- Complex plugin systems
- Extra configuration layers

for features that may never exist.

## Good Example

Build only what current requirements demand.

## Benefits

- Faster development
- Less code to maintain
- Simpler architecture
- Reduced complexity

## Rule

> Future requirements are guesses. Current requirements are facts.

---

# 3. KISS (Keep It Simple, Stupid)

## Definition

Prefer the simplest solution that works.

## Goal

Maximize readability and maintainability.

## Bad Example

```java
users.stream()
     .filter(User::isActive)
     .map(User::getName)
     .sorted()
     .collect(Collectors.toList());
```

For a very simple operation where a loop would be clearer.

## Good Example

```java
List<String> names = new ArrayList<>();

for (User user : users) {
    if (user.isActive()) {
        names.add(user.getName());
    }
}
```

## Benefits

- Easier debugging
- Easier onboarding
- Fewer hidden bugs
- Better readability

## Rule

> Simple code survives longer than clever code.

---

# 4. Curly's Law

## Definition

A variable, function, or object should mean exactly one thing.

## Goal

Single purpose for every piece of code.

## Bad Example

```java
Object temp;
```

Used for multiple unrelated purposes.

## Good Example

```java
Long userId;
BigDecimal discountAmount;
```

Each variable has a single responsibility.

## Benefits

- Better readability
- Easier maintenance
- Predictable behavior

---

# 5. The Boy Scout Rule

## Definition

Leave the code cleaner than you found it.

## Goal

Prevent technical debt accumulation.

## Examples

While implementing a feature:

- Remove unused imports
- Rename unclear variables
- Fix formatting
- Improve comments

## Benefits

- Continuous improvement
- Cleaner codebase over time
- Reduced technical debt

## Rule

> Every commit should make the code slightly better.

---

# 6. Separation of Concerns (SoC)

## Definition

Different parts of the application should handle different responsibilities.

## Goal

Separate unrelated responsibilities.

## Typical Spring Boot Structure

```text
Controller
    ↓
Service
    ↓
Repository
```

### Controller

Handles HTTP requests.

### Service

Contains business logic.

### Repository

Handles database operations.

## Benefits

- High cohesion
- Loose coupling
- Easier testing
- Better organization

---

# 7. Law of Demeter (Principle of Least Knowledge)

## Definition

Objects should only communicate with their immediate collaborators.

## Goal

Reduce coupling.

## Bad Example

```java
customer.getAccount()
        .getWallet()
        .deduct(100);
```

## Good Example

```java
customer.deductFunds(100);
```

Customer handles internal details.

## Benefits

- Encapsulation
- Easier refactoring
- Reduced dependencies

## Rule

> Don't talk to strangers.

---

# SOLID Principles

SOLID is the foundation of Object-Oriented Design.

---

# 8. SRP (Single Responsibility Principle)

## Definition

A class should have only one reason to change.

## Bad Example

```java
class Invoice {
    saveToDatabase();
    calculateTotal();
    generatePdf();
}
```

## Good Example

```java
InvoiceCalculator
InvoiceRepository
InvoicePdfGenerator
```

## Benefits

- Easier testing
- Easier maintenance
- Smaller classes

---

# 9. OCP (Open/Closed Principle)

## Definition

Software entities should be:

- Open for extension
- Closed for modification

## Bad Example

```java
if (type.equals("EMAIL")) {
   ...
}
else if (type.equals("SMS")) {
   ...
}
```

Adding new types requires modifying existing code.

## Good Example

```java
interface NotificationSender {
    void send();
}
```

```java
EmailSender
SmsSender
PushSender
```

## Benefits

- Safer feature additions
- Reduced regression risk
- Better extensibility

---

# 10. LSP (Liskov Substitution Principle)

## Definition

Subclasses must be replaceable for their parent classes.

## Bad Example

```java
class Bird {
    void fly();
}
```

```java
class Penguin extends Bird {
    void fly() {
        throw new UnsupportedOperationException();
    }
}
```

## Problem

Penguin cannot truly behave like Bird.

## Benefits

- Correct inheritance
- Predictable behavior
- Fewer runtime errors

---

# 11. ISP (Interface Segregation Principle)

## Definition

Clients should not depend on methods they don't use.

## Bad Example

```java
interface Worker {
    work();
    eat();
    sleep();
}
```

Robot must implement irrelevant methods.

## Good Example

```java
interface Workable {}
interface Eatable {}
interface Sleepable {}
```

Robot only implements:

```java
Workable
```

## Benefits

- Smaller interfaces
- Cleaner implementations
- Better flexibility

---

# 12. DIP (Dependency Inversion Principle)

## Definition

High-level modules should depend on abstractions, not concrete implementations.

## Bad Example

```java
CheckoutService service =
    new CheckoutService(new StripeProcessor());
```

## Good Example

```java
public class CheckoutService {

    private final PaymentGateway paymentGateway;

    public CheckoutService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
}
```

## Benefits

- Loose coupling
- Easier testing
- Easier replacement of implementations

## Common Spring Example

```java
@Service
public class CheckoutService {

    private final PaymentGateway gateway;

    @Autowired
    public CheckoutService(PaymentGateway gateway) {
        this.gateway = gateway;
    }
}
```

---

# Command Query Separation (CQS)

Created by Bertrand Meyer.

## Core Rule

> Asking a question should not change the answer.

Every method should be either:

1. A Command
2. A Query

Never both.

---

## Query Methods

### Purpose

Return information.

### Rules

- Return data
- No side effects
- Do not modify state

### Example

```java
public User getUser(Long id) {
    return repository.findById(id);
}
```

Calling this method multiple times should not change anything.

### Benefits

- Predictable behavior
- Easier testing
- Easier debugging

---

## Command Methods

### Purpose

Modify system state.

### Rules

- Perform actions
- Usually return void
- Change state

### Example

```java
public void updateUser(User user) {
    repository.save(user);
}
```

### Benefits

- Clear intent
- Easier maintenance
- Better separation of responsibilities

---

## CQS Violation

### Bad Example

```java
public User getAndIncrementViewCount(Long id) {
    User user = repository.findById(id);
    user.incrementViews();
    return user;
}
```

This method:

- Returns data (Query)
- Changes state (Command)

Therefore it violates CQS.

---

## Better Design

```java
public User getUser(Long id) {
    return repository.findById(id);
}
```

```java
public void incrementViewCount(Long id) {
    repository.incrementViews(id);
}
```

Now responsibilities are separated.

---

# Principle Comparison

| Principle      | Core Idea                     | Main Benefit            |
| -------------- | ----------------------------- | ----------------------- |
| DRY            | Don't repeat code             | Easier maintenance      |
| YAGNI          | Build only what's needed      | Avoid over-engineering  |
| KISS           | Prefer simple solutions       | Better readability      |
| Curly's Law    | One thing = one meaning       | Predictability          |
| Boy Scout Rule | Improve code continuously     | Reduced technical debt  |
| SoC            | Separate responsibilities     | Better modularity       |
| Law of Demeter | Don't expose internals        | Lower coupling          |
| SRP            | One reason to change          | Easier testing          |
| OCP            | Extend, don't modify          | Safer feature additions |
| LSP            | Subclasses behave correctly   | Reliable inheritance    |
| ISP            | Small focused interfaces      | Cleaner APIs            |
| DIP            | Depend on abstractions        | Loose coupling          |
| CQS            | Commands and Queries separate | Predictable behavior    |

---

# Quick Mental Checklist

Before writing code, ask:

- Am I repeating code? → DRY
- Am I building something not required yet? → YAGNI
- Can this be simpler? → KISS
- Does this variable/class have one purpose? → Curly's Law / SRP
- Did I improve the code while touching it? → Boy Scout Rule
- Are responsibilities separated? → SoC
- Am I exposing too many internals? → Law of Demeter
- Can I extend this without modifying existing code? → OCP
- Is inheritance actually valid? → LSP
- Is this interface too large? → ISP
- Am I depending on implementations instead of abstractions? → DIP
- Does this method both return data and change state? → CQS

---

# Conclusion

These principles are not strict rules but guidelines that help create maintainable, scalable, and robust software systems.

A good engineer doesn't blindly apply every principle everywhere. The real skill is understanding:

- When a principle provides value
- When it adds unnecessary complexity
- How to balance simplicity with extensibility

Following these principles consistently leads to cleaner architecture, fewer bugs, easier testing, and a codebase that remains healthy as it grows.
