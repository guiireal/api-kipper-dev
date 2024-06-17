CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE events (
    "id" UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title VARCHAR(50) NOT NULL,
    "description" VARCHAR(255) NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    event_url VARCHAR(255) NOT NULL,
    "date" TIMESTAMP NOT NULL,
    is_remote BOOLEAN NOT NULL DEFAULT true
);
