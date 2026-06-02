# Factory (Method)

---

- Definition: Creates objects without exposing the instantiation logic to the client and refers to newly created objects using a common interface.

- Use Case: Creating different types of notifications (Email, SMS, Push) based on user input.

- Solves: Coupling the client to specific classes.

- Prevents: Having if-else blocks everywhere you need to instantiate a related group of objects.