
# JVM Basics – LearnTrack Project

## What are JDK, JRE, and JVM?

### JVM (Java Virtual Machine)
The **Java Virtual Machine (JVM)** is responsible for executing Java programs.  
It runs Java **bytecode** and handles memory management, garbage collection, and execution of instructions.  
The JVM makes Java platform-independent by running the same bytecode on different operating systems.

---

### JRE (Java Runtime Environment)
The **Java Runtime Environment (JRE)** provides everything needed to run a Java application.  
It contains:
- JVM
- Core Java libraries
- Supporting runtime files

If a user only wants to run Java programs and not develop them, JRE is sufficient.

---

### JDK (Java Development Kit)
The **Java Development Kit (JDK)** is used for developing Java applications.  
It includes:
- JRE
- Java compiler (`javac`)
- Development and debugging tools

To write and compile Java code, the JDK is required.

---

## What is Bytecode?

When a Java program is compiled using the Java compiler (`javac`), it is converted into an intermediate format called **bytecode**.  
Bytecode is stored in `.class` files and is not specific to any operating system.

The JVM reads and executes this bytecode, allowing Java programs to run on different platforms.

---

## What Does “Write Once, Run Anywhere” Mean?

“**Write Once, Run Anywhere**” means that a Java program needs to be written and compiled only once.  
The compiled bytecode can run on any operating system (Windows, Linux, macOS) as long as a compatible JVM is available.

This feature makes Java **platform-independent** and one of the most widely used programming languages for cross-platform applications.
