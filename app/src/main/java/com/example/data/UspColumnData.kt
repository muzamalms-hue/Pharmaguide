package com.example.data

data class UspColumn(
    val code: String, // e.g. "L1", "L3"
    val name: String, // e.g. "Octadecyl Silane (C18)"
    val description: String,
    val packingMaterial: String,
    val carbonLoadRange: String,
    val phRange: String,
    val maxTemp: String,
    val particleSizes: String,
    val typicalApplications: List<String>,
    val popularBrands: List<String>
)

object UspColumnData {
    val columns = listOf(
        UspColumn(
            code = "L1",
            name = "Octadecyl Silane (C18)",
            description = "Octadecyl silane chemically bonded to porous silica or ceramic microparticles, 1.5 to 10 µm in diameter, or a monolithic silica rod.",
            packingMaterial = "C18 (Octadecylsilane) on High Purity Silica",
            carbonLoadRange = "10% - 20%",
            phRange = "1.5 - 10.0",
            maxTemp = "60°C",
            particleSizes = "1.7, 1.8, 3.0, 5.0, 10.0 µm",
            typicalApplications = listOf(
                "Reverse-phase separation of non-polar compounds",
                "Assay of active pharmaceutical ingredients (APIs)",
                "Impurity profiling in tablets & capsules",
                "Analysis of vitamins and steroids"
            ),
            popularBrands = listOf(
                "Waters Symmetry C18",
                "Agilent Zorbax SB-C18",
                "Phenomenex Luna C18",
                "Inertsil ODS-3",
                "YMC-Pack ODS-A"
            )
        ),
        UspColumn(
            code = "L3",
            name = "Porous Silica (Unbonded)",
            description = "Porous silica particles in diameter of 1.5 to 10 µm, without any chemically bonded phase.",
            packingMaterial = "Pure Silanol Active Bare Silica",
            carbonLoadRange = "0% (Unbonded)",
            phRange = "1.0 - 8.0",
            maxTemp = "80°C",
            particleSizes = "3.0, 5.0, 10.0 µm",
            typicalApplications = listOf(
                "Normal-phase separations of polar organic molecules",
                "Separation of fat-soluble vitamins (A, D, E, K)",
                "Isomers and basic compounds under non-aqueous conditions",
                "Preparative chromatography scaling"
            ),
            popularBrands = listOf(
                "Agilent Zorbax SIL",
                "Phenomenex Luna Silica(2)",
                "Waters Spherisorb Silica",
                "Inertsil Silica"
            )
        ),
        UspColumn(
            code = "L7",
            name = "Octyl Silane (C8)",
            description = "Octyl silane chemically bonded to porous silica particles, 1.5 to 10 µm in diameter.",
            packingMaterial = "C8 (Octylsilane) on Silica Support",
            carbonLoadRange = "6% - 12%",
            phRange = "2.0 - 9.0",
            maxTemp = "60°C",
            particleSizes = "1.8, 3.0, 5.0, 10.0 µm",
            typicalApplications = listOf(
                "Moderately polar to non-polar organic molecules",
                "Faster analysis than C18 when high retention is not required",
                "Analysis of preservatives and parabens",
                "Peptides and protein mapping"
            ),
            popularBrands = listOf(
                "Agilent Zorbax Eclipse XDB-C8",
                "Phenomenex Luna C8(2)",
                "Waters Symmetry C8",
                "Kromasil C8"
            )
        ),
        UspColumn(
            code = "L8",
            name = "Aminopropyl Silane (NH2)",
            description = "An essentially monomolecular layer of aminopropylsilane chemically bonded to totally porous silica gel support, 3 to 10 µm in diameter.",
            packingMaterial = "Aminopropyl bonded silica",
            carbonLoadRange = "2% - 5%",
            phRange = "2.0 - 7.5",
            maxTemp = "50°C",
            particleSizes = "3.0, 5.0, 10.0 µm",
            typicalApplications = listOf(
                "Sugar and carbohydrate separation (Normal phase / HILIC)",
                "Weak anion exchange (WAX) for acidic nucleotides",
                "Water-soluble vitamins analysis",
                "Simple organic acids resolution"
            ),
            popularBrands = listOf(
                "Phenomenex Luna NH2",
                "Agilent Zorbax NH2",
                "Waters Spherisorb NH2",
                "Inertsil NH2"
            )
        ),
        UspColumn(
            code = "L9",
            name = "Strong Acidic Cation Exchange (Ca/H)",
            description = "Amorphous, sulfonated, cross-linked polystyrene-divinylbenzene copolymer (PS-DVB) in the calcium or hydrogen form, 5 to 10 µm in diameter.",
            packingMaterial = "Sulfonated Polystyrene-Divinylbenzene",
            carbonLoadRange = "Polymeric Support",
            phRange = "1.0 - 13.0",
            maxTemp = "85°C",
            particleSizes = "8.0, 9.0, 10.0 µm",
            typicalApplications = listOf(
                "Analysis of organic acids in fermentation broths",
                "Separation of sugars, alcohols, and starches",
                "Analysis of high-fructose corn syrup",
                "Fruit juice quality testing"
            ),
            popularBrands = listOf(
                "Bio-Rad Aminex HPX-87H",
                "Bio-Rad Aminex HPX-87C",
                "Shodex SUGAR SH1011",
                "Waters Sugar-Pak I"
            )
        ),
        UspColumn(
            code = "L10",
            name = "Cyano Silane (CN)",
            description = "Cyano groups chemically bonded to porous silica microparticles, 1.5 to 10 µm in diameter.",
            packingMaterial = "Cyanopropylsilane bonded silica",
            carbonLoadRange = "3% - 8%",
            phRange = "2.0 - 8.0",
            maxTemp = "50°C",
            particleSizes = "3.0, 5.0, 10.0 µm",
            typicalApplications = listOf(
                "Reversed-phase or normal-phase separation of polar compounds",
                "Unique selectivity for aromatic amines and steroids",
                "Analysis of anti-depressants and tricyclics",
                "Fast elution compared to standard C18 columns"
            ),
            popularBrands = listOf(
                "Phenomenex Luna CN",
                "Agilent Zorbax SB-CN",
                "Waters Symmetry CN",
                "Inertsil CN-3"
            )
        ),
        UspColumn(
            code = "L11",
            name = "Phenyl Silane (Phenyl)",
            description = "Phenyl groups chemically bonded to porous silica microparticles, 1.5 to 10 µm in diameter.",
            packingMaterial = "Phenyl-Hexyl or Phenyl-Dimethyl bonded silica",
            carbonLoadRange = "5% - 14%",
            phRange = "2.0 - 8.5",
            maxTemp = "60°C",
            particleSizes = "1.8, 3.0, 5.0, 10.0 µm",
            typicalApplications = listOf(
                "Aromatic compounds utilizing pi-pi interaction",
                "Separation of positional isomers of aromatic analytes",
                "Tricyclic drug analysis in Quality Control",
                "Analgesics and pain management panel"
            ),
            popularBrands = listOf(
                "Phenomenex Luna Phenyl-Hexyl",
                "Agilent Zorbax SB-Phenyl",
                "Waters XBridge Phenyl",
                "Inertsil Phenyl"
            )
        ),
        UspColumn(
            code = "L20",
            name = "Dihydroxypropane Silane (Diol)",
            description = "Dihydroxypropane groups chemically bonded to porous silica microparticles, 3 to 10 µm in diameter.",
            packingMaterial = "Diol bonded silica phase",
            carbonLoadRange = "3% - 6%",
            phRange = "2.0 - 8.0",
            maxTemp = "50°C",
            particleSizes = "3.0, 5.0, 10.0 µm",
            typicalApplications = listOf(
                "Normal-phase separations of highly polar molecules",
                "Size Exclusion Chromatography (SEC) of biomolecules",
                "Alternative to bare silica for polar organic separation",
                "Protein and peptide size profiling"
            ),
            popularBrands = listOf(
                "Waters Spherisorb Diol",
                "Inertsil Diol",
                "YMC-Pack Diol-120",
                "Lichrospher Diol"
            )
        ),
        UspColumn(
            code = "L43",
            name = "Propyl Silane (C3)",
            description = "Propyl silane chemically bonded to porous silica or ceramic microparticles, 1.5 to 10 µm in diameter.",
            packingMaterial = "C3 (Propylsilane) on silica",
            carbonLoadRange = "3% - 5%",
            phRange = "1.5 - 8.0",
            maxTemp = "60°C",
            particleSizes = "3.0, 5.0 µm",
            typicalApplications = listOf(
                "Hydrophobic interaction chromatography",
                "Separation of larger hydrophobic proteins & biomolecules",
                "Peptide fragments profiling",
                "QC testing of biopharmaceuticals"
            ),
            popularBrands = listOf(
                "Agilent Zorbax 300SB-C3",
                "YMC-Pack C3",
                "Phenomenex Aeris C3"
            )
        ),
        UspColumn(
            code = "L60",
            name = "Pentafluorophenyl Silane (PFP)",
            description = "Spherical, porous silica gel, 3 or 5 µm in diameter, the surface of which has been modified with chemically bonded alkyl groups containing fluorine.",
            packingMaterial = "Pentafluorophenylpropyl bonded silica",
            carbonLoadRange = "6% - 10%",
            phRange = "1.5 - 8.0",
            maxTemp = "60°C",
            particleSizes = "1.7, 3.0, 5.0 µm",
            typicalApplications = listOf(
                "Halogenated and fluorinated organic molecules",
                "Taxanes and complex natural products",
                "Positional isomers of aromatic drugs",
                "Highly polar basic compounds"
            ),
            popularBrands = listOf(
                "Discovery HS F5",
                "Phenomenex Kinetex F5",
                "Agilent Zorbax RX-SIL F5",
                "Inertsil ODS-PFP"
            )
        )
    )
}
