import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArtistTest {

    @Test
    public void testAddArtistValidData() {
        Artist artist = new Artist();
        assertTrue(artist.addArtist("567ABCDEF_", "05-11-1990", "Melbourne|Victoria|Australia",
                "Talented artist with a passion for music.", List.of("Singer", "Songwriter"),
                List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical")));

        assertTrue(artist.addArtist("678DEFGHI_", "15-03-1985", "New York|NY|USA",
                "Versatile musician with a love for jazz.", List.of("Pianist", "Composer"),
                List.of("2005, Jazz Artist of the Year"), List.of("Jazz", "Blues")));
    }

    @Test
    public void testAddArtistInvalidData() {
        Artist artist = new Artist();
        assertFalse(artist.addArtist("123XYZ456_", "05-11-1990", "Melbourne|Victoria|Australia",
                "Short bio.", List.of("Singer", "Songwriter"), List.of(), List.of("Pop", "Classical")));

        assertFalse(artist.addArtist("567ABCDEF_", "05-11-1980", "Invalid Address Format",
                "Talented artist with a passion for music.", List.of("Singer", "Songwriter"),
                List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Rock")));

        assertFalse(artist.addArtist("999HHHHHHH", "05-11-1990", "Sydney|NSW|Australia",
                "Talented artist with a passion for music.", List.of("Singer", "Songwriter"),
                List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Rock")));
    }

    //    @Test
//    public void testUpdateArtistValidData() {
//        Artist artist = new Artist();
//        artist.addArtist("567ABCDEF_", "05-11-1990", "Melbourne|Victoria|Australia",
//                "Talented artist with a passion for music.", List.of("Singer", "Songwriter"),
//                List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical"));
//
//        assertTrue(artist.updateArtist("567ABCDEF_", "05-11-1995", "Melbourne|VIC|Australia",
//                "Updated bio for the talented artist.", List.of("Singer", "Songwriter", "Producer"),
//                List.of("2022, Best Song Written For Visual Media", "2025, Song of the Year"),
//                List.of("Pop", "Classical", "Electronic")));
//    }
    @Test
    public void testUpdateArtistValidData() {
        Artist artist = new Artist();
        artist.addArtist("567ABCDEF_", "05-11-1990", "Melbourne|Victoria|Australia",
                "Talented artist with a passion for music.", List.of("Singer", "Songwriter"),
                List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical"));

        assertTrue(artist.updateArtist("567ABCDEF_", "05-11-1995", "Melbourne|VIC|Australia",
                "Updated bio for the talented artist.", List.of("Singer", "Songwriter", "Producer"),
                List.of("2022, Best Song Written For Visual Media", "2025, Song of the Year"),
                List.of("Pop", "Classical", "Electronic")));
    }


    @Test
    public void testUpdateArtistInvalidData() {
        Artist artist = new Artist();
        artist.addArtist("567ABCDEF_", "05-11-1990", "Melbourne|Victoria|Australia",
                "Talented artist with a passion for music.", List.of("Singer", "Songwriter"),
                List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical"));

        // Attempt to change occupation for an artist born before 2000
        assertFalse(artist.updateArtist("567ABCDEF_", "05-11-1995", "Melbourne|VIC|Australia",
                "Updated bio for the talented artist.", List.of("Singer", "Songwriter", "Producer", "Actor"),
                List.of("2022, Best Song Written For Visual Media", "2025, Song of the Year"),
                List.of("Pop", "Classical", "Electronic")));

        // Attempt to change award information given before 2000
        assertFalse(artist.updateArtist("567ABCDEF_", "05-11-1995", "Melbourne|VIC|Australia",
                "Updated bio for the talented artist.", List.of("Singer", "Songwriter"),
                List.of("2022, Best Song Written For Visual Media", "1998, Debut Artist of the Year"),
                List.of("Pop", "Classical", "Electronic")));
    }
}
