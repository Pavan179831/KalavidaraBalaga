# ಕಲಾವಿದರ ಬಳಗ — Kalavidara Balaga

> **MindMatrix VTU Internship Program | Project #50**
> Android App Development using GenAI — Folk Artist Employment Platform

---

## 📖 Problem Statement

Local musical troupes (Dollu Kunitha, Pooja Kunitha, etc.) only get work during the *"Wedding Season"* or *"Festival Season"*. They have no way to reach Event Managers in cities who are looking for authentic performers, making traditional art financially unsustainable.

## 💡 Solution — Kalavidara Balaga

A **"Folk Artist Talent Hub"** — a professional marketplace for traditional troupes. Each troupe creates a **Performance Profile** complete with photos, instruments used, and their service area. It makes traditional art a **Sustainable Profession**.

---

## 🏗️ Architecture

```
MVVM Architecture
├── Model       → Troupe.kt (Firestore data class)
├── Repository  → TroupeRepository.kt (Firestore operations)
├── ViewModel   → TroupeViewModel.kt (LiveData + Coroutines)
└── View        → Fragments + Activities (ViewBinding)
```

## 📱 Screens

| Screen | Description |
|--------|-------------|
| **Splash** | Animated logo with Kannada app name |
| **Home** | Featured troupes + art form filter chips |
| **Search** | Filter by District (32) & Art Type (13) |
| **Troupe Profile** | Full profile, gallery, contact details |
| **Booking Inquiry** | Form saved to Firestore + direct call |

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | **Kotlin** |
| Architecture | **MVVM** + LiveData + Coroutines |
| Database | **Firebase Firestore** |
| Storage | **Firebase Storage** |
| UI | **ViewBinding** + Material 3 |
| Images | **Glide** |
| Gallery | **StaggeredGridLayoutManager** |
| Navigation | **Navigation Component** |

## 🎨 Design

- **Theme**: Karnataka folk art inspired — Deep Maroon (`#8B1A1A`) + Gold (`#D4A017`)
- **Typography**: Kannada Unicode supported
- **Gallery**: Staggered grid for natural photo ratios (per project spec)
- **Booking**: DatePicker + Firestore submission to `bookings` collection

---

## 🚀 Setup Instructions

### 1. Firebase Setup (Required before building)

1. Go to [Firebase Console](https://console.firebase.google.com)
2. Create a new project → name it `kalavidara-balaga`
3. Add Android app → package: `com.kalavidarabalaga.app`
4. Download `google-services.json` → place in `app/` folder
5. Enable **Cloud Firestore** (Start in test mode)
6. Enable **Firebase Storage**

### 2. Firestore Collections

The app auto-seeds sample data on first launch. Collections used:

```
troupes/          ← Troupe profiles
  ├── name
  ├── artType
  ├── district
  ├── phone
  ├── memberCount
  ├── instruments
  ├── equipment
  ├── galleryUrls[]
  └── isFeatured

bookings/         ← Booking inquiries from event managers
  ├── troupeId
  ├── organizerName
  ├── eventName
  ├── eventDate
  └── status
```

### 3. Deploy Firestore Rules

```bash
firebase deploy --only firestore:rules,firestore:indexes
```

### 4. Build & Run

1. Open project in **Android Studio Hedgehog (2023.1.1)** or later
2. Wait for Gradle sync to complete
3. Connect Android device (API 24+) or start emulator
4. Click **Run ▶**

---

## 📂 Project Structure

```
KalavidaraBalaga/
├── app/
│   ├── google-services.json       ← Add your Firebase config here
│   └── src/main/
│       ├── java/com/kalavidarabalaga/app/
│       │   ├── KalavidaraApp.kt           ← Application class
│       │   ├── model/Troupe.kt            ← Data model
│       │   ├── repository/               ← Firestore layer
│       │   ├── viewmodel/                ← UI state management
│       │   ├── adapter/                  ← RecyclerView adapters
│       │   └── ui/
│       │       ├── splash/SplashActivity.kt
│       │       ├── MainActivity.kt
│       │       ├── home/HomeFragment.kt
│       │       ├── search/SearchFragment.kt
│       │       ├── profile/TroupeProfileActivity.kt
│       │       └── booking/BookingActivity.kt
│       └── res/
│           ├── layout/       ← All XML layouts
│           ├── drawable/     ← Shapes, gradients, logo
│           ├── values/       ← Colors, strings, themes, dimens
│           └── navigation/   ← Nav graph
├── firestore.rules            ← Security rules
├── firestore.indexes.json     ← Composite indexes
└── firebase.json
```

---

## ✅ Success Criteria (per MindMatrix spec)

- [x] Artist Search filterable by **District** and **Art Type**
- [x] Troupe profiles load with **StaggeredGridLayout** gallery
- [x] Vibrant UI with traditional textures (Karnataka maroon + gold palette)
- [x] **Call** button using Android `Intent.ACTION_CALL`
- [x] Firebase Firestore backend (searchable directory)
- [x] **Booking Inquiry** saved to Firestore

---

## 👨‍💻 Team

> MindMatrix VTU Internship Program 2026 — Project #50
