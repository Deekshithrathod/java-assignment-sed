import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Artist {
    private String artistId;
    private String birthDate;
    private String address;
    private String bio;
    private List<String> occupations;
    private List<String> awards;
    private List<String> musicGenres;

    public Artist() {
        this.occupations = new ArrayList<>();
        this.awards = new ArrayList<>();
        this.musicGenres = new ArrayList<>();
    }

    public boolean addArtist(String artistId, String birthDate, String address, String bio,
                             List<String> occupations, List<String> awards, List<String> musicGenres) {
        // Condition 1: Check Artist ID format
        if (!isValidArtistId(artistId)) {
            return false;
        }

        // Condition 2: Check Birth Date format
        if (!isValidBirthDate(birthDate)) {
            return false;
        }

        // Condition 3: Check Address format
        if (!isValidAddress(address)) {
            return false;
        }

        // Condition 4: Check Bio length
        if (!isValidBioLength(bio)) {
            return false;
        }

        // Condition 5: Check Occupations count
        if (!isValidOccupationsCount(occupations)) {
            return false;
        }

        // Condition 6: Check Awards format and count
        if (!isValidAwards(awards)) {
            return false;
        }

        // Condition 7: Check Music Genres count and conflict
        if (!isValidMusicGenres(musicGenres)) {
            return false;
        }

        // If all conditions are met, add the artist information to the TXT file (or perform any desired action)
        writeToFile(artistId, birthDate, address, bio, occupations, awards, musicGenres);

        return true;
    }

    private boolean isValidArtistId(String artistId) {
        String pattern = "^[5-9]\\d{2}[A-Z]{5}[!@#$%^&*()_+]$";
        return artistId.matches(pattern);
    }

    private boolean isValidBirthDate(String birthDate) {
        String pattern = "^\\d{2}-\\d{2}-\\d{4}$";
        return birthDate.matches(pattern);
    }

    private boolean isValidAddress(String address) {
        String pattern = "^[^|]+\\|[^|]+\\|[^|]+$";
        return address.matches(pattern);
    }

    private boolean isValidBioLength(String bio) {
        int wordCount = bio.split("\\s+").length;
        return wordCount >= 10 && wordCount <= 30;
    }

    private boolean isValidOccupationsCount(List<String> occupations) {
        return !occupations.isEmpty() && occupations.size() <= 5;
    }

    private boolean isValidAwards(List<String> awards) {
        if (awards.size() > 3) {
            return false;
        }

        String awardPattern = "^\\d{4}, [\\w\\s]{4,10}$";
        for (String award : awards) {
            if (!award.matches(awardPattern)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidMusicGenres(List<String> musicGenres) {
        if (musicGenres.size() < 2 || musicGenres.size() > 5) {
            return false;
        }

        int popCount = 0;
        int rockCount = 0;

        for (String genre : musicGenres) {
            if (genre.equalsIgnoreCase("pop")) {
                popCount++;
            } else if (genre.equalsIgnoreCase("rock")) {
                rockCount++;
            }
        }

        return popCount <= 1 && rockCount <= 1;
    }

    private void writeToFile(String artistId, String birthDate, String address, String bio,
                             List<String> occupations, List<String> awards, List<String> musicGenres) {
        // Implement writing to the TXT file or perform any desired action
        // Example: Write the artist information to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("artists.txt", true))) {
            writer.write("Artist ID: " + artistId + "\n");
            writer.write("Birth Date: " + birthDate + "\n");
            writer.write("Address: " + address + "\n");
            writer.write("Bio: " + bio + "\n");

            writer.write("Occupations: ");
            for (String occupation : occupations) {
                writer.write(occupation + ", ");
            }
            writer.write("\n");

            writer.write("Awards: ");
            for (String award : awards) {
                writer.write(award + ", ");
            }
            writer.write("\n");

            writer.write("Music Genres: ");
            for (String genre : musicGenres) {
                writer.write(genre + ", ");
            }
            writer.write("\n");

            writer.write("\n");  // Add a separator for each artist
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean updateArtist(String newArtistId, String newBirthDate, String newAddress, String newBio,
                                List<String> newOccupations, List<String> newAwards, List<String> newMusicGenres) {
        // Condition 1: Check all constraints for updating an artist
        if (!addArtist(newArtistId, newBirthDate, newAddress, newBio, newOccupations, newAwards, newMusicGenres)) {
            return false;
        }

        // Condition 2: If an artist was born before 2000, their occupation cannot be changed.
        int birthYear = Integer.parseInt(newBirthDate.split("-")[2]);
        if (birthYear < 2000 && !newOccupations.equals(this.occupations)) {
            return false;
        }

        // Condition 3: Awards that were given before 2000 cannot be changed.
        for (String newAward : newAwards) {
            int awardYear = Integer.parseInt(newAward.split(",")[0].trim());
            if (awardYear < 2000 && !awards.contains(newAward)) {
                return false;
            }
        }

        // If all conditions are met, update the artist information in the TXT file (or perform any desired action)
        writeToFile(newArtistId, newBirthDate, newAddress, newBio, newOccupations, newAwards, newMusicGenres);

        return true;
    }
}
