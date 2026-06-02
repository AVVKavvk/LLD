# Proxy

---
- Definition: Provides a placeholder for another object to control access to it.
- Use Case: Lazy initialization (loading massive images only when scrolled into view), access control (checking if a user is an admin before executing).
- What it solves: Controls access to the original object, allowing you to perform actions before or after the request reaches the original object.
- What it prevents: Heavy resource allocation when it isn't needed yet, or unauthorized access.