-- Create admin table
CREATE TABLE IF NOT EXISTS admin (
    id INT PRIMARY KEY,
    password VARCHAR(255) NOT NULL
);

-- Create theatre table
CREATE TABLE IF NOT EXISTS theatre (
    theatre_id INT PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    theatre_name VARCHAR(255) NOT NULL,
    theatre_address VARCHAR(255) NOT NULL
);

-- Create movie table with proper indexing for movieId
CREATE TABLE IF NOT EXISTS movie (
    movieId INT PRIMARY KEY AUTO_INCREMENT,
    movieName VARCHAR(255),
    releaseDate DATE,
    movieSynopsis TEXT,
    censor VARCHAR(10),
    imageUrl VARCHAR(255),
    genre VARCHAR(255),
    language VARCHAR(255)
);

-- Ensure movieId has an index for foreign key references
CREATE INDEX idx_movieId ON movie (movieId);

-- Create screen table (depends on theatre)
CREATE TABLE IF NOT EXISTS screen (
    screen_id INT PRIMARY KEY AUTO_INCREMENT,
    screen_name VARCHAR(255) NOT NULL,
    total_rows INT NOT NULL,
    total_columns INT NOT NULL,
    budget_rows INT NOT NULL,
    theatre_id INT, -- Foreign key to the theatre table
    CONSTRAINT fk_theatre FOREIGN KEY (theatre_id) REFERENCES theatre (theatre_id)
);

-- Create show_table (depends on screen)
CREATE TABLE IF NOT EXISTS show_table (
    id INT PRIMARY KEY AUTO_INCREMENT,
    show_name VARCHAR(255),
    screen_id INT,
    CONSTRAINT fk_screen FOREIGN KEY (screen_id) REFERENCES screen (screen_id)
);

-- Create timings table (depends on screen)
CREATE TABLE IF NOT EXISTS timings (
    id INT PRIMARY KEY AUTO_INCREMENT,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    screen_id INT,
    CONSTRAINT fk_screen_timing FOREIGN KEY (screen_id) REFERENCES screen (screen_id)
);

-- Create user table
CREATE TABLE IF NOT EXISTS user (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    number VARCHAR(15) NOT NULL UNIQUE,
    address VARCHAR(255) NOT NULL
);

-- Create ticket table (depends on user and screen)
CREATE TABLE IF NOT EXISTS ticket (
    ticket_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    no_of_seats INT NOT NULL,
    movie_name VARCHAR(255) NOT NULL,
    theatre_name VARCHAR(255) NOT NULL,
    screen_name VARCHAR(255) NOT NULL,
    show_date DATE NOT NULL,
    show_timing TIME NOT NULL,
    seat_numbers VARCHAR(255) NOT NULL,
    price INT NOT NULL,
    CONSTRAINT fk_user_ticket FOREIGN KEY (user_id) REFERENCES user (user_id)
);

-- Create invoice table (depends on user)
CREATE TABLE IF NOT EXISTS invoice (
    transId VARCHAR(255) PRIMARY KEY,
    time TIME NOT NULL,
    quantity INT NOT NULL,
    price INT NOT NULL,
    userId INT NOT NULL,
    userName VARCHAR(255) NOT NULL
);

-- Create movie_theatre table (depends on movie and theatre)
CREATE TABLE IF NOT EXISTS movie_theatre (
    movie_id INT NOT NULL,
    theatre_id INT NOT NULL,
    CONSTRAINT fk_movie FOREIGN KEY (movie_id) REFERENCES movie (movieId),
    CONSTRAINT fk_movie_theatre_theatre FOREIGN KEY (theatre_id) REFERENCES theatre (theatre_id),
    PRIMARY KEY (movie_id, theatre_id)
);

-- Create order table (independent)
CREATE TABLE IF NOT EXISTS `order` (
    price DECIMAL(10, 2) NOT NULL,
    currency VARCHAR(10) NOT NULL,
    method VARCHAR(50) NOT NULL,
    intent VARCHAR(50) NOT NULL,
    description TEXT NOT NULL
);