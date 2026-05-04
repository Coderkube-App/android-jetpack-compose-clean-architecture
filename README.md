# Android Jetpack Compose Clean Architecture Project

A modern Android application built using **Kotlin**, **Jetpack Compose**, and **Clean Architecture** principles. This project demonstrates a scalable, maintainable, and responsive structure using MVVM, Hilt (Dependency Injection), and REST API integration with a premium design system.

---

## Tech Stack

* **Language**: Kotlin
* **UI Framework**: Jetpack Compose (Material 3)
* **Architecture**: Clean Architecture + MVVM
* **Dependency Injection**: Hilt (Dagger)
* **Networking**: Retrofit + OkHttp
* **Annotation Processing**: KSP (Kotlin Symbol Processing)
* **Asynchronous**: Kotlin Coroutines + Flow
* **State Management**: StateFlow
* **Navigation**: Compose Navigation

---

## Project Structure

```text
app/src/main/java/com/compose/cleanarchitecture/

├── core/                  
│   ├── network/           # Retrofit & OkHttp setup
│   ├── navigation/        # Type-safe navigation (Screen, AppNavigation)
│   └── designsystem/      # Premium tokens, components, and responsive layouts
├── data/                  
│   ├── remote/            # API Service & Constants
│   └── repository/        # Repository implementations
├── domain/                
│   ├── model/             # Pure entities
│   ├── repository/        # Repository interfaces
│   └── usecase/           # Business logic (GetUsersUseCase)
├── presentation/          
│   ├── screens/           # Compose screens (UserListScreen)
│   ├── viewmodel/         # ViewModels managing StateFlow
│   └── state/             # UI State definitions (UserState)
└── MainActivity.kt        # Entry point with NavHost
```

---

## Layer Breakdown

### Core Layer

Contains reusable components and infrastructure used across the app:

* **Network**: Retrofit configuration, OkHttpClient, and Hilt AppModule.
* **Design System**: Advanced UI foundations including:
    * **Tokens**: Spacing system and custom Modifiers.
    * **Components**: Premium TopBars, BottomNavigation, and Card styles.
    * **Layouts**: `ResponsiveScaffold` and `WindowSize` detection for mobile/tablet support.
    * **Animations**: Fade and Slide visibility utilities.

---

### Data Layer

Responsible for handling all data operations and mapping:

* **Remote**: API calls using Retrofit and Gson converters.
* **Repository Implementations**: Concrete implementations of domain repository interfaces.
* **Mappers**: (Optional) Mapping between DTOs and Domain Models.

---

### Domain Layer

Pure business logic with no Android dependencies (The heart of the app):

* **Models**: Data classes representing business entities.
* **Repository Interfaces**: Defining the contract for data operations.
* **UseCases**: Single-responsibility classes for application logic.

---

### Presentation Layer

Handles UI and state using Jetpack Compose:

* **Screens**: Declarative UI built with Material 3 components.
* **ViewModels**: Handling UI logic and exposing immutable state via `StateFlow`.
* **UI State**: Data classes representing all possible screen states (Loading, Success, Error).

---

## Data Flow

```text
UI (Compose Screen)
   ↓
ViewModel (StateFlow)
   ↓
UseCase
   ↓
Repository (Domain Interface)
   ↓
Repository Implementation (Data Layer)
   ↓
Remote API (Retrofit)
```

---

## Features

* **Strict Clean Architecture**: High modularity and separation of concerns.
* **Modern Compose UI**: Built with Material 3 and a custom design system.
* **Responsive Design**: Support for multiple window sizes (Mobile, Tablet, Desktop).
* **Unidirectional Data Flow**: Reliable state management with StateFlow.
* **Dependency Injection**: Full Hilt integration for all layers.
* **Type-Safe Navigation**: Centralized route management.
* **Asynchronous Operations**: Robust networking with Coroutines and Flow.

---

## Setup Instructions

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/android-jetpack-compose-clean-architecture.git
   ```

2. **Open the project** in Android Studio (Koala or later recommended).

3. **Sync Gradle** to download dependencies.

4. **Run the application** on an emulator or physical device.

---

## Best Practices

* **SOLID Principles**: Ensuring the code is easy to maintain and extend.
* **Responsive Layouts**: Using `WindowSize` classes for multi-device support.
* **Design Tokens**: Centralized spacing and modifier systems.
* **Clean Code**: Meaningful naming and clear structure.

---

## Contributing

Contributions are welcome. Feel free to fork the repository and submit a pull request for new features or bug fixes.

---

## License

This project is licensed under the Apache License 2.0.