# Bus-Ticket-Reservation-System

Problem Statement:

Most bus operators still rely on manual booking, leading to double bookings, wrong fare calculations, and poor seat tracking.
Even existing digital bus systems lack a proper waitlist mechanism. This means if all seats are full, passengers miss out even if cancellations happen later.
A system is needed that not only automates booking and cancellation but also introduces an efficient waitlist feature to improve passenger experience.

Description:

The Bus Ticket Reservation System with Waitlist Feature is a Java-based application that simplifies managing bus bookings.
It allows passengers to book, cancel, and view tickets while keeping seat availability updated in real time.
A unique waitlist system ensures that if all seats are full, passengers are placed in a queue. If a cancellation occurs, the system automatically confirms the first person in the waitlist.
It also supports Sleeper and Seater buses, each with different fare calculation logic, designed using core OOP principles.

Features:

Book and cancel tickets.

Real-time seat availability tracking.

Sleeper & Seater buses with unique fare calculations.

Ticket details include passenger name, seat number, and fare.

Waitlist system (unique) → auto-confirmation when a seat becomes available.

Console-based for demo (extendable with DBMS & GUI).

UML Diagram:

![WhatsApp Image 2025-08-27 at 12 47 30_c17f326e](https://github.com/user-attachments/assets/a451e9ee-9e43-4b60-b6a9-88297afbbdd8)

OOPS concepts used:

Encapsulation → Passenger details and seat counts are private with controlled access.

Inheritance → SleeperBus and SeaterBus inherit common properties from Bus.

Polymorphism → calcFare() is overridden to compute fares differently for each bus type.

Abstraction → Bus is defined as an abstract class with abstract methods like calcFare().

Composition → Ticket depends on Bus; waitlist is integrated with Ticket system.
