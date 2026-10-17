package com.example.chakravyuh.data.repository

import com.example.chakravyuh.data.model.Challenge
import com.example.chakravyuh.data.model.ChallengeLevel
import com.example.chakravyuh.data.model.FaqItem
import com.example.chakravyuh.data.model.FrontierTheme
import com.example.chakravyuh.data.model.Partner
import com.example.chakravyuh.data.model.TimelineItem
import com.example.chakravyuh.ui.theme.NeonCyan
import com.example.chakravyuh.ui.theme.SignalGold
import com.example.chakravyuh.ui.theme.ThemeCyber
import com.example.chakravyuh.ui.theme.ThemeFintech
import com.example.chakravyuh.ui.theme.ThemeQuantum
import com.example.chakravyuh.ui.theme.ThemeSpace
import com.example.chakravyuh.ui.theme.ThemeSustainability
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ChakravyuhRepository {

    val themes: List<FrontierTheme> = listOf(
        FrontierTheme(
            id = "cybersecurity",
            number = "01",
            label = "CYBERSECURITY & BLOCKCHAIN",
            title = "DEFEND THE DIGITAL FRONTIER",
            subtitle = "Secure systems. Trusted transactions. Protect critical networks, identities, cloud workloads, and smart-contract rails.",
            motivationalQuote = "BREAK THE ATTACK. PROTECT THE WORLD. BUILD UNBREAKABLE TRUST.",
            assetImage = "theme_cyber_server_room_1792211745523.jpg",
            accentColor = ThemeCyber,
            glowColor = NeonCyan
        ),
        FrontierTheme(
            id = "space",
            number = "02",
            label = "SPACE TECHNOLOGY",
            title = "ENGINEER BEYOND EARTH",
            subtitle = "Explore beyond. Build for tomorrow. Transform satellite telemetry, orbital navigation, and Earth remote sensing into practical tools.",
            motivationalQuote = "DON'T JUST LOOK AT THE STARS. BUILD THE TECHNOLOGY THAT TAKES US THERE.",
            assetImage = "theme_space_satellite_1792211745140.jpg",
            accentColor = ThemeSpace,
            glowColor = NeonCyan
        ),
        FrontierTheme(
            id = "quantum",
            number = "03",
            label = "QUANTUM COMPUTING",
            title = "COMPUTE BEYOND CONVENTION",
            subtitle = "Smarter qubits. Bigger possibilities. Investigate quantum-inspired optimization, superposition visualizers, and state simulation algorithms.",
            motivationalQuote = "CHALLENGE THE LIMITS OF COMPUTATION. SOLVE WHAT ONCE SEEMED IMPOSSIBLE.",
            assetImage = "theme_quantum_chip_1792211746846.jpg",
            accentColor = ThemeQuantum,
            glowColor = SignalGold
        ),
        FrontierTheme(
            id = "fintech",
            number = "04",
            label = "FINTECH",
            title = "REIMAGINE DIGITAL FINANCE",
            subtitle = "Smarter finance. Greater access. Construct high-throughput fraud detection, biometric transaction flows, and inclusive credit analytics.",
            motivationalQuote = "MAKE MONEY SMARTER. MAKE TRANSACTIONS SAFER. MAKE OPPORTUNITY ACCESSIBLE.",
            assetImage = "theme_fintech_payment_1792211744391.jpg",
            accentColor = ThemeFintech,
            glowColor = NeonCyan
        ),
        FrontierTheme(
            id = "sustainability",
            number = "05",
            label = "ENERGY & SUSTAINABILITY",
            title = "POWER A BETTER TOMORROW",
            subtitle = "Clean energy. A sustainable future. Develop predictive solar/wind forecasting, smart grid balancing, and transparent carbon accounting.",
            motivationalQuote = "CODE FOR THE PLANET. ENGINEER A CLEANER FUTURE. MAKE EVERY WATT COUNT.",
            assetImage = "theme_sustainability_grid_1792211746205.jpg",
            accentColor = ThemeSustainability,
            glowColor = NeonCyan
        )
    )

    val challenges: List<Challenge> = listOf(
        // Cybersecurity
        Challenge(
            id = "CYB-F-01",
            themeId = "cybersecurity",
            level = ChallengeLevel.FLAGSHIP,
            title = "Intelligent Cyber Threat Detection & Real-time Mitigation",
            summary = "Develop a real-time behavioral anomaly detection engine for corporate network traffic that pinpoints lateral movement, zero-day intrusion vectors, and automated botnet probing.",
            realWorldContext = "Modern enterprise environments face advanced persistent threats (APTs) that bypass signature firewalls by blending with legitimate admin traffic.",
            expectedOutcomes = listOf(
                "Real-time packet inspection and feature extraction engine",
                "Explainable machine learning scoring identifying anomalous socket behavior",
                "Interactive SOC triage dashboard with incident severity breakdown"
            ),
            suggestedTools = listOf("Python", "FastAPI", "scikit-learn", "Suricata", "Zeek", "Docker"),
            implementationGuidance = listOf(
                "Ingest live or recorded PCAP/NetFlow log streams.",
                "Extract statistical session features (timing, byte entropy, flow duration).",
                "Train isolation forests to detect anomalous deviations."
            ),
            evaluationCriteria = listOf(
                "Detection accuracy and false-positive suppression rate",
                "Packet parsing throughput and notification latency",
                "Clarity of SOC incident visualization"
            )
        ),
        Challenge(
            id = "CYB-F-02",
            themeId = "cybersecurity",
            level = ChallengeLevel.FLAGSHIP,
            title = "Secure Smart-Contract Vulnerability & Reentrancy Analysis",
            summary = "Construct an automated static and dynamic audit tool that scans EVM smart contracts for reentrancy, integer overflows, and front-running risks.",
            realWorldContext = "Decentralized finance protocols have lost billions due to subtle reentrancy and access-control oversights in contract code.",
            expectedOutcomes = listOf(
                "AST parser and bytecode analyzer for Solidity contracts",
                "Automated detection of standard SWC (Smart Contract Weakness) patterns",
                "Detailed remediation report with patched code snippets"
            ),
            suggestedTools = listOf("Solidity", "Slither", "Foundry", "Rust", "Python"),
            implementationGuidance = listOf(
                "Parse contract Abstract Syntax Tree (AST).",
                "Verify state changes before external calls (checks-effects-interactions).",
                "Simulate transactions in a local testnet fork."
            ),
            evaluationCriteria = listOf(
                "Breadth of detected vulnerability signatures",
                "Actionability of remediation suggestions",
                "Audit speed"
            )
        ),
        Challenge(
            id = "CYB-M-01",
            themeId = "cybersecurity",
            level = ChallengeLevel.MEDIUM,
            title = "Phishing URL Risk Classification & Domain Age Auditor",
            summary = "Build an ML-powered browser extension and API that evaluates web addresses, DNS registration age, and DOM heuristics to detect deceptive phishing portals.",
            realWorldContext = "Spear-phishing campaigns rapidly register typosquatting domains that stay active just long enough to harvest credentials.",
            expectedOutcomes = listOf(
                "Lightweight URL reputation classifier",
                "Domain WHOIS and SSL certificate age verification module",
                "Browser banner warning users before entering sensitive credentials"
            ),
            suggestedTools = listOf("Python", "Flask", "XGBoost", "JavaScript WebExtension"),
            implementationGuidance = listOf(
                "Analyze URL lexical patterns.",
                "Query DNS resolution time and SSL validity.",
                "Provide intuitive risk tiering."
            ),
            evaluationCriteria = listOf("Classification accuracy", "Inference speed under 80ms", "Extension UI clarity")
        ),
        Challenge(
            id = "CYB-M-02",
            themeId = "cybersecurity",
            level = ChallengeLevel.MEDIUM,
            title = "Blockchain Transaction Anomaly & Mixer Explorer",
            summary = "Create an open ledger transaction monitor that detects tumbling, mixing, or sudden wash-trading volumes across tracked wallet addresses.",
            realWorldContext = "Compliance teams and investigators require visual tools to trace illicit token movements across complex token swaps.",
            expectedOutcomes = listOf(
                "Graph visualization of wallet fund transfers",
                "Anomaly alert for cyclic transactions or high-velocity splitting",
                "Address risk scoring module"
            ),
            suggestedTools = listOf("Ethers.js", "D3.js", "Node.js", "WebSockets"),
            implementationGuidance = listOf(
                "Listen to pending/confirmed transactions via public RPC.",
                "Construct directed graph of sender-receiver relationships.",
                "Highlight suspicious clusters."
            ),
            evaluationCriteria = listOf("Graph rendering responsiveness", "Pattern detection logic", "Clarity of risk heuristics")
        ),
        Challenge(
            id = "CYB-E-01",
            themeId = "cybersecurity",
            level = ChallengeLevel.EASY,
            title = "Password Strength, Entropy & Breach Auditor",
            summary = "Develop a client-side password entropy evaluator and breach auditor that checks credentials against compromised dictionary hashes without exposing secrets.",
            realWorldContext = "Users regularly reuse weak passwords due to lack of immediate, actionable feedback on cracking complexity.",
            expectedOutcomes = listOf(
                "Entropy calculator based on character diversity and pattern dictionaries",
                "k-Anonymity API integration with HaveIBeenPwned hash ranges",
                "Interactive password generation assistant"
            ),
            suggestedTools = listOf("HTML5", "Vanilla JavaScript", "Web Crypto API", "CSS"),
            implementationGuidance = listOf(
                "Calculate Shannon entropy and crack-time approximations.",
                "Hash password with SHA-1 client-side and query 5-char prefix.",
                "Deliver tips for passphrases."
            ),
            evaluationCriteria = listOf("Zero secret leakage", "Accuracy of entropy math", "Responsive UI feedback")
        ),
        Challenge(
            id = "CYB-E-02",
            themeId = "cybersecurity",
            level = ChallengeLevel.EASY,
            title = "Encrypted In-Browser Document Drop & Verification",
            summary = "Implement an end-to-end encrypted in-browser file transfer app using AES-GCM and public-key exchange for temporary secure document drops.",
            realWorldContext = "Sharing sensitive documents over plaintext email risks intercept and data leakage.",
            expectedOutcomes = listOf(
                "Client-side file encryption with user-defined or generated key",
                "Self-decrypting download link or passphrase verification",
                "Clean drag-and-drop file interface"
            ),
            suggestedTools = listOf("Web Crypto API", "JavaScript", "IndexedDB", "CSS3"),
            implementationGuidance = listOf(
                "Use AES-GCM 256-bit encryption before payload leaves the browser.",
                "Generate unique IV for each drop.",
                "Provide clean download workflow."
            ),
            evaluationCriteria = listOf("Cryptographic correctness", "User experience", "Local decryption speed")
        ),

        // Space Technology
        Challenge(
            id = "SPC-F-01",
            themeId = "space",
            level = ChallengeLevel.FLAGSHIP,
            title = "Satellite Imagery Intelligence for Environmental Change",
            summary = "Build an automated computer vision pipeline that processes multi-spectral satellite imagery to detect deforestation, reservoir shrinkage, and urban heat islands.",
            realWorldContext = "Earth observation satellites beam terabytes of imagery daily requiring automated segmentation to guide climate intervention.",
            expectedOutcomes = listOf(
                "Multi-temporal satellite tile alignment and NDVI index calculator",
                "Segmentation model highlighting significant land-cover delta over time",
                "Web map dashboard with interactive time-lapse slider"
            ),
            suggestedTools = listOf("Python", "PyTorch", "Rasterio", "GDAL", "Mapbox GL"),
            implementationGuidance = listOf(
                "Ingest Sentinel-2 open imagery.",
                "Calculate Normalized Difference Vegetation Index (NDVI).",
                "Flag anomalous index variance."
            ),
            evaluationCriteria = listOf("Segmentation accuracy", "Geospatial coordinate handling", "Map interaction smoothness")
        ),
        Challenge(
            id = "SPC-F-02",
            themeId = "space",
            level = ChallengeLevel.FLAGSHIP,
            title = "Intelligent Satellite Telemetry Anomaly Detection",
            summary = "Develop a multivariate streaming telemetry analyzer that predicts solar array degradation and reaction-wheel friction spikes before hardware failure occurs.",
            realWorldContext = "CubeSats and orbital craft have limited diagnostic bandwidth and rely on ground systems to detect early telemetry trends.",
            expectedOutcomes = listOf(
                "Streaming telemetry ingest pipeline for simulated satellite subsystems",
                "Multivariate time-series forecasting detecting subsystem drift",
                "Visual health telemetry status panel"
            ),
            suggestedTools = listOf("Python", "FastAPI", "InfluxDB", "Chart.js", "LSTM"),
            implementationGuidance = listOf(
                "Simulate power, temperature, attitude telemetry.",
                "Train time-series forecasting models on nominal behavior.",
                "Trigger predictive failure warnings."
            ),
            evaluationCriteria = listOf("Lead time before simulated failure", "Alert precision", "Dashboard responsiveness")
        ),
        Challenge(
            id = "SPC-M-01",
            themeId = "space",
            level = ChallengeLevel.MEDIUM,
            title = "Satellite Image Terrain & Cloud Cover Classification",
            summary = "Train an efficient convolutional classifier to distinguish satellite ground imagery into cloud cover, agricultural land, water bodies, and developed zones.",
            realWorldContext = "Rapid cloud masking and terrain tagging is the essential first filter for ground station image ingestion.",
            expectedOutcomes = listOf(
                "Trained image classifier with >90% validation accuracy",
                "Image upload and instant multi-class probability breakdown",
                "Exportable classification summary"
            ),
            suggestedTools = listOf("Python", "TensorFlow / PyTorch", "Flask", "Tailwind CSS"),
            implementationGuidance = listOf(
                "Utilize pre-trained ResNet backbones on open EuroSAT data.",
                "Provide drag-and-drop test image upload.",
                "Display class confidence percentages."
            ),
            evaluationCriteria = listOf("Model accuracy and inference latency", "Clean web UI", "Confidence calibration")
        ),
        Challenge(
            id = "SPC-M-02",
            themeId = "space",
            level = ChallengeLevel.MEDIUM,
            title = "Orbital Data 3D Visualisation Globe Dashboard",
            summary = "Create a 3D Earth globe visualization tracking real-time positions, orbital paths, and ground footprints of active research and weather satellites.",
            realWorldContext = "Flight directors and students need intuitive 3D spatial awareness of satellite orbits and ground station communication windows.",
            expectedOutcomes = listOf(
                "Interactive 3D globe with textured Earth",
                "TLE (Two-Line Element) orbital propagator computing real-time coordinates",
                "Satellite info card showing velocity, altitude, and upcoming ground pass"
            ),
            suggestedTools = listOf("JavaScript", "Three.js", "satellite.js", "TLE data"),
            implementationGuidance = listOf(
                "Fetch active satellite TLE datasets.",
                "Propagate SGP4 coordinates using satellite.js.",
                "Render orbital rings and ground projection footprint."
            ),
            evaluationCriteria = listOf("Framerate stability", "Astronomical coordinate math", "Usability of satellite selector")
        ),
        Challenge(
            id = "SPC-E-01",
            themeId = "space",
            level = ChallengeLevel.EASY,
            title = "Interactive Solar System Orbital Mechanics Explorer",
            summary = "Build an educational, accurate scale model of the solar system featuring planetary orbits, relative velocity, and celestial physical characteristics.",
            realWorldContext = "Interactive astronomy education benefits from accurate comparative views of planetary size, distance, and orbital mechanics.",
            expectedOutcomes = listOf(
                "Interactive Canvas or SVG orbital animation with speed control",
                "Planetary detail drawer showing mass, orbital period, and atmospheric composition",
                "Distance and scale toggle for realistic versus readable modes"
            ),
            suggestedTools = listOf("HTML5 Canvas", "CSS3", "JavaScript"),
            implementationGuidance = listOf(
                "Establish Keplerian orbital period ratios.",
                "Add click handlers for each planet node.",
                "Ensure high-contrast accessible design."
            ),
            evaluationCriteria = listOf("Smooth animation", "Educational accuracy", "Mobile touch support")
        ),
        Challenge(
            id = "SPC-E-02",
            themeId = "space",
            level = ChallengeLevel.EASY,
            title = "Visible Satellite Pass Prediction & Sky Chart Visualiser",
            summary = "Design a clean tool that calculates upcoming ISS and visible satellite flyovers for any city, displaying look angles, compass bearings, and visibility duration.",
            realWorldContext = "Stargazers and amateur radio operators need quick predictions of when satellites will rise above the local horizon.",
            expectedOutcomes = listOf(
                "City/coordinate search with instant pass calculation",
                "Visual sky-chart compass showing rise, peak elevation, and set trajectory",
                "Countdown timer to the next visible pass"
            ),
            suggestedTools = listOf("JavaScript", "HTML5", "OpenStreetMap API", "CSS"),
            implementationGuidance = listOf(
                "Calculate azimuth and elevation relative to user latitude/longitude.",
                "Filter for dark hour passes.",
                "Draw the sky path on an interactive radial dial."
            ),
            evaluationCriteria = listOf("Pass time accuracy", "Sky chart readability", "Minimal overhead")
        ),

        // Quantum Computing
        Challenge(
            id = "QNT-F-01",
            themeId = "quantum",
            level = ChallengeLevel.FLAGSHIP,
            title = "Quantum-Inspired Optimisation for High-Dimensional Logistics",
            summary = "Implement a simulated annealing and QAOA inspired solver for high-dimensional logistics and job-shop scheduling problems.",
            realWorldContext = "Complex industrial supply chains face NP-hard routing problems where quantum-inspired heuristics uncover near-optimal paths faster than brute force.",
            expectedOutcomes = listOf(
                "QUBO problem formulation module",
                "Quantum-inspired annealing algorithm benchmarked against classical baselines",
                "Visual convergence dashboard showing energy-state minimization over iterations"
            ),
            suggestedTools = listOf("Python", "NumPy", "Qiskit Optimization", "Chart.js"),
            implementationGuidance = listOf(
                "Formulate traveling salesperson or scheduling as a QUBO matrix.",
                "Simulate quantum tunneling through energy barriers.",
                "Compare time-to-solution against classical baselines."
            ),
            evaluationCriteria = listOf("Formulation rigor", "Algorithm speed and solution quality", "Comparison clarity")
        ),
        Challenge(
            id = "QNT-F-02",
            themeId = "quantum",
            level = ChallengeLevel.FLAGSHIP,
            title = "Classical vs Quantum Algorithm Empirical Benchmarking",
            summary = "Develop an empirical benchmarking playground that pits Grover's search and Shor's period-finding against classical counterparts across increasing problem scales.",
            realWorldContext = "Engineers require tangible empirical evidence of where quantum advantage begins versus classical polynomial scaling.",
            expectedOutcomes = listOf(
                "Simulation of classical linear search vs Grover amplitude amplification",
                "Theoretical and empirical complexity scaling graphs (O(N) vs O(√N))",
                "Interactive circuit depth and gate count telemetry"
            ),
            suggestedTools = listOf("Python", "Cirq / Qiskit", "FastAPI", "React / Vanilla JS"),
            implementationGuidance = listOf(
                "Simulate oracle queries and state vector rotations.",
                "Count gate executions and state probabilities.",
                "Plot runtime curves as search space grows."
            ),
            evaluationCriteria = listOf("Mathematical fidelity", "Clarity of quantum speedup proof", "Usability of interactive controls")
        ),
        Challenge(
            id = "QNT-M-01",
            themeId = "quantum",
            level = ChallengeLevel.MEDIUM,
            title = "Interactive 3-Qubit Quantum Circuit Simulator",
            summary = "Build an interactive browser circuit builder allowing users to place Hadamard, Pauli, CNOT, and Phase gates on 3 qubits and observe state vector changes.",
            realWorldContext = "Students learning quantum mechanics struggle with abstract matrix multiplication without real-time state visualization.",
            expectedOutcomes = listOf(
                "Click-to-place quantum gate canvas",
                "Matrix multiplication engine computing final state vector amplitudes",
                "Probability histogram of measurement outcomes"
            ),
            suggestedTools = listOf("JavaScript", "HTML5 Canvas / SVG", "Math.js", "CSS"),
            implementationGuidance = listOf(
                "Represent single-qubit gates as 2x2 unitary matrices, two-qubit as 4x4.",
                "Compute tensor products.",
                "Display probabilities dynamically."
            ),
            evaluationCriteria = listOf("Mathematical correctness", "Circuit layout responsiveness", "Clean probability visuals")
        ),
        Challenge(
            id = "QNT-M-02",
            themeId = "quantum",
            level = ChallengeLevel.MEDIUM,
            title = "3D Bloch Sphere Qubit State Visualisation Tool",
            summary = "Create a 3D interactive Bloch Sphere that represents single-qubit pure states, phase angles (θ, φ), and animated rotations under quantum logic gates.",
            realWorldContext = "The Bloch sphere is the foundational geometric representation of a two-level quantum system, essential for intuitive quantum gate intuition.",
            expectedOutcomes = listOf(
                "3D interactive Bloch sphere rendered with WebGL / Three.js",
                "State vector arrow responding to coordinate sliders and gate buttons",
                "Display of Dirac bra-ket notation: |ψ⟩ = cos(θ/2)|0⟩ + e^(iφ)sin(θ/2)|1⟩"
            ),
            suggestedTools = listOf("Three.js", "JavaScript", "HTML5"),
            implementationGuidance = listOf(
                "Render unit sphere with latitude/longitude guides.",
                "Animate state vector smoothly along spherical arcs.",
                "Update amplitude formulas in real time."
            ),
            evaluationCriteria = listOf("3D rendering quality", "Smooth rotational interpolations", "Accessible coordinate controls")
        ),
        Challenge(
            id = "QNT-E-01",
            themeId = "quantum",
            level = ChallengeLevel.EASY,
            title = "Interactive Superposition & Entanglement Learning Playground",
            summary = "Design an interactive step-by-step tutorial introducing superposition, entanglement, and quantum measurement through bite-sized puzzles.",
            realWorldContext = "Demystifying quantum mechanics for beginners requires progressive interactive challenges rather than dry textbook theorems.",
            expectedOutcomes = listOf(
                "Sequential interactive modules (Superposition, Entanglement, Teleportation)",
                "Interactive coin-flip simulation demonstrating quantum random measurement",
                "Knowledge-check quizzes with immediate visual feedback"
            ),
            suggestedTools = listOf("HTML5", "CSS3", "JavaScript"),
            implementationGuidance = listOf(
                "Provide visual metaphors (quantum coin that spins until observed).",
                "Track learner progress.",
                "Zero complex jargon in introductory explanations."
            ),
            evaluationCriteria = listOf("Pedagogical clarity", "Design restraint", "Flawless mobile interaction")
        ),
        Challenge(
            id = "QNT-E-02",
            themeId = "quantum",
            level = ChallengeLevel.EASY,
            title = "Superposition Wavefunction Collapse Simulator",
            summary = "Develop an interactive visual tool showing how equal superposition collapses into discrete binary states across repeated measurement trials.",
            realWorldContext = "Understanding probability distributions and Born's rule is the first step toward grasp of quantum hardware measurement runs.",
            expectedOutcomes = listOf(
                "Interactive measurement dial triggering 1 to 10,000 simulated shots",
                "Dynamic bar chart updating as sample counts approach distribution",
                "Statistical variance calculation demonstrating the Law of Large Numbers"
            ),
            suggestedTools = listOf("JavaScript", "HTML5 Canvas", "CSS Flexbox"),
            implementationGuidance = listOf(
                "Simulate pseudo-random quantum measurement collapses.",
                "Plot cumulative frequencies dynamically.",
                "Provide slider to skew basis probabilities."
            ),
            evaluationCriteria = listOf("Chart performance under 10k shots", "Clear scientific labeling", "Clean visual aesthetic")
        ),

        // FinTech
        Challenge(
            id = "FIN-F-01",
            themeId = "fintech",
            level = ChallengeLevel.FLAGSHIP,
            title = "Explainable Real-time Financial Fraud Scoring & SHAP Attribution",
            summary = "Engineer a high-throughput transaction scoring pipeline utilizing SHAP to provide real-time regulatory compliance and fraud explanations.",
            realWorldContext = "Banking regulations require financial institutions to explain exactly why a credit card payment or wire transfer was flagged or frozen.",
            expectedOutcomes = listOf(
                "Low-latency fraud scoring engine evaluating transaction velocity and geolocation delta",
                "SHAP feature importance waterfall chart generated for every flagged payment",
                "Compliance investigation portal allowing human analysts to confirm or dispute alerts"
            ),
            suggestedTools = listOf("Python", "FastAPI", "XGBoost", "SHAP", "Chart.js"),
            implementationGuidance = listOf(
                "Train model on anonymized credit card fraud benchmark.",
                "Compute localized SHAP values for anomaly triggers.",
                "Render intuitive bar breakdowns."
            ),
            evaluationCriteria = listOf("Inference throughput", "Clarity of human-readable explanations", "Dashboard usability")
        ),
        Challenge(
            id = "FIN-F-02",
            themeId = "fintech",
            level = ChallengeLevel.FLAGSHIP,
            title = "Inclusive Alternative Credit-Risk Scoring Prototype",
            summary = "Create an alternative credit-scoring model incorporating utility payment consistency, cash-flow stability, and business turnover for unbanked micro-entrepreneurs.",
            realWorldContext = "Millions of small merchants lack formal credit histories, excluding them from affordable commercial credit despite consistent cash flows.",
            expectedOutcomes = listOf(
                "Multi-source financial data ingest simulator (utility bills, UPI cash flows, merchant logs)",
                "Alternative credit risk algorithm with transparent score calibration (300-850)",
                "Applicant transparency portal detailing steps to improve score eligibility"
            ),
            suggestedTools = listOf("Python", "scikit-learn", "FastAPI", "HTML5/CSS"),
            implementationGuidance = listOf(
                "Weight cash-flow volatility, recurring payment timeliness, savings buffer.",
                "Implement fair-lending bias mitigation checks.",
                "Provide actionable improvement suggestions."
            ),
            evaluationCriteria = listOf("Fairness and bias mitigation", "Model stability", "Applicant portal clarity")
        ),
        Challenge(
            id = "FIN-M-01",
            themeId = "fintech",
            level = ChallengeLevel.MEDIUM,
            title = "Personal Expense Intelligence & Subscription Creep Auditor",
            summary = "Build an intelligent personal budget dashboard with automated receipt parsing, categorical cash-burn projections, and anomaly subscription detection.",
            realWorldContext = "Modern consumers lose hundreds annually to recurring forgotten subscriptions and irregular expenditure drift.",
            expectedOutcomes = listOf(
                "CSV transaction import and automated merchant categorization",
                "Monthly burn-rate chart with 30-day forward cash-flow projection",
                "Automated detection of recurring price creep on subscription charges"
            ),
            suggestedTools = listOf("JavaScript", "Chart.js", "IndexedDB", "CSS Grid"),
            implementationGuidance = listOf(
                "Pattern matching for bank statement descriptions.",
                "Compute rolling averages and forecast month-end balance.",
                "Highlight charges repeating at 30-day intervals."
            ),
            evaluationCriteria = listOf("Data privacy (100% client-side processing)", "Chart clarity", "Categorization accuracy")
        ),
        Challenge(
            id = "FIN-M-02",
            themeId = "fintech",
            level = ChallengeLevel.MEDIUM,
            title = "Suspicious Transaction Network Graph Explorer",
            summary = "Develop a visual workbench that maps accounts, shared devices, and transaction flows to expose synthetic identity rings and mule account networks.",
            realWorldContext = "Fraud syndicates use networks of mule accounts to split and launder stolen funds within minutes of unauthorized access.",
            expectedOutcomes = listOf(
                "Network graph connecting bank accounts, IP addresses, and phone identifiers",
                "Clustering algorithm highlighting high-degree money mule hubs",
                "Timeline playback of suspicious fund dispersion"
            ),
            suggestedTools = listOf("D3.js", "JavaScript", "Node.js"),
            implementationGuidance = listOf(
                "Construct multi-partite graph linking accounts through shared attributes.",
                "Calculate centrality scores.",
                "Provide timeline scrubbing to trace money velocity."
            ),
            evaluationCriteria = listOf("Graph layout performance", "Clustering accuracy", "Investigator workflow efficiency")
        ),
        Challenge(
            id = "FIN-E-01",
            themeId = "fintech",
            level = ChallengeLevel.EASY,
            title = "Dynamic 50/30/20 Budget Planning & Debt Snowball Tool",
            summary = "Design an intuitive 50/30/20 budget planner with income allocation dials, debt snowball repayment calculators, and target savings projections.",
            realWorldContext = "Young adults starting careers need clean financial planning tools free from aggressive ad-driven loan promotions.",
            expectedOutcomes = listOf(
                "Interactive income breakdown based on Needs, Wants, and Savings rules",
                "Debt payoff schedule comparator (Snowball vs Avalanche)",
                "Exportable financial summary"
            ),
            suggestedTools = listOf("HTML5", "CSS3", "JavaScript"),
            implementationGuidance = listOf(
                "Dynamic input calculations without page reloads.",
                "Responsive visual feedback on budget surplus or deficit.",
                "Strict focus on readable tabular numerals."
            ),
            evaluationCriteria = listOf("Calculation precision", "Zero-clutter user experience", "Mobile touch friendliness")
        ),
        Challenge(
            id = "FIN-E-02",
            themeId = "fintech",
            level = ChallengeLevel.EASY,
            title = "Compound Interest & Inflation Purchasing Power Visualiser",
            summary = "Build an interactive financial simulator illustrating the power of compound interest, inflation erosion, and portfolio diversification.",
            realWorldContext = "Understanding how inflation diminishes idle savings versus compound investments is essential for long-term financial security.",
            expectedOutcomes = listOf(
                "Compound interest calculator with customizable monthly deposits and inflation toggles",
                "Visual comparison of cash savings versus index investing over 10-40 years",
                "Interactive inflation cost-of-living comparison slider"
            ),
            suggestedTools = listOf("HTML5 Canvas / SVG", "Vanilla JS", "CSS"),
            implementationGuidance = listOf(
                "Compute future value: FV = P(1 + r/n)^(nt).",
                "Adjust for real purchasing power: (FV) / (1 + i)^t.",
                "Render high-legibility comparison curves."
            ),
            evaluationCriteria = listOf("Mathematical accuracy", "Simplicity and accessibility", "Visual finish")
        ),

        // Energy & Sustainability
        Challenge(
            id = "SUS-F-01",
            themeId = "sustainability",
            level = ChallengeLevel.FLAGSHIP,
            title = "Intelligent Renewable Energy Forecasting via Weather Models",
            summary = "Develop a hybrid machine learning model that forecasts solar panel array and wind turbine yield 48 hours in advance using numerical weather predictions.",
            realWorldContext = "Intermittent renewable generation causes grid instability unless regional utilities can predict production swings with high confidence.",
            expectedOutcomes = listOf(
                "Time-series model predicting hourly megawatt generation from weather features",
                "Confidence intervals (P10, P50, P90) indicating generation uncertainty",
                "Utility operator forecast console with weather parameter overlays"
            ),
            suggestedTools = listOf("Python", "Prophet / LightGBM", "FastAPI", "Chart.js"),
            implementationGuidance = listOf(
                "Ingest historical solar irradiance, wind speed, temperature.",
                "Train gradient boosted regression models.",
                "Produce hourly curves with clear error margins."
            ),
            evaluationCriteria = listOf("Mean Absolute Percentage Error (MAPE)", "Uncertainty calibration", "Dashboard clarity")
        ),
        Challenge(
            id = "SUS-F-02",
            themeId = "sustainability",
            level = ChallengeLevel.FLAGSHIP,
            title = "Smart-Grid Peak Shaving & EV Fleet Coordination Simulator",
            summary = "Construct a dynamic load-balancing simulator that coordinates smart EV charging stations and industrial batteries to shave peak energy consumption.",
            realWorldContext = "Unmanaged EV charging during evening peak hours threatens substation transformer overloads and forces deployment of dirty peaker plants.",
            expectedOutcomes = listOf(
                "Microgrid simulation modeling fluctuating demand, solar generation, and 100+ EV chargers",
                "Dynamic pricing or priority queuing algorithm that flattens aggregate peak load",
                "Substation load profile monitor displaying transformer stress reduction"
            ),
            suggestedTools = listOf("Python", "SimPy / NumPy", "FastAPI", "Canvas"),
            implementationGuidance = listOf(
                "Formulate peak shaving as a constrained optimization problem.",
                "Shift flexible EV charging loads to mid-day solar surplus hours.",
                "Quantify avoided carbon emissions."
            ),
            evaluationCriteria = listOf("Peak-to-average ratio reduction", "Simulation fidelity", "Visual quality of grid monitor")
        ),
        Challenge(
            id = "SUS-M-01",
            themeId = "sustainability",
            level = ChallengeLevel.MEDIUM,
            title = "Household Energy Consumption Analytics & Vampire Drain Detector",
            summary = "Build an IoT energy monitor dashboard that disaggregates household smart meter data to pinpoint vampire power drain and heating inefficiencies.",
            realWorldContext = "Homeowners receive aggregate utility bills without knowing which specific appliances are driving up costs or wasting electricity.",
            expectedOutcomes = listOf(
                "Smart meter time-series ingestion with high/low tariff zone breakdown",
                "Appliance signature disaggregation (refrigerator, AC, standby electronics)",
                "Actionable recommendations showing monetary savings from usage shifts"
            ),
            suggestedTools = listOf("JavaScript", "Chart.js", "Node.js", "CSS3"),
            implementationGuidance = listOf(
                "Analyze baseline night-time consumption to estimate standby vampire draw.",
                "Detect cyclic motor compressor signatures.",
                "Display time-of-use cost savings estimates."
            ),
            evaluationCriteria = listOf("Analytics usability", "Clear energy units (kWh, ₹, kg CO2)", "Responsive layout")
        ),
        Challenge(
            id = "SUS-M-02",
            themeId = "sustainability",
            level = ChallengeLevel.MEDIUM,
            title = "Rooftop Solar & Battery Storage Power Flow Monitor",
            summary = "Create a monitoring dashboard for rooftop solar installations tracking real-time kilowatt output, battery state of charge, and carbon offset milestones.",
            realWorldContext = "Solar system owners need intuitive metrics on solar self-consumption versus grid exports to maximize their investment.",
            expectedOutcomes = listOf(
                "Real-time power flow diagram (Solar → Inverter → Home / Battery / Grid)",
                "Daily and monthly generation versus consumption comparison graphs",
                "Equivalency metrics (trees planted, coal avoided, monetary savings)"
            ),
            suggestedTools = listOf("HTML5 Canvas / SVG", "Chart.js", "JavaScript", "CSS"),
            implementationGuidance = listOf(
                "Animate power flow lines indicating direction of energy transfer.",
                "Calculate self-sufficiency percentage: (solar consumed / total consumed) * 100.",
                "Provide clean tabular summary."
            ),
            evaluationCriteria = listOf("Diagram clarity and animation smoothness", "Metric correctness", "Mobile adaptability")
        ),
        Challenge(
            id = "SUS-E-01",
            themeId = "sustainability",
            level = ChallengeLevel.EASY,
            title = "Personal Lifestyle Carbon Footprint Estimator",
            summary = "Develop a transparent personal carbon footprint calculator evaluating daily transportation, diet, home electricity, and consumer purchases.",
            realWorldContext = "Individuals are often unaware of which personal lifestyle factors contribute most significantly to annual greenhouse gas emissions.",
            expectedOutcomes = listOf(
                "Multi-category questionnaire with regional metric conversion factors",
                "Visual breakdown comparing personal tonnage to national and global averages",
                "Personalized roadmap to reduce emissions by 20% over 12 months"
            ),
            suggestedTools = listOf("HTML5", "CSS3", "JavaScript"),
            implementationGuidance = listOf(
                "Use verified IPCC emission factors.",
                "Display immediate dynamic chart updates as questions are answered.",
                "Provide realistic reduction milestones."
            ),
            evaluationCriteria = listOf("Scientific basis of emission coefficients", "Form usability", "Clean typographic presentation")
        ),
        Challenge(
            id = "SUS-E-02",
            themeId = "sustainability",
            level = ChallengeLevel.EASY,
            title = "Daily Sustainable Habit Tracking & Impact Calculator",
            summary = "Design a lightweight, privacy-focused daily habit checklist for tracking public transit use, reusable container adoption, and composting.",
            realWorldContext = "Building consistent environmental habits requires positive reinforcement, streak tracking, and tangible cumulative impact metrics.",
            expectedOutcomes = listOf(
                "Daily checklist with customizable sustainable action items",
                "Cumulative savings counter (single-use plastics avoided, liters of water saved)",
                "Local storage persistence with zero tracking or telemetry"
            ),
            suggestedTools = listOf("HTML5", "CSS Grid", "JavaScript (LocalStorage)"),
            implementationGuidance = listOf(
                "Store streaks and completed habits in local storage.",
                "Calculate environmental impact multipliers upon task completion.",
                "Provide clean interface."
            ),
            evaluationCriteria = listOf("Usability and speed", "100% offline functionality", "Polished accessible design")
        )
    )

    val faqs: List<FaqItem> = listOf(
        FaqItem(
            id = "faq-1",
            question = "What is CHAKRAVYUH?",
            answer = "CHAKRAVYUH: CYBERSHIELD HACKATHON is the largest offline hackathon hosted at VIT-AP University, bringing together student developers to design cyber-resilient solutions across five technology frontiers."
        ),
        FaqItem(
            id = "faq-2",
            question = "When and where is the event conducted?",
            answer = "The hackathon is conducted offline on 27–28 October 2026 at the VIT-AP University campus near Amaravati / Vijayawada."
        ),
        FaqItem(
            id = "faq-3",
            question = "What are the three challenge tiers (Flagship, Medium, Easy)?",
            answer = "Each of the five frontiers offers three distinct difficulty tiers: Flagship (advanced, high-impact architecture), Medium (applied problem-solving), and Easy (foundational challenges)."
        ),
        FaqItem(
            id = "faq-4",
            question = "Is On-Duty (OD) leave provided for participants?",
            answer = "Yes, official On-Duty (OD) attendance approval is provided for all confirmed participating students from recognised institutions."
        ),
        FaqItem(
            id = "faq-5",
            question = "What is the total prize pool?",
            answer = "The total prize pool is ₹7,00,000, distributed across winner, runner-up, and special category tracks in all five frontiers."
        ),
        FaqItem(
            id = "faq-6",
            question = "How are teams formed?",
            answer = "Teams can consist of 2 to 4 members. Interdisciplinary teams with cross-functional development, design, and domain expertise are highly encouraged."
        )
    )

    val timeline: List<TimelineItem> = listOf(
        TimelineItem(
            dayNumber = "DAY 01",
            dateText = "27 OCTOBER 2026",
            phaseTag = "Deployment Phase",
            title = "Orientation, Team Mobilisation & Build Kickoff",
            narrative = "Opening ceremony, problem exploration, track allocation, and initial prototype architecture. Teams select their frontier, analyse problem statements, and begin 24-hour continuous development."
        ),
        TimelineItem(
            dayNumber = "DAY 02",
            dateText = "28 OCTOBER 2026",
            phaseTag = "The Breakthrough",
            title = "Final Implementation, Demonstrations & Valedictory",
            narrative = "Sprint deadline, code freeze, technical evaluation with industry juries, stage presentations, and prize distribution ceremony celebrating innovative breakthroughs."
        )
    )

    val partners: List<Partner> = listOf(
        Partner("VIT-AP University", "Host Institution"),
        Partner("Unstop", "Powered By"),
        Partner("Pocket Lab", "Technical Partner"),
        Partner("Qualium AI", "Platinum Sponsor"),
        Partner("Notion", "Creative Partner"),
        Partner("NEP Saarthi", "Organiser · NEP 2020"),
        Partner("VISH", "Collaboration Partner"),
        Partner("Innovators Quest", "ACS · IIEC VIT-AP")
    )

    // Bookmarking state
    private val _bookmarkedIds = MutableStateFlow<Set<String>>(emptySet())
    val bookmarkedIds: StateFlow<Set<String>> = _bookmarkedIds.asStateFlow()

    fun toggleBookmark(challengeId: String) {
        _bookmarkedIds.update { current ->
            if (current.contains(challengeId)) current - challengeId else current + challengeId
        }
    }
}
