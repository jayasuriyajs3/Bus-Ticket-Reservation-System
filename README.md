# Bus-Ticket-Reservation-System

Problem Statement:

Many bus operators still rely on manual booking methods, which lead to issues like double booking, fare miscalculations, and poor seat management. A digital system is required to automate ticket booking, handle cancellations, and track seat availability efficiently.

Description:

The Bus Ticket Reservation System is a Java-based application that simplifies the process of managing bus bookings. It enables travelers to book, cancel, and view tickets while automatically updating seat availability. The system supports different types of buses — Sleeper and Seater — with separate fare calculation logic. By applying core OOP principles such as inheritance, polymorphism, and abstraction, the project ensures a modular and scalable design.

Features:

Book and cancel tickets.

Track available seats in real-time.

Different bus types (Sleeper & Seater) with unique fare calculation.

Ticket details including passenger name, seat number, and fare.

Console-based user interaction for demonstration.

UML Diagram:

![WhatsApp Image 2025-08-27 at 12 47 30_c17f326e](https://github.com/user-attachments/assets/a451e9ee-9e43-4b60-b6a9-88297afbbdd8)

OOPS concepts used:

Encapsulation → Passenger and seat data kept private, accessed via methods.

Inheritance → SleeperBus and SeaterBus extend the Bus class.

Polymorphism → calcFare() overridden in subclasses to compute different fares.

Abstraction → Bus is abstract with calcFare() as an abstract method.

Composition → Ticket class uses a Bus object for booking.
