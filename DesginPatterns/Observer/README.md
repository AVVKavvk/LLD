# Observer

---
- Definition: Defines a subscription mechanism to notify multiple objects about any events that happen to the object they're observing.
- Use Case: Push notifications, MVC architectures (Model updates the View).
- What it solves: Defines a one-to-many dependency. When one object changes state, all its dependents are notified.
- What it prevents: "Polling" (where objects constantly waste CPU cycles asking, "Did you change yet? Did you change yet?").