package com.example.data

data class QaArticle(
    val id: Int,
    val code: String,
    val title: String,
    val category: String,
    val objective: String
)

object QaArticlesNewData {
    val categories = listOf(
        "Documentation & Good Documentation Practices (GDP)",
        "Quality Management Systems (QMS)",
        "Validation & Qualification (V&Q)",
        "Equipment & Facilities Qualification",
        "Materials & Supplier Management",
        "Operations & Line Clearance",
        "Regulatory Compliance & Audits",
        "Training & Personnel Hygiene"
    )

    val articles = listOf(
        // 1. Documentation & Good Documentation Practices (GDP) (1-18)
        QaArticle(1, "SOP-QA-016", "Standard Operating Procedure for Writing and Formatting SOPs", "Documentation & Good Documentation Practices (GDP)", 
            "To outline a standardized format, style, and structure for the preparation of all standard operating procedures (SOPs) on the plant site."),
        QaArticle(2, "SOP-QA-017", "Standard Operating Procedure for Control of Master Documents and GMP Prints", "Documentation & Good Documentation Practices (GDP)", 
            "To define standard methods for secure storage of master templates, issuing controlled copies, and reclaiming expired documents."),
        QaArticle(3, "SOP-QA-018", "Standard Guidelines for Good Documentation Practices (GDP)", "Documentation & Good Documentation Practices (GDP)", 
            "To establish rules for recording raw entries, making manual corrections, using approved inks, and preventing unauthorized records deletion."),
        QaArticle(4, "SOP-QA-019", "Standard Operating Procedure for Retained and Reserve Document Archival", "Documentation & Good Documentation Practices (GDP)", 
            "To define storage conditions, retrieval protocols, access control, and retention periods for batch manufacturing records and logs."),
        QaArticle(5, "SOP-QA-020", "SOP for Review and Approval of Product Labels and Artworks", "Documentation & Good Documentation Practices (GDP)", 
            "To establish standard steps for multi-department approval of packaging artwork, texts, barcode values, and pharmacodes."),
        QaArticle(6, "SOP-QA-021", "SOP for Destruction and Shredding of Rejected or Obsolete Documents", "Documentation & Good Documentation Practices (GDP)", 
            "To define the authorization workflow, cross-shredding weights monitoring, and certificates registry for obsolete files."),
        QaArticle(7, "SOP-QA-022", "SOP for Management and Issuance of Logbooks and Registers", "Documentation & Good Documentation Practices (GDP)", 
            "To outline page numbering, printing control, issuance logs, and verification of analytical and production logbooks."),
        QaArticle(8, "SOP-QA-023", "Guidelines for Data Integrity Compliance (ALCOA+ principles) on Paper Records", "Documentation & Good Documentation Practices (GDP)", 
            "To implement the attributable, legible, contemporaneous, original, and accurate principles across physical GMP records."),
        QaArticle(9, "SOP-QA-024", "SOP for Review and Verification of Batch Manufacturing Records (BMR)", "Documentation & Good Documentation Practices (GDP)", 
            "To outline the checklist for double-review of executed batch records, weight checks, and sign-offs before product release."),
        QaArticle(10, "SOP-QA-025", "SOP for Review and Verification of Batch Packaging Records (BPR)", "Documentation & Good Documentation Practices (GDP)", 
            "To detail secondary packaging checks, label reconciliation, and visual inspections review before release."),
        QaArticle(11, "SOP-QA-026", "SOP for Preparation and Maintenance of the Site Master File (SMF)", "Documentation & Good Documentation Practices (GDP)", 
            "To describe the annual revision, compiling site layouts, machinery lists, and quality policies for site inspections."),
        QaArticle(12, "SOP-QA-027", "SOP for Document Control and Archival of Electronic Spreadsheets", "Documentation & Good Documentation Practices (GDP)", 
            "To detail directory permissions, cell locking, formula validation, and backup policies for analytical calculations in Excel."),
        QaArticle(13, "SOP-QA-028", "SOP for Storage, Handing and Control of Master Formula Records (MFR)", "Documentation & Good Documentation Practices (GDP)", 
            "To define security levels, access authorizations, and modification records for the master active formulation templates."),
        QaArticle(14, "SOP-QA-029", "SOP for Control of Computerized Systems Audit Trail Reports", "Documentation & Good Documentation Practices (GDP)", 
            "To outline the frequency, checklist, and documentation of electronic audit trail review for analytical instruments."),
        QaArticle(15, "SOP-QA-030", "SOP for Issuance and Verification of Sterile Room Gown Logs", "Documentation & Good Documentation Practices (GDP)", 
            "To establish the record keeping for sterilizer cycles, clean garments stock tracking, and usage counts per shift."),
        QaArticle(16, "SOP-QA-031", "SOP for Logging and Maintenance of Calibration Master Certificates", "Documentation & Good Documentation Practices (GDP)", 
            "To describe standard indexing, verification of external certificates, and keeping traceability records of master standard weights."),
        QaArticle(17, "SOP-QA-032", "SOP for Distribution and Control of Material Safety Data Sheets (MSDS)", "Documentation & Good Documentation Practices (GDP)", 
            "To outline standard placement of hazard guidelines, updates frequency, and training logs for raw chemical sheets."),
        QaArticle(18, "SOP-QA-033", "SOP for Issuance and Monitoring of Equipment Status Labels", "Documentation & Good Documentation Practices (GDP)", 
            "To define color codes (Green-Calibrated/Cleaned, Red-Under Maintenance/Dirty) and authorization for label switches."),

        // 2. Quality Management Systems (QMS) (19-38)
        QaArticle(19, "SOP-QA-034", "SOP for Change Control Management System", "Quality Management Systems (QMS)", 
            "To lay down standard steps for logging, multi-department risk assessment, approvals, and post-implementation reviews of site changes."),
        QaArticle(20, "SOP-QA-035", "SOP for Handling and Investigation of Unplanned Deviations", "Quality Management Systems (QMS)", 
            "To define deviation reporting, classification (Minor, Major, Critical), Root Cause Analysis (RCA), and timeline compliance."),
        QaArticle(21, "SOP-QA-036", "SOP for Corrective and Preventive Actions (CAPA) Program", "Quality Management Systems (QMS)", 
            "To establish a systematic tracking, implementation, and biennial effectiveness verification process for CAPA files."),
        QaArticle(22, "SOP-QA-037", "SOP for Handling of Out of Specification (OOS) Results", "Quality Management Systems (QMS)", 
            "To outline Phase I laboratory checks, Phase II manufacturing investigations, and regulatory notifications of OOS cases."),
        QaArticle(23, "SOP-QA-038", "SOP for Handling of Out of Trend (OOT) Analytical Data", "Quality Management Systems (QMS)", 
            "To establish statistical triggers, evaluation charts, and corrective adjustments for OOT runs during stability tests."),
        QaArticle(24, "SOP-QA-039", "SOP for Management and Tracking of Product Complaints", "Quality Management Systems (QMS)", 
            "To describe patient/customer complaint logging, reserve samples analysis, batch review, and standard response deadlines."),
        QaArticle(25, "SOP-QA-040", "SOP for Product Recall Management and Crisis Control", "Quality Management Systems (QMS)", 
            "To define Class I, II, and III recall categories, communications plan, returned inventory quarantine, and reconciliation."),
        QaArticle(26, "SOP-QA-041", "SOP for Execution and Evaluation of Mock Recalls", "Quality Management Systems (QMS)", 
            "To detail the annual verification of recall efficacy, material traceability calculations, and timeline reporting within 24 hours."),
        QaArticle(27, "SOP-QA-042", "SOP for Quality Risk Management (QRM) using FMEA Methodology", "Quality Management Systems (QMS)", 
            "To outline Risk Priority Number (RPN) scoring, severity-likelihood matrices, and documented risk reduction actions."),
        QaArticle(28, "SOP-QA-043", "SOP for Annual Product Quality Review (APQR) Compilation", "Quality Management Systems (QMS)", 
            "To describe statistical trending, process capability index (Cpk) calculation, and summary reporting of product history."),
        QaArticle(29, "SOP-QA-044", "SOP for Organization and Review of Quality Management Review (QMR) Meetings", "Quality Management Systems (QMS)", 
            "To detail meeting schedules, agendas, compiling KPI metrics, action items assignments, and management sign-offs."),
        QaArticle(30, "SOP-QA-045", "SOP for Handling and Disposal of Returned Pharmaceutical Goods", "Quality Management Systems (QMS)", 
            "To outline warehouse reception, evaluation of returned packages, physical quarantine, and destruction of expired stocks."),
        QaArticle(31, "SOP-QA-046", "SOP for Periodic Review of Quality Agreements with Service Providers", "Quality Management Systems (QMS)", 
            "To outline scope of quality oversight, technical obligations, and dispute resolution for contract testing/manufacturing."),
        QaArticle(32, "SOP-QA-047", "SOP for Risk-Based Classification of site GMP Systems and Equipments", "Quality Management Systems (QMS)", 
            "To establish a standard logic for defining Direct Impact, Indirect Impact, and No Impact systems to focus validations."),
        QaArticle(33, "SOP-QA-048", "SOP for Tracking and Verification of CAPA Effectiveness Checks", "Quality Management Systems (QMS)", 
            "To establish periodic audits after CAPA closure to verify that root causes remain eliminated and no new failures occur."),
        QaArticle(34, "SOP-QA-049", "SOP for Root Cause Analysis (RCA) using Fishbone and 5-Whys Methods", "Quality Management Systems (QMS)", 
            "To define standard guidelines for facilitating multi-department brain-storming sessions for root cause tracking."),
        QaArticle(35, "SOP-QA-050", "SOP for Quarantine Management of Discrepant Materials and Products", "Quality Management Systems (QMS)", 
            "To detail physical separation, locked cage rules, custom quarantine tape markings, and computer access blocks."),
        QaArticle(36, "SOP-QA-051", "SOP for Incident Reporting and Non-Conformance Tracking", "Quality Management Systems (QMS)", 
            "To outline immediate logging of equipment breakdown, utilities deviations, or environmental alerts not affecting batch runs."),
        QaArticle(37, "SOP-QA-052", "SOP for Handling of Out of Calibration (OOC) Incidents of site Instruments", "Quality Management Systems (QMS)", 
            "To establish procedure for evaluating product impact when a critical testing scale is found out of tolerance."),
        QaArticle(38, "SOP-QA-053", "SOP for Quality Review of Engineering Maintenance Logbooks", "Quality Management Systems (QMS)", 
            "To outline periodic checks of preventive maintenance schedules, lube replacement logs, and gaskets change registries."),

        // 3. Validation & Qualification (V&Q) (39-56)
        QaArticle(39, "SOP-QA-054", "SOP for Preparation of the Validation Master Plan (VMP)", "Validation & Qualification (V&Q)", 
            "To establish standard guidelines for writing, approving, and annually updating the site Validation Master Plan (VMP)."),
        QaArticle(40, "SOP-QA-055", "SOP for Equipment Qualification Lifecycle (IQ, OQ, PQ)", "Validation & Qualification (V&Q)", 
            "To outline standard steps for generating Installation, Operational, and Performance Qualification protocols and reports."),
        QaArticle(41, "SOP-QA-056", "SOP for Cleaning Validation Master Program", "Validation & Qualification (V&Q)", 
            "To establish worst-case product selection matrix, MACO calculation, swab-rinse sampling methods, and analytical recoveries."),
        QaArticle(42, "SOP-QA-057", "SOP for Process Validation of Solid Oral Dosage Forms", "Validation & Qualification (V&Q)", 
            "To detail traditional 3-batch validation runs, sampling locations, blend uniformity checks, and tablet properties monitoring."),
        QaArticle(43, "SOP-QA-058", "SOP for Computer System Validation (CSV) following GAMP-5 Guidelines", "Validation & Qualification (V&Q)", 
            "To outline software categorization, risk assessments, user requirement specifications (URS), and lifecycle testing."),
        QaArticle(44, "SOP-QA-059", "SOP for Environmental Monitoring in Sterile Manufacturing Areas", "Validation & Qualification (V&Q)", 
            "To define active air sampler setup, settling plates location, glove count swabs, and alert-action microbial limits."),
        QaArticle(45, "SOP-QA-060", "SOP for Media Fill and Aseptic Process Simulation Validation", "Validation & Qualification (V&Q)", 
            "To establish simulation parameters, nutrient media specifications, shift duration, incubation checks, and acceptance limits."),
        QaArticle(46, "SOP-QA-061", "SOP for Clean Utility Validation (Purified Water & WFI)", "Validation & Qualification (V&Q)", 
            "To outline Phase I daily sampling, Phase II trend checks, and Phase III long-term monitoring for site water loops."),
        QaArticle(47, "SOP-QA-062", "SOP for HVAC System Qualification and Requalification", "Validation & Qualification (V&Q)", 
            "To establish testing protocols for air velocity, differential pressures, HEPA integrity, and cleanroom recovery tests."),
        QaArticle(48, "SOP-QA-063", "SOP for Technical Transfer of Products from R&D to Commercial Site", "Validation & Qualification (V&Q)", 
            "To detail formulation specs transfer, equipment gap analysis, trial batch protocols, and commercial validation."),
        QaArticle(49, "SOP-QA-064", "SOP for Annual Retrospective Validation Reviews", "Validation & Qualification (V&Q)", 
            "To outline the statistical verification of non-modified processes to confirm continuous validated state."),
        QaArticle(50, "SOP-QA-065", "SOP for Qualification of Swab and Rinse Sampling Methods", "Validation & Qualification (V&Q)", 
            "To describe recovery studies using various materials (Stainless steel, Glass, PTFE) for cleaning validations."),
        QaArticle(51, "SOP-QA-066", "SOP for Analytical Method Transfer Validation", "Validation & Qualification (V&Q)", 
            "To define comparative testing, co-validation, or transfer exemption criteria between sending and receiving laboratories."),
        QaArticle(52, "SOP-QA-067", "SOP for Validation of Analytical and Quality Spreadsheet Applications", "Validation & Qualification (V&Q)", 
            "To outline verification of formulas, cell locking security, and data output consistency for lab spreadsheets."),
        QaArticle(53, "SOP-QA-068", "SOP for Gown Laundering and Sterilization Process Validation", "Validation & Qualification (V&Q)", 
            "To detail microbial spore strip validation, autoclave cycle mapping, and particle counts checks of sterile garments."),
        QaArticle(54, "SOP-QA-069", "SOP for Validation of steam Sterilization (Autoclave) Cycles", "Validation & Qualification (V&Q)", 
            "To outline thermocouple placement, heat penetration testing, F0 value calculations, and biological indicator tests."),
        QaArticle(55, "SOP-QA-070", "SOP for Recovery Studies for Swab Analysis of Active APIs", "Validation & Qualification (V&Q)", 
            "To establish spike level calculations, material swab recoveries verification, and determination of correction factors."),
        QaArticle(56, "SOP-QA-071", "SOP for Validation of Active Gaseous Disinfection (VHP Sanitization)", "Validation & Qualification (V&Q)", 
            "To outline bio-indicator mapping, hydrogen peroxide distribution checks, and cleanroom gassing cycle qualification."),

        // 4. Equipment & Facilities Qualification (57-74)
        QaArticle(57, "SOP-QA-072", "SOP for Annual HEPA Filter Requalification (DOP/PAO Testing)", "Equipment & Facilities Qualification", 
            "To describe aerosol injection, scan patterns, leak detection threshold, and filter repair/replacement guidelines."),
        QaArticle(58, "SOP-QA-073", "SOP for Factory Acceptance Testing (FAT) of New GMP Machinery", "Equipment & Facilities Qualification", 
            "To outline verification of electrical layouts, component specifications, safety loops, and test runs at manufacturer site."),
        QaArticle(59, "SOP-QA-074", "SOP for Site Acceptance Testing (SAT) of New GMP Machinery", "Equipment & Facilities Qualification", 
            "To detail verification of site utility coupling, calibration checks, and test run verification after installation."),
        QaArticle(60, "SOP-QA-075", "SOP for User Requirement Specifications (URS) Preparation", "Equipment & Facilities Qualification", 
            "To establish standard steps for drafting physical, environmental, control system, and compliance requirements for purchase."),
        QaArticle(61, "SOP-QA-076", "SOP for Calibration of site Critical Sensors", "Equipment & Facilities Qualification", 
            "To define standard methods for calibrating temperature RTDs, relative humidity sensors, and digital pressure indicators."),
        QaArticle(62, "SOP-QA-077", "SOP for Calibration of Differential Pressure Gauges in Cleanrooms", "Equipment & Facilities Qualification", 
            "To outline zero-point checks, multi-point digital manometer calibration, and recording tolerance limits of cleanroom gauges."),
        QaArticle(63, "SOP-QA-078", "SOP for Verification of Weighing Balances and Scales", "Equipment & Facilities Qualification", 
            "To detail daily repeatability checks, eccentricity tests, and standard weights traceability in dispensing areas."),
        QaArticle(64, "SOP-QA-079", "SOP for Area Qualification and Requalification of Manufacturing Facilities", "Equipment & Facilities Qualification", 
            "To establish requalification criteria for finishes, air locks differential pressure, temperature mapping, and lux levels."),
        QaArticle(65, "SOP-QA-080", "SOP for Temperature Mapping Studies of Warehouse and Storage Rooms", "Equipment & Facilities Qualification", 
            "To outline seasonal dataloggers mapping, identifying hot/cold spots, and determining temperature controller locations."),
        QaArticle(66, "SOP-QA-081", "SOP for Calibration of Temperature and Humidity Dataloggers", "Equipment & Facilities Qualification", 
            "To detail mapping sensors calibration against NIST standards, recording drift, and logging calibration constants."),
        QaArticle(67, "SOP-QA-082", "SOP for Periodic Maintenance of Sterile Area Air Locks Seals", "Equipment & Facilities Qualification", 
            "To outline inspection of magnetic locks, visual seal checking, interlock delay calibration, and gasket replacement logs."),
        QaArticle(68, "SOP-QA-083", "SOP for Area Cleanliness and Pest Control Auditing", "Equipment & Facilities Qualification", 
            "To establish site audit of pest bait stations, insectocutors, physical barricades, and logging external pest audits."),
        QaArticle(69, "SOP-QA-084", "SOP for Validation of Clean-In-Place (CIP) Automatic Systems", "Equipment & Facilities Qualification", 
            "To detail spray ball mapping, chemical rinse monitoring, automatic sequence validation, and conductivity checks."),
        QaArticle(70, "SOP-QA-085", "SOP for Monitoring of Compressed Nitrogen Gas Quality", "Equipment & Facilities Qualification", 
            "To outline dew point checks, particulate counts, oil residue verification, and bioburden sampling of nitrogen loop."),
        QaArticle(71, "SOP-QA-086", "SOP for Calibration and Care of Master Standard Weights (Class E2/F1)", "Equipment & Facilities Qualification", 
            "To define storage inside felt-lined boxes, handling with bone-tipped tweezers, and external recalibration schedules."),
        QaArticle(72, "SOP-QA-087", "SOP for Periodic Inspection of Warehouse Racks and Safety Barriers", "Equipment & Facilities Qualification", 
            "To describe audit of rack alignment, physical dent checks, load capacity rating display, and protective bumper checks."),
        QaArticle(73, "SOP-QA-088", "SOP for Monitoring of Laboratory Clean Air Benches (Laminar Flow)", "Equipment & Facilities Qualification", 
            "To establish daily velocity check, HEPA integrity test, and particles mapping of QC micro laminar benches."),
        QaArticle(74, "SOP-QA-089", "SOP for Sanitization and Sterilization of Pure Steam Generators", "Equipment & Facilities Qualification", 
            "To describe clean steam condensate sampling, endotoxin testing, boiler blowdown control, and maintenance logs."),

        // 5. Materials & Supplier Management (75-90)
        QaArticle(75, "SOP-QA-090", "SOP for Vendor Qualification and Supplier Quality Audit", "Materials & Supplier Management", 
            "To define standard guidelines for sending questionnaires, executing site audits, reviewing CAPAs, and AVL updates."),
        QaArticle(76, "SOP-QA-091", "SOP for Sampling of Raw Materials, excipients and Active APIs", "Materials & Supplier Management", 
            "To establish a standard layout for dispensing samplers, sanitizing sample bottles, and using 100% identification rule."),
        QaArticle(77, "SOP-QA-092", "SOP for Material Reception, Logging and Quarantine in Warehouse", "Materials & Supplier Management", 
            "To describe physically matching bills of lading, integrity checking, assigning lot numbers, and quarantine label placement."),
        QaArticle(78, "SOP-QA-093", "SOP for Material Dispensing and Weighing Control in Compounding Areas", "Materials & Supplier Management", 
            "To establish double-operator verification of weights, container clean-down, dust suction, and strict logging."),
        QaArticle(79, "SOP-QA-094", "SOP for Supplier Quality Performance Metrics and AVL Reviews", "Materials & Supplier Management", 
            "To detail the annual compiling of material deviations, OOS history, delivery consistency, and AVL updates."),
        QaArticle(80, "SOP-QA-095", "SOP for Handling of Spurious and Suspicious Raw Materials", "Materials & Supplier Management", 
            "To define quarantine guidelines, regulatory notification pathways, and security containment of suspected fakes."),
        QaArticle(81, "SOP-QA-096", "SOP for Auditing of Third-Party Testing and Contract Labs", "Materials & Supplier Management", 
            "To detail verification of data integrity, equipment calibration, standards traceability, and analyst logs at external sites."),
        QaArticle(82, "SOP-QA-097", "SOP for Storage and Control of Printed Packaging Materials", "Materials & Supplier Management", 
            "To outline access restriction to foil/carton cabinets, counting checks, double-gated lock boxes, and preventing mix-ups."),
        QaArticle(83, "SOP-QA-098", "SOP for Material Expiry and Re-testing Schedules", "Materials & Supplier Management", 
            "To outline automated re-test alerts in ERP system, sampling active stocks, and re-labeling shelf-life."),
        QaArticle(84, "SOP-QA-099", "SOP for Warehouse Material Transfer and Air Locks Sanitization", "Materials & Supplier Management", 
            "To detail physical wipe-down of material drums, removing outer wraps, and sanitizing pass box surfaces."),
        QaArticle(85, "SOP-QA-100", "SOP for Disposal and Incineration of Rejected active Materials", "Materials & Supplier Management", 
            "To define environmental controls, weighing rejected containers, joint warehouse-QA authorization, and waste manifest."),
        QaArticle(86, "SOP-QA-101", "SOP for Label Reconciliation and Waste Counting of Packaging Materials", "Materials & Supplier Management", 
            "To outline verification of labels issued, labels used, damaged labels, and double-operator shredding logs."),
        QaArticle(87, "SOP-QA-102", "SOP for Sampling and Testing of Primary Packaging Materials", "Materials & Supplier Management", 
            "To establish dimensional check, pinhole testing of foil, material composition spectra, and microbial clean-checks."),
        QaArticle(88, "SOP-QA-103", "SOP for Sampling of Intermediates and In-Process Granulations", "Materials & Supplier Management", 
            "To detail blend sample thief handling, compositing rules, and quick-transit to QC lab to prevent moisture gain."),
        QaArticle(89, "SOP-QA-104", "SOP for Cold Chain Management and Temperature Sensitive Shipments", "Materials & Supplier Management", 
            "To outline gel pack packing layout, using single-use temperature USB dataloggers, and checking arrivals temperature."),
        QaArticle(90, "SOP-QA-105", "SOP for Quarantine and Release of Finished Product Pallets", "Materials & Supplier Management", 
            "To outline ERP stock status lock, physical green tape labeling, and double signature release file."),

        // 6. Operations & Line Clearance (91-105)
        QaArticle(91, "SOP-QA-106", "SOP for Line Clearance in Manufacturing and Packaging Divisions", "Operations & Line Clearance", 
            "To define multi-department cleaning, removal of past products labels, visual audit, and line clearance certificate issuance."),
        QaArticle(92, "SOP-QA-107", "SOP for Control of cross Contamination in Multi-Product Plant Sites", "Operations & Line Clearance", 
            "To outline HVAC pressure cascades, closed transfer systems, dedusting units, and specific campaigning protocols."),
        QaArticle(93, "SOP-QA-108", "SOP for Barcode and Pharmacode Reader Verification on packaging Lines", "Operations & Line Clearance", 
            "To establish challenge testing of line sensors using deliberate mismatched barcodes before starting secondary runs."),
        QaArticle(94, "SOP-QA-109", "SOP for Prevention of mix-Ups during Secondary Packaging of Multiple Strengths", "Operations & Line Clearance", 
            "To outline physical segregations, distinct colored labels, and strict line separation of duplicate active products."),
        QaArticle(95, "SOP-QA-110", "SOP for Material Transfer between Sterile and Non-Sterile plant Divisions", "Operations & Line Clearance", 
            "To establish surface chemical gassing, sanitizing outer wraps, and pass box interlocking operation."),
        QaArticle(96, "SOP-QA-111", "SOP for Reprocessing and Reworking of Defective Batches", "Operations & Line Clearance", 
            "To outline the strict Quality Risk Assessment, protocol creation, regulatory variations, and extensive double-operator audits."),
        QaArticle(97, "SOP-QA-112", "SOP for Control of Intermediates and In-process Material Hold Times", "Operations & Line Clearance", 
            "To define maximum bulk storage durations in stainless steel drums, temperature logs, and requalification testing."),
        QaArticle(98, "SOP-QA-113", "SOP for Sanitization and Chemical Flushing of Purified Water loop", "Operations & Line Clearance", 
            "To outline ozone exposure, hot water sanitation, chemical residue testing, and logging loop sanitation cycles."),
        QaArticle(99, "SOP-QA-114", "SOP for Verification of Metal Detector Units on Solid Oral Dosage Lines", "Operations & Line Clearance", 
            "To establish hourly verification using certified test spheres (Ferrous, Non-Ferrous, Stainless Steel) inside tablet lines."),
        QaArticle(100, "SOP-QA-115", "SOP for Cleaning of Fluid Bed Dryer (FBD) and Filter Bags Management", "Operations & Line Clearance", 
            "To outline filter bag washing, visual inspection for tear, dedicating bags to specific campaigns, and clean-tagging."),
        QaArticle(101, "SOP-QA-116", "SOP for Area Sanitization and Disinfectant Solution Rotation", "Operations & Line Clearance", 
            "To detail phenolic and quaternary ammonium disinfectant dilution, weekly rotation, and logging clean cycles."),
        QaArticle(102, "SOP-QA-117", "SOP for Cleaning and Sanitization of HVAC Ducts and Plenums", "Operations & Line Clearance", 
            "To establish clean air plenum vacuuming, wipe down, filter replacement logs, and post-clean air microbial checks."),
        QaArticle(103, "SOP-QA-118", "SOP for Verification of Leak Testing of Sterile Liquid Vials", "Operations & Line Clearance", 
            "To outline standard dye intrusion checks, vacuum pressure hold, and visual checks of rejected vials."),
        QaArticle(104, "SOP-QA-119", "SOP for visual Inspection of Parenteral Products by Operators", "Operations & Line Clearance", 
            "To detail visual mapping under light/dark background, operator eye fatigue rest schedules, and reject classification."),
        QaArticle(105, "SOP-QA-120", "SOP for Cleaning and Care of Tableting tooling (Punch and Die Sets)", "Operations & Line Clearance", 
            "To establish standard steps for tool ultrasonic cleaning, visual inspections, measuring wear, and oiling before cabinet storage."),

        // 7. Regulatory Compliance & Audits (106-115)
        QaArticle(106, "SOP-QA-121", "SOP for Self-Inspection and Internal quality GMP Audits", "Regulatory Compliance & Audits", 
            "To establish a standardized internal audit team, audit notifications, checklists, and CAPA follow-up timelines."),
        QaArticle(107, "SOP-QA-122", "SOP for Hosting External Regulatory Inspections (FDA, WHO, EMA)", "Regulatory Compliance & Audits", 
            "To outline front-room hosting, back-room document logistics, scribe logging, and immediate response to auditor requests."),
        QaArticle(108, "SOP-QA-123", "SOP for Risk Assessment of Nitrosamine Impurities in Drug Products", "Regulatory Compliance & Audits", 
            "To outline the chemical risk mapping, supplier questionnaires, and testing triggers for potential nitrosamine risks."),
        QaArticle(109, "SOP-QA-124", "SOP for Regulatory Notifications of Quality Failures and Recalls", "Regulatory Compliance & Audits", 
            "To define mandatory reporting deadlines, standard email formats, and liaison steps with local FDA offices."),
        QaArticle(110, "SOP-QA-125", "SOP for Periodic Review of Validated Computerized Systems", "Regulatory Compliance & Audits", 
            "To outline annual audit trail checking, user accounts review, and verification of backup-restore GXP systems."),
        QaArticle(111, "SOP-QA-126", "SOP for Hosting Client Audits and Quality Agreements Reviews", "Regulatory Compliance & Audits", 
            "To establish standard audit paths, sharing non-disclosure reports, review of deviations, and logging client findings."),
        QaArticle(112, "SOP-QA-127", "SOP for Management of Regulatory Variations and Filing Changes", "Regulatory Compliance & Audits", 
            "To detail linking change controls to regulatory submissions, pre-approval requirements, and post-approval tracking."),
        QaArticle(113, "SOP-QA-128", "SOP for Quality Audit of Site Environmental Management Systems (EMS)", "Regulatory Compliance & Audits", 
            "To outline emissions auditing, waste water analysis records, and verifying particulate scrubber logs."),
        QaArticle(114, "SOP-QA-129", "SOP for Site Quality Performance KPI Reporting", "Regulatory Compliance & Audits", 
            "To establish monthly dashboard compiling: deviations overdue, CAPA closure rate, and right-first-time index."),
        QaArticle(115, "SOP-QA-130", "SOP for Periodic Monitoring of Pharmacovigilance and Safety Alerts", "Regulatory Compliance & Audits", 
            "To outline review of international safety alerts, compiling post-marketing safety data, and filing updates."),

        // 8. Training & Personnel Hygiene (116-125)
        QaArticle(116, "SOP-QA-131", "SOP for GMP Training Program and Employee Qualification", "Training & Personnel Hygiene", 
            "To outline standard annual GMP curriculum, training evaluation quizzes, and keeping individual training folders."),
        QaArticle(117, "SOP-QA-132", "SOP for Personnel Hygiene, Health Monitoring and Medical Check-ups", "Training & Personnel Hygiene", 
            "To define annual physical exams, reporting infectious illness, and hand wash validation audits."),
        QaArticle(118, "SOP-QA-133", "SOP for Entry and Exit Procedure for Sterile Cleanrooms", "Training & Personnel Hygiene", 
            "To establish a step-by-step sterile gowning procedure, mirror-checks, sterile hand spray, and glove changes."),
        QaArticle(119, "SOP-QA-134", "SOP for Cleanroom Garment Qualification and Lifecycle Tracking", "Training & Personnel Hygiene", 
            "To outline fabric particle checking, maximum wash counts verification, autoclave tracking, and visual wear audits."),
        QaArticle(120, "SOP-QA-135", "SOP for Visual Inspection Qualification for QC and Production Operators", "Training & Personnel Hygiene", 
            "To establish challenge kit validation (seeded defect vials), passing limits, and annual re-qualification of inspectors."),
        QaArticle(121, "SOP-QA-136", "SOP for Hand Sanitization and Glove Touch Plates Validation", "Training & Personnel Hygiene", 
            "To outline the microbiologist swabs of operator gloves, plate incubation, and recording colony counts after gowning."),
        QaArticle(122, "SOP-QA-137", "SOP for Visitor Entry Policies inside site GMP Areas", "Training & Personnel Hygiene", 
            "To establish escort procedures, visitor health declaration forms, and issuing temporary visitor gowns and caps."),
        QaArticle(123, "SOP-QA-138", "SOP for Control of Lab Gowns Laundering and Sterilization", "Training & Personnel Hygiene", 
            "To outline standard washing cycles, using neutral detergents, autoclave folding, and sterilizing records."),
        QaArticle(124, "SOP-QA-139", "SOP for Qualification of GMP Trainers and Course Materials", "Training & Personnel Hygiene", 
            "To define evaluation of internal trainers, approving slides/presentations, and recording external trainer certifications."),
        QaArticle(125, "SOP-QA-140", "SOP for Monitoring and Restricting Jewelry and Makeup inside GMP plant", "Training & Personnel Hygiene", 
            "To establish standard checks at shift-change locker rooms, visual inspections, and logging personnel exceptions.")
    );

    fun getArticleBody(article: QaArticle): String {
        return """
            PHARMACEUTICAL GUIDELINES & COMPLIANCE PORTAL
            REFERENCE CODE: ${article.code} | DEPARTMENT: QUALITY ASSURANCE
            TECHNICAL DIVISION: ${article.category}
            STANDARD REFERENCE MANUAL (cGMP & 21 CFR Part 211 COMPLIANT)
            
            1.0 OBJECTIVE
            ${article.objective}
            
            2.0 SCOPE
            This guidelines manual is applicable to all quality systems, standard operations, validations, qualification processes, documentation controls, audits, and compliance evaluations executed on the pharmaceutical site under Quality Assurance oversight. All site managers, supervisors, operators, and analysts must strictly adhere to these criteria to ensure absolute compliance with current Good Manufacturing Practices (cGMP) and global regulatory expectations (FDA, WHO, and ICH guidelines).
            
            3.0 MATERIAL & EQUIPMENTS REQUIRED
            - Certified controlled master copies, stamp ink (controlled copy, historical, master).
            - GXP-compliant document vaults, locked storage boxes, cross-cut shredders.
            - Personal Protective Equipment (PPE) including sterile cleanroom garments, gloves, hair nets, safety shoes, and visors.
            - Calibrated monitoring tools (thermo-hygrometers, digital manometers, aerosol photometers).
            - GXP analytical software, validated document management systems, secure backup drives.
            
            4.0 STEP-BY-STEP TECHNICAL PROCEDURE
            4.1 PRE-EXECUTION STEPS:
            - Prior to initiating any quality system workflow (logging changes, deviations, or qualifications), verify that the appropriate GXP log or digital application is logged under your unique, secure user ID with audit trail active.
            - Ensure all reference materials, master templates, and regulatory filings are in their latest approved version. Check the effective master list of documents.
            - When preparing for sterile entry or visual inspections, verify that you carry active training and qualification certifications and have signed the health clearance sheet.
            
            4.2 CORE COMPLIANCE METHODOLOGY:
            - Execute the steps precisely as described in this standard operating procedure. All records, whether paper or electronic, must be completed concurrently at the time of activity execution following GDP (ALCOA+) principles.
            - For document controls, ensure that controlled templates are printed only on watermarked GXP paper and stamped in green ink. Unauthorized photocopies are strictly prohibited and constitute a major non-conformance.
            - For validations, qualifications, and line clearances, complete each checklist step-by-step. If any target parameter or limit is not met, do not proceed; stop the line, stabilize the system, and report a deviation to QA within 24 hours.
            - For QMS processes (deviations, OOS, CAPAs), form cross-functional teams, document comprehensive root-cause analysis (Ishikawa/5-Whys), and draft concrete corrective action plans before submitting to QA Head for closure.
            
            4.3 DATA INTEGRITY AND COMPLIANCE RULES:
            - All weights, balances printouts, and digital files must be co-signed by a double operator check. Raw files must be directly archived in secure, restricted-access network directories.
            - Backdating, pre-dating, writing over entries, or using white-out correction fluid on any GMP paper records is a critical compliance breach. Correct errors with a single clean strike-through, initials, date, and reason.
            - Never delete, overwrite, or archive any raw analytical or system data without QA oversight and formal change control records.
            
            5.0 SAFETY & ENVIRONMENTAL PRECAUTIONS
            - Always handle heavy GXP paper document boxes using proper ergonomic lifting practices.
            - Wear appropriate gowns, sterile gloves, and respiratory masks when executing line clearances or sampling raw active ingredients in dispensing cubicles.
            - Ensure all shredded GXP paper waste and obsolete printed materials are collected in locked secure disposal bins and weighed before final incineration.
            
            6.0 QUALITY AUDIT FREQUENCY
            This compliance guideline and standard procedure must be reviewed and re-verified on a biennial basis (every 2 years), or immediately upon any technical change control proposal, facility upgrades, or major regulatory audits.
            
            EFFECTIVE DATE: 2026-06-28
            AUTHOR: Lead QA Compliance Officer
            REVIEWER: QA Systems Manager
            APPROVER: Head of Quality Assurance
        """.trimIndent()
    }
}
