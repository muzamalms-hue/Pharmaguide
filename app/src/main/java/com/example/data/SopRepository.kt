package com.example.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class SopRepository(private val sopDao: SopDao) {

    fun getAllUserMonographs(): Flow<List<UserMonographEntity>> = sopDao.getAllUserMonographs()

    suspend fun insertUserMonograph(monograph: UserMonographEntity) {
        sopDao.insertUserMonograph(monograph)
    }

    suspend fun insertUserMonographs(monographs: List<UserMonographEntity>) {
        sopDao.insertUserMonographs(monographs)
    }

    suspend fun deleteUserMonograph(id: Int) {
        sopDao.deleteUserMonograph(id)
    }

    fun getAllContactInquiries(): Flow<List<ContactInquiryEntity>> = sopDao.getAllContactInquiries()

    suspend fun insertContactInquiry(inquiry: ContactInquiryEntity) {
        sopDao.insertContactInquiry(inquiry)
    }

    fun getAllSops(): Flow<List<SopEntity>> = sopDao.getAllSops()

    fun getSopById(id: Int): Flow<SopEntity?> = sopDao.getSopById(id)

    fun searchSops(query: String, departments: List<String>): Flow<List<SopEntity>> {
        return if (departments.isEmpty()) {
            sopDao.searchSops(query)
        } else {
            sopDao.searchSopsInDepartments(query, departments)
        }
    }

    suspend fun updateBookmark(id: Int, isBookmarked: Boolean) {
        sopDao.updateBookmark(id, isBookmarked)
    }

    suspend fun signOffSop(id: Int, userRole: String, timestamp: Long) {
        sopDao.signOffSop(id, userRole, timestamp)
    }

    suspend fun checkAndPrepopulate() {
        val existingSops = try {
            sopDao.getAllSops().first()
        } catch (e: Exception) {
            emptyList()
        }
        val existingCodes = existingSops.map { it.code }.toSet()
        
        val defaultSops = listOf(
                SopEntity(
                    code = "SOP-QC-001",
                    title = "Calibration of HPLC Instrument",
                    department = "Quality Control",
                    section = "Instruments",
                    objective = "To lay down the step-by-step procedure for the calibration of High-Performance Liquid Chromatography (HPLC) systems to ensure accurate and reproducible chromatographic separation and analysis.",
                    scope = "This SOP is applicable to all HPLC systems installed in the Quality Control laboratory.",
                    responsibility = "Quality Control Analysts are responsible for executing the calibration. The Quality Control Manager is responsible for review and approval.",
                    procedure = "Ensure the system is thoroughly washed and primed with HPLC-grade water before calibration.;Set up the pump flow rate accuracy test: Measure the actual flow rate using a calibrated digital flowmeter or standard class A volumetric flask at 1.0 mL/min, 2.0 mL/min, and 0.5 mL/min. Record 3 readings for each.;Run wavelength accuracy of the detector: Use a standard solution of Caffeine (0.01 mg/mL in water) and scan between 200 nm and 300 nm. Confirm the absorbance maxima at 205 nm and 273 nm (tolerance: ±2 nm).;Execute column oven temperature accuracy: Insert a calibrated digital thermometer probe into the column oven. Set temperatures to 30°C, 40°C, and 50°C. Verify deviation is ≤ ±1.0°C.;Inject 6 replicates of standard solution (e.g., caffeine standard) to evaluate the injector precision and reproducibility. Peak area RSD must be ≤ 1.0%.;Document all results in the HPLC Calibration Logbook and apply the 'CALIBRATED' status label on the instrument.",
                    safetyPrecautions = "Always wear appropriate PPE (Safety goggles, lab coat, nitrile gloves).;Handle organic solvents under a fume hood. Dispose of organic waste in designated waste containers.;Ensure column pressure does not exceed the maximum rating (e.g., 400 bar).",
                    frequency = "Bi-annually (Every 6 months) or after major servicing or component replacement.",
                    effectiveDate = "2026-01-15",
                    roleRequired = "Analyst"
                ),
                SopEntity(
                    code = "SOP-QC-002",
                    title = "Operation of UV-Vis Spectrophotometer",
                    department = "Quality Control",
                    section = "Instruments",
                    objective = "To provide clear instructions for the standard operation of the UV-Visible Spectrophotometer to perform quantitative and qualitative absorbance analyses.",
                    scope = "Applicable to all qualitative and quantitative analysis of raw materials and finished goods using UV-Vis spectrophotometry.",
                    responsibility = "All trained QC Analysts are responsible for the safe and compliant operation of the instrument.",
                    procedure = "Turn on the main power switch and allow the deuterium (D2) and halogen lamps to warm up and stabilize for at least 30 minutes.;Perform the automated system self-check (wavelength scan, lamp intensity, and electronic verification). Ensure all checks pass.;Select the required analytical method or set the target wavelength in the instrument control panel.;Rinse two matched quartz cuvettes with the designated blank solvent (e.g., purified water or ethanol).;Fill both cuvettes with the blank solution, wipe the optical window with lint-free tissue paper, and place them in the sample and reference holders. Press 'Zero' or 'Blank'.;Discard blank from the sample cuvette, rinse twice with the sample solution, and fill to 3/4 volume. Place in sample holder and press 'Read/Measure'.;Record the absorbance value or spectrum profile. Print the system generated report and export the raw data file.;Discard solutions safely and clean both cuvettes immediately with methanol, followed by purified water.",
                    safetyPrecautions = "Never touch the optical transparent windows of quartz cuvettes with bare hands; use lens-cleaning paper.;Avoid physical exposure to high-intensity ultraviolet light emitted from the lamp house.",
                    frequency = "Daily verification (wavelength accuracy and photometric noise) before starting routine analysis.",
                    effectiveDate = "2026-02-10",
                    roleRequired = "Analyst"
                ),
                SopEntity(
                    code = "SOP-QC-003",
                    title = "Handling of Out of Specification (OOS) Results",
                    department = "Quality Control",
                    section = "General",
                    objective = "To define the structured procedure to investigate, document, and resolve Out of Specification (OOS) analytical results obtained during chemical or physical analysis.",
                    scope = "Applies to all analytical tests that fall outside the approved monograph specifications or established acceptance criteria for raw materials, in-process, finished drug products, and stability samples.",
                    responsibility = "QC Analyst is responsible for immediately reporting the OOS. QC Supervisor/Manager is responsible for initiating the Phase I laboratory investigation. QA Manager is responsible for review and final product disposition.",
                    procedure = "Do not discard any test preparations, glassware, standard solutions, or mobile phases. Retain all materials used in the failing test.;Inform the Supervisor immediately and fill out the 'OOS Notification Form' within 24 hours of obtaining the result.;Supervisor initiates Phase I Laboratory Investigation: Check calculations, verify standards/reagents freshness, inspect instrument calibration status, and interview the analyst regarding errors.;If an obvious laboratory error is identified (e.g., calculation mistake, wrong dilution, contaminated glassware), document the finding, invalidate the original result, perform re-testing with a fresh preparation, and implement corrective actions.;If no obvious laboratory error is identified, progress to Phase II Investigation: Formulate an investigation plan, perform authorized duplicate testing (re-testing) by a different analyst, and perform manufacturing site investigations if appropriate.;Compile all analytical raw data and submit the Phase I/II report to Quality Assurance for final evaluation. The QA Manager will determine product release or rejection.",
                    safetyPrecautions = "Always handle failing results with strict compliance; never perform informal 'trial' re-testing to get a passing result.",
                    frequency = "Triggered immediately upon occurrence of any test result that fails to meet official monographs.",
                    effectiveDate = "2026-03-01",
                    roleRequired = "QA Officer"
                ),
                SopEntity(
                    code = "SOP-QC-004",
                    title = "Preparation and Standardization of 0.1M Sodium Hydroxide (NaOH)",
                    department = "Quality Control",
                    section = "Solution Preparation",
                    objective = "To establish the procedure for preparing and standardizing 0.1 Molar Sodium Hydroxide (NaOH) volumetric solution to ensure accuracy in volumetric acid-base titrations.",
                    scope = "Applicable to standard chemical assays in the wet-chemistry lab where 0.1M NaOH is utilized as a volumetric titrant.",
                    responsibility = "Wet-chemistry laboratory Analysts are responsible for the preparation, standardization, and safe storage of the standard solution.",
                    procedure = "Weigh approximately 4.0 grams of high-purity Sodium Hydroxide pellets into a clean glass beaker.;Dissolve the pellets completely in about 100 mL of carbon dioxide-free purified water.;Transfer the solution quantitatively into a 1000 mL volumetric flask. Dilute to volume with carbon dioxide-free purified water and mix thoroughly. Let it cool to room temperature.;Dry Analytical Grade Potassium Hydrogen Phthalate (KHP) in an oven at 120°C for 2 hours and cool in a desiccator.;Weigh accurately about 0.5 grams of dried KHP into a clean conical flask and dissolve in 50 mL of purified water. Add 2 drops of phenolphthalein indicator solution.;Titrate with the prepared NaOH solution from a calibrated burette until a faint, persistent pink color is obtained (color persists for 15 seconds).;Calculate the molarity using the formula: Molarity = (Weight of KHP in grams) / (Volume of NaOH in mL * 0.20422).;Perform standardization in triplicate. The RSD of the three replicates must be ≤ 0.2%. Label the bottle with Name, Batch No, Date, Molarity, Factor, and Expiry.",
                    safetyPrecautions = "Sodium hydroxide pellets are highly corrosive and cause severe chemical burns. Wear safety goggles, protective apron, and thick nitrile gloves.;Always dissolve NaOH pellets slowly to avoid sudden heat generation.",
                    frequency = "Prepare fresh. Standardize monthly or before immediate use.",
                    effectiveDate = "2026-01-20",
                    roleRequired = "Analyst"
                ),
                SopEntity(
                    code = "SOP-MIC-001",
                    title = "Environmental Monitoring of Cleanrooms by Active Air Sampling",
                    department = "Microlab",
                    section = "Microbiology",
                    objective = "To establish guidelines for performing microbiologic environmental monitoring using active air samplers in Grade A/B aseptic areas and Grade C/D cleanrooms.",
                    scope = "This procedure is applicable to active viable particle air sampling in all sterile manufacturing and microbiology testing facility zones.",
                    responsibility = "Microbiology laboratory technicians and Analysts are responsible for conducting active air sampling and incubation.",
                    procedure = "Prepare required Soyabean Casein Digest Agar (SCDA) plates (90mm). Ensure plates have passed growth promotion testing and are stored at room temperature before use.;Sanitize the active air sampler head with 70% Sterile Isopropyl Alcohol (IPA). Allow to dry fully.;Dress in complete aseptic gowning before entering the manufacturing core (Grade A/B).;Place the sampler at the designated monitoring location as per the Environmental Monitoring Layout map.;Aseptically open the SCDA plate and secure it on the sampler rotor. Place the perforated sampling head back securely.;Program the air sampler to aspirate exactly 1000 Liters (1 m³) of air at a rate of 100 Liters per minute.;Once the cycle is complete, aseptically retrieve the plate, cover with its sterile lid, seal with cleanroom tape, and record sampling location and time on the plate base.;Transfer the plates to the incubator. Incubate SCDA plates at 20-25°C for 3 days, followed by 30-35°C for 2 days. Count and record colony forming units (CFU).",
                    safetyPrecautions = "Ensure complete sterile technique to prevent false contamination of plates.;Do not spray 70% IPA directly into active electronic inlets of the air sampler.",
                    frequency = "Every production shift in Grade A and B zones; weekly in Grade C zones; monthly in Grade D zones.",
                    effectiveDate = "2026-04-12",
                    roleRequired = "Analyst"
                ),
                SopEntity(
                    code = "SOP-MIC-002",
                    title = "Sterility Testing of Sterile Drug Products",
                    department = "Microlab",
                    section = "Microbiology",
                    objective = "To specify the sterility testing protocol by membrane filtration or direct inoculation to confirm sterile drug batches are free from viable micro-organisms before clinical release.",
                    scope = "Applicable to all sterile injectables, ophthalmic drops, and active sterile pharmaceutical ingredients.",
                    responsibility = "Qualified microbiologists are responsible for executing sterility testing under a Grade A laminar air flow cabinet.",
                    procedure = "Disinfect the outer surfaces of product vials or containers using sterile spore-killing disinfectants and transfer into the aseptic testing cabinet.;Sanitize the sterile membrane filtration assembly and load 0.45 micron hydrophobic edge membrane filters.;Aseptically transfer the specified volume of sample from product vials into the filter cup and apply vacuum.;Wash the membrane filter three times with 100 mL of Sterile Fluid A to rinse off any residual antimicrobial properties of the drug.;Aseptically cut the membrane in half or transfer the contents of the filter units. Immerse one half into Fluid Thioglycollate Medium (FTM) and the other half into Soybean Casein Digest Medium (SCDM).;Incubate FTM containers at 30-35°C (to detect anaerobic and aerobic bacteria) for 14 days.;Incubate SCDM containers at 20-25°C (to detect fungi and molds) for 14 days.;Perform daily visual inspections of the media containers for turbidity, cloudiness, or fungal colony growth. Record observations.",
                    safetyPrecautions = "Execute testing in an environment that strictly avoids biological contamination. Sterility testing must be performed with utmost care and double operator verification.",
                    frequency = "Mandatory for every manufactured batch of sterile pharmaceuticals before final release.",
                    effectiveDate = "2026-05-01",
                    roleRequired = "Analyst"
                ),
                SopEntity(
                    code = "SOP-QA-001",
                    title = "Change Control Management System",
                    department = "Quality Assurance",
                    section = "General",
                    objective = "To define a systematic procedure to propose, evaluate, review, and implement modifications that may impact the validated status of facilities, equipment, utilities, products, or processes.",
                    scope = "Applicable to all GMP changes including manufacturing process modifications, master formula revisions, equipment changes, computer system updates, and material specification adjustments.",
                    responsibility = "Any department personnel can initiate a change. The Quality Assurance Department is responsible for managing the registry, conducting risk assessments, and authorizing implementation.",
                    procedure = "The Change Initiator completes the 'Change Control Request Form' defining the proposed change, logical justification, and potential impact.;QA logs the request in the Change Control Register and assigns a unique tracker ID (e.g., CC-2026-XXX).;Initiate a multidisciplinary impact assessment involving QC, Production, Engineering, Regulatory Affairs, and Validation departments.;Conduct a formal Quality Risk Assessment (FMEA or PHA) to identify potential hazards to product quality or regulatory compliance.;Formulate an action plan outlining specific tasks (re-validation, stability testing, regulatory filing, document updates) and target deadlines.;QA Manager reviews the complete assessment and issues 'Conditional Approval' to execute the proposed changes.;After execution, verify completion of all actions and compile the 'Change Evaluation Report'. The QA Head issues final closure approval.",
                    safetyPrecautions = "Never execute any GMP-critical change without prior formal authorization of the Change Control panel.",
                    frequency = "Ad-hoc (Triggered whenever a physical or documentary change is proposed).",
                    effectiveDate = "2026-01-05",
                    roleRequired = "QA Officer"
                ),
                SopEntity(
                    code = "SOP-QA-002",
                    title = "Corrective and Preventive Action (CAPA) Procedure",
                    department = "Quality Assurance",
                    section = "General",
                    objective = "To establish a standard method for investigating deviations, non-conformances, and customer complaints to determine root causes and implement effective CAPAs to prevent recurrence.",
                    scope = "Applicable to all deviations, audit findings, customer complaints, out of specifications, and product failures requiring systematic corrective action.",
                    responsibility = "QA Officers are responsible for documenting and coordinating CAPA. Department Heads are responsible for implementing CAPA tasks. QA Head is responsible for verifying efficiency.",
                    procedure = "Log the trigger event (e.g., Deviation, Audit observation) in the CAPA system and assign a tracking ID within 48 hours of occurrence.;Form a cross-functional investigation team to conduct Root Cause Analysis (RCA) using tools like 5-Whys, Ishikawa (Fishbone) diagram, or Fault Tree Analysis.;Clearly define the Corrective Action (immediate action to correct the existing non-conformance) and Preventive Action (long-term action to eliminate root cause).;Create individual CAPA action items in the database with assigned Department Heads and strict due dates.;Implement action items (e.g., revise operating procedures, upgrade machine guards, re-train operators).;QA conducts a CAPA Effectiveness Verification after 3 to 6 months to confirm that the changes successfully resolved the issue without causing new failures.;If effective, close the CAPA file. If ineffective, re-open investigation.",
                    safetyPrecautions = "Prioritize structural engineering controls over visual training as a primary preventative choice.",
                    frequency = "Continuously managed as quality deviation issues are logged.",
                    effectiveDate = "2026-02-15",
                    roleRequired = "QA Officer"
                ),
                SopEntity(
                    code = "SOP-PRO-001",
                    title = "Operation of Tablet Compression Machine",
                    department = "Production",
                    section = "Oral",
                    objective = "To describe the standard operating procedure for set-up, pre-checks, starting, operation, and in-process testing of the high-speed rotary tablet compression machine.",
                    scope = "This SOP applies to the tablet compression machines operated in the Oral Solid Dosage facility.",
                    responsibility = "Production Operators and Supervisors are responsible for the safe and compliant operation of the machinery.",
                    procedure = "Verify that the machine, punches, dies, and compression room hold a green 'CLEANED' status label with active line clearance approval.;Install the appropriate punches and dies as per the batch manufacturing record. Hand-turn the turret to verify smooth, unhindered rotation.;Fill the feed hopper with the validated granules batch. Open the discharge slide to allow flow into the force feeder.;Set the machine parameters in the PLC screen: Fill depth (tablet weight), pre-compression, and main compression force as specified in the Master Formula.;Turn on the dust extractor and tablet deduster. Start the machine at low jogging speed (5-10 RPM) and inspect the first set of compressed tablets.;Measure physical attributes: Individual and average weight of 10 tablets, thickness, hardness, and friability. Adjust punches if weight or hardness deviates.;Gradually increase compression speed to the validated production speed. Record in-process testing results every 30 minutes in the batch card.;Upon batch completion, switch off power, empty hopper, remove punches/dies, and apply 'TO BE CLEANED' label on the machine and room.",
                    safetyPrecautions = "Never reach inside the turret chamber or feeder area while the turret is rotating.;Always wear high-filtration face masks, protective safety glasses, and sound-muffling ear defenders during operation.;Ensure the interlock sensors are fully functional. Never bypass physical safety guards.",
                    frequency = "Every manufacturing run of solid dosage tablets.",
                    effectiveDate = "2026-03-10",
                    roleRequired = "Operator"
                ),
                SopEntity(
                    code = "SOP-PRO-002",
                    title = "Aseptic Gowning Procedure for Grade A Sterile Areas",
                    department = "Production",
                    section = "Sterile",
                    objective = "To outline the mandatory sequence of washing, sanitization, and sterile gowning required for personnel entering Grade A/B aseptic cleanrooms.",
                    scope = "This procedure is mandatory for all personnel (operators, QA, maintenance, visitors) entering Grade B corridors or Grade A sterile workstation boundaries.",
                    responsibility = "Every individual entering the sterile cleanroom is responsible for compliance. QA Cleanroom Inspectors verify the gowning integrity.",
                    procedure = "Remove all jewelry, cosmetics, watches, and personal outer clothing in the changing room. Step across the red line and put on dedicated cleanroom slippers.;Wash hands and forearms up to the elbows with antiseptic liquid soap for 2 minutes. Dry hands with hot-air drier or sterile lint-free towels.;Sanitize hands with 70% IPA and enter the Grade B gowning room.;Retrieve a sterile pre-packed gowning kit of correct size. Inspect package integrity and check the steam-sterility indicator tape.;Put on a sterile hair hood and face mask. Adjust the mask nose clip so it is sealed tightly against the face. Wear sterile goggles securely.;Put on the sterile one-piece jumpsuit without letting it touch the floor, walls, or outer bench surface. Zip up fully and tuck the hood under the collar.;Slip on sterile knee-high boots and secure straps tightly.;Wash hands with sterile IPA, then put on the first pair of sterile latex gloves. Pull cuffs of gloves over jumpsuit sleeves. Put on the second pair of gloves similarly.;Perform visual self-inspection in the mirror to verify 100% skin coverage before entering the sterile airlock.",
                    safetyPrecautions = "Any accidental touch of gown outer surfaces to non-sterile items voids the gowning. The person must step back and start the sequence from step 1.;Avoid swift, high-turbulent movements that create airborne skin shedding.",
                    frequency = "Every single entry into the Grade B/A cleanroom zones.",
                    effectiveDate = "2026-04-01",
                    roleRequired = "Operator"
                ),
                SopEntity(
                    code = "SOP-PRO-003",
                    title = "Preparation of Liquid Oral Suspensions",
                    department = "Production",
                    section = "Non-Sterile",
                    objective = "To define the manufacturing methodology for raw material hydration, mixing, and dispersion of liquid oral suspensions in the compounding vessel.",
                    scope = "Applies to the manufacturing of non-sterile oral liquid pharmaceutical suspensions in the syrup/suspension manufacturing tank.",
                    responsibility = "Compounding Operators and Production Supervisors are responsible for processing liquid suspensions.",
                    procedure = "Verify clean status of the 1000L Jacketed Compounding Vessel and obtain line clearance certificate from QA.;Add designated volume of Purified Water to the vessel and heat to 70-75°C under constant agitation.;Weigh and add Sweetening Agents (e.g., Sucrose or Sorbitol) slowly. Continue stirring at 30-40 RPM for 30 minutes to form a clear syrup base.;Cool the syrup base to 40°C. In a separate colloid mill or high-shear mixing tank, prepare a uniform suspension of active raw materials in wetting agents (e.g., Glycerin or Polysorbate).;Slowly transfer the active dispersion into the main syrup base while running the high-shear homogenizer at 2000 RPM for 15 minutes to guarantee dispersion homogeneity.;Dissolve preservatives (e.g., Methylparaben, Propylparaben) and flavoring agents in a small quantity of hot water/alcohol and add to the vessel.;Adjust the final volume of the suspension to 1000 Liters with purified water. Mix for 15 minutes.;Draw a top, middle, and bottom sample for QC viscosity, pH, and active content check. Transfer to holding tank upon QC clearance.",
                    safetyPrecautions = "Exercise extreme caution when working with jacketed vessel high-pressure steam pipes. Wear high-thermal protection gloves.;Ensure proper grounding of the vessel to prevent static buildup when pouring raw powders.",
                    frequency = "Every production batch of liquid oral suspension.",
                    effectiveDate = "2026-05-15",
                    roleRequired = "Operator"
                ),
                SopEntity(
                    code = "SOP-WH-001",
                    title = "Receiving and Sampling of Raw Materials",
                    department = "Warehouse",
                    section = "Raw Materials",
                    objective = "To establish the receipt, visual inspection, quarantine, and aseptic sampling procedure of active pharmaceutical ingredients (APIs) and excipients upon arrival.",
                    scope = "This procedure is applicable to all incoming dry chemical powders and liquid starting materials received at the warehouse loading bay.",
                    responsibility = "Warehouse Receiving Officers are responsible for receiving and storage. QC Samplers are responsible for drawing samples.",
                    procedure = "Check delivery vehicle integrity. Verify seal numbers and check that the shipping invoice matches the Purchase Order and manufacturer labels.;Visually inspect all outer containers for damage, leakage, or wetness. Reject compromised containers immediately.;Perform physical sanitization (dust blowing/wiping) of outer containers before transferring to the Warehouse quarantine area.;Affix yellow 'QUARANTINE' status labels containing Material Name, Internal Lot Number, and Date on each container.;Log the receipt in the ERP inventory system to freeze quantity updates.;Notify QC of material arrival. QC Analyst performs sampling inside a dedicated Class 100 Laminar Air Flow (LAF) sampling booth inside the warehouse.;Cut container seals cleanly, draw samples from random containers using a sterile sampling thief, transfer to sterile bottles, and seal.;Re-seal raw containers with 'SAMPLED' tape and update material status in the database to await QC clearance.",
                    safetyPrecautions = "Never open chemical containers in open, non-classified warehouse areas. This prevents environmental contamination and product degradation.;Always wear respirators and face masks when handling volatile or active dust-producing raw powders.",
                    frequency = "Every incoming consignment of active starting pharmaceutical materials.",
                    effectiveDate = "2026-02-28",
                    roleRequired = "Warehouse Executive"
                ),
                SopEntity(
                    code = "SOP-WH-002",
                    title = "Inventory Control and FEFO Implementation",
                    department = "Warehouse",
                    section = "Finished Goods",
                    objective = "To outline inventory storage rules, material segregation, and the strict implementation of FEFO (First Expired, First Out) policies for stock dispatch.",
                    scope = "Applies to all raw chemical powders, packaging materials, intermediate drug batches, and finished pharmaceutical products stored in warehouse zones.",
                    responsibility = "The Warehouse Store Manager and warehouse workers are responsible for material binning and FEFO compliance.",
                    procedure = "Verify storage environment daily: Maintain controlled room temperature zone between 15°C and 25°C, or cold room between 2°C and 8°C. Record thermo-hygrometer readings twice daily.;Ensure all materials are stacked on high-density plastic or wooden pallets. Never stack materials directly on the floor or touching the walls.;Organize materials by department categories, and arrange rows logically. Ensure a 10-inch separation from walls for airflow and cleaning access.;Implement the FEFO (First Expired, First Out) principle: Place batches with earlier expiration dates at the front of shelving arrays, and later dates behind.;Upon receiving a material dispensing request or finished goods shipping invoice, the warehouse picker must select the batch with the nearest expiration date.;Check the physical material status label before picking. Ensure it carries a green 'RELEASED' label and the approval seal of QC/QA.;Log the picked batch barcode in the inventory terminal to immediately adjust stock counts.;Conduct monthly cycle counting and reconciliations. Investigate any discrepancy >0.5% immediately and report to QA.",
                    safetyPrecautions = "Wear steel-toed boots and safety helmets in tall pallet racking bays.;Do not operate electric forklifts without valid training and licenses.;Observe maximum stacking heights printed on outer shipping boxes.",
                    frequency = "Continuous daily operation.",
                    effectiveDate = "2026-03-22",
                    roleRequired = "Warehouse Executive"
                ),
                SopEntity(
                    code = "VAL-001",
                    title = "Equipment Qualification Protocol (IQ/OQ/PQ)",
                    department = "Validation",
                    section = "Equipment",
                    objective = "To define the protocol for Installation, Operational, and Performance Qualification (IQ/OQ/PQ) of manufacturing equipment.",
                    scope = "Applicable to all new and majorly modified manufacturing equipment.",
                    responsibility = "Validation team is responsible. QA is responsible for approval.",
                    procedure = "Draft the qualification protocol specifying physical and electronic parameters.;Perform Installation Qualification (IQ) to verify that the equipment is installed as per engineering drawings and manual specifications.;Execute Operational Qualification (OQ) to run the system through its entire operating range and verify limit switches and alarms.;Execute Performance Qualification (PQ) by running three consecutive batches to prove consistency in product output and process tolerance.;Document any deviations or failures during run trials, analyze impact, and sign off the report upon verification.",
                    safetyPrecautions = "Wear appropriate PPE during live system runs.;Do not bypass electronic limit sensors during standard testing.",
                    frequency = "Tri-annually or after any major component replacement or hardware upgrade.",
                    effectiveDate = "2026-05-15",
                    roleRequired = "QA Officer"
                ),
                SopEntity(
                    code = "VAL-002",
                    title = "Cleaning Validation Master Plan",
                    department = "Validation",
                    section = "Cleaning",
                    objective = "To establish the master plan for verification of cleanliness of product-contact equipment to prevent cross-contamination.",
                    scope = "All manufacturing lines and product-contact utensils.",
                    responsibility = "Production team performs cleaning. Validation analysts conduct swab and rinse sampling.",
                    procedure = "Identify worst-case drug products based on solubility, toxicity, and cleaning difficulty.;Calculate Maximum Allowable Carryover (MACO) using pharmacological active dose data.;Perform standard cleaning procedure on the equipment as defined in the cleaning SOP.;Take swab samples from predefined hard-to-clean areas using high-recovery swabs.;Collect final rinse water samples (at least 500 mL) to analyze total organic carbon (TOC) and active residues.;Analyze samples using HPLC or TOC analyzer. Residue level must be within calculated MACO limits.;Compile results and certify the clean hold time (CHT) for the equipment.",
                    safetyPrecautions = "Ensure equipment is electrically locked out and tagged out (LOTO) before opening for swab sampling.;Handle hazardous residues with appropriate mask filtration.",
                    frequency = "Once every year or upon introduction of a new, highly active drug product.",
                    effectiveDate = "2026-06-01",
                    roleRequired = "QA Officer"
                ),
                SopEntity(
                    code = "GMP-001",
                    title = "Good Documentation Practices (GDP) Requirements",
                    department = "GMP",
                    section = "Documentation",
                    objective = "To outline the requirements for recording and maintaining GMP-compliant data in the pharmaceutical facility.",
                    scope = "All departments involved in GMP-regulated operations.",
                    responsibility = "All employees are responsible for adhering to Good Documentation Practices.",
                    procedure = "Write all entries in permanent black or blue ballpoint ink. Never use pencil or correction fluid.;Record observations immediately at the time the action is performed. Backdating or pre-dating is strictly prohibited.;If a correction is needed, draw a single line through the incorrect entry, write the correct value next to it, and initial/date with the reason (e.g., 'typo' or 'writing error').;Ensure all printouts, charts, and weight slips are signed, dated, and securely attached to the batch record.;Archive all files in a controlled fire-proof record cabinet with restricted card access.",
                    safetyPrecautions = "Never discard raw data sheets or scrap papers containing original notes.",
                    frequency = "Continuous compliance. Verified during self-inspections.",
                    effectiveDate = "2026-01-10",
                    roleRequired = "Analyst"
                ),
                SopEntity(
                    code = "GMP-002",
                    title = "WHO Guidelines for Sterile Pharmaceutical Products",
                    department = "GMP",
                    section = "Sterility",
                    objective = "To summarize the WHO regulatory requirements for environmental cleanliness in sterile drug production.",
                    scope = "Sterile manufacturing facility.",
                    responsibility = "QA department is responsible for ensuring compliance through monitoring and design checks.",
                    procedure = "Maintain a strict cascading air pressure differential between clean rooms (Grade A > Grade B > Grade C > Grade D).;Ensure at least 20 air changes per hour in Grade C and D zones, and unidirectional laminar flow (0.45 m/s) in Grade A.;Execute regular sanitization using rotated disinfectants and a sporicidal agent to prevent bacterial resistance.;Monitor non-viable particles continuously during production operations in Grade A zones.;Conduct media fill validation runs bi-annually with 100% sterile growth-promoted media.",
                    safetyPrecautions = "Adhere strictly to personal hygiene rules. No make-up or hand lotions inside sterile areas.",
                    frequency = "Continuous compliance.",
                    effectiveDate = "2026-02-15",
                    roleRequired = "QA Officer"
                ),
                SopEntity(
                    code = "AUD-001",
                    title = "Internal Quality Audit Checklist - QC Laboratory",
                    department = "Audit",
                    section = "Laboratory",
                    objective = "To establish a comprehensive audit checklist for evaluating QC laboratory compliance.",
                    scope = "All Quality Control testing sections.",
                    responsibility = "Lead Auditors are responsible for conducting audits. QC supervisors are responsible for corrective actions.",
                    procedure = "Verify that all analytical instruments carry active 'CALIBRATED' labels and matching logbook entries.;Check standard solutions preparation log: ensure reagents are within their expiry date and standard factors are calculated correctly.;Audit raw chromatograms on the HPLC system: inspect integration parameters and verify there are no unauthorized deletion of data runs.;Confirm that all Analysts are qualified on their specific analytical methods and have valid training files.;Inspect chemical storage cabinets: verify correct segregation of incompatible acids and bases.",
                    safetyPrecautions = "Ensure strict confidentiality of all audited materials and personnel files.",
                    frequency = "Annually as per the approved Internal Audit Calendar.",
                    effectiveDate = "2026-03-01",
                    roleRequired = "QA Officer"
                ),
                SopEntity(
                    code = "AUD-002",
                    title = "FDA Inspection Readiness Guidelines",
                    department = "Audit",
                    section = "Regulatory",
                    objective = "To outline the response protocol, roles, and readiness checklist for regulatory FDA audits.",
                    scope = "Entire pharmaceutical plant.",
                    responsibility = "All site managers and executive leadership.",
                    procedure = "Establish a dedicated 'War Room' for audit document management, coordinate retrievers, and assign primary scribes.;Ensure all logbooks are completely filled, signed, and up-to-date.;Brief all staff: answer auditor questions clearly, truthfully, and concisely. Speak only to your direct responsibilities.;Review historical deviations, CAPAs, and change controls from the past two years; verify all actions are closed.;Confirm that the facility is physically clean, labeling is immaculate, and waste is correctly discarded.",
                    safetyPrecautions = "Remain professional and collaborative at all times during audit sessions.",
                    frequency = "Continuous readiness.",
                    effectiveDate = "2026-04-10",
                    roleRequired = "QA Officer"
                ),
                SopEntity(
                    code = "DOC-001",
                    title = "Master Batch Manufacturing Record (BMR) Template",
                    department = "Documents",
                    section = "Forms",
                    objective = "To provide the standardized template format for a Batch Manufacturing Record.",
                    scope = "Production and Quality Assurance.",
                    responsibility = "Production executes the BMR; QA issues and archives.",
                    procedure = "BMR Header: Batch number, product name, batch size, manufacturing date, and unique document reference number.;Bill of Materials (BOM): Exact quantities of raw material ingredients with active potency calculations.;Equipment Details: Cleaned line-clearance checklist with operator and supervisor sign-offs.;Step-by-step process flow: hydration, mixing, tablet compression, or sterile filling with double-operator verification signatures.;In-process checks log: physical attribute tables, weight sheets, and thickness parameters.;Yield reconciliation sheet: compare final output against theoretical yield (limits: 97.0% - 101.5%).",
                    safetyPrecautions = "Ensure BMR is printed on security-tinted watermark paper to prevent duplication.",
                    frequency = "Issued for every manufactured batch.",
                    effectiveDate = "2026-01-25",
                    roleRequired = "Operator"
                ),
                SopEntity(
                    code = "DOC-002",
                    title = "Laboratory Deviation Report Template",
                    department = "Documents",
                    section = "Forms",
                    objective = "To define the standard form layout for documenting and initiating laboratory deviations.",
                    scope = "Quality Control.",
                    responsibility = "The initiating Analyst is responsible for documenting. QA is responsible for logging.",
                    procedure = "Section 1: Deviation details including Date, Time, Instrument ID, Product Name, and Batch number.;Section 2: Detailed description of the event, immediate corrective actions taken, and supervisor interview notes.;Section 3: Phase I investigation checklist (reagents, glassware, dilution checks).;Section 4: Proposed corrective actions (CAPA) and risk evaluation.;Section 5: Final review and approval signatures from QC and QA heads.",
                    safetyPrecautions = "Initiate the form immediately; do not wait for the next shift.",
                    frequency = "Triggered on occurrence of any laboratory deviation.",
                    effectiveDate = "2026-03-15",
                    roleRequired = "Analyst"
                ),
                SopEntity(
                    code = "SOP-QC-005",
                    title = "Operation and Calibration of pH Meter",
                    department = "Quality Control",
                    section = "Instruments",
                    objective = "To outline the standard procedure for the daily operation and buffer calibration of laboratory pH meters to ensure precise pH measurements.",
                    scope = "Applicable to all benchtop pH meters inside the Quality Control laboratory.",
                    responsibility = "All trained laboratory Analysts are responsible for the operation and calibration of the instrument.",
                    procedure = "Verify the temperature sensor is connected. Standardize using fresh pH 4.01, 7.00, and 10.01 NIST-traceable buffer solutions.;Rinse electrode with deionized water and pat dry with lint-free paper between readings.;Measure sample by immersing probe fully and waiting for stability beep.;Store probe in 3M KCl electrolyte solution when not in use.",
                    safetyPrecautions = "Handle standard acid and base buffer solutions with caution.;Do not scratch the glass bulb membrane of the electrode.",
                    frequency = "Daily before use.",
                    effectiveDate = "2026-03-10",
                    roleRequired = "Analyst"
                ),
                SopEntity(
                    code = "SOP-QC-006",
                    title = "Standard Operation of Karl Fischer Titrator for Moisture Analysis",
                    department = "Quality Control",
                    section = "Instruments",
                    objective = "To define operational steps for Karl Fischer volumetric titrator to accurately estimate moisture content in raw materials and finished goods.",
                    scope = "Applicable to all moisture and water content determinations across active drug components and excipients.",
                    responsibility = "All trained Analysts are responsible for standardizing titrant and performing sample runs.",
                    procedure = "Switch on KF titrator. Check molecular sieve status in drying tube.;Perform conditioning run to neutralize moisture in reaction vessel.;Standardize KF reagent with purified water or sodium tartrate dihydrate standard in triplicate.;Weigh sample and introduce into vessel. Titrate to electromagnetic endpoint. Record water percentage.",
                    safetyPrecautions = "KF reagents contain hazardous methanol, pyridine/imidazole, and sulfur dioxide. Work inside a fume hood.;Wear high-grade nitrile gloves.",
                    frequency = "Monthly calibration, or daily standardization check.",
                    effectiveDate = "2026-04-18",
                    roleRequired = "Analyst"
                ),
                SopEntity(
                    code = "SOP-QA-003",
                    title = "Annual Product Quality Review (APQR)",
                    department = "Quality Assurance",
                    section = "General",
                    objective = "To establish a procedure to compile and evaluate annual manufacture history of every product, ensuring consistency and detecting adverse trends.",
                    scope = "Mandatory for all commercial drug products manufactured under site license.",
                    responsibility = "The QA APQR Officer compiles the data. The Quality Head reviews and approves.",
                    procedure = "Gather batch records, yields, raw material lots, analytical test results, and stability data for the product.;Collate all registered deviations, CAPAs, OOS results, change controls, and product recalls initiated over the past year.;Evaluate critical parameters like tablet hardness, assay values, and dissolution rates using control charts.;Compile a comprehensive APQR report with statistical conclusions and submit to the Quality Head for sign-off.",
                    safetyPrecautions = "Ensure strict compliance with data integrity rules during compilation.",
                    frequency = "Annually per product.",
                    effectiveDate = "2026-02-28",
                    roleRequired = "QA Officer"
                ),
                SopEntity(
                    code = "SOP-QA-004",
                    title = "Management of Non-Conformities and Deviations",
                    department = "Quality Assurance",
                    section = "General",
                    objective = "To detail the identification, documentation, classification, and investigation of process deviations to prevent quality issues.",
                    scope = "Applicable to all manufacturing and testing deviations on site.",
                    responsibility = "Any employee observing a deviation must stop the activity and report it to the area supervisor immediately.",
                    procedure = "Log the deviation in the Pharma SOP Portal tracker within 24 hours of discovery.;Classify the deviation as Minor, Major, or Critical based on risk assessment of product quality, safety, and GMP compliance.;Conduct a multidisciplinary root-cause investigation. Implement corrective actions and obtain QA approval for product disposition.",
                    safetyPrecautions = "Never hide or minimize any deviation event, regardless of severity.",
                    frequency = "Ad-hoc (Triggered on occurrence).",
                    effectiveDate = "2026-03-15",
                    roleRequired = "QA Officer"
                ),
                SopEntity(
                    code = "SOP-MIC-003",
                    title = "Operation and Validation of Steam Sterilizer (Autoclave)",
                    department = "Microlab",
                    section = "Microbiology",
                    objective = "To establish instructions for operating and validating autoclaves to sterilize laboratory media, glassware, and waste.",
                    scope = "Applicable to autoclaves in laboratory prep zones.",
                    responsibility = "Qualified microbiology technicians are responsible for load loading and run cycles.",
                    procedure = "Load items into autoclave basket with steam indicators. Do not overload.;Secure the lid. Set the cycle parameters: 121°C at 15 psi pressure for 15 minutes (or 20 minutes for biohazard waste).;Verify chamber temperature and pressure in printout stream. Ensure cycle runs smoothly.;Let chamber cool below 80°C and 0 psi before opening lid. Retrieve items with heat-resistant gloves.;Verify color change of autoclave tape and check biological indicators (Geobacillus stearothermophilus) monthly.",
                    safetyPrecautions = "Never open the autoclave door when chamber pressure is above 0 psi.;Use heat-resistant safety gloves and safety face shields.",
                    frequency = "Daily operation; bi-annual thermal mapping validation.",
                    effectiveDate = "2026-05-20",
                    roleRequired = "Analyst"
                ),
                SopEntity(
                    code = "SOP-MIC-004",
                    title = "Growth Promotion Testing of Culture Media",
                    department = "Microlab",
                    section = "Microbiology",
                    objective = "To specify growth promotion testing (GPT) steps for verifying the quality and nutritive capacity of newly prepared or purchased media batches.",
                    scope = "All solid and liquid media utilized for microbiological assays.",
                    responsibility = "Trained microbiology Analysts are responsible for carrying out GPT checks.",
                    procedure = "Inoculate media plates/bottles from a new batch with <= 100 CFU of standard test microorganisms (e.g., E. coli, S. aureus, C. albicans).;Incubate inoculated and uninoculated (negative control) media at appropriate temperatures (30-35°C for bacteria, 20-25°C for fungi).;Observe for growth: solid media must show >= 50% recovery compared to previously approved reference batches; liquid media must show clearly visible turbidity.;Document results in the Media Receipt & Validation Logbook.",
                    safetyPrecautions = "Handle standard pathogenic cultures with biosafety Level II compliance; incinerate/autoclave positive plates after use.",
                    frequency = "Every fresh batch/consignment of culture media.",
                    effectiveDate = "2026-06-05",
                    roleRequired = "Analyst"
                ),
                SopEntity(
                    code = "SOP-PRO-004",
                    title = "Operation and Control of Fluid Bed Dryer (FBD)",
                    department = "Production",
                    section = "Oral",
                    objective = "To define the operation, cleaning, and parameter control of the fluid bed dryer during wet granule moisture removal.",
                    scope = "This SOP applies to FBD equipment installed in the Solid Oral Dosage manufacturing block.",
                    responsibility = "Production Operators and Supervisors are responsible for the safe and compliant operation of the dryer.",
                    procedure = "Verify active line clearance. Check that product bags are clean and untorn.;Load wet granules trolley into FBD chamber. Secure inflatable seal.;Set inlet temperature, air flow rate, and shaking intervals on the control screen as per Batch manufacturing instructions.;During drying, pull sample probes to check Moisture Content (LOD - Loss On Drying). Continue until moisture is within 1.5% - 2.5%.;Discharge dry granules into intermediate container and verify total yield.",
                    safetyPrecautions = "Ensure grounding cable is securely clamped to dissipate static electricity.;Wear dust-proof safety respirators.",
                    frequency = "For every granule batch drying cycle.",
                    effectiveDate = "2026-03-25",
                    roleRequired = "Operator"
                ),
                SopEntity(
                    code = "SOP-PRO-005",
                    title = "Standard Parameters for Tablet Film Coating Process",
                    department = "Production",
                    section = "Oral",
                    objective = "To lay down standard processing parameters for applying polymer film coating on compressed tablets.",
                    scope = "Applicable to all film-coated tablet production runs.",
                    responsibility = "Trained Coating Operators are responsible for process execution and inspection.",
                    procedure = "Load core tablets into the coating pan. Ensure core tablet dust has been removed by vacuum deduster.;Prepare coating suspension (e.g., Opadry polymer in purified water) with continuous stirring for 45 minutes.;Pre-heat tablets to 38-42°C in the pan by blowing warm dry air while jogging pan slowly.;Set parameters: Spray rate 15-25 g/min, pan speed 6-12 RPM, inlet air temperature 60°C, and atomizing air pressure 2.5 bar.;Spray continuously until target weight gain of 2.0% - 3.0% is achieved. Dry tablets for 10 minutes post-coating.",
                    safetyPrecautions = "Do not touch the rotating coating pan drum during operation.;Ensure spray gun nozzle does not clog; clear immediately using purified water.",
                    frequency = "Every coated tablet batch manufacture.",
                    effectiveDate = "2026-04-14",
                    roleRequired = "Operator"
                ),
                SopEntity(
                    code = "SOP-WH-003",
                    title = "SOP for Dispensing of Raw Materials",
                    department = "Warehouse",
                    section = "Raw Materials",
                    objective = "To specify the steps for dispensing of active drug substances and excipients under controlled class 100 LAF dispensing booths.",
                    scope = "Applicable to all raw ingredients and chemicals dispensed for production batches.",
                    responsibility = "Warehouse Executives are responsible for weighing. QC is responsible for verification.",
                    procedure = "Confirm QA issued dispensing request matches active Batch record details.;Transfer material from main store to pre-dispensing zone. Clean outer surface of containers.;Turn on dispensing LAF cabinet 15 minutes prior to action. Check differential pressure.;Weigh out target ingredients sequentially, using high-precision calibrated balances. Double-verify tare and gross weights.;Seal dispensed material in clean, polybag containers, label with active Batch ID, Material Name, and Net Weight, and transfer to intermediate staging area.",
                    safetyPrecautions = "Dispense APIs inside reverse-laminar flow booth to protect the operator from powder inhalation.;Never mix scopes or scoops of different ingredients.",
                    frequency = "Before every compounding process.",
                    effectiveDate = "2026-02-15",
                    roleRequired = "Warehouse Executive"
                ),
                SopEntity(
                    code = "VAL-003",
                    title = "Computerized System Validation (CSV) Protocol",
                    department = "Validation",
                    section = "Equipment",
                    objective = "To outline the GAMP 5 life-cycle validation process for GxP computerized systems, software, and databases.",
                    scope = "Applicable to software systems, laboratory instruments, and database backups on site.",
                    responsibility = "Validation team and Software Engineers compile protocols. QA provides approval.",
                    procedure = "Draft a User Requirements Specification (URS) and perform GxP impact screening.;Conduct a System Risk Assessment to establish mitigation actions for electronic signatures and data backup audit trails.;Perform Design Qualification (DQ) of software vendors.;Coordinate with engineers to execute Installation Qualification (IQ) and Operational Qualification (OQ) tests.;Verify strict compliance with 21 CFR Part 11 electronic records, audit trails, secure logins, and automated data archival.",
                    safetyPrecautions = "Always maintain secure administrator keys during computerized system qualification.",
                    frequency = "For any GxP-critical software installation or major configuration patch.",
                    effectiveDate = "2026-05-30",
                    roleRequired = "QA Officer"
                ),
                SopEntity(
                    code = "VAL-004",
                    title = "Process Validation Master Protocol",
                    department = "Validation",
                    section = "Process",
                    objective = "To establish standard steps for validation of manufacturing processes to consistently yield quality drug batches.",
                    scope = "Mandatory for all manufactured processes on site.",
                    responsibility = "Process Engineers and Validation Executives execute; QA Head approves.",
                    procedure = "Formulate a Process Validation Protocol detailing batch parameters, sampling matrices, and acceptance thresholds.;Manufacture three successive commercial-scale batches using identical process controls.;Collect critical in-process samples (granules blending homogeneity, tablet uniformity, vial fill weights) as per the sampling layout.;Apply statistical analysis (Process Capability Index CpK) to demonstrate process stability and robust control.;Draft the validation final report and present to QA Head for authorization before commercial distribution.",
                    safetyPrecautions = "Do not deviate from the validated batch parameters unless under pre-planned experimental protocol.",
                    frequency = "Initial qualification of new drug products, or after significant change in raw material source or scale.",
                    effectiveDate = "2026-06-15",
                    roleRequired = "QA Officer"
                ),
                SopEntity(
                    code = "GMP-003",
                    title = "Implementation of Quality Risk Management (QRM)",
                    department = "GMP",
                    section = "Risk",
                    objective = "To lay down rules for the practical implementation of ICH Q9 Quality Risk Management across the manufacturing plant.",
                    scope = "Applicable globally across site quality divisions.",
                    responsibility = "All GxP section heads and QA officers execute risk assessments.",
                    procedure = "Initiate risk assessment by identifying potential failure modes using Failure Mode and Effects Analysis (FMEA).;Evaluate the risk based on Severity (S), Probability of Occurrence (O), and Detectability (D). Calculate Risk Priority Number (RPN).;For any RPN > 100, define corrective risk-mitigation plans with designated completion dates.;Re-evaluate the risk after mitigation implementation to ensure residual risk is within acceptable GxP thresholds.",
                    safetyPrecautions = "Always base risk evaluations on scientific knowledge and patient safety parameters.",
                    frequency = "Continuous; triggered during change control, deviation, or technical complaint evaluations.",
                    effectiveDate = "2026-04-20",
                    roleRequired = "QA Officer"
                ),
                SopEntity(
                    code = "GMP-004",
                    title = "Sanitization and Hygiene Requirements for GMP Facilities",
                    department = "GMP",
                    section = "Hygiene",
                    objective = "To outline personal hygiene, cleanliness, and periodic sanitization requirements inside manufacturing areas.",
                    scope = "All personnel entering site production areas.",
                    responsibility = "Area supervisors and QA inspectors ensure compliance daily.",
                    procedure = "Perform daily physical checks of operators for infectious skin diseases, cuts, or open wounds. Restrict exposed operators from GxP spaces.;Prohibit eating, drinking, smoking, chewing, or storing personal items inside manufacturing zones.;Rotate cleanroom disinfectants (e.g., quaternary ammonium compounds, phenolic compounds, and 70% IPA) on a weekly schedule to prevent micro-organism resistance.;Clean and sanitize walls, ceilings, and floors daily using lint-free flat mops.",
                    safetyPrecautions = "Rotate sporicidal agents monthly to control spore-forming bacterial contaminants.",
                    frequency = "Daily compliance and weekly inspection.",
                    effectiveDate = "2026-02-12",
                    roleRequired = "Analyst"
                ),
                SopEntity(
                    code = "AUD-003",
                    title = "Audit Checklist for Warehouse and Materials Management",
                    department = "Audit",
                    section = "Warehouse",
                    objective = "To establish a standard audit checklist for evaluating GxP warehouse material handling and inventory control compliance.",
                    scope = "Applicable to all material storing and picking processes.",
                    responsibility = "Lead GMP Auditor evaluates. Warehouse manager addresses observations.",
                    procedure = "Verify that raw material and finished goods are correctly segregated and labeled (Quarantine, Released, Rejected).;Inspect temperature and humidity logs: check for out-of-limit incidents and corresponding corrective records.;Check calibrated weight scales: verify daily physical balance checks are logged.;Audit dispensing logs: verify raw weight values match theoretical batch weights.;Confirm that hazardous chemicals and active APIs are stored under secure, well-ventilated, or flame-proof spaces.",
                    safetyPrecautions = "Keep audit logs secure and report critical violations directly to the Site Quality Head.",
                    frequency = "Bi-annually.",
                    effectiveDate = "2026-05-10",
                    roleRequired = "QA Officer"
                ),
                SopEntity(
                    code = "DOC-003",
                    title = "Standard Operating Procedure (SOP) Lifecycle Management",
                    department = "Documents",
                    section = "SOP",
                    objective = "To outline the workflow for drafting, reviewing, approving, distributing, and archiving Standard Operating Procedures (SOPs).",
                    scope = "All Standard Operating Procedures governing site operations.",
                    responsibility = "QA Document Control is responsible for registrar. GxP authors write the SOP.",
                    procedure = "Draft a new SOP using the official template. Assign a unique code as per department catalog.;Submit the draft to Department Heads and QA for peer review and impact assessment.;Approve the SOP via electronic or hand-signed signatures of Author, Reviewer, and Quality Assurance Approver.;Train all relevant personnel on the approved SOP. Document and file the completed training records.;Distribute the effective SOP as a watermark-controlled copy, retrieve the old revision, stamp it 'SUPERSEDED', and archive safely.",
                    safetyPrecautions = "Never distribute photocopies of SOPs without QA verification seals.",
                    frequency = "Triggered on drafting or biennial review cycle.",
                    effectiveDate = "2026-01-30",
                    roleRequired = "QA Officer"
                ),
                SopEntity(
                    code = "DOC-004",
                    title = "Site Master File (SMF) Maintenance and Update Guidelines",
                    department = "Documents",
                    section = "Regulatory",
                    objective = "To specify requirements for writing and maintaining the Site Master File (SMF) for regulatory inspections.",
                    scope = "Applicable to Site Quality Assurance and Corporate Regulatory teams.",
                    responsibility = "QA Site Manager maintains and revises document.",
                    procedure = "Maintain the SMF with description of company policy, layout diagrams, personnel structure, and equipment list.;Update the SMF annually or whenever significant modifications occur in the site facilities, equipment, or quality management systems.;Detail the validation, quality control, computerized systems, and sanitation programs within the official pages.;Submit the updated SMF to regulatory authorities during plant registration or inspection prep.",
                    safetyPrecautions = "SMF is a confidential legal document. Restrict copying and digital transfer to authorized personnel.",
                    frequency = "Annually revised.",
                    effectiveDate = "2026-03-20",
                    roleRequired = "QA Officer"
                )
            )
            
            // Map the 205 QC Articles to full SopEntity instances
            val qcDbSops = QcArticlesData.articles.map { article ->
                SopEntity(
                    code = article.code,
                    title = article.title,
                    department = "Quality Control",
                    section = article.category,
                    objective = article.objective,
                    scope = "This guideline is applicable to all standard operations and technical documentation executed in the pharmaceutical site Quality Control Division.",
                    responsibility = "Quality Control Analysts and Specialists are responsible for adhering to these compliance requirements.",
                    procedure = QcArticlesData.getArticleBody(article).replace("\n", ";"),
                    safetyPrecautions = "Always wear appropriate PPE (Safety goggles, lab coat, nitrile gloves).;Handle chemical solutions under a functional exhaust fume hood.",
                    frequency = "Biennially (Every 2 years) or after major changes.",
                    effectiveDate = "2026-06-28",
                    roleRequired = "Analyst"
                )
            }
            
            // Map the 98 new QC Articles to full SopEntity instances
            val qcNewDbSops = QcArticlesNewData.articles.map { article ->
                SopEntity(
                    code = article.code,
                    title = article.title,
                    department = "Quality Control",
                    section = article.category,
                    objective = article.objective,
                    scope = "This guideline is applicable to all standard operations and technical documentation executed in the pharmaceutical site Quality Control Division.",
                    responsibility = "Quality Control Analysts and Specialists are responsible for adhering to these compliance requirements.",
                    procedure = QcArticlesNewData.getArticleBody(article).replace("\n", ";"),
                    safetyPrecautions = "Always wear appropriate PPE (Safety goggles, lab coat, nitrile gloves).;Handle chemical solutions under a functional exhaust fume hood.",
                    frequency = "Biennially (Every 2 years) or after major changes.",
                    effectiveDate = "2026-06-28",
                    roleRequired = "Analyst"
                )
            }
            
            // Map the 125 new QA Articles to full SopEntity instances
            val qaNewDbSops = QaArticlesNewData.articles.map { article ->
                SopEntity(
                    code = article.code,
                    title = article.title,
                    department = "Quality Assurance",
                    section = article.category,
                    objective = article.objective,
                    scope = "This guideline is applicable to all standard operations and quality systems executed in the pharmaceutical site Quality Assurance Division.",
                    responsibility = "Quality Assurance Officers and Specialists are responsible for adhering to these compliance requirements.",
                    procedure = QaArticlesNewData.getArticleBody(article).replace("\n", ";"),
                    safetyPrecautions = "Never bypass any designated QMS or validation step without prior QA registration and approval.;Ensure all paper records are logged contemporaneously under GDP rules.",
                    frequency = "Biennially (Every 2 years) or after major changes.",
                    effectiveDate = "2026-06-28",
                    roleRequired = "QA Officer"
                )
            }
            
            // Map the 105 new Microbiology (Microlab) Articles to full SopEntity instances
            val microNewDbSops = MicroArticlesNewData.articles.map { article ->
                SopEntity(
                    code = article.code,
                    title = article.title,
                    department = "Microlab",
                    section = article.category,
                    objective = article.objective,
                    scope = "This guideline is applicable to all standard operations, aseptic procedures, and quality tests executed under the Microbiology Laboratory Division.",
                    responsibility = "Microbiologists and Lab Specialists are responsible for adhering to these compliance requirements.",
                    procedure = MicroArticlesNewData.getArticleBody(article).replace("\n", ";"),
                    safetyPrecautions = "Handle biohazardous waste and reference strains inside certified hoods/cabinets only.;Never bypass designated sanitization or glove prints tracking.",
                    frequency = "Biennially (Every 2 years) or after major changes.",
                    effectiveDate = "2026-06-28",
                    roleRequired = "Analyst"
                )
            }

            // Map the 180 new Production Articles to full SopEntity instances
            val productionNewDbSops = ProductionArticlesNewData.articles.map { article ->
                SopEntity(
                    code = article.code,
                    title = article.title,
                    department = "Production",
                    section = article.category,
                    objective = article.objective,
                    scope = "This guideline is applicable to all standard manufacturing steps, equipment operations, and packaging runs in the Production division.",
                    responsibility = "Operators, Engineers, and Production Supervisors are responsible for compliance.",
                    procedure = ProductionArticlesNewData.getArticleBody(article).replace("\n", ";"),
                    safetyPrecautions = "Follow Lock-Out-Tag-Out (LOTO) protocols prior to cleaning or maintenance.;Wear high-filtration respirators when handling active powder formulations.",
                    frequency = "Biennially (Every 2 years) or after major changes.",
                    effectiveDate = "2026-06-28",
                    roleRequired = "Operator"
                )
            }
            
            val allNewSops = mutableListOf<SopEntity>().apply {
                addAll(defaultSops)
                addAll(qcDbSops)
                addAll(qcNewDbSops)
                addAll(qaNewDbSops)
                addAll(microNewDbSops)
                addAll(productionNewDbSops)
                addAll(SopPrepopulationData.qaSops)
                addAll(SopPrepopulationData.microSops)
                addAll(SopPrepopulationData.productionSops)
                addAll(SopPrepopulationData.generalSops)
                addAll(PharmaSopsNewData.getSops())
                addAll(ValidationArticlesNewData.getValidationSops())
                addAll(GmpArticlesNewData.getGmpSops())
                addAll(AuditArticlesNewData.getAuditSops())
            }
            
            val distinctNewSops = allNewSops.distinctBy { it.code }.distinctBy { it.title.trim().lowercase() }
            
            val sopsToInsert = if (existingCodes.isNotEmpty()) {
                distinctNewSops.filter { it.code !in existingCodes }
            } else {
                distinctNewSops
            }
            
            if (sopsToInsert.isNotEmpty()) {
                sopDao.insertSops(sopsToInsert)
            }
    }
}
