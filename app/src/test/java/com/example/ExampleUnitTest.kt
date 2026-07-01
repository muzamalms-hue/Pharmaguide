package com.example

import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File
import java.io.FileNotFoundException

class ExampleUnitTest {
  @Test
  fun addition_isCorrect() {
    assertEquals(4, 2 + 2)
  }

  @Test
  fun compareAndUpdateDMonographs() {
    val rawList = listOf(
      "Dacarbazine for Injection",
      "Dacarbazine",
      "Dactinomycin for Injection",
      "Dactinomycin",
      "Dalfampridine",
      "Delteparin Sodium",
      "Danazol Capsules",
      "Danazol",
      "Dantrolene Sodium Capsules",
      "Dantrolene Sodium for Injection",
      "Dantrolene Sodium",
      "Dapagliflozin Propanediol",
      "Dapsone Compounded Oral Suspension",
      "Dapsone Tablets",
      "Dapsone",
      "Daunorubicin Hydrochloride for Injection",
      "Daunorubicin Hydrochloride",
      "Decoquinate Type A Medicated Article",
      "Decoquinate",
      "Deferoxamine Mesylate for Injection",
      "Deferoxamine Mesylate",
      "Dehydrated Alcohol Injection",
      "Dehydrated Alcohol USP",
      "Dehydrocholic Acid",
      "Demecarium Bromide",
      "Demeclocycline Hydrochloride Tablets",
      "Demeclocycline Hydrochloride",
      "Deoxycholic Acid",
      "Desflurane",
      "Desipramine Hydrochloride Tablets",
      "Desipramine Hydrochloride",
      "Desloratadine Orally Disintegrating Tablets",
      "Desloratadine Tablets",
      "Desloratadine",
      "Desmopressin Acetate Injection",
      "Desmopressin Acetate",
      "Desmopressin Nasal Spray Solution",
      "Desogestrel and Ethinyl Estradiol Tablets",
      "Desogestrel",
      "Desonide",
      "Desoximetasone Cream",
      "Desoximetasone Gel",
      "Desoximetasone Ointment",
      "Desoximetasone",
      "Desoxycorticosterone Pivalate Injectable Suspension",
      "Desoxycorticosterone Pivalate",
      "Desvenlafaxine Fumarate",
      "Desvenlafaxine Succinate",
      "Desvenlafaxine",
      "Dexamethasone Acetate Injectable Suspension",
      "Dexamethasone Acetate",
      "Dexamethasone Compounded Oral Suspension",
      "Dexamethasone Elixir",
      "Dexamethasone Injection",
      "Dexamethasone Ophthalmic Suspension",
      "Dexamethasone Oral Solution",
      "Dexamethasone Sodium Phosphate Compounded Injection",
      "Dexamethasone Sodium Phosphate Injection",
      "Dexamethasone Sodium Phosphate Ophthalmic Solution",
      "Dexamethasone Sodium Phosphate",
      "Dexamethasone Tablets",
      "Dexamethasone",
      "Dexbrompheniramine Maleate and Pseudoephedrine Sulfate Oral Solution",
      "Dexbrompheniramine Maleate",
      "Dexchlorpheniramine Maleate Oral Solution",
      "Dexchlorpheniramine Maleate Tablets",
      "Dexchlorpheniramine Maleate",
      "Dexmedetomidine Hydrochloride",
      "Dexmedetomidine Injection",
      "Dexpanthenol Preparation",
      "Dexpanthenol",
      "Dextran 1",
      "Dextran 40 in Dextrose Injection",
      "Dextran 40 in Sodium Chloride Injection",
      "Dextran 40",
      "Dextran 70 in Dextrose Injection",
      "Dextran 70 in Sodium Chloride Injection",
      "Dextran 70",
      "Dextroamphetamine Sulfate Tablets",
      "Dextroamphetamine Sulfate",
      "Dextromethorphan Hydrobromide Oral Solution",
      "Dextromethorphan Hydrobromide",
      "Dextromethorphan",
      "Dextrose and Sodium Chloride Injection",
      "Dextrose Injection",
      "Dextrose",
      "Diatrizoate Meglumine and Diatrizoate Sodium Injection",
      "Diatrizoate Meglumine and Diatrizoate Sodium Solution",
      "Diatrizoate Meglumine Injection",
      "Diatrizoate Meglumine",
      "Diatrizoate Sodium Injection",
      "Diatrizoate Sodium Solution",
      "Diatrizoate Sodium",
      "Diatrizoic Acid",
      "Diazepam Injection",
      "Diazepam Tablets",
      "Diazepam",
      "Diazoxide Oral Suspension",
      "Diazoxide",
      "Dibasic Calcium Phosphate Dihydrate",
      "Dibasic Calcium Phosphate Tablets",
      "Dibasic Potassium Phosphate",
      "Dibasic Sodium Phosphate",
      "Dibucaine Cream",
      "Dibucaine Hydrochloride Injection",
      "Dibucaine Hydrochloride",
      "Dibucaine Ointment",
      "Dibucaine",
      "Dichlorphenamide Tablets",
      "Dichlorphenamide",
      "Diclazuril",
      "Diclofenac Potassium for Oral Solution",
      "Diclofenac Potassium Tablets",
      "Diclofenac Potassium",
      "Diclofenac Sodium and Misoprostol Delayed-Release Tablets",
      "Diclofenac Sodium Delayed-Release Tablets",
      "Diclofenac Sodium Extended-Release Tablets",
      "Diclofenac Sodium Topical Solution",
      "Diclofenac Sodium",
      "Dicloxacillin Sodium Capsules",
      "Dicloxacillin Sodium",
      "Dicyclomine Hydrochloride Capsules",
      "Dicyclomine Hydrochloride Injection",
      "Dicyclomine Hydrochloride Oral Solution",
      "Dicyclomine Hydrochloride Tablets",
      "Dicyclomine Hydrochloride",
      "Didanosine Delayed-Release Capsules",
      "Didanosine for Oral Solution",
      "Didanosine",
      "Diethylcarbamazine Citrate Tablets",
      "Diethylcarbamazine Citrate",
      "Diethylpropion Hydrochloride Tablets",
      "Diethylpropion Hydrochloride",
      "Diethylstilbestrol",
      "Diethyltoluamide Topical Solution",
      "Diethyltoluamide",
      "Diflorasone Diacetate Cream",
      "Diflorasone Diacetate Ointment",
      "Diflorasone Diacetate",
      "Diflunisal Tablets",
      "Diflunisal",
      "Digitoxin Injection",
      "Digitoxin Tablets",
      "Digitoxin",
      "Digoxin Injection",
      "Digoxin Oral Solution",
      "Digoxin Tablets",
      "Digoxin",
      "Dihydrocodeine Bitartrate",
      "Dihydroergotamine Mesylate Injection",
      "Dihydroergotamine Mesylate",
      "Dihydrostreptomycin Injection",
      "Dihydrostreptomycin Sulfate Boluses",
      "Dihydrostreptomycin Sulfate",
      "Dihydroxyacetone",
      "Dihydroxyaluminum Aminoacetate Magma",
      "Dihydroxyaluminum Aminoacetate",
      "Dihydroxyaluminum Sodium Carbonate Chewable Tablets",
      "Dihydroxyaluminum Sodium Carbonate",
      "Diloxanide Furoate",
      "Diltiazem Hydrochloride Compounded Cream",
      "Diltiazem Hydrochloride Compounded Oral Solution",
      "Diltiazem Hydrochloride Compounded Oral Suspension",
      "Diltiazem Hydrochloride Extended-Release Capsules",
      "Diltiazem Hydrochloride Tablets",
      "Diltiazem Hydrochloride",
      "Diluted Isosorbide Dinitrate",
      "Diluted Isosorbide Mononitrate",
      "Diluted Nitroglycerin",
      "Dimenhydrinate Injection",
      "Dimenhydrinate Oral Solution",
      "Dimenhydrinate Tablets",
      "Dimenhydrinate",
      "Dimercaprol Injection",
      "Dimercaprol",
      "Dimethyl Fumarate Delayed-Release Capsules",
      "Dimethyl Fumarate",
      "Dimethyl Sulfoxide Gel",
      "Dimethyl Sulfoxide Irrigation",
      "Dimethyl Sulfoxide Topical Solution",
      "Dimethyl Sulfoxide",
      "Dinoprost Tromethamine Injection",
      "Dinoprost Tromethamine",
      "Dinoprostone",
      "Dioxybenzone and Oxybenzone Cream",
      "Dioxybenzone",
      "Diphenhydramine and Phenylephrine Hydrochlorides Tablets",
      "Diphenhydramine and Pseudoephedrine Capsules",
      "Diphenhydramine Citrate and Ibuprofen Tablets",
      "Diphenhydramine Citrate",
      "Diphenhydramine Hydrochloride and Ibuprofen Capsules",
      "Diphenhydramine Hydrochloride Capsules",
      "Diphenhydramine Hydrochloride Injection",
      "Diphenhydramine Hydrochloride Oral Powder",
      "Diphenhydramine Hydrochloride Oral Solution",
      "Diphenhydramine Hydrochloride",
      "Diphenoxylate Hydrochloride and Atropine Sulfate Oral Solution",
      "Diphenoxylate Hydrochloride and Atropine Sulfate Tablets",
      "Diphenoxylate Hydrochloride",
      "Dipivefrin Hydrochloride",
      "Dipyridamole Compounded Oral Suspension",
      "Dipyridamole Injection",
      "Dipyridamole Tablets",
      "Dipyridamole",
      "Disopyramide Phosphate Capsules",
      "Disopyramide Phosphate Extended-Release Capsules",
      "Disopyramide Phosphate",
      "Disulfiram Tablets",
      "Disulfiram",
      "Divalproex Sodium Delayed-Release Capsules",
      "Divalproex Sodium Delayed-Release Tablets",
      "Divalproex Sodium Extended-Release Tablets",
      "Divalproex Sodium",
      "Dobutamine for Injection",
      "Dobutamine Hydrochloride",
      "Dobutamine in Dextrose Injection",
      "Dobutamine Injection",
      "Docetaxel Injection",
      "Docetaxel",
      "Docusate Calcium Capsules",
      "Docusate Calcium",
      "Docusate Potassium Capsules",
      "Docusate Potassium",
      "Docusate Sodium Capsules",
      "Docusate Sodium Solution",
      "Docusate Sodium Syrup",
      "Docusate Sodium Tablets",
      "Docusate Sodium",
      "Dofetilide",
      "Dolasetron Mesylate Compounded Oral Solution",
      "Dolasetron Mesylate Compounded Oral Suspension",
      "Dolasetron Mesylate",
      "Donepezil Hydrochloride Orally Disintegrating Tablets",
      "Donepezil Hydrochloride Tablets",
      "Donepezil Hydrochloride",
      "Dopamine Hydrochloride and Dextrose Injection",
      "Dopamine Hydrochloride Injection",
      "Dopamine Hydrochloride",
      "Dorzolamide Hydrochloride and Timolol Maleate Ophthalmic Solution",
      "Dorzolamide Hydrochloride Ophthalmic Solution",
      "Dorzolamide Hydrochloride",
      "Doxapram Hydrochloride Injection",
      "Doxapram Hydrochloride",
      "Doxazosin Mesylate",
      "Doxazosin Tablets",
      "Doxepin Hydrochloride Capsules",
      "Doxepin Hydrochloride Oral Solution",
      "Doxepin Hydrochloride",
      "Doxercalciferol",
      "Doxorubicin Hydrochloride for Injection",
      "Doxorubicin Hydrochloride Injection",
      "Doxorubicin Hydrochloride",
      "Doxycycline Calcium Oral Suspension",
      "Doxycycline Capsules",
      "Doxycycline Compounded Oral Suspension, Veterinary",
      "Doxycycline for Injection",
      "Doxycycline for Oral Suspension",
      "Doxycycline Hyclate Capsules",
      "Doxycycline Hyclate Delayed-Release Capsules",
      "Doxycycline Hyclate Delayed-Release Tablets",
      "Doxycycline Hyclate Tablets",
      "Doxycycline Hyclate",
      "Doxycycline Tablets",
      "Doxycycline",
      "Doxylamine Succinate Oral Solution",
      "Doxylamine Succinate Tablets",
      "Doxylamine Succinate",
      "Dried Aluminum Hydroxide Gel Capsules",
      "Dried Aluminum Hydroxide Gel Tablets",
      "Dried Aluminum Hydroxide Gel",
      "Dried Ferrous Sulfate",
      "Dronabinol Capsules",
      "Dronabinol",
      "Dronedarone Hydrochloride",
      "Dronedarone Tablets",
      "Droperidol Injection",
      "Droperidol",
      "Drospirenone and Ethinyl Estradiol Tablets",
      "Drospirenone",
      "Duloxetine Delayed-Release Capsules",
      "Duloxetine Hydrochloride",
      "Dutasteride and Tamsulosin Hydrochloride Capsules",
      "Dutasteride",
      "Dyclonine Hydrochloride Gel",
      "Dyclonine Hydrochloride Topical Solution",
      "Dyclonine Hydrochloride",
      "Dydrogesterone Tablets",
      "Dydrogesterone",
      "Dyphylline and Guaifenesin Oral Solution",
      "Dyphylline and Guaifenesin Tablets",
      "Dyphylline"
    )

    println("Total input items from user: ${rawList.size}")

    // Dynamic file path setup
    val userDir = System.getProperty("user.dir")
    var file: File? = null
    val pathsToCheck = listOf(
      "src/main/java/com/example/data/UspMonographData.kt",
      "app/src/main/java/com/example/data/UspMonographData.kt",
      "../src/main/java/com/example/data/UspMonographData.kt",
      "../app/src/main/java/com/example/data/UspMonographData.kt"
    )
    for (p in pathsToCheck) {
      val f = File(p)
      if (f.exists()) { file = f; break }
      val absF = File(userDir, p)
      if (absF.exists()) { file = absF; break }
    }
    if (file == null) {
      val searchRoot = File(userDir).parentFile ?: File(userDir)
      val foundFiles = searchRoot.walkTopDown().filter { it.name == "UspMonographData.kt" }.toList()
      if (foundFiles.isNotEmpty()) { file = foundFiles.first() }
    }
    if (file == null) {
      throw FileNotFoundException("Could not locate UspMonographData.kt in workspace.")
    }

    val fileText = file.readText()
    val rawDataStartPattern = "private val rawMonographData = \"\"\""
    val rawDataStart = fileText.indexOf(rawDataStartPattern)
    val rawDataEndPattern = "\"\"\".trimIndent()"
    val rawDataEnd = fileText.indexOf(rawDataEndPattern, rawDataStart)
    val rawData = fileText.substring(rawDataStart + rawDataStartPattern.length, rawDataEnd)

    // Lines of raw monograph data
    val rawDataLines = rawData.split('\n')

    // Separate other lines (A, B, C, E, etc.)
    val nonDLinesBefore = mutableListOf<String>()
    val nonDLinesAfter = mutableListOf<String>()
    val existingDLines = mutableMapOf<String, String>()

    var encounteredD = false
    var finishedD = false

    for (line in rawDataLines) {
      val trimmed = line.trim()
      if (trimmed.isEmpty()) continue
      val firstChar = trimmed[0]
      if (firstChar == 'D') {
        encounteredD = true
        val key = trimmed.split('|')[0].trim().uppercase()
        existingDLines[key] = line // Store the full original formatted line
      } else {
        if (!encounteredD) {
          nonDLinesBefore.add(line)
        } else {
          finishedD = true
          nonDLinesAfter.add(line)
        }
      }
    }

    println("Total existing 'D' monographs: ${existingDLines.size}")

    // Now, let's build the final collection of D lines
    val finalDLinesMap = mutableMapOf<String, String>()

    // Start with all existing D lines to preserve their detailed HPLC column info if they have any
    finalDLinesMap.putAll(existingDLines)

    val addedItems = mutableListOf<String>()
    // Add all missing D lines from the input list (only if not already present)
    for (name in rawList) {
      val key = name.uppercase()
      if (!finalDLinesMap.containsKey(key)) {
        val (active, form) = getActiveAndForm(name)
        finalDLinesMap[key] = "        $key|$active|$form"
        addedItems.add(name)
      }
    }

    // Sort all combined D lines alphabetically by their key
    val sortedDLines = finalDLinesMap.entries.sortedBy { it.key }.map { entry ->
      val line = entry.value
      val trimmedLine = line.trim()
      "        $trimmedLine"
    }

    // Combine everything back together
    val newRawDataContent = buildString {
      append("\n")
      nonDLinesBefore.forEach { append(it).append("\n") }
      sortedDLines.forEach { append(it).append("\n") }
      nonDLinesAfter.forEach { append(it).append("\n") }
      append("    ") // alignment for closing triple quote
    }

    val updatedFileText = fileText.substring(0, rawDataStart + rawDataStartPattern.length) +
        newRawDataContent +
        fileText.substring(rawDataEnd)

    file.writeText(updatedFileText)
    
    println("--- SUMMARY OF THE MERGE ---")
    println("Total input items from user's D list: ${rawList.size}")
    println("Existing 'D' monographs in database before merge: ${existingDLines.size}")
    println("Newly added 'D' monographs: ${addedItems.size}")
    println("Total 'D' monographs in database after merge: ${sortedDLines.size}")
    println("Added items list: $addedItems")
    println("Successfully merged and updated UspMonographData.kt!")
  }

  @Test
  fun compareAndUpdateEMonographs() {
    val rawList = listOf(
      "Ecamsule Solution",
      "Echothiophate Iodide for Ophthalmic Solution",
      "Echothiophate Iodide",
      "Econazole Nitrate",
      "Edetate Calcium Disodium Injection",
      "Edetate Calcium Disodium",
      "Edetate Disodium Compounded Ophthalmic Solution",
      "Edetate Disodium Injection",
      "Edetate Disodium",
      "Edrophonium Chloride Injection",
      "Edrophonium Chloride",
      "Efavirenz Capsules",
      "Efavirenz Tablets",
      "Efavirenz",
      "Elm",
      "Emtricitabine",
      "Enalapril Maleate and Hydrochlorothiazide Tablets",
      "Enalapril Maleate Compounded Oral Suspension, Veterinary",
      "Enalapril Maleate Compounded Oral Suspension",
      "Enalapril Maleate Tablets",
      "Enalapril Maleate",
      "Enalaprilat Injection",
      "Enalaprilat",
      "Endotoxin Indicator for Depyrogenation",
      "Enoxaparin Sodium Injection",
      "Enoxaparin Sodium",
      "Enrofloxacin Compounded Oral Suspension, Veterinary",
      "Enrofloxacin",
      "Ensulizole",
      "Entacapone Tablets",
      "Entacapone",
      "Entecavir Oral Solution",
      "Entecavir Tablets",
      "Entecavir",
      "Enzacamene",
      "Ephedrine Hydrochloride",
      "Ephedrine Sulfate Capsules",
      "Ephedrine Sulfate Injection",
      "Ephedrine Sulfate Nasal Solution",
      "Ephedrine Sulfate Oral Solution",
      "Ephedrine Sulfate",
      "Ephedrine",
      "Epinephrine Bitartrate for Ophthalmic Solution",
      "Epinephrine Bitartrate Ophthalmic Solution",
      "Epinephrine Bitartrate",
      "Epinephrine Inhalation Solution",
      "Epinephrine Injection",
      "Epinephrine Nasal Solution",
      "Epinephrine Ophthalmic Solution",
      "Epinephrine",
      "Epirubicin Hydrochloride Injection",
      "Epirubicin Hydrochloride",
      "Epoetin",
      "Eprinomectin",
      "Eprosartan Mesylate",
      "Equilin",
      "Ergocalciferol Capsules",
      "Ergocalciferol Oral Solution",
      "Ergocalciferol Tablets",
      "Ergocalciferol",
      "Ergoloid Mesylates Tablets",
      "Ergoloid Mesylates",
      "Ergonovine Maleate Injection",
      "Ergonovine Maleate",
      "Ergotamine Tartrate and Caffeine Suppositories",
      "Ergotamine Tartrate and Caffeine Tablets",
      "Ergotamine Tartrate Sublingual Tablets",
      "Ergotamine Tartrate Tablets",
      "Ergotamine Tartrate",
      "Erythromycin and Benzoyl Peroxide Topical Gel",
      "Erythromycin Delayed-Release Capsules",
      "Erythromycin Delayed-Release Tablets",
      "Erythromycin Ethylsuccinate and Sulfisoxazole Acetyl for Oral Suspension",
      "Erythromycin Ethylsuccinate for Oral Suspension",
      "Erythromycin Ethylsuccinate Tablets",
      "Erythromycin Ethylsuccinate",
      "Erythromycin Injection",
      "Erythromycin Intramammary Infusion",
      "Erythromycin Lactobionate for Injection",
      "Erythromycin Ointment",
      "Erythromycin Ophthalmic Ointment",
      "Erythromycin Pledgets",
      "Erythromycin Stearate Tablets",
      "Erythromycin Stearate",
      "Erythromycin Tablets",
      "Erythromycin Topical Gel",
      "Erythromycin Topical Solution",
      "Erythromycin",
      "Escitalopram Oral Solution",
      "Escitalopram Oxalate",
      "Escitalopram Tablets",
      "Esmolol Hydrochloride",
      "Esomeprazole Magnesium Delayed-Release Capsules",
      "Esomeprazole Magnesium",
      "Esomeprazole Strontium",
      "Estazolam Tablets",
      "Estazolam",
      "Esterified Estrogens Tablets",
      "Esterified Estrogens",
      "Estradiol and Norethindrone Acetate Tablets",
      "Estradiol Benzoate",
      "Estradiol Cypionate Injection",
      "Estradiol Cypionate",
      "Estradiol Tablets",
      "Estradiol Transdermal System",
      "Estradiol Vaginal Cream",
      "Estradiol Vaginal Inserts",
      "Estradiol Valerate Injection",
      "Estradiol Valerate",
      "Estradiol",
      "Estriol Compounded Vaginal Cream",
      "Estriol",
      "Estrone",
      "Estropipate Tablets",
      "Estropipate",
      "Eszopiclone Tablets",
      "Eszopiclone",
      "Ethacrynate Sodium for Injection",
      "Ethacrynic Acid Tablets",
      "Ethacrynic Acid",
      "Ethambutol Hydrochloride Compounded Oral Suspension",
      "Ethambutol Hydrochloride Tablets",
      "Ethambutol Hydrochloride",
      "Ethchlorvynol",
      "Ether USP",
      "Ethinyl Estradiol Tablets",
      "Ethinyl Estradiol",
      "Ethiodized Oil Injection",
      "Ethionamide Tablets",
      "Ethionamide",
      "Ethopabate",
      "Ethosuximide Capsules",
      "Ethosuximide Oral Solution",
      "Ethosuximide",
      "Ethotoin Tablets",
      "Ethotoin",
      "Ethylenediamine USP",
      "Ethynodiol Diacetate and Ethinyl Estradiol Tablets",
      "Ethynodiol Diacetate",
      "Etidronate Disodium Tablets",
      "Etidronate Disodium",
      "Etodolac Capsules",
      "Etodolac Extended-Release Tablets",
      "Etodolac Tablets",
      "Etodolac",
      "Etomidate Injection",
      "Etomidate",
      "Etonogestrel",
      "Etoposide Capsules",
      "Etoposide Injection",
      "Etoposide Phosphate for Injection",
      "Etoposide Phosphate",
      "Etoposide",
      "Etravirine Tablets",
      "Etravirine",
      "Eucalyptol",
      "Eugenol",
      "Everolimus",
      "Exemestane Tablets",
      "Exemestane",
      "Exenatide Injection",
      "Exenatide",
      "Extended Insulin Zinc Suspension",
      "Extended Phenytoin Sodium Capsules",
      "Ezetimibe Tablets",
      "Ezetimibe"
    )

    println("Total input items from user: ${rawList.size}")

    // Dynamic file path setup
    val userDir = System.getProperty("user.dir")
    var file: File? = null
    val pathsToCheck = listOf(
      "src/main/java/com/example/data/UspMonographData.kt",
      "app/src/main/java/com/example/data/UspMonographData.kt",
      "../src/main/java/com/example/data/UspMonographData.kt",
      "../app/src/main/java/com/example/data/UspMonographData.kt"
    )
    for (p in pathsToCheck) {
      val f = File(p)
      if (f.exists()) { file = f; break }
      val absF = File(userDir, p)
      if (absF.exists()) { file = absF; break }
    }
    if (file == null) {
      val searchRoot = File(userDir).parentFile ?: File(userDir)
      val foundFiles = searchRoot.walkTopDown().filter { it.name == "UspMonographData.kt" }.toList()
      if (foundFiles.isNotEmpty()) { file = foundFiles.first() }
    }
    if (file == null) {
      throw FileNotFoundException("Could not locate UspMonographData.kt in workspace.")
    }

    val fileText = file.readText()
    val rawDataStartPattern = "private val rawMonographData = \"\"\""
    val rawDataStart = fileText.indexOf(rawDataStartPattern)
    val rawDataEndPattern = "\"\"\".trimIndent()"
    val rawDataEnd = fileText.indexOf(rawDataEndPattern, rawDataStart)
    val rawData = fileText.substring(rawDataStart + rawDataStartPattern.length, rawDataEnd)

    // Lines of raw monograph data
    val rawDataLines = rawData.split('\n')

    // Separate other lines (A, B, C, D, F, etc.)
    val nonELinesBefore = mutableListOf<String>()
    val nonELinesAfter = mutableListOf<String>()
    val existingELines = mutableMapOf<String, String>()

    var encounteredE = false
    var finishedE = false

    for (line in rawDataLines) {
      val trimmed = line.trim()
      if (trimmed.isEmpty()) continue
      val firstChar = trimmed[0]
      if (firstChar == 'E') {
        encounteredE = true
        val key = trimmed.split('|')[0].trim().uppercase()
        existingELines[key] = line // Store the full original formatted line
      } else {
        if (!encounteredE) {
          nonELinesBefore.add(line)
        } else {
          finishedE = true
          nonELinesAfter.add(line)
        }
      }
    }

    println("Total existing 'E' monographs: ${existingELines.size}")

    // Now, let's build the final collection of E lines
    val finalELinesMap = mutableMapOf<String, String>()

    // Start with all existing E lines to preserve their detailed HPLC column info if they have any
    finalELinesMap.putAll(existingELines)

    val addedItems = mutableListOf<String>()
    // Add all missing E lines from the input list (only if not already present)
    for (name in rawList) {
      val key = name.uppercase()
      if (!finalELinesMap.containsKey(key)) {
        val (active, form) = getActiveAndForm(name)
        finalELinesMap[key] = "        $key|$active|$form"
        addedItems.add(name)
      }
    }

    // Sort all combined E lines alphabetically by their key
    val sortedELines = finalELinesMap.entries.sortedBy { it.key }.map { entry ->
      val line = entry.value
      val trimmedLine = line.trim()
      "        $trimmedLine"
    }

    // Combine everything back together
    val newRawDataContent = buildString {
      append("\n")
      nonELinesBefore.forEach { append(it).append("\n") }
      sortedELines.forEach { append(it).append("\n") }
      nonELinesAfter.forEach { append(it).append("\n") }
      append("    ") // alignment for closing triple quote
    }

    val updatedFileText = fileText.substring(0, rawDataStart + rawDataStartPattern.length) +
        newRawDataContent +
        fileText.substring(rawDataEnd)

    file.writeText(updatedFileText)
    
    val uniqueUserList = rawList.map { it.trim().uppercase() }.distinct()
    val inUserNotDb = uniqueUserList.filter { !existingELines.containsKey(it) }
    val inDbNotUser = existingELines.keys.filter { !uniqueUserList.contains(it) }

    println("--- SUMMARY OF THE MERGE ---")
    println("Total raw input lines from user: ${rawList.size}")
    println("Unique items in user's list: ${uniqueUserList.size}")
    println("Existing 'E' monographs in database before merge: ${existingELines.size}")
    println("Newly added 'E' monographs: ${addedItems.size}")
    println("Total 'E' monographs in database after merge: ${sortedELines.size}")
    println("Items in user's list but NOT in the database: $inUserNotDb")
    println("Items in the database but NOT in user's list: $inDbNotUser")
    println("Successfully merged and updated UspMonographData.kt!")
  }

  @Test
  fun compareAndUpdateFMonographs() {
    val rawList = listOf(
      "Factor IX Complex",
      "Famciclovir Compounded Oral Suspension",
      "Famciclovir Tablets",
      "Famciclovir",
      "Famotidine for Oral Suspension",
      "Famotidine Injection",
      "Famotidine Tablets",
      "Famotidine",
      "Felbamate Oral Suspension",
      "Felbamate Tablets",
      "Felbamate",
      "Felodipine Extended-Release Tablets",
      "Felodipine",
      "Fenbendazole",
      "Fenofibrate Capsules",
      "Fenofibrate Tablets",
      "Fenofibrate",
      "Fenofibric Acid Delayed-Release Capsules",
      "Fenoldopam Mesylate Injection",
      "Fenoldopam Mesylate",
      "Fenoprofen Calcium Capsules",
      "Fenoprofen Calcium Tablets",
      "Fenoprofen Calcium",
      "Fentanyl Citrate and Bupivacaine Hydrochloride Compounded Injection",
      "Fentanyl Citrate and Ropivacaine Hydrochloride Compounded Injection",
      "Fentanyl Citrate Compounded Injection",
      "Fentanyl Citrate Injection",
      "Fentanyl Citrate",
      "Fentanyl",
      "Ferric Ammonium Citrate for Oral Solution",
      "Ferric Ammonium Citrate",
      "Ferric Subsulfate Solution",
      "Ferric Sulfate USP",
      "Ferrous Fumarate and Docusate Sodium Extended-Release Tablets",
      "Ferrous Fumarate Tablets",
      "Ferrous Fumarate",
      "Ferrous Gluconate Capsules",
      "Ferrous Gluconate Oral Solution",
      "Ferrous Gluconate Tablets",
      "Ferrous Gluconate",
      "Ferrous Sulfate Oral Solution",
      "Ferrous Sulfate Syrup",
      "Ferrous Sulfate Tablets",
      "Ferrous Sulfate",
      "Fexofenadine Hydrochloride and Pseudoephedrine Hydrochloride Extended-Release Tablets",
      "Fexofenadine Hydrochloride Capsules",
      "Fexofenadine Hydrochloride Tablets",
      "Fexofenadine Hydrochloride",
      "Filgrastim",
      "Finasteride Tablets",
      "Finasteride",
      "Fingolimod Hydrochloride",
      "Flavoxate Hydrochloride Tablets",
      "Flavoxate Hydrochloride",
      "Flecainide Acetate Compounded Oral Suspension",
      "Flecainide Acetate Tablets",
      "Flecainide Acetate",
      "Flexible Collodion",
      "Floxuridine for Injection",
      "Floxuridine",
      "Fluconazole for Oral Suspension",
      "Fluconazole in Dextrose Injection",
      "Fluconazole in Sodium Chloride Injection",
      "Fluconazole Tablets",
      "Fluconazole",
      "Flucytosine Capsules",
      "Flucytosine Compounded Oral Suspension",
      "Flucytosine",
      "Fludarabine Phosphate for Injection",
      "Fludarabine Phosphate Injection",
      "Fludarabine Phosphate",
      "Fludeoxyglucose F 18 Injection",
      "Fludrocortisone Acetate Compounded Oral Suspension, Veterinary",
      "Fludrocortisone Acetate Compounded Oral Suspension",
      "Fludrocortisone Acetate Tablets",
      "Fludrocortisone Acetate",
      "Flumazenil Injection",
      "Flumazenil",
      "Flunisolide Nasal Solution",
      "Flunisolide",
      "Flunixin Meglumine Granules",
      "Flunixin Meglumine Injection",
      "Flunixin Meglumine Paste",
      "Flunixin Meglumine",
      "Fluocinolone Acetonide Cream",
      "Fluocinolone Acetonide Ointment",
      "Fluocinolone Acetonide Topical Solution",
      "Fluocinolone Acetonide",
      "Fluocinonide Cream",
      "Fluocinonide Gel",
      "Fluocinonide Ointment",
      "Fluocinonide Topical Solution",
      "Fluocinonide",
      "Fluorescein Injection",
      "Fluorescein Sodium and Benoxinate Hydrochloride Ophthalmic Solution",
      "Fluorescein Sodium and Proparacaine Hydrochloride Ophthalmic Solution",
      "Fluorescein Sodium Ophthalmic Strips",
      "Fluorescein Sodium",
      "Fluorescein",
      "Fluorometholone Acetate",
      "Fluorometholone Ophthalmic Suspension",
      "Fluorometholone",
      "Fluorouracil Cream",
      "Fluorouracil Injection",
      "Fluorouracil Topical Solution",
      "Fluorouracil",
      "Fluoxetine Capsules",
      "Fluoxetine Delayed-Release Capsules",
      "Fluoxetine Hydrochloride",
      "Fluoxetine Oral Solution",
      "Fluoxetine Tablets",
      "Fluoxymesterone Tablets",
      "Fluoxymesterone",
      "Fluphenazine Decanoate Injection",
      "Fluphenazine Decanoate",
      "Fluphenazine Enanthate Injection",
      "Fluphenazine Enanthate",
      "Fluphenazine Hydrochloride Elixir",
      "Fluphenazine Hydrochloride Injection",
      "Fluphenazine Hydrochloride Oral Solution",
      "Fluphenazine Hydrochloride Tablets",
      "Fluphenazine Hydrochloride",
      "Flurandrenolide Cream",
      "Flurandrenolide Lotion",
      "Flurandrenolide Ointment",
      "Flurandrenolide Tape",
      "Flurandrenolide",
      "Flurazepam Hydrochloride Capsules",
      "Flurazepam Hydrochloride",
      "Flurbiprofen Sodium Ophthalmic Solution",
      "Flurbiprofen Sodium",
      "Flurbiprofen Tablets",
      "Flurbiprofen",
      "Flutamide Capsules",
      "Flutamide",
      "Fluticasone Propionate and Salmeterol Inhalation Aerosol",
      "Fluticasone Propionate and Salmeterol Inhalation Powder",
      "Fluticasone Propionate Cream",
      "Fluticasone Propionate Inhalation Aerosol",
      "Fluticasone Propionate Inhalation Powder",
      "Fluticasone Propionate Lotion",
      "Fluticasone Propionate Nasal Spray",
      "Fluticasone Propionate Ointment",
      "Fluticasone Propionate",
      "Fluvastatin Capsules",
      "Fluvastatin Sodium",
      "Fluvoxamine Maleate Tablets",
      "Fluvoxamine Maleate",
      "Folic Acid Compounded Oral Solution",
      "Folic Acid Injection",
      "Folic Acid Tablets",
      "Folic Acid",
      "Fondaparinux Sodium Injection",
      "Fondaparinux Sodium",
      "Formaldehyde Solution USP",
      "Formoterol Fumarate",
      "Fosamprenavir Calcium Tablets",
      "Fosamprenavir Calcium",
      "Foscarnet Sodium",
      "Fosfomycin Tromethamine",
      "Fosinopril Sodium and Hydrochlorothiazide Tablets",
      "Fosinopril Sodium Tablets",
      "Fosinopril Sodium",
      "Fosphenytoin Sodium Injection",
      "Fosphenytoin Sodium",
      "Fructose and Sodium Chloride Injection",
      "Fructose Injection",
      "Fructose",
      "Fulvestrant",
      "Furazolidone",
      "Furosemide Injection",
      "Furosemide Oral Solution",
      "Furosemide Tablets",
      "Furosemide"
    )

    println("Total input items from user: ${rawList.size}")

    // Dynamic file path setup
    val userDir = System.getProperty("user.dir")
    var file: File? = null
    val pathsToCheck = listOf(
      "src/main/java/com/example/data/UspMonographData.kt",
      "app/src/main/java/com/example/data/UspMonographData.kt",
      "../src/main/java/com/example/data/UspMonographData.kt",
      "../app/src/main/java/com/example/data/UspMonographData.kt"
    )
    for (p in pathsToCheck) {
      val f = File(p)
      if (f.exists()) { file = f; break }
      val absF = File(userDir, p)
      if (absF.exists()) { file = absF; break }
    }
    if (file == null) {
      val searchRoot = File(userDir).parentFile ?: File(userDir)
      val foundFiles = searchRoot.walkTopDown().filter { it.name == "UspMonographData.kt" }.toList()
      if (foundFiles.isNotEmpty()) { file = foundFiles.first() }
    }
    if (file == null) {
      throw FileNotFoundException("Could not locate UspMonographData.kt in workspace.")
    }

    val fileText = file.readText()
    val rawDataStartPattern = "private val rawMonographData = \"\"\""
    val rawDataStart = fileText.indexOf(rawDataStartPattern)
    val rawDataEndPattern = "\"\"\".trimIndent()"
    val rawDataEnd = fileText.indexOf(rawDataEndPattern, rawDataStart)
    val rawData = fileText.substring(rawDataStart + rawDataStartPattern.length, rawDataEnd)

    // Lines of raw monograph data
    val rawDataLines = rawData.split('\n')

    // Separate other lines (A, B, C, D, E, G, etc.)
    val nonFLinesBefore = mutableListOf<String>()
    val nonFLinesAfter = mutableListOf<String>()
    val existingFLines = mutableMapOf<String, String>()

    var encounteredF = false
    var finishedF = false

    for (line in rawDataLines) {
      val trimmed = line.trim()
      if (trimmed.isEmpty()) continue
      val firstChar = trimmed[0]
      if (firstChar == 'F') {
        encounteredF = true
        val key = trimmed.split('|')[0].trim().uppercase()
        existingFLines[key] = line // Store the full original formatted line
      } else {
        if (!encounteredF) {
          if (firstChar > 'F') {
            finishedF = true
            nonFLinesAfter.add(line)
          } else {
            nonFLinesBefore.add(line)
          }
        } else {
          finishedF = true
          nonFLinesAfter.add(line)
        }
      }
    }

    println("Total existing 'F' monographs: ${existingFLines.size}")

    // Now, let's build the final collection of F lines
    val finalFLinesMap = mutableMapOf<String, String>()

    // Start with all existing F lines to preserve their detailed HPLC column info if they have any
    finalFLinesMap.putAll(existingFLines)

    val addedItems = mutableListOf<String>()
    // Add all missing F lines from the input list (only if not already present)
    for (name in rawList) {
      val key = name.uppercase()
      if (!finalFLinesMap.containsKey(key)) {
        val (active, form) = getActiveAndForm(name)
        finalFLinesMap[key] = "        $key|$active|$form"
        addedItems.add(name)
      }
    }

    // Sort all combined F lines alphabetically by their key
    val sortedFLines = finalFLinesMap.entries.sortedBy { it.key }.map { entry ->
      val line = entry.value
      val trimmedLine = line.trim()
      "        $trimmedLine"
    }

    // Combine everything back together
    val newRawDataContent = buildString {
      append("\n")
      nonFLinesBefore.forEach { append(it).append("\n") }
      sortedFLines.forEach { append(it).append("\n") }
      nonFLinesAfter.forEach { append(it).append("\n") }
      append("    ") // alignment for closing triple quote
    }

    val updatedFileText = fileText.substring(0, rawDataStart + rawDataStartPattern.length) +
        newRawDataContent +
        fileText.substring(rawDataEnd)

    file.writeText(updatedFileText)
    
    val uniqueUserList = rawList.map { it.trim().uppercase() }.distinct()
    val inUserNotDb = uniqueUserList.filter { !existingFLines.containsKey(it) }
    val inDbNotUser = existingFLines.keys.filter { !uniqueUserList.contains(it) }

    println("--- SUMMARY OF THE MERGE ---")
    println("Total raw input lines from user: ${rawList.size}")
    println("Unique items in user's list: ${uniqueUserList.size}")
    println("Existing 'F' monographs in database before merge: ${existingFLines.size}")
    println("Newly added 'F' monographs: ${addedItems.size}")
    println("Total 'F' monographs in database after merge: ${sortedFLines.size}")
    println("Items in user's list but NOT in the database: $inUserNotDb")
    println("Items in the database but NOT in user's list: $inDbNotUser")
    println("Successfully merged and updated UspMonographData.kt!")
  }

  @Test
  fun compareAndUpdateGMonographs() {
    val rawList = listOf(
      "Gabapentin Capsules",
      "Gabapentin Compounded Cream",
      "Gabapentin Compounded Oral Suspension",
      "Gabapentin Tablets",
      "Gabapentin",
      "Gadobutrol",
      "Gadodiamide Injection",
      "Gadodiamide",
      "Gadopentetate Dimeglumine Injection",
      "Gadoterate Meglumine Injection",
      "Gadoteridol Injection",
      "Gadoteridol",
      "Galantamine Extended-Release Capsules",
      "Galantamine Hydrobromide",
      "Galantamine Oral Solution",
      "Galantamine Tablets",
      "Gallium Citrate Ga 67 Injection",
      "Ganciclovir Compounded Oral Suspension",
      "Ganciclovir for Injection",
      "Ganciclovir",
      "Gauze Bandage",
      "Gefitinib Tablets",
      "Gefitinib",
      "Gemcitabine for Injection",
      "Gemcitabine Hydrochloride",
      "Gemfibrozil Capsules",
      "Gemfibrozil Tablets",
      "Gemfibrozil",
      "Gemifloxacin Mesylate",
      "Gemifloxacin Tablets",
      "Gentamicin and Prednisolone Acetate Ophthalmic Ointment",
      "Gentamicin and Prednisolone Acetate Ophthalmic Suspension",
      "Gentamicin Injection",
      "Gentamicin Sulfate and Betamethasone Acetate Ophthalmic Solution",
      "Gentamicin Sulfate and Betamethasone Valerate Ointment",
      "Gentamicin Sulfate and Betamethasone Valerate Otic Solution",
      "Gentamicin Sulfate and Betamethasone Valerate Topical Solution",
      "Gentamicin Sulfate Cream",
      "Gentamicin Sulfate Ointment",
      "Gentamicin Sulfate Ophthalmic Ointment",
      "Gentamicin Sulfate Ophthalmic Solution",
      "Gentamicin Sulfate",
      "Gentamicin Uterine Infusion",
      "Gentian Violet Cream",
      "Gentian Violet Topical Solution",
      "Gentian Violet",
      "Glacial Acetic Acid USP",
      "Glimepiride Tablets",
      "Glimepiride",
      "Glipizide and Metformin Hydrochloride Tablets",
      "Glipizide Tablets",
      "Glipizide",
      "Glucagon for Injection",
      "Glucagon",
      "Gluconolactone",
      "Glucose Enzymatic Test Strip",
      "Glutamine",
      "Glutaral Concentrate",
      "Glyburide and Metformin Hydrochloride Tablets",
      "Glyburide Tablets",
      "Glyburide",
      "Glycerin Ophthalmic Solution",
      "Glycerin Oral Solution",
      "Glycerin Suppositories",
      "Glycerin USP",
      "Glycine Irrigation",
      "Glycine USP",
      "Glycopyrrolate Injection",
      "Glycopyrrolate Tablets",
      "Glycopyrrolate",
      "Gold Sodium Thiomalate Injection",
      "Gold Sodium Thiomalate",
      "Gonadorelin Acetate",
      "Gonadorelin for Injection",
      "Gonadorelin Hydrochloride",
      "Goserelin Acetate",
      "Goserelin Implants",
      "Gramicidin",
      "Granisetron Hydrochloride Compounded Oral Suspension",
      "Granisetron Hydrochloride Injection",
      "Granisetron Hydrochloride Tablets",
      "Granisetron Hydrochloride",
      "Granisetron",
      "Green Soap Tincture",
      "Green Soap",
      "Griseofulvin Capsules",
      "Griseofulvin Oral Suspension",
      "Griseofulvin Tablets",
      "Griseofulvin",
      "Guaifenesin and Codeine Phosphate Oral Solution",
      "Guaifenesin Capsules",
      "Guaifenesin Compounded Injection, Veterinary",
      "Guaifenesin for Injection",
      "Guaifenesin Oral Solution",
      "Guaifenesin Tablets",
      "Guaifenesin, Pseudoephedrine Hydrochloride, and Dextromethorphan Hydrobromide Capsules",
      "Guaifenesin",
      "Guanabenz Acetate Tablets",
      "Guanabenz Acetate",
      "Guanethidine Monosulfate",
      "Guanfacine Extended-Release Tablets",
      "Guanfacine Hydrochloride",
      "Guanfacine Tablets",
      "Gutta Percha"
    )

    println("Total input items from user: ${rawList.size}")

    // Dynamic file path setup
    val userDir = System.getProperty("user.dir")
    var file: File? = null
    val pathsToCheck = listOf(
      "src/main/java/com/example/data/UspMonographData.kt",
      "app/src/main/java/com/example/data/UspMonographData.kt",
      "../src/main/java/com/example/data/UspMonographData.kt",
      "../app/src/main/java/com/example/data/UspMonographData.kt"
    )
    for (p in pathsToCheck) {
      val f = File(p)
      if (f.exists()) { file = f; break }
      val absF = File(userDir, p)
      if (absF.exists()) { file = absF; break }
    }
    if (file == null) {
      val searchRoot = File(userDir).parentFile ?: File(userDir)
      val foundFiles = searchRoot.walkTopDown().filter { it.name == "UspMonographData.kt" }.toList()
      if (foundFiles.isNotEmpty()) { file = foundFiles.first() }
    }
    if (file == null) {
      throw FileNotFoundException("Could not locate UspMonographData.kt in workspace.")
    }

    val fileText = file.readText()
    val rawDataStartPattern = "private val rawMonographData = \"\"\""
    val rawDataStart = fileText.indexOf(rawDataStartPattern)
    val rawDataEndPattern = "\"\"\".trimIndent()"
    val rawDataEnd = fileText.indexOf(rawDataEndPattern, rawDataStart)
    val rawData = fileText.substring(rawDataStart + rawDataStartPattern.length, rawDataEnd)

    // Lines of raw monograph data
    val rawDataLines = rawData.split('\n')

    // Separate other lines (A, B, C, D, E, F, H, etc.)
    val nonGLinesBefore = mutableListOf<String>()
    val nonGLinesAfter = mutableListOf<String>()
    val existingGLines = mutableMapOf<String, String>()

    var encounteredG = false
    var finishedG = false

    for (line in rawDataLines) {
      val trimmed = line.trim()
      if (trimmed.isEmpty()) continue
      val firstChar = trimmed[0]
      if (firstChar == 'G') {
        encounteredG = true
        val key = trimmed.split('|')[0].trim().uppercase()
        existingGLines[key] = line // Store the full original formatted line
      } else {
        if (!encounteredG) {
          if (firstChar > 'G') {
            finishedG = true
            nonGLinesAfter.add(line)
          } else {
            nonGLinesBefore.add(line)
          }
        } else {
          finishedG = true
          nonGLinesAfter.add(line)
        }
      }
    }

    println("Total existing 'G' monographs: ${existingGLines.size}")

    // Now, let's build the final collection of G lines
    val finalGLinesMap = mutableMapOf<String, String>()

    // Start with all existing G lines to preserve their detailed HPLC column info if they have any
    finalGLinesMap.putAll(existingGLines)

    val addedItems = mutableListOf<String>()
    // Add all missing G lines from the input list (only if not already present)
    for (name in rawList) {
      val key = name.uppercase()
      if (!finalGLinesMap.containsKey(key)) {
        val (active, form) = getActiveAndForm(name)
        finalGLinesMap[key] = "        $key|$active|$form"
        addedItems.add(name)
      }
    }

    // Sort all combined G lines alphabetically by their key
    val sortedGLines = finalGLinesMap.entries.sortedBy { it.key }.map { entry ->
      val line = entry.value
      val trimmedLine = line.trim()
      "        $trimmedLine"
    }

    // Combine everything back together
    val newRawDataContent = buildString {
      append("\n")
      nonGLinesBefore.forEach { append(it).append("\n") }
      sortedGLines.forEach { append(it).append("\n") }
      nonGLinesAfter.forEach { append(it).append("\n") }
      append("    ") // alignment for closing triple quote
    }

    val updatedFileText = fileText.substring(0, rawDataStart + rawDataStartPattern.length) +
        newRawDataContent +
        fileText.substring(rawDataEnd)

    file.writeText(updatedFileText)
    
    val uniqueUserList = rawList.map { it.trim().uppercase() }.distinct()
    val inUserNotDb = uniqueUserList.filter { !existingGLines.containsKey(it) }
    val inDbNotUser = existingGLines.keys.filter { !uniqueUserList.contains(it) }

    println("--- SUMMARY OF THE MERGE ---")
    println("Total raw input lines from user: ${rawList.size}")
    println("Unique items in user's list: ${uniqueUserList.size}")
    println("Existing 'G' monographs in database before merge: ${existingGLines.size}")
    println("Newly added 'G' monographs: ${addedItems.size}")
    println("Total 'G' monographs in database after merge: ${sortedGLines.size}")
    println("Items in user's list but NOT in the database: $inUserNotDb")
    println("Items in the database but NOT in user's list: $inDbNotUser")
    println("Successfully merged and updated UspMonographData.kt!")
  }

  @Test
  fun compareAndUpdateHMonographs() {
    val rawList = listOf(
      "Halazone Tablets for Solution",
      "Halazone",
      "Halcinonide Cream",
      "Halcinonide Ointment",
      "Halcinonide Topical Solution",
      "Halcinonide",
      "Half-Strength Lactated Ringer's and Dextrose Injection",
      "Halobetasol Propionate",
      "Haloperidol Decanoate",
      "Haloperidol Injection",
      "Haloperidol Oral Solution",
      "Haloperidol Tablets",
      "Haloperidol",
      "Halothane",
      "Helium",
      "Heparin Lock Flush Solution",
      "Heparin Sodium Injection",
      "Heparin Sodium",
      "Hexachlorophene Cleansing Emulsion",
      "Hexachlorophene Liquid Soap",
      "Hexachlorophene",
      "Hexylresorcinol Lozenges",
      "Hexylresorcinol",
      "Histamine Phosphate Injection",
      "Histamine Phosphate",
      "Histidine",
      "Homatropine Hydrobromide Ophthalmic Solution",
      "Homatropine Hydrobromide",
      "Homatropine Methylbromide Tablets",
      "Homatropine Methylbromide",
      "Homosalate",
      "Human Insulin Isophane Suspension and Human Insulin Injection",
      "Hyaluronidase for Injection",
      "Hyaluronidase Injection",
      "Hydralazine Hydrochloride Compounded Oral Solution",
      "Hydralazine Hydrochloride Injection",
      "Hydralazine Hydrochloride Tablets",
      "Hydralazine Hydrochloride",
      "Hydrochloric Acid Compounded Injection",
      "Hydrochlorothiazide Capsules",
      "Hydrochlorothiazide Compounded Oral Suspension",
      "Hydrochlorothiazide Tablets",
      "Hydrochlorothiazide",
      "Hydrocodone Bitartrate and Acetaminophen Tablets",
      "Hydrocodone Bitartrate and Homatropine Methylbromide Tablets",
      "Hydrocodone Bitartrate Tablets",
      "Hydrocodone Bitartrate",
      "Hydrocortisone Acetate Cream",
      "Hydrocortisone Acetate Lotion",
      "Hydrocortisone Acetate Ointment",
      "Hydrocortisone Acetate",
      "Hydrocortisone and Acetic Acid Otic Solution",
      "Hydrocortisone Butyrate Cream",
      "Hydrocortisone Butyrate",
      "Hydrocortisone Compounded Oral Suspension",
      "Hydrocortisone Cream",
      "Hydrocortisone Gel",
      "Hydrocortisone Hemisuccinate",
      "Hydrocortisone Lotion",
      "Hydrocortisone Ointment",
      "Hydrocortisone Rectal Suspension",
      "Hydrocortisone Sodium Phosphate Injection",
      "Hydrocortisone Sodium Phosphate",
      "Hydrocortisone Sodium Succinate for Injection",
      "Hydrocortisone Sodium Succinate",
      "Hydrocortisone Tablets",
      "Hydrocortisone Valerate Cream",
      "Hydrocortisone Valerate Ointment",
      "Hydrocortisone Valerate",
      "Hydrocortisone",
      "Hydroflumethiazide Tablets",
      "Hydroflumethiazide",
      "Hydrogen Peroxide Concentrate",
      "Hydrogen Peroxide Topical Solution",
      "Hydromorphone Hydrochloride Injection",
      "Hydromorphone Hydrochloride Oral Solution",
      "Hydromorphone Hydrochloride Tablets",
      "Hydromorphone Hydrochloride",
      "Hydrophilic Ointment",
      "Hydrophilic Petrolatum",
      "Hydroquinone Cream",
      "Hydroquinone Topical Solution",
      "Hydroquinone",
      "Hydrous Benzoyl Peroxide",
      "Hydroxocobalamin Injection",
      "Hydroxocobalamin",
      "Hydroxyamphetamine Hydrobromide",
      "Hydroxychloroquine Sulfate Compounded Oral Suspension",
      "Hydroxychloroquine Sulfate Tablets",
      "Hydroxychloroquine Sulfate",
      "Hydroxyprogesterone Caproate Injection",
      "Hydroxyprogesterone Caproate",
      "Hydroxypropyl Cellulose Ocular System",
      "Hydroxyurea Capsules",
      "Hydroxyurea",
      "Hydroxyzine Hydrochloride Injection",
      "Hydroxyzine Hydrochloride Oral Solution",
      "Hydroxyzine Hydrochloride Tablets",
      "Hydroxyzine Hydrochloride",
      "Hydroxyzine Pamoate Capsules",
      "Hydroxyzine Pamoate",
      "Hyoscyamine Hydrobromide",
      "Hyoscyamine Sulfate Elixir",
      "Hyoscyamine Sulfate Injection",
      "Hyoscyamine Sulfate Oral Solution",
      "Hyoscyamine Sulfate Tablets",
      "Hyoscyamine Sulfate",
      "Hyoscyamine",
      "Hypromellose Ophthalmic Solution",
      "Hypromellose"
    )

    println("Total input items from user: ${rawList.size}")

    // Dynamic file path setup
    val userDir = System.getProperty("user.dir")
    var file: File? = null
    val pathsToCheck = listOf(
      "src/main/java/com/example/data/UspMonographData.kt",
      "app/src/main/java/com/example/data/UspMonographData.kt",
      "../src/main/java/com/example/data/UspMonographData.kt",
      "../app/src/main/java/com/example/data/UspMonographData.kt"
    )
    for (p in pathsToCheck) {
      val f = File(p)
      if (f.exists()) { file = f; break }
      val absF = File(userDir, p)
      if (absF.exists()) { file = absF; break }
    }
    if (file == null) {
      val searchRoot = File(userDir).parentFile ?: File(userDir)
      val foundFiles = searchRoot.walkTopDown().filter { it.name == "UspMonographData.kt" }.toList()
      if (foundFiles.isNotEmpty()) { file = foundFiles.first() }
    }
    if (file == null) {
      throw FileNotFoundException("Could not locate UspMonographData.kt in workspace.")
    }

    val fileText = file.readText()
    val rawDataStartPattern = "private val rawMonographData = \"\"\""
    val rawDataStart = fileText.indexOf(rawDataStartPattern)
    val rawDataEndPattern = "\"\"\".trimIndent()"
    val rawDataEnd = fileText.indexOf(rawDataEndPattern, rawDataStart)
    val rawData = fileText.substring(rawDataStart + rawDataStartPattern.length, rawDataEnd)

    // Lines of raw monograph data
    val rawDataLines = rawData.split('\n')

    // Separate other lines (A to G, and I onwards)
    val nonHLinesBefore = mutableListOf<String>()
    val nonHLinesAfter = mutableListOf<String>()
    val existingHLines = mutableMapOf<String, String>()

    var encounteredH = false
    var finishedH = false

    for (line in rawDataLines) {
      val trimmed = line.trim()
      if (trimmed.isEmpty()) continue
      val firstChar = trimmed[0]
      if (firstChar == 'H') {
        encounteredH = true
        val key = trimmed.split('|')[0].trim().uppercase()
        existingHLines[key] = line // Store the full original formatted line
      } else {
        if (!encounteredH) {
          if (firstChar > 'H') {
            finishedH = true
            nonHLinesAfter.add(line)
          } else {
            nonHLinesBefore.add(line)
          }
        } else {
          finishedH = true
          nonHLinesAfter.add(line)
        }
      }
    }

    println("Total existing 'H' monographs: ${existingHLines.size}")

    // Now, let's build the final collection of H lines
    val finalHLinesMap = mutableMapOf<String, String>()

    // Start with all existing H lines to preserve their detailed HPLC column info if they have any
    finalHLinesMap.putAll(existingHLines)

    val addedItems = mutableListOf<String>()
    // Add all missing H lines from the input list (only if not already present)
    for (name in rawList) {
      val key = name.uppercase()
      if (!finalHLinesMap.containsKey(key)) {
        val (active, form) = getActiveAndForm(name)
        finalHLinesMap[key] = "        $key|$active|$form"
        addedItems.add(name)
      }
    }

    // Sort all combined H lines alphabetically by their key
    val sortedHLines = finalHLinesMap.entries.sortedBy { it.key }.map { entry ->
      val line = entry.value
      val trimmedLine = line.trim()
      "        $trimmedLine"
    }

    // Combine everything back together
    val newRawDataContent = buildString {
      append("\n")
      nonHLinesBefore.forEach { append(it).append("\n") }
      sortedHLines.forEach { append(it).append("\n") }
      nonHLinesAfter.forEach { append(it).append("\n") }
      append("    ") // alignment for closing triple quote
    }

    val updatedFileText = fileText.substring(0, rawDataStart + rawDataStartPattern.length) +
        newRawDataContent +
        fileText.substring(rawDataEnd)

    file.writeText(updatedFileText)
    
    val uniqueUserList = rawList.map { it.trim().uppercase() }.distinct()
    val inUserNotDb = uniqueUserList.filter { !existingHLines.containsKey(it) }
    val inDbNotUser = existingHLines.keys.filter { !uniqueUserList.contains(it) }

    println("--- SUMMARY OF THE MERGE ---")
    println("Total raw input lines from user: ${rawList.size}")
    println("Unique items in user's list: ${uniqueUserList.size}")
    println("Existing 'H' monographs in database before merge: ${existingHLines.size}")
    println("Newly added 'H' monographs: ${addedItems.size}")
    println("Total 'H' monographs in database after merge: ${sortedHLines.size}")
    println("Items in user's list but NOT in the database: $inUserNotDb")
    println("Items in the database but NOT in user's list: $inDbNotUser")
    println("Successfully merged and updated UspMonographData.kt!")
  }

  @Test
  fun compareAndUpdateIMonographs() {
    val rawList = listOf(
      "Ibuprofen and Pseudoephedrine Hydrochloride Tablets",
      "Ibuprofen Oral Suspension",
      "Ibuprofen Tablets",
      "Ibuprofen",
      "Ibutilide Fumarate",
      "Ichthammol Ointment",
      "Ichthammol",
      "Idarubicin Hydrochloride for Injection",
      "Idarubicin Hydrochloride Injection",
      "Idarubicin Hydrochloride",
      "Idoxuridine Ophthalmic Solution",
      "Idoxuridine",
      "Ifosfamide for Injection",
      "Ifosfamide",
      "Imipenem and Cilastatin for Injectable Suspension",
      "Imipenem and Cilastatin for Injection",
      "Imipenem",
      "Imipramine Hydrochloride Injection",
      "Imipramine Hydrochloride Tablets",
      "Imipramine Hydrochloride",
      "Imipramine Pamoate Capsules",
      "Imipramine Pamoate",
      "Imiquimod Cream",
      "Imiquimod",
      "Inamrinone Injection",
      "Inamrinone",
      "Indapamide Tablets",
      "Indapamide",
      "Indigotindisulfonate Sodium Injection",
      "Indigotindisulfonate Sodium",
      "Indinavir Sulfate",
      "Indium In 111 Capromab Pendetide Injection",
      "Indium In 111 Chloride Solution",
      "Indium In 111 Oxyquinoline Solution",
      "Indium In 111 Pentetate Injection",
      "Indium In 111 Pentetreotide Injection",
      "Indocyanine Green for Injection",
      "Indocyanine Green",
      "Indomethacin Capsules",
      "Indomethacin Compounded Topical Gel",
      "Indomethacin Extended-Release Capsules",
      "Indomethacin for Injection",
      "Indomethacin Oral Suspension",
      "Indomethacin Sodium",
      "Indomethacin Suppositories",
      "Indomethacin",
      "Insulin Aspart Injection",
      "Insulin Aspart",
      "Insulin Glargine Injection",
      "Insulin Glargine",
      "Insulin Human Injection",
      "Insulin Human",
      "Insulin Injection",
      "Insulin Lispro Injection",
      "Insulin Lispro",
      "Insulin Zinc Suspension",
      "Insulin",
      "Inulin",
      "Iobenguane I 123 Injection",
      "Iodinated I 125 Albumin Injection",
      "Iodinated I 131 Albumin Injection",
      "Iodine Tincture",
      "Iodine Topical Solution",
      "Iodine USP",
      "Iodipamide Meglumine Injection",
      "Iodipamide",
      "Iodixanol Injection",
      "Iodixanol",
      "Iodoform",
      "Iodoquinol",
      "Iohexol Injection",
      "Iohexol",
      "Iopamidol Injection",
      "Iopamidol",
      "Iopromide Injection",
      "Iopromide",
      "Iothalamate Meglumine Injection",
      "Iothalamate Sodium I 125 Injection",
      "Iothalamic Acid",
      "Ioversol Injection",
      "Ioversol",
      "Ioxaglate Meglumine and Ioxaglate Sodium Injection",
      "Ioxaglic Acid",
      "Ipecac Oral Solution",
      "Ipecac",
      "Ipratropium Bromide and Albuterol Sulfate Inhalation Solution",
      "Ipratropium Bromide Inhalation Solution",
      "Ipratropium Bromide",
      "Irbesartan and Hydrochlorothiazide Tablets",
      "Irbesartan Tablets",
      "Irbesartan",
      "Irinotecan Hydrochloride Injection",
      "Irinotecan Hydrochloride",
      "Iron Dextran Injection",
      "Iron Sucrose Injection",
      "Iron, Carbonyl",
      "Isoflupredone Acetate Injectable Suspension",
      "Isoflupredone Acetate",
      "Isoflurane",
      "Isoleucine",
      "Isometheptene Mucate",
      "Isoniazid Injection",
      "Isoniazid Oral Solution",
      "Isoniazid Tablets",
      "Isoniazid",
      "Isophane Insulin Human Suspension",
      "Isophane Insulin Suspension",
      "Isopropamide Iodide",
      "Isopropyl Alcohol",
      "Isopropyl Rubbing Alcohol",
      "Isoproterenol Hydrochloride Injection",
      "Isoproterenol Hydrochloride",
      "Isosorbide Concentrate",
      "Isosorbide Dinitrate Extended-Release Capsules",
      "Isosorbide Dinitrate Extended-Release Tablets",
      "Isosorbide Dinitrate Tablets",
      "Isosorbide Mononitrate Extended-Release Tablets",
      "Isosorbide Mononitrate Tablets",
      "Isosorbide Oral Solution",
      "Isotretinoin Capsules",
      "Isotretinoin",
      "Isoxsuprine Hydrochloride Tablets",
      "Isoxsuprine Hydrochloride",
      "Isradipine Capsules",
      "Isradipine Compounded Oral Suspension",
      "Isradipine",
      "Itraconazole Capsules",
      "Itraconazole",
      "Ivermectin and Clorsulon Injection",
      "Ivermectin and Pyrantel Pamoate Tablets",
      "Ivermectin Compounded Oral Solution, Veterinary",
      "Ivermectin Injection",
      "Ivermectin Paste",
      "Ivermectin Tablets",
      "Ivermectin Topical Solution",
      "Ivermectin",
      "Ixabepilone"
    )

    println("Total input items from user: ${rawList.size}")

    // Dynamic file path setup
    val userDir = System.getProperty("user.dir")
    var file: File? = null
    val pathsToCheck = listOf(
      "src/main/java/com/example/data/UspMonographData.kt",
      "app/src/main/java/com/example/data/UspMonographData.kt",
      "../src/main/java/com/example/data/UspMonographData.kt",
      "../app/src/main/java/com/example/data/UspMonographData.kt"
    )
    for (p in pathsToCheck) {
      val f = File(p)
      if (f.exists()) { file = f; break }
      val absF = File(userDir, p)
      if (absF.exists()) { file = absF; break }
    }
    if (file == null) {
      val searchRoot = File(userDir).parentFile ?: File(userDir)
      val foundFiles = searchRoot.walkTopDown().filter { it.name == "UspMonographData.kt" }.toList()
      if (foundFiles.isNotEmpty()) { file = foundFiles.first() }
    }
    if (file == null) {
      throw FileNotFoundException("Could not locate UspMonographData.kt in workspace.")
    }

    val fileText = file.readText()
    val rawDataStartPattern = "private val rawMonographData = \"\"\""
    val rawDataStart = fileText.indexOf(rawDataStartPattern)
    val rawDataEndPattern = "\"\"\".trimIndent()"
    val rawDataEnd = fileText.indexOf(rawDataEndPattern, rawDataStart)
    val rawData = fileText.substring(rawDataStart + rawDataStartPattern.length, rawDataEnd)

    // Lines of raw monograph data
    val rawDataLines = rawData.split('\n')

    // Separate other lines (A to H, and J onwards)
    val nonILinesBefore = mutableListOf<String>()
    val nonILinesAfter = mutableListOf<String>()
    val existingILines = mutableMapOf<String, String>()

    var encounteredI = false
    var finishedI = false

    for (line in rawDataLines) {
      val trimmed = line.trim()
      if (trimmed.isEmpty()) continue
      val firstChar = trimmed[0]
      if (firstChar == 'I') {
        encounteredI = true
        val key = trimmed.split('|')[0].trim().uppercase()
        existingILines[key] = line // Store the full original formatted line
      } else {
        if (!encounteredI) {
          if (firstChar > 'I') {
            finishedI = true
            nonILinesAfter.add(line)
          } else {
            nonILinesBefore.add(line)
          }
        } else {
          finishedI = true
          nonILinesAfter.add(line)
        }
      }
    }

    println("Total existing 'I' monographs: ${existingILines.size}")

    // Now, let's build the final collection of I lines
    val finalILinesMap = mutableMapOf<String, String>()

    // Start with all existing I lines to preserve their detailed HPLC column info if they have any
    finalILinesMap.putAll(existingILines)

    val addedItems = mutableListOf<String>()
    // Add all missing I lines from the input list (only if not already present)
    for (name in rawList) {
      val key = name.uppercase()
      if (!finalILinesMap.containsKey(key)) {
        val (active, form) = getActiveAndForm(name)
        finalILinesMap[key] = "        $key|$active|$form"
        addedItems.add(name)
      }
    }

    // Sort all combined I lines alphabetically by their key
    val sortedILines = finalILinesMap.entries.sortedBy { it.key }.map { entry ->
      val line = entry.value
      val trimmedLine = line.trim()
      "        $trimmedLine"
    }

    // Combine everything back together
    val newRawDataContent = buildString {
      append("\n")
      nonILinesBefore.forEach { append(it).append("\n") }
      sortedILines.forEach { append(it).append("\n") }
      nonILinesAfter.forEach { append(it).append("\n") }
      append("    ") // alignment for closing triple quote
    }

    val updatedFileText = fileText.substring(0, rawDataStart + rawDataStartPattern.length) +
        newRawDataContent +
        fileText.substring(rawDataEnd)

    file.writeText(updatedFileText)
    
    val uniqueUserList = rawList.map { it.trim().uppercase() }.distinct()
    val inUserNotDb = uniqueUserList.filter { !existingILines.containsKey(it) }
    val inDbNotUser = existingILines.keys.filter { !uniqueUserList.contains(it) }
    println("--- SUMMARY OF THE MERGE ---")
    println("Total raw input lines from user: ${rawList.size}")
    println("Unique items in user's list: ${uniqueUserList.size}")
    println("Existing 'I' monographs in database before merge: ${existingILines.size}")
    println("Newly added 'I' monographs: ${addedItems.size}")
    println("Total 'I' monographs in database after merge: ${sortedILines.size}")
    println("Items in user's list but NOT in the database: $inUserNotDb")
    println("Items in the database but NOT in user's list: $inDbNotUser")
    println("Successfully merged and updated UspMonographData.kt!")
  }

  @Test
  fun compareAndUpdateKMonographs() {
    val rawList = listOf(
      "Kanamycin Injection",
      "Kanamycin Sulfate",
      "Kaolin",
      "Ketamine Compounded Oral Solution",
      "Ketamine Hydrochloride Injection",
      "Ketamine Hydrochloride",
      "Ketoconazole Compounded Oral Suspension",
      "Ketoconazole Tablets",
      "Ketoconazole",
      "Ketoprofen Capsules",
      "Ketoprofen Extended-Release Capsules",
      "Ketoprofen",
      "Ketorolac Tromethamine Injection",
      "Ketorolac Tromethamine Tablets",
      "Ketorolac Tromethamine",
      "Ketotifen Fumarate"
    )

    println("Total input items from user: ${rawList.size}")

    // Dynamic file path setup
    val userDir = System.getProperty("user.dir")
    var file: File? = null
    val pathsToCheck = listOf(
      "src/main/java/com/example/data/UspMonographData.kt",
      "app/src/main/java/com/example/data/UspMonographData.kt",
      "../src/main/java/com/example/data/UspMonographData.kt",
      "../app/src/main/java/com/example/data/UspMonographData.kt"
    )
    for (p in pathsToCheck) {
      val f = File(p)
      if (f.exists()) { file = f; break }
      val absF = File(userDir, p)
      if (absF.exists()) { file = absF; break }
    }
    if (file == null) {
      val searchRoot = File(userDir).parentFile ?: File(userDir)
      val foundFiles = searchRoot.walkTopDown().filter { it.name == "UspMonographData.kt" }.toList()
      if (foundFiles.isNotEmpty()) { file = foundFiles.first() }
    }
    if (file == null) {
      throw FileNotFoundException("Could not locate UspMonographData.kt in workspace.")
    }

    val fileText = file.readText()
    val rawDataStartPattern = "private val rawMonographData = \"\"\""
    val rawDataStart = fileText.indexOf(rawDataStartPattern)
    val rawDataEndPattern = "\"\"\".trimIndent()"
    val rawDataEnd = fileText.indexOf(rawDataEndPattern, rawDataStart)
    val rawData = fileText.substring(rawDataStart + rawDataStartPattern.length, rawDataEnd)

    // Lines of raw monograph data
    val rawDataLines = rawData.split('\n')

    // Separate other lines (A to J, and L onwards)
    val nonKLinesBefore = mutableListOf<String>()
    val nonKLinesAfter = mutableListOf<String>()
    val existingKLines = mutableMapOf<String, String>()

    var encounteredK = false
    var finishedK = false

    for (line in rawDataLines) {
      val trimmed = line.trim()
      if (trimmed.isEmpty()) continue
      val firstChar = trimmed[0]
      if (firstChar == 'K') {
        encounteredK = true
        val key = trimmed.split('|')[0].trim().uppercase()
        existingKLines[key] = line // Store the full original formatted line
      } else {
        if (!encounteredK) {
          if (firstChar > 'K') {
            finishedK = true
            nonKLinesAfter.add(line)
          } else {
            nonKLinesBefore.add(line)
          }
        } else {
          finishedK = true
          nonKLinesAfter.add(line)
        }
      }
    }

    println("Total existing 'K' monographs: ${existingKLines.size}")

    // Now, let's build the final collection of K lines
    val finalKLinesMap = mutableMapOf<String, String>()

    // Start with all existing K lines to preserve their detailed HPLC column info if they have any
    finalKLinesMap.putAll(existingKLines)

    val addedItems = mutableListOf<String>()
    // Add all missing K lines from the input list (only if not already present)
    for (name in rawList) {
      val key = name.uppercase()
      if (!finalKLinesMap.containsKey(key)) {
        val (active, form) = getActiveAndForm(name)
        finalKLinesMap[key] = "        $key|$active|$form"
        addedItems.add(name)
      }
    }

    // Sort all combined K lines alphabetically by their key
    val sortedKLines = finalKLinesMap.entries.sortedBy { it.key }.map { entry ->
      val line = entry.value
      val trimmedLine = line.trim()
      "        $trimmedLine"
    }

    // Combine everything back together
    val newRawDataContent = buildString {
      append("\n")
      nonKLinesBefore.forEach { append(it).append("\n") }
      sortedKLines.forEach { append(it).append("\n") }
      nonKLinesAfter.forEach { append(it).append("\n") }
      append("    ") // alignment for closing triple quote
    }

    val updatedFileText = fileText.substring(0, rawDataStart + rawDataStartPattern.length) +
        newRawDataContent +
        fileText.substring(rawDataEnd)

    file.writeText(updatedFileText)
    
    val uniqueUserList = rawList.map { it.trim().uppercase() }.distinct()
    val inUserNotDb = uniqueUserList.filter { !existingKLines.containsKey(it) }
    val inDbNotUser = existingKLines.keys.filter { !uniqueUserList.contains(it) }

    println("--- SUMMARY OF THE MERGE ---")
    println("Total raw input lines from user: ${rawList.size}")
    println("Unique items in user's list: ${uniqueUserList.size}")
    println("Existing 'K' monographs in database before merge: ${existingKLines.size}")
    println("Newly added 'K' monographs: ${addedItems.size}")
    println("Total 'K' monographs in database after merge: ${sortedKLines.size}")
    println("Items in user's list but NOT in the database: $inUserNotDb")
    println("Items in the database but NOT in user's list: $inDbNotUser")
    println("Successfully merged and updated UspMonographData.kt!")
  }

  @Test
  fun compareAndUpdateLMonographs() {
    val rawList = listOf(
      "Labetalol Hydrochloride Compounded Oral Suspension",
      "Labetalol Hydrochloride Injection",
      "Labetalol Hydrochloride Tablets",
      "Labetalol Hydrochloride",
      "Lacosamide Injection",
      "Lacosamide Oral Solution",
      "Lacosamide Tablets",
      "Lacosamide",
      "Lactase",
      "Lactated Ringer's and Dextrose Injection",
      "Lactated Ringer's Injection",
      "Lactic Acid",
      "Lactulose Concentrate",
      "Lactulose Solution",
      "Lamivudine and Zidovudine Tablets",
      "Lamivudine Oral Solution",
      "Lamivudine Tablets",
      "Lamivudine",
      "Lamotrigine Compounded Oral Suspension",
      "Lamotrigine Extended-Release Tablets",
      "Lamotrigine Orally Disintegrating Tablets",
      "Lamotrigine Tablets for Oral Suspension",
      "Lamotrigine Tablets",
      "Lamotrigine",
      "Lanolin",
      "Lansoprazole Compounded Oral Suspension",
      "Lansoprazole Delayed-Release Capsules",
      "Lansoprazole",
      "Latanoprost Compounded Topical Solution",
      "Latanoprost",
      "Leflunomide Compounded Oral Suspension",
      "Leflunomide Tablets",
      "Leflunomide",
      "Lemon Tincture",
      "Letrozole Tablets",
      "Letrozole",
      "Leucine",
      "Leucovorin Calcium Compounded Oral Suspension",
      "Leucovorin Calcium for Injection",
      "Leucovorin Calcium Injection",
      "Leucovorin Calcium Tablets",
      "Leucovorin Calcium",
      "Leuprolide Acetate",
      "Levalbuterol Hydrochloride",
      "Levalbuterol Inhalation Solution",
      "Levamisole Hydrochloride Tablets",
      "Levamisole Hydrochloride",
      "Levetiracetam Extended-Release Tablets",
      "Levetiracetam Injection",
      "Levetiracetam Oral Solution",
      "Levetiracetam Tablets",
      "Levetiracetam",
      "Levmetamfetamine",
      "Levobunolol Hydrochloride Ophthalmic Solution",
      "Levobunolol Hydrochloride",
      "Levocabastine Hydrochloride",
      "Levocarnitine Injection",
      "Levocarnitine Oral Solution",
      "Levocarnitine Tablets",
      "Levocarnitine",
      "Levocetirizine Dihydrochloride Tablets",
      "Levocetirizine Dihydrochloride",
      "Levodopa",
      "Levofloxacin Oral Solution",
      "Levofloxacin Tablets",
      "Levofloxacin",
      "Levonordefrin",
      "Levonorgestrel and Ethinyl Estradiol Tablets",
      "Levonorgestrel",
      "Levorphanol Tartrate Tablets",
      "Levorphanol Tartrate",
      "Levothyroxine Sodium Oral Powder",
      "Levothyroxine Sodium Tablets",
      "Levothyroxine Sodium",
      "Lidocaine and Prilocaine Cream",
      "Lidocaine Hydrochloride and Dextrose Injection",
      "Lidocaine Hydrochloride and Epinephrine Injection",
      "Lidocaine Hydrochloride Injection",
      "Lidocaine Hydrochloride Jelly",
      "Lidocaine Hydrochloride Oral Topical Solution",
      "Lidocaine Hydrochloride Topical Solution",
      "Lidocaine Hydrochloride",
      "Lidocaine Ointment",
      "Lidocaine Oral Topical Solution",
      "Lidocaine Topical Aerosol",
      "Lidocaine, Racepinephrine and Tetracaine Hydrochlorides Compounded Topical Gel",
      "Lidocaine",
      "Lincomycin Hydrochloride Capsules",
      "Lincomycin Hydrochloride Soluble Powder",
      "Lincomycin Hydrochloride",
      "Lincomycin Injection",
      "Lincomycin Oral Solution",
      "Lindane Cream",
      "Lindane Shampoo",
      "Lindane",
      "Linezolid Tablets",
      "Linezolid",
      "Liothyronine Sodium Injection",
      "Liothyronine Sodium Tablets",
      "Liothyronine Sodium",
      "Lipid Injectable Emulsion",
      "Liquefied Phenol",
      "Lisinopril and Hydrochlorothiazide Tablets",
      "Lisinopril Compounded Oral Suspension",
      "Lisinopril Tablets",
      "Lisinopril",
      "Lithium Carbonate Capsules",
      "Lithium Carbonate Extended-Release Tablets",
      "Lithium Carbonate Tablets",
      "Lithium Carbonate",
      "Lithium Citrate",
      "Lithium Hydroxide",
      "Lithium Oral Solution",
      "Lomustine Capsules",
      "Lomustine",
      "Loperamide Hydrochloride Capsules",
      "Loperamide Hydrochloride Oral Solution",
      "Loperamide Hydrochloride Tablets",
      "Loperamide Hydrochloride",
      "Lopinavir and Ritonavir Oral Solution",
      "Lopinavir and Ritonavir Tablets",
      "Lopinavir",
      "Loratadine Capsules",
      "Loratadine Chewable Tablets",
      "Loratadine Oral Solution",
      "Loratadine Orally Disintegrating Tablets",
      "Loratadine Tablets",
      "Loratadine",
      "Lorazepam Injection",
      "Lorazepam Oral Concentrate",
      "Lorazepam Tablets",
      "Lorazepam",
      "Losartan Potassium and Hydrochlorothiazide Tablets",
      "Losartan Potassium Tablets",
      "Losartan Potassium",
      "Lovastatin Tablets",
      "Lovastatin",
      "Loxapine Capsules",
      "Loxapine Succinate",
      "Lufenuron",
      "Lumefantrine",
      "Lysine Acetate",
      "Lysine Hydrochloride"
    )

    println("Total input items from user: ${rawList.size}")

    // Dynamic file path setup
    val userDir = System.getProperty("user.dir")
    var file: File? = null
    val pathsToCheck = listOf(
      "src/main/java/com/example/data/UspMonographData.kt",
      "app/src/main/java/com/example/data/UspMonographData.kt",
      "../src/main/java/com/example/data/UspMonographData.kt",
      "../app/src/main/java/com/example/data/UspMonographData.kt"
    )
    for (p in pathsToCheck) {
      val f = File(p)
      if (f.exists()) { file = f; break }
      val absF = File(userDir, p)
      if (absF.exists()) { file = absF; break }
    }
    if (file == null) {
      val searchRoot = File(userDir).parentFile ?: File(userDir)
      val foundFiles = searchRoot.walkTopDown().filter { it.name == "UspMonographData.kt" }.toList()
      if (foundFiles.isNotEmpty()) { file = foundFiles.first() }
    }
    if (file == null) {
      throw FileNotFoundException("Could not locate UspMonographData.kt in workspace.")
    }

    val fileText = file.readText()
    val rawDataStartPattern = "private val rawMonographData = \"\"\""
    val rawDataStart = fileText.indexOf(rawDataStartPattern)
    val rawDataEndPattern = "\"\"\".trimIndent()"
    val rawDataEnd = fileText.indexOf(rawDataEndPattern, rawDataStart)
    val rawData = fileText.substring(rawDataStart + rawDataStartPattern.length, rawDataEnd)

    // Lines of raw monograph data
    val rawDataLines = rawData.split('\n')

    // Separate other lines (A to K, and M onwards)
    val nonLLinesBefore = mutableListOf<String>()
    val nonLLinesAfter = mutableListOf<String>()
    val existingLLines = mutableMapOf<String, String>()

    var encounteredL = false
    var finishedL = false

    for (line in rawDataLines) {
      val trimmed = line.trim()
      if (trimmed.isEmpty()) continue
      val firstChar = trimmed[0]
      if (firstChar == 'L') {
        encounteredL = true
        val key = trimmed.split('|')[0].trim().uppercase()
        existingLLines[key] = line // Store the full original formatted line
      } else {
        if (!encounteredL) {
          if (firstChar > 'L') {
            finishedL = true
            nonLLinesAfter.add(line)
          } else {
            nonLLinesBefore.add(line)
          }
        } else {
          finishedL = true
          nonLLinesAfter.add(line)
        }
      }
    }

    println("Total existing 'L' monographs: ${existingLLines.size}")

    // Now, let's build the final collection of L lines
    val finalLLinesMap = mutableMapOf<String, String>()

    // Start with all existing L lines to preserve their detailed HPLC column info if they have any
    finalLLinesMap.putAll(existingLLines)

    val addedItems = mutableListOf<String>()
    // Add all missing L lines from the input list (only if not already present)
    for (name in rawList) {
      val key = name.uppercase()
      if (!finalLLinesMap.containsKey(key)) {
        val (active, form) = getActiveAndForm(name)
        finalLLinesMap[key] = "        $key|$active|$form"
        addedItems.add(name)
      }
    }

    // Sort all combined L lines alphabetically by their key
    val sortedLLines = finalLLinesMap.entries.sortedBy { it.key }.map { entry ->
      val line = entry.value
      val trimmedLine = line.trim()
      "        $trimmedLine"
    }

    // Combine everything back together
    val newRawDataContent = buildString {
      append("\n")
      nonLLinesBefore.forEach { append(it).append("\n") }
      sortedLLines.forEach { append(it).append("\n") }
      nonLLinesAfter.forEach { append(it).append("\n") }
      append("    ") // alignment for closing triple quote
    }

    val updatedFileText = fileText.substring(0, rawDataStart + rawDataStartPattern.length) +
        newRawDataContent +
        fileText.substring(rawDataEnd)

    file.writeText(updatedFileText)
    
    val uniqueUserList = rawList.map { it.trim().uppercase() }.distinct()
    val inUserNotDb = uniqueUserList.filter { !existingLLines.containsKey(it) }
    val inDbNotUser = existingLLines.keys.filter { !uniqueUserList.contains(it) }

    println("--- SUMMARY OF THE MERGE ---")
    println("Total raw input lines from user: ${rawList.size}")
    println("Unique items in user's list: ${uniqueUserList.size}")
    println("Existing 'L' monographs in database before merge: ${existingLLines.size}")
    println("Newly added 'L' monographs: ${addedItems.size}")
    println("Total 'L' monographs in database after merge: ${sortedLLines.size}")
    println("Items in user's list but NOT in the database: $inUserNotDb")
    println("Items in the database but NOT in user's list: $inDbNotUser")
    println("Successfully merged and updated UspMonographData.kt!")
  }

  @Test
  fun compareAndUpdateMMonographs() {
    val rawList = listOf(
      "Mafenide Acetate Cream",
      "Mafenide Acetate for Topical Solution",
      "Mafenide Acetate",
      "Magaldrate and Simethicone Chewable Tablets",
      "Magaldrate and Simethicone Oral Suspension",
      "Magaldrate",
      "Magnesia Tablets",
      "Magnesium Carbonate and Citric Acid for Oral Solution",
      "Magnesium Carbonate and Sodium Bicarbonate for Oral Suspension",
      "Magnesium Carbonate, Citric Acid, and Potassium Citrate for Oral Solution",
      "Magnesium Carbonate",
      "Magnesium Chloride",
      "Magnesium Citrate for Oral Solution",
      "Magnesium Citrate Oral Solution",
      "Magnesium Citrate",
      "Magnesium Gluconate Tablets",
      "Magnesium Gluconate",
      "Magnesium Hydroxide Paste",
      "Magnesium Hydroxide",
      "Magnesium Oxide Capsules",
      "Magnesium Oxide Tablets",
      "Magnesium Oxide",
      "Magnesium Phosphate",
      "Magnesium Salicylate Tablets",
      "Magnesium Salicylate",
      "Magnesium Sulfate in Dextrose Injection",
      "Magnesium Sulfate Injection",
      "Magnesium Sulfate",
      "Magnesium Trisilicate Tablets",
      "Magnesium Trisilicate",
      "Malathion Lotion",
      "Malathion",
      "Manganese Chloride Injection",
      "Manganese Chloride",
      "Manganese Gluconate",
      "Manganese Sulfate Injection",
      "Manganese Sulfate",
      "Mannitol Compounded Injection",
      "Mannitol in Sodium Chloride Injection",
      "Mannitol Injection",
      "Mannitol",
      "Maprotiline Hydrochloride Tablets",
      "Maprotiline Hydrochloride",
      "Marbofloxacin Compounded Oral Suspension, Veterinary",
      "Mebendazole Oral Suspension",
      "Mebendazole Tablets",
      "Mebendazole",
      "Mebrofenin",
      "Mecamylamine Hydrochloride Tablets",
      "Mecamylamine Hydrochloride",
      "Mechlorethamine Hydrochloride for Injection",
      "Mechlorethamine Hydrochloride",
      "Meclizine Hydrochloride Tablets",
      "Meclizine Hydrochloride",
      "Meclofenamate Sodium Capsules",
      "Meclofenamate Sodium",
      "Medical Air",
      "Medroxyprogesterone Acetate Injectable Suspension",
      "Medroxyprogesterone Acetate Tablets",
      "Medroxyprogesterone Acetate",
      "Mefenamic Acid Capsules",
      "Mefenamic Acid",
      "Mefloquine Hydrochloride Tablets",
      "Mefloquine Hydrochloride",
      "Megestrol Acetate Oral Suspension",
      "Megestrol Acetate Tablets",
      "Megestrol Acetate",
      "Meglumine",
      "Melengestrol Acetate",
      "Meloxicam Oral Suspension",
      "Meloxicam Tablets",
      "Meloxicam",
      "Melphalan Tablets",
      "Melphalan",
      "Memantine Hydrochloride Tablets",
      "Memantine Hydrochloride",
      "Menadione",
      "Menthol Lozenges",
      "Menthol",
      "Meperidine Hydrochloride Injection",
      "Meperidine Hydrochloride Oral Solution",
      "Meperidine Hydrochloride Tablets",
      "Meperidine Hydrochloride",
      "Mephobarbital",
      "Mepivacaine Hydrochloride and Levonordefrin Injection",
      "Mepivacaine Hydrochloride Injection",
      "Mepivacaine Hydrochloride",
      "Meprobamate Tablets",
      "Meprobamate",
      "Meradimate",
      "Mercaptopurine Tablets",
      "Mercaptopurine",
      "Meropenem for Injection",
      "Meropenem",
      "Mesalamine Delayed-Release Tablets",
      "Mesalamine Extended-Release Capsules",
      "Mesalamine Rectal Suspension",
      "Mesalamine Suppositories",
      "Mesalamine",
      "Mesna Tablets",
      "Mesna",
      "Mestranol",
      "Metacresol",
      "Metaproterenol Sulfate Oral Solution",
      "Metaproterenol Sulfate Tablets",
      "Metaproterenol Sulfate",
      "Metaraminol Bitartrate Injection",
      "Metaraminol Bitartrate",
      "Metaxalone Tablets",
      "Metaxalone",
      "Metformin Hydrochloride Extended-Release Tablets",
      "Metformin Hydrochloride Tablets",
      "Metformin Hydrochloride",
      "Methacholine Chloride",
      "Methacycline Hydrochloride",
      "Methadone Hydrochloride Injection",
      "Methadone Hydrochloride Oral Concentrate",
      "Methadone Hydrochloride Oral Solution",
      "Methadone Hydrochloride Tablets for Oral Suspension",
      "Methadone Hydrochloride Tablets",
      "Methadone Hydrochloride",
      "Methamphetamine Hydrochloride Tablets",
      "Methamphetamine Hydrochloride",
      "Methazolamide Tablets",
      "Methazolamide",
      "Methenamine Hippurate Tablets",
      "Methenamine Hippurate",
      "Methenamine Mandelate Tablets",
      "Methenamine Mandelate",
      "Methenamine",
      "Methimazole Tablets",
      "Methimazole",
      "Methionine",
      "Methocarbamol Injection",
      "Methocarbamol Tablets",
      "Methocarbamol",
      "Methohexital Sodium for Injection",
      "Methohexital",
      "Methotrexate for Injection",
      "Methotrexate Injection",
      "Methotrexate Tablets",
      "Methotrexate",
      "Methotrimeprazine Injection",
      "Methotrimeprazine",
      "Methoxsalen Capsules",
      "Methoxsalen Topical Solution",
      "Methoxsalen",
      "Methscopolamine Bromide Tablets",
      "Methscopolamine Bromide",
      "Methsuximide Capsules",
      "Methsuximide",
      "Methyclothiazide Tablets",
      "Methyclothiazide",
      "Methylbenzethonium Chloride Lotion",
      "Methylbenzethonium Chloride",
      "Methylcellulose Ophthalmic Solution",
      "Methylcellulose Oral Solution",
      "Methylcellulose Tablets",
      "Methylcellulose",
      "Methyldopa and Hydrochlorothiazide Tablets",
      "Methyldopa Tablets",
      "Methyldopa",
      "Methylene Blue Compounded Injection, Veterinary",
      "Methylene Blue Injection",
      "Methylene Blue",
      "Methylergonovine Maleate Injection",
      "Methylergonovine Maleate Tablets",
      "Methylergonovine Maleate",
      "Methylnaltrexone Bromide",
      "Methylphenidate Hydrochloride Extended-Release Tablets",
      "Methylphenidate Hydrochloride Tablets",
      "Methylphenidate Hydrochloride",
      "Methylprednisolone Acetate Injectable Suspension",
      "Methylprednisolone Acetate",
      "Methylprednisolone Hemisuccinate",
      "Methylprednisolone Sodium Succinate for Injection",
      "Methylprednisolone Sodium Succinate",
      "Methylprednisolone Tablets",
      "Methylprednisolone",
      "Methyltestosterone Capsules",
      "Methyltestosterone Tablets",
      "Methyltestosterone",
      "Methysergide Maleate",
      "Metoclopramide Hydrochloride",
      "Metoclopramide Injection",
      "Metoclopramide Oral Solution",
      "Metoclopramide Tablets",
      "Metolazone Compounded Oral Suspension",
      "Metolazone Tablets",
      "Metolazone",
      "Metoprolol Fumarate",
      "Metoprolol Succinate Extended-Release Tablets",
      "Metoprolol Succinate",
      "Metoprolol Tartrate and Hydrochlorothiazide Tablets",
      "Metoprolol Tartrate Compounded Oral Solution",
      "Metoprolol Tartrate Compounded Oral Suspension",
      "Metoprolol Tartrate Injection",
      "Metoprolol Tartrate Tablets",
      "Metoprolol Tartrate",
      "Metrifonate",
      "Metronidazole Benzoate Compounded Oral Suspension",
      "Metronidazole Benzoate",
      "Metronidazole Capsules",
      "Metronidazole Extended-Release Tablets",
      "Metronidazole Gel",
      "Metronidazole Injection",
      "Metronidazole Tablets",
      "Metronidazole",
      "Metyrapone",
      "Metyrosine Capsules",
      "Metyrosine",
      "Mexiletine Hydrochloride Capsules",
      "Mexiletine Hydrochloride",
      "Mibolerone Oral Solution",
      "Mibolerone",
      "Micafungin for Injection",
      "Micafungin Sodium",
      "Miconazole Compounded Ophthalmic Solution",
      "Miconazole Nitrate Cream",
      "Miconazole Nitrate Topical Powder",
      "Miconazole Nitrate Vaginal Suppositories",
      "Miconazole Nitrate",
      "Miconazole",
      "Midazolam Injection",
      "Midazolam",
      "Midodrine Hydrochloride Tablets",
      "Midodrine Hydrochloride",
      "Milbemycin Oxime",
      "Milk of Bismuth",
      "Milk of Magnesia",
      "Milrinone Lactate Injection",
      "Milrinone",
      "Mineral Oil Emulsion",
      "Mineral Oil, Rectal",
      "Mineral Oil",
      "Minocycline for Injection",
      "Minocycline Hydrochloride Capsules",
      "Minocycline Hydrochloride Extended-Release Tablets",
      "Minocycline Hydrochloride Tablets",
      "Minocycline Hydrochloride",
      "Minocycline Periodontal System",
      "Minoxidil Tablets",
      "Minoxidil Topical Solution",
      "Minoxidil",
      "Mirtazapine Compounded Oral Suspension, Veterinary",
      "Mirtazapine Orally Disintegrating Tablets",
      "Mirtazapine Tablets",
      "Mirtazapine",
      "Misoprostol Dispersion",
      "Misoprostol",
      "Mitomycin for Injection",
      "Mitomycin",
      "Mitotane Tablets",
      "Mitotane",
      "Mitoxantrone Hydrochloride",
      "Mitoxantrone Injection",
      "Modafinil Tablets",
      "Modafinil",
      "Modified Lactated Ringer's and Dextrose Injection",
      "Modified Lanolin",
      "Moexipril Hydrochloride and Hydrochlorothiazide Tablets",
      "Moexipril Hydrochloride Tablets",
      "Moexipril Hydrochloride",
      "Molindone Hydrochloride Tablets",
      "Molindone Hydrochloride",
      "Mometasone Furoate Cream",
      "Mometasone Furoate Ointment",
      "Mometasone Furoate Topical Solution",
      "Mometasone Furoate",
      "Monensin Granulated",
      "Monensin Sodium",
      "Monensin Type A Medicated Article",
      "Monensin",
      "Monobasic Sodium Phosphate",
      "Monobenzone",
      "Montelukast Sodium Chewable Tablets",
      "Montelukast Sodium Oral Granules",
      "Montelukast Sodium Tablets",
      "Montelukast Sodium",
      "Morantel Tartrate",
      "Morphine Sulfate Compounded Injection",
      "Morphine Sulfate Compounded Oral Solution",
      "Morphine Sulfate Compounded Suppositories",
      "Morphine Sulfate Extended-Release Capsules",
      "Morphine Sulfate Injection",
      "Morphine Sulfate",
      "Moxidectin",
      "Moxifloxacin Hydrochloride",
      "Moxifloxacin Ophthalmic Solution",
      "Moxifloxacin Tablets",
      "Multiple Electrolytes and Dextrose Injection Type 1",
      "Multiple Electrolytes and Dextrose Injection Type 2",
      "Multiple Electrolytes and Dextrose Injection Type 3",
      "Multiple Electrolytes Injection Type 1",
      "Multiple Electrolytes Injection Type 2",
      "Mupirocin Calcium",
      "Mupirocin Cream",
      "Mupirocin Nasal Ointment",
      "Mupirocin Ointment",
      "Mupirocin",
      "Mycophenolate Mofetil Capsules",
      "Mycophenolate Mofetil for Injection",
      "Mycophenolate Mofetil for Oral Suspension",
      "Mycophenolate Mofetil Tablets",
      "Mycophenolate Mofetil",
      "Mycophenolate Sodium",
      "Mycophenolic Acid Delayed-Release Tablets",
      "Myrrh Topical Solution",
      "Myrrh"
    )

    println("Total input items from user: ${rawList.size}")

    // Dynamic file path setup
    val userDir = System.getProperty("user.dir")
    var file: File? = null
    val pathsToCheck = listOf(
      "src/main/java/com/example/data/UspMonographData.kt",
      "app/src/main/java/com/example/data/UspMonographData.kt",
      "../src/main/java/com/example/data/UspMonographData.kt",
      "../app/src/main/java/com/example/data/UspMonographData.kt"
    )
    for (p in pathsToCheck) {
      val f = File(p)
      if (f.exists()) { file = f; break }
      val absF = File(userDir, p)
      if (absF.exists()) { file = absF; break }
    }
    if (file == null) {
      val searchRoot = File(userDir).parentFile ?: File(userDir)
      val foundFiles = searchRoot.walkTopDown().filter { it.name == "UspMonographData.kt" }.toList()
      if (foundFiles.isNotEmpty()) { file = foundFiles.first() }
    }
    if (file == null) {
      throw FileNotFoundException("Could not locate UspMonographData.kt in workspace.")
    }

    val fileText = file.readText()
    val rawDataStartPattern = "private val rawMonographData = \"\"\""
    val rawDataStart = fileText.indexOf(rawDataStartPattern)
    val rawDataEndPattern = "\"\"\".trimIndent()"
    val rawDataEnd = fileText.indexOf(rawDataEndPattern, rawDataStart)
    val rawData = fileText.substring(rawDataStart + rawDataStartPattern.length, rawDataEnd)

    // Lines of raw monograph data
    val rawDataLines = rawData.split('\n')

    // Separate other lines (A to L, and N onwards)
    val nonMLinesBefore = mutableListOf<String>()
    val nonMLinesAfter = mutableListOf<String>()
    val existingMLines = mutableMapOf<String, String>()

    var encounteredM = false
    var finishedM = false

    for (line in rawDataLines) {
      val trimmed = line.trim()
      if (trimmed.isEmpty()) continue
      val firstChar = trimmed[0]
      if (firstChar == 'M') {
        encounteredM = true
        val key = trimmed.split('|')[0].trim().uppercase()
        existingMLines[key] = line // Store the full original formatted line
      } else {
        if (!encounteredM) {
          if (firstChar > 'M') {
            finishedM = true
            nonMLinesAfter.add(line)
          } else {
            nonMLinesBefore.add(line)
          }
        } else {
          finishedM = true
          nonMLinesAfter.add(line)
        }
      }
    }

    println("Total existing 'M' monographs: ${existingMLines.size}")

    // Now, let's build the final collection of M lines
    val finalMLinesMap = mutableMapOf<String, String>()

    // Start with all existing M lines to preserve their detailed HPLC column info if they have any
    finalMLinesMap.putAll(existingMLines)

    val addedItems = mutableListOf<String>()
    // Add all missing M lines from the input list (only if not already present)
    for (name in rawList) {
      val key = name.uppercase()
      if (!finalMLinesMap.containsKey(key)) {
        val (active, form) = getActiveAndForm(name)
        finalMLinesMap[key] = "        $key|$active|$form"
        addedItems.add(name)
      }
    }

    // Sort all combined M lines alphabetically by their key
    val sortedMLines = finalMLinesMap.entries.sortedBy { it.key }.map { entry ->
      val line = entry.value
      val trimmedLine = line.trim()
      "        $trimmedLine"
    }

    // Combine everything back together
    val newRawDataContent = buildString {
      append("\n")
      nonMLinesBefore.forEach { append(it).append("\n") }
      sortedMLines.forEach { append(it).append("\n") }
      nonMLinesAfter.forEach { append(it).append("\n") }
      append("    ") // alignment for closing triple quote
    }

    val updatedFileText = fileText.substring(0, rawDataStart + rawDataStartPattern.length) +
        newRawDataContent +
        fileText.substring(rawDataEnd)

    file.writeText(updatedFileText)
    
    val uniqueUserList = rawList.map { it.trim().uppercase() }.distinct()
    val inUserNotDb = uniqueUserList.filter { !existingMLines.containsKey(it) }
    val inDbNotUser = existingMLines.keys.filter { !uniqueUserList.contains(it) }

    println("--- SUMMARY OF THE MERGE ---")
    println("Total raw input lines from user: ${rawList.size}")
    println("Unique items in user's list: ${uniqueUserList.size}")
    println("Existing 'M' monographs in database before merge: ${existingMLines.size}")
    println("Newly added 'M' monographs: ${addedItems.size}")
    println("Total 'M' monographs in database after merge: ${sortedMLines.size}")
    println("Items in user's list but NOT in the database: $inUserNotDb")
    println("Items in the database but NOT in user's list: $inDbNotUser")
    println("Successfully merged and updated UspMonographData.kt!")
  }

  @Test
  fun compareAndUpdateNMonographs() {
    val rawList = listOf(
      "Nabumetone Tablets",
      "Nabumetone",
      "Nadolol and Bendroflumethiazide Tablets",
      "Nadolol Tablets",
      "Nadolol",
      "Nafcillin for Injection",
      "Nafcillin Injection",
      "Nafcillin Sodium",
      "Naftifine Hydrochloride Cream",
      "Naftifine Hydrochloride Gel",
      "Naftifine Hydrochloride",
      "Nalorphine Hydrochloride Injection",
      "Nalorphine Hydrochloride",
      "Naloxone Hydrochloride Injection",
      "Naloxone Hydrochloride",
      "Naltrexone Hydrochloride Compounded Cream",
      "Naltrexone Hydrochloride Tablets",
      "Naltrexone Hydrochloride",
      "Nandrolone Decanoate Injection",
      "Nandrolone Decanoate",
      "Naphazoline Hydrochloride and Pheniramine Maleate Ophthalmic Solution",
      "Naphazoline Hydrochloride Nasal Solution",
      "Naphazoline Hydrochloride Ophthalmic Solution",
      "Naphazoline Hydrochloride",
      "Naproxen Compounded Oral Suspension",
      "Naproxen Delayed-Release Tablets",
      "Naproxen Oral Suspension",
      "Naproxen Sodium and Pseudoephedrine Hydrochloride Extended-Release Tablets",
      "Naproxen Sodium Tablets",
      "Naproxen Sodium",
      "Naproxen Tablets",
      "Naproxen",
      "Narasin Granular",
      "Narasin Type A Medicated Article",
      "Naratriptan Compounded Oral Suspension",
      "Naratriptan Hydrochloride",
      "Naratriptan Tablets",
      "Natamycin Ophthalmic Suspension",
      "Natamycin",
      "Nateglinide Tablets",
      "Nateglinide",
      "Nefazodone Hydrochloride Tablets",
      "Nefazodone Hydrochloride",
      "Neomycin and Polymyxin B Sulfates and Bacitracin Ointment",
      "Neomycin and Polymyxin B Sulfates and Bacitracin Ophthalmic Ointment",
      "Neomycin and Polymyxin B Sulfates and Bacitracin Zinc Ointment",
      "Neomycin and Polymyxin B Sulfates and Bacitracin Zinc Ophthalmic Ointment",
      "Neomycin and Polymyxin B Sulfates and Dexamethasone Ophthalmic Ointment",
      "Neomycin and Polymyxin B Sulfates and Dexamethasone Ophthalmic Suspension",
      "Neomycin and Polymyxin B Sulfates and Gramicidin Ophthalmic Solution",
      "Neomycin and Polymyxin B Sulfates and Hydrocortisone Acetate Cream",
      "Neomycin and Polymyxin B Sulfates and Hydrocortisone Ophthalmic Suspension",
      "Neomycin and Polymyxin B Sulfates and Hydrocortisone Otic Solution",
      "Neomycin and Polymyxin B Sulfates and Hydrocortisone Otic Suspension",
      "Neomycin and Polymyxin B Sulfates and Lidocaine Cream",
      "Neomycin and Polymyxin B Sulfates and Pramoxine Hydrochloride Cream",
      "Neomycin and Polymyxin B Sulfates and Prednisolone Acetate Ophthalmic Suspension",
      "Neomycin and Polymyxin B Sulfates Ophthalmic Ointment",
      "Neomycin and Polymyxin B Sulfates Ophthalmic Solution",
      "Neomycin and Polymyxin B Sulfates Solution for Irrigation",
      "Neomycin and Polymyxin B Sulfates, Bacitracin Zinc, and Hydrocortisone Acetate Ophthalmic Ointment",
      "Neomycin and Polymyxin B Sulfates, Bacitracin Zinc, and Hydrocortisone Ointment",
      "Neomycin and Polymyxin B Sulfates, Bacitracin Zinc, and Hydrocortisone Ophthalmic Ointment",
      "Neomycin and Polymyxin B Sulfates, Bacitracin Zinc, and Lidocaine Ointment",
      "Neomycin and Polymyxin B Sulfates, Bacitracin, and Hydrocortisone Acetate Ointment",
      "Neomycin and Polymyxin B Sulfates, Bacitracin, and Hydrocortisone Acetate Ophthalmic Ointment",
      "Neomycin and Polymyxin B Sulfates, Bacitracin, and Lidocaine Ointment",
      "Neomycin Boluses",
      "Neomycin for Injection",
      "Neomycin Sulfate and Bacitracin Ointment",
      "Neomycin Sulfate and Bacitracin Zinc Ointment",
      "Neomycin Sulfate and Dexamethasone Sodium Phosphate Ophthalmic Ointment",
      "Neomycin Sulfate and Dexamethasone Sodium Phosphate Ophthalmic Solution",
      "Neomycin Sulfate and Fluocinolone Acetonide Cream",
      "Neomycin Sulfate and Fluorometholone Ointment",
      "Neomycin Sulfate and Flurandrenolide Ointment",
      "Neomycin Sulfate and Gramicidin Ointment",
      "Neomycin Sulfate and Hydrocortisone Acetate Ointment",
      "Neomycin Sulfate and Hydrocortisone Acetate Ophthalmic Suspension",
      "Neomycin Sulfate and Hydrocortisone Cream",
      "Neomycin Sulfate and Hydrocortisone Ointment",
      "Neomycin Sulfate and Hydrocortisone Otic Suspension",
      "Neomycin Sulfate and Methylprednisolone Acetate Cream",
      "Neomycin Sulfate and Prednisolone Acetate Ointment",
      "Neomycin Sulfate and Prednisolone Acetate Ophthalmic Suspension",
      "Neomycin Sulfate and Triamcinolone Acetonide Cream",
      "Neomycin Sulfate Cream",
      "Neomycin Sulfate Ointment",
      "Neomycin Sulfate Ophthalmic Ointment",
      "Neomycin Sulfate Oral Solution",
      "Neomycin Sulfate Tablets",
      "Neomycin Sulfate, Isoflupredone Acetate, and Tetracaine Hydrochloride Ointment",
      "Neomycin Sulfate, Isoflupredone Acetate, and Tetracaine Hydrochloride Topical Powder",
      "Neomycin Sulfate",
      "Neostigmine Bromide Tablets",
      "Neostigmine Bromide",
      "Neostigmine Methylsulfate Injection",
      "Neostigmine Methylsulfate",
      "Nevirapine Extended-Release Tablets",
      "Nevirapine Oral Suspension",
      "Nevirapine Tablets",
      "Nevirapine",
      "Niacin Extended-Release Tablets",
      "Niacin Injection",
      "Niacin Tablets",
      "Niacin",
      "Niacinamide Injection",
      "Niacinamide Tablets",
      "Niacinamide",
      "Nicardipine Hydrochloride Injection",
      "Nicardipine Hydrochloride",
      "Nicotine Polacrilex Gum",
      "Nicotine Polacrilex",
      "Nicotine Transdermal System",
      "Nicotine",
      "Nifedipine Capsules",
      "Nifedipine Extended-Release Tablets",
      "Nifedipine",
      "Nilutamide",
      "Nimodipine",
      "Nitrofurantoin Capsules",
      "Nitrofurantoin Oral Suspension",
      "Nitrofurantoin Tablets",
      "Nitrofurantoin",
      "Nitrofurazone Ointment",
      "Nitrofurazone",
      "Nitroglycerin Injection",
      "Nitroglycerin Ointment",
      "Nitroglycerin Sublingual Tablets",
      "Nitromersol Topical Solution",
      "Nitromersol",
      "Nitrous Oxide",
      "Nizatidine Capsules",
      "Nizatidine",
      "Nonabsorbable Surgical Suture",
      "Norelgestromin",
      "Norepinephrine Bitartrate Injection",
      "Norepinephrine Bitartrate",
      "Norethindrone Acetate and Ethinyl Estradiol Tablets",
      "Norethindrone Acetate Tablets",
      "Norethindrone Acetate",
      "Norethindrone and Ethinyl Estradiol Tablets",
      "Norethindrone and Mestranol Tablets",
      "Norethindrone Tablets",
      "Norethindrone",
      "Norgestimate and Ethinyl Estradiol Tablets",
      "Norgestimate",
      "Norgestrel and Ethinyl Estradiol Tablets",
      "Norgestrel Tablets",
      "Norgestrel",
      "Nortriptyline Hydrochloride Capsules",
      "Nortriptyline Hydrochloride Oral Solution",
      "Nortriptyline Hydrochloride",
      "Noscapine",
      "Novobiocin Sodium Intramammary Infusion",
      "Novobiocin Sodium",
      "Nystatin and Triamcinolone Acetonide Cream",
      "Nystatin and Triamcinolone Acetonide Ointment",
      "Nystatin Cream",
      "Nystatin for Oral Suspension",
      "Nystatin Lotion",
      "Nystatin Lozenges",
      "Nystatin Ointment",
      "Nystatin Oral Suspension",
      "Nystatin Tablets",
      "Nystatin Topical Powder",
      "Nystatin Vaginal Inserts",
      "Nystatin Vaginal Suppositories",
      "Nystatin, Neomycin Sulfate, Gramicidin, and Triamcinolone Acetonide Cream",
      "Nystatin, Neomycin Sulfate, Gramicidin, and Triamcinolone Acetonide Ointment",
      "Nystatin, Neomycin Sulfate, Thiostrepton, and Triamcinolone Acetonide Cream",
      "Nystatin, Neomycin Sulfate, Thiostrepton, and Triamcinolone Acetonide Ointment",
      "Nystatin"
    )

    println("Total input items from user: ${rawList.size}")

    // Dynamic file path setup
    val userDir = System.getProperty("user.dir")
    var file: File? = null
    val pathsToCheck = listOf(
      "src/main/java/com/example/data/UspMonographData.kt",
      "app/src/main/java/com/example/data/UspMonographData.kt",
      "../src/main/java/com/example/data/UspMonographData.kt",
      "../app/src/main/java/com/example/data/UspMonographData.kt"
    )
    for (p in pathsToCheck) {
      val f = File(p)
      if (f.exists()) { file = f; break }
      val absF = File(userDir, p)
      if (absF.exists()) { file = absF; break }
    }
    if (file == null) {
      val searchRoot = File(userDir).parentFile ?: File(userDir)
      val foundFiles = searchRoot.walkTopDown().filter { it.name == "UspMonographData.kt" }.toList()
      if (foundFiles.isNotEmpty()) { file = foundFiles.first() }
    }
    if (file == null) {
      throw FileNotFoundException("Could not locate UspMonographData.kt in workspace.")
    }

    val fileText = file.readText()
    val rawDataStartPattern = "private val rawMonographData = \"\"\""
    val rawDataStart = fileText.indexOf(rawDataStartPattern)
    val rawDataEndPattern = "\"\"\".trimIndent()"
    val rawDataEnd = fileText.indexOf(rawDataEndPattern, rawDataStart)
    val rawData = fileText.substring(rawDataStart + rawDataStartPattern.length, rawDataEnd)

    // Lines of raw monograph data
    val rawDataLines = rawData.split('\n')

    // Separate other lines (A to M, and O onwards)
    val nonNLinesBefore = mutableListOf<String>()
    val nonNLinesAfter = mutableListOf<String>()
    val existingNLines = mutableMapOf<String, String>()

    var encounteredN = false
    var finishedN = false

    for (line in rawDataLines) {
      val trimmed = line.trim()
      if (trimmed.isEmpty()) continue
      val firstChar = trimmed[0]
      if (firstChar == 'N') {
        encounteredN = true
        val key = trimmed.split('|')[0].trim().uppercase()
        existingNLines[key] = line // Store the full original formatted line
      } else {
        if (!encounteredN) {
          if (firstChar > 'N') {
            finishedN = true
            nonNLinesAfter.add(line)
          } else {
            nonNLinesBefore.add(line)
          }
        } else {
          finishedN = true
          nonNLinesAfter.add(line)
        }
      }
    }

    println("Total existing 'N' monographs: ${existingNLines.size}")

    // Now, let's build the final collection of N lines
    val finalNLinesMap = mutableMapOf<String, String>()

    // Start with all existing N lines to preserve their detailed HPLC column info if they have any
    finalNLinesMap.putAll(existingNLines)

    val addedItems = mutableListOf<String>()
    // Add all missing N lines from the input list (only if not already present)
    for (name in rawList) {
      val key = name.uppercase()
      if (!finalNLinesMap.containsKey(key)) {
        val (active, form) = getActiveAndForm(name)
        finalNLinesMap[key] = "        $key|$active|$form"
        addedItems.add(name)
      }
    }

    // Sort all combined N lines alphabetically by their key
    val sortedNLines = finalNLinesMap.entries.sortedBy { it.key }.map { entry ->
      val line = entry.value
      val trimmedLine = line.trim()
      "        $trimmedLine"
    }

    // Combine everything back together
    val newRawDataContent = buildString {
      append("\n")
      nonNLinesBefore.forEach { append(it).append("\n") }
      sortedNLines.forEach { append(it).append("\n") }
      nonNLinesAfter.forEach { append(it).append("\n") }
      append("    ") // alignment for closing triple quote
    }

    val updatedFileText = fileText.substring(0, rawDataStart + rawDataStartPattern.length) +
        newRawDataContent +
        fileText.substring(rawDataEnd)

    file.writeText(updatedFileText)
    
    val uniqueUserList = rawList.map { it.trim().uppercase() }.distinct()
    val inUserNotDb = uniqueUserList.filter { !existingNLines.containsKey(it) }
    val inDbNotUser = existingNLines.keys.filter { !uniqueUserList.contains(it) }

    println("--- SUMMARY OF THE MERGE ---")
    println("Total raw input lines from user: ${rawList.size}")
    println("Unique items in user's list: ${uniqueUserList.size}")
    println("Existing 'N' monographs in database before merge: ${existingNLines.size}")
    println("Newly added 'N' monographs: ${addedItems.size}")
    println("Total 'N' monographs in database after merge: ${sortedNLines.size}")
    println("Items in user's list but NOT in the database: $inUserNotDb")
    println("Items in the database but NOT in user's list: $inDbNotUser")
    println("Successfully merged and updated UspMonographData.kt!")
  }

  @Test
  fun compareAndUpdateOMonographs() {
    val rawList = listOf(
      "Octinoxate",
      "Octisalate",
      "Octocrylene",
      "Octreotide Acetate",
      "Ofloxacin Ophthalmic Solution",
      "Ofloxacin Tablets",
      "Ofloxacin",
      "Olanzapine and Fluoxetine Capsules",
      "Olanzapine Orally Disintegrating Tablets",
      "Olanzapine Tablets",
      "Olanzapine",
      "Oleovitamin A and D Capsules",
      "Oleovitamin A and D",
      "Olmesartan Medoxomil Tablets",
      "Olmesartan Medoxomil",
      "Olopatadine Hydrochloride Ophthalmic Solution",
      "Olopatadine Hydrochloride",
      "Omega-3-Acid Ethyl Esters Capsules",
      "Omega-3-Acid Ethyl Esters",
      "Omeprazole Delayed-Release Capsules",
      "Omeprazole Magnesium",
      "Omeprazole",
      "Ondansetron Compounded Oral Suspension",
      "Ondansetron Compounded Topical Gel",
      "Ondansetron Hydrochloride",
      "Ondansetron Injection",
      "Ondansetron Oral Solution",
      "Ondansetron Orally Disintegrating Tablets",
      "Ondansetron Tablets",
      "Ondansetron",
      "Opium Tincture",
      "Opium",
      "Oral Powder Containing at Least Three of the Following—Acetaminophen and Salts Chlorpheniramine, Dextromethorphan, Pseudoephedrine",
      "Oral Rehydration Salts",
      "Oral Solution Containing at Least Three of the Following—Acetaminophen and Salts of Chlorpheniramine, Dextromethorphan, and Pseudoephedrine",
      "Orange Syrup",
      "Orbifloxacin Tablets",
      "Orbifloxacin",
      "Orlistat Capsules",
      "Orlistat",
      "Orphenadrine Citrate Extended-Release Tablets",
      "Orphenadrine Citrate Injection",
      "Orphenadrine Citrate, Aspirin, and Caffeine Tablets",
      "Orphenadrine Citrate",
      "Oseltamivir Phosphate Capsules",
      "Oseltamivir Phosphate",
      "Oxacillin for Injection",
      "Oxacillin Injection",
      "Oxacillin Sodium",
      "Oxaliplatin for Injection",
      "Oxaliplatin Injection",
      "Oxaliplatin",
      "Oxandrolone Tablets",
      "Oxandrolone",
      "Oxaprozin Tablets",
      "Oxaprozin",
      "Oxazepam Capsules",
      "Oxazepam",
      "Oxcarbazepine Oral Suspension",
      "Oxcarbazepine Tablets",
      "Oxcarbazepine",
      "Oxfendazole Oral Suspension",
      "Oxfendazole",
      "Oxiconazole Nitrate",
      "Oxidized Cellulose",
      "Oxidized Regenerated Cellulose",
      "Oxprenolol Hydrochloride",
      "Oxtriphylline",
      "Oxybenzone",
      "Oxybutynin Chloride Extended-Release Tablets",
      "Oxybutynin Chloride Oral Solution",
      "Oxybutynin Chloride Tablets",
      "Oxybutynin Chloride",
      "Oxycodone and Acetaminophen Tablets",
      "Oxycodone and Aspirin Tablets",
      "Oxycodone Hydrochloride Extended-Release Tablets",
      "Oxycodone Hydrochloride Oral Solution",
      "Oxycodone Hydrochloride Tablets",
      "Oxycodone Hydrochloride",
      "Oxycodone Terephthalate",
      "Oxygen 93 Percent",
      "Oxygen",
      "Oxymetazoline Hydrochloride Nasal Solution",
      "Oxymetazoline Hydrochloride Ophthalmic Solution",
      "Oxymetazoline Hydrochloride",
      "Oxymetholone Tablets",
      "Oxymetholone",
      "Oxymorphone Hydrochloride Extended-Release Tablets",
      "Oxymorphone Hydrochloride Injection",
      "Oxymorphone Hydrochloride Tablets",
      "Oxymorphone Hydrochloride",
      "Oxytetracycline for Injection",
      "Oxytetracycline Hydrochloride and Hydrocortisone Acetate Ophthalmic Suspension",
      "Oxytetracycline Hydrochloride and Polymyxin B Sulfate Ointment",
      "Oxytetracycline Hydrochloride and Polymyxin B Sulfate Ophthalmic Ointment",
      "Oxytetracycline Hydrochloride Capsules",
      "Oxytetracycline Hydrochloride Soluble Powder",
      "Oxytetracycline Hydrochloride",
      "Oxytetracycline Injection",
      "Oxytetracycline Tablets",
      "Oxytetracycline",
      "Oxytocin Injection",
      "Oxytocin"
    )

    println("Total input items from user: ${rawList.size}")

    // Dynamic file path setup
    val userDir = System.getProperty("user.dir")
    var file: File? = null
    val pathsToCheck = listOf(
      "src/main/java/com/example/data/UspMonographData.kt",
      "app/src/main/java/com/example/data/UspMonographData.kt",
      "../src/main/java/com/example/data/UspMonographData.kt",
      "../app/src/main/java/com/example/data/UspMonographData.kt"
    )
    for (p in pathsToCheck) {
      val f = File(p)
      if (f.exists()) { file = f; break }
      val absF = File(userDir, p)
      if (absF.exists()) { file = absF; break }
    }
    if (file == null) {
      val searchRoot = File(userDir).parentFile ?: File(userDir)
      val foundFiles = searchRoot.walkTopDown().filter { it.name == "UspMonographData.kt" }.toList()
      if (foundFiles.isNotEmpty()) { file = foundFiles.first() }
    }
    if (file == null) {
      throw FileNotFoundException("Could not locate UspMonographData.kt in workspace.")
    }

    val fileText = file.readText()
    val rawDataStartPattern = "private val rawMonographData = \"\"\""
    val rawDataStart = fileText.indexOf(rawDataStartPattern)
    val rawDataEndPattern = "\"\"\".trimIndent()"
    val rawDataEnd = fileText.indexOf(rawDataEndPattern, rawDataStart)
    val rawData = fileText.substring(rawDataStart + rawDataStartPattern.length, rawDataEnd)

    // Lines of raw monograph data
    val rawDataLines = rawData.split('\n')

    // Separate other lines (A to N, and P onwards)
    val nonOLinesBefore = mutableListOf<String>()
    val nonOLinesAfter = mutableListOf<String>()
    val existingOLines = mutableMapOf<String, String>()

    var encounteredO = false
    var finishedO = false

    for (line in rawDataLines) {
      val trimmed = line.trim()
      if (trimmed.isEmpty()) continue
      val firstChar = trimmed[0]
      if (firstChar == 'O') {
        encounteredO = true
        val key = trimmed.split('|')[0].trim().uppercase()
        existingOLines[key] = line // Store the full original formatted line
      } else {
        if (!encounteredO) {
          if (firstChar > 'O') {
            finishedO = true
            nonOLinesAfter.add(line)
          } else {
            nonOLinesBefore.add(line)
          }
        } else {
          finishedO = true
          nonOLinesAfter.add(line)
        }
      }
    }

    println("Total existing 'O' monographs: ${existingOLines.size}")

    // Now, let's build the final collection of O lines
    val finalOLinesMap = mutableMapOf<String, String>()

    // Start with all existing O lines to preserve their detailed HPLC column info if they have any
    finalOLinesMap.putAll(existingOLines)

    val addedItems = mutableListOf<String>()
    // Add all missing O lines from the input list (only if not already present)
    for (name in rawList) {
      val key = name.uppercase()
      if (!finalOLinesMap.containsKey(key)) {
        val (active, form) = getActiveAndForm(name)
        finalOLinesMap[key] = "        $key|$active|$form"
        addedItems.add(name)
      }
    }

    // Sort all combined O lines alphabetically by their key
    val sortedOLines = finalOLinesMap.entries.sortedBy { it.key }.map { entry ->
      val line = entry.value
      val trimmedLine = line.trim()
      "        $trimmedLine"
    }

    // Combine everything back together
    val newRawDataContent = buildString {
      append("\n")
      nonOLinesBefore.forEach { append(it).append("\n") }
      sortedOLines.forEach { append(it).append("\n") }
      nonOLinesAfter.forEach { append(it).append("\n") }
      append("    ") // alignment for closing triple quote
    }

    val updatedFileText = fileText.substring(0, rawDataStart + rawDataStartPattern.length) +
        newRawDataContent +
        fileText.substring(rawDataEnd)

    file.writeText(updatedFileText)
    
    val uniqueUserList = rawList.map { it.trim().uppercase() }.distinct()
    val inUserNotDb = uniqueUserList.filter { !existingOLines.containsKey(it) }
    val inDbNotUser = existingOLines.keys.filter { !uniqueUserList.contains(it) }

    println("--- SUMMARY OF THE MERGE ---")
    println("Total raw input lines from user: ${rawList.size}")
    println("Unique items in user's list: ${uniqueUserList.size}")
    println("Existing 'O' monographs in database before merge: ${existingOLines.size}")
    println("Newly added 'O' monographs: ${addedItems.size}")
    println("Total 'O' monographs in database after merge: ${sortedOLines.size}")
    println("Items in user's list but NOT in the database: $inUserNotDb")
    println("Items in the database but NOT in user's list: $inDbNotUser")
    println("Successfully merged and updated UspMonographData.kt!")
  }

  private fun getActiveAndForm(name: String): Pair<String, String> {
    val upper = name.uppercase()
    val dosageForm = when {
      upper.contains("CAPSULES") -> "Capsules"
      upper.contains("TABLETS") -> "Tablets"
      upper.contains("FOR INJECTION") -> "Injection"
      upper.contains("INJECTION") -> "Injection"
      upper.contains("ORAL SUSPENSION") || upper.contains("COMPOUNDED SUSPENSION") -> "Oral Suspension"
      upper.contains("ORAL SOLUTION") || upper.contains("TOPICAL SOLUTION") || upper.contains("OTIC SOLUTION") || upper.contains("SOLUTION") -> "Oral Solution"
      upper.contains("CREAM") -> "Cream"
      upper.contains("GEL") -> "Gel"
      upper.contains("OINTMENT") -> "Ointment"
      upper.contains("NASAL SPRAY") -> "Nasal Spray"
      upper.contains("ELIXIR") -> "Elixir"
      upper.contains("IRRIGATION") -> "Irrigation"
      upper.contains("OPHTHALMIC") -> "Ophthalmic"
      upper.contains("SUPPOSITORIES") -> "Suppositories"
      upper.contains("DEVICES") || upper.contains("DEVICE") -> "Device"
      upper.contains("MEDICATED ARTICLE") -> "Type A Medicated Article"
      else -> "Raw Material (API)"
    }

    var active = name
    val suffixes = listOf(
      " Compounded Oral Suspension, Veterinary",
      " Orally Disintegrating Tablets",
      " Delayed-Release Capsules",
      " Delayed-Release Tablets",
      " Extended-Release Capsules",
      " Extended-Release Tablets",
      " Compounded Oral Suspension",
      " Compounded Oral Solution",
      " Injectable Suspension",
      " Compounded Injection",
      " Ophthalmic Suspension",
      " Ophthalmic Solution",
      " Compounded Solution",
      " Inhalation Solution",
      " Topical Solution",
      " Otic Solution",
      " Oral Suspension",
      " for Injection",
      " Oral Solution",
      " Nasal Spray",
      " Medicated Article",
      " Preparation",
      " Capsules",
      " Tablets",
      " Injection",
      " Ointment",
      " Cream",
      " Elixir",
      " Solution",
      " Suspension",
      " Gel",
      " Boluses",
      " Magma",
      " Syrup",
      " Suture",
      " Sponge",
      " Film",
      " Gauze",
      " USP"
    )

    for (suffix in suffixes) {
      if (active.endsWith(suffix, ignoreCase = true)) {
        active = active.substring(0, active.length - suffix.length).trim()
        break
      }
    }
    
    // Quick sanitization of common salt suffixes or details
    if (active.endsWith(" Hydrochloride", ignoreCase = true)) {
      active = active.substring(0, active.length - " Hydrochloride".length).trim() + " HCl"
    }

    return Pair(active, dosageForm)
  }

  @org.junit.Test
  fun generateHtmlWebsite() {
    val escapedColumns = com.example.data.UspColumnData.columns.joinToString(prefix = "[", postfix = "]") { col ->
      """
      {
        "code": "${escapeJsString(col.code)}",
        "name": "${escapeJsString(col.name)}",
        "description": "${escapeJsString(col.description)}",
        "packingMaterial": "${escapeJsString(col.packingMaterial)}",
        "carbonLoadRange": "${escapeJsString(col.carbonLoadRange)}",
        "phRange": "${escapeJsString(col.phRange)}",
        "maxTemp": "${escapeJsString(col.maxTemp)}",
        "particleSizes": "${escapeJsString(col.particleSizes)}",
        "typicalApplications": [${col.typicalApplications.joinToString { "\"${escapeJsString(it)}\"" }}],
        "popularBrands": [${col.popularBrands.joinToString { "\"${escapeJsString(it)}\"" }}]
      }
      """.trimIndent()
    }

    val escapedMonographs = com.example.data.UspMonographData.monographs.joinToString(prefix = "[", postfix = "]") { mono ->
      val colsJson = mono.columnsUsed.joinToString(prefix = "[", postfix = "]") { col ->
        """
        {
          "pf": "${escapeJsString(col.pf)}",
          "lgsCode": "${escapeJsString(col.lgsCode)}",
          "brand": "${escapeJsString(col.brand)}",
          "testType": "${escapeJsString(col.testType)}",
          "comments": "${escapeJsString(col.comments)}"
        }
        """.trimIndent()
      }
      """
      {
        "productName": "${escapeJsString(mono.productName)}",
        "activeIngredient": "${escapeJsString(mono.activeIngredient)}",
        "dosageForm": "${escapeJsString(mono.dosageForm)}",
        "columnsUsed": $colsJson
      }
      """.trimIndent()
    }

    val allSops = mutableListOf<com.example.data.SopEntity>().apply {
      addAll(com.example.data.SopPrepopulationData.qaSops)
      addAll(com.example.data.SopPrepopulationData.microSops)
      addAll(com.example.data.SopPrepopulationData.productionSops)
      addAll(com.example.data.SopPrepopulationData.generalSops)
      addAll(com.example.data.PharmaSopsNewData.getSops())
    }

    val escapedSops = allSops.joinToString(prefix = "[", postfix = "]") { sop ->
      """
      {
        "id": ${sop.id},
        "code": "${escapeJsString(sop.code)}",
        "title": "${escapeJsString(sop.title)}",
        "department": "${escapeJsString(sop.department)}",
        "section": "${escapeJsString(sop.section)}",
        "objective": "${escapeJsString(sop.objective)}",
        "scope": "${escapeJsString(sop.scope)}",
        "responsibility": "${escapeJsString(sop.responsibility)}",
        "procedure": "${escapeJsString(sop.procedure)}",
        "safetyPrecautions": "${escapeJsString(sop.safetyPrecautions)}",
        "frequency": "${escapeJsString(sop.frequency)}",
        "effectiveDate": "${escapeJsString(sop.effectiveDate)}",
        "roleRequired": "${escapeJsString(sop.roleRequired)}"
      }
      """.trimIndent()
    }

    var rootDir = java.io.File(".").absoluteFile
    while (rootDir != null && !java.io.File(rootDir, "settings.gradle.kts").exists()) {
      rootDir = rootDir.parentFile
    }
    if (rootDir == null) {
      rootDir = java.io.File(".").absoluteFile
    }

    val templateFile = java.io.File(rootDir, "app/src/main/assets/web/template.html")
    if (!templateFile.exists()) {
      throw java.io.FileNotFoundException("Template file not found at: " + templateFile.absolutePath)
    }
    val templateContent = templateFile.readText()

    val b64Columns = java.util.Base64.getEncoder().encodeToString(escapedColumns.toByteArray(Charsets.UTF_8))
    val b64Monographs = java.util.Base64.getEncoder().encodeToString(escapedMonographs.toByteArray(Charsets.UTF_8))
    val b64Sops = java.util.Base64.getEncoder().encodeToString(escapedSops.toByteArray(Charsets.UTF_8))

    val htmlContent = templateContent
      .replace("/*COLUMNS_DATA_PLACEHOLDER*/", b64Columns)
      .replace("/*MONOGRAPHS_DATA_PLACEHOLDER*/", b64Monographs)
      .replace("/*SOPS_DATA_PLACEHOLDER*/", b64Sops)

    val rootWebFile = java.io.File(rootDir, "web/index.html")
    rootWebFile.parentFile?.mkdirs()
    rootWebFile.writeText(htmlContent)
    println("Successfully generated HTML website at root: " + rootWebFile.absolutePath)

    val vercelWebFile = java.io.File(rootDir, "index.html")
    vercelWebFile.writeText(htmlContent)
    println("Successfully generated HTML website for Vercel at: " + vercelWebFile.absolutePath)

    val assetsWebFile = java.io.File(rootDir, "app/src/main/assets/web/index.html")
    assetsWebFile.parentFile?.mkdirs()
    assetsWebFile.writeText(htmlContent)
    println("Successfully generated HTML website inside assets: " + assetsWebFile.absolutePath)
  }

  private fun escapeJsString(str: String): String {
    return str.replace("\\", "\\\\")
        .replace("\"", "\\\"")
        .replace("\n", "\\n")
        .replace("\r", "")
  }

  @org.junit.Test
  fun validateHtmlScript() {
    var rootDir = java.io.File(".").absoluteFile
    while (rootDir != null && !java.io.File(rootDir, "settings.gradle.kts").exists()) {
      rootDir = rootDir.parentFile
    }
    if (rootDir == null) {
      rootDir = java.io.File(".").absoluteFile
    }
    
    val indexFile = java.io.File(rootDir, "index.html")
    if (!indexFile.exists()) {
      throw java.lang.RuntimeException("index.html does not exist yet at: " + indexFile.absolutePath)
    }
    val html = indexFile.readText()
    
    val regex = java.util.regex.Pattern.compile("<script>([\\s\\S]*?)</script>")
    val matcher = regex.matcher(html)
    var count = 0
    val resultsList = mutableListOf<String>()
    var hasError = false
    while (matcher.find()) {
      count++
      var scriptContent = matcher.group(1)
      
      // Prepend mock DOM globals to test real execution in Node
      scriptContent = """
        const localStorage = {
          getItem: () => null,
          setItem: () => {}
        };
        const window = {
          onload: null,
          addEventListener: () => {},
          onerror: null
        };
        const document = {
          getElementById: () => ({ value: '', addEventListener: () => {}, querySelectorAll: () => [], classList: { add: () => {}, remove: () => {}, toggle: () => {} } }),
          querySelectorAll: () => [],
          createElement: () => ({ style: {} }),
          body: { appendChild: () => {} }
        };
        const navigator = {
          userAgent: "Mozilla"
        };
        $scriptContent
      """.trimIndent()
      
      val tempFile = java.io.File(rootDir, "temp_script_$count.js")
      tempFile.writeText(scriptContent)
      
      // Run node to execute and catch runtime errors
      val process = java.lang.Runtime.getRuntime().exec(arrayOf("node", tempFile.absolutePath))
      process.waitFor()
      val errorStream = process.errorStream.bufferedReader().readText()
      
      tempFile.delete()
      
      if (errorStream.isNotEmpty()) {
        resultsList.add("Script $count threw a runtime error:\n$errorStream")
        hasError = true
      } else {
        resultsList.add("Script $count executed successfully with no runtime errors.")
      }
    }
    
    val finalReport = resultsList.joinToString("\n")
    if (hasError) {
      throw java.lang.RuntimeException("VALIDATION REPORT:\n$finalReport\nHas Error: $hasError")
    } else {
      println("All scripts validated perfectly:\n$finalReport")
    }
  }
}


