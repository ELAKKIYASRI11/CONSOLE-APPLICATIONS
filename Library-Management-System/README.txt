Library Management System (Console Java)
==========================================

HOW TO RUN
1. Extract this zip.
2. Open a terminal in the "src" folder.
3. Compile:   javac *.java
4. Run:       java Main

FILES
- Item.java                    Abstract base class (OOP)
- Book.java, Magazine.java,
  DVD.java                     Concrete Item subclasses
- Borrowable.java               Interface implemented by Item
- Member.java                   Library member, tracks borrowed items
- Library.java                  Core logic: HashMap catalog, ArrayList members,
                                 Queue-based waitlists per item
- ItemNotFoundException.java
- ItemAlreadyBorrowedException.java
- InvalidMemberException.java   Custom checked exceptions
- Main.java                     Console menu (Scanner-based UI)

The catalog is pre-loaded with sample books/magazines/DVDs and two members
(MEM1, MEM2) so you can try borrowing/returning immediately.
