# Facade

---

- Definition: Provides a simplified interface to a library, a framework, or any other complex set of classes.

- Use Case: An E-commerce checkout process. The client just calls checkoutFacade.placeOrder(), and the Facade handles talking to Inventory, Payment, and Shipping subsystems.

- Solves: Clients needing to understand complex subsystem interactions.

- Prevents: Tight coupling between the client code and the internal details of subsystems.