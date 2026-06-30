package com.example.data

data class QcArticle(
    val id: Int,
    val code: String,
    val title: String,
    val category: String,
    val objective: String,
    val referenceSop: String = "SOP-QC-REF"
)

object QcArticlesData {
    val categories = listOf(
        "Chromatography (HPLC & GC)",
        "Spectroscopy (UV & IR)",
        "Lab Instruments & Calibration",
        "Solutions, Reagents & Standards",
        "Wet Chemistry & Limit Tests",
        "Lab Quality Systems (OOS, OOT)",
        "Microbiology QC & Media",
        "Documentation & GMP Compliance",
        "Method Validation & Stability"
    )

    val articles = listOf(
        // 1. Chromatography (HPLC & GC) (1-25)
        QcArticle(1, "QC-ART-001", "Calibration of High-Performance Liquid Chromatography (HPLC) System", "Chromatography (HPLC & GC)", "To establish the procedure for calibration of pump flow rate, wavelength accuracy, column oven temperature, injector precision, and detector linearity of HPLC."),
        QcArticle(2, "QC-ART-002", "HPLC Column Management: Care, Maintenance, and Storage", "Chromatography (HPLC & GC)", "To define procedures for cleaning, washing, documenting, and safely storing reverse phase and normal phase HPLC columns."),
        QcArticle(3, "QC-ART-003", "Preparation and Degassing of HPLC Mobile Phases", "Chromatography (HPLC & GC)", "To describe the standard methods for mobile phase preparation, pH adjustment, filtration, and helium or sonication degassing."),
        QcArticle(4, "QC-ART-004", "HPLC Troubleshooting: Resolving Baseline Noise, Drifts, and Spikes", "Chromatography (HPLC & GC)", "To outline steps for diagnosing and correcting common HPLC baseline issues such as air bubbles, lamp degradation, and temperature fluctuations."),
        QcArticle(5, "QC-ART-005", "HPLC Troubleshooting: Managing High System Pressure and Column Clogging", "Chromatography (HPLC & GC)", "To provide standard instructions for locating high pressure causes and cleaning clogged columns or inline filters."),
        QcArticle(6, "QC-ART-006", "System Suitability Criteria for HPLC/GC Chromatographic Analysis", "Chromatography (HPLC & GC)", "To outline acceptance parameters for system suitability, including tailing factor, theoretical plates, resolution, and peak area RSD."),
        QcArticle(7, "QC-ART-007", "Calibration of Gas Chromatography (GC) Pump and Flow Controllers", "Chromatography (HPLC & GC)", "To detail calibration procedures for gas flow rates, split ratio, column flow, and carrier gas pressure control systems of GC."),
        QcArticle(8, "QC-ART-008", "Care and Cleaning of Gas Chromatography (GC) Injector Port Liner", "Chromatography (HPLC & GC)", "To describe the routine maintenance, inspection, and replacement of GC liners and septa to prevent peak tailing or sample carryover."),
        QcArticle(9, "QC-ART-009", "Standard Operation and Calibration of Flame Ionization Detector (FID)", "Chromatography (HPLC & GC)", "To establish guidelines for ignition, stabilization, gas flow optimization, and noise checking of Flame Ionization Detectors."),
        QcArticle(10, "QC-ART-010", "Operation and Calibration of Headspace Autosampler for GC", "Chromatography (HPLC & GC)", "To describe the operation, pressure check, and temperature calibration of headspace samplers used in residual solvents testing."),
        QcArticle(11, "QC-ART-011", "Wavelength Accuracy Verification of Photodiode Array (PDA) Detectors", "Chromatography (HPLC & GC)", "To outline the method for PDA wavelength calibration using standard solutions of anthracene or caffeine."),
        QcArticle(12, "QC-ART-012", "Prevention of Ghost Peaks in HPLC and GC Chromatography", "Chromatography (HPLC & GC)", "To provide troubleshooting guidelines for identifying the source of phantom or ghost peaks in blank injections."),
        QcArticle(13, "QC-ART-013", "HPLC Autosampler Needle and Loop Wash Procedures", "Chromatography (HPLC & GC)", "To establish washing cycles and solvent selection to eliminate injector carryover and cross-contamination."),
        QcArticle(14, "QC-ART-014", "Troubleshooting Peak Split and Peak Broadening in HPLC Chromatograms", "Chromatography (HPLC & GC)", "To outline diagnostic steps for peak abnormalities caused by column void, overload, or mismatched sample diluent."),
        QcArticle(15, "QC-ART-015", "Calibration and Care of GC Thermal Conductivity Detector (TCD)", "Chromatography (HPLC & GC)", "To describe standard operating controls, cleaning, and sensitivity checking of GC TCD units."),
        QcArticle(16, "QC-ART-016", "SOP for Handling and Disposal of Hazardous Chromatography Mobile Phase Waste", "Chromatography (HPLC & GC)", "To outline safe collection, segregation, storage, and disposal of toxic organic solvent effluents from HPLC systems."),
        QcArticle(17, "QC-ART-017", "Standard Rules for Chromatographic Integration Parameters", "Chromatography (HPLC & GC)", "To establish compliance rules for baseline integration, peak width, threshold, and prohibition of manual integration adjustments without QA approval."),
        QcArticle(18, "QC-ART-018", "HPLC Column Qualification and Efficiency Checking", "Chromatography (HPLC & GC)", "To outline standard tests for column plate count, capacity factor, asymmetry, and peak resolution to determine column lifespan."),
        QcArticle(19, "QC-ART-019", "Calibration of GC Electron Capture Detector (ECD)", "Chromatography (HPLC & GC)", "To define standard safety requirements and calibration protocols for ECD units used in pesticide residue assays."),
        QcArticle(20, "QC-ART-020", "Procedure for Guard Column Installation and Maintenance", "Chromatography (HPLC & GC)", "To describe the selection, coupling, and replacement frequency of HPLC inline guard cartridges to preserve analytical column performance."),
        QcArticle(21, "QC-ART-021", "Standard Operation of Thin Layer Chromatography (TLC)", "Chromatography (HPLC & GC)", "To define plate preparation, sample spotting, development chamber saturation, and Rf value calculations for TLC analysis."),
        QcArticle(22, "QC-ART-022", "High-Performance Thin-Layer Chromatography (HPTLC) System Calibration", "Chromatography (HPLC & GC)", "To outline the parameters for scanner wavelength accuracy and applicator precision check in HPTLC analyses."),
        QcArticle(23, "QC-ART-023", "Handling and Safety of Compressed Gas Cylinders in Chromatography Lab", "Chromatography (HPLC & GC)", "To describe secure storage, color coding, pressure regulator checks, leak detection, and transport of GC gases."),
        QcArticle(24, "QC-ART-024", "Standard Maintenance of HPLC Pump Piston Seals and Frits", "Chromatography (HPLC & GC)", "To detail the steps for replacement of sapphire pistons, PTFE pump seals, and inlet check valve sonication."),
        QcArticle(25, "QC-ART-025", "GC Column Conditioning and Installation Protocol", "Chromatography (HPLC & GC)", "To outline temperature programming, leak checking, and column installation in GC ovens to prevent stationary phase bleed."),

        // 2. Spectroscopy (UV & IR) (26-45)
        QcArticle(26, "QC-ART-026", "Wavelength Calibration of UV-Vis Spectrophotometer", "Spectroscopy (UV & IR)", "To verify wavelength accuracy of UV-Vis spectrophotometers using Holmium Oxide filter or standard Holmium perchlorate solution."),
        QcArticle(27, "QC-ART-027", "Photometric Accuracy and Linearity Verification in UV-Vis", "Spectroscopy (UV & IR)", "To detail the calibration of absorbance values using standard Potassium Dichromate solutions at specific wavelengths."),
        QcArticle(28, "QC-ART-028", "Stray Light and Resolution Checks in UV-Vis Spectrophotometers", "Spectroscopy (UV & IR)", "To outline the method for verifying stray light limits using Sodium Iodide solution and spectral resolution check using Toluene in Hexane."),
        QcArticle(29, "QC-ART-029", "Selection, Calibration, and Care of Quartz and Glass Cuvettes", "Spectroscopy (UV & IR)", "To describe matched cuvette verification, cleaning with nitric acid/methanol, and optical window protection rules."),
        QcArticle(30, "QC-ART-030", "Calibration of Fourier Transform Infrared (FTIR) Spectrophotometer", "Spectroscopy (UV & IR)", "To describe wavelength calibration of FTIR instruments using NIST-traceable standard Polystyrene film thickness checks."),
        QcArticle(31, "QC-ART-031", "Sample Preparation Techniques for FTIR Spectroscopy (KBr Pellets)", "Spectroscopy (UV & IR)", "To establish the procedure for grinding, mixing, pressing, and handling Potassium Bromide (KBr) discs for solid sample scans."),
        QcArticle(32, "QC-ART-032", "Operation and Maintenance of Attenuated Total Reflection (ATR) in FTIR", "Spectroscopy (UV & IR)", "To outline standard care, cleaning of the zinc selenide or diamond crystal, and sample positioning for ATR scans."),
        QcArticle(33, "QC-ART-033", "Wavelength Calibration and Operation of Atomic Absorption Spectrophotometer (AAS)", "Spectroscopy (UV & IR)", "To establish setup parameters, hollow cathode lamp selection, and burner alignment for heavy metals assay via AAS."),
        QcArticle(34, "QC-ART-034", "Standard Flame Calibration and Optimization in AAS Systems", "Spectroscopy (UV & IR)", "To describe air-acetylene flame adjustments, nebulizer cleaning, and standard curve linearity checks for AAS analysis."),
        QcArticle(35, "QC-ART-035", "Operation and Calibration of Graphite Furnace AAS (GF-AAS)", "Spectroscopy (UV & IR)", "To outline furnace tube temperature ramp validation, sample injection, and background correction parameters."),
        QcArticle(36, "QC-ART-036", "Verification of Stray Light in Infrared Spectrophotometers", "Spectroscopy (UV & IR)", "To detail methods to confirm low baseline noise and verify high energy ratios inside IR optical paths."),
        QcArticle(37, "QC-ART-037", "Deuterium and Halogen Light Lamp Replacement in UV-Vis Instruments", "Spectroscopy (UV & IR)", "To outline standard instructions for lamp alignment, electronic reset, and energy output checks after lamp replacement."),
        QcArticle(38, "QC-ART-038", "Determination of Optical Rotation using Automatic Polarimeter", "Spectroscopy (UV & IR)", "To establish steps for measuring specific optical rotation of active materials using sodium D-line wavelengths."),
        QcArticle(39, "QC-ART-039", "Calibration and Care of Digital Polarimeter Polarizing Tubes", "Spectroscopy (UV & IR)", "To verify specific rotation accuracy using certified sucrose solutions and describe tube cleaning methods."),
        QcArticle(40, "QC-ART-040", "Standard Operation and Verification of Abbe Refractometer", "Spectroscopy (UV & IR)", "To describe measuring refractive index of liquids and calibration checking with standard purified water at 20 degrees Celsius."),
        QcArticle(41, "QC-ART-041", "Operation and Maintenance of Fluorescence Spectrophotometer", "Spectroscopy (UV & IR)", "To define standard excitation, emission wavelength checks, and quantum yield references for fluorometry."),
        QcArticle(42, "QC-ART-042", "Verification of Wavenumber Resolution in FTIR Spectroscopy", "Spectroscopy (UV & IR)", "To establish specific resolution thresholds in infrared scans to guarantee distinct molecular transition signatures."),
        QcArticle(43, "QC-ART-043", "Moisture and Optical Path Care inside Spectroscopic Chambers", "Spectroscopy (UV & IR)", "To outline silica gel replacement, desiccator housing maintenance, and nitrogen purging protocols for IR optics."),
        QcArticle(44, "QC-ART-044", "Operation and Calibration of Near-Infrared (NIR) Spectrometer", "Spectroscopy (UV & IR)", "To describe raw material identity verification using library match and wavelength verification in NIR systems."),
        QcArticle(45, "QC-ART-045", "Inductively Coupled Plasma Mass Spectrometry (ICP-MS) Setup Guidelines", "Spectroscopy (UV & IR)", "To outline plasma gas flow rate, nebulizer configuration, and calibration standards for ultra-trace metal analysis."),

        // 3. Lab Instruments & Calibration (46-75)
        QcArticle(46, "QC-ART-046", "Calibration and Buffer Standardization of Laboratory pH Meters", "Lab Instruments & Calibration", "To establish the daily 3-point calibration procedure using fresh pH 4.01, 7.00, and 10.01 buffers with slope calculation."),
        QcArticle(47, "QC-ART-047", "Care, Storage, and Reconditioning of Glass pH Electrodes", "Lab Instruments & Calibration", "To describe electrode rinsing, storage in 3M KCl electrolyte, and cleaning protocols for clogged junction membranes."),
        QcArticle(48, "QC-ART-048", "Standard Operation and Reagent Standardization of Karl Fischer Titrator", "Lab Instruments & Calibration", "To detail water determination using volumetric Karl Fischer, drift evaluation, and standardization using sodium tartrate."),
        QcArticle(49, "QC-ART-049", "Operation of Coulometric Karl Fischer for Low Moisture Determination", "Lab Instruments & Calibration", "To describe drift monitoring, generator electrode cleaning, and trace water content determination in raw powders."),
        QcArticle(50, "QC-ART-050", "Daily Calibration Check of Electronic Analytical Balances", "Lab Instruments & Calibration", "To define balance leveling, taring, and verification of repeatability using standard calibrated E2 weights."),
        QcArticle(51, "QC-ART-051", "Periodic Balance Calibration: Eccentricity, Linearity, and Repeatability Tests", "Lab Instruments & Calibration", "To establish procedures for testing corner load error, multi-point weight linearity, and minimum weigh calculations."),
        QcArticle(52, "QC-ART-052", "Care, Handling, and Certification of Standard Weight Box", "Lab Instruments & Calibration", "To describe E2 weight storage, handling with clean forceps, and external certification trace protocol."),
        QcArticle(53, "QC-ART-053", "Operation and Calibration of USP Dissolution Apparatus 1 (Basket)", "Lab Instruments & Calibration", "To detail speed rpm calibration, vessel alignment, basket physical inspection, and Prednisone tablet chemical calibration."),
        QcArticle(54, "QC-ART-054", "Operation and Calibration of USP Dissolution Apparatus 2 (Paddle)", "Lab Instruments & Calibration", "To describe paddle clearance limits, dissolution media preparation, temperature control, and automated sampling validation."),
        QcArticle(55, "QC-ART-055", "Standard Calibration of Tablet Disintegration Tester", "Lab Instruments & Calibration", "To detail water bath temperature control, basket raise/lower stroke frequency calibration, and mesh screen checks."),
        QcArticle(56, "QC-ART-056", "Calibration and Verification of Tablet Friability Tester", "Lab Instruments & Calibration", "To establish speed of rotation (25 rpm) and total drum rotations verification (100 turns) for tablet physical test."),
        QcArticle(57, "QC-ART-057", "Standard Calibration of Tablet Hardness Tester", "Lab Instruments & Calibration", "To describe load cell force verification, calibration using standard weights, and anvil cleaning."),
        QcArticle(58, "QC-ART-058", "Operation and Calibration of Melting Point Apparatus", "Lab Instruments & Calibration", "To outline heating rate control, capillary sample packing, and calibration using standard reference chemical substances."),
        QcArticle(59, "QC-ART-059", "Operation and Verification of Ostwald and Brookfield Viscometers", "Lab Instruments & Calibration", "To describe flow time measurements, spindle selection, rotational speed control, and calibration with viscosity standards."),
        QcArticle(60, "QC-ART-060", "Thermal Calibration and Mapping of Laboratory Hot Air Ovens", "Lab Instruments & Calibration", "To detail thermocouple placement, temperature deviation limits, and thermostat calibration checks in drying ovens."),
        QcArticle(61, "QC-ART-061", "Standard Operation and Decontamination of Laboratory Autoclaves", "Lab Instruments & Calibration", "To outline autoclave cycle controls, pressure safety valve checking, biological indicator runs, and door seal replacement."),
        QcArticle(62, "QC-ART-062", "Calibration and Temp Mapping of BOD and Microbiology Incubators", "Lab Instruments & Calibration", "To define daily temperature logging, multi-probe thermal validation, and decontamination frequency for incubators."),
        QcArticle(63, "QC-ART-063", "Operation and Calibration of Laboratory Muffle Furnaces", "Lab Instruments & Calibration", "To establish thermocouple calibration, temperature overshoot limits, and safety protocols for high-temp ash testing."),
        QcArticle(64, "QC-ART-064", "Daily Verification of Water Baths and Heating Blocks", "Lab Instruments & Calibration", "To describe visual checks for scale buildup, temperature uniformity checks, and water level monitoring."),
        QcArticle(65, "QC-ART-065", "Operation and Calibration of Density Meter and Pycnometer", "Lab Instruments & Calibration", "To outline specific gravity measurement of liquids and density calibration checking using purified water and dry air."),
        QcArticle(66, "QC-ART-066", "Validation of Laboratory Sonicators and Ultrasonic Baths", "Lab Instruments & Calibration", "To verify sonic power using aluminum foil erosion test and temperature rise indicators."),
        QcArticle(67, "QC-ART-067", "SOP for Calibration of Handheld Infrared Thermometers", "Lab Instruments & Calibration", "To define multi-point temperature verification against standard reference RTD probes under blackbody simulator conditions."),
        QcArticle(68, "QC-ART-068", "Operation and Calibration of Digital Polarimeters", "Lab Instruments & Calibration", "To describe optical zero alignment, tube thermal equilibrium controls, and optical rotation verification."),
        QcArticle(69, "QC-ART-069", "Checking and Maintenance of Desiccator Cabinets and Silica Gel", "Lab Instruments & Calibration", "To establish guidelines for color indicator tracking, silica regeneration, and vacuum seal integrity checks."),
        QcArticle(70, "QC-ART-070", "SOP for daily checks of Air Velocity in Laminar Air Flow (LAF) benches", "Lab Instruments & Calibration", "To describe anemometer measurements, HEPA filter pressure drop monitoring, and air velocity limits (0.45 m/s ±20%)."),
        QcArticle(71, "QC-ART-071", "Calibration of Laboratory Digital Burettes and Liquid Dispensers", "Lab Instruments & Calibration", "To outline gravimetric volume verification of mechanical titrators using high-purity water and analytical balances."),
        QcArticle(72, "QC-ART-072", "Standard Check of Stability Chamber Humidity and Temp Sensors", "Lab Instruments & Calibration", "To detail physical calibration of capacitive humidity probes and Pt100 temperature sensors inside climatic chambers."),
        QcArticle(73, "QC-ART-073", "Qualification of Fume Hood Hood Velocity and Exhaust Systems", "Lab Instruments & Calibration", "To outline face velocity tests, smoke flow visualization, sash interlock verifications, and carbon filter monitoring."),
        QcArticle(74, "QC-ART-074", "Verification and Temperature Calibration of Refrigerators (2 to 8°C)", "Lab Instruments & Calibration", "To describe multi-point temperature sensor logging, door open recovery, and backup power supply checks."),
        QcArticle(75, "QC-ART-075", "Calibration of Digital Timer Clocks and Stopwatches in Lab", "Lab Instruments & Calibration", "To verify timing accuracy against a certified national master standard clock frequency reference."),

        // 4. Solutions, Reagents & Standards (76-105)
        QcArticle(76, "QC-ART-076", "Preparation and Standardization of 0.1M Sodium Hydroxide (NaOH)", "Solutions, Reagents & Standards", "To detail preparation, cooling of CO2-free water, and standardization using analytical grade Potassium Hydrogen Phthalate."),
        QcArticle(77, "QC-ART-077", "Preparation and Standardization of 0.1M Hydrochloric Acid (HCl)", "Solutions, Reagents & Standards", "To describe dilution, handling fuming acids, and standardization using standard anhydrous Sodium Carbonate."),
        QcArticle(78, "QC-ART-078", "Preparation and Standardization of 0.1N Potassium Permanganate", "Solutions, Reagents & Standards", "To establish dissolution, boiling to precipitate manganese dioxide, and standardization using Sodium Oxalate."),
        QcArticle(79, "QC-ART-079", "Preparation and Standardization of 0.05M Disodium EDTA", "Solutions, Reagents & Standards", "To describe metal-free water criteria and titration standardization using standard Zinc metal granule solutions."),
        QcArticle(80, "QC-ART-080", "Preparation and Standardization of 0.1M Sodium Thiosulfate", "Solutions, Reagents & Standards", "To describe addition of sodium carbonate preservative and standardization against Potassium Iodate standard."),
        QcArticle(81, "QC-ART-081", "Preparation and Standardization of 0.1M Silver Nitrate", "Solutions, Reagents & Standards", "To describe light-protected storage and titration standardization using high-purity Sodium Chloride standard."),
        QcArticle(82, "QC-ART-082", "Preparation and Standardization of 0.1N Iodine Solution", "Solutions, Reagents & Standards", "To establish potassium iodide dissolution, iodine sublimation addition, and standardization against Arsenic Trioxide or Sodium Thiosulfate."),
        QcArticle(83, "QC-ART-083", "Preparation and Standardization of 0.1M Perchloric Acid in Glacial Acetic Acid", "Solutions, Reagents & Standards", "To establish non-aqueous titration preparation, acetic anhydride addition, and standardization against Potassium Hydrogen Phthalate."),
        QcArticle(84, "QC-ART-084", "Labeling and Shelf Life of Prepared Volumetric Solutions", "Solutions, Reagents & Standards", "To outline standard guidelines for label content, batch numbering, re-standardization frequency, and maximum shelf life (e.g. 30 days)."),
        QcArticle(85, "QC-ART-085", "Handling, Storage, and Log Entries of Chemical Reagents", "Solutions, Reagents & Standards", "To describe storage grades, inventory logging, safety symbols, shelf life tracking, and segregation of acids/bases."),
        QcArticle(86, "QC-ART-086", "Qualification and Identification of Primary Reference Standards", "Solutions, Reagents & Standards", "To outline verification of USP/EP reference standards vial integrity, storage temperatures, and log entry documentation."),
        QcArticle(87, "QC-ART-087", "Preparation, Labeling, and Storage of Working Standards", "Solutions, Reagents & Standards", "To detail secondary standard purification, assay determination against primary standards, labeling, and desiccator storage."),
        QcArticle(88, "QC-ART-088", "Purified Water and Water for Injection (WFI) Chemical Specifications", "Solutions, Reagents & Standards", "To outline testing parameters for water conductivity, total organic carbon (TOC), heavy metals, acidity, and nitrates in QC lab."),
        QcArticle(89, "QC-ART-089", "Receipt and Verification of Incoming Chemical Solvent Consignments", "Solutions, Reagents & Standards", "To outline physical checks, lot number validation, COA verification, and solvent purity screening checks."),
        QcArticle(90, "QC-ART-090", "Preparation of Test Solutions (TS) and Indicator Solutions (IS)", "Solutions, Reagents & Standards", "To describe standard preparation, concentration checks, and shelf-life matrix of indicators (e.g. Phenolphthalein TS)."),
        QcArticle(91, "QC-ART-091", "Reagent Inventory Auditing and Re-order Threshold Protocols", "Solutions, Reagents & Standards", "To outline safety stock controls, expiry auditing, and electronic registration in the warehouse inventory database."),
        QcArticle(92, "QC-ART-092", "Handling and Disposal of expired Volumetric Solutions and Reagents", "Solutions, Reagents & Standards", "To define neutralization protocols, secure waste barrels logging, and environmental compliance rules for non-organic liquid wastes."),
        QcArticle(93, "QC-ART-093", "Preparation and Standardization of 0.1M Ammonium Thiocyanate", "Solutions, Reagents & Standards", "To describe preparation steps and standardization titration against standard Silver Nitrate solution."),
        QcArticle(94, "QC-ART-094", "Handling and Safety of Concentrated Acids (HF, Nitric, Sulfuric, HCl)", "Solutions, Reagents & Standards", "To outline protective rubber aprons, safety visors, acid-resistant fume hoods, and rapid dilution safety rules (acid to water)."),
        QcArticle(95, "QC-ART-095", "Storage of Flammable Organic Solvents inside Explosion-Proof Cabinets", "Solutions, Reagents & Standards", "To detail chemical compatibility charts, grounding wire clamps, flash point thresholds, and fire extinguisher positioning."),
        QcArticle(96, "QC-ART-096", "Daily Physical Inspection of Reagent Storage Areas", "Solutions, Reagents & Standards", "To check spill trays, container leaks, ventilation rate, temperature stability (below 25°C), and humidity control."),
        QcArticle(97, "QC-ART-097", "SOP for Verification of Standard Solution Factors", "Solutions, Reagents & Standards", "To outline mandatory triplicate standardization, factor limits (0.990 - 1.010), and relative standard deviation limits (RSD <= 0.2%)."),
        QcArticle(98, "QC-ART-098", "Handling and Logging of Controlled Chemical Substances", "Solutions, Reagents & Standards", "To establish double lock security, restricted administrator access, and usage logs for narcotic or precursor reagents."),
        QcArticle(99, "QC-ART-099", "Preparation of Buffer Solutions as per USP/EP Monographs", "Solutions, Reagents & Standards", "To describe analytical balance weighing, pH adjustment, and storage limits of standard buffers (e.g., Phosphate buffer pH 6.8)."),
        QcArticle(100, "QC-ART-100", "Disposal and Neutralization of Alkaline Reagent Waste", "Solutions, Reagents & Standards", "To define neutralization limits (pH 6.0 - 8.5), cooling steps, and safe discharge tracking for aqueous bases."),
        QcArticle(101, "QC-ART-101", "Qualification of Deionized Water System in Quality Control Lab", "Solutions, Reagents & Standards", "To check water purity, monitor resistivity values (>= 18.2 MOhm-cm), and verify inline filter changes."),
        QcArticle(102, "QC-ART-102", "Handling of Moisture-Sensitive Chemical Reagents", "Solutions, Reagents & Standards", "To outline storage in hermetic desiccators under active nitrogen or molecular sieves to prevent degradation."),
        QcArticle(103, "QC-ART-103", "Standardization of 0.05M Ceric Ammonium Sulfate Volumetric Solution", "Solutions, Reagents & Standards", "To establish titration steps and standardization against analytical grade Arsenic Trioxide standard."),
        QcArticle(104, "QC-ART-104", "Preparation and Care of Phenolphthalein and Methyl Orange Indicators", "Solutions, Reagents & Standards", "To describe dilution with ethanol and verification of color transition thresholds."),
        QcArticle(105, "QC-ART-105", "Storage and Inventory of Reference Standards in Cryogenic Chambers", "Solutions, Reagents & Standards", "To outline temperature tracking (-20°C or -80°C), thermal alarm verification, and emergency backup power guidelines."),

        // 5. Wet Chemistry & Limit Tests (106-125)
        QcArticle(106, "QC-ART-106", "Standard Operating Procedure for Loss on Drying (LOD) Test", "Wet Chemistry & Limit Tests", "To outline sample weighing, tare crucible drying, muffle oven duration, and desiccator cooling steps for LOD."),
        QcArticle(107, "QC-ART-107", "Standard Assay for Determination of Residue on Ignition (ROI) / Sulfated Ash", "Wet Chemistry & Limit Tests", "To describe acid carbonization in fume hood, heating crucible in muffle furnace at 600°C, and final ash weight calculation."),
        QcArticle(108, "QC-ART-108", "Limit Test for Heavy Metals in Pharmaceutical Raw Materials", "Wet Chemistry & Limit Tests", "To detail lead standard solution prep, sample digestion, lead sulfide precipitate comparison inside Nessler cylinders."),
        QcArticle(109, "QC-ART-109", "Limit Test for Chloride and Sulfate Impurities as per USP", "Wet Chemistry & Limit Tests", "To describe precipitation checks against standard solutions using Silver Nitrate and Barium Chloride reagents."),
        QcArticle(110, "QC-ART-110", "SOP for Limit Test for Iron Impurity", "Wet Chemistry & Limit Tests", "To detail standard iron comparison using thioglycolic acid and citric acid reagents in alkaline solution comparison."),
        QcArticle(111, "QC-ART-111", "Standard Operation and Apparatus for Limit Test for Arsenic", "Wet Chemistry & Limit Tests", "To describe setup of the Gutzeit generator, zinc and acid reaction, and arsine gas staining on mercuric bromide paper."),
        QcArticle(112, "QC-ART-112", "Determination of Solubility in Raw Materials as per Monograph", "Wet Chemistry & Limit Tests", "To define solubility grades, solvent temperature controls, and physical agitation timing rules."),
        QcArticle(113, "QC-ART-113", "SOP for Identification of Inorganic Cations and Anions", "Wet Chemistry & Limit Tests", "To detail qualitative wet chemistry identification tests (e.g. sodium, chloride, calcium, carbonate) using precipitate colors."),
        QcArticle(114, "QC-ART-114", "Determination of Sieve Analysis and Particle Size Distribution", "Wet Chemistry & Limit Tests", "To detail mechanical sieve shaker operations, standard mesh sizes, shaking duration, and fractional weight retention calculations."),
        QcArticle(115, "QC-ART-115", "Operation of Digital Melting Point and Boiling Point Apparatus", "Wet Chemistry & Limit Tests", "To describe capillary packing, heating speed control (1.0°C/min), and optical detection verification."),
        QcArticle(116, "QC-ART-116", "Acid Value and Saponification Value Determination in Oils", "Wet Chemistry & Limit Tests", "To outline non-aqueous volumetric titration with potassium hydroxide and back-titration indicator checks."),
        QcArticle(117, "QC-ART-117", "Determination of Iodine Value and Peroxide Value in Excipients", "Wet Chemistry & Limit Tests", "To describe solvent extraction, addition of potassium iodide, and volumetric sodium thiosulfate titration standard checks."),
        QcArticle(118, "QC-ART-118", "Standard Procedure for Water Insoluble Matter Assay", "Wet Chemistry & Limit Tests", "To outline sample dissolution in hot purified water, filtration through sintered glass crucible, drying, and weighing."),
        QcArticle(119, "QC-ART-119", "Limit Test for Lead Impurities in Calcium Carbonate and Excipients", "Wet Chemistry & Limit Tests", "To outline sample preparation, extraction with dithizone, and visual comparison in Nessler cylinders."),
        QcArticle(120, "QC-ART-120", "Standard Operation of Automatic Potentiometric Titrators", "Wet Chemistry & Limit Tests", "To describe electrode choice (silver, glass, platinum), method setup, and detection of inflection point."),
        QcArticle(121, "QC-ART-121", "Identification of Organic Chemicals by Color Reaction Tests", "Wet Chemistry & Limit Tests", "To detail qualitative tests using specific chemical reagents (e.g., Ninhydrin for amino acids) to verify molecular groups."),
        QcArticle(122, "QC-ART-122", "Daily Calibration of Laboratory Glassware", "Wet Chemistry & Limit Tests", "To establish gravimetric calibration check of volumetric pipettes and burettes using water density at ambient temperature."),
        QcArticle(123, "QC-ART-123", "Checking and Calibration of Liquid Thermometers", "Wet Chemistry & Limit Tests", "To detail calibration of mercury and alcohol thermometers against certified master digital RTD probes."),
        QcArticle(124, "QC-ART-124", "Cleaning and Drying of Volumetric Glassware", "Wet Chemistry & Limit Tests", "To outline chromic acid cleaning, rinsing with deionized water, and drying temperatures in glassware ovens."),
        QcArticle(125, "QC-ART-125", "SOP for Handling and Weighing Toxic Dry API Samples", "Wet Chemistry & Limit Tests", "To outline reverse-flow weighing booths, micro-balance static controls, and respiratory protection guidelines."),

        // 6. Lab Quality Systems (OOS, OOT) (126-145)
        QcArticle(126, "QC-ART-126", "Handling of Out of Specification (OOS) Analytical Results", "Lab Quality Systems (OOS, OOT)", "To define a systematic procedure to log, investigate, and close OOS analytical results according to FDA guidelines."),
        QcArticle(127, "QC-ART-127", "Phase I Laboratory Investigation Checklist for OOS Results", "Lab Quality Systems (OOS, OOT)", "To outline immediate checks on calculations, standards freshness, instrument calibration, and analyst interview rules."),
        QcArticle(128, "QC-ART-128", "Phase II Full Quality Investigation and Re-testing Protocols", "Lab Quality Systems (OOS, OOT)", "To detail duplicate re-testing plans by a second analyst, manufacturing site evaluations, and QA release approval parameters."),
        QcArticle(129, "QC-ART-129", "Handling of Out of Trend (OOT) Analytical Stability Results", "Lab Quality Systems (OOS, OOT)", "To describe statistical analysis using control charts to identify and investigate results deviating from historical trends."),
        QcArticle(130, "QC-ART-130", "Classification and Investigation of Laboratory Deviations", "Lab Quality Systems (OOS, OOT)", "To outline the workflow for documenting accidental errors, instrument failures, and sample contamination issues."),
        QcArticle(131, "QC-ART-131", "Implementation of Corrective and Preventive Action (CAPA) in Lab", "Lab Quality Systems (OOS, OOT)", "To establish the investigation of root causes and implementation of CAPA tasks with effectiveness verification."),
        QcArticle(132, "QC-ART-132", "SOP for Management of Out of Calibration (OOC) Instruments", "Lab Quality Systems (OOS, OOT)", "To describe labeling instruments with RED out-of-order tags, isolating systems, and evaluating impact of past tests."),
        QcArticle(133, "QC-ART-133", "Quality Risk Assessment of Laboratory Testing Operations", "Lab Quality Systems (OOS, OOT)", "To outline FMEA risk assessment on chromatography software, analytical standards handling, and sample logs."),
        QcArticle(134, "QC-ART-134", "Logbook Management and Documentation Integrity in Lab", "Lab Quality Systems (OOS, OOT)", "To define issuance, page numbering, raw data pasting, corrections entry, and archiving of instrument logbooks."),
        QcArticle(135, "QC-ART-135", "Preventive Maintenance (PM) Scheduling for Lab Instruments", "Lab Quality Systems (OOS, OOT)", "To establish monthly, bi-annual, and annual PM contracts, sensor replacement checks, and system re-qualification."),
        QcArticle(136, "QC-ART-136", "Audit Trail Review of Chromatographic Software Systems", "Lab Quality Systems (OOS, OOT)", "To outline mandatory daily/weekly audit trail checks, tracking injection deletions, and software password controls."),
        QcArticle(137, "QC-ART-137", "SOP for Annual Product Quality Review (APQR) Data Compilation", "Lab Quality Systems (OOS, OOT)", "To outline standard steps for compiling QC assay, physical results, and OOS summaries for annual product reports."),
        QcArticle(138, "QC-ART-138", "Management and Storage of Retention Samples of Finished Goods", "Lab Quality Systems (OOS, OOT)", "To detail secure storage under climatic conditions, quantity audit twice a year, and disposal rules after expiry plus one year."),
        QcArticle(139, "QC-ART-139", "Preparation and Execution of Internal Quality Audits in QC", "Lab Quality Systems (OOS, OOT)", "To describe audit checklists, auditing raw data sheets, training files checks, and CAPA follow-up audits."),
        QcArticle(140, "QC-ART-140", "Handling of Customer Complaints and Re-testing Protocols", "Lab Quality Systems (OOS, OOT)", "To outline logging complaints, retrieving retention samples, double-analyst assay checks, and reporting final data."),
        QcArticle(141, "QC-ART-141", "Re-validation Criteria of Laboratory Analytical Methods", "Lab Quality Systems (OOS, OOT)", "To define technical triggers (e.g., formulation change) requiring partial or full analytical method validation."),
        QcArticle(142, "QC-ART-142", "SOP for Handling of Spills and Chemical Laboratory Emergencies", "Lab Quality Systems (OOS, OOT)", "To describe spill kit usage, neutralization of hazardous acids or organic liquids, and incident reporting forms."),
        QcArticle(143, "QC-ART-143", "Management of Laboratory Computerized Systems Access Control", "Lab Quality Systems (OOS, OOT)", "To outline GAMP 5 user groups (Admin, Analyst, Supervisor), password complexity, and prohibition of shared logins."),
        QcArticle(144, "QC-ART-144", "SOP for Handling Reagents with Expired Standard Factors", "Lab Quality Systems (OOS, OOT)", "To establish quarantine labeling and prohibition of titrating with solutions whose factor check dates are overdue."),
        QcArticle(145, "QC-ART-145", "SOP for Investigation of Out of Limit Stability Chamber Readings", "Lab Quality Systems (OOS, OOT)", "To outline technical checklists for probe failures, chamber door open tracking, and impact on stability samples."),

        // 7. Microbiology QC & Media (146-165)
        QcArticle(146, "QC-ART-146", "Sterility Testing of Sterile Pharmaceutical Products", "Microbiology QC & Media", "To define membrane filtration and direct inoculation testing under Grade A cleanroom laminar flow workbench."),
        QcArticle(147, "QC-ART-147", "Bacterial Endotoxin LAL Gel Clot Assay for Injectables", "Microbiology QC & Media", "To outline endotoxin standard curve prep, lysate sensitivity verification, sample dilution, and gel clot interpretation."),
        QcArticle(148, "QC-ART-148", "Microbiology Environmental Monitoring of Cleanrooms by Active Air Sampling", "Microbiology QC & Media", "To describe active air sampler sanitization, plate loading, and air aspiration volume settings in aseptic Grade A/B zones."),
        QcArticle(149, "QC-ART-149", "Environmental Monitoring of Cleanrooms by Passive Settle Plates", "Microbiology QC & Media", "To establish exposure layout, exposure duration (e.g., 4 hours) of settle plates, collection, and plate incubation conditions."),
        QcArticle(150, "QC-ART-150", "Microbial Limits Test (MLT) for Pathogens in Raw Materials", "Microbiology QC & Media", "To detail enrichment, selective media inoculations, and identification tests for E. coli, S. aureus, Pseudomonas, and Salmonella."),
        QcArticle(151, "QC-ART-151", "Preparation and Sterilization of Microbiological Culture Media", "Microbiology QC & Media", "To describe media weighing, dissolution, pH adjustment, autoclave cycle controls (121°C, 15 min), and plate pouring in LAF."),
        QcArticle(152, "QC-ART-152", "Growth Promotion Testing (GPT) of Culture Media Batches", "Microbiology QC & Media", "To detail nutritive performance checks of fresh media batches using standard micro-organism inoculations of less than 100 CFU."),
        QcArticle(153, "QC-ART-153", "Maintenance and Preservation of Microbiological Pure Cultures", "Microbiology QC & Media", "To describe sub-culturing rules, glycerol stock cryopreservation, and verification of purity of standard strain cultures."),
        QcArticle(154, "QC-ART-154", "Biological Indicators (BI) Verification for Autoclave Validation", "Microbiology QC & Media", "To detail the placement of Geobacillus stearothermophilus strips, post-run incubation, and growth verification checks."),
        QcArticle(155, "QC-ART-155", "SOP for Gowning and Sanitization of Microbiology Lab Personnel", "Microbiology QC & Media", "To describe handwashing, sterile gowning, and disinfectant hand sanitization sequence for sterile testing rooms."),
        QcArticle(156, "QC-ART-156", "Bioburden Estimation of Purified Water and Water for Injection (WFI)", "Microbiology QC & Media", "To outline water sample filtration through 0.45 micron membranes, plating on R2A agar, and colony count after 5 days."),
        QcArticle(157, "QC-ART-157", "Disinfectant Efficacy Testing (DET) inside Microbiology Lab", "Microbiology QC & Media", "To outline in-vitro carrier testing of cleanroom disinfectants against local isolates to verify log reduction capacity."),
        QcArticle(158, "QC-ART-158", "Sterility Testing of Aseptic Processing Media Fills", "Microbiology QC & Media", "To describe visual inspection of filled vials, incubation temperatures, and target growth turbidity controls."),
        QcArticle(159, "QC-ART-159", "Sanitization of Laminar Air Flow Benches and Bio-Safety Cabinets", "Microbiology QC & Media", "To detail weekly sporicidal cleaning, daily 70% IPA wiping, and HEPA filter grill inspection protocols."),
        QcArticle(160, "QC-ART-160", "Preservative Efficacy Testing (PET) of Multi-Dose Formulations", "Microbiology QC & Media", "To outline target pathogen inoculation, physical storage, and colony reduction counts at days 7, 14, and 28."),
        QcArticle(161, "QC-ART-161", "Disposal and Neutralization of Hazardous Microbiological Culture Waste", "Microbiology QC & Media", "To describe autoclave sterilization of positive petri dishes and contaminated media before chemical dumping."),
        QcArticle(162, "QC-ART-162", "Operation and Calibration of Colony Counter Equipment", "Microbiology QC & Media", "To outline standard grid illumination settings, pressure pen checks, and multi-analyst double-blind counts."),
        QcArticle(163, "QC-ART-163", "SOP for Gram Staining and Morphological Identification of Bacteria", "Microbiology QC & Media", "To describe heat-fixation slide prep, crystal violet/iodine dye sequence, and optical microscopy observation."),
        QcArticle(164, "QC-ART-164", "Handling and Safety of Anaerobic Culture Incubators", "Microbiology QC & Media", "To outline chemical gas-pouch activation, jar pressure sealing, and biological anaerobic indicators checks."),
        QcArticle(165, "QC-ART-165", "Microbiological Assay of Antibiotics using Cup-Plate Method", "Microbiology QC & Media", "To outline zone of inhibition measurement, standard dilution preparation, and nutrient agar layer thickness checks."),

        // 8. Documentation & GMP Compliance (166-185)
        QcArticle(166, "QC-ART-166", "Good Documentation Practices (GDP) Requirements in QC Lab", "Documentation & GMP Compliance", "To outline requirements for permanent ink entries, immediate recording, error corrections without scratching, and initial sign-offs."),
        QcArticle(167, "QC-ART-167", "Control and Archive of Chromatography Raw Data Prints", "Documentation & GMP Compliance", "To describe printing run sequences, signing chromatograms, binding raw data sheets, and secure archival cabinet cards."),
        QcArticle(168, "QC-ART-168", "SOP for Double-Analyst Verification of Analytical Weight Slips", "Documentation & GMP Compliance", "To define mandatory co-signing of weight records, balance tape pasting, and supervisor validation checks."),
        QcArticle(169, "QC-ART-169", "Issuance and Reconciliation of Laboratory Analytical Worksheets", "Documentation & GMP Compliance", "To describe secure worksheet watermarking, tracking sheet serial numbers, and logs for destroyed sheets."),
        QcArticle(170, "QC-ART-170", "FDA Data Integrity ALCOA+ Principles Implementation", "Documentation & GMP Compliance", "To define Attributable, Legible, Contemporaneous, Original, and Accurate metadata tracking rules across instruments."),
        QcArticle(171, "QC-ART-171", "Good Chromatography Practices: Managing System Suitability Failures", "Documentation & GMP Compliance", "To outline compliance boundaries: never delete failing injections, log all calibration runs, and investigate failures."),
        QcArticle(172, "QC-ART-172", "Data Archival and Backup Restoration of Laboratory Servers", "Documentation & GMP Compliance", "To establish automatic daily database backup validation, secure offline tapes, and periodic restore testing."),
        QcArticle(173, "QC-ART-173", "SOP for Retention of Raw Analytical Spectroscopic Scans", "Documentation & GMP Compliance", "To detail digital folder structure standards, file naming rules, and prohibition of local PDF deletion."),
        QcArticle(174, "QC-ART-174", "Standard Labeling of Standard Solutions and Working Reagents", "Documentation & GMP Compliance", "To establish chemical color coding, preparer signature, standardization factor, and expiry date labeling."),
        QcArticle(175, "QC-ART-175", "Handling of Instrument Logs during Serving and Power Failures", "Documentation & GMP Compliance", "To outline recording blackout timing, system re-check runs, and documentation of battery backup operations."),
        QcArticle(176, "QC-ART-176", "Qualification and Archival of Certificates of Analysis (COA)", "Documentation & GMP Compliance", "To describe review checklists for manufacturer COAs, verifying standard references, and digital storage index."),
        QcArticle(177, "QC-ART-177", "Training File Maintenance and Analyst Qualification records", "Documentation & GMP Compliance", "To establish training curriculum indexes, physical file audit paths, and annual pipette/balance qualifications."),
        QcArticle(178, "QC-ART-178", "Logbook Management for Glassware Calibration and Care", "Documentation & GMP Compliance", "To outline daily balance checks, volumetric certifications, and tracking damaged volumetric glass pieces."),
        QcArticle(179, "QC-ART-179", "Preparation and Review of Laboratory Specifications and Test Procedures", "Documentation & GMP Compliance", "To outline standard formatting, version control, peer-review loops, and QA authorization of analytical specs."),
        QcArticle(180, "QC-ART-180", "Archival and Retrieval of Completed Laboratory Notebooks", "Documentation & GMP Compliance", "To describe sequential cataloging, fire-proof cabinet storage, retrieval forms, and destruction timeline policies."),
        QcArticle(181, "QC-ART-181", "SOP for Handling Out-of-Order Instrument Alerts and Quarantine Labels", "Documentation & GMP Compliance", "To define mandatory yellow out-of-order labels, physical isolations, and reporting mechanisms to engineering."),
        QcArticle(182, "QC-ART-182", "Preparation of Reagents Logbook and Lot Number Issuance", "Documentation & GMP Compliance", "To outline standard coding for reagent batches, recording manufacturer details, and preparer certifications."),
        QcArticle(183, "QC-ART-183", "Documentation Rules for HPLC Column Utilization Logs", "Documentation & GMP Compliance", "To define mandatory log sheets tracking injection counts, run times, and column flushing steps."),
        QcArticle(184, "QC-ART-184", "Management of Out-of-Specification (OOS) Notification Registers", "Documentation & GMP Compliance", "To describe secure tracking numbers, filing notifications with QA, and maintaining investigation deadlines."),
        QcArticle(185, "QC-ART-185", "SOP for GMP Audit Preparedness: Daily Housekeeping inside QC", "Documentation & GMP Compliance", "To outline clean benches checks, reagent vial labeling reviews, and verifying active logbook entries."),

        // 9. Method Validation & Stability (186-205)
        QcArticle(186, "QC-ART-186", "Analytical Method Validation (AMV) Protocol Preparation", "Method Validation & Stability", "To outline writing AMV protocols, defining acceptance parameters for specificity, linearity, accuracy, and precision."),
        QcArticle(187, "QC-ART-187", "Determination of Linearity and Range in Method Validation", "Method Validation & Stability", "To detail preparation of 5 to 6 standard concentrations, plotting calibration curve, and calculating R-square correlation coefficient."),
        QcArticle(188, "QC-ART-188", "Determination of Limit of Detection (LOD) and Limit of Quantitation (LOQ)", "Method Validation & Stability", "To describe signal-to-noise ratio calculation methods (3:1 for LOD, 10:1 for LOQ) and standard deviation slopes."),
        QcArticle(189, "QC-ART-189", "Accuracy and Recovery Studies in Analytical Method Validation", "Method Validation & Stability", "To outline recovery tests using active substance spiking at 80%, 100%, and 120% levels in placebo mixtures."),
        QcArticle(190, "QC-ART-190", "Precision Studies: Repeatability and Intermediate Precision validation", "Method Validation & Stability", "To detail 6 replicate injections of standard on same day, and by second analyst on different days to check RSD limits."),
        QcArticle(191, "QC-ART-191", "Robustness testing in HPLC Method Validation", "Method Validation & Stability", "To describe testing small deliberate parameter changes: flow rate, column temp, mobile phase pH, and wavelength."),
        QcArticle(192, "QC-ART-192", "Analytical Method Transfer (AMT) Protocol and Criteria", "Method Validation & Stability", "To define receiving and transferring lab responsibilities, comparative test runs, and statistical evaluation."),
        QcArticle(193, "QC-ART-193", "Standard Operation and Control of Stability Chambers", "Method Validation & Stability", "To outline temperature (e.g. 25°C ±2°C) and relative humidity (60% ±5% RH) control and thermo-hygrometer calibrations."),
        QcArticle(194, "QC-ART-194", "Climatic Zone Stability testing guidelines (ICH Q1A)", "Method Validation & Stability", "To describe accelerated (40°C/75% RH) and long-term stability testing frequencies for different world climate regions."),
        QcArticle(195, "QC-ART-195", "Forced Degradation Studies (Stress Testing) of Active Materials", "Method Validation & Stability", "To outline sample exposure to acid, base, oxidation (H2O2), thermal heat, and photolytic UV light to verify impurity resolution."),
        QcArticle(196, "QC-ART-196", "Stability Sample Logging, Labeling, and Pull-Out Schedule", "Method Validation & Stability", "To describe stability chamber login, color-coded bottle labeling, and pull-out timelines (0, 3, 6, 9, 12, 18, 24, 36 months)."),
        QcArticle(197, "QC-ART-197", "SOP for Handling Stability Failures and Out of Trend (OOT) Alerts", "Method Validation & Stability", "To outline immediate chamber lock checks, sample logging audit, and reporting chemical failures to QA."),
        QcArticle(198, "QC-ART-198", "Transport and Shipping Stability Study Protocols", "Method Validation & Stability", "To detail temperature datalogger integration in cargo boxes, transit simulation tests, and post-shipping assay checks."),
        QcArticle(199, "QC-ART-199", "Method Validation for Dissolution Assays of Solid Oral Dosages", "Method Validation & Stability", "To detail sink conditions validation, filter adsorption study, and automated sampling compatibility."),
        QcArticle(200, "QC-ART-200", "Determination of System Suitability Resolution under degraded conditions", "Method Validation & Stability", "To verify peak separation between active pharmaceutical ingredient and adjacent impurity standards."),
        QcArticle(201, "QC-ART-201", "Photostability Testing of Drug Substances (ICH Q1B)", "Method Validation & Stability", "To outline sample exposure to overall cool white fluorescent and near UV light energy inside photostability chambers."),
        QcArticle(202, "QC-ART-202", "SOP for Calibration of Stability Chamber Alarm Systems", "Method Validation & Stability", "To check automated telecommunication triggers, warning siren volumes, and emergency backup power tests."),
        QcArticle(203, "QC-ART-203", "Statistical evaluation of Stability Data and Shelf-Life Calculation", "Method Validation & Stability", "To outline regression line plotting, determining 95% confidence intervals, and assigning drug expiration dates."),
        QcArticle(204, "QC-ART-204", "SOP for Changing HPLC Columns in Validated Methods", "Method Validation & Stability", "To describe equivalent column guidelines, matching stationary phase carbon loading, and verification of resolution."),
        QcArticle(205, "QC-ART-205", "Validation of Cleaning Residue Analytical Methods on Equipment Surfaces", "Method Validation & Stability", "To outline validation of recovery rates of swab sampling and HPLC limits of quantification for worst-case active residues.")
    )

    fun getArticleBody(article: QcArticle): String {
        return """
            PHARMACEUTICAL GUIDELINES & COMPLIANCE PORTAL
            REFERENCE CODE: ${article.code} | DEPARTMENT: QUALITY CONTROL
            TECHNICAL DIVISION: ${article.category}
            STANDARD REFERENCE MANUAL (cGMP & 21 CFR Part 211 COMPLIANT)
            
            1.0 OBJECTIVE
            ${article.objective}
            
            2.0 SCOPE
            This guidelines manual is applicable to all analytical testing, quality systems, standard operations, instruments calibration, and technical documentations executed in the pharmaceutical site Quality Control Division. All analysts, supervisors, and quality auditors must strictly adhere to these criteria to ensure absolute compliance with current Good Manufacturing Practices (cGMP) and global regulatory expectations (FDA, WHO, and ICH guidelines).
            
            3.0 MATERIAL & EQUIPMENTS REQUIRED
            - Certified NIST Traceable Reference Standards and Standard Working weights.
            - Volumetric Class-A calibrated glassware (pipettes, flasks, burettes).
            - Calibrated analytical testing equipment (HPLC, UV, GC, pH meter, balance) carrying active green 'CALIBRATED' status labels.
            - High-purity pharmaceutical reagents and chemicals (Milli-Q Purified water, HPLC-grade organic solvents, analytical grade reagents).
            - Personal Protective Equipment (PPE) including safety visors, dust-filtration respirators, and acid-resistant nitrile gloves.
            
            4.0 STEP-BY-STEP TECHNICAL PROCEDURE
            4.1 PRE-EXECUTION STEPS:
            - Before starting the procedure, physically inspect the testing area to ensure pristine cleanliness and verify that the relative humidity is below 60% and room temperature remains stable between 20°C and 25°C.
            - Retrieve the designated analytical logbook and record your name, date, start time, instrument code, standard weights batch numbers, and reagent expiry dates.
            - Conduct a system suitability verification. If working with analytical software (Empower / LabSolutions), verify that the system is fully logged under your unique user ID and the secure audit trail log is active.
            
            4.2 CORE COMPLIANCE METHODOLOGY:
            - Execute the steps precisely as described in the official pharmacopeial monographs (USP, EP, or IP). For standardizations, perform the titrations or injections in triplicate.
            - Ensure all dilution preparations are thoroughly homogenized. Sonicate liquid matrices for at least 15 minutes to fully degas or dissolve the components.
            - For chromatographic assays (HPLC or GC), inject the standard solution six times. The relative standard deviation (RSD) of the peak areas must be less than or equal to 1.0% to confirm system precision.
            - For limit tests or physical evaluations (LOD, disintegration, or melting point), verify that the water bath or muffle furnace temperature is calibrated and does not overshoot the target threshold by more than ±1.0°C.
            
            4.3 DATA INTEGRITY AND COMPLIANCE RULES:
            - All weights and raw balance printouts must be immediately pasted into the analytical worksheet. Co-sign the worksheet with a double-operator check.
            - If any out-of-specification (OOS) or out-of-calibration (OOC) alert is triggered, stop testing immediately, do not discard any test solutions, and notify the area supervisor within 24 hours of the event.
            - Never delete, overwrite, or hide any raw data or chromatogram runs. Any unauthorized deletion is a critical violation of regulatory data integrity.
            
            5.0 SAFETY & ENVIRONMENTAL PRECAUTIONS
            - Always handle hazardous concentrated chemicals and volatile organic solvents under a functional exhaust fume hood.
            - Ensure all liquid chemical wastes, solvent residues, and expired standard buffers are poured into designated color-coded chemical waste barrels. Never discharge organic wastes directly into laboratory drainage systems.
            - In case of skin or eye contact with acid reagents, immediately flush the affected area with purified water at the safety eye wash station for at least 15 minutes and log a laboratory deviation report.
            
            6.0 QUALITY AUDIT FREQUENCY
            This compliance guideline and standard procedure must be reviewed and re-verified on a biennial basis (every 2 years), or immediately upon any technical change control proposal, equipment upgrades, or major regulatory audits.
            
            EFFECTIVE DATE: 2026-06-28
            AUTHOR: Lead QC Compliance Officer
            REVIEWER: QC Lab Manager
            APPROVER: Head of Quality Assurance
        """.trimIndent()
    }
}
