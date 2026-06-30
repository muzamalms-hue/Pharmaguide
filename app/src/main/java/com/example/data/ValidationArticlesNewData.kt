package com.example.data

object ValidationArticlesNewData {

    data class ValidationSopPair(
        val title: String,
        val objective: String,
        val typeIndex: Int // 1: Equipment, 2: Process, 3: Cleaning, 4: Analytical, 5: CSV, 6: Utility/HVAC
    )

    private val rawValidationSops = listOf(
        // 1. Equipment Qualification (IQ/OQ/PQ) (1 - 25)
        ValidationSopPair(
            "SOP for Qualification of Double Cone Blender",
            "To outline the Installation, Operational, and Performance Qualification (IQ/OQ/PQ) of the double cone blender.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Tablet Compression Machine",
            "To establish the qualification guidelines for verifying mechanical pressure adjustments and punch alignment during tablet compression.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Rapid Mixer Granulator",
            "To define the validation criteria for RMG impeller speeds, binder addition rates, and chopper safety interlocks.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Fluid Bed Dryer",
            "To establish drying temperature profiles, airflow rates, and exhaust bag filtration safety limits during FBD qualification.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of High-Performance Liquid Chromatograph",
            "To define flow rate accuracy, column oven temperature stability, and detector wavelength precision checks for HPLC qualification.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Gas Chromatograph",
            "To establish split/splitless injector precision, carrier gas flow rates, and flame ionization detector sensitivity verification during GC qualification.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Tablet Coating Machine",
            "To outline the operational temperature uniformity, pan speed regulation, and spray gun automation checks during coater qualification.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Walk-In Stability Chambers",
            "To define multi-point temperature and humidity mapping, backup cooler switchover, and sensor validation for stability rooms.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Micro Lab Incubators",
            "To establish temperature mapping criteria, door opening recovery tests, and digital sensor validation for bio-incubators.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Glassware Washer",
            "To outline spray arm pressure, temperature ramp, and cleaning detergent wash validation during laboratory washer qualification.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Autoclave Sterilizer",
            "To define thermocouple distribution, biological indicator challenge, and heat penetration profiling for steam autoclaves.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Dry Heat Sterilizer",
            "To establish temperature mapping, endotoxin challenge, and chamber heat distribution qualification for DHS ovens.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Depyrogenation Tunnel",
            "To outline belt transit speed, hot-air velocity, and endotoxin vial challenges during depyrogenation tunnel qualification.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Ultra-filtration Membrane System",
            "To define pressure holds, flow velocities, and particle filtration efficiency checks for ultra-filtration квалификаций.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Capsule Filling Machine",
            "To establish dosing disk thickness adjustments, capsule tamping pins alignment, and weight control qualification.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Blister Packaging Machine",
            "To outline forming foil temperature, sealing roller mechanical pressure, and pocket forming accuracy checks for blister line qualification.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Liquid Syrup Filling Line",
            "To establish volumetric accuracy, nitrogen purging nozzle alignment, and bottle conveyor speed qualification during syrup filler runs.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Tube Sealing Machine",
            "To define ultrasonic seal temperature, jaw mechanical pressure, and seal strength evaluation parameters for tube qualification.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Carton Labeler",
            "To outline print alignment accuracy, barcode reader verification, and reject arm timing checks during labeler qualification.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Multi-Directional Sifter",
            "To establish mesh screen integrity, vibrating frequency, and powder flow velocity limits during sifter qualification.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Laboratory Muffle Furnace",
            "To outline high-temperature mapping (up to 1000°C), temperature controller linearity, and thermocouple accuracy verification.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Polarimeter Instrument",
            "To establish optical zero adjustment, sodium lamp wavelength validation, and measuring specific rotation precision.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of UV-Visible Spectrophotometer",
            "To outline wavelength accuracy, photometric linearity, stray light limit, and baseline flatness validation checks.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Karl Fischer Titrator",
            "To define water factor verification, burette dispense accuracy, and reaction vessel moisture seal qualification.",
            1
        ),
        ValidationSopPair(
            "SOP for Qualification of Tablet Friability Tester",
            "To establish rotation speed (25 RPM) accuracy, drop counts (100 drops), and mechanical alignment checks during tester qualification.",
            1
        ),

        // 2. Process Validation (26 - 45)
        ValidationSopPair(
            "SOP for Prospective Process Validation",
            "To outline the guidelines for executing process validation for new pharmaceutical formulations prior to commercial distribution.",
            2
        ),
        ValidationSopPair(
            "SOP for Concurrent Process Validation",
            "To establish validation protocols for commercial batches manufactured concurrently during special regulatory situations.",
            2
        ),
        ValidationSopPair(
            "SOP for Retrospective Process Validation",
            "To define guidelines for compiling historical batch records and utilizing statistical data for retrospective process validation.",
            2
        ),
        ValidationSopPair(
            "SOP for Process Re-Validation Matrix",
            "To establish triggers, periodic intervals, and change-control requirements for initiating process re-validation.",
            2
        ),
        ValidationSopPair(
            "SOP for Granulation Process Validation Protocol",
            "To outline the critical parameters like impeller speed, binder quantity, and mixing time for RMG granulation process validation.",
            2
        ),
        ValidationSopPair(
            "SOP for Fluid Bed Drying Process Validation",
            "To define air temperature, moisture content reduction, and loss on drying (LOD) endpoints for FBD drying validation.",
            2
        ),
        ValidationSopPair(
            "SOP for Blending Process Validation",
            "To establish sampling locations, RSD limits, and blending times to ensure content uniformity in final powder blends.",
            2
        ),
        ValidationSopPair(
            "SOP for Tablet Compression Process Validation",
            "To outline compression force, turret speed, and in-process variations (weight, hardness, thickness) during tableting process validation.",
            2
        ),
        ValidationSopPair(
            "SOP for Tablet Coating Process Validation",
            "To define gun distance, atomization air pressure, spray rate, and weight gain limits for tablet coating process validation.",
            2
        ),
        ValidationSopPair(
            "SOP for Capsule Filling Process Validation",
            "To establish tamping pressure, machine speed, and capsule weight variations during encapsulation process validation.",
            2
        ),
        ValidationSopPair(
            "SOP for Liquid Syrup Mixing Process Validation",
            "To outline sugar dissolution temperature, active ingredient dispersion times, and viscosity verification during syrup blending validation.",
            2
        ),
        ValidationSopPair(
            "SOP for Sterile Filtration Process Validation",
            "To define membrane integrity, bubble-point checks, bacterial retention limits, and pressure differentials for sterile liquid fill runs.",
            2
        ),
        ValidationSopPair(
            "SOP for Terminal Sterilization Process Validation",
            "To establish steam autoclave validation parameters for terminally sterilized liquid formulations.",
            2
        ),
        ValidationSopPair(
            "SOP for Aseptic Media Fill Run Validation",
            "To define liquid media preparation, line setup, filling parameters, continuous visual inspections, and incubation logs.",
            2
        ),
        ValidationSopPair(
            "SOP for Ointment Homogenization Process Validation",
            "To outline mixer temperature, cooling rate, shear force, and physical consistency verification during ointment blending validation.",
            2
        ),
        ValidationSopPair(
            "SOP for Semi-Solid Tube Filling Process Validation",
            "To establish volumetric dosing accuracy, heating seal temperatures, and cosmetic sealing checks for ointment tubes.",
            2
        ),
        ValidationSopPair(
            "SOP for Blister Sealing Process Validation",
            "To outline forming temperatures, sealing roller dwell times, and vacuum leak testing parameters for blister packaging.",
            2
        ),
        ValidationSopPair(
            "SOP for Powder Inhalation Filling Process Validation",
            "To define micro-dosing weight variations, relative humidity controls, and static charge elimination during dry powder runs.",
            2
        ),
        ValidationSopPair(
            "SOP for Lyophilization Freeze-Drying Process Validation",
            "To establish freezing curves, condenser temperatures, primary drying vacuum pressures, and secondary moisture reduction.",
            2
        ),
        ValidationSopPair(
            "SOP for Process Validation Report Compilation",
            "To outline compile guidelines, statistical evaluations, deviation registers, and QA release approval for process validation files.",
            2
        ),

        // 3. Cleaning Validation (46 - 65)
        ValidationSopPair(
            "SOP for Drafting Cleaning Validation Protocols",
            "To outline the guidelines for drafting, reviewing, and approving equipment cleaning validation protocols.",
            3
        ),
        ValidationSopPair(
            "SOP for Worst-Case Product Selection in Cleaning Validation",
            "To establish matrix based on solubility, potency, toxicity, and batch size to determine the worst-case product.",
            3
        ),
        ValidationSopPair(
            "SOP for Calculation of Maximum Allowable Carryover (MACO)",
            "To define the mathematical formulas for calculating MACO based on LD50, ADI, and dose limits.",
            3
        ),
        ValidationSopPair(
            "SOP for Swab Sampling Methodology",
            "To outline standard dacron swab wetting, template applications, swabbing stroke techniques, and storage vials.",
            3
        ),
        ValidationSopPair(
            "SOP for Rinse Sampling Methodology",
            "To establish standard rinse volume flushes, collection beaker sanitizations, and analytical sample transfers.",
            3
        ),
        ValidationSopPair(
            "SOP for Cleaning Validation Swab Recovery Studies",
            "To outline spiking stainless steel coupons, recovery factor calculations, and analytical correction parameters.",
            3
        ),
        ValidationSopPair(
            "SOP for Cleaning Validation Rinse Recovery Studies",
            "To define chemical recovery calculations from rinse flushing on coupon surfaces to validate rinse sampling.",
            3
        ),
        ValidationSopPair(
            "SOP for Visual Inspection Cleanliness Criteria",
            "To establish high-intensity lighting checks, visual distance constraints, and 'visually clean' verification for equipment.",
            3
        ),
        ValidationSopPair(
            "SOP for Validation of Manual Cleaning Procedures",
            "To outline training matrix, scrub duration, detergent concentration, and operator reproducibility for manual washes.",
            3
        ),
        ValidationSopPair(
            "SOP for Validation of Clean-In-Place (CIP) Cycles",
            "To establish spray-ball pressure, solvent temperature, circulation times, and rinse conductivity validation for CIP.",
            3
        ),
        ValidationSopPair(
            "SOP for Validation of Wash-In-Place (WIP) Systems",
            "To outline water volume flushes, pressure nozzle alignments, and cycle validations for WIP cabinets.",
            3
        ),
        ValidationSopPair(
            "SOP for Equipment Hold Time (EHT) Validation",
            "To define standard timelines, microbiological swab collections, and bioburden limits for dirty equipment storage.",
            3
        ),
        ValidationSopPair(
            "SOP for Clean Equipment Hold Time (CEHT) Validation",
            "To establish storage conditions, environmental controls, and microbial swab checks for clean equipment hold limits.",
            3
        ),
        ValidationSopPair(
            "SOP for Cleaning Validation Detergent Residue Trace",
            "To outline chemical detection methods (TOC, conductivity) to verify detergent residue compliance below limits.",
            3
        ),
        ValidationSopPair(
            "SOP for Microbiological Swab Sampling in Cleaning Validation",
            "To define sampling clean surfaces for total aerobic counts and pathogen check to validate disinfection cycles.",
            3
        ),
        ValidationSopPair(
            "SOP for Dedicated Equipment Cleaning Validation",
            "To establish reduced cleaning studies, checking mechanical crevices, and validation logic for dedicated machinery.",
            3
        ),
        ValidationSopPair(
            "SOP for Cleaning Validation Analytical Method Linkage",
            "To outline linking validated HPLC/UV/TOC assays to cleaning protocols for active residue detections.",
            3
        ),
        ValidationSopPair(
            "SOP for Re-Validation of Cleaning Procedures",
            "To define triggers like cleaning agent changes, major equipment modifications, or historical trends for re-validation.",
            3
        ),
        ValidationSopPair(
            "SOP for Training and Certification of Swab Samplers",
            "To establish annual practical assessments, target recoveries check, and certification for cleaning validation samplers.",
            3
        ),
        ValidationSopPair(
            "SOP for Cleaning Validation Summary Report Preparation",
            "To outline combining swab results, rinse values, recovery factor corrections, and final cGMP approvals.",
            3
        ),

        // 4. Analytical Method Validation (66 - 80)
        ValidationSopPair(
            "SOP for Analytical Method Validation Protocol",
            "To outline the drafting, review, and approval of protocols for validating HPLC, GC, and UV analytical assays.",
            4
        ),
        ValidationSopPair(
            "SOP for Method Specificity and Selectivity Validation",
            "To establish testing procedures to prove non-interference from excipients, placebos, impurities, and degradation products.",
            4
        ),
        ValidationSopPair(
            "SOP for Method Linearity and Range Validation",
            "To outline preparing standard dilution series (minimum 5 concentration points) and calculating regression coefficient R².",
            4
        ),
        ValidationSopPair(
            "SOP for Method Accuracy and Recovery Validation",
            "To define standard recovery spikes at 50%, 100%, and 150% target concentration and calculating percent recoveries.",
            4
        ),
        ValidationSopPair(
            "SOP for Method Precision and Repeatability Validation",
            "To establish six injection repeatability check, calculating Relative Standard Deviation (%RSD) for analytical assays.",
            4
        ),
        ValidationSopPair(
            "SOP for Intermediate Precision Validation",
            "To outline testing reproducibility across different analysts, different days, and different columns or instruments.",
            4
        ),
        ValidationSopPair(
            "SOP for Method Limit of Detection (LOD) Determination",
            "To define signal-to-noise ratio calculation (3:1) and calculating LOD limits for analytical impurity trace methods.",
            4
        ),
        ValidationSopPair(
            "SOP for Method Limit of Quantitation (LOQ) Determination",
            "To define signal-to-noise ratio calculation (10:1) and calculating LOQ limits for analytical trace methods.",
            4
        ),
        ValidationSopPair(
            "SOP for Method Robustness Validation Studies",
            "To outline deliberately varying flow rates, pH buffers, mobile phase ratios, and column oven temperatures during validation.",
            4
        ),
        ValidationSopPair(
            "SOP for Analytical Solution Stability Validation",
            "To establish storage conditions (refrigerated, ambient), checking degradation rates, and defining sample shelf-life limits.",
            4
        ),
        ValidationSopPair(
            "SOP for Validation of Dissolution Testing Methods",
            "To outline paddle/basket RPM validations, dissolution medium compositions, and filter absorption evaluation studies.",
            4
        ),
        ValidationSopPair(
            "SOP for Validation of Microbiological Assays",
            "To define cylinder plate or turbidimetric test validations, inoculant densities, and standard dose-response curves.",
            4
        ),
        ValidationSopPair(
            "SOP for Analytical Method Transfer Validation",
            "To establish transfer protocols, receiving-sending lab comparative testings, and acceptance limits for technology transfers.",
            4
        ),
        ValidationSopPair(
            "SOP for Re-Validation of Analytical Methods",
            "To define criteria like synthetic route changes, API supplier changes, or testing scope adjustments for method re-validation.",
            4
        ),
        ValidationSopPair(
            "SOP for Analytical Method Validation Report Compilation",
            "To outline combining raw chromatograms, calculating regression lines, summarizing statistical variances, and QA sign-off.",
            4
        ),

        // 5. Computer System Validation (CSV) (81 - 95)
        ValidationSopPair(
            "SOP for Computer System Validation Master Plan",
            "To outline the overall site strategy, system inventory, GAMP 5 category assignments, and lifecycle for CSV.",
            5
        ),
        ValidationSopPair(
            "SOP for User Requirement Specifications (URS) for Software",
            "To establish guidelines for capturing functional, security, data integrity, and compliance requirements for software packages.",
            5
        ),
        ValidationSopPair(
            "SOP for GAMP 5 Risk Assessment Methodology",
            "To define failure mode classifications, impact evaluation on product quality, and mitigating controls for GXP computer systems.",
            5
        ),
        ValidationSopPair(
            "SOP for Functional Specification (FS) Verification",
            "To outline verifying software design code modules, database structures, and system configurations against URS.",
            5
        ),
        ValidationSopPair(
            "SOP for Installation Qualification of GXP Software",
            "To establish verification for operating system requirements, SQL databases, directory paths, and client installations.",
            5
        ),
        ValidationSopPair(
            "SOP for Operational Qualification of GXP Software",
            "To outline testing login permissions, electronic signatures, backup logs, data entries, and system parameter limits.",
            5
        ),
        ValidationSopPair(
            "SOP for Performance Qualification of GXP Software",
            "To define executing user acceptance tests, batch entry verifications, and workflow approvals under standard conditions.",
            5
        ),
        ValidationSopPair(
            "SOP for 21 CFR Part 11 Electronic Signature Validation",
            "To establish password complex rules, timeout logoffs, audit trails, and non-repudiation configurations.",
            5
        ),
        ValidationSopPair(
            "SOP for Software Audit Trail Review and Verification",
            "To outline daily/weekly audit log checkups, detecting manual edits, unauthorized entries, and supervisor reviews.",
            5
        ),
        ValidationSopPair(
            "SOP for GXP Database Backup and Recovery Validation",
            "To define schedule configurations, data compression, encrypted storage, and mock-recovery validation runs.",
            5
        ),
        ValidationSopPair(
            "SOP for Disaster Recovery Planning for GXP Systems",
            "To establish emergency standby servers, database replications, manual fallback processes, and disaster-recovery qualification.",
            5
        ),
        ValidationSopPair(
            "SOP for Legacy Computer System Validation Guidance",
            "To outline gap analyses, compensating controls, audit trail add-ons, and retrospective validations for old software.",
            5
        ),
        ValidationSopPair(
            "SOP for Validation of LIMS (Laboratory Information Management)",
            "To define sample entry verification, automatic calculation validation, certificate of analysis generation, and user roles.",
            5
        ),
        ValidationSopPair(
            "SOP for Validation of ERP Warehouse Tracking Modules",
            "To establish barcode scanning, material location locks, status change triggers (released, quarantine) validations.",
            5
        ),
        ValidationSopPair(
            "SOP for CSV Periodic Review and System Decommissioning",
            "To outline annual audit checkups of computer systems, tracking updates, and secure data migration for decommissioning.",
            5
        ),

        // 6. Utility & HVAC Validation (96 - 105)
        ValidationSopPair(
            "SOP for Cleanroom HVAC Qualification Protocol",
            "To outline drafting facility air mapping protocols, defining differential pressure targets, and cleanroom class criteria.",
            6
        ),
        ValidationSopPair(
            "SOP for HEPA Filter Integrity (PAO) Leak Testing",
            "To establish aerosol generator setups, photometer scans over filter media, gasket leak detection, and limits.",
            6
        ),
        ValidationSopPair(
            "SOP for Cleanroom Air Velocity and Change Rate Validation",
            "To outline vane-anemometer measurements, grid calculations, and verifying air change rates per hour (ACPH) compliance.",
            6
        ),
        ValidationSopPair(
            "SOP for Differential Pressure Cascade Validation",
            "To define monitoring pressure sensors under dynamic air-handler runs, checking pressure drops, and interlock timings.",
            6
        ),
        ValidationSopPair(
            "SOP for Cleanroom Recovery Run Qualification",
            "To establish particle generator spiking, measuring time intervals to restore cleanroom air class within 15 minutes.",
            6
        ),
        ValidationSopPair(
            "SOP for Non-Viable Particulate Count Mapping",
            "To outline positioning isokinetic probes, sample air volumes (1 m³), mapping grids, and class compliance audits.",
            6
        ),
        ValidationSopPair(
            "SOP for Purified Water System Validation Protocol",
            "To define executing Phase I (daily testing for 2 weeks), Phase II (2 weeks), and Phase III (1 year) sampling matrix.",
            6
        ),
        ValidationSopPair(
            "SOP for Water for Injection (WFI) Distillation Validation",
            "To establish validation parameters for vapor compression or multi-effect distillation columns, TOC and conductivity limits.",
            6
        ),
        ValidationSopPair(
            "SOP for Compressed Air Moisture and Dew-Point Validation",
            "To outline dew-point chilled-mirror sensor validations, moisture content trace limits, and inline sampling checks.",
            6
        ),
        ValidationSopPair(
            "SOP for Nitrogen Gas Purity and Particle Count Validation",
            "To establish oxygen sensor calibrations, particulate counts per volume, and validating nitrogen pressure distributions.",
            6
        )
    )

    fun getValidationSops(): List<SopEntity> {
        return rawValidationSops.mapIndexed { index, pair ->
            val codeStr = String.format("SOP-VAL-%03d", index + 1)
            
            val (dept, cat, role) = when (pair.typeIndex) {
                1 -> Triple("Validation", "Equipment Qualification", "Validation Engineer")
                2 -> Triple("Validation", "Process Validation", "Process Specialist")
                3 -> Triple("Validation", "Cleaning Validation", "Validation Scientist")
                4 -> Triple("Validation", "Analytical Method Validation", "Analytical Chemist")
                5 -> Triple("Validation", "Computer System Validation", "CSV Engineer")
                6 -> Triple("Validation", "Utility & HVAC Validation", "Utility Engineer")
                else -> Triple("Validation", "General Validation", "QA Officer")
            }

            // High-quality domain-specific procedures
            val procedureSteps = when (pair.typeIndex) {
                1 -> "Verify all design specifications against vendor documentation (IQ).;Perform electrical, pneumatic, and safety interlock verifications (OQ).;Run the equipment under load using placebo or dummy materials (PQ).;Measure process consistency across three consecutive successful runs.;Document all deviations, compile the final qualification report, and submit to QA."
                2 -> "Prepare the process validation protocol and obtain inter-departmental approvals.;Determine critical process parameters (CPPs) and critical quality attributes (CQAs).;Monitor three consecutive commercial-scale batches under strict in-process control.;Collect representative samples from predefined sampling points across the batch.;Review batch yield, analytical results, and statistical process capability indexes (Cpk)."
                3 -> "Identify the worst-case product based on solubility, toxicity, and potency.;Draft the cleaning validation protocol specifying limits for active residues (MACO).;Execute the cleaning procedure and visually inspect all product contact surfaces.;Collect swab samples from difficult-to-clean locations using clean dacron swabs.;Perform rinse water sampling and analyze using validated HPLC or TOC methods."
                4 -> "Determine analytical method specificity by analyzing blank, placebo, and standards.;Prepare a series of standard solutions to establish method linearity (R² > 0.999).;Evaluate method accuracy by recovering active ingredients at 50%, 100%, and 150% levels.;Perform precision studies including system suitability, repeatability, and intermediate precision.;Determine the Limit of Detection (LOD) and Limit of Quantitation (LOQ)."
                5 -> "Define user requirement specifications (URS) and perform GAMP 5 risk assessment.;Verify software installation, directory structures, and electronic access privileges (IQ).;Test core software functional modules, boundary parameters, and alarm triggers (OQ).;Conduct user acceptance testing (UAT) and verify security and electronic signatures (PQ).;Perform continuous audit trail reviews and periodic data backup/restoration checks."
                6 -> "Perform air velocity mapping and determine air change rates per hour (ACPH).;Conduct HEPA filter integrity tests using poly-alpha-olefin (PAO) aerosol challenge.;Measure differential pressures across pressure cascade boundaries under dynamic conditions.;Conduct non-viable particulate count mapping and airborne viable microbial monitoring.;Execute recovery runs to verify the time required to restore cleanroom class."
                else -> "Draft standard validation protocol specifying requirements and testing goals.;Verify pre-requisite conditions and ensure all safety instructions are reviewed.;Execute steps sequentially and record results on approved sheets immediately.;Check limits and flag any out-of-limit observation to the supervisor.;Compile findings, write summary recommendations, and sign off the record.;Submit files to Quality Assurance for formal documentation and archiving."
            }

            SopEntity(
                code = codeStr,
                title = pair.title,
                department = dept,
                section = cat,
                objective = pair.objective,
                scope = "This standard operating procedure is applicable to all validation, qualification, and testing activities performed within the $cat division of the pharmaceutical facility.",
                responsibility = "The $role is responsible for performing the tests, the Validation Manager for review, and Quality Assurance for final oversight and approval.",
                procedure = procedureSteps,
                safetyPrecautions = "Always wear appropriate cleanroom garments or laboratory personal protective equipment (PPE).;Ensure equipment electrical isolation rules are strictly followed before validation probes are installed.",
                frequency = "Biennially (Every 2 years) or after any major system modification/change control.",
                effectiveDate = "2026-06-28",
                roleRequired = "QA Specialist"
            )
        }
    }
}
