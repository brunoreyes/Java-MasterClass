package sample.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING =
            "jdbc:sqlite:/Users/brunoreyes/Desktop/Code/Java/Java-MasterClass/Music/" + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    // unlike indexes, indices are based on start on point position 1
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 4;

    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    // adding sort order query as constants making it easier for querying
    public static final String QUERY_ALBUMS_BY_ARTIST_START =
            "SELECT " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " FROM " + TABLE_ALBUMS +
                    " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." +
                    COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
                    " WHERE " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + " = \"";
    // since the concatenations only take place once when a datasource instance is created, we stick with
    //    concatenations
    public static final String QUERY_ALBUMS_BY_ARTIST_SORT =
            " ORDER BY " + TABLE_ALBUMS + "." + COLUMN_ARTIST_NAME + " COLLATE NOCASE ";

    public static final String QUERY_ARTIST_FOR_SONG_START =
            "SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
                    TABLE_SONGS + "." + COLUMN_SONG_TRACK + " FROM " + TABLE_SONGS +
                    " INNER JOIN " + TABLE_ALBUMS + " ON " +
                    TABLE_SONGS + "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
                    " INNER JOIN " + TABLE_ARTISTS + " ON " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
                    " WHERE " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + " = \"";

    public static final String QUERY_ARTIST_FOR_SONG_SORT =
            " ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";

    public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";

    public static final String CREATE_ARTIST_FOR_SONG_VIEW = "CREATE VIEW IF NOT EXISTS " +
            TABLE_ARTIST_SONG_VIEW + " AS SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " AS " + COLUMN_SONG_ALBUM + ", " +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK + ", " + TABLE_SONGS + "." + COLUMN_SONG_TITLE +
            " FROM " + TABLE_SONGS +
            " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS +
            "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
            " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
            " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
            " ORDER BY " +
            TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK;

    public static final String QUERY_VIEW_SONG_INFO = "SELECT " + COLUMN_ARTIST_NAME + ", " +
            COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW +
            " WHERE " + COLUMN_SONG_TITLE + " = \"";

    // SELECT name, album, track FROM artist_list WHERE title = ?
    public static final String QUERY_VIEW_SONG_INFO_PREP = "SELECT " + COLUMN_ARTIST_NAME + ", " +
            COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW +
            " WHERE " + COLUMN_SONG_TITLE + " = ?"; // ? is the placeholder character

    // SELECT name, album, track FROM artist_list WHERE title = ? OR artist = ?
    // can't use placeholders for table or column names

    // INSERT INTO artists(name) VALUES(?)
    public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS +
            '(' + COLUMN_ARTIST_NAME + ") VALUES(?)";


    // INSERT INTO albums(name, artist) VALUES(?,?)
    public static final String INSERT_ALBUMS = "INSERT INTO " + TABLE_ALBUMS +
            '(' + COLUMN_ALBUM_NAME + ", " + COLUMN_ALBUM_ARTIST + ") VALUES(?, ?)";

    // INSERT INTO songs(track, title, album) VALUES(?,?,?)
    public static final String INSERT_SONGS = "INSERT INTO " + TABLE_SONGS +
            '(' + COLUMN_SONG_TRACK + ", " + COLUMN_SONG_TITLE + ", " + COLUMN_SONG_ALBUM + ") VALUES(?, ?, ?)";

    // Select will return the id, the where clause will do a search by name, getting back the id we can use for the insertion,
    // if the id doesn't exist we will return the id after the insert.
    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID + " FROM " +
            TABLE_ARTISTS + " WHERE " + COLUMN_ARTIST_NAME + " = ?";
    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUM_ID + " FROM " +
            TABLE_ALBUMS + " WHERE " + COLUMN_ALBUM_NAME + " = ?";

    // SELECT * FROM ALBUMS WHERE artist = ? ORDER BY name COLLATE NOCASE
    public static final String QUERY_ALBUMS_BY_ARTIST_ID = "SELECT * FROM " + TABLE_ALBUMS +
            " WHERE " + COLUMN_ALBUM_ARTIST + " = ? ORDER BY " + COLUMN_ARTIST_NAME + " COLLATE NOCASE";

    private Connection connection;

    private PreparedStatement querySongInfoView;

    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;

    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;
    private PreparedStatement queryAlbumsByArtistId;

    // This is lazy initiation because the instance won't be created until the 1st time the class is loaded,
    // which is the 1st time another instance references the class by calling the getInstance().
    private static Datasource instance = new Datasource();

    // Since Datasource is marked private, only the class will be able to create an instance of itself
    private Datasource(){

    }

    // The code is valid but not thread-safe, possible for a thread to be interpted after checking for null
    public static Datasource getInstance(){
//        if (instance == null ){
//            instance = new Datasource();
//        }
        return instance;
    }

    public boolean open() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);

            // Calling the connection.prepare statement method to create that instance of prepared statement,
            // passing it to sequel, where we'll execute. Recall that sequel contains the placeholders,
            // that will be replaced everytime we use the statement to make a query
            querySongInfoView = connection.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);

            // "_id" is the key and the DB generates the value whenever it insets the record into the table
            // 2nd parameter is the constant, key aka "_id", allowing to access the keys from the prepared statement object.
            insertIntoArtists = connection.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = connection.prepareStatement(INSERT_ALBUMS, Statement.RETURN_GENERATED_KEYS);
            // insertIntoSongs doesn't need the id's returned, so there's no need to grab the keys bc they don't need to pass to anything else.
            insertIntoSongs = connection.prepareStatement(INSERT_SONGS);

            queryArtist = connection.prepareStatement(QUERY_ARTIST);
            queryAlbum = connection.prepareStatement(QUERY_ALBUM);
            queryAlbumsByArtistId = connection.prepareStatement(QUERY_ALBUMS_BY_ARTIST_ID);

            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to a database: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public void close() {
        try {
            // We cannot close the connection first, because we need an open connection to close statements,
            // always closing resources in the reverse order in which they were opened
            if (querySongInfoView != null){
                querySongInfoView.close();
            }

            // Checking to see if the Artists or Album or Song exist, if so, I return the _id
            if (insertIntoArtists != null){
                insertIntoArtists.close();
            }
            if (insertIntoAlbums != null){
                insertIntoAlbums.close();
            }
            if (insertIntoSongs != null){
                insertIntoSongs.close();
            }

            if (queryArtist != null){
                queryArtist.close();
            }

            if (queryAlbum != null){
                queryAlbum.close();
            }

            if (queryAlbumsByArtistId != null){
                queryAlbumsByArtistId.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection " + e.getMessage());
        }
    }

    public List<Artist> queryArtist(int sortOrder) {
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTISTS);
        if (sortOrder != ORDER_BY_NONE) {
            sb.append(" ORDER BY ");
            sb.append(COLUMN_ARTIST_NAME);
            sb.append(" COLLATE NOCASE "); // case-insensitive order
            if (sortOrder == ORDER_BY_DESC) {
                sb.append("DESC ");
            } else {
                sb.append("ASC "); // The default option
            }

        }
//        Statement statement = null;
//        ResultSet results = null;

        // utilizing the try with resources allows to get rid of finally clause because both
        // the Statement and ResultSet will now automatically be closed
        // and initialized Statement and ResultSet above are no longer necessary
        try (Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {
//            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS)) {
//            statement = connection.createStatement();
//            results = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS);

            // Creating a list called artists, comprised of Artist objects
            List<Artist> artists = new ArrayList<>();
            while (results.next()) { // while there is a next artist
                Artist artist = new Artist();
                artist.setId(results.getInt(INDEX_ARTIST_ID));
                artist.setName(results.getString(INDEX_ARTIST_NAME));
                artists.add(artist);
            }
            return artists;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }

//        } finally {
//            try {
//                if (results != null){
//                    results.close();
//                }
//            } catch (SQLException e){
//                System.out.println("Error closing ResultSet " + e.getMessage());
//            }
//            try {
//                if (statement != null){
//                    statement.close();
//                }
//            } catch (SQLException e){
//                System.out.println("Error closing Statement "  + e.getMessage());
//            }
//        }
    }

    // setting the artist id in the prepared statement, running it, and setting the results
    public List<Album> queryAlbumForArtistId(int id){
        try {
            queryAlbumsByArtistId.setInt(1, id);
            ResultSet results = queryAlbumsByArtistId.executeQuery();

            List<Album> albums = new ArrayList<>();
            while (results.next()){
                Album album = new Album();
                album.setId(results.getInt(1));
                album.setName(results.getString(2));
                album.setArtistId(id); // know it's the same, no need to do extra retrieval from database
                albums.add(album);
            }
            return albums;
        } catch (SQLException e){
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    // select albums.name from albums inner join artists on albums.artist
    // = artist._id where artist.name = "Carole King
    // order by albums.name collate nocase asc
    public List<String> queryAlbumsForArtist(String artistName, int sortOrder) {

        StringBuilder sb = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START);
        sb.append(artistName);
        sb.append("\"");
        // the commented out code beneath has been converted to a constant above
//        sb.append(TABLE_ALBUMS);
//        sb.append(".");
//        sb.append(COLUMN_ALBUM_NAME);
//        sb.append(" FROM ");
//        sb.append(TABLE_ALBUMS);
//        sb.append(" INNER JOIN ");
//        sb.append(TABLE_ARTISTS);
//        sb.append(" ON ");
//        sb.append(TABLE_ALBUMS);
//        sb.append(".");
//        sb.append(COLUMN_ALBUM_ARTIST);
//        sb.append(" = ");
//        sb.append(TABLE_ARTISTS);
//        sb.append("."); // the period is for accessing rows within the tables. For Ex: artists.id
//        sb.append(COLUMN_ARTIST_ID);
//        sb.append(" WHERE ");
//        sb.append(TABLE_ARTISTS);
//        sb.append(".");
//        sb.append(COLUMN_ARTIST_NAME);
//        sb.append(" = \"");
//        sb.append(artistName); // putting the artist's name within double quotes
//        sb.append("\"");

        if (sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_ALBUMS_BY_ARTIST_SORT);
            // the commented out code beneath has been converted to a constant above
//            sb.append(" ORDER BY ");
//            sb.append(TABLE_ALBUMS);
//            sb.append(".");
//            sb.append(COLUMN_ALBUM_NAME);
//            sb.append(" COLLATE NOCASE ");
            if (sortOrder == ORDER_BY_DESC) {
                sb.append("DESC"); // no need to add extra space since this is the end of the query
            } else {
                sb.append("ASC");
            }
        }
        System.out.println("SQL statement = " + sb.toString());
        try (Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {
            List<String> albums = new ArrayList<>();
            while (results.next()) {
                albums.add(results.getString(1));
            }
            return albums;

        } catch (SQLException e) {
            System.out.println("Query failed " + e.getMessage());
            return null;
        }
    }



    public void querySongsMetaData() {
        String sql = "SELECT * FROM " + TABLE_SONGS;

        try (Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery(sql)) {

            ResultSetMetaData meta = results.getMetaData();
            int numColumns = meta.getColumnCount();
            for (int i = 1; i <= numColumns; i++) {
                System.out.format("Column %d in the songs table is names %s\n",
                        i, meta.getColumnName(i));
            }
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
    }

    // SELECT COUNT (*) FROM songs, how to get the count of songs?
    public int getCount(String table) {
        // Using As allows me to not have to change getter calls if I modify query String
        String sql = "SELECT COUNT(*) AS count, MIN(_id) AS min_id FROM " + table;
//        String sql = "SELECT COUNT(*) AS count FROM " + table;

        try (Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery(sql)) {

            int count = results.getInt("count");
//            int min = results.getInt("min_id");

            System.out.format("Count: %d\n", count);
//            System.out.format("Count = %d, Min = %d\n", count, min);
            return count; // treating the function result as a column
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return -1;
        }
    }

    public boolean createViewForSongArtists() {

        try (Statement statement = connection.createStatement()) {

            statement.execute(CREATE_ARTIST_FOR_SONG_VIEW);
            return true;

        } catch (SQLException e) {
            System.out.println("Create View failed: " + e.getMessage());
            return false;
        }
    }



    private int insertArtist(String name) throws SQLException {
        queryArtist.setString(1, name);
        ResultSet resultSet = queryArtist.executeQuery();
        // if we get a number back from our 1st query, we know the artist is on file,
        // returning the id, and exiting the method
        // not inserting the artist because they are already on file
        if (resultSet.next()){
            return resultSet.getInt(1);
        } else {
            // Insert the artist
            insertIntoArtists.setString(1, name);

            // executeUpdate() returns the # of rows affected by the SQL code ran
            int affectedRows = insertIntoArtists.executeUpdate();

            // Here if more than 1 row was affected something went wrong
            if (affectedRows != 1){
                throw new SQLException("Could not insert artist!");
            }

            // Using getGeneratedKeys() to get a resultSet that contains the generated key
            ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();
            if (generatedKeys.next()){
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Could not get artist' id ");
            }
        }
    }

    private int insertAlbum(String name, int artistId) throws SQLException {
        queryAlbum.setString(1, name);
        ResultSet resultSet = queryAlbum.executeQuery();
        // if we get a number back from our 1st query, we know the artist is on file,
        // returning the id, and exiting the method
        // not inserting the artist because they are already on file
        if (resultSet.next()){
            return resultSet.getInt(1);
        } else {
            // Insert the album, by updating 2 fields, album name & artist id
            insertIntoAlbums.setString(1, name);
            insertIntoAlbums.setInt(2, artistId);

            // executeUpdate() returns the # of rows affected by the SQL code ran
            int affectedRows = insertIntoAlbums.executeUpdate();

            // Here if more than 1 row was affected something went wrong
            if (affectedRows != 1){
                throw new SQLException("Could not insert album!");
            }

            // Using getGeneratedKeys() to get a resultSet that contains the generated key
            ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
            if (generatedKeys.next()){
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Could not get album' id ");
            }
        }
    }

    // public while insertAlbum() and insertArtist() are private
    public void insertSong(String title, String artist, String album, int track) {

        // Recall I turned off the default auto-commit behavior to run a series of SQL statements as a transaction
        // rather than committing every change by running every update, delete, and insert statement as a transaction
        try {
            connection.setAutoCommit(false);

            // returning the id of the existing artist or the newly inserted record
            int artistId = insertArtist(artist);

            // inserting the song and making sure only one row was affected by SQL
            int albumId = insertAlbum(album, artistId);
            insertIntoSongs.setInt(1, track);
            insertIntoSongs.setString(2, title);
            insertIntoSongs.setInt(3, albumId);
            int affectedRows = insertIntoSongs.executeUpdate();
            if (affectedRows == 1){
                connection.commit();
            } else {
                throw new SQLException("The song insert failed");
            }
            // If something goes wrong we rollback if any errors occur
        } catch (Exception e){
            System.out.println("Insert song exception: " + e.getMessage());
            try {
                System.out.println("Performing Rollback");
                connection.rollback();
                // connection.setSavePoint() allows us to rollback a transaction to a specific point, returning a save point object
            } catch (SQLException e2){
                System.out.println("Oh boy, things are really bad " + e2.getMessage());
            }
        } finally {
            // turning back on the auto commit after the transaction,
            // ensuring it will turn on if the transaction succeeds or fails
            try {
                System.out.println("Resetting default commit behavior");
                connection.setAutoCommit(true);
            } catch (SQLException e){
                System.out.println("Could not reset auto-commit " + e.getMessage());
            }
        }
    }

}