# java-assignment-sed
Id:
 - 578MMRRR_%
 - 378MMRRR_%

DOB:
 - 06-11-1980
 - 16th Jan, 2022
 
Address:
 - Delhi|Victoria|Australia
 - Delhi Vi

Bio
 - Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio
 - Fail Bio

Occupation
 - Writer
 - Writer Writer Writer Writer Writer
 - Writer,Writer,Writer,Writer,Writer

Awards
 - 2022, Writer of Writer of Writer of
 - 2022, Writer

Genres
 - Western, pop
 - Western, pop, pop, pop, pop, pop

6 test cases
- 2 test data each


addArtist("578MMRRR_%","06-11-1980","Delhi|Victoria|Australia","Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio",List.of("Singer", "Songwriter"),
                List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical"))
addArtist("378MMRRR_%","06-11-1980","Delhi|Victoria|Australia","Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio",List.of("Singer", "Songwriter"),
                List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical"))
---
addArtist("578MMRRR_%","16th Jan, 2022","Delhi|Victoria|Australia","Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio",List.of("Singer", "Songwriter"), List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical"))
addArtist("578MMRRR_%","06-11-1980","Delhi VI","Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio",List.of("Singer", "Songwriter"), List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical"))

addArtist("378MMRRR_%","16th Jan, 2022","Delhi|Victoria|Australia","Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio",List.of("Singer", "Songwriter"),                List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical"))
addArtist("378MMRRR_%","06-11-1980","Delhi VI","Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio",List.of("Singer", "Songwriter"),
                List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical"))

addArtist("578MMRRR_%","16th Jan, 2022","Delhi VI","Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio",List.of("Singer", "Songwriter"),
                List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical"))
addArtist("378MMRRR_%","16th Jan, 2022","Delhi VI","Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio",List.of("Singer", "Songwriter"),
                List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical"))
---
addArtist("578MMRRR_%","06-11-1980","Delhi|Victoria|Australia","BioSignleFail")
addArtist("378MMRRR_%","06-11-1980","Delhi|Victoria|Australia","BioSignleFail")

addArtist("578MMRRR_%","16th Jan, 2022","Delhi|Victoria|Australia","BioSignleFail")
addArtist("378MMRRR_%","16th Jan, 2022","Delhi|Victoria|Australia","BioSignleFail")

addArtist("578MMRRR_%","06-11-1980","Delhi VI","BioSignleFail")
addArtist("378MMRRR_%","06-11-1980","Delhi VI","BioSignleFail")

addArtist("578MMRRR_%","16th Jan, 2022","Delhi VI","BioSignleFail")
addArtist("378MMRRR_%","16th Jan, 2022","Delhi VI","BioSignleFail")


---
addArtist("06-11-1980")
addArtist("16th Jan, 2022")