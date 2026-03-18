-- ==========================================
-- USERS
-- ==========================================
CREATE TABLE users
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    email      VARCHAR(255) NOT NULL UNIQUE,
    role       VARCHAR(50),
    created_at DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active     BOOLEAN               DEFAULT TRUE
);

-- ==========================================
-- PLAYER PROFILE
-- ==========================================
CREATE TABLE player_profile
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id          BIGINT NOT NULL UNIQUE,
    f_name           VARCHAR(100),
    l_name           VARCHAR(100),
    age_in_years     INT,
    city             VARCHAR(255),
    primary_position VARCHAR(50),
    description      VARCHAR(500),

    CONSTRAINT fk_player_user
        FOREIGN KEY (user_id)
            REFERENCES users (id)
            ON DELETE CASCADE
);

-- ==========================================
-- TEAM PROFILE
-- ==========================================
CREATE TABLE team_profile
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id     BIGINT NOT NULL UNIQUE,

    team_name   VARCHAR(255),
    city        VARCHAR(255),
    category    VARCHAR(50),
    division    VARCHAR(100),
    home_ground VARCHAR(255),
    description VARCHAR(500),

    CONSTRAINT fk_team_user
        FOREIGN KEY (user_id)
            REFERENCES users (id)
            ON DELETE CASCADE
);

-- ==========================================
-- PLAYER REQUEST (Team creates)
-- ==========================================
CREATE TABLE player_request
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    team_id    BIGINT      NOT NULL,

    position   VARCHAR(50),
    category   VARCHAR(50),
    min_age    INT,
    max_age    INT,
    status     VARCHAR(50) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_request_team
        FOREIGN KEY (team_id)
            REFERENCES team_profile (id)
            ON DELETE CASCADE
);

-- ==========================================
-- APPLICATION (Player applies)
-- ==========================================
CREATE TABLE application
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    player_id  BIGINT NOT NULL,
    request_id BIGINT NOT NULL,

    status     VARCHAR(50),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_application_player
        FOREIGN KEY (player_id)
            REFERENCES player_profile (id)
            ON DELETE CASCADE,

    CONSTRAINT fk_application_request
        FOREIGN KEY (request_id)
            REFERENCES player_request (id)
            ON DELETE CASCADE,

    CONSTRAINT uk_player_request UNIQUE (player_id, request_id)
);

-- ==========================================
-- PLAYER INVITE (Team invites player)
-- ==========================================
CREATE TABLE player_invite
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    team_id    BIGINT      NOT NULL,
    player_id  BIGINT      NOT NULL,

    status     VARCHAR(50) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_invite_team
        FOREIGN KEY (team_id)
            REFERENCES team_profile (id)
            ON DELETE CASCADE,

    CONSTRAINT fk_invite_player
        FOREIGN KEY (player_id)
            REFERENCES player_profile (id)
            ON DELETE CASCADE,

    CONSTRAINT uk_team_player UNIQUE (team_id, player_id)
);

-- ==========================================
-- PLAYER SECONDARY POSITIONS
-- ==========================================
CREATE TABLE player_secondary_positions
(
    player_id BIGINT      NOT NULL,
    position  VARCHAR(50) NOT NULL,

    PRIMARY KEY (player_id, position),

    CONSTRAINT fk_secondary_player
        FOREIGN KEY (player_id)
            REFERENCES player_profile (id)
            ON DELETE CASCADE
);

-- ==========================================
-- PLAYER PREFERRED CATEGORIES
-- ==========================================
CREATE TABLE player_preferred_categories
(
    player_id BIGINT      NOT NULL,
    category  VARCHAR(50) NOT NULL,

    PRIMARY KEY (player_id, category),

    CONSTRAINT fk_category_player
        FOREIGN KEY (player_id)
            REFERENCES player_profile (id)
            ON DELETE CASCADE
);

CREATE TABLE player_availability
(
    player_id BIGINT      NOT NULL,
    day       VARCHAR(50) NOT NULL,

    PRIMARY KEY (player_id, day),

    FOREIGN KEY (player_id)
        REFERENCES player_profile (id)
        ON DELETE CASCADE
);

-- ==========================================
-- INDEXES (important for marketplace)
-- ==========================================
CREATE INDEX idx_request_status ON player_request (status);
CREATE INDEX idx_application_request ON application (request_id);
CREATE INDEX idx_application_player ON application (player_id);
CREATE INDEX idx_invite_player ON player_invite (player_id);
CREATE INDEX idx_invite_team ON player_invite (team_id);
