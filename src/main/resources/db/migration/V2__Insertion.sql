-- Insert sample data into admin table
INSERT INTO admin (id, password)
VALUES
(1, 'adminPass123');

-- Insert sample data into theatre table
INSERT INTO theatre (theatre_id, password, theatre_name, theatre_address)
VALUES
(1, 'theatrePass123', 'PVR Cinemas', '123 Cinema Road, City'),
(2, 'theatrePass456', 'INOX', '456 Movie Lane, City');

-- Insert sample data into movie table
INSERT INTO movie (movieName, releaseDate, movieSynopsis, censor, imageUrl, genre, language)
VALUES
('Inception', '2010-07-16', 'A thief who steals corporate secrets...', 'PG-13', 'inception.jpg', 'Sci-Fi', 'English'),
('Avatar', '2009-12-18', 'A paraplegic marine is dispatched...', 'PG-13', 'avatar.jpg', 'Action', 'English');

-- Insert sample data into screen table
INSERT INTO screen (screen_name, total_rows, total_columns, budget_rows, theatre_id)
VALUES
('Screen 1', 10, 15, 5, 1),
('Screen 2', 12, 18, 6, 1),
('Screen A', 8, 12, 4, 2);

-- Insert sample data into show_table
INSERT INTO show_table (show_name, screen_id)
VALUES
('Morning Show', 1),
('Evening Show', 2),
('Late Night Show', 3);

-- Insert sample data into timings table
INSERT INTO timings (start_time, end_time, screen_id)
VALUES
('09:00:00', '12:00:00', 1),
('18:00:00', '21:00:00', 2),
('22:00:00', '01:00:00', 3);

-- Insert sample data into user table
INSERT INTO user (name, password, email, number, address)
VALUES
('John Doe', 'userPass123', 'johndoe@example.com', '1234567890', '123 Main Street'),
('Jane Smith', 'userPass456', 'janesmith@example.com', '0987654321', '456 Elm Street');

-- Insert sample data into ticket table
INSERT INTO ticket (user_id, no_of_seats, movie_name, theatre_name, screen_name, show_date, show_timing, seat_numbers, price)
VALUES
(1, 2, 'Inception', 'PVR Cinemas', 'Screen 1', '2024-09-10', '09:00:00', 'A1, A2', 500),
(2, 1, 'Avatar', 'INOX', 'Screen A', '2024-09-10', '22:00:00', 'B1', 250);

-- Insert sample data into invoice table
INSERT INTO invoice (transId, time, quantity, price, userId, userName)
VALUES
('TXN123456', '09:15:00', 2, 500, 1, 'John Doe'),
('TXN654321', '22:15:00', 1, 250, 2, 'Jane Smith');

-- Insert sample data into movie_theatre table
INSERT INTO movie_theatre (movie_id, theatre_id)
VALUES
(1, 1),  -- Inception at PVR Cinemas
(2, 2);  -- Avatar at INOX

-- Insert sample data into order table
INSERT INTO `order` (price, currency, method, intent, description)
VALUES
(500.00, 'INR', 'Credit Card', 'Sale', 'Order for 2 tickets of Inception'),
(250.00, 'INR', 'Debit Card', 'Sale', 'Order for 1 ticket of Avatar');
