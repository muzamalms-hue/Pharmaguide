package com.example.data

object AuditArticlesNewData {

    data class AuditSopPair(
        val title: String,
        val objective: String,
        val typeIndex: Int // 1: Self-Inspection, 2: External / Vendor Audit, 3: Regulatory Inspection, 4: Department-Specific, 5: Checklists & Templates, 6: CAPA & Oversight
    )

    private val rawAuditSops = listOf(
        // 1. Self-Inspection / Internal Audits (1 - 15)
        AuditSopPair(
            "SOP for Preparing Annual Internal Audit Calendar",
            "To outline guidelines for scheduling and distributing the site-wide annual GxP self-inspection schedule.",
            1
        ),
        AuditSopPair(
            "SOP for Selection and Qualification of Internal GxP Auditors",
            "To establish the criteria, training metrics, written tests, and certificates required to qualify internal self-inspection team members.",
            1
        ),
        AuditSopPair(
            "SOP for Execution of Internal GxP Self-Inspections",
            "To define standard timelines, tour protocols, opening/closing meetings, and audit log entries for internal audits.",
            1
        ),
        AuditSopPair(
            "SOP for Grading Internal Audit Findings and Observations",
            "To establish a clear risk-based classification system for grading observations into Critical, Major, and Minor categories.",
            1
        ),
        AuditSopPair(
            "SOP for Drafting and Circulating Internal Audit Reports",
            "To outline timelines (typically 10 working days) and review templates for distributing final self-inspection reports.",
            1
        ),
        AuditSopPair(
            "SOP for Auditing Quality Risk Management (QRM) Registers",
            "To outline the audit process for reviewing site risk assessments, failure mode logs, and risk-reduction verifications.",
            1
        ),
        AuditSopPair(
            "SOP for Auditing Site Change Control Files",
            "To define standard checks for verifying that all engineering or process changes have formal approvals and closed actions.",
            1
        ),
        AuditSopPair(
            "SOP for Auditing Site Deviation and Incident Logs",
            "To establish auditing protocols for verifying timely closure, proper root-cause analyses, and repeat-occurrence checks on deviations.",
            1
        ),
        AuditSopPair(
            "SOP for Auditing Annual Product Quality Reviews (APQR)",
            "To outline verifying statistical validations, stability profiles, and regulatory compliance reviews in completed APQRs.",
            1
        ),
        AuditSopPair(
            "SOP for Auditing Out-of-Specification (OOS) Investigations",
            "To define check parameters for verifying that Phase I and Phase II laboratory OOS audits are fully detailed and justified.",
            1
        ),
        AuditSopPair(
            "SOP for Auditing Out-of-Trend (OOT) Investigation Reports",
            "To establish audit verification steps for reviewing statistical drift analyses and preventive adjustments.",
            1
        ),
        AuditSopPair(
            "SOP for Mock Internal Audits and GxP Simulation Exercises",
            "To outline the process for conducting surprise mock-inspections to assess actual daily compliance in production areas.",
            1
        ),
        AuditSopPair(
            "SOP for Auditing Personnel GxP Training Files",
            "To define verifying that current job descriptions, curriculum logs, and annual re-qualifications are up to date.",
            1
        ),
        AuditSopPair(
            "SOP for Auditing Site Pest Control and Bait Station Registers",
            "To establish inspection guidelines for verifying pest map updates, chemical contracts, and bait inspection logs.",
            1
        ),
        AuditSopPair(
            "SOP for Auditing GxP Document Vault Access and Card Registries",
            "To outline auditing access logs, card permission groups, and fire protection tests for the document control archive.",
            1
        ),

        // 2. External / Vendor Audits (16 - 30)
        AuditSopPair(
            "SOP for GxP Vendor Qualification and Re-evaluation Audits",
            "To outline questionnaires, test lot qualifications, and scoring rules for adding or retaining suppliers on the AVL.",
            2
        ),
        AuditSopPair(
            "SOP for Conducting On-site Audits of Active Pharmaceutical Ingredient (API) Manufacturers",
            "To define audit checklists, raw synthetic path trace reviews, and crystallization block checks at API supplier plants.",
            2
        ),
        AuditSopPair(
            "SOP for Auditing Contract Packaging and Label Printing Vendors",
            "To establish audits for printing plate security, copy control, mix-up preventions, and electronic barcode verification systems.",
            2
        ),
        AuditSopPair(
            "SOP for Auditing Contract Research Organizations (CRO) for Bioequivalence Studies",
            "To define auditing clinical data logs, subject informed-consent files, and sample bio-analytical validation runs at CROs.",
            2
        ),
        AuditSopPair(
            "SOP for Auditing Third-Party Cold-Chain Logistics and 3PL Providers",
            "To establish temperature mapping audits of transport trucks, backup power checks, and transit alarms review.",
            2
        ),
        AuditSopPair(
            "SOP for Auditing Third-Party Calibration and Testing Labs",
            "To outline verification checklists for vendor master standard tracebacks, analyst certifications, and raw test logs.",
            2
        ),
        AuditSopPair(
            "SOP for Supplier Technical Quality Agreement Reviews during Audits",
            "To establish checking the technical boundary files, dispute processes, and notification periods in active vendor agreements.",
            2
        ),
        AuditSopPair(
            "SOP for Auditing Raw Material Primary Excipient Manufacturers",
            "To define audit steps for raw starch, lactose, or microcrystalline cellulose production plants.",
            2
        ),
        AuditSopPair(
            "SOP for Auditing Primary Sterile Glass Vial and Ampoule Manufacturers",
            "To outline auditing glass-annealing ovens, particulate washes, camera checks, and hydrolytic resistance test logs.",
            2
        ),
        AuditSopPair(
            "SOP for Auditing Secondary Carton and Foil Packaging Suppliers",
            "To establish audits for print ink selections, line clearance validations, and text-proofing verifications at box manufacturers.",
            2
        ),
        AuditSopPair(
            "SOP for Issuing Supplier Corrective Action Requests (SCAR) Post Audit",
            "To define standard rules, response timelines (typically 30 days), and closure verify steps for SCAR forms.",
            2
        ),
        AuditSopPair(
            "SOP for Managing the Site Approved Vendor List (AVL) Database",
            "To outline entries, classifications, holding tags, and formal removals of vendor profiles based on audit scores.",
            2
        ),
        AuditSopPair(
            "SOP for Pre-Audit Questionnaires for New Raw Material Suppliers",
            "To establish standard layouts, regulatory certificate collections, and initial risk grading prior to physical audits.",
            2
        ),
        AuditSopPair(
            "SOP for Auditing Third-Party Toxic Waste Incineration Plants",
            "To define environmental compliance checklists, destruction logs reviews, and trace transport manifest audits.",
            2
        ),
        AuditSopPair(
            "SOP for Auditing Contract Manufacturing Organizations (CMO) for Sterile Dosage Blocks",
            "To establish detailed cleanroom gowning reviews, media fill results trace, and autoclave validation audits at sterile CMOs.",
            2
        ),

        // 3. Regulatory Inspections (31 - 42)
        AuditSopPair(
            "SOP for Preparing and Coordinating Regulatory GxP Inspections",
            "To establish the front room, back room, document scribe roles, and team assignments for regulatory inspections.",
            3
        ),
        AuditSopPair(
            "SOP for Managing the Regulatory Inspection Host Room (Front Room)",
            "To define rules for receiving inspectors, speaking protocols, managing questions, and presenting requested items.",
            3
        ),
        AuditSopPair(
            "SOP for Coordinating the Document Control War Room (Back Room)",
            "To outline document retrieval tracking, reviewing files before transfer, and double-witnessing balance copies.",
            3
        ),
        AuditSopPair(
            "SOP for Scribes and Note-Takers during GxP Audits",
            "To establish real-time recording of auditor questions, comments, physical areas visited, and documents requested.",
            3
        ),
        AuditSopPair(
            "SOP for Handling FDA Form 483 Observations and Warning Letters",
            "To outline assembling root-cause investigations and writing official response files within 15 working days.",
            3
        ),
        AuditSopPair(
            "SOP for Post-Inspection Site De-briefing Meetings",
            "To define compiling all audit scribe logs, identifying immediate fix items, and organizing immediate CAPA actions.",
            3
        ),
        AuditSopPair(
            "SOP for Annual Regulatory Inspection Readiness Mock Drills",
            "To establish site-wide mock exercises with external consultants to assess physical areas, staff answers, and response times.",
            3
        ),
        AuditSopPair(
            "SOP for Maintaining the Site Master File (SMF)",
            "To outline annual reviews, format guidelines, and updates of the SMF for regulatory inspections.",
            3
        ),
        AuditSopPair(
            "SOP for Presenting Out-of-Specification (OOS) Logs to Auditors",
            "To define standard presentation folders containing phase logs, hypothesis files, and retest raw data for smooth reviews.",
            3
        ),
        AuditSopPair(
            "SOP for Speaking to Regulatory Auditors during Inspections",
            "To establish guidelines for personnel answers: be clear, answer truthfully, do not speculate, and present only facts.",
            3
        ),
        AuditSopPair(
            "SOP for Handling Photographically Documented Audit Findings",
            "To outline rules for capturing matching photographs when an auditor photographs site areas during inspections.",
            3
        ),
        AuditSopPair(
            "SOP for Handling Regulatory Sample Collections and Split Samples",
            "To establish split-sampling, capturing identical lots, and concurrent laboratory testing of samples taken by inspectors.",
            3
        ),

        // 4. Department-Specific Audits (43 - 57)
        AuditSopPair(
            "SOP for Auditing the Raw Material Dispensing Area",
            "To outline checks for scale calibrations, reverse airflows under RLAF, cleaning logs, and cleanroom cross-pressures.",
            4
        ),
        AuditSopPair(
            "SOP for Auditing Tablet Compression Suites",
            "To define checking die-table cleanliness, scraper blades integrity, weight check logs, and metal detector reject tests.",
            4
        ),
        AuditSopPair(
            "SOP for Auditing Film Coating Operations",
            "To establish audits for gun distances, spray-rate logs, exhaust temperature maps, and coating solution trace checks.",
            4
        ),
        AuditSopPair(
            "SOP for Auditing Capsule Filling Cleanrooms",
            "To outline checking dosing disks, tamping pin heights, empty capsule lot checks, and capsule weight-variance logs.",
            4
        ),
        AuditSopPair(
            "SOP for Auditing Liquid Syrup Mixing and Filling Lines",
            "To define sugar-melting temperature logs, mixing speed charts, filling pump nozzle flushes, and torque checks.",
            4
        ),
        AuditSopPair(
            "SOP for Auditing Sterile Aseptic Filling Suites (Grade A/B)",
            "To establish detailed gowning reviews, continuous particle monitor trails, and gloves leak test audits.",
            4
        ),
        AuditSopPair(
            "SOP for Auditing Quality Control Analytical Instrumentation",
            "To outline checking HPLC/GC system suitability logs, columns lifetime, and calibration stickers.",
            4
        ),
        AuditSopPair(
            "SOP for Auditing Microbiology Testing Laboratories",
            "To define audits for growth promotion logs, reference strain passage counts, and biosafety cabinet flow maps.",
            4
        ),
        AuditSopPair(
            "SOP for Auditing Computerized Chromatography Data Systems (CDS)",
            "To establish audits for user privilege groups, password expirations, electronic signatures, and audit trail records.",
            4
        ),
        AuditSopPair(
            "SOP for Auditing Purified Water (PW) and WFI Utility Blocks",
            "To outline checkups of temperature charts, loop pressure sensors, TOC readouts, and UV lamp sanitization logs.",
            4
        ),
        AuditSopPair(
            "SOP for Auditing Cleanroom HVAC Airflow Mapping and HEPA Logs",
            "To establish audits for PAO filter leak scans, differential pressure cascades, and air change rates (ACPH).",
            4
        ),
        AuditSopPair(
            "SOP for Auditing Engineering Preventive Maintenance (PM) Records",
            "To define checking completed PM tickets against schedules, calibration standards, and parts inventory.",
            4
        ),
        AuditSopPair(
            "SOP for Auditing Warehouse Material Storage and Cold-Rooms",
            "To outline checking multi-point temperature maps, quarantine gates, inventory database logs, and picking balances.",
            4
        ),
        AuditSopPair(
            "SOP for Auditing Laboratory Glassware Calibration Programs",
            "To establish check parameters for weight-of-water calibrations, certificate files, and acid washes of volumetric flasks.",
            4
        ),
        AuditSopPair(
            "SOP for Auditing Electronic Batch Manufacturing Records (eBMR) Systems",
            "To define audits for data capture, transaction locks, electronic signatures, and eBMR supervisor approvals.",
            4
        ),

        // 5. Checklists and Templates (58 - 70)
        AuditSopPair(
            "Audit Checklist for Analytical Solution Standardization Records",
            "To provide a standard checklist for reviewing laboratory primary standards, factor calculations, and expiration dates.",
            5
        ),
        AuditSopPair(
            "Audit Checklist for Stability Chambers and Chamber Mapping",
            "To establish a checklist for auditing stability rooms, backup cooler controllers, and multi-point sensor maps.",
            5
        ),
        AuditSopPair(
            "Audit Checklist for Cleaning Validation Swab and Rinse Recovery Studies",
            "To outline checking recovery factor calculations, coupon spiking logs, and active residue HPLC method linkages.",
            5
        ),
        AuditSopPair(
            "Audit Checklist for Media Fill Simulation Runs and Incubation Logs",
            "To define checklists for auditing media prep logs, line setup, visual inspection counts, and incubator charts.",
            5
        ),
        AuditSopPair(
            "Audit Checklist for Environmental Monitoring Settle and Active Plates",
            "To provide a checklist for reviewing air sample logs, settle plate maps, operator glove dab logs, and micro-limits.",
            5
        ),
        AuditSopPair(
            "Audit Checklist for Customer Complaint Files and Root-Cause Files",
            "To establish a review checklist for complaints logs, retained counter-sample tests, and corrective client responses.",
            5
        ),
        AuditSopPair(
            "Audit Checklist for Product Recall Reports and Simulation Logs",
            "To outline checking mock-recall lot tracing, distribution database audits, and reconcile math worksheets.",
            5
        ),
        AuditSopPair(
            "Audit Checklist for Laboratory Reference Standards Controls",
            "To define standard checks for reference vial freezer logs, opening dates, working standards, and vendor certs.",
            5
        ),
        AuditSopPair(
            "Audit Checklist for Site Pest Control Bait Station Maps",
            "To establish checks for verifying bait placements against plans, insect trap count logs, and contract certifications.",
            5
        ),
        AuditSopPair(
            "Audit Checklist for Master Signature Registers and Logs",
            "To provide a checklist for auditing site-wide handwritten signature records, initial templates, and digitization databases.",
            5
        ),
        AuditSopPair(
            "Audit Checklist for GAMP 5 Software Risk Assessment Logs",
            "To establish reviewing computer software risk classifications, failure mode guides, and quality controls verification.",
            5
        ),
        AuditSopPair(
            "Audit Checklist for Sterile Steam Autoclave Cycle Reports",
            "To outline checking autoclave cycle prints, biological indicators, heat penetration charts, and thermocouple calibrations.",
            5
        ),
        AuditSopPair(
            "Audit Checklist for Compressed Nitrogen Gas Purity Records",
            "To define checks for reviewing moisture logs, oxygen trace readouts, and line particulate counts.",
            5
        ),

        // 6. CAPA and Audit Oversight (71 - 82)
        AuditSopPair(
            "SOP for Creating and Tracking Audit CAPA Plans",
            "To establish the logging, tracking, coordinating, and effectiveness reviews of CAPAs resulting from audits.",
            6
        ),
        AuditSopPair(
            "SOP for Escalation of Overdue Audit Responses and CAPA Items",
            "To define escalation paths (to Department Head, Site Quality Head, and CEO) for delayed audit action items.",
            6
        ),
        AuditSopPair(
            "SOP for Verifying Effectiveness of Closed CAPA Actions",
            "To outline guidelines for retrospective checks to confirm that implemented CAPA steps actually resolved the root cause.",
            6
        ),
        AuditSopPair(
            "SOP for Preparation of Audit Trend Reports for Management Reviews",
            "To establish compiling quarterly audit findings, top 10 observation trends, and outstanding CAPA statistics into QMR reports.",
            6
        ),
        AuditSopPair(
            "SOP for Hosting and Managing Customer Audits",
            "To outline coordinating logistics, presenting requested documents, and responding to observation letters from clients.",
            6
        ),
        AuditSopPair(
            "SOP for Annual GxP Compliance Self-Assessment Reports",
            "To define compiling all site self-inspection logs, supplier audit scores, and regulatory updates into an annual report.",
            6
        ),
        AuditSopPair(
            "SOP for Site Quality Council Meetings and Audit Oversight",
            "To establish monthly council reviews of site compliance, pending audit actions, and regulatory inspection updates.",
            6
        ),
        AuditSopPair(
            "SOP for Managing Corrective Actions for Repeat Audit Observations",
            "To outline detailed root-cause re-investigations and procedural updates when an audit finding occurs repeatedly.",
            6
        ),
        AuditSopPair(
            "SOP for Documenting and Archiving Completed Audit Binders",
            "To establish standard methods for filing all scribe notes, requests, presented files, and final audit reports.",
            6
        ),
        AuditSopPair(
            "SOP for Tracking SCAR (Supplier CAPA) Commitments and Verification",
            "To outline checking on-site vendor updates or reviewing proof documents to verify vendor CAPA compliance.",
            6
        ),
        AuditSopPair(
            "SOP for Auditing Toxic Waste Disposal and Hazardous Material Registers",
            "To define checking waste manifest receipts, transport truck weights, and chemical neutralization log verifications.",
            6
        ),
        AuditSopPair(
            "SOP for Audit Closing Presentation and Exit Protocols",
            "To outline standard presentation formats, summarizing findings, and setting feedback agreements at audit completion.",
            6
        )
    )

    fun getAuditSops(): List<SopEntity> {
        return rawAuditSops.mapIndexed { index, pair ->
            val codeStr = String.format("AUD-%03d", index + 4) // Start from AUD-004 onwards (001, 002, 003 are pre-existing)
            
            val (dept, cat, role) = when (pair.typeIndex) {
                1 -> Triple("Audit", "Self-Inspection", "Internal Auditor")
                2 -> Triple("Audit", "External & Vendor Audit", "Lead Vendor Auditor")
                3 -> Triple("Audit", "Regulatory Inspection", "Regulatory Liaison")
                4 -> Triple("Audit", "Department-Specific Audit", "QA Auditor")
                5 -> Triple("Audit", "Audit Checklists & Templates", "Audit Coordinator")
                6 -> Triple("Audit", "CAPA & Quality Oversight", "Quality Compliance Manager")
                else -> Triple("Audit", "General Audit", "QA Officer")
            }

            // High-quality domain-specific procedures
            val procedureSteps = when (pair.typeIndex) {
                1 -> "Establish the scope and schedule of the internal audit by consulting the approved Annual Audit Calendar.;Prepare audit checklists matching the target GxP regulations (GMP/GLP/GDP).;Conduct an opening meeting with area heads to confirm timelines and agenda.;Perform physical tours, review records contemporaneously, and log all findings on observation sheets.;Hold a closing meeting to present draft observations and agree on tentative correction timelines."
                2 -> "Initiate vendor audit requests based on supplier risk ratings or AVL expiry schedules.;Compile pre-audit questionnaires and regulatory certificates from the supplier.;Form the audit panel and draft a detailed agenda highlighting critical focus areas.;Perform on-site inspections of crystallization blocks, cleanroom loops, and chromatography logs.;Write a comprehensive vendor audit report within 15 days and issue SCARs for any major observations."
                3 -> "Immediately alert the Site Quality Head and activate the pre-assigned Front/Back room teams.;Set up the host room, verify all scribe computers, and check document retriever links.;Welcome the inspectors, conduct initial site presentations, and assign primary guides.;Review all requested records in the War Room before transferring them to the front room.;Note every inspector question and split all physical samples taken concurrently."
                4 -> "Confirm that the target department's active instruments carry valid calibration tags.;Review area logbooks for contemporaneous signatures, complete data logs, and correct corrections.;Inspect physical spaces for cleanliness, logical material flows, and proper labeling.;Cross-reference completed batch records with master formulation requirements.;Compile findings into a department-specific report and submit to the QA manager."
                5 -> "Obtain the required checklist template corresponding to the system being audited.;Inspect raw logs, calibration files, and system parameter readouts against checklist prompts.;Check for compliance indicators such as NIST traceback certs and standardized factors.;Verify that any deviations or out-of-limit entries are correctly flagged and cross-referenced.;Attach copy proofs for any negative findings and submit the checklist to the audit file."
                6 -> "Log all formal audit findings and observations inside the CAPA database within 48 hours.;Co-operate with department heads to conduct fishbone analyses and draft target CAPAs.;Track CAPA progress metrics and update the Quality Council dashboard monthly.;Perform physical verifications or review records after 6 months to assess CAPA effectiveness.;Archive completed audit binders with all scribe logs and report files inside the GxP document vault."
                else -> "Draft standard audit protocol specifying requirements and testing goals.;Verify pre-requisite conditions and ensure all safety instructions are reviewed.;Execute steps sequentially and record results on approved sheets immediately.;Check limits and flag any out-of-limit observation to the supervisor.;Compile findings, write summary recommendations, and sign off the record.;Submit files to Quality Assurance for formal documentation and archiving."
            }

            SopEntity(
                code = codeStr,
                title = pair.title,
                department = dept,
                section = cat,
                objective = pair.objective,
                scope = "This audit protocol is applicable to all compliance evaluations, checklists, and inspections conducted within the $cat scope under GxP regulations.",
                responsibility = "The $role is responsible for performing the audits or checklists, the Audit Manager for reviewing results, and Quality Assurance for final oversight and approval.",
                procedure = procedureSteps,
                safetyPrecautions = "Always wear standard cleanroom gowns and personal protective equipment (PPE) matching the area under audit.;Follow site safety instructions when touring machinery or raw chemical vaults.",
                frequency = "Annually or as specified by the Approved Internal Audit Calendar.",
                effectiveDate = "2026-06-28",
                roleRequired = "QA Officer"
            )
        }
    }
}
