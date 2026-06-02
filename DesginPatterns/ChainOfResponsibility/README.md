# Chain of Responsibility

---

- Definition: Passes requests along a chain of handlers. Upon receiving a request, each handler decides either to process it or to pass it to the next handler in the chain.
- Use Case: Logging systems (Info -> Debug -> Error), event handling in user interfaces.
- What it solves: Passes a request along a chain of handlers until one of them processes it.
- What it prevents: Hard-wiring the sender of a request to the receiver.