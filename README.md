# Notes App 📝

A modern, simple Android application for creating and managing daily notes. This project demonstrates the integration of modern Android development practices, including Jetpack Compose for the UI, Room Database for local storage, and robust Unit Testing for database operations.

## ✨ Features

*   **Create Notes:** Quickly add new notes with a simple interface.
*   **Read & View:** Display a list of all saved notes using reactive data streams.
*   **Update Notes:** Edit existing notes seamlessly.
*   **Delete Notes:** Remove unwanted notes from the database.
*   **Database Testing:** Includes JUnit instrumented tests to verify Room Database queries and DAO operations.

## 🛠️ Tech Stack & Architecture

This project is built using the following technologies:

*   **Language:** [Kotlin](https://kotlinlang.org/)
*   **UI Toolkit:** [Jetpack Compose](https://developer.android.com/jetpack/compose) for a declarative and modern UI.
*   **Architecture:** MVVM (Model-View-ViewModel).
*   **Local Database:** [Room](https://developer.android.com/training/data-storage/room) for SQLite object mapping.
*   **Asynchronous Programming:** [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) and [Flow](https://kotlin.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/) for managing background threads and reactive data.
*   **Testing:** [JUnit4](https://junit.org/junit4/) for local and instrumented unit testing (specifically testing the DAO).

## 🧪 Testing

The application includes Instrumented Unit Tests to ensure the database operations work flawlessly. The tests run on an Android device or emulator to create an in-memory database and verify the `Insert`, `Update`, `Delete`, and `Select` queries.

To run the database tests:
1. Open the project in Android Studio.
2. Navigate to `app/src/androidTest/java/com/maadcoding/notesapp/NoteDaoTest.kt`.
3. Click the green **Run** arrow next to the `NoteDaoTest` class.
4. Ensure an emulator or a physical device is connected.
