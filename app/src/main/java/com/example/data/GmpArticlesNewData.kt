package com.example.data

object GmpArticlesNewData {

    data class GmpSopPair(
        val title: String,
        val objective: String,
        val typeIndex: Int // 1 to 10
    )

    private val rawGmpSops = listOf(
        // 1. Quality Management System (QMS) (1 - 15)
        GmpSopPair(
            "SOP for Deviation Handling and Investigation",
            "To outline a standardized process for identifying, reporting, and investigating deviations from approved GMP guidelines.",
            1
        ),
        GmpSopPair(
            "SOP for Out of Specification (OOS) Investigations",
            "To establish clear laboratory and manufacturing investigation workflows for any test result falling outside approved standards.",
            1
        ),
        GmpSopPair(
            "SOP for Out of Trend (OOT) Investigations",
            "To define guidelines for identifying and investigating analytical or process trends showing drift even within specs.",
            1
        ),
        GmpSopPair(
            "SOP for Corrective and Preventive Action (CAPA) Management",
            "To define procedures for logging, tracking, executing, and evaluating the effectiveness of CAPA plans.",
            1
        ),
        GmpSopPair(
            "SOP for Quality Risk Management (QRM) Implementation",
            "To outline a risk-based framework utilizing FMEA and HACCP methodologies for quality hazard evaluation.",
            1
        ),
        GmpSopPair(
            "SOP for Change Control Management and Impact Assessment",
            "To establish standard workflows for requesting, evaluating, and QA authorizing changes to validated processes or equipment.",
            1
        ),
        GmpSopPair(
            "SOP for Preparing and Reviewing Annual Product Quality Review (APQR)",
            "To detail compiling batch statistics, stability summaries, and deviation trends into annual regulatory quality reviews.",
            1
        ),
        GmpSopPair(
            "SOP for Quality Management Review (QMR) Meetings",
            "To outline procedures for scheduling, preparing agendas, and summarizing decisions made during QMR executive meetings.",
            1
        ),
        GmpSopPair(
            "SOP for Field Alert Reports (FAR) and Regulatory Alerts",
            "To establish mandatory timelines and communication pathways for reporting critical quality failures to the FDA or other bodies.",
            1
        ),
        GmpSopPair(
            "SOP for Quality KPI Tracking and Reporting",
            "To define site quality key performance indicators, including right-first-time index and CAPA timelines compliance.",
            1
        ),
        GmpSopPair(
            "SOP for Preparing Quality System Manual",
            "To outline the layout, contents, and review requirements for maintaining the pharmaceutical site's Quality Manual.",
            1
        ),
        GmpSopPair(
            "SOP for GxP Regulatory Inspection Readiness",
            "To establish guidelines for periodic self-inspections and mock audits to prepare the site for regulatory checks.",
            1
        ),
        GmpSopPair(
            "SOP for Managing Technical Quality Disagreements",
            "To outline escalation steps and dispute-resolution workflows for technical quality differences between departments.",
            1
        ),
        GmpSopPair(
            "SOP for Product Development Quality Oversight",
            "To define the quality gate reviews and documentation verifications required during scale-up and tech transfer.",
            1
        ),
        GmpSopPair(
            "SOP for GxP Training Program Management",
            "To establish standard processes for managing GMP training plans, schedules, and personnel qualifications.",
            1
        ),

        // 2. Personnel, Gowning, Hygiene (16 - 30)
        GmpSopPair(
            "SOP for Cleanroom Gowning Procedure and Qualification",
            "To detail aseptic gowning steps for entering Grade A/B cleanrooms and the qualification of operators.",
            2
        ),
        GmpSopPair(
            "SOP for Personal Hygiene and Health Monitoring",
            "To establish mandatory hand sanitization, disease reporting, and physical checkups for GMP area operators.",
            2
        ),
        GmpSopPair(
            "SOP for Training Needs Analysis and Annual Training Plan",
            "To outline the development of training curricula based on role matrices and plant GMP operations.",
            2
        ),
        GmpSopPair(
            "SOP for Qualification of GMP Trainers",
            "To establish criteria for verifying, assessing, and certifying internal trainers and instructors.",
            2
        ),
        GmpSopPair(
            "SOP for Training File Maintenance",
            "To define rules for updating, filing, and verifying employee training log binders and certificates.",
            2
        ),
        GmpSopPair(
            "SOP for Managing Temporary and Contract Personnel",
            "To outline basic GMP training, monitoring, and boundary rules for third-party contracted staff on site.",
            2
        ),
        GmpSopPair(
            "SOP for Hand Washing and Sanitization in GxP Premise",
            "To establish detailed sanitization, drying, and hand-swabbing verifications for entering plant airlocks.",
            2
        ),
        GmpSopPair(
            "SOP for Laundering and Storage of Cleanroom Garments",
            "To outline detergent wash cycles, drying, packaging in polybags, and autoclave sterilization of cleanroom garments.",
            2
        ),
        GmpSopPair(
            "SOP for Eye Protection and Safety Glasses Guidelines",
            "To define the selection, cleaning, storage, and mandatory wear of safety glasses inside manufacturing and QC lab blocks.",
            2
        ),
        GmpSopPair(
            "SOP for Cleaning of Visitor Apparel",
            "To establish sanitization and stocking guidelines for gowns and safety shoes used by plant visitors.",
            2
        ),
        GmpSopPair(
            "SOP for Control of Hair, Jewelry and Cosmetics",
            "To outline restrictions on jewelry, makeup, perfume, and long fingernails inside GxP blocks.",
            2
        ),
        GmpSopPair(
            "SOP for Personnel Flow and Airlock Access",
            "To define separate paths for entry/exit of operators to prevent clean/dirty corridor cross-contamination.",
            2
        ),
        GmpSopPair(
            "SOP for Shift Handover Protocols",
            "To establish guidelines for double-signing logs and face-to-face handovers of machinery status during shift changes.",
            2
        ),
        GmpSopPair(
            "SOP for Handling GxP Personal Injuries",
            "To outline immediate response, reporting, first-aid application, and tracking on-site physical cuts or burns.",
            2
        ),
        GmpSopPair(
            "SOP for Infectious Diseases Evaluation",
            "To establish screening protocols for restricting sick or infected staff from direct product contact areas.",
            2
        ),

        // 3. Premises, Equipment, Utilities (31 - 45)
        GmpSopPair(
            "SOP for Pest and Rodent Control in GxP Areas",
            "To outline placement mapping of bait stations, inspect schedules, and monthly pesticide contracts.",
            3
        ),
        GmpSopPair(
            "SOP for Cleaning and Sanitization of Production Areas",
            "To define daily mopping, wall wipe-downs, and lint-free equipment dustings in tablet and liquid blocks.",
            3
        ),
        GmpSopPair(
            "SOP for Preventive Maintenance of Manufacturing Equipment",
            "To establish monthly, quarterly, and annual maintenance schedules, lubricants check, and belt checks.",
            3
        ),
        GmpSopPair(
            "SOP for Equipment Identification and Status Labeling",
            "To outline color-coded status stickers (Cleaned, Under Maintenance, To Be Cleaned) applied to machinery.",
            3
        ),
        GmpSopPair(
            "SOP for Calibration of Process Measuring Instruments",
            "To establish standard master-meter comparison routines for on-line gauges, thermocouples, and sensor arrays.",
            3
        ),
        GmpSopPair(
            "SOP for Cleanroom Facility Cleaning and Disinfection",
            "To detail sterile cleanroom disinfection cycles, sanitizers rotations, and triple-bucket mop procedures.",
            3
        ),
        GmpSopPair(
            "SOP for Differential Pressure Monitoring of HVAC Systems",
            "To define limits, recording frequency, and emergency corrective responses for HVAC pressure excursions.",
            3
        ),
        GmpSopPair(
            "SOP for HEPA Filter Integrity Testing (PAO Challenge)",
            "To establish aerosol photometer leakage scanning guidelines for cleanroom ceiling HEPA installations.",
            3
        ),
        GmpSopPair(
            "SOP for Purified Water Loop Line Sanitization",
            "To define heat-cycle loops water circulation (80°C) parameters to control microbiological bioburden.",
            3
        ),
        GmpSopPair(
            "SOP for Sand Filter Backwashing in Purified Water Plant",
            "To outline multi-valve adjustments and reverse-pressure flushing of sand filter beds to remove sediments.",
            3
        ),
        GmpSopPair(
            "SOP for Active Carbon Filter Steam Sanitization",
            "To establish steam exposure schedules to eliminate biofilms within active carbon filtration systems.",
            3
        ),
        GmpSopPair(
            "SOP for Water for Injection (WFI) Loop Temperature Maintenance",
            "To define continuous hot circulation (85°C) guidelines and loop monitoring of conductivity.",
            3
        ),
        GmpSopPair(
            "SOP for Nitrogen Gas Line Purity Monitoring",
            "To outline oxygen content trace measuring, particulate filters checks, and system pressure logging.",
            3
        ),
        GmpSopPair(
            "SOP for Compressed Air Particle and Moisture Monitoring",
            "To establish dew-point mirror verifications and inline particle count checks for process compressed air.",
            3
        ),
        GmpSopPair(
            "SOP for GxP Site Earthing Copper Rod Inspections",
            "To define ground resistance tests, moisture verifications, and cabling checks for building earth links.",
            3
        ),

        // 4. Documentation, Batch Records, Labeling (46 - 60)
        GmpSopPair(
            "SOP for Good Documentation Practices (GDP)",
            "To outline permanent ink writing rules, contemporaneous entries, error corrections, and signature controls.",
            4
        ),
        GmpSopPair(
            "SOP for Issuance and Control of Batch Manufacturing Records (BMR)",
            "To define security printings, master template checks, barcode verifications, and logs of issued BMR pages.",
            4
        ),
        GmpSopPair(
            "SOP for Review of Completed Batch Records for Product Release",
            "To outline line clearance reviews, raw data calculations verify, and QA head final release signatures.",
            4
        ),
        GmpSopPair(
            "SOP for Revision, Review, and Approval of SOPs",
            "To establish drafting protocols, reviewer assignments, QA authorizations, and tracking SOP lifecycle histories.",
            4
        ),
        GmpSopPair(
            "SOP for Long-term Archiving and Retrieval of GxP Documents",
            "To detail packing, indexing, fireproof warehouse storage, and secure card-access controls of records.",
            4
        ),
        GmpSopPair(
            "SOP for Preparation and Control of Master Formulation Records (MFR)",
            "To outline development, formatting, dual-verification, and secure lockings of site master formulas.",
            4
        ),
        GmpSopPair(
            "SOP for Hand-written Correction and Strike-through Approvals",
            "To establish single clear strike rules, adding reasons for changes, and supervisor counter-signing.",
            4
        ),
        GmpSopPair(
            "SOP for Issuance and Control of Logbooks and Notebooks",
            "To define unique alphanumeric coding, page-number verifications, and archiving of laboratory and facility logs.",
            4
        ),
        GmpSopPair(
            "SOP for Watermark Decal Printing for Approved Labels",
            "To outline security background printing, logo validations, and count check of released carton labels.",
            4
        ),
        GmpSopPair(
            "SOP for Security and Control of Master Signature Logs",
            "To establish annual collection, digitizing, and validation checks of signature registries.",
            4
        ),
        GmpSopPair(
            "SOP for Coding and Alphanumeric Numbering of GxP Documents",
            "To define site-wide identifier logic (e.g., SOP-QA-XXX) to maintain complete data traceability.",
            4
        ),
        GmpSopPair(
            "SOP for Destruction and Cross-cut Shredding of Obsolete Records",
            "To outline dual-operator witness verifications and shredder specifications for destroying outdated files.",
            4
        ),
        GmpSopPair(
            "SOP for Verification of Serialized Finished Product Carton Labels",
            "To detail barcode scanning verification and print quality checks for regulatory serialization databases.",
            4
        ),
        GmpSopPair(
            "SOP for Controlled Issuance of Product Pallet Barcodes",
            "To define generating unique pallet identifiers, matching lots, and digital inventory database postings.",
            4
        ),
        GmpSopPair(
            "SOP for GxP Document Vault Access and Control Policies",
            "To establish logbook entries, magnetic lock credentials, and fire suppression test schedules for GxP vaults.",
            4
        ),

        // 5. Production Controls & Line Clearance (61 - 75)
        GmpSopPair(
            "SOP for Line Clearance before Granulation Run",
            "To establish absolute machine checks, past lot labels disposal, and dust-line vacuums prior to granulation.",
            5
        ),
        GmpSopPair(
            "SOP for Line Clearance before Compression Run",
            "To outline checking die-table cleanliness, scraper blades integrity, and vacuum line check before compression.",
            5
        ),
        GmpSopPair(
            "SOP for Line Clearance before Coating Run",
            "To define pan sanitization, spray guns distance, and nozzle checks prior to starting film coating runs.",
            5
        ),
        GmpSopPair(
            "SOP for Line Clearance before Capsule Filling Run",
            "To establish checking dosing disks, tamping pins alignment, and empty capsule feed channels before filling.",
            5
        ),
        GmpSopPair(
            "SOP for Line Clearance before Liquid Syrup Filling",
            "To outline syrup tank flush verifications, pump nozzle cleaning, and line air evacuations prior to liquid filling.",
            5
        ),
        GmpSopPair(
            "SOP for Line Clearance before Blister Packaging Run",
            "To establish heating plate inspections, cutting dies alignment, and verifying packaging lot numbers.",
            5
        ),
        GmpSopPair(
            "SOP for Handling of Leftover and Returned Excess Raw Materials",
            "To outline container seals check, weighing balances, and returning raw stock safely back to warehouse.",
            5
        ),
        GmpSopPair(
            "SOP for Safe Handling and Dispensing of Active Raw Materials",
            "To establish cleanroom pressure verifications, balances calibrations, and wearing respiratory safety masks.",
            5
        ),
        GmpSopPair(
            "SOP for Operation and Cleaning of Rapid Mixer Granulator (RMG)",
            "To define RMG safety locks, chopper speeds, and wet-granulation endpoint indicators.",
            5
        ),
        GmpSopPair(
            "SOP for Operation and Cleaning of Fluid Bed Dryer (FBD)",
            "To establish dryer temperature ramp, air duct filter checks, and FBD powder moisture testing.",
            5
        ),
        GmpSopPair(
            "SOP for Operation and Cleaning of Cone Mill",
            "To outline rotor alignments, screen mesh verifications, and milling motor checks.",
            5
        ),
        GmpSopPair(
            "SOP for Blender Operation and Dry Powder Mixing",
            "To define loading parameters, cage interlocks check, blender speed (12 RPM), and mixing times.",
            5
        ),
        GmpSopPair(
            "SOP for Tablet Compression Set-up and Run Controls",
            "To outline press setups, weight check limits, and automatic scrap-reject mechanisms.",
            5
        ),
        GmpSopPair(
            "SOP for In-Process Checks during Tablet Compression",
            "To establish tablet hardness, thickness, weight, and disintegration tests performed at 30-minute intervals.",
            5
        ),
        GmpSopPair(
            "SOP for Tablet Coating and Weight Gain Calculations",
            "To define film sprayer air atomization, spray gun calibration, and coating weight calculations.",
            5
        ),

        // 6. Quality Control Laboratory Controls (76 - 90)
        GmpSopPair(
            "SOP for Operation and Calibration of Digital pH Meter in QC",
            "To outline standard buffer adjustments, glass electrode storages, and slope calculations.",
            6
        ),
        GmpSopPair(
            "SOP for Calibration of Volumetric Glassware",
            "To establish temperature correction and weight calculations for volumetric pipettes and flasks.",
            6
        ),
        GmpSopPair(
            "SOP for Preparation and Standardization of Volumetric Solutions",
            "To define primary standard dryings, titrations, factor logging, and shelf-life tracking.",
            6
        ),
        GmpSopPair(
            "SOP for Operation and Maintenance of UV-Visible Spectrophotometer",
            "To establish wavelength calibrations, lamp alignments, baseline flats, and calibration checks.",
            6
        ),
        GmpSopPair(
            "SOP for Operating Karl Fischer Volumetric Titrators",
            "To outline sample weighing, moisture calibrations, cell cleanings, and drift verifications.",
            6
        ),
        GmpSopPair(
            "SOP for Calibration of Digital Electronic Balances",
            "To establish standard weights calibrations, corner weight accuracy checks, and balance leveling logs.",
            6
        ),
        GmpSopPair(
            "SOP for Analytical Chromatographic Column Lifetime Tracking",
            "To outline column unique codings, injection logs, solvent cleans, and backpressure graphs.",
            6
        ),
        GmpSopPair(
            "SOP for Handling and Storage of Reference Standards",
            "To define freezer logs, opening dates, working standards qualifications, and vial disposals.",
            6
        ),
        GmpSopPair(
            "SOP for Sampling of Raw Materials under RLAF",
            "To establish laminar flow checks, sampler cleanliness, and cross-contamination prevention.",
            6
        ),
        GmpSopPair(
            "SOP for Wet Chemical Limit Tests for Heavy Metals",
            "To outline sample digestions, lead standard comparisons, and visual inspections of precipitate.",
            6
        ),
        GmpSopPair(
            "SOP for Wet Chemical Limit Tests for Arsenic",
            "To detail Gutzeit apparatus setups, mercury-bromide papers stain matching, and acid digestions.",
            6
        ),
        GmpSopPair(
            "SOP for Reagent Expiration and Storage Labeling in QC",
            "To define container labeling, preparer initials, hazard color codings, and safe discard logs.",
            6
        ),
        GmpSopPair(
            "SOP for Chromatographic System Suitability Checks",
            "To establish inject RSD limits, tailing factors, and theoretical plates checks for HPLC.",
            6
        ),
        GmpSopPair(
            "SOP for Handling of Laboratory Solvents and Flammables",
            "To outline storage in flameproof lockers, earthing wire links, and maximum container volume rules.",
            6
        ),
        GmpSopPair(
            "SOP for Operation and Calibration of Melting Point Apparatus",
            "To define capillary packing, heating ramp speed control, and recording melt-onset indices.",
            6
        ),

        // 7. Microbiology Laboratory Controls (91 - 105)
        GmpSopPair(
            "SOP for Preparation and Autoclaving of Culture Media",
            "To establish powder mixing, pH adjusts, autoclave sterilization parameters, and media log tracking.",
            7
        ),
        GmpSopPair(
            "SOP for Growth Promotion Testing (GPT) of Media",
            "To outline standard strain inoculations, recovery count compare, and media release validations.",
            7
        ),
        GmpSopPair(
            "SOP for Microbiological Air Sampling in Cleanrooms",
            "To define active air sampler setups, plate placement mapping, and colony-forming unit calculations.",
            7
        ),
        GmpSopPair(
            "SOP for Settle Plates Environmental Monitoring",
            "To outline exposure times (4 hours), location mappings, and incubation parameters inside cleanrooms.",
            7
        ),
        GmpSopPair(
            "SOP for Finger Dab Print Sampling of Operators",
            "To establish glove finger-dab prints on agar plates prior to and after aseptic manufacturing shifts.",
            7
        ),
        GmpSopPair(
            "SOP for Bacterial Endotoxin Testing (BET) by Gel Clot",
            "To define LAL reagent reconstitution, tube dilution curves, hot-water bath incubation, and gel checks.",
            7
        ),
        GmpSopPair(
            "SOP for Sterility Testing of Finished Sterile Batches",
            "To outline membrane filter canister transfers, flushing runs, and 14-day incubations in FTM and TSB.",
            7
        ),
        GmpSopPair(
            "SOP for Maintenance and Cryovial Storage of Reference Strains",
            "To detail freeze-dry cultures opening, subculturing limits (5 passages), and deep-freezer logs.",
            7
        ),
        GmpSopPair(
            "SOP for Calibration of Bio-Incubators Temp Sensors",
            "To establish multi-point thermocouple verifications and alarm triggers checks inside incubators.",
            7
        ),
        GmpSopPair(
            "SOP for Micro Lab Chemical Disinfectant Rotations",
            "To outline rotating sanitizers weekly, preparing diluted sprays, and mopping micro lab walls.",
            7
        ),
        GmpSopPair(
            "SOP for Disposal of Active Bio-hazardous Plates",
            "To define autoclaving waste runs, secure bag packaging, and weigh logs of microbial bio-waste.",
            7
        ),
        GmpSopPair(
            "SOP for Purified Water Sampling for Total Viable Count",
            "To outline sampling port flushes, sterile bottle rinses, membrane filtration, and colony counts.",
            7
        ),
        GmpSopPair(
            "SOP for Identification of Microbial Contaminants",
            "To detail Gram staining methods, morphology examine, and biochemical kit checks of colonies.",
            7
        ),
        GmpSopPair(
            "SOP for Validation of Gowning of Microbiologists",
            "To establish annual practical checks, glove swabs recovery limits, and chest swabbing validations.",
            7
        ),
        GmpSopPair(
            "SOP for Operation and Care of Class II Biosafety Cabinets",
            "To outline HEPA flow velocity checkups, UV light runtime monitors, and sash height safety settings.",
            7
        ),

        // 8. Data Integrity & IT Systems (106 - 120)
        GmpSopPair(
            "SOP for User Privilege Management in GxP Software",
            "To outline user access request flows, password setups, and deleting inactive GxP accounts.",
            8
        ),
        GmpSopPair(
            "SOP for Computer GxP User Password Complexity Rules",
            "To establish character requirements, minimum length, and automatic lock expiration thresholds.",
            8
        ),
        GmpSopPair(
            "SOP for Periodic Auditing of Computer GxP Audit Trails",
            "To define weekly analytical audit trail review protocols and supervisor verification checks.",
            8
        ),
        GmpSopPair(
            "SOP for GxP Database Backup and Restore Validations",
            "To outline automatic schedules, off-site archive drives, and biannual recovery test runs.",
            8
        ),
        GmpSopPair(
            "SOP for Disaster Recovery Planning for Software Systems",
            "To establish fallback servers, emergency data recovery procedures, and post-recovery validations.",
            8
        ),
        GmpSopPair(
            "SOP for GAMP 5 Software Risk Assessments",
            "To detail categorizing software packages and conducting hazard analyses to verify product quality.",
            8
        ),
        GmpSopPair(
            "SOP for Installation Qualification of GxP Software",
            "To establish checkups of hardware, server paths, SQL DB links, and operating system updates.",
            8
        ),
        GmpSopPair(
            "SOP for Operational Qualification of GxP Software",
            "To outline checking password validation limits, transaction approvals, and alarm notifications.",
            8
        ),
        GmpSopPair(
            "SOP for 21 CFR Part 11 Compliance Audits",
            "To define checklists for validating electronic signatures, audit trail non-repudiation, and records.",
            8
        ),
        GmpSopPair(
            "SOP for Validation of Laboratory Information Management Systems (LIMS)",
            "To establish sample login checks, auto calculation formulas, and secure COA printing validations.",
            8
        ),
        GmpSopPair(
            "SOP for Validation of ERP GxP Transaction Modules",
            "To outline checking status gates (quarantine, release, reject) and database trigger validations.",
            8
        ),
        GmpSopPair(
            "SOP for Decommissioning GxP Computer Systems and Data Migration",
            "To define data extraction, schema mapping, and archiving old software files securely.",
            8
        ),
        GmpSopPair(
            "SOP for Preventing Data Integrity Violations (ALCOA+ Standards)",
            "To establish site-wide GDP compliance, direct machine printouts, and double balance slip checks.",
            8
        ),
        GmpSopPair(
            "SOP for Balance Printout Verification and Double Check",
            "To detail operator double-witnessing of balance weighing values and immediate signature matching.",
            8
        ),
        GmpSopPair(
            "SOP for Direct Archiving of Raw Chromatographic Data",
            "To define chromatographic software configurations for direct vault storage of raw files.",
            8
        ),

        // 9. Contract Operations & Vendor Management (121 - 135)
        GmpSopPair(
            "SOP for GxP Vendor Qualification and Re-qualification",
            "To outline questionnaires, test batch evaluations, and compliance score evaluations.",
            9
        ),
        GmpSopPair(
            "SOP for On-site GxP Vendor Audits",
            "To define audit scheduling, checklist preparation, plant touring, and auditor qualifications.",
            9
        ),
        GmpSopPair(
            "SOP for Approved Vendor List (AVL) Management",
            "To establish criteria for listing, suspending, or blacklisting suppliers of GxP materials.",
            9
        ),
        GmpSopPair(
            "SOP for Site Quality Agreement Management",
            "To outline writing, reviewing, and approving quality boundaries and responsibilities with contract labs.",
            9
        ),
        GmpSopPair(
            "SOP for Contract Manufacturing Organization (CMO) Audits",
            "To establish audit protocols for third-party solid, liquid, and sterile dosage production blocks.",
            9
        ),
        GmpSopPair(
            "SOP for Technical Agreement Review Timelines",
            "To outline biennial re-assessments and update requirements for technical quality agreements.",
            9
        ),
        GmpSopPair(
            "SOP for Escalation of Vendor Quality Deficiencies",
            "To define reporting, logging, and issuing corrective action requests (SCAR) to vendors.",
            9
        ),
        GmpSopPair(
            "SOP for Review of Supplier Certificate of Analysis (COA)",
            "To establish analytical checkup rules and comparisons of supplier results against pharmacopoeias.",
            9
        ),
        GmpSopPair(
            "SOP for Testing of Vendor Sample Lots",
            "To outline collection of representative vendor raw stock and laboratory validation checks.",
            9
        ),
        GmpSopPair(
            "SOP for Qualification of Third-party Logistics (3PL)",
            "To establish temperature mapping of trucks and audit guidelines for transport warehousing.",
            9
        ),
        GmpSopPair(
            "SOP for Management of Outsource Calibration Contractors",
            "To define verification of contractor standards and qualification credentials before site calibration.",
            9
        ),
        GmpSopPair(
            "SOP for Auditing of Third-party Testing Laboratories",
            "To establish GLP checklist verification, instrumentation qualification checks, and audit reports.",
            9
        ),
        GmpSopPair(
            "SOP for Vendor Packaging Materials Evaluations",
            "To outline testing foil rolls, carton card thicknesses, and glass bottle hydrolytic resistance.",
            9
        ),
        GmpSopPair(
            "SOP for Site Quality Oversight on Subcontractors",
            "To define audit and control parameters for sub-tier component or chemical vendors.",
            9
        ),
        GmpSopPair(
            "SOP for Annual Vendor Performance Metrics Review",
            "To establish compiling supplier quality KPIs, deviation counts, and right-first-time ratios.",
            9
        ),

        // 10. Complaints, Product Recall & Audits (136 - 150)
        GmpSopPair(
            "SOP for Handling of Customer Complaints",
            "To establish logging complaints, retrieving reference samples, re-testing, and client replies.",
            10
        ),
        GmpSopPair(
            "SOP for Product Recall Management and Simulation",
            "To outline recall classifications (Class I, II, III), assembly tracing, and mock simulation drills.",
            10
        ),
        GmpSopPair(
            "SOP for Product Recall Committee Activations",
            "To define committee members, emergency roles, and regulatory agency notifications workflows.",
            10
        ),
        GmpSopPair(
            "SOP for Managing Regulatory Observations (FDA Form 483)",
            "To establish root-cause analyses and compilation of 483 response files within 15 working days.",
            10
        ),
        GmpSopPair(
            "SOP for Mock Recall Execution and Verification",
            "To outline annual exercises targeting 100% reconciliation of distributed lots within 48 hours.",
            10
        ),
        GmpSopPair(
            "SOP for Self-Inspections and Internal Quality Audits",
            "To establish annual site schedules, department checklists, and self-inspection reports.",
            10
        ),
        GmpSopPair(
            "SOP for Audit Trail Reviews of QC Instruments",
            "To outline chromatographic database audit verifications and supervisor sign-offs.",
            10
        ),
        GmpSopPair(
            "SOP for Managing Regulatory Inspection Host Rooms",
            "To define inspection hosting rules, scribe verifications, and document retrieval logistics.",
            10
        ),
        GmpSopPair(
            "SOP for Internal Audit CAPA Follow-ups",
            "To establish verifying implementation of corrections and closing out internal audit findings.",
            10
        ),
        GmpSopPair(
            "SOP for Self-Inspection Auditor Qualification",
            "To outline GxP training, quiz grading, and certification of internal self-inspection team.",
            10
        ),
        GmpSopPair(
            "SOP for Customer Audit Hospitality and Logistics",
            "To define host room setups, client tour protocols, and documenting audit questionnaires.",
            10
        ),
        GmpSopPair(
            "SOP for Tracking Audit Responses from GxP Departments",
            "To establish monthly dashboard notifications and escalation paths for overdue audit items.",
            10
        ),
        GmpSopPair(
            "SOP for Management of Regulatory Contact Registries",
            "To define maintaining direct emergency phone links and email contacts of regulatory inspectors.",
            10
        ),
        GmpSopPair(
            "SOP for Filing Clinical Trial Batch Records",
            "To establish secure document storage and tracking of experimental/clinical trial batches.",
            10
        ),
        GmpSopPair(
            "SOP for Site Quality Auditing Closeout Procedures",
            "To outline closing presentations, logging final auditor signatures, and archiving files.",
            10
        )
    )

    fun getGmpSops(): List<SopEntity> {
        return rawGmpSops.mapIndexed { index, pair ->
            val codeStr = String.format("GMP-%03d", index + 5) // Start from GMP-005 onwards
            
            val (dept, cat, role) = when (pair.typeIndex) {
                1 -> Triple("GMP", "Quality Management System", "QMS Specialist")
                2 -> Triple("GMP", "Personnel & Gowning", "Training Coordinator")
                3 -> Triple("GMP", "Premises & Utilities", "Utility Engineer")
                4 -> Triple("GMP", "Documentation & Records", "Document Specialist")
                5 -> Triple("GMP", "Production Controls", "Production Supervisor")
                6 -> Triple("GMP", "QC Lab Controls", "QC Chemist")
                7 -> Triple("GMP", "Microbiology Lab Controls", "Microbiologist")
                8 -> Triple("GMP", "Data Integrity & IT", "Data Integrity Analyst")
                9 -> Triple("GMP", "Vendor Management", "Vendor Auditor")
                10 -> Triple("GMP", "Complaints & Recalls", "Quality Compliance Manager")
                else -> Triple("GMP", "General GMP", "QA Officer")
            }

            // High-quality domain-specific procedures
            val procedureSteps = when (pair.typeIndex) {
                1 -> "Log the quality event inside the QMS electronic system within 24 hours.;Categorize the deviation or trend severity based on standard risk matrices.;Form an investigation team and determine the root cause using fishbone analysis.;Draft clear CAPA actions specifying timelines and owners.;Submit the completed QMS file to QA head for final evaluation and closure."
                2 -> "Initiate hand washing and sanitization at the designated plant entrance airlock.;Proceed to primary gowning room, remove street clothes, and wear protective scrubs.;Wash hands with antimicrobial soap and wear sterile cleanroom gloves.;Proceed to secondary gowning area, wear sterile coveralls, booties, hood, and mask.;Verify visual gowning correctness inside a full-length mirror and step into the cleanroom."
                3 -> "Inspect the GxP premises daily for any leaks, chipped paint, or dust accumulation.;Ensure the HVAC differential pressure gauge readings are within approved limits (10-15 Pa).;Log temperature and relative humidity hourly; escalate if values cross alert triggers.;Clean returning air ducts and return grills using validated chemical spray rotations.;Document all findings in the facility logbook and place appropriate status tags."
                4 -> "Write all entries contemporaneously in permanent black or blue ink.;Ensure all data entries are clear, legible, and directly traceable to raw records.;In case of typographical error, make a single strike-through, write corrections next to it.;Provide initials, dates, and clear justifications for every manual correction.;Archive completed documents inside fireproof vaults with card-entry security."
                5 -> "Verify previous batch product clearance stickers are completely removed from the area.;Clean all machine contact parts and verify cleanliness visually under high-intensity light.;Check that all vacuum lines, tooling dies, and containers are properly sanitized.;Apply green 'LINE CLEARANCE APPROVED' decal signed by both operator and QA inspector.;Begin active batch operations as defined in the master batch record instructions."
                6 -> "Ensure the analytical instrument calibration decal is valid before operation.;Prepare required volumetric solutions and perform standardizations under dual checks.;Calibrate balances or pH meters daily using certified NIST reference standards.;Record all chromatograms directly inside the validated database with audit trail enabled.;Report any unexpected test result to the laboratory supervisor immediately."
                7 -> "Decontaminate the media preparation area and prepare sterile agar culture media.;Conduct growth promotion tests using certified reference strains to verify recovery rates.;Place active or settle plates in designated cleanroom locations for exposure sampling.;Incubate plates at required temperatures and count colony-forming units (CFUs).;Document microbial counts and identify contaminants using Gram staining protocols."
                8 -> "Verify user login permissions and ensure multi-factor authentication is configured.;Never share login passwords or leave active sessions unattended without lockouts.;Perform automatic hourly GxP database backups to secure off-site archive drives.;Review audit trail logs weekly to identify any manual edits or parameter overrides.;Report any potential data integrity breach or security compromise to the QA manager."
                9 -> "Review the GxP vendor questionnaire and verify compliance score evaluations.;Schedule and perform on-site vendor audits targeting raw material supply routes.;Test representative sample lots from the vendor in the laboratory prior to qualification.;Add the qualified supplier to the Site Approved Vendor List (AVL) database.;Conduct biennial re-evaluations of supplier quality metrics and deviation counts."
                10 -> "Log customer complaints within the regulatory tracking system within 24 hours.;Retrieve retained counter-samples from the secure stability chambers vault.;Perform complete laboratory re-testing and investigate manufacturing batch records.;Compile a detailed root-cause investigation report and draft a formal client reply.;In case of critical recall, activate the recall committee and notify regulatory bodies."
                else -> "Verify pre-requisite conditions and ensure all safety instructions are reviewed.;Execute steps sequentially and record results on approved sheets immediately.;Check limits and flag any out-of-limit observation to the supervisor.;Compile findings, write summary recommendations, and sign off the record.;Submit files to Quality Assurance for formal documentation and archiving."
            }

            SopEntity(
                code = codeStr,
                title = pair.title,
                department = dept,
                section = cat,
                objective = pair.objective,
                scope = "This standard operating procedure is applicable to all personnel and operations performed within the $cat division under GMP regulations.",
                responsibility = "The $role is responsible for performing the activities, GxP section heads for review, and Quality Assurance for final oversight and approval.",
                procedure = procedureSteps,
                safetyPrecautions = "Always wear appropriate cleanroom gowning and laboratory personal protective equipment (PPE).;Follow standard chemical and electrical safety guidelines before handling process machinery.",
                frequency = "Biennially (Every 2 years) or after any major quality event or change control.",
                effectiveDate = "2026-06-28",
                roleRequired = "QA Officer"
            )
        }
    }
}
