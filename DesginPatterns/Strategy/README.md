# Strategy

---

- Definition: Lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.

- Use Case: Payment gateways. A user can choose to pay via CreditCardStrategy or PayPalStrategy at runtime.

- Solves / Prevents: Hardcoded algorithms and massive if (paymentType == "paypal") blocks in your core logic.