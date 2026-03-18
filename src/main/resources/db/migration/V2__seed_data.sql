-- ==========================================
-- USERS
-- ==========================================

INSERT INTO users (email, password, role)
VALUES ('player1@mail.com', '12444444', 'PLAYER'),
       ('player2@mail.com', '12444444', 'PLAYER'),
       ('player3@mail.com', '12444444', 'PLAYER'),
       ('player4@mail.com', '12444444', 'PLAYER'),
       ('player5@mail.com', '12444444', 'PLAYER'),
       ('player6@mail.com', '12444444', 'PLAYER'),
       ('player7@mail.com', '12444444', 'PLAYER'),
       ('player8@mail.com', '12444444', 'PLAYER'),
       ('player9@mail.com', '12444444', 'PLAYER'),
       ('player10@mail.com', '12444444', 'PLAYER'),

       ('team1@mail.com', '12444444', 'TEAM'),
       ('team2@mail.com', '12444444', 'TEAM'),
       ('team3@mail.com', '12444444', 'TEAM'),
       ('team4@mail.com', '12444444', 'TEAM'),
       ('team5@mail.com', '12444444', 'TEAM'),
       ('team6@mail.com', '12444444', 'TEAM'),
       ('team7@mail.com', '12444444', 'TEAM'),
       ('team8@mail.com', '12444444', 'TEAM'),
       ('team9@mail.com', '12444444', 'TEAM'),
       ('team10@mail.com', '12444444', 'TEAM');


-- ==========================================
-- PLAYER PROFILES
-- ==========================================

INSERT INTO player_profile
(user_id, f_name, l_name, age_in_years, city, primary_position, description)
VALUES (1, 'Nikos', 'Papadopoulos', 24, 'Athens', 'ST', 'Fast striker'),
       (2, 'Giorgos', 'Nikolaou', 21, 'Thessaloniki', 'CM', 'Creative midfielder'),
       (3, 'Dimitris', 'Karalis', 26, 'Patras', 'CB', 'Strong defender'),
       (4, 'Kostas', 'Ioannidis', 23, 'Athens', 'RW', 'Fast winger'),
       (5, 'Andreas', 'Mavros', 28, 'Larisa', 'GK', 'Experienced goalkeeper'),
       (6, 'Petros', 'Galanis', 22, 'Volos', 'LB', 'Attacking fullback'),
       (7, 'Stavros', 'Kotsis', 25, 'Athens', 'CAM', 'Playmaker'),
       (8, 'Michalis', 'Zografos', 20, 'Heraklion', 'LW', 'Young winger'),
       (9, 'Panagiotis', 'Raptis', 27, 'Ioannina', 'CDM', 'Defensive midfielder'),
       (10, 'Alexandros', 'Karras', 24, 'Athens', 'RB', 'Solid right back');


-- ==========================================
-- TEAM PROFILES
-- ==========================================

INSERT INTO team_profile
(user_id, team_name, city, category, division, home_ground, description)
VALUES (11, 'Athens FC', 'Athens', 'A_LOCAL', 'EPS ATHENS', 'Athens Stadium', 'Competitive amateur club'),
       (12, 'Thess United', 'Thessaloniki', 'B_LOCAL', 'EPSM', 'North Arena', 'Young team'),
       (13, 'Patraikos', 'Patras', 'A_LOCAL', 'EPS ACHAIA', 'Patras Arena', 'Looking for attackers'),
       (14, 'Larisa Town', 'Larisa', 'B_LOCAL', 'EPS LARISA', 'Larisa Field', 'Developing squad'),
       (15, 'Volos City', 'Volos', 'A_LOCAL', 'EPS THESSALY', 'Volos Stadium', 'Experienced players'),
       (16, 'Heraklion Stars', 'Heraklion', 'B_LOCAL', 'EPS IRAKLIOU', 'Crete Arena', 'Youth focused club'),
       (17, 'Ioannina Eagles', 'Ioannina', 'A_LOCAL', 'EPS IONNINA', 'Lake Stadium', 'Ambitious club'),
       (18, 'Athens Youth', 'Athens', 'G_LOCAL', 'EPS ATHENS', 'Youth Ground', 'Development academy'),
       (19, 'Salonika FC', 'Thessaloniki', 'A_LOCAL', 'EPSM', 'North Field', 'Competitive squad'),
       (20, 'Piraeus Athletic', 'Piraeus', 'B_LOCAL', 'EPS PIRAEUS', 'Port Arena', 'New club');


-- ==========================================
-- PLAYER SECONDARY POSITIONS
-- ==========================================

INSERT INTO player_secondary_positions (player_id, position)
VALUES (1, 'LW'),
       (2, 'CAM'),
       (3, 'RB'),
       (4, 'LW'),
       (5, 'CB'),
       (6, 'LM'),
       (7, 'CM'),
       (8, 'RW'),
       (9, 'CB'),
       (10, 'LB');


-- ==========================================
-- PLAYER PREFERRED CATEGORIES
-- ==========================================

INSERT INTO player_preferred_categories (player_id, category)
VALUES (1, 'A_LOCAL'),
       (2, 'B_LOCAL'),
       (3, 'A_LOCAL'),
       (4, 'A_LOCAL'),
       (5, 'B_LOCAL'),
       (6, 'G_LOCAL'),
       (7, 'A_LOCAL'),
       (8, 'B_LOCAL'),
       (9, 'A_LOCAL'),
       (10, 'B_LOCAL');


-- ==========================================
-- PLAYER AVAILABILITY
-- ==========================================

INSERT INTO player_availability (player_id, day)
VALUES (1, 'SATURDAY'),
       (1, 'SUNDAY'),

       (2, 'SUNDAY'),

       (3, 'SATURDAY'),
       (3, 'SUNDAY'),

       (4, 'THURSDAY'),
       (4, 'SUNDAY'),

       (5, 'MONDAY'),
       (5, 'WEDNESDAY'),

       (6, 'FRIDAY'),
       (6, 'SUNDAY'),

       (7, 'SATURDAY'),

       (8, 'TUESDAY'),
       (8, 'SUNDAY'),

       (9, 'THURSDAY'),
       (9, 'SATURDAY'),

       (10, 'SUNDAY');