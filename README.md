# Notes App 📝

A modern, simple Android application for creating and managing daily notes. This project demonstrates the integration of the latest Android development practices, including Jetpack Compose for the UI, Type-Safe Navigation (Navigation 3), Room Database for local storage, and robust Unit Testing for database operations.

## ✨ Features

*   **Create Notes:** Quickly add new notes with a simple interface.
*   **Read & View:** Display a list of all saved notes using reactive data streams.
*   **Update Notes:** Edit existing notes seamlessly.
*   **Delete Notes:** Remove unwanted notes from the database.
*   **Type-Safe Navigation:** Smooth and crash-safe transitions between screens using the latest Navigation 3 DSL and serializable keys.
*   **Database Testing:** Includes JUnit instrumented tests to verify Room Database queries and DAO operations.

## 📸 Screenshots & Demo

| Notes List | Delete/Edit Note |
| :---: | :---: |
| <img src="https://github.com/user-attachments/assets/5d3a7043-765d-47fa-b989-7f30558a72f8" width="250" /> | <img src="https://github.com/user-attachments/assets/7b8f30e4-c905-4b45-ac64-e2bb0fde8829" width="250" /> |

**🎥 App Navigation & Transitions Demo:**  
https://github.com/user-attachments/assets/50f4e051-9942-481e-bd64-795865d6bcb9

## 🛠️ Tech Stack & Architecture

This project is built using the following technologies:

*   **Language:** [Kotlin](https://kotlinlang.org/)
*   **UI Toolkit:** [Jetpack Compose](https://developer.android.com/jetpack/compose) for a declarative and modern UI.
*   **Architecture:** Single-Activity Architecture following the MVVM (Model-View-ViewModel) pattern.
*   **Navigation:** **Jetpack Compose Navigation 3** (`androidx.navigation3`) with customized `NavDisplay` and `entryProvider`.
*   **Serialization:** [Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization) for passing strongly-typed objects between screens and surviving process death.
*   **Local Database:** [Room](https://developer.android.com/training/data-storage/room) for SQLite object mapping.
*   **Asynchronous Programming:** [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) and [Flow](https://kotlin.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/) for managing background threads and reactive data.
*   **Testing:** [JUnit4](https://junit.org/junit4/) for local and instrumented unit testing (specifically testing the DAO).

## 🧪 Testing

The application includes Instrumented Unit Tests to ensure the database operations work flawlessly. The tests run on an Android device or emulator to create an in-memory database and verify the `Insert` and `Select` queries.

To run the database tests:
1. Open the project in Android Studio.
2. Navigate to `app/src/androidTest/java/com/maadcoding/notesapp/NoteDaoTest.kt`.
3. Click the green **Run** arrow next to the `NoteDaoTest` class.
4. Ensure an emulator or a physical device is connected.
