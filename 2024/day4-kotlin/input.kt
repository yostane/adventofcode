val testInput = """
..X...
.SAMX.
.A..A.
XMAS.S
.X....
""".trimIndent()

val testInput2 = """
M.S
.A.
M.S
""".trimIndent()

val testInput3 = """
.M.S......
..A..MSMS.
.M.S.MAA..
..A.ASMSM.
.M.S.M....
..........
S.S.S.S.S.
.A.A.A.A..
M.M.M.M.M.
..........
""".trimIndent()

val input = """
SAXMASMMMASAMMMMXXMMXMMMSSMMMXSAAXMSSMSSSSSSSSXSASXMSMMMSASXSXMASXMSSSMXSSMXSMSSXMXXSXMXAMXMASXASXMSAMSSSMMAAXAMMXXSAMMSXSSSSMSMMSMSAXSAMXMX
MXXAAMAAMAMASXSSSMMSAMMSAMASMMSXSAMXAAMAAAAAAXSXAMMMAMAAXAMMAXXAXAAAXMAMMAMAMMAMXMAXSASXSAMXAXMSMAMMAAXSAMXSSXMMMAMMASAMXAAAXAAAXAAMAMXAMXAM
XSXMASXMMXSAMXAAXMASASMMXXAMAXXAMXXSMMMMMMMMMMXMXMAMASASMMMAMMMMXMMMMSAMSAMAXMAMAMMXSAMXMMXMASXAMXMSMMMSMXMXAXSAMSXSAMASMMMMMSMSMMSMAMSXMASA
SMAMASMAMAMASMMMMMASMMXAAMMSSMMMMMXAXXXAMAMASXAASXXSASAXAAASAAAMASAXMSXXSMMMMSASXSMAMXMAMXAMXMXMMAMXAAAMXSMMMXMAMMAMSSXMMMSMAMXXXAAMAAXASAMS
XMAMAXXAMSSXSMSAXMXSXSMSMMXAXAXMASAMXMMMSMSASXMXSAMMMMXSMMMMSSXSXSASAMXMMMSMMMAMAAMXMMSXSAXXAMAXASASXMSSXXAAXMXMMMMMASXAXAAMSSXXMXSSXSMMMAXX
SSXSXMMXSMMMSASAMSMSAXAAAXMXMSMSASAMAMAAAAMASXMASAMXASXAXAXMXMASAMXMASMSAAAAMMSMSMMAXAAAMMSSXMAMMMAXXAXAXMSMSSMXAMXMAMSAMSXSMMMXXAMXXMASXMMS
XAAAAMSMMMAAMMMSMAAMMMSMSMMMMMAMXSMXAXMSSSMAMXMASAMXMAASXSSMAMXMASASXMASMSSSMAMMXXSSSSMSMXXASASXMMXMMXMMMXMAAASXMMSMAXMXXMMSASMXSAMXSAAXAAAX
SMMMMMAAASMSMSAMMMSMXAXXXAAAAAXMMXMSAXMAMXMAXXMAXAMSXMXMAMXXAXSXMSMMSMMMMAAMMMSXMAXMAMAMXMMAXMXAMXAMXSXXMAMMMSMSMAXMSXMXSAMXMMAMXASAMMSXXMSM
MAAXMSXXMSAAAMMXAXAMMMSMSSMSMSMSAXMASAMAMXSXMMMMXSAMXXXMAMASXXSAMXMXAMAAMMMMAAXASXSMSMMAAMMAASXMMSSSMMMSSMSSMAAAMXMMXAMXSMMSSMXMSAMXXAMMSXMM
SAMMXAMSAMMMSMSSSXXXAXAMMXAXMAMXAXXAMXSXSAMXMSAXAXMMSSMSAMXMMMSAMAMSMMSMSXSSMSMMMAAXXAMSXXXMXSAAMXAAAAAXSXAMSMSMXAMXSAMASXAAAAXMMXAAMSSXMASX
MSSXAAMMASXSAXXAAMSSSSSSMMSMMXMMMMSXSAMAMAXAAAXMMXAAAMXSXMAMXAMAMXMAXMAXXAMXAMASMSMMSXMXMSAMASXMMMXMSMSSXMSXSXMASXSMSXMASMSMMMMXAMMXMAMAMAMS
MAXXMAMXAXXXXMMXMAMAAMXAMXXXMMAAAXXAMXSASMSMSMMXXSMMMMAXMMSSMMSAMXASMMSMSAXMASAMAAXMAMMMASAMXSAMSAMXAAXMXMMAMSSXAAAAXMMASAMSMAMXXSMAMASAMASX
MSSMXMSMMSSMMSMAMASMSMSMMSXAAXSMMSMAMASXSAAAMXAXMASXMMSSXAMAMXXASAMXXSAAXXMAXMAMSMXSAXMAXXAMASAMXMASMSMMAMMXMAXSMSMMMAMAMXMAMMXSXAMSSMSMSMAX
XAMAAAAAAAAAAAXXSASXMAXXAMMSMXXAMAXMMXSSMMMXSASMAMSMSAAAMXSAMXXAMAMAXSMSMAXMMXAMAMAXMSXSSSMMXSMMSAXSAMAMASMMMSXSXAASMXMASMSMXSAMSMSMMMMMSMAA
AMSSMSSSMMSMSSSXMMSMMSMMXSAMXMMAMMSMSMMAXXAMAXMMMMMAMMSSXMMMMSAMXSMXXMAMXMMSMSMSAMXXSMAAAAXSAMXAXMXSAXSSMSAAMXASMSSMASMMMXAAAMAXXXAAAXAAXMXS
SXAXMMXMAMXXMXMMAMXMAAXMAMXSXAXXMXAXAASXMSAMMMAXSXMMMMXMMXAAAXAMSAMXMMAMAMXAAAASXMMXMAXMMMMSXMAMMMASAMXAAXASAMAMAXXMAMAAXSMMMMSMMSSMMSMSSMAX
AMASXXAAXAMXAMXSAMMSMMMMASMXMSAMXSMSSMMAXMAMXMXXXAMSSMAMSSSMMMXMXAMXASASASMMSMMMXASXMASMXSAMASAXAMAMMSSMMMXMMMMMMMXMSSSMMXMAMMAAXXMAXXMMXMAM
MMMMMSMMSMSAXAMSASAAXXASXSAAAXAXMMMAMAMSASXMASMMSAMAAMASAXXMSSSXSXSXMXASMXXAAXAMSXAAXMAMXMASASAMSMSSMAAASXXMXAMAXAXMAXAXMXMASXSSMMMMAAAAMMSS
XXAAAAAXAAXXXMASAMMSSSMSAMMSSMXSAXMASAMAAAAMXSAASAMSSMSMMXXAAAXAAAXAXMMMMSMSMSAXXXSXMXSSMSMMASMMXAMAMSSMAMXXSASMSSMSMSMMASXAAXAAAXASMSMXSAAM
SSSSSSSMMSMXMAXMMMMMXMXMAMAXAAAMMMSXSAMMMSXMXMXMSAMAXXAASMSMMSMXMAXAMXSAAXAAAXXASXMXSAAAAXMMMMXSXASXMAXMAXAAMAMAAAXAAAMMAMMXXASMMMMSAAASMMSS
AAMAAAMXMAXAMXXAXAMXMMXSMMXXMMMXSAMXSAMXAAAMMMMXSAMMXXXXXAAAAMASMMASMMSMMSMMXSAMXAMAMMSMMMMAAMASXMMMMMXXMMAMXAMMSMMMSMXMASXMXMASXAAMMMMXASAM
MSMSMSMSSSSMXAMSMMXXASXSXSAMXAAMMASASAMMMSSMAMXMSAMXMSSXMSMMMSXMAXAAAAXMMAXXXSMXSXMAXAXXAASXSMAMXXAAMXMASMSXSXSXMXSAAMXSXMASMXMSSMSSXXASMMAS
XXAXAXAAAAAXMXSAASASMMAMAMXMSMSSSMMASXMXMAMMXSAMXAXXSAAMAMXMAXMSMMXSMMSXMAXSAMXAMMSXSXSSSXSMXMMSMSSMSASMXAXAXAMXXAMSMSXMXMAMSAMXXMAXMXXMXSMM
AMMMSMMMSMMAMSAXXMAMAMAMAMAXAMAXAMMMMMSXMASXASASXSMMAMMMSXAMSSMMXSAAAMAXXAMMXMAXMAMMAXXAMASAMMMAAMXAMXSAMSMSMSMSMMMXXMAMXMXSSMMMMMMSMSSMASXA
AAXAAXXXXASMMAAMSSMSAXAMASMSSXMSSMXAAAXAMSAMXXXMAXXXMXXXMAMSXAXXAMXSMMASXMMXMMMSMMSSXXMAMSMXMASXSSSSMAMAMMAXAMASXSASASMMAXMAMXAAAAMAAASMAMMS
SSMSSSXMAMMXXMSMXAASASXSMAMSASXAAMMSMMSAMXMASMMMMMMXXXSAMXXSMMMMMMAMXMXSAMAXXAAMAMAAAAMMMMAASAMAMMAMMASXMXSMXMAMAMASAMXMXMXAMSSMSSSMMMMMXMAM
XAAXXXMAXMAXXAAMMMMMMMMAMMSMMAMSSMAXAMXMAMMASAMMAAXMXMXMAMMMAXAMAMSSXMSMASASXSXSAMXSMMSAAMAMMASMMMAMXMMAAXMMXMMSAMXMAMSSSMAXMAMXAAXAMXSSSMSS
SMMMMMSMMSXSSSMSXMASXSSMMXXMXMMMAMASAMXMAMMASXMMMSSMMSSMMSASMMXMASMAMSMMASMSAMXSASAMAXSMSSMXSAMAASXSAMMXMMMASXAXAMXSAMXAAAAASAMMMMMSAMXAAAAX
SAMXXAAAMMAMAAAMXMXAAAAMAXMASXSSMMXSAMMSASMASMMSMAXXAXAAMXMAXSASMXMAMAAMASAMAMASMMXSAMXXAXMXMASMMMASAXSSMXXASMMSAMASMSMSMMMMMASAAAAXASMSMSMS
SAMXASMSMMAMSMMMAMMMMSMMXAXMMAMAXSAMXXAXASMMXXAAMMMMSMMMMSAMXMASAXSASMSMMMXMAMMMASAMAMXMMSAXMASAMMMMSMAASMMMSAXSAMXSASXAMXXXSMMMSMSSXMMMXXAA
MSAMXAAAXSSMXXASASAXAMXMXMXMMAMAXMXSAMMSXMASMMSMSASMXXSAASAMXMSMMMMASXXXMASXMXXXAMASXMXAXAMXAAMAMXXAMMSMMXXXSXMSMSMMAMSMSMSAMAAXMAXMASXSAMXM
XMMMMMSMMAXMASXMMSXMXSASASAMSMSMSMMSASAAAAAXAMXAMAXAXASMXSAMXXXAXAMSMMSMSXMASMMMASXMAAMMXSXSSSSSMMMAMAMASXAMMSMXAAMMAMAXXMAASXMMMMMSMXAMXSAS
MXAAAXAMMMXMASMSXMXMMSASAXAXAAAAAMASXMASMMXSAMMMMSMMMMMMMXXMSMSMMXMAAMAAAMMAMAMMAXAMMMSMAMAMAMAASAMSMXSAMXSAAAMMSMMXASMXXAMXMMAMXAAXXMXMXMAS
AXMSXMXXAXAMASAAMXASAMMMMSSMMMMSXMXSXMXXAMXAAXXXAXAMSXSMSSSXXAXMASMMMSMSMSSSSSSMMSMMXAAMAMAMAMXAXXXAAMMMSSMMSMXAAXSSMSASXSAXASMMMMXSAMASMMMM
SXMMMMMMMSSSMMXMAMXMMSXAAAXASMMMASAMXSAMAMXSXMXMMMAXMASAAASAMSMMMSAXMAAAXMAAAAXAAAMSMSSSXSXSXSMASXSXSMASMXXAXAMSMMMAXMXMAXXMXMASAAASXMAXAAXS
XSAAAXAMMAMAXAMXSAAMXMMMSSSMMAAMXMAXXXASXMAXAMXAMSSMMMMMMXMXMAXAXSASMMXMXMMMMMMMMMXAAMXMXMAMAXXMAMXAXXXMASMSSXMXASXMMXSMMMXAAMMMMMXSAMSSXMSM
SAMSMSSXMASAMMSMMSAMASAMXAAXSXMMSMSMMMMMMMASXMAXXAMASXXXSXSMSXSSXXAMAMASAMXXAASMMSSMSMAMMMAMAMSAMXMXMAXMSMAAMMSXMMAMSMSAAAMMSSXXMSASMMAAASAM
AMXAAMXAMXMAXAAAMMMXAXAMMSMMSMSMSAAXAXSAXMAXAXAMMASASMMMSAAAMMMMMMSMXSAMASXXXASAAXAXAXMXAMMXAXMMASXXAASXMMXMXAXAXSXMAAMXMMSAAXMSXMAXXMMSMSAS
MXSMSMSMMMSAMSSSMAAMXSXSXMAAXMAAMSMMSMSASMSSMMSXSAMMSASAMSMMMAMMMAAXMMMXAMASMASMMSMSSXMMSSSMMXAAMAAASXMMAMMMMSXMMMXSMSMASAMXSMMXXMMMMSXXAMAM
XASMAXAMXXMAXAAAXMSSMAASASMMSSMSMAXXMAXAMAAXMAMXMASXSAMSAXMAXMSSMSSMSASMASAXMAMAXXXMMAAXXAXAXSMMMMMMMAMSAMXSAMSSMSMSAAXXMAMMAMXXMASMAMXMAMXM
MXSAMSSXMXSMMMMMMXAXMMXSAMXMMAAAMXMSMSMXMXMXMAXAMAMXMXMMMMAXXXAMMXAXMAMSAMXSMMMMMMMASXMMMSMSMXMAXXXAMAMSASAAASAMASAMSMSXMAXXAMXMSASMSMMXAMAM
XMXAMXMASAMXSXSXXMMSXXAMMMSSSMMMMMMAAAAAMMSMSASMSSMXMAXAMMAMXMMSSMXMMMMMSMSMXSAMAASMMAXMAMAMAMSMMMSXMAMSMMMMMMMMAMAMMMMASASMMSSXMASAMXSSSSSS
MSMAXXSAMASAAMAMMAASAMXMAAAAXAXXMASMSMSXSAAMAAMXAMXASXSSMMASAAXAMAMXAXAXASXAASMSMXMASXMXXMAMAMAAAXXXSMMXAASXMXXMASXMMASAMAXXMAMXMXMMMXMAMAAM
AMXMMXMXMXMXMAAAXMMSXMAMMSSMSMMXSAMMAAXMMMSSMMMXMXSMSAMAXSASMSMXSXMXXSASMMMMMSXSXSSXMMMXMSAMXXMSMSAMMSSSSMSAMXSAAXMXSMMXSMSSMSSXMXMAAXMAMMMM
SMSMMAMMSXSAMSSSMSXMASXSAMAXSAAXMAMSMSMSAMXAAMMAMMMMMMMAMSAMXMXXMASMXSAMAAXMXSAXAXMMMAXMASXSXSAAXMAXAAMAAASXMAMMMXMASAMXSAAMAMXAMASAMXMAMAAX
ASAAMXSAAAMAXAAAAMXSAMMMASMMSMMSSSXAAAMAMMSSMMSAMAAAAXMAMMMMMMSASAMMAMASXMSXAMAMSMMASMSAMXXAAMSMMSMMMSXSSMMMMASAAASASAMAMMMMMMSXMASASASXSSSS
SSSSMXAXMSSSMMSMMMMXMASMXMAXXAAAAAMMMMSAMXMASXSXSSSSMSMXMASXXASMAMSMXMAMAMMMMSAAMAMASMAMXMXMXMAMAAAMAMMMAXAXMXSMMXMASXMXSAMMMMXAMXXMMXAAXAAX
AMAMXMMSXMAXAAMAAXSAMXMXXSMMSMMMMMXXAXSMSMSAAMMMMMAXASMMMAMXMASMAMXMAMMXSXAAMMMXSAMXSXMMXSMSASMSXSXMAXASAMXMMAXXXAMAMAMASAMAAXSSMMMXMSMXMMMM
MMAMXSAAAMAMMMSSMXSAMSAMXSXMXAXASXSSMXMASAMMMMAXXMAMMMASAXSAMXXMAXAMAMSAMSSSSXMASASASAMXXXAXASAAMMXMSSMMXMASMSASXXMASXMASAMSMXAAAXSAMAAASASM
XSMSAMSSSMASXAAAXAXMASXMXMAMSSMMSAAAXAMAMAMMXSASXMMSXMAMMXXXMAMXSSMSASMAMAMAXXMASXMASXMAXMSMAMMMXXAMXAXSAMXXAAAAMSSXXAMASAMAMMMMSMSASMSMMASA
MMAMAMAMXMASMMSSMMMSASASASAMXMASMMMMSMSASAMXAMAXXAAMMSMMXSMMXASAAAXMXSMSMAMSSMMMSAMXMMMXMAAMXMXMSAMXMMMXAMSMSSMMAXMMMMAMSXMASAXMAASXMAMAMSMM
AMAMXMMSMSAXAMAAASAMXMAXMXASXSXMAXSXSAXAXAXMSSMMSMMSAAAXAXAAXAXMSMMMASXMSXXMAASAMMXSAAASMSMXSASAXAAMAXMMSSXAAMAXSXSAAXAMMMSXSXSSMMMMMSMSMAAA
MMXSXSXMAMAMSMMXMMSSSMSMMSAMASXSAMMAMXMMSSMAAAAAMASMMXSMMSXMXSMMAAMMMSAMXSMSSMMASXXSMMMSAMAMMASMSMSSMXMAMAMXMSAMXXSSSSXSAAXMMAAMMMAMMMAMMSXM
XSXMMSAMMMSAMXSAXXAMAAXAMMMMMXASXSMAMMMMAAAMSSMMMXMASXXAAMAXAAASXMMAMMAMAMMAAASXMMMSASAMXMSMMAMXXAAAMSMMXSAMXXMXMMMMMAXXMMSAMXMMASAMXMAMAMMM
AXAMASAMXAMASAASAMXSSMMXMASMMMAMAAMMXSAASXMMAMASXMMAAXSMMXAMSXMMASXXSSMMSXMMSMMXMAAMXMXMXMMAMSSMMSMSMXAAAMMAMASAMAAAAMSXSXSASXMSMSASXMXSAMAM
SSMMXSAMXXSAMXMAXAAAAXSXSASMXMAMAMXXAMMXXAMMXSAXMAMAMMMSSMMMAASMMMMAMXAAMASAXXMASMSSXSSMXSSMMAAAAXXMAMMMMMSSMASASXSMSAMAMMMMMMMAXSAMXXXMASAM
XAMSXSASXAMXMSXMXMMMMXMXMAMAASXMXMAMMSMMSAMMMMMSSXMXXSAAXAXMXXMASAMSMSMMMAMASAXAXAAAMAMXAXAMSSSMXSXSASMSMMAAMASMMAXAAMMAMSSXXAXMMMAMSAMXXSAS
SMMXASAMMMMMAXAAXXAAXASMMSXSASXSAMAMMAXXSAMAAXXXAMXMMMMMSMMSMXSMMAAMASXSMSSMSXMSSSMMAMMMASMMMAXMAMAMASAAMMSXMMSAMSMXMXMASAAAMSSMMSMMASAXXSAM
XAAMXMSMAAAMMSAMXSSXSASAAXMMAMXSASASXMMMSASXSSMMSAAXXAMXXXAAXMXXMXMMAMMAAAAXXAXMAMXXMSSMASAAMMMMASAMMMXMMAMASMSXMXAXXAAXMMMMSAAMAAAMAMXMAMMM
SMMSAAAXSSSSMSAMXXAAXASMMMAXSMMSXMAMAXAASAMAMXMAXSSSSSSSSMMSAMMXMAMMMMAMMMXAMSMMAMMSMAAMASMMMAASXSASXAMXMASXMAMMMSMMSMSMXXXMAMMMSSXMMXAMSMAM
MAASMSMXMAAAMSAMXMMMMMMXMMXMAAXMMMMSMMMMSAMSMSMMXAMAXAAXXAAXMAAAMAMXMAMXMSMSMXASXMAAMSSMASXSSSXSXSMMMMSXMASMMAMXAMAMXMXMMXSAMXMXAMXMAXXXAAAS
SMMSAMMAMSSMMSXMAMAAAAAAMAAASAMXAAAAAAAMSXMAAAAXSAMXMMMMMMMSXMXXSASMXSXAAXAXXMXMMMSSXMXMASAMXXMXMMMSXSMMMXSXSASMASXMASAMMAMXXMASASMXMASXSSMS
XXSMAMSSMMAAXXAMXSSSSMSSSSXXMSXXMMSSSSSMXXMMSMSMXMASMSAXMAMSASAXMASMAMSSMMXMXSMXXAAMMMAMXMAMXMAAXAAMMSXAXASXSASMXMASMSMSAMXMASXMAMXAXASAMAAX
MMMMMMXMASXMMSXMXAMXAXXXAAXAAXMXSAMAAMMAMMSAMXAAXMXSASASMAXSAMMMSAMMSMAXMASMAAAXMMXSASXSXSAMAMMSSMXSAMSSMASMMMXXMSXMAXAMAMAMMXMMSMMXMXSAXMMM
SASAXMMSAMAAAAASMSSSMMXMMSAMXMAMMAMMMMSAMMAMASMSMMAMAMXMMMMMAMAAMAMSAMXSXAAMASMMXAAMXSAMASXSASAMXMXMMMAXMMMXSMMXXXAMXMXMASMSMXMAAXXAMXMAMSAM
SASAXSAMXXMMMSSMAAAMXASAAAMXSMSMSSMSXXXAMXASXSXAASASAMMSASASAMMSSMMMMMAXMXMSAMXAMMMSAMXMAMXAAMASASAMSMSXSASMSAASMSMAAAASXMMAASMMSAXAXAMAMXAX
MMMAMMASAMSAMXAMMMMMMSAAMSXMAAXXAAAXMSSSMSXSAMXMXSXSXSXSASMSASAAAMXSXMMSMSMSMSMXSAMXMSXMASAMAMXSASAAXAMXSASASMMMAAMSSSMMAASAMMASXMMXSASXSSSM
SSMMMSMMAMXAMXAMSAMMMMMAAXMSMSMMSAMXXAAAXSASMMAMMSMMASAMXMXXXMMSMMAAXMSXAAAMXXMAMXSMXXASAMASAMXMASXMMMMMMMMMMAXSSSMXAMXXSMXAAMXMASAMSAMXAAMX
XAAMXAMMSMSSMAXAXAXAAAXXXXAAAAXMMMXSMMXMXMAMSSXSASAMAMAMAMMSMSAXAMXSMMMXXMSMAMMXMAMAXSXMASAMASXSMMXMAAAASXSXSMMAMMMMAMMAMASMXMXSAMAMMXMMMMMS
SMMMSASAXMAMXAMMSMMSSSSMMSSMSMMMAMAXXMASMMAMXXAMASXMSSMSXSAAXMASMXAXAAMMMMMMSSMSMSXSAMASAMXSAMXMAAASXSSMXASMAMAMXAAXXMXXMAMXAAXMMSMMMAXAAXXA
MAAASMMMSMASXMAXAAAAAXAAMAAMMAXSAMMXMMXAAXASXSAMAMAXXAXAAMXSMMAMAMSSSXSAAXAAAAMMAAAXMSAMXSXMAMXSMMMAMMXXMAMXAMXXMSSSSMSXMMMMMMXAAXMASXSSMSSM
ASMXXASXXMASXAXSMSMSSSSMMXXMMMMSAXMASMSSSSXSASASXSMMSMMMMMMMAMXSMXXAMXMMSMMSSSMMMMSMXSAMXXMASXMMXMASMMAXMAMSSSSMAXMAAAMXSAAASXSMMMXMSXAAXAAX
XMMMMAMMAMXXXSXSAAAAXMAXXSXSASAMXXSASAAAAXAMASAMMMXMXSMXMAAMSSXMXSMAMXMAMXMAAAMXAAAXMMMSSMXAXMAMAMAXAMXMASAXAAAXMXMMMMMASMSSSMXMASAASMSMMSSM
MSASMSMXSMSXAXAMMMSMMSSMSAAXMXAXMAMXXMMSMMSMAMMMAXXXMASASMXSAMAXAMMMMXMASASMSMMSMSSSMAAAAAMXSXSSSSMMSMAXAMAAMSMMSMMXMAMAMAMAMAAMASMXSAAXAXAA
AMAMAMSMMASMMMMMAAXXAAAMXMMXSMMMSMMMMSAAXXXMSSXSSSMMXASMXAMMASMMMSAAXAMMSAMMAXAXMAXAMMMSSMXMMMAMXAAAMMSMXXMMXMMXAAXSSMMMSAMSXSMMAXXAMMMXMMMS
SMAMMMAMMAMAAAASMSSMMMMMXXXXXASASXSAAMMSMSXAXAMMXAMXSXMXSAXMXMXASMXSMMSAMXMXAMMXMSXSMXXXAMXMAXAMSMMMSAXXMMSAXASXMSMXAAAASAMXMXAMASMSSMMSAAMM
ASXSASXMMMMSMSMSAMMMSAMMXMXXSAMASXMMXSAXXMMXMAMXSMMAXAAAMMMMSMSSSMAMAAMMMXSMXXSAAAAXXSXSAMXSSSMMAMXXSAMASAMXMAMXXMXXMMMMSASXASXMMAXAAAASXMMM
MMMSMSASXMAXXXAMXMAAMASMAAAAMAMXMXMAMXAMAXSMSSSMAAMXSMMMMMAMAAMAMMAMMXMSMMMSAASMMMXMAAMSXSXMAAMSAMSAMASXMASAMSSSSXSMMAMXSAMXMAXMXXASMMMSMSAX
ASAMXSMMAMASAMXMMMMMSAMMSMMSSSMSXXMASMMMXMXAAAAXSMMMXMAAASMSMSMAXMXXXAAAAAAMMXMXAXAMMMAMMSAMSAMXMXMASXMASMMXSAAAMASMASXMMSXSMMXSAMMMXMMXAXXM
SSMSASXSMMAMAMAMASMAMXSAXAXMXMAXMAXAMAAAAMMMMSMXMXAXAMMXXSAAAMXMMMSMSSSSSMSSSSXSASMSAAXSASAMXMXASXSAMXMASXSXMMSMMAMXAXASAMXMAAAXAMMSXMSSMMSS
MMAMASAMXMXSMMXSAMMASMMMSMMSAMXMMSMASMMSXSAAMMXMASMSMXASXMMMAMAMAXAAAAAAMXMAXAMSAAASMSAMXSAMXAMSAMXAXAMAMAMSAMXXMASMSSMMASMSMMMSAMXMMMAAAAAA
SMAMMMMMAMXXMAMMASMXSAMXSAASAMAXAAAXXMAXAXMSMMAMMMMAXAAMXAXXXSAMXSMSMMMMMAMMMMAMMMXMXMASMSAMAXMAMASASMMMMAAAXMASXXXAXMAXAMMASMXXXAMXAMMMMMMM
MMMXSASXSSXMMMSMXMMASXMAMMXSAMAMMMMAMXMMMMAXXSAMAASAMXSXSAMSXMXSAAXXXAAMXMSMMXXXAXXMXSMSASAMMXMAXMAAAXAXXSSSXSAMXMMSMSMMSXXAMMXXMMMMMSASMSMS
MASMMASAMXXMAAAXMMMAMAMXMMXSMMAXMSSXAAXAXMXSASASMXMAMMXASXMXAAAMMMMSSSMSASAMXAMMXSXMAMXMAMMXXASMSSMMMSXMMAAXMAXSAAAMAXXSXAXSAMXMMASXMMAXAAAA
SASAMAMAMASMMSSXSAMSSMSXMSAMXSMSXAAAXMSXXSAMXMXAXXSXMAMXMASMMMMMAXMAXMASMSXSMASXAAAMASAMMMMMMXXMAMXAXAMSAMXMASMMAMSMAMXXMXMMAMXMSASASMSMSMMM
MASXMASAMXSXAMAASMMMAXAAXMASAAASMMSMAMAMXMMSAMASMMAAXSMMSAMAXXMSSSXMSMXMMXAXMAAMXMXMAXMMSAXAAMSMMMMASMAMSXMSXXXXAMXMAXSASXSSXMAXMMSAMXXAXXAS
MAMAMAXAAXSMSSMMMMSSMMMMMMASXMMMAXAXXMXSAAASASAAAMAXMAAAMASAMAAAAAMXAMASMMMXMMSMAMMMXMSASMSAXAAMXXMASXAXASAMXMMSMSXXAXSAMAMAMSSSMAMXMMMSMXMX
SMSSMMSXMASMMAXXAAMAAAXXSMMMASMSSSSSSMAMMMMSAMMXXMASMMMSMXMXASMMSMASASASXASAMXAMASAMAAMAXAXAXSASMMMASMMXMSMMMMAAAMAMSXMAMMMAMAAAMMXAXXAMMASM
AAAMAXAAXXSASXMSMMSMSXSAXAXSAMMXAAMAAMXSAMXMMXMSXMAAMSXXXXAMMMAMXXXSXMASMMMMSSMSXSASMSMSMMMMMMAAXAMMSASMXSASXMSSSMSMMASAMASXSMXAMXMSMMAXSAMA
MMMSMMSXMASAMXMASXMXMXMMSMMMXXAMMMMSMMMMAMXMSAASXMMMAMAMMMMMAXAMXXAMMMXMXSAAAAAAASAXAAAAXXXXXMXXMMSXSAMXAMAAXAAAAAXAMAMXSXSMXXMSXMAMMSMMMSSM
XMMSMAMMMXMXMMMSXXXAXMAAAAMMSAMXAAAMASXSAMXAMMXMAXMSMMAMAAXMASMMMSSMASXMASMMSSMMXMMMSMSMSXMMMSMMMASAMXMMXMAMMMMSMMMMMSMMSXMXSXMMASMMAXASAMXX
XSASMXSASMMMMSXMXSMMSAXSMSMAMAXXXMXSAMAMAXMAXMASXMMAXXSSSMSAMXXAAAASASXMASAMMAAXMXMAMAXXMMAXAAAMMXSAMSXMSXSXSAAAAXSXAMAMXAMAXSASMMMMSSMMSSMX
XMASXAMXMAAAASAMAXAAAXMXMMMMMSMMXXAMXMXMAXSSMSASAMSSSXXAAAXAAMSMMSMMXSXXASMMMXMMAAMXMXMXSASMSSSMXMSAMXAAAAAXSMSSMMSMXMAMSSMASMXXAAXSAAAMAMAM
MMMMMMSXMXMMXXAMASMMMSMMMMAAXMAMXSSSMMAMXXMAAMXMAMAAMMMMMMSXMAAXAAAAXMMMMMAAMASMSSSSMXSAMXXAXMAMMAMAMXMMMXMMSMMMMSXMMSXMXAMXMXMSSMMMXSMMASXX
AXSAXSAMMSSXMSAMXSASAMXAASMMMSAMXAMAMSASMMSMMMMSAMXSMAAXXAMMSSXMSXSAMMAAAXSMSASAAAAAAAMXXAMXMSAMASMMMXMMXAMAMAMXXSAMXAASMMMXMAAMASXAAMASASAM
SMSMXMASAAXAXMMSSXAMMSXSXXAXAMAMMMSAMSASAASAMAAMAMSMXSSMMMSAMAMMAXMASXSXSXMAMXMMMSMMMMSSMMXXAMAMXXAAMMMSMMMAMAMMMSAMMXMXAXAASXMSAMMMMXAMASXA
MAXMASAMMSMXMMAMAMMMMSAMMMMMMSMMAXMAMMXMMMMAMMXMASXMAMAXAXMXMASMMXSXMAMAXXMXMAXMAXAXSAAXAAAASMSSXSSMMAAXASXXMAMAASAMXMMSXMXMSAAMASMASMXMXMMS
SSMSMSASXXMAMMASAAAMASAMXASXMAMXMSSXMSMXXMSMMMSSMSAMSSSMXSAMSXMASAMAMAMMMSSMSMSXMSXMMMSSMMMSAAAAXXASMMSSXMASMSASMSMMXXMAXSXMMMMMAXMASMSXSAAA
SAAMXSASAASXSSMMXSASMSAMMXXAMXSAAMMMMAAAMMAAAAMAMMMMXAAAAMMMMXSAMXSXMASAAAAAMMMAMMXAMSMXXAMXMMMMMSAMXMMMMMMMAMMMAXAMMXAMMMASXMXMSXMMSAAASMMS
XMMMAMMMMXASAMSMXMMMXSXMMSSMMAXMXSAMSASMASXSMXSAMSXMASMMMMSAMMMMSXMASMSMSXMMMASMMSSMXAAMXMSMXXMXAMXMSXMAAAAMAMASXSAMSAMXXSAMAMSMMASXMMMXMMAX
XSAMAMAXXMMXXMAMAAAMXMMXXMASMMSXASAMXAXMXMAAAMSMXMAMMXXXXMSASAMXMMMAXXMAXXMXXXXAAAAXSMSMMMAAXAMMMSMAAASMSSSMXSXSXSAXMASAXMMMAMAAXAMAAXMASXAM
XSASMSMSXAXAMMASMXMXAASMXXAXXSAMXXMMMMXMAMMMMMMMXSAMXMAMMMSAXXXAXAMMSXMAMAMAMXSMMSXMXAAAASMSMXXAAAAMXMMAMAAXAAMMAMMMSAMXSMMSMSMSMSSSMMMSAMAS
XSXMAAASASMMSAMXMASMSSMAMSMMMXXAMXSXXMASXSAXASXAAMXSAMAMAMMMMMXMSXSASAMXSAMASMAXAXMSXSMSMSAAASMMMMXSXMMSMSMMMMAMAMAASAMXSAASXSAXXMAMXAXAAMXS
MMMMSMMSAMXAAXSSMXSAMXMXMAAAAXMSAMXAXSAMAMXMMSMMXSASXSASXXASXMAXMXMASMMASXSASXSMXSASAAXXAXMMSMASXSMMMAAMXMAMXASMMMMXSAMAMXMSAXMASXSMSSSSSMAX
XAAMAMMMMMMMMXMAMMMMMXSSSSSMXSAMXSAMXMMSSMAXSMMAXMAMXMASMSMSAMXSAAMAMAMAMAMXMXMAAMAMMMMMXMAXAMMMAAAASMSMSMMSSMMASXSASAMAXAMMMMSAMMXAXAXMAMMS
SSXMASAMXASMSMSAMMSMAMSAMAAAASAMMSAMXSMAAMXMXAMSXMAMAMAMXAASXMSXMXMAMXMASMSSSXSMMSXMXMXMSAMXMSMSSSMMXAAXXSAAAASXMASASXXXSMMAXAMAMAMAMMMMSMXM
XMMSMMMAXMXAAMMAMMAMASMAMSMMMSAMMSAMMAMXMMAMXXMAASAMSSMMAMXMMXMAMXSXSAMXAXAAXAMAMXXXXMXMXMMMXAAMAMXSMSMXMMMSSMMSMXMAMMXMAXXXMASMMSMMSASMMSAA
SMMAAXXSSMMSMXMAMSAXXXXMMXAAXSMMAMSAMXMAXXASMMSMMSASAMXSXXXXAAMAMAAXAMMMMMMMMXMASMSSMMSAMXAMXMSMSMAXXXXAXAMAAMSASXMSMAMMASMXMXMMAXAASASMASMS
XASXSMAXAAXXMXAMMSASMSAMXMAMXMAMMXMMSAMMMSASMAAXXMMAMXAAAXMASMSXSMSSSMAAXXAXXXSMSAXMAAAMASAXSAXAMMMSMMSXSAMSSMSASXMAMMSMAMAAXAAMAMMMMAMMASMA
SAMXAMXMXMMAMXSMAXXAASMMSSXMAMMAMAMXMAAAMAMXMMSSXSMMMXXMXMAMXXSASAAAASMSSSMXSAMXMMMSMMXXMSAXMAMMMAMAAXAMMXMAAAMAMXMASMXMASMXSXXMASMSMSMMAMMM
AAMSXMAMASMMMAMMXMMSAMXAASASXSAASXSXSSMSSXSXMMXMAAMASAMXMASMMAMAMMMSMMXXAXMASAMXAXAAXXXSMMMMMMMASASXMMASMMMSMXMSMAXASAAXASMXSMXXMAXAXAXMMSMX
SAMAMSASASAAMSSXMXXMSSMSSSXMASMMMXAXXXMXXXMASAMMMMSAMMAAXAAMMSMXMXAAAXMMAMMASAMSSSSMSSXSAMXAAASXSAMXASAMXAAAXAAXMMMXSMSMAMMASMXSMMSXMMXSAAXM
MMAMXMAMASXMMAMASXSMAMAMAMMMXMASXMMMMASAMXSAMMSAAXMASXSMSSXSAAMAMMSSMMMMSMMAXAMAAXXXAXXMAASXSMSAMXSAMMASXSSMSMSMAAAMMAXMAMMAXMAMAAAMSMAMMMSA
XASXSMSMMMMSMMSAMSMMASMMAMSAMXXMXMXAMAMMSAMXSXMXMXAXAMXAMXAMMSXXSAXAXAAAMXMSMMMMSMMMXSMSSMAMMMMXMAAAXSAMXAAXXXAMSXSAMAMMSSMMMMAMXMSAAMASXXXM
MXMASXXASAAXAAMAMAXMASAXXMXMASXXAASMXSSMMXMAXMMMSMMXSAMXSMXMXMMXMXSAMSMSSSXMAXAAAAAXXSAAAMXSAAXAMXXMMMAXMSMMASXXXMAXMASXAXAAAMMSXMXXXSASXMMM
AAMXMMSAMMXSSMSSMAMSASMMSSMSAMXSXMMMAXAMXSMASASAAAAMMAAMAMXMAXMXSXMAMXAAXMASMSMSSSMSASMSMMASMSMSMMMSXSMXMAMXXXMASMMXAAMMMMMSXSAAMSASXMASAXAA
SXMASXMMMXXMAAAAMAMMAMXMMAAMMSAMMAAMSSMMAXMXSAMSSMSMSASXMSXMAMSAMXSXMASMXMASAAMAAAAMAXXAXMXSAXAXMASAAASMXSAMSAMMMAXXMAMAAAAAAMMMSMASAMXMMXXM
MASASASXXXAMMMMMXAAMSMMSAMXMAMAXSMXMMAAMXSMAMAMAMAAASAXMXSXMMXMAXAMASAXAXMAMMSMMXMXMXMSASXAXAMXMSMSMSMSXAXAXSASMSMMMSXSSSMSSSMSXSMSMMMSSXSSS
SAMASXMMMSMMAAXXMMXXAAXMAXAMXSXMMXMMSSMMSAMASAXAMSMXMMXMAMAMXASMSMSMMSSMXMAMXAMMSSMSAAMASMMMXMAMAAXAAAXMASMMSAMXAMAXSMMMAAAMMMXAXXMAMAAXXAAS
MAMMMMSMAAXXSMSXAXMSSSMMMMXSAMXMMAMXAXAXXASAXXSXXXXMAXAMASAMXMMMAAXAAAXASXMSSMSASXASMSMAXAASMMXSMSMSMSMMAAAMMMMSXMSXMASXMMMMSXMXMXMAMMSSMMXM
SXMAAAAMXSSMXASMMAMXMMAAAASMMMAAMASMAMXXSXMXSAMXMASXXSMSASASMSSSMMMMMMSMXASAXAMXMMXMXXMXSAMXASAMXMAXXXXMASAMAXMAMXMXXAMASXSAMXSMMSSMMAAXASXS
MXSSMXXSXAXAMAXAMSASMSSMMMXAAXMMMMSMAMXAXAAASAMASMMSMAMMXSASAMMAAXXXAXMASMMMXMASMMAMXXSAMXSXMAMMMMXMASMSAXXSXSMMASMSMASXMAAXMXAAMAAAMMMXXMAA
SAMXSXASMMMXMAMSMAAMMAXAXMMSMSSXMSSXSXSASMXMXASMXMAAXAMXAMMMAMSSMMXMMSAMXXAXMSXMASASMXMASAMAMMSAXMAMMMAMASAMXMAMSAAXMAMMMSMMSMMAMSSMMASMSMXM
MASAMMMMAAAXXMAMXMXMMAMXMMMMAAAAXAXAMAAASXAMSMMMMMSSSSSMXSSSSMXAMXAAAMXXMSMMASASXSASAXSAMXSXMASMMSASASMMAMAMAXXMMMMMSASAAMXAAAXMMXMASASAMXAX
MMMAMAAMXMSSMSMXMMAMMMXAAXAMMMSMMMMSMSMMMXSMMAASAAXAAAMAMXAAXXXMASXSXSSMMASXMSAMAMAMXAMASXSXMXSXASASASXMXSXMMSSMXAMASASMASMSSSMXXAMXMMMAMSXS
SSSMSSSSXAXMMAMAASXSAAMSMMMSMXAAAXAAMASMXXMASMMSMMSAMSMSSMMMMMSMMAXMASAMSAMXXMAMAMXMSXMASMMMSAMMAMXMXMMAMXAMAAMASMMAMAMMXXAAXAMXSXMSXSXSMSMA
XMAAAAAMMMMMSASXXAMMMSMMAXXAXMSXMMSSSMAMXMMAMXXXXXMXXAAXAAXXAAAAMSAMXMAMMASMMSXSASAMMASAXAAAMSMMSXSAMXXMXSXMMSSMSAMXSMXMMMMMSSMXXMXSAMAMASAM
XSMMMSMAAMAASXSMSMMAXMAXSMSMSXXAMAAXAXMSMSMSSMMXSSSMSMXMMSMSMSSSMXXMMSXMSAMAXAASASMXSAMXSSMXSASXAAXXAMAMXMSXXAXXXMMXXAAMASXAAAMMMMAMAMSMAMSA
ASASXXMSSSMMSASAAXXAMSMMMXMXSAMAMMSXMMXAAAMMAMXXXAAMXSAAXAAAAAXAMXASAMXMMSSSMMMMXMXMMAMXXMAMSAMMMMMMAMASAAAMMMXSXMSSMSMSSSMMMMSAAMMSMMMMAMMM
XSAMXMAAAMXXMAMMMSASMXMASAAAXXMXMXXMAASMSMSSSMAAMSMMAMMXSMSMSMSMMXMMXSXMAMMAMXMMXSAMSSMMMMXMMAMXAXASXSASMSMSXMASMMAXAMAXAXMAMAMXXSMMAAMSSSMS
MMMMMMMMSMXMMXMASXAXAAMASXMAXSAMXAMXXMXAXMMAMXXSMXAMXMXAXXAXAXMASXSXMAXMAXSAMXSAXXAMAXAAAAAMSXSSMSMXXMXXAAXMAMXSAMASXMMMAMSAMXMAMSASMMMAAAAS
XMAMAAXMAMXXAAMXMMMMSXMASAXMASMSMXSSSSMXMXMAMXAXXSXMMXSAMMSXMSMASXAXAASXMMAASAMXSSSMSSSSSSMXAAAAMAXMSMSMSMSSXMASMMASXAXAXASMXSAMXSAMXMMMSMMM
MSSSSSSXSXSXSMSAMAXAMAMXSMMSMMXMMMAXAAASMSSSSMMMMXAXMAXAAMAASMMASXSXMASAAMSMMMMAXXXAAAXXAAXMASMMXMSXAAAAAAXMSMMSXMXMMAMSMMMSASXSAMXMAMXAMMMS
MMMAXAMAMAMXMAMXXAXSMSMAMXAXASMAAMXMMMMXAAAMXAAMMSAXMASMSMSSMAMAXMAASASMMMAAXSMSSMMMMSMXSMMMAMMSAMMMMSMMMXMAASAMXSMMMSAAXAAAMSAXXXASASMMMAAA
SAMXMMMAMAMMSAMSMSXMAAMMAMXSAMASMSAMSMSMMMSMXSMSAMXMSAXXAAMAMAMXXASAMAMMMXMSMXXMAXAAXMXMMXMMXMASMSAMXAAMSSMSMSMSAMAAAMSSSMSXAMMMSMASAMMASMSS
XSMXAXAAXXMAMAMXAMAMXMMXAAXMAMXMXSMSAAAXXMXXAAXMMSXMASXSMSMASMMMSMMMMSMSAASAMXSSMMSSSXMAXASXMMAMXMMMMMSMAAXXAMAMMSSMXXAXXXXMMXSAAMAMAXSMSMAA
SXXSAMMXXXMAMAMMAMXMSXMXAMXXAMMXASXSMSMXXSAMSSMMXMXMAMXMAMMMMXMAAXXAAXMMXMXAMAMAMAXAXMASMMMAASAMSMMSSMAMMSASAMXMAXMMSMMMSSXAXAMMMMXMMXMAXXMX
AXAAAMAASMSASXSMAMAMAASXSMMSASAMXSAXAMMSMMMMMAXMAMAMMMAMAMMMASMSMSSMSSMAMSSSMASXMSMSMMAXXMMMMMAXSAAAAXMSXXASXMAXMMMAASASAMXMMMSMSSMMSSMAMMXM
MMMMSMXXSAAAAAXXASASXXMAMAASXMASMMMMSMAAAASASMMSASASMSSMASXMAMAAXMASAXMAMXAASAMXAXAAAMSSSMAXXSXMSMMSSMXAAMAMXSXSXAMSSSSMASAXAMAXAAAAAAAMSAAA
XXXXMAMXMAMSMAMSXSMSXMMAMMMMXXMAMAXXXMSSSMSMSXMSASMSMXMAXSAMMSSMSSMMSSSMSMSMMSAMXMSMSMMAASXSAMXMXXMAXXSMSMSMMXXSMSXXAMXMASASMSSSSSMMSSMXAXSS 
""".trimIndent()