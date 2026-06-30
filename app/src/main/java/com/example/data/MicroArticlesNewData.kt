package com.example.data

data class MicroArticle(
    val id: Int,
    val code: String,
    val title: String,
    val category: String,
    val objective: String
)

object MicroArticlesNewData {
    val categories = listOf(
        "Media Preparation & Growth Promotion (GPT)",
        "Sterility Testing & Aseptic Processing",
        "Bacterial Endotoxin Testing (BET) & LAL",
        "Environmental Monitoring (EM) & Particulate Audits",
        "Microbial Limit Testing (MLT) & Pathogen Testing",
        "Water System Testing & Bioburden",
        "Equipment Qualification & Operation (Autoclave, Incubator, Hood)",
        "Culture Maintenance & Biological Indicators",
        "Disinfection & Cleanroom Hygiene",
        "General Microbiology SOPs & Good Lab Practices"
    )

    val articles = listOf(
        // 1. Media Preparation & Growth Promotion (GPT) (11-20)
        MicroArticle(11, "SOP-MIC-011", "Preparation and Sterilization of Soybean Casein Digest Agar (SCDA)", "Media Preparation & Growth Promotion (GPT)", 
            "To define standard parameters for compounding, heating, and autoclave sterilization of Soybean Casein Digest Agar for aerobic plate counts."),
        MicroArticle(12, "SOP-MIC-012", "Preparation and Sterilization of Fluid Thioglycollate Medium (FTM)", "Media Preparation & Growth Promotion (GPT)", 
            "To outline compounding steps, heating rules to avoid resazurin oxidation, and sterilization of FTM for anaerobic sterility tests."),
        MicroArticle(13, "SOP-MIC-013", "Standard Procedure for Growth Promotion Testing of Anaerobic Media", "Media Preparation & Growth Promotion (GPT)", 
            "To establish the inoculation, incubation, and growth recovery validation criteria for anaerobic bacterial strains on media plates."),
        MicroArticle(14, "SOP-MIC-014", "Management of Dehydrated Culture Media Inventory and Shelf Life", "Media Preparation & Growth Promotion (GPT)", 
            "To describe storage temperature requirements, humidity controls, and re-test schedules for dehydrated media powders in the warehouse."),
        MicroArticle(15, "SOP-MIC-015", "SOP for Melting and Tempering of Agar Media", "Media Preparation & Growth Promotion (GPT)", 
            "To define heating parameters in water baths, temperature limits of 45-50°C, and maximum hold-times to prevent heat degradation of agar."),
        MicroArticle(16, "SOP-MIC-016", "SOP for Physical Parameters Check of Prepared Media Plates", "Media Preparation & Growth Promotion (GPT)", 
            "To outline visual checking protocols for bubbles, thickness, pH measurement, cracking, and dehydration indicators in agar plates."),
        MicroArticle(17, "SOP-MIC-017", "SOP for Sterility Check of Prepared Media Batches", "Media Preparation & Growth Promotion (GPT)", 
            "To establish incubation conditions (30-35°C and 20-25°C) of a 2% sample of each prepared media batch to verify absolute sterility."),
        MicroArticle(18, "SOP-MIC-018", "Preparation and Control of Diluents and Buffers in Microlab", "Media Preparation & Growth Promotion (GPT)", 
            "To detail compounding of peptone water, saline solutions, and phosphate buffers, including autoclave validation parameters."),
        MicroArticle(19, "SOP-MIC-019", "SOP for Disposal of Unused, Expired Prepared Culture Media", "Media Preparation & Growth Promotion (GPT)", 
            "To define autoclave decontamination cycles, solid waste segregation, and recording weight metrics of discarded media batches."),
        MicroArticle(20, "SOP-MIC-020", "Growth Promotion Testing of Liquid Enrichment Media", "Media Preparation & Growth Promotion (GPT)", 
            "To outline the inoculation with <100 CFU of reference organisms, and visual turbidity verification of liquid enrichment broths."),

        // 2. Sterility Testing & Aseptic Processing (21-32)
        MicroArticle(21, "SOP-MIC-021", "Membrane Filtration Method for Sterility Testing of Water-Soluble Powders", "Sterility Testing & Aseptic Processing", 
            "To establish steps for reconstituting sterile raw powders and performing membrane filtration testing in an aseptic isolator."),
        MicroArticle(22, "SOP-MIC-022", "Direct Inoculation Method for Sterility Testing of Non-Filterable Products", "Sterility Testing & Aseptic Processing", 
            "To define rules for direct addition of ointments, oils, or device components into Fluid Thioglycollate and Soybean Casein media."),
        MicroArticle(23, "SOP-MIC-023", "Validation of Sterility Testing Method for Antibiotic Preparations", "Sterility Testing & Aseptic Processing", 
            "To outline neutralizer validation, dilution protocols, and filtration rinsing volumes to completely clear antibiotic residues."),
        MicroArticle(24, "SOP-MIC-024", "Handling of Turbid or Suspicious Sterility Test Canisters", "Sterility Testing & Aseptic Processing", 
            "To establish isolation protocols, sub-culturing steps, gram staining, and microscopic examination of turbid sterility samples."),
        MicroArticle(25, "SOP-MIC-025", "Cleaning and Sanitization of Sterility Testing Cleanroom Suite", "Sterility Testing & Aseptic Processing", 
            "To detail sporicidal mopping, walls cleaning, HEPA terminal wipes, and daily particulate validation of sterility testing rooms."),
        MicroArticle(26, "SOP-MIC-026", "SOP for Sterility Testing of Surgical Dressings and Sutures", "Sterility Testing & Aseptic Processing", 
            "To describe aseptic dissection, handling sutures with sterile forceps, and direct immersion in sterile culture medium tubes."),
        MicroArticle(27, "SOP-MIC-027", "Investigation of Sterility Test Failures (Aseptic Lab Out of Specification)", "Sterility Testing & Aseptic Processing", 
            "To outline Phase I laboratory audits, environmental reviews, operator logs checks, and strain-match DNA analysis of contaminants."),
        MicroArticle(28, "SOP-MIC-028", "Entry and Exit Procedure for Sterility Testing Isolators", "Sterility Testing & Aseptic Processing", 
            "To define hand scrubbing, donning sterile sleeves, sleeve checking, and maintaining dynamic air pressure cascades inside isolators."),
        MicroArticle(29, "SOP-MIC-029", "Leak Testing and Validation of Sterility Testing Isolator Gloves", "Sterility Testing & Aseptic Processing", 
            "To outline daily pressure decay testing of isolator gloves, sleeve visual integrity audits, and recording leak parameters."),
        MicroArticle(30, "SOP-MIC-030", "Bio-Decontamination Cycle Validation of Sterility Test Isolators using VHP", "Sterility Testing & Aseptic Processing", 
            "To detail gassing parameters, spore strip placement, aeration validation, and checking hydrogen peroxide residue limits."),
        MicroArticle(31, "SOP-MIC-031", "Rapid Sterility Testing Methods and Validation Guidelines", "Sterility Testing & Aseptic Processing", 
            "To outline qualification of automated growth detection systems, laser spectroscopy, and comparative validation with traditional runs."),
        MicroArticle(32, "SOP-MIC-032", "Sampling and Sterility Testing of Sterile Raw APIs", "Sterility Testing & Aseptic Processing", 
            "To establish sterile sampling thief rules, nitrogen blanketed bottles, and transfer of bulk raw sterile powders to the testing suite."),

        // 3. Bacterial Endotoxin Testing (BET) & LAL (33-44)
        MicroArticle(33, "SOP-MIC-033", "Standard Turbidimetric Kinetic Method for Bacterial Endotoxin Test", "Bacterial Endotoxin Testing (BET) & LAL", 
            "To detail turbidimetric kinetic calculations, software setup, optical density readings, and sample preparation for LAL testing."),
        MicroArticle(34, "SOP-MIC-034", "Chromogenic Kinetic Method for Bacterial Endotoxin Quantification", "Bacterial Endotoxin Testing (BET) & LAL", 
            "To outline sample dilution, addition of chromogenic substrate, temperature control at 37°C, and calibration curve validation."),
        MicroArticle(35, "SOP-MIC-035", "Determination of LAL Lysate Sensitivity (Lambda Verification)", "Bacterial Endotoxin Testing (BET) & LAL", 
            "To establish the verification of amebocyte lysate label claims using four dilutions of reference endotoxin standard in quadruplicate."),
        MicroArticle(36, "SOP-MIC-036", "Preparation of Endotoxin Standard Curves for Kinetic Assays", "Bacterial Endotoxin Testing (BET) & LAL", 
            "To describe reconstitution of CSE, serial dilutions preparation from 10.0 EU/mL to 0.005 EU/mL, and regression line metrics validation."),
        MicroArticle(37, "SOP-MIC-037", "Enhancing and Inhibiting Factors (Interference) Testing for BET", "Bacterial Endotoxin Testing (BET) & LAL", 
            "To outline spike-recovery calculations, pH adjustment rules, and non-interfering sample dilution determinations."),
        MicroArticle(38, "SOP-MIC-038", "Depyrogenation of Glassware in Hot Air Oven for BET Use", "Bacterial Endotoxin Testing (BET) & LAL", 
            "To establish heating parameters (250°C for minimum 60 mins), validation using endotoxin challenge vials, and storage restrictions."),
        MicroArticle(39, "SOP-MIC-039", "Calculation of Endotoxin Limits and Maximum Valid Dilution (MVD)", "Bacterial Endotoxin Testing (BET) & LAL", 
            "To define mathematical formulas for MVD based on dose, potency, and amebocyte sensitivity to prevent false-negative runs."),
        MicroArticle(40, "SOP-MIC-040", "Cleaning and Maintenance of Pyros Kinetix Endotoxin Readers", "Bacterial Endotoxin Testing (BET) & LAL", 
            "To establish daily optic check, block sanitization with non-interfering alcohols, and software troubleshooting guidelines."),
        MicroArticle(41, "SOP-MIC-041", "Investigation of Out of Specification (OOS) Endotoxin Results", "Bacterial Endotoxin Testing (BET) & LAL", 
            "To outline double checking dilutions, verifying endotoxin-free water batches, reviewing depyrogenation charts, and re-testing guidelines."),
        MicroArticle(42, "SOP-MIC-042", "Reconstitution and Storage of Control Standard Endotoxin (CSE)", "Bacterial Endotoxin Testing (BET) & LAL", 
            "To describe precise vortexing times, storage at 2-8°C, and maximum hold times of reconstituted CSE stock solutions."),
        MicroArticle(43, "SOP-MIC-043", "SOP for Monitoring Endotoxin Levels in Purified Water and WFI Ports", "Bacterial Endotoxin Testing (BET) & LAL", 
            "To detail sampling methods, sample storage restrictions, and endotoxin thresholds (WFI limit: < 0.25 EU/mL) monitoring."),
        MicroArticle(44, "SOP-MIC-044", "Endotoxin Retention Validation of Sterilizing Grade Filters", "Bacterial Endotoxin Testing (BET) & LAL", 
            "To outline the challenging of hydrophobic membranes with high concentration endotoxin feed solutions and measuring filtrate recovery."),

        // 4. Environmental Monitoring (EM) & Particulate Audits (45-56)
        MicroArticle(45, "SOP-MIC-045", "Active Air Sampling using Impactor Samplers in Grade A Cleanrooms", "Environmental Monitoring (EM) & Particulate Audits", 
            "To establish parameters for active air volume calibration, sampler positioning, media plates insertion, and CFU calculation."),
        MicroArticle(46, "SOP-MIC-046", "Settle Plate (Passive Air) Monitoring in Manufacturing Core Areas", "Environmental Monitoring (EM) & Particulate Audits", 
            "To outline the placement of Soybean Casein media plates, exposure durations (max 4 hours), and dynamic monitoring of cleanrooms."),
        MicroArticle(47, "SOP-MIC-047", "Contact Plate (Surface) Sampling of Cleanroom Walls and Floors", "Environmental Monitoring (EM) & Particulate Audits", 
            "To define surface swabbing, contact plate pressure duration (5 seconds), lecithin/polysorbate addition for neutralizers, and clean-up."),
        MicroArticle(48, "SOP-MIC-048", "Personnel Hygiene Monitoring: Glove Print and Gown Swab Sampling", "Environmental Monitoring (EM) & Particulate Audits", 
            "To describe finger-dab impressions, sleeve swabbing, and recording colonies from sterile filling machine operators."),
        MicroArticle(49, "SOP-MIC-049", "Trending and Statistical Analysis of Environmental Monitoring Data", "Environmental Monitoring (EM) & Particulate Audits", 
            "To establish monthly statistical evaluations of cleanroom counts, calculating percentages of zero runs, and identifying OOT locations."),
        MicroArticle(50, "SOP-MIC-050", "Determination of Environmental Alert and Action Limits for Cleanrooms", "Environmental Monitoring (EM) & Particulate Audits", 
            "To outline standard calculations of 95th and 99th percentiles of historical EM data to establish site alert thresholds."),
        MicroArticle(51, "SOP-MIC-051", "Microscopic Characterization of Airborne Particulates in Cleanrooms", "Environmental Monitoring (EM) & Particulate Audits", 
            "To detail collection of fibers and dust, polarized light microscopy examination, and identification of particle sources."),
        MicroArticle(52, "SOP-MIC-052", "Air Velocity and Visual Airflow Pattern (Smoke Study) Verification", "Environmental Monitoring (EM) & Particulate Audits", 
            "To describe video recording of glycol fog sweeps, HEPA filter air velocity profiling, and laminar flow vectors checking."),
        MicroArticle(53, "SOP-MIC-053", "Non-Viable Particulate Monitoring using Airborne Particle Counters", "Environmental Monitoring (EM) & Particulate Audits", 
            "To establish laser particle counters sampling, volume parameters (28.3 LPM), and counting channels verification (0.5 and 5.0 micron)."),
        MicroArticle(54, "SOP-MIC-054", "Environmental Monitoring in Compressed Air and Nitrogen Lines", "Environmental Monitoring (EM) & Particulate Audits", 
            "To outline high-pressure diffuser connection, particulate sampling, and microbial bioburden testing of pure process gases."),
        MicroArticle(55, "SOP-MIC-055", "SOP for Handling of Cleanroom Environmental Monitoring Exceedances", "Environmental Monitoring (EM) & Particulate Audits", 
            "To define corrective sanitizations, tracking root causes, identifying wild microbial strains, and re-monitoring procedures."),
        MicroArticle(56, "SOP-MIC-056", "Validation of Swabbing Efficiency for Surface Microbial Recovery", "Environmental Monitoring (EM) & Particulate Audits", 
            "To establish surface spike recovery tests, swabbing angles verification, and calculating surface retrieval correction factors."),

        // 5. Microbial Limit Testing (MLT) & Pathogen Testing (57-68)
        MicroArticle(57, "SOP-MIC-057", "Membrane Filtration Method for Microbial Limit Testing of Liquid Dosages", "Microbial Limit Testing (MLT) & Pathogen Testing", 
            "To detail sample filtration of liquid syrups, rinsing buffers volume, placing membranes on selective agar, and colonies count."),
        MicroArticle(58, "SOP-MIC-058", "Plate Count Methods (Spread and Pour Plate) for Oral Solids MLT", "Microbial Limit Testing (MLT) & Pathogen Testing", 
            "To outline serial dilutions preparation, agar temperature control, mixing plate swirls, and plate reading of tablets and capsules."),
        MicroArticle(59, "SOP-MIC-059", "Screening and Identification of Escherichia coli in Oral Dosages", "Microbial Limit Testing (MLT) & Pathogen Testing", 
            "To detail pre-enrichment in MacConkey Broth, streaking on MacConkey Agar, and verification of brick-red colonies with indole tests."),
        MicroArticle(60, "SOP-MIC-060", "Detection and Isolation of Staphylococcus aureus in Topical Creams", "Microbial Limit Testing (MLT) & Pathogen Testing", 
            "To outline enrichment in Casein Digest Broth, streaking on Mannitol Salt Agar, and confirming golden colonies with coagulase tests."),
        MicroArticle(61, "SOP-MIC-061", "Identification and Differentiation of Pseudomonas aeruginosa in Purified Water", "Microbial Limit Testing (MLT) & Pathogen Testing", 
            "To establish filtration, inoculation on Cetrimide Agar, looking for blue-green pigmentation, and oxidase testing verify."),
        MicroArticle(62, "SOP-MIC-062", "Detection of Salmonella species in Plant-derived Raw Materials", "Microbial Limit Testing (MLT) & Pathogen Testing", 
            "To describe pre-enrichment, enrichment in Rappaport-Vassiliadis Broth, streaking on XLD Agar, and triple-sugar iron agar checks."),
        MicroArticle(63, "SOP-MIC-063", "Determination of Bile-Tolerant Gram-Negative Bacteria in Finished Products", "Microbial Limit Testing (MLT) & Pathogen Testing", 
            "To outline enrichment in Mossel Broth, streaking on Violet Red Bile Glucose Agar, and quantifying bacterial load limits."),
        MicroArticle(64, "SOP-MIC-064", "Detection and Isolation of Candida albicans in Mucosal Formulations", "Microbial Limit Testing (MLT) & Pathogen Testing", 
            "To establish enrichment in Sabouraud Dextrose Broth, streaking on Selective Chromogenic Agar, and germ tube testing confirms."),
        MicroArticle(65, "SOP-MIC-065", "Detection of Clostridium species in Dietary Supplements and Powders", "Microbial Limit Testing (MLT) & Pathogen Testing", 
            "To outline anaerobic heat shocking of samples, inoculation in Reinforced Clostridial Medium, and anaerobic plate checks."),
        MicroArticle(66, "SOP-MIC-066", "Method Suitability Validation for Microbial Limits Test of New Products", "Microbial Limit Testing (MLT) & Pathogen Testing", 
            "To establish spike recovery testing of new formulations to verify that product antimicrobial activity is fully neutralized."),
        MicroArticle(67, "SOP-MIC-067", "Use and Validation of API 20E Strips for Enterobacteriaceae Identification", "Microbial Limit Testing (MLT) & Pathogen Testing", 
            "To describe inoculating API microtubes, incubation rules, adding indicator reagents, and database search for species names."),
        MicroArticle(68, "SOP-MIC-068", "Gram Stain Controls and Quality Check of Staining Reagents", "Microbial Limit Testing (MLT) & Pathogen Testing", 
            "To define standard quality control of staining reagents using known S. aureus and E. coli slides prior to isolate tests."),

        // 6. Water System Testing & Bioburden (69-80)
        MicroArticle(69, "SOP-MIC-069", "Bioburden Testing of Purified Water via Membrane Filtration", "Water System Testing & Bioburden", 
            "To establish standard filtration of 100 mL purified water, plating on R2A agar, and colony counts reporting."),
        MicroArticle(70, "SOP-MIC-070", "Bioburden Testing of Water for Injection (WFI) via Large Volume Filtration", "Water System Testing & Bioburden", 
            "To outline high-volume filtration (100-200 mL), using low-nutrient media, and incubation at 20-25°C for slow growing microbes."),
        MicroArticle(71, "SOP-MIC-071", "Daily Water Sampling Schedule and Gown-down for Sampling Ports", "Water System Testing & Bioburden", 
            "To detail sampling route mapping, port flaming with propane torch, sanitization with 70% IPA, and secure sampling protocols."),
        MicroArticle(72, "SOP-MIC-072", "Alert and Action Limits for Water Bioburden and Endotoxins", "Water System Testing & Bioburden", 
            "To establish action guidelines when water counts exceed 100 CFU/mL (Purified) or 10 CFU/100 mL (WFI) standards."),
        MicroArticle(73, "SOP-MIC-073", "Sanitization and Bio-burden Evaluation of Pure Steam Condensate", "Water System Testing & Bioburden", 
            "To outline safe collection of hot steam condensates, cooling loops operation, filtration, and incubation guidelines."),
        MicroArticle(74, "SOP-MIC-074", "Identification of Oligotrophic Bacteria in High-Purity Water Systems", "Water System Testing & Bioburden", 
            "To describe morphological, gram stain, and automated metabolic profiling of water bacteria (e.g. Ralstonia pickettii)."),
        MicroArticle(75, "SOP-MIC-075", "Investigation of Microbes in Purified Water System Loop Alerts", "Water System Testing & Bioburden", 
            "To establish investigative steps including checking water UV lamp hours, checking carbon filters, and pipeline flush logs."),
        MicroArticle(76, "SOP-MIC-076", "Validation of Sampling Containers and Hold-Time for Water Bioburden", "Water System Testing & Bioburden", 
            "To outline studies verifying that sample bottle thiosulfate levels neutralize residual chlorine, and verifying 24h cold storage hold."),
        MicroArticle(77, "SOP-MIC-077", "Microscopic Examination of Biofilms in Purified Water Pipings", "Water System Testing & Bioburden", 
            "To detail swabbing inside water piping sections, staining with fluorescent dyes, and checking for bacterial biofilm clusters."),
        MicroArticle(78, "SOP-MIC-078", "Testing for Total Viable Count (TVC) in Raw Water Inputs", "Water System Testing & Bioburden", 
            "To establish serial dilutions testing, pour plate method on Plate Count Agar, and evaluating sand filtration efficiency."),
        MicroArticle(79, "SOP-MIC-079", "Calibration of Vacuum Manifolds Used in Water Testing", "Water System Testing & Bioburden", 
            "To outline checking vacuum gauge accuracy, cleaning stainless steel branch valves, and verifying sterile gasket seal holds."),
        MicroArticle(80, "SOP-MIC-080", "Operation and Maintenance of Reverse Osmosis (RO) Membrane Sanitizer", "Water System Testing & Bioburden", 
            "To establish chemical sanitizing cycles of RO membranes, checking peracetic acid residue limits, and logging bioburden reductions."),

        // 7. Equipment Qualification & Operation (Autoclave, Incubator, Hood) (81-92)
        MicroArticle(81, "SOP-MIC-081", "Operation, Cleaning, and Daily Checks of Laboratory Autoclaves", "Equipment Qualification & Operation (Autoclave, Incubator, Hood)", 
            "To describe standard autoclave settings, pressure valve checks, chamber cleaning, and recording cycle parameters."),
        MicroArticle(82, "SOP-MIC-082", "Heat Distribution and Penetration Studies (Temperature Mapping) of Autoclaves", "Equipment Qualification & Operation (Autoclave, Incubator, Hood)", 
            "To establish parameters for placing 12 thermal sensors inside autoclave chamber, calculating F0, and verifying cold spot locations."),
        MicroArticle(83, "SOP-MIC-083", "Calibration and Daily Temperature Profiling of Microlab Incubators", "Equipment Qualification & Operation (Autoclave, Incubator, Hood)", 
            "To outline morning/evening temperature tracking, alarm checks, sensor calibration, and continuous chart recorder verification."),
        MicroArticle(84, "SOP-MIC-084", "SOP for Operation and Validation of Biosafety Cabinets (Class II Type A2)", "Equipment Qualification & Operation (Autoclave, Incubator, Hood)", 
            "To detail sash height checks, air inflow velocity measurements, HEPA leak scans, and daily UV light tracking."),
        MicroArticle(85, "SOP-MIC-085", "Calibration of Microscopic Micrometers and Graticules", "Equipment Qualification & Operation (Autoclave, Incubator, Hood)", 
            "To describe stage micrometer alignment, eyepiece graticule calibration, and measuring yeast or spore sizes."),
        MicroArticle(86, "SOP-MIC-086", "Operation, Maintenance, and Calibration of automated Colony Counters", "Equipment Qualification & Operation (Autoclave, Incubator, Hood)", 
            "To outline counting sensitivity settings, grid selection rules, checking dark-field lighting, and verifying standard calibration disks."),
        MicroArticle(87, "SOP-MIC-087", "Temperature Mapping of Laboratory Fridges and Culture Freezers", "Equipment Qualification & Operation (Autoclave, Incubator, Hood)", 
            "To detail placing digital dataloggers in door, center, and back racks, mapping for 72 hours, and logging door-opening drift."),
        MicroArticle(88, "SOP-MIC-088", "Operation and Calibration of Analytical Balances in Microlab", "Equipment Qualification & Operation (Autoclave, Incubator, Hood)", 
            "To establish daily balance checks using calibrated standard weights (10g and 100g), recording drift, and leveling checks."),
        MicroArticle(89, "SOP-MIC-089", "Calibration and Preventive Maintenance of Micropipettes", "Equipment Qualification & Operation (Autoclave, Incubator, Hood)", 
            "To outline gravimetric calibration of pipettes at 100% and 10% volumes, using deaerated water, and calculation of error margins."),
        MicroArticle(90, "SOP-MIC-090", "Operation and Calibration of pH Meters inside Media Prep Room", "Equipment Qualification & Operation (Autoclave, Incubator, Hood)", 
            "To establish standard three-point calibration using pH 4.01, 7.00, and 10.01 buffers, and checking slope sensitivity percentage."),
        MicroArticle(91, "SOP-MIC-091", "Qualification of Vortex Mixers and Shakers for Dilution Preparation", "Equipment Qualification & Operation (Autoclave, Incubator, Hood)", 
            "To outline periodic RPM checks, rubber head inspections, speed settings validation, and cleaning protocols."),
        MicroArticle(92, "SOP-MIC-092", "Decontamination and Sterilization of Bio-Hazardous Laboratory Waste", "Equipment Qualification & Operation (Autoclave, Incubator, Hood)", 
            "To define waste segregation, placing plates in biohazard bags, running autoclave discard cycles (121°C for 30 mins), and records logging."),

        // 8. Culture Maintenance & Biological Indicators (93-102)
        MicroArticle(93, "SOP-MIC-093", "Retrieval and Reconstitution of ATCC Lyophilized Reference Cultures", "Culture Maintenance & Biological Indicators", 
            "To establish aseptic reconstitution of freeze-dried culture pellets, first enrichment broth transfers, and purity verification."),
        MicroArticle(94, "SOP-MIC-094", "Preparation and Preservation of Working Cultures (Sub-culturing Limits)", "Culture Maintenance & Biological Indicators", 
            "To outline seed-lot system rules, restricting working culture transfers to 5 passages from original master culture, and storage."),
        MicroArticle(95, "SOP-MIC-095", "Cryopreservation of Reference Strains in Liquid Nitrogen or Deep Freezers", "Culture Maintenance & Biological Indicators", 
            "To detail formulation of cryoprotectant bead solutions (glycerol), freezing vials at -80°C, and logging inventory registers."),
        MicroArticle(96, "SOP-MIC-096", "Purity and Phenotypic Verification of Reference Culture Strains", "Culture Maintenance & Biological Indicators", 
            "To outline biochemical checks, colonial morphology evaluations, gram staining, and recording culture master histories."),
        MicroArticle(97, "SOP-MIC-097", "Qualification of Geobacillus stearothermophilus spore strips for Steam Sterilization", "Culture Maintenance & Biological Indicators", 
            "To establish verifying concentration (min 1.0 x 10^6), running autoclave challenge cycles, and culture incubation tracking."),
        MicroArticle(98, "SOP-MIC-098", "Qualification of Bacillus atrophaeus spore strips for Dry Heat Sterilization", "Culture Maintenance & Biological Indicators", 
            "To establish verifying dry-heat spore strips resistance inside hot air sterilization ovens, and incubation logs."),
        MicroArticle(99, "SOP-MIC-099", "Disposal and Autoclaving of Expired Reference Strains and Biohazards", "Culture Maintenance & Biological Indicators", 
            "To outline strict decontamination parameters, autoclaving waste at 121°C, and documenting destruction certificates."),
        MicroArticle(100, "SOP-MIC-100", "Determination of D-Value and Z-Value for Biological Indicators", "Culture Maintenance & Biological Indicators", 
            "To define mathematical modeling and experimental runs to verify biological indicators thermal death kinetics."),
        MicroArticle(101, "SOP-MIC-101", "In-house Isolation and Identification of Cleanroom Microflora (Wild Strains)", "Culture Maintenance & Biological Indicators", 
            "To establish protocols for storing isolates retrieved from Grade A cleanrooms, sequencing or biochem typing, and stocking."),
        MicroArticle(102, "SOP-MIC-102", "Storage and Issuance Registry for Biological Spore Suspension Stocks", "Culture Maintenance & Biological Indicators", 
            "To outline cataloging, temperature-controlled storage, signature authorization for BI vial retrieval, and usage audits."),

        // 9. Disinfection & Cleanroom Hygiene (103-110)
        MicroArticle(103, "SOP-MIC-103", "Preparation and Filtration of 70% Isopropyl Alcohol (IPA)", "Disinfection & Cleanroom Hygiene", 
            "To establish raw alcohol dilution with purified water, passing through a sterile 0.2-micron filter inside LAF, and labeling."),
        MicroArticle(104, "SOP-MIC-104", "Rotation and Efficacy Validation of Disinfectant Solutions in Microlab", "Disinfection & Cleanroom Hygiene", 
            "To detail weekly shifting between phenolic and quaternary ammonium compounds, sporicidal gassing, and efficacy swab studies."),
        MicroArticle(105, "SOP-MIC-105", "Preparation and Sterilization of Sporicidal Sanitizers (Sodium Hypochlorite)", "Disinfection & Cleanroom Hygiene", 
            "To outline raw bleach dilutions calculations, daily preparations, checking active chlorine ppm, and sterile filtration."),
        MicroArticle(106, "SOP-MIC-106", "Gowning and Hygiene Requirements for Microbiology Laboratory Personnel", "Disinfection & Cleanroom Hygiene", 
            "To define hand wash protocols, wearing clean uniforms, hair caps, shoe covers, and restricting personal items in microlab areas."),
        MicroArticle(107, "SOP-MIC-107", "Monitoring of Disinfectant Residuals on Cleanroom Surfaces", "Disinfection & Cleanroom Hygiene", 
            "To outline chemical swabbing of benchtops, HPLC analysis of residual disinfectants, and sterile water rinsing intervals."),
        MicroArticle(108, "SOP-MIC-108", "Sanitization and Maintenance of Stainless Steel Pass Boxes", "Disinfection & Cleanroom Hygiene", 
            "To establish daily sanitization of pass box interiors, checking UV lamp hours, and calibrating door magnetic interlocks."),
        MicroArticle(109, "SOP-MIC-109", "Cleaning and Sanitization of Microbiology Incubator Interiors", "Disinfection & Cleanroom Hygiene", 
            "To detail monthly emptying of incubators, washing shelves with disinfectant solutions, rinsing with sterile water, and EM checks."),
        MicroArticle(110, "SOP-MIC-110", "Air Lock Operations and Pressure Cascade Monitoring in Microlab", "Disinfection & Cleanroom Hygiene", 
            "To establish recording daily differential pressures of microlab rooms, checking air flow directions, and recording limit alerts."),

        // 10. General Microbiology SOPs & Good Lab Practices (111-115)
        MicroArticle(111, "SOP-MIC-111", "Validation of Analytical Methods for Antimicrobial Preservative Efficacy", "General Microbiology SOPs & Good Lab Practices", 
            "To outline testing preservative adequacy in liquid syrups, challenging products with high culture loads, and tracking CFU log reductions."),
        MicroArticle(112, "SOP-MIC-112", "Good Microbiology Laboratory Practices (GMLP) Guidelines", "General Microbiology SOPs & Good Lab Practices", 
            "To establish general lab safety, handling infectious cultures, preventing aerosol formation, and keeping positive-negative controls."),
        MicroArticle(113, "SOP-MIC-113", "Handling of Media Prep Autoclave Faults and Batch Rejection", "General Microbiology SOPs & Good Lab Practices", 
            "To define logging parameters when autoclave sterilization runs fail, physical testing of suspect agar, and batch dump records."),
        MicroArticle(114, "SOP-MIC-114", "Recording and Verification of Microbiological Test Raw Data", "General Microbiology SOPs & Good Lab Practices", 
            "To outline contemporaneous documentation of plate counts, raw calculation sheets co-signing, and archiving analytical records."),
        MicroArticle(115, "SOP-MIC-115", "Periodic Re-training and Eye Vision Checks for Microbiologists", "General Microbiology SOPs & Good Lab Practices", 
            "To establish annual vision checks (Jaeger test), color blindness tests, and re-qualification program for colony reading.")
    );

    fun getArticleBody(article: MicroArticle): String {
        return """
            PHARMACEUTICAL GUIDELINES & COMPLIANCE PORTAL
            REFERENCE CODE: ${article.code} | DEPARTMENT: MICROBIOLOGY
            TECHNICAL DIVISION: ${article.category}
            STANDARD REFERENCE MANUAL (cGMP & 21 CFR Part 211 COMPLIANT)
            
            1.0 OBJECTIVE
            ${article.objective}
            
            2.0 SCOPE
            This guidelines manual is applicable to all microbiological testing, culture operations, sterile evaluations, media preparation, environmental audits, water systems monitoring, and cleanroom sanitizations executed under the Microbiology Laboratory Division. All analysts, supervisors, and quality auditors must strictly adhere to these criteria to ensure absolute compliance with current Good Manufacturing Practices (cGMP) and global regulatory expectations (FDA, WHO, and ICH guidelines).
            
            3.0 MATERIAL & EQUIPMENTS REQUIRED
            - Certified ATCC Traceable Reference Culture Strains and standard cryopreservatives.
            - Class-A sterile glassware and pyrogen-free test tubes and pipettes.
            - Calibrated active air samplers, airborne particle counters, colony counters, and microscopes (carrying active calibration labels).
            - High-purity reagents and culture media (dehydrated media powders, LAL reagents, endotoxin-free water, 70% sterile IPA).
            - Personal Protective Equipment (PPE) including sterile full-body cleanroom suits, sterile gloves, masks, and protective safety goggles.
            
            4.0 STEP-BY-STEP TECHNICAL PROCEDURE
            4.1 PRE-EXECUTION STEPS:
            - Before starting any microbiological procedure, physically clean the biosafety cabinet or laminar air flow workbench. Verify differential pressure gauges display stable readings.
            - Record your details, date, start time, media batch numbers, standard weights, and reagent expiry dates in the analytical logbook.
            - If using automated colony counters or BET systems, log in under your unique secure user ID. Ensure the audit trail is active and verified before starting.
            
            4.2 CORE COMPLIANCE METHODOLOGY:
            - Execute the steps precisely as described in the official pharmacopeial monographs (USP, EP, or IP). For limit tests or environmental monitoring, perform sampling in exact locations.
            - All media preparation must be fully autoclaved. Ensure media tempering at 45-50°C before pouring to prevent heat degradation of nutrients.
            - For bacterial endotoxin or sterility tests, run positive and negative controls in parallel. Any positive growth in a negative control invalidates the test run.
            - For active air sampling or settle plate exposures, record the start and end exposure times concurrently under GDP (ALCOA+) guidelines.
            
            4.3 DATA INTEGRITY AND COMPLIANCE RULES:
            - All colony counts and raw plate printouts must be immediately written down in the raw analytical worksheet. Co-sign with double operator checks.
            - If any out-of-specification (OOS), environmental alert, or water count exceedance is triggered, stop work immediately, do not discard plates, and notify the supervisor within 24 hours.
            - Never delete, overwrite, or ignore any colony counts, turbid sterility runs, or test reports. Doing so is a direct violation of regulatory data integrity guidelines.
            
            5.0 SAFETY & ENVIRONMENTAL PRECAUTIONS
            - Always handle pathogenic reference cultures and biohazardous materials inside a certified Biosafety Cabinet to prevent inhalation or contact.
            - Ensure all liquid biohazardous wastes, plate cultures, and contaminated pipettes are autoclaved at 121°C for 30 minutes before final disposal.
            - In case of accidental spills or needle-sticks, wash the area with disinfectant, report to the safety officer, and log a laboratory deviation report immediately.
            
            6.0 QUALITY AUDIT FREQUENCY
            This compliance guideline and standard procedure must be reviewed and re-verified on a biennial basis (every 2 years), or immediately upon any technical change control proposal, equipment upgrades, or major regulatory audits.
            
            EFFECTIVE DATE: 2026-06-28
            AUTHOR: Lead QC Microbiology Specialist
            REVIEWER: Microbiology Lab Manager
            APPROVER: Head of Quality Assurance
        """.trimIndent()
    }
}
