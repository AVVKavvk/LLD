# Builder

---
- Definition: Separates the construction of a complex object from its representation, allowing the same construction process to create various representations.

- Use Case: Creating complex objects that require many optional parameters (e.g., creating a User object where only name is required, but age, phone, address are optional).

- What it solves: Provides a clear, step-by-step way to construct an object.

- What it prevents: The "Telescoping Constructor" anti-pattern (where you have constructors with 10+ confusing parameters: new User("John", null, null, 25, true)).
