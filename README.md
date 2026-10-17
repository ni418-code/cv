# CHAKRAVYUH: CYBERSHIELD HACKATHON (Android Native)

Modern Android application rewritten in Kotlin and Jetpack Compose for the **CHAKRAVYUH: CYBERSHIELD HACKATHON** at **VIT-AP University** (27–28 October 2026).

---

## Architecture & Technology Stack

- **Target OS:** Android 14+ (minSdk 26, targetSdk 35)
- **UI Framework:** Jetpack Compose with Material Design 3 (M3)
- **Architecture Pattern:** MVVM (Model-View-ViewModel) with Kotlin Coroutines & StateFlow
- **Theming & Design System:**
  - Cyber Navy (`#071426`, `#0C2B52`)
  - Electric Blue (`#287BFF`)
  - Neon Cyan (`#58E1FF`)
  - Signal Gold (`#F5BD55`)
  - Ice White (`#F3F8FF`)
- **Visual Features:**
  - Interactive Chakra constellation radar with animated rotating core
  - 5-Pointed frontier nodes with inward energy guides and motivational quotes
  - Dynamic 4-unit countdown timer to hackathon launch (27 October 2026)
  - 3 Challenge difficulty tiers (Flagship, Medium, Easy)
  - Full technical challenge specification modal (Problem Statement, Context, Deliverables, Suggested Tools, Guidance, Evaluation Criteria)
  - In-app challenge bookmarking & search filtering
  - Adaptive launcher icon with custom cyber shield and chakra motif

---

## The Five Technology Frontiers

1. **[01] Cybersecurity & Blockchain** — *"Defend the Digital Frontier"*
   - *Battle Cry:* `BREAK THE ATTACK. PROTECT THE WORLD. BUILD UNBREAKABLE TRUST.`
2. **[02] Space Technology** — *"Engineer Beyond Earth"*
   - *Battle Cry:* `DON'T JUST LOOK AT THE STARS. BUILD THE TECHNOLOGY THAT TAKES US THERE.`
3. **[03] Quantum Computing** — *"Compute Beyond Convention"*
   - *Battle Cry:* `CHALLENGE THE LIMITS OF COMPUTATION. SOLVE WHAT ONCE SEEMED IMPOSSIBLE.`
4. **[04] FinTech** — *"Reimagine Digital Finance"*
   - *Battle Cry:* `MAKE MONEY SMARTER. MAKE TRANSACTIONS SAFER. MAKE OPPORTUNITY ACCESSIBLE.`
5. **[05] Energy & Sustainability** — *"Power a Better Tomorrow"*
   - *Battle Cry:* `CODE FOR THE PLANET. ENGINEER A CLEANER FUTURE. MAKE EVERY WATT COUNT.`

---

## Directory Structure

```
├── app/
│   ├── build.gradle.kts
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── assets/images/
│       ├── java/com/example/chakravyuh/
│       │   ├── MainActivity.kt
│       │   ├── data/
│       │   │   ├── model/Models.kt
│       │   │   └── repository/ChakravyuhRepository.kt
│       │   └── ui/
│       │       ├── components/
│       │       │   ├── ChakraWheelView.kt
│       │       │   ├── ChakravyuhTopBar.kt
│       │       │   ├── ChallengeCard.kt
│       │       │   ├── ChallengeDetailDialog.kt
│       │       │   └── CountdownTimer.kt
│       │       ├── screens/
│       │       │   ├── BookmarksScreen.kt
│       │       │   ├── HomeScreen.kt
│       │       │   └── ThemeDetailScreen.kt
│       │       ├── theme/
│       │       │   ├── Color.kt
│       │       │   ├── Theme.kt
│       │       │   └── Type.kt
│       │       └── viewmodel/ChakravyuhViewModel.kt
│       └── res/
│           ├── drawable/
│           │   ├── ic_launcher_background.xml
│           │   └── ic_launcher_foreground.xml
│           ├── mipmap-anydpi-v26/
│           │   ├── ic_launcher.xml
│           │   └── ic_launcher_round.xml
│           └── values/
│               ├── colors.xml
│               ├── strings.xml
│               └── themes.xml
├── build.gradle.kts
├── settings.gradle.kts
├── gradle/libs.versions.toml
└── metadata.json
```
